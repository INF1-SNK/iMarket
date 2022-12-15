package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import fr.pantheonsorbonne.ufr27.miage.service.StockService;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    @Inject
    StockService StockService;

    @Inject
    ProductService productService;

    @Inject
    CommandGateway commandGateway;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:queue:statutStockStore/" + jmsPrefix)
                .log("statut stock recu - ${body}")
                .unmarshal().json(StoreStockDTO.class)
                .bean(StockService, "verifyStock");

        from("direct:sendCommandToStore")
                .marshal().json()
                .to("jms:queue:sendCommandToStore/"+jmsPrefix);

        from("direct:sendCommandToVendor")
                .marshal().jacksonxml()
                .to("jms:topic:CACommands/"+jmsPrefix);

        from("jms:queue:vendorInfos/"+jmsPrefix+"?exchangePattern=InOut")
                .unmarshal().jacksonxml(ProductDTO.class)
                .log("information ${body}")
                .aggregate(new PriceStrategy()).constant(true)
                .completionTimeout(500L)
                .bean(productService, "createCommand")
                .marshal().jacksonxml()
                .to(ExchangePattern.InOut, "jms:queue:vendorInfos/"+jmsPrefix);

        from("jms:queue:vendorEmit/"+jmsPrefix)
                .unmarshal().json(CommandDTO.class)
                .bean(commandGateway, "updateStocks");
    }

    private class PriceStrategy implements AggregationStrategy {

        @Override
        public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
            ProductDTO newBody = (ProductDTO) newExchange.getIn().getBody();
            ProductDTO productDto = null;
            if (oldExchange == null) {
                newExchange.getIn().setBody(newBody);
                return newExchange;
            } else {
                ProductDTO p = (ProductDTO) oldExchange.getIn().getBody();
                if(p.getPrice()<productDto.getPrice()){
                    return oldExchange;
                }
                oldExchange.getIn().setBody(productDto);
                return oldExchange;
            }
        }

    }
}