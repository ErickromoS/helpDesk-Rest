package org.lasalle.services.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.lasalle.services.controller.ControllerUsusario;
import org.lasalle.services.model.Usuario;


/**
 *
 * @author romer
 */
@Path("usuario")
public class RestUsuario {
    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response validar(@FormParam ("user")String user,
                            @FormParam("password") String password){
        ControllerUsusario cu = new ControllerUsusario();
        String out ="";
        try {
            
            Usuario u = cu.validarLista(user, password); 
            if (u == null){
                out = """
                      {"Usuario no encontrado"}
                      """;
                
            }else{
                out = """
                      {"Usuario valido: id: %s "}
                      """;
                out = String.format(out, u.getIdUsuario());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
        
        return Response.ok(out).build();
        
    }
    
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        String out = "";
        List<Usuario> listUsers = null;
        Gson gson = new Gson();
        try {
            ControllerUsusario cu = new ControllerUsusario();
            listUsers = cu.getAll();
            out = gson.toJson(listUsers);
        } catch (Exception e) {
            out = """
                  {"result" : " %s"}
                  """;
            out = String.format(out, e);
        }
        return Response.ok(out).build();
    }
}
