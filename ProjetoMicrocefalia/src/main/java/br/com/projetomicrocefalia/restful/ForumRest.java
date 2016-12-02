/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.restful;

import br.com.projetomicrocefalia.dao.CategoriaDao;
import br.com.projetomicrocefalia.model.CategoriaRest;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gilberto
 */
@Path("forum")
public class ForumRest {

    private CategoriaDao dao = null;

    public ForumRest() {
        this.dao = new CategoriaDao();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/categoria")
    public Response salvarUsuario() {
        dao = new CategoriaDao();
        List<CategoriaRest> lista;
        try {
            lista = dao.listCatetoriaRest();
            return Response.status(Response.Status.OK).entity(lista).build();
        } catch (SQLException ex) {
            Logger.getLogger(ForumRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}
