import javax.jms.*;
import javax.naming.InitialContext;

class Emetteur {
	public Emetteur() {
		System.out.println("emetteur created");
	}

	public void sendMessage(String m, String receiver) {
		
		System.out.println("Sending a message (to "+receiver+")...");
		try {
			InitialContext messaging = new InitialContext();
			QueueConnectionFactory connectionFactory = 	(QueueConnectionFactory)
			messaging.lookup("jms/FactoryConnector");
			Queue queue = (Queue) messaging.lookup("jms/DestinationResource");
			QueueConnection connection = connectionFactory.createQueueConnection();
			QueueSession session =
			connection.createQueueSession(false,Session.CLIENT_ACKNOWLEDGE);
			connection.start();
		
			QueueSender sender = session.createSender(queue);
		
			TextMessage msg = session.createTextMessage();
			msg.setText(m);
			msg.setStringProperty("receiver", receiver);
			
			sender.send(msg);
			System.out.println("Done.");
		} catch(Exception e) {
		
			System.out.println("ERROR.");
		}
	}
}
