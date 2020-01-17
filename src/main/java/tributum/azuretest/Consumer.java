package tributum.azuretest;

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
		final String storageConnectionString =
			    "DefaultEndpointsProtocol=https;" +
			    "AccountName=queuestoragetributum;" +
			    "AccountKey=3lOqCDk9IXhiUDXthOGeuTDli19EZ32/xkAHF4QX8xNxDxHCxbBKZMnkwvp5GlOtC2iLp6yXXlBMYMjr9zdb0A==";
		
		try {
			CloudStorageAccount storageAccount =
				       CloudStorageAccount.parse(storageConnectionString);
			CloudQueueClient queueClient = storageAccount.createCloudQueueClient();
			CloudQueue inputQueue = queueClient.getQueueReference("${input.queue}");
			CloudQueueMessage inputMsg = inputQueue.retrieveMessage();
			String inputMsgStr = inputMsg.toString(); 
			log.info("<<< LOGGING STARTS HERE >>>");
			log.info("Received Message: -- " + inputMsgStr + " -- ");
			log.info("<<< Message gets processed >>>");
			double bPrice = Double.parseDouble(fileHandler.getDataFromXMLFormat(inputMsgStr, "bPrice"));
			double sPrice = Double.parseDouble(fileHandler.getDataFromXMLFormat(inputMsgStr, "sPrice"));
			int nos = Integer.parseInt(fileHandler.getDataFromXMLFormat(inputMsgStr, "nos"));
			double taxRate = Double.parseDouble(fileHandler.getDataFromXMLFormat(inputMsgStr, "taxRate"));
			double result = tmsgService.taxAmount(bPrice, sPrice, nos, taxRate);
			log.info("Message processed -- Tax amount is: " + String.valueOf(result));
			String strResult = fileHandler.generateXMLFormat(inputMsgStr, result);
			CloudQueueMessage outputMsg = new CloudQueueMessage(strResult);
			CloudQueue outputQueue = queueClient.getQueueReference("${output.queue}");
			outputQueue.addMessage(outputMsg);
			log.info("Message processed to queue ${output.queue}");
			log.info("<<< LOGGING ENDS HERE >>>");
		} catch (Exception e) {
		    log.error(e.toString());
		}
		
		

		
		//String resultXMLString = fileHandler.generateXMLFormat(taxMessage, result);
		//log.info(resultXMLString);
		//return resultXMLString;
	}
	
}
