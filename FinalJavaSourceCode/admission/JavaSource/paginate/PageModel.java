package paginate;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class PageModel<T> {
	
	//
	private List<T> list;
	
	//
	private int totalRecords;
	
	//
	private int pageSize;
	
	//
	private int pageNo;

	/**
	 * get total number of pages
	 * @return int
	 */
	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}
	
	/**
	 * return 1 
	 * @return int
	 */
	public int getTopPageNo() {
		return 1;
	}
	
	/**
	 *  return the page number of previous one.
	 * @return int
	 */
	public int getPreviousPageNo() {
		if (this.pageNo <= 1) {
			return 1;
		}
		return this.pageNo - 1;
	}
	
	/**
	 *  return the page number of next one.
	 * @return int
	 */
	public int getNextPageNo() {
		if (this.pageNo >= getButtomPageNo()) {
			return getButtomPageNo();
		}
		return this.pageNo + 1;
	}
	
	/**
	 *  return the page number of last one.
	 * @return int
	 */
	public int getButtomPageNo() {
		return getTotalPages();
	}
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
