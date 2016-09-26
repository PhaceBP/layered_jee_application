package hu.javaee.training.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import hu.javaee.training.dao.StockDAO;
import hu.javaee.tranining.entities.StockDTO;

@Stateless
public class StockServiceBean {

	@Inject
	private StockDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<StockDTO> getStocks() {
		return dao.getEntities();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void saveStock(StockDTO dto) {
		dao.save(dto);
	}
}
