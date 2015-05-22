import javax.jms.*;
import javax.ejb.*;
import javax.naming.InitialContext;

@MessageDriven(
	mappedName="jms/DestinationResource", activationConfig = {
		@ActivationConfigProperty(propertyName = "messageSelector",	propertyValue = "name='Robert'")
	}
)
class Recepteur implements MessageListener {

	public Recepteur() {
	
		System.out.println("Recepteur created");
	}

	/* Implémentation de l'event onMessage */
	public void onMessage(Message m) {
		try {
			if(m instanceof TextMessage) {
				TextMessage p = (TextMessage)m;
				System.out.println("got :"+ p.getText());
			}
		} catch(JMSException JMSe) {
			JMSe.printStackTrace();
		}
	}
}
