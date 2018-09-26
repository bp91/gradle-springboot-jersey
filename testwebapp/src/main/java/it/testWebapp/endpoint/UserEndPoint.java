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
import it.testWebapp.model.User;
import it.testWebapp.service.UserService;

@Component
@Path("/users")
public class UserEndPoint {
    
    @Autowired
    private UserService userService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        
        return userService.getUsers();
    }
    
    @Path("/user")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(
            @NotNull @QueryParam("id") int id) {
        
        return userService.getUser(id);
        
    }

}
