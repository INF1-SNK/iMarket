package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import fr.pantheonsorbonne.ufr27.miage.service.StockService;
import org.apache.camel.CamelContext;

import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    @Inject
    StockService StockService;


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

        /*from("direct:sendCommandToVendor")
                .marshal().jacksonxml()
                .to("jms:topic:CACommands/"+jmsPrefix);

        from("jms:queue:vendorInfos/"+jmsPrefix)
                .unmarshal().jacksonxml()
                .bean();*/
    }
}