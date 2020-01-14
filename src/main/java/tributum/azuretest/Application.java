package tributum.azuretest;

import javax.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class Application implements ApplicationRunner {

	@Value("${input.queue}")
	private String inputQueue;
	
	@Value("${output.queue}")
	private String outputQueue;
	
	@Autowired
	private JmsTemplate template;
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*try {
			String txmsg = "<xml><txId>50214235</txId><bPrice>100</bPrice><sPrice>120</sPrice><nos>20</nos><taxRate>25</taxRate></xml>";
			template.convertAndSend(inputQueue, txmsg);
			
			template.setReceiveTimeout(1000);
			
			Message m = template.receive(outputQueue);
			log.info(m.toString());
			log.info("Published " + ((ActiveMQTextMessage) m).getText() + " to output " + m.getJMSDestination());
		} catch(Exception e) {
			log.error(e.toString());
		}*/
	}
	
}
