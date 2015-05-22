import javax.jms.*;

public class JMessage implements MessageListener {

	@Override
	public void onMessage(Message message)
	{
		try	{
			if(message instanceof TextMessage) {
				TextMessage tmsg = (TextMessage)message;
				System.out.println(message);
			}
			else System.out.println("No text in msg");
			
		} catch(Exception e) {
				System.err.println(e);
		}
	}
}
