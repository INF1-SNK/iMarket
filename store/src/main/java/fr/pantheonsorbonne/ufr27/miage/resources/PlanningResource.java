package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.service.PlanningService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("planning")
public class PlanningResource {

    @Inject
    PlanningService planningService;

    @Path("/latest")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PlanningDTO getLastPlanning(){
        return planningService.getLastPlanning();
    }
    @Path("/{planningId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PlanningDTO getPlanningById(@PathParam("planningId") int planningId) {

        if (planningService.getPlanningById(planningId) == null){
            throw new WebApplicationException(404);
        }
        return planningService.getPlanningById(planningId);
    }

}
