import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Emetteur extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html");
	}
	
	//Envoi du msg
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");

		if(msg.isEmpty() || msg == null)
			response.sendRedirect("index.html");
		else
		{
			PrintWriter printWriter = response.getWriter();
			if (EnvoyerMsg(msg))
				printWriter.println("Msg sent");
			else
				printWriter.println("msg couldnt be sent");
		}
	}

	//Méthode permettant d'envoyer un message
	public boolean EnvoyerMsg(String text) {

		try {
			Context c = new InitialContext();
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory)c.lookup("jms/FactoryConnector");
			Queue queue = (Queue)c.lookup("jms/DestinationResource");
			QueueConnection connection = connectionFactory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			connection.start();
			QueueSender sender =session.createSender(queue);
			TextMessage msg = session.createTextMessage();
			msg.setText(text);
			msg.setStringProperty("Destinataire","Robert");
			sender.send(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	return false;
	}
}
