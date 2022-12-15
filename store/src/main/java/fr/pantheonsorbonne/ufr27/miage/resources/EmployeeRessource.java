package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.service.EmployeeServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("employee")
public class EmployeeRessource {

    @Inject
    EmployeeServiceImpl employeeService;


    @POST
    @Path("/added")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createEmploye(){
        if(employeeService.createEmployee()) {
            return Response.created(URI.create("employees/created")).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error : employees not inserted").build(); //TODO: change the response to negative
    }
}
