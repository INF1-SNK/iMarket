package fr.pantheonsorbonne.ufr27.miage.producer;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import fr.pantheonsorbonne.ufr27.miage.service.StoreStockService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.apache.camel.CamelContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class QuantityScheduler implements Runnable {

        //Recuperation grace a CDI d'une fabrique de connexions JMS
        @Inject
        ConnectionFactory connectionFactory;

        @Inject
        StoreStockService storeStockService;

        @Inject
        ProductService productService;

        @Inject
        CamelContext context;


        //Planificateur de tache
        private final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);

        void onStart(@Observes StartupEvent ev) {
            scheduler.scheduleAtFixedRate(this, 0L, 10L, TimeUnit.SECONDS);
        }

        void onStop(@Observes ShutdownEvent ev) {
            scheduler.shutdown();
        }

        @Override
        public void run() {
                System.out.println("moins 3 concombre --");
                storeStockService.quantityScheduler();
        }


}
