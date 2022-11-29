package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.PlanningNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.PlanningService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("planning")
public class PlanningResource {

    @Inject
    PlanningService planningService;

    @Path("{planningId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PlanningDTO getPlanning(@PathParam("planningId") int planningId) {
        try {
            return planningService.getPlanningById(planningId);
        }
        catch (PlanningNotFoundException e){
            return null;
        }
    }
}
