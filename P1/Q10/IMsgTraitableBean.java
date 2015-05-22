import javax.ejb.Stateless;
import javax.jms.TextMessage;
import javax.annotation.*;

@Stateless
public class IMsgTraitableBean implements IMsgTraitable {

	@Override
	public void msgProceed(TextMessage msg)
	{
		try {
			System.out.println("proceeding msg '" + msg.getText() +"'...");
			
		} catch(Exception e) {
			System.out.println("Error : " +e.getMessage());
		}
	}
}
