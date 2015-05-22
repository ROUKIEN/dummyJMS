import javax.jms.*;
import javax.naming.InitialContext;

class Recepteur {
	
	protected long timer;
	protected String receiverName;
	
	public Recepteur(long t, String rn) {
	
		this.timer = t;
		this.receiverName = rn;
		System.out.println("Recepteur created with timer "+ this.timer +" for receiver "+this.receiverName);
	}

	public String getReceiverName() {

		return this.receiverName;
	}
	
	public void setReceiverName(String rn) {

		this.receiverName = rn;
	}

	public long getTimer() {

		return this.timer;
	}
	
	public void setTimer(long v) {

		this.timer = v;	
	}

	public void receiveMessage() {

		try {
			InitialContext messaging = new InitialContext();
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory) messaging.lookup("jms/FactoryConnector");
			Queue queue = (Queue) messaging.lookup("jms/DestinationResource");
			QueueConnection connection = connectionFactory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			connection.start();
			
			String selector = "receiver='"+this.receiverName+"'";
			QueueReceiver receiver = session.createReceiver(queue, selector);
		
			TextMessage msg = (TextMessage) receiver.receive();

			System.out.println(msg.getText());
			msg.acknowledge(); //on informe explicitement au middleware qu'on a reçu le message
			connection.close();
			
		} catch(Exception e) {
		
			System.out.println("ERROR");
		}
	}
}
