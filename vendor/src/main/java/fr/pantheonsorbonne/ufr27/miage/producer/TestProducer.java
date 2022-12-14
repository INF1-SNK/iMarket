package fr.pantheonsorbonne.ufr27.miage.producer;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.apache.camel.CamelContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//Classe:Singleton
//StockProducer implemente l'interface Runnable qui s'execute sous un scheduler
@ApplicationScoped
public class TestProducer implements Runnable {

    @Inject
    CamelContext context;

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
        ProductDTO p = new ProductDTO("toto","meat", 0);
        context.createProducerTemplate().sendBody("direct:testProd", p);
    }
}