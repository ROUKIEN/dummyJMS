import javax.jms.*;
import javax.naming.InitialContext;

class Emetteur {

	public Emetteur() {
		System.out.println("emetteur created");
	}

	public void sendMessage(String m, String receiver, String correlationID) {
		
		System.out.println("Sending a message (to "+receiver+")...");
		try {
			InitialContext messaging = new InitialContext();
			QueueConnectionFactory connectionFactory = 	(QueueConnectionFactory)
			messaging.lookup("jms/FactoryConnector");
			Queue queue = (Queue) messaging.lookup("jms/DestinationResource");
			QueueConnection connection = connectionFactory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,Session.CLIENT_ACKNOWLEDGE);

			connection.start();
		
			QueueSender sender = session.createSender(queue);
			Queue tmpQueue = session.createTemporaryQueue();
			QueueReceiver receiiver = session.createReceiver(tmpQueue);
			
			TextMessage msg = session.createTextMessage();
			msg.setText(m);
			msg.setJMSReplyTo(tmpQueue);
			msg.setJMSCorrelationID(correlationID);
			
			System.out.println(msg.getText());
			System.out.println("En attente de réponse du Recepteur...");
			
			sender.send(msg);

			TextMessage response_msg = (TextMessage) receiiver.receive();
			
			System.out.println("Done.");
		} catch(Exception e) {
		
			System.out.println("ERROR EMETTEUR : " +e.getMessage());
		}
	}
}
