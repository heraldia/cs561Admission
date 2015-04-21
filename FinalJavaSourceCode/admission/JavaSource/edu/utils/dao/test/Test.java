package edu.utils.dao.test;
import dao.DutyAssignDAO;

public class Test {

	
	public static void main(String arg[])throws Exception
	{
		DutyAssignDAO da=new DutyAssignDAO();
		
		//System.out.print(da.getApplicants());
		//System.out.print(da.getCommittee());
	/*	
	    int[][] a= da.prepareData();
		 
		 for(int i=0;i<7;i++)
		 {
			 for(int j=0;j<a[i].length;j++)
				 System.out.print(a[i][j]);
			 
			 System.out.println();
			 
		 }
	*/
		da.inserttoDutyAssign();
	
	//da.inserttoDuty();
		
	}
}
