/*package tributum.azuretest;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.queue.CloudQueueMessage;

import tributum.azuretest.service.TaxMessageService;

@Component
public class Consumer {

private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@Autowired
	private TaxMessageService tmsgService;
	
	@Autowired
	private FileHandler fileHandler;
	
	public void receiveMessage() throws JMSException {
		
		
		

		
		//String resultXMLString = fileHandler.generateXMLFormat(taxMessage, result);
		//log.info(resultXMLString);
		//return resultXMLString;
	}
	
}*/
