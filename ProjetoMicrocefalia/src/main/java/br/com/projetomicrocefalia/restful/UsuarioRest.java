/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.restful;

import br.com.projetomicrocefalia.dao.UsuarioDao;
import br.com.projetomicrocefalia.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gilberto
 */
@Path("usuario")
public class UsuarioRest {

    private UsuarioDao dao = null;

    public UsuarioRest() {
        this.dao = new UsuarioDao();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/criar")
    public Response salvarUsuario(Usuario usuario) {
        try {
            dao = new UsuarioDao();
            usuario = dao.salvar(usuario);
            usuario = dao.exibirUsuario(usuario.getId());            
            return Response.status(Response.Status.OK).entity(usuario).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editar")
    public Response editarUsuario(Usuario usuario) {
        try {
            dao = new UsuarioDao();
            if (dao.validarUsuario(usuario)) {
                dao.editarUsuario(usuario);
                return Response.status(Response.Status.OK).entity(usuario).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/exibir/{id}")
    public Response exibirUsuario(@PathParam("id") int id) {
        try {
            dao = new UsuarioDao();
            Usuario usuario = dao.exibirUsuario(id);
            return Response.status(Response.Status.OK).entity(usuario).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
