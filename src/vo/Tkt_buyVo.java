package vo;

public class Tkt_buyVo {
	 private String tktbuy_no;
	 private String users_no;
	 private int tkt_pay;
	 private String tktbuy_date;
	 private String del_yn;

	public String getTktbuy_no() {
		return tktbuy_no;
	}
	public void setTktbuy_no(String tktbuy_no) {
		this.tktbuy_no = tktbuy_no;
	}
	public String getUsers_no() {
		return users_no;
	}
	public void setUsers_no(String users_no) {
		this.users_no = users_no;
	}
	public int getTkt_pay() {
		return tkt_pay;
	}
	public void setTkt_pay(int tkt_pay) {
		this.tkt_pay = tkt_pay;
	}
	public String getTktbuy_date() {
		return tktbuy_date;
	}
	public void setTktbuy_date(String tktbuy_date) {
		this.tktbuy_date = tktbuy_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

}