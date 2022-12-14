package fr.pantheonsorbonne.ufr27.miage.producer;

import fr.pantheonsorbonne.ufr27.miage.camel.StoreStockGateway;
import fr.pantheonsorbonne.ufr27.miage.service.StoreStockService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.beans.factory.annotation.Value;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.*;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//Classe:Singleton
//StockProducer implemente l'interface Runnable qui s'execute sous un scheduler
@ApplicationScoped
public class StockProducer implements Runnable {

    //Recuperation grace a CDI d'une fabrique de connexions JMS
    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    StoreStockService storeStockService;

    @Inject
    CamelContext context;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.storeId")
    Integer storeId;


    //Planificateur de tache
    private final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);

    void onStart(@Observes StartupEvent ev) {
        scheduler.scheduleAtFixedRate(this, 0L, 30L, TimeUnit.SECONDS);
    }

    void onStop(@Observes ShutdownEvent ev) {
        scheduler.shutdown();
    }

    //Envoie du stock du magasin vers la queue "direct:statut"
    @Override
    public void run() {
        context.createProducerTemplate().sendBody("direct:statut",storeStockService.getStockFromProductByID(storeId));
    }
}