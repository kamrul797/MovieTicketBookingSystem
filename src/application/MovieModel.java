package application;

public class MovieModel {

	private String mname, status, stime;
	
	public MovieModel(String mname, String stime, String status) {
		super();
		this.mname = mname;
		this.stime = stime;
		this.status = status;
		
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
