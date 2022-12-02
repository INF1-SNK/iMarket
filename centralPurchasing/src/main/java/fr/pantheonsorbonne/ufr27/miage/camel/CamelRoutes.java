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

<<<<<<< HEAD
        from("jms:queue/statutStockStore")
                .unmarshal()
                .csv()
                .log("statut stock recu ${body}");
=======
        from("direct:statutStockStore" + jmsPrefix + "in")
                .unmarshal().csv().log("statut stock envoyee ${body}");
>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2

    }
}
