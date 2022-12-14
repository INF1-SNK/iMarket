package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.CommandException;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
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
    CommandGateway commandHandler;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);
        onException(CommandException.class)
                .handled(true)
                .setHeader("success", simple("false"))
                .setBody(simple("there was an error during the treatment. Please try again"));

        from("direct:testProd").marshal().jacksonxml().to("jms:topic:CACommands/"+jmsPrefix);

        from("jms:topic:CACommands/"+jmsPrefix)
                .log("commande - ${body}")
                .unmarshal().jacksonxml(ProductDTO.class)
                .bean(commandHandler, "sendProductInfos")
                .marshal().jacksonxml()
                .to(ExchangePattern.InOut, "jms:queue:vendorInfos/"+jmsPrefix);



        from("jms:queue:CAToVendorCommand/"+jmsPrefix)
                .unmarshal().jacksonxml(CommandDTO.class)
                .bean(commandHandler, "sendCommand")
                .marshal().json()
                .to("jms:queue:vendorEmit/"+jmsPrefix);
    }
}