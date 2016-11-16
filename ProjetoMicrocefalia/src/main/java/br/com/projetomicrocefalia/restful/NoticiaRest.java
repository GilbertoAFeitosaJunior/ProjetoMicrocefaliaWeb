/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.restful;

import br.com.projetomicrocefalia.dao.NoticiaDao;
import br.com.projetomicrocefalia.model.ChamadaNoticia;
import br.com.projetomicrocefalia.model.CurtidasUsuario;
import br.com.projetomicrocefalia.model.CurtirTemp;
import br.com.projetomicrocefalia.model.Noticia;
import br.com.projetomicrocefalia.model.Pesquisa;
import java.util.List;
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
@Path("noticia")
public class NoticiaRest {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/chamada")
    public Response exibirChamdasNoticia(Pesquisa pesquisa) {
        NoticiaDao dao = new NoticiaDao();
        List<ChamadaNoticia> chamdas = dao.chamadasNoticias(pesquisa);
        return Response.status(Response.Status.OK).entity(chamdas).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/exibir/{id}")
    public Response exibirChamdasNoticia(@PathParam("id") int id) {
        NoticiaDao dao = new NoticiaDao();
        Noticia noticia = dao.exibirNoticiaAndroid(id);
        return Response.status(Response.Status.OK).entity(noticia).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/curtir")
    public Response curtir(CurtirTemp curtirTemp) {
        NoticiaDao dao = new NoticiaDao();
        dao.curtir(curtirTemp);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/discurtir")
    public Response discurtir(CurtirTemp curtirTemp) {
        NoticiaDao dao = new NoticiaDao();
        boolean retorno = dao.discurtir(curtirTemp);
        if (retorno) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/curtidas")
    public Response curtidas(CurtirTemp curtirTemp) {
        NoticiaDao dao = new NoticiaDao();
        List<CurtidasUsuario> lista = dao.listaCurtir(curtirTemp);
        if (!lista.isEmpty()) {
            return Response.status(Response.Status.OK).entity(lista).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
