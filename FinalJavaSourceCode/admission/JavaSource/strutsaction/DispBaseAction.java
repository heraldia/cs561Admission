package strutsaction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/*
 * Base action extends DispatchAction 
 */
public class DispBaseAction extends DispatchAction {

	public void addMessage(HttpServletRequest request, String key,
			String[] values)
	{

		ActionMessages messages = (ActionMessages) request
				.getAttribute(Globals.ERROR_KEY);
		if (messages == null)
			messages = new ActionMessages();


		if (values != null && values.length > 0)
			messages.add(Globals.ERROR_KEY, new ActionMessage(key, values));
		else
			messages.add(Globals.ERROR_KEY, new ActionMessage(key));
		

		request.setAttribute(Globals.ERROR_KEY, messages);
	}


	public void addMessage(HttpServletRequest request, String key)
	{
		addMessage(request, key, null);
	}
	
}
