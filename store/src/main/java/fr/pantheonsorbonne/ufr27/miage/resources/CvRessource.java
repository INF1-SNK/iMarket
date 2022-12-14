package fr.pantheonsorbonne.ufr27.miage.resources;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.service.CandidatureService;
import fr.pantheonsorbonne.ufr27.miage.service.PlanningService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
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
