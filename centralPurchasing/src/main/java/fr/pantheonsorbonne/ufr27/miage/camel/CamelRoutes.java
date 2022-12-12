package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.service.StockService;
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

    @Inject
    StockService StockService;


    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);


        from("jms:queue/statutStockStore")
                .log("statut stock recu - ${body}")
                .unmarshal().json()
                .bean(StockService, "verifyStock")  //verifier si la quantite est ok
                .log("statut stock bon - ${body} ");
                //.to("jms:queue/StockIsGood");
    }
}