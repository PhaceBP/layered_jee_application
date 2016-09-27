package hu.javaee.training.web;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import hu.javaee.training.service.StockServiceBean;
import hu.javaee.tranining.entities.StockDTO;

@Path("/stocks")
@ApplicationScoped
public class StockRestService {

	@Inject
	private StockServiceBean stockService;

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StockDTO> getAllStock() {

		return stockService.getStocks();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveStock(StockDTO dto) {
		stockService.saveStock(dto);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
}
