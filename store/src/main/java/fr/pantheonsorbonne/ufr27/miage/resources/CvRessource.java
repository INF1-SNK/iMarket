package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.service.CandidatureService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cv")
public class CvRessource {

    @Inject
    CandidatureService candidatureService;

    @Path("accepted")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<CvDTO> sendCv() {
        return (List<CvDTO>) candidatureService.sendCandidatAccepted();
    }


}
