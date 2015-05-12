import javax.jms.*;
import javax.naming.InitialContext;

class Recepteur {
	public Recepteur() {
		System.out.println("Recepteur created");
	}

	public void receiveMessage() {

		try {
			InitialContext messaging = new InitialContext();
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory) messaging.lookup("jms/FactoryConnector");
			Queue queue = (Queue) messaging.lookup("jms/DestinationResource");
			QueueConnection connection = connectionFactory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			connection.start();
		
			//QueueReceiver receiver = session.createReceiver(queue, selector);
			QueueReceiver receiver = session.createReceiver(queue);
		
			TextMessage msg = (TextMessage) receiver.receive();
		
			System.out.println(msg.getText());
		} catch(Exception e) {
		
			System.out.println("ERROR");
		}
	}
}
