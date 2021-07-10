package application;

public class ShowModel {

	private int mid;
	private String mname, status, stime;
	
	public ShowModel(int mid, String mname, String stime, String status) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.stime = stime;
		this.status = status;
		
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
