package fr.pantheonsorbonne.ufr27.miage.producer;

import fr.pantheonsorbonne.ufr27.miage.camel.StoreStockGateway;
import fr.pantheonsorbonne.ufr27.miage.service.StoreStockService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.*;
import javax.resource.spi.ConfigProperty;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//cette classe est un singleton
//elle implémente l'interface Runnable qui spécifie qu'elle peut être exécutée par un scheduler
@ApplicationScoped
public class StockProducer implements Runnable {

    //nous récupérons à l'aide de CDI une fabrique de connexions JMS
    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    StoreStockService storeStockService;

    @Inject
    CamelContext context;

    //planificateur d'exécution de tache
    private final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);

    void onStart(@Observes StartupEvent ev) {
        scheduler.scheduleAtFixedRate(this, 0L, 5L, TimeUnit.SECONDS);
    }

    void onStop(@Observes ShutdownEvent ev) {
        scheduler.shutdown();
    }

    @Override
    public void run() {
        context.createProducerTemplate().sendBody("direct:statut",storeStockService.getStockFromProductByID(1).getProducts());
    }
}