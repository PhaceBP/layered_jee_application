package hu.javaee.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import hu.javaee.training.entity.Stock;
import hu.javaee.tranining.entities.StockDTO;

@Stateless
@LocalBean
public class StockDAO {

	@PersistenceContext(name = "STOCKS")
	private EntityManager em;

	public List<StockDTO> getEntities() {
        List<StockDTO> retList = new ArrayList<StockDTO>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Stock> cq = cb.createQuery(Stock.class);
        Root<Stock> rootEntry = cq.from(Stock.class);
        CriteriaQuery<Stock> all = cq.select(rootEntry);
        TypedQuery<Stock> allQuery = em.createQuery(all);
        allQuery.getResultList().forEach(item->{
        	StockDTO dto = new StockDTO();
        	dto.setStockCode(item.getStockCode());
        	dto.setStockId(item.getStockId());
        	dto.setStockName(item.getStockName());
        	retList.add(dto);
        });
        
        return retList;
        
	}
	
	public void save(StockDTO dto){
		Stock stock = new Stock();
		stock.setStockCode(dto.getStockCode());
		stock.setStockName(dto.getStockName());
		em.merge(stock);
	}
 }
