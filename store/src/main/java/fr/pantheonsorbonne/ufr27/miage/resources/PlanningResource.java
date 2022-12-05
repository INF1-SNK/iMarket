package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.PlanningNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.PlanningService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("planning")
public class PlanningResource {

    @Inject
    PlanningService planningService;

    @Path("show")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PlanningDTO getLastPlanning(){
        return planningService.getLastPlanning();
    }
    @Path("show/{planningId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PlanningDTO getPlanningById(@PathParam("planningId") int planningId) {

        if (planningService.getPlanningById(planningId) == null){
            throw new NotFoundException();
        }
        return planningService.getPlanningById(planningId);
    }

}
