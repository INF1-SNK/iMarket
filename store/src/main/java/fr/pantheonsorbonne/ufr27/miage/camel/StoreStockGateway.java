package fr.pantheonsorbonne.ufr27.miage.camel;


<<<<<<< HEAD
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
=======
import fr.pantheonsorbonne.ufr27.miage.model.StoreStock;
>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
<<<<<<< HEAD
import javax.jms.Message;
=======
>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2
import java.io.IOException;

@ApplicationScoped
public class StoreStockGateway {

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

<<<<<<< HEAD
    @Inject
    CamelContext camelContext;


    public void sendStockStatus(StoreStockDTO storeStockDTO) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:statut", storeStockDTO.getProducts());
=======
        @Inject
        CamelContext camelContext;

    public void SendStore(StoreStock StatusStock) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBodyAndHeader("direct:statutStockStore");
>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}