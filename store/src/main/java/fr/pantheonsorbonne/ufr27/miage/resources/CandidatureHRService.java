package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/candidatureRessources")
@RegisterRestClient(configKey = "HR")
public interface CandidatureHRService {

    @Path("show")
    @GET
    List<CvDTO> getCv();
}
