package servletsession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import servletsession.UserInfo;
import model.Applicant;
import model.StudentAccount;
import model.User;

public class AuthorityUtil {

	public static final String SESSION_USERINFO = "authority.userinfo";
	public static final String SESSION_STUDENTINFO = "authority.studentinfo";
	public static final String SESSION_APPLICANTINFO = "authority.applicantinfo";
	public static final String SESSION_EVALUATIONINFO = "authority.evaluationinfo";
	
	/**
	 *  set user's id, category, uid, username into session.
	 * @return void
	 */
	public static void saveUser( HttpServletRequest request, User user ) {
		
		if( user==null ) return;
		
		UserInfo ui = getUser( request );
		
		if( ui==null ) ui = new UserInfo();
		
		ui.setUserId( user.getId() );
		ui.setCategory(user.getCategory());
		ui.setUid(user.getUid());
		ui.setUsername(user.getUsername());
		saveUser( request, ui );
	}
	
	
	/**
	 *  set user's information into SESSION_USERINFO.
	 * @return void
	 */
	public static void saveUser( HttpServletRequest request, UserInfo user ) {
		HttpSession session = request.getSession();
		session.setAttribute( SESSION_USERINFO, user );
	}
	
	/**
	 *  get user's information from SESSION_USERINFO.
	 * @return userinfo
	 */
	public static UserInfo getUser( HttpServletRequest request ) {
		HttpSession session = request.getSession();
		return (UserInfo)session.getAttribute( SESSION_USERINFO );
	}
	
	/**
	 *  remove and clear userinfo from session.
	 * @return void
	 */
	 public static void removeUser( HttpServletRequest request ) {
	        HttpSession session = request.getSession();
	        session.removeAttribute(SESSION_USERINFO);
	        session.invalidate();

}
	 
	 public static void saveStudentAccount( HttpServletRequest request, StudentAccount st ) {
			
			if( st==null ) return;
			
			StudentInfo ui = getStudentAccount( request );
			
			if( ui==null ) ui = new StudentInfo();
			
			ui.setStudentId( st.getId() );
			ui.setUsername(st.getUsername());
			saveStudentAccount( request, ui );
		}
		
		public static void saveStudentAccount( HttpServletRequest request, StudentInfo s ) {
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_STUDENTINFO, s );
		}
		
		public static StudentInfo getStudentAccount( HttpServletRequest request ) {
			HttpSession session = request.getSession();
			return (StudentInfo)session.getAttribute( SESSION_STUDENTINFO );
		}
		
		 public static void removeStudentAccount( HttpServletRequest request ) {
		        HttpSession session = request.getSession();
		        session.removeAttribute(SESSION_STUDENTINFO);
		        session.invalidate();

	}

		public static void saveApplicant(HttpServletRequest request, Applicant st) {
			if( st==null ) return;
			
			ApplicantInfo ui = getApplicant( request );
			
			if( ui==null ) ui = new ApplicantInfo();
			
			ui.setAppl_Id( st.getId() );
			ui.setApplicantid(st.getApplicantId());
			ui.setEmail(st.getEmail());
			ui.setNameLast(st.getNameLast());
			ui.setNameFirst(st.getNameFirst());
			ui.setNameMiddle(st.getNameMiddle());
			saveApplicant( request, ui );
		}
		
		public static void saveApplicant( HttpServletRequest request, ApplicantInfo st ) {
			HttpSession session = request.getSession();
			session.setAttribute( SESSION_APPLICANTINFO, st );
		}
		
		public static ApplicantInfo getApplicant( HttpServletRequest request ) {
			HttpSession session = request.getSession();
			return (ApplicantInfo)session.getAttribute( SESSION_APPLICANTINFO );
		}
		
		 public static void removeApplicant( HttpServletRequest request ) {
		        HttpSession session = request.getSession();
		        session.removeAttribute(SESSION_APPLICANTINFO);
		        session.invalidate();

		}
		 
		 
		 
		 
		 //ADD BY PRIYANGIKA
		 

	   public static int getEvalApplicant( HttpServletRequest request ) {
				HttpSession session = request.getSession();
				return (Integer)session.getAttribute(SESSION_EVALUATIONINFO);
		}
			

		 public static void saveEvalApplicant(HttpServletRequest request, int id)
		 {
			 
			 HttpSession session = request.getSession();
				session.setAttribute( SESSION_EVALUATIONINFO, id );
		 }
		 
		 
	   
}
