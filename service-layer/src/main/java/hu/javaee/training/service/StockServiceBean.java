package hu.javaee.training.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.JMSSessionMode;
import javax.jms.Queue;

import hu.javaee.training.dao.StockDAO;
import hu.javaee.tranining.entities.StockDTO;

@Interceptors(value = {LoggerInterceptor.class} )
@Stateless
public class StockServiceBean {

	@Inject
	private StockDAO dao;

	@Resource(mappedName = "jms/testQueue")
	private Queue destination;

	@Inject
	@JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
	@JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
	private JMSContext jmsContext;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<StockDTO> getStocks() {
		List<StockDTO> retList = dao.getEntities();
		sendJMSMessageToMyQueue("Stocks queried, list size: " + retList.size());
		return retList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void saveStock(StockDTO dto) {
		dao.save(dto);
		sendJMSMessageToMyQueue("Stock created with name : " + dto.getStockName());
	}

	private void sendJMSMessageToMyQueue(String message) {
		try {
			jmsContext.createProducer().send(destination, message);
		} catch (JMSRuntimeException t) {
			System.out.println(t.toString());
		}
	}
}
