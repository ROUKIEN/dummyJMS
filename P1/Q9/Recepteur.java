import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;
import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;

@MessageDriven(mappedName="jms/DestinationResource", activationConfig = 
	{
		@ActivationConfigProperty(
			propertyName = "Destinataire",
			propertyValue = "Destinataire = 'Robert'")
	}
)
public class Recepteur implements MessageListener {
	
	@Override
	public void onMessage(Message msg) {
		
		try	{
			if(msg instanceof TextMessage) {
				TextMessage text = (TextMessage)msg;
				System.out.println(text.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
