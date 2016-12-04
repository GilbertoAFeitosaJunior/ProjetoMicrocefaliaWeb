/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.restful;

import br.com.projetomicrocefalia.dao.CategoriaDao;
import br.com.projetomicrocefalia.dao.MensagemDao;
import br.com.projetomicrocefalia.dao.TopicoDao;
import br.com.projetomicrocefalia.model.CategoriaRest;
import br.com.projetomicrocefalia.model.MensagemOutRest;
import br.com.projetomicrocefalia.model.MensagemRest;
import br.com.projetomicrocefalia.model.TopicoRest;
import br.com.projetomicrocefalia.model.TopicosRest;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gilberto
 */
@Path("forum")
public class ForumRest {

    private CategoriaDao categoriaDao = null;
    private TopicoDao topicoDao = null;
    private MensagemDao mensagemDao = null;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/categoria")
    public Response salvarUsuario() {
        categoriaDao = new CategoriaDao();
        List<CategoriaRest> lista;
        try {
            lista = categoriaDao.listCatetoriaRest();
            return Response.status(Response.Status.OK).entity(lista).build();
        } catch (SQLException ex) {
            Logger.getLogger(ForumRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/topico")
    public Response criarTopico(TopicoRest topicoRest) {
        topicoDao = new TopicoDao();
        try {
            topicoDao.criarTopico(topicoRest);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException ex) {
            Logger.getLogger(ForumRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/topicos/{id}")
    public Response topicos(@PathParam("id") int id) {
        topicoDao = new TopicoDao();
        List<TopicosRest> lista;
        try {
            lista = topicoDao.listarTopicos(id);
            return Response.status(Response.Status.OK).entity(lista).build();
        } catch (SQLException ex) {
            Logger.getLogger(ForumRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mensagem")
    public Response criarMensagem(MensagemRest mensagemRest) {
        mensagemDao = new MensagemDao();
        try {
            mensagemDao.salvarMensagem(mensagemRest);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException ex) {
            Logger.getLogger(ForumRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mensagem/{id}")
    public Response listarMensagem(@PathParam("id") int id) {
        mensagemDao = new MensagemDao();
        List<MensagemOutRest> lista;
        try {
            lista = mensagemDao.listarMensagem(id);
            return Response.status(Response.Status.OK).entity(lista).build();
        } catch (SQLException ex) {
            Logger.getLogger(ForumRest.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
