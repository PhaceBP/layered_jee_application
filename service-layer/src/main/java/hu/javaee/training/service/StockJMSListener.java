package hu.javaee.training.service;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/testQueue", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class StockJMSListener implements MessageListener {

	@Resource
	private MessageDrivenContext mdc;

	@Override
	public void onMessage(Message message) {

		try {
			if (message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;
				System.out.println("MESSAGE BEAN: Message received: " + msg.getText());
			} else {
				System.out.println("Message of wrong type: " + message.getClass().getName());
			}
		} catch (JMSException e) {
			e.printStackTrace();
			mdc.setRollbackOnly();
		} catch (Throwable te) {
			te.printStackTrace();
		}

	}

}
