package application;

public class BookingModel {

	private int bid, seat;
	private String cname, cnumber, movie, date, time;
	
	public BookingModel(int bid, String cname, String cnumber, String movie, String date, String time, int seat) {
		super();
		this.bid = bid;
		this.cname = cname;
		this.cnumber = cnumber;
		this.movie = movie;
		this.date = date;
		this.time = time;
		this.seat = seat;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	
	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
