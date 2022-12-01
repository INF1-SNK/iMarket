package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("planning")
@RegisterRestClient(configKey = "initial-store")
public interface PlanningService {


    @Path("show")
    @GET
    PlanningDTO getLastPlanning();

    @Path("show/{planningId}")
    @GET
    PlanningDTO getPlanningById(@PathParam("planningId") int planningId);
}
