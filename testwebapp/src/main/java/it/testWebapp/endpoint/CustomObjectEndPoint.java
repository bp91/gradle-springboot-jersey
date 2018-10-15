package it.testWebapp.endpoint;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.testWebapp.model.CustomObject;
import it.testWebapp.service.CustomObjectService;

@Component
@Path("/customobjects")
public class CustomObjectEndPoint {
	
	@Autowired
	private CustomObjectService customObjectService;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomObject> getCustomObjects() {
        
        return customObjectService.getCustomObjects();
    }
    
    @Path("/customObject")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomObject getUser(
            @NotNull @QueryParam("id") int id) {
        
        return customObjectService.getCustomObject(id);
        
    }
	
}
