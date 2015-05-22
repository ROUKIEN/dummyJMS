import javax.ejb.Local;
import javax.jms.TextMessage;

@Local
public interface IMsgTraitable {

	public void msgProceed(TextMessage text);
}
