package hu.javaee.training.web;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hu.javaee.training.service.StockServiceBean;
import hu.javaee.tranining.entities.StockDTO;

@Path("/stocks")
@ApplicationScoped
public class StockRestService {

	
	@Inject
	private StockServiceBean stockService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StockDTO> getAllStock(){
		
		return stockService.getStocks();
	}
}
