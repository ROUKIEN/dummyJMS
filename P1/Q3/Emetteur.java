import javax.jms.*;
import javax.naming.InitialContext;

class Emetteur {
	public Emetteur() {
		System.out.println("emetteur created");
	}

	public void sendMessage(String m) {
		
		System.out.println("Sending a message...");
		try {
			InitialContext messaging = new InitialContext();
			QueueConnectionFactory connectionFactory = 	(QueueConnectionFactory)
			messaging.lookup("jms/FactoryConnector");
			Queue queue = (Queue) messaging.lookup("jms/DestinationResource");
			QueueConnection connection = connectionFactory.createQueueConnection();
			QueueSession session =
			connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			connection.start();
		
			QueueSender sender = session.createSender(queue);
		
			TextMessage msg = session.createTextMessage();
			msg.setText(m);
			sender.send(msg);
			System.out.println("Done.");
		} catch(Exception e) {
		
			System.out.println("ERROR.");
		}
	}
}
