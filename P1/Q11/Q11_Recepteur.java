import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;

public class Q11_Recepteur {

	public static void main(String[] args) {
		
		try {
			Context c = new InitialContext();
			TopicConnectionFactory connectionFactory = (TopicConnectionFactory) c.lookup("jms/FactoryConnector");
			Topic topic = (Topic)c.lookup("jms/DestinationResource");
			TopicConnection connection = connectionFactory.createTopicConnection();
			TopicSession session = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
			connection.start();
			
			TopicSubscriber subscriber = session.createSubscriber(topic);
			subscriber.setMessageListener(new JMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
