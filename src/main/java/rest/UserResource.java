package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.UserDTO;
import entities.User;
import facades.UserFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("user")
public class UserResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade FACADE =  UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll(){
    return Response.ok().entity(GSON.toJson(FACADE.getAll())).build();
}

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUser(@PathParam("id") int id){
        return Response.ok().entity(GSON.toJson(FACADE.getUserById(id))).build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String user) {
        UserDTO userDTO =GSON.fromJson(user, UserDTO.class);
        UserDTO newUserDTO = FACADE.create(userDTO);
        return Response.ok().entity(GSON.toJson(newUserDTO)).build();
    }
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") int id, String content) throws EntityNotFoundException {
        User userJson = GSON.fromJson(content, User.class);
        userJson.setId(id);
        User updated = FACADE.update(userJson);
        return Response.ok().entity(GSON.toJson(updated)).build();
    }
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") int id) throws EntityNotFoundException {
        User deleted = FACADE.delete(id);
        return Response.ok().entity(GSON.toJson(deleted)).build();
    }
}

