package fr.pantheonsorbonne.ufr27.miage.camel;


import org.apache.camel.CamelContext;
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


    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);


        from("direct:statut")
                .marshal().json()
                .log("statut stock emis - ${body}")
                .to("jms:queue/statutStockStore");
    }
}