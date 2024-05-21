/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.rest;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.lasalle.services.controller.ControllerCategoria;
import org.lasalle.services.model.Categoria;

/**
 *
 * @author angel
 */
@Path("categoria")
public class RestCategoria {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("saludar")
    public Response saludar(){
        String out = """
                     {"response":"Hola"}
                     """;
        return Response.ok(out).build();
    }
    
    //DEclarar el servicio para saveCategoria
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(@FormParam("categoria")String c,
                         @FormParam("departamento") String d,
                         @FormParam("responsable") int r){
        String out = "";
        try {
            ControllerCategoria cc = new ControllerCategoria();
            cc.saveCategoria(new Categoria(0,c,d,r));
            out = """
                  {"response":"Registro realizado"}
                  """;
        } catch (Exception e) {
            out=  """
                  {"response":"Error al registrar"}
                  """;
        }
        return Response.ok(out).build();
                
    }
    
}
