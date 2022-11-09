package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.UserDTO;
import entities.User;
import facades.UserFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("user")
public class UserResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade FACADE =  UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll(){
    return Response.ok().entity(GSON.toJson(FACADE.getAll())).build();
}

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String user) {
        UserDTO userDTO =GSON.fromJson(user, UserDTO.class);
        UserDTO newUserDTO = FACADE.create(userDTO);
        return Response.ok().entity(GSON.toJson(newUserDTO)).build();
    }
}

