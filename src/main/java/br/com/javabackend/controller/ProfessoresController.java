package br.com.javabackend.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.javabackend.dao.ProfessoresDAO;
import br.com.javabackend.model.Professores;

@Path("professores")
public class ProfessoresController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Professores> listProfessores() {
		try {
			ProfessoresDAO professoresDAO = new ProfessoresDAO();
			return professoresDAO.listar();

		} catch (Exception ex) {
			Logger.getLogger(ProfessoresController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Professores getProfessores(@PathParam("id") long id) {
		try {
			ProfessoresDAO professoresDAO = new ProfessoresDAO();
			return professoresDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(ProfessoresController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Professores professor) {
		try {
			ProfessoresDAO professoresDAO = new ProfessoresDAO();
			professoresDAO.inserir(professor);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ProfessoresController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Professores professor) {
		try {

			ProfessoresDAO professoresDAO = new ProfessoresDAO();
			professoresDAO.alterar(professor);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ProfessoresController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id) {
		try {
			ProfessoresDAO professoresDAO = new ProfessoresDAO();
			professoresDAO.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ProfessoresController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") long id) {
		try {
			ProfessoresDAO professoresDAO = new ProfessoresDAO();

			Professores c = professoresDAO.selecionar(id);

			professoresDAO.alterar(c);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ProfessoresController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
