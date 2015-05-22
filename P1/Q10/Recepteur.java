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
				
				InitialContext ctx = new InitialContext();
				IMsgTraitableBean tm = (IMsgTraitableBean) ctx.lookup("java:global/Q10/IMsgTraitableBean!msgProceed");
				tm.msgProceed(text);
				
				System.out.println("MSG = "+text.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
