package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.service.CandidatureService;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/candidatureRessources")
@RegisterRestClient(configKey = "HR")
public interface CandidatureRessource {

    @Path("show")
    @GET
    List<CvDTO> getCv();
}
