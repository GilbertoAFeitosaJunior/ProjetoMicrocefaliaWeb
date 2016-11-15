/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.restful;

import br.com.projetomicrocefalia.dao.NoticiaDao;
import br.com.projetomicrocefalia.model.ChamadaNoticia;
import br.com.projetomicrocefalia.model.Pesquisa;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

}
