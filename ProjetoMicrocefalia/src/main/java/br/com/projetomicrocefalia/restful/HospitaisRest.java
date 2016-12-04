/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.restful;

import br.com.projetomicrocefalia.dao.HospitaisDao;
import br.com.projetomicrocefalia.model.Estados;
import br.com.projetomicrocefalia.model.Hospitais;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gilberto
 */
@Path("hospital")
public class HospitaisRest {

    private HospitaisDao hospitaisDao = null;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/estados")
    public Response estados() {
        try {
            List<Estados> lista = new ArrayList<>();
            hospitaisDao = new HospitaisDao();
            lista = hospitaisDao.estadosRest();
            return Response.status(Response.Status.OK).entity(lista).build();
        } catch (SQLException ex) {
            Logger.getLogger(HospitaisRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
     @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hospitais/{id}")
    public Response hospitais(@PathParam ("id") int id) {
        try {
            List<Hospitais> lista = new ArrayList<>();
            hospitaisDao = new HospitaisDao();
            lista = hospitaisDao.hospitaisRest(id);
            return Response.status(Response.Status.OK).entity(lista).build();
        } catch (SQLException ex) {
            Logger.getLogger(HospitaisRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
