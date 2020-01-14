package tributum.azuretest;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import tributum.azuretest.service.TaxMessageService;

@Component
public class Consumer {

private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@Autowired
	private TaxMessageService tmsgService;
	
	@Autowired
	private FileHandler fileHandler;
	
	@JmsListener(destination = "${input.queue}")
	@SendTo("${output.queue}")
	public String receiveMessage(String taxMessage) throws JMSException {
		log.info("Received Message: -- " + taxMessage + " -- ");
		log.info("<< Message gets processed >>");
		double bPrice = Double.parseDouble(fileHandler.getDataFromXMLFormat(taxMessage, "bPrice"));
		double sPrice = Double.parseDouble(fileHandler.getDataFromXMLFormat(taxMessage, "sPrice"));
		int nos = Integer.parseInt(fileHandler.getDataFromXMLFormat(taxMessage, "nos"));
		double taxRate = Double.parseDouble(fileHandler.getDataFromXMLFormat(taxMessage, "taxRate"));
		double result = tmsgService.taxAmount(bPrice, sPrice, nos, taxRate);
		log.info("Message processed -- Tax amount is: " + String.valueOf(result));
		String strResult = fileHandler.generateXMLFormat(taxMessage, result);
		return strResult;
		//String resultXMLString = fileHandler.generateXMLFormat(taxMessage, result);
		//log.info(resultXMLString);
		//return resultXMLString;
	}
	
}
