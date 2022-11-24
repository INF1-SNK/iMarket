package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Cv;
import fr.pantheonsorbonne.ufr27.miage.service.CandidatureService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/vendor")
public class candidatureRessources {

    @Inject
    protected CandidatureService service;


    @Path("candidature/")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<CvDTO> getCv() {
        return service.getCandidatures();
    }
}