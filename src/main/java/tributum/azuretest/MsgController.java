/*package tributum.azuretest;

import javax.jms.Message;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
	
	@Value("${input.queue}")
	private String inputQueue;
	
	@Value("${output.queue}")
	private String outputQueue;
	
	@Autowired
	private JmsTemplate template;
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	/*@RequestMapping(value = "/", produces = {"application/JSON"})
	public String index(@RequestParam(value = "txmsg", required = false) String taxMessage) throws Exception {
		if(taxMessage != null) {
			try {
				
				
				/*template.convertAndSend(inputQueue, taxMessage);
				
				template.setReceiveTimeout(1000);
				
				Message m = template.receive(outputQueue);
				log.info(m.toString());
				String result = "Published '" + ((ActiveMQTextMessage) m).getText() + "' successfully to output '" + m.getJMSDestination() + "'";
				log.info(result);
				
				return result;
			} catch(Exception e) {
				log.error(e.toString());
				return "Message could not be processed due to an exception. Please view console for more information.";
			}
			
		} else {
			return "Please enter an XML Tax Message to get the tax amount calculated.";
		}
		
	}
	
}
*/