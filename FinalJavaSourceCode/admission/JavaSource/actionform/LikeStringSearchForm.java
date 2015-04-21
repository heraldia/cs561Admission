package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

public class LikeStringSearchForm extends IdForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	String likeString;

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.likeString = null;
	}
	
	public String getLikeString() {
		return likeString;
	}

	public void setLikeString(String likeString) {
		this.likeString = likeString;
	}
	
}
