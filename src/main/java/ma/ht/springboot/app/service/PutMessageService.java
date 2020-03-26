package ma.ht.springboot.app.service;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

@Service
public class PutMessageService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String HOST = "localhost"; // Host name or IP address
	private static final int PORT = 1414; // Listener port for your queue manager
	private static final String CHANNEL = "DEV.APP.SVRCON"; // Channel name
	private static final String QMGR = "MQ1"; // Queue manager name
	private static final String APP_USER = ""; // User name that application uses to connect to MQ
	private static final String APP_PASSWORD = ""; // Password that the application uses to connect to MQ
	private static final String QUEUE_NAME = "Q1"; // Queue that the application uses to put and get messages to and from


	
	private  JmsConnectionFactory createJmsFactory() {
		JmsFactoryFactory jmsFactoryFactory=null;
		JmsConnectionFactory jmsConnectionFactory=null;
		try {
			jmsFactoryFactory = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
			jmsConnectionFactory=jmsFactoryFactory.createConnectionFactory();
			jmsConnectionFactory.setStringProperty(WMQConstants.WMQ_HOST_NAME, HOST);
			jmsConnectionFactory.setIntProperty(WMQConstants.WMQ_PORT, PORT);
			jmsConnectionFactory.setStringProperty(WMQConstants.WMQ_CHANNEL, CHANNEL);
			jmsConnectionFactory.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
			jmsConnectionFactory.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, QMGR);
			jmsConnectionFactory.setStringProperty(WMQConstants.WMQ_APPLICATIONNAME, "spring-boot-06-19");
			jmsConnectionFactory.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, true);
			jmsConnectionFactory.setStringProperty(WMQConstants.USERID, APP_USER);
			jmsConnectionFactory.setStringProperty(WMQConstants.PASSWORD, APP_PASSWORD);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jmsConnectionFactory;
	}
	
	public void createJmsObjects() {
		// Create JMS objects
		JMSContext jmsContext=null;
		jmsContext = this.createJmsFactory().createContext();
		Destination destination = jmsContext.createQueue("queue:///" + QUEUE_NAME);

		//Set up the message
		long uniqueNumber = System.currentTimeMillis() % 1000;
		TextMessage message = jmsContext.createTextMessage("Your lucky number today is " + uniqueNumber);
		
		JMSProducer producer;
		producer = jmsContext.createProducer();
		producer.send(destination, message);
		logger.info("Sent Message: {}",message);
		
	}
}
