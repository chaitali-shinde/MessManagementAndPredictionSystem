package mess.predict.model;

public class ThaliMenuModel {
	private int tid;
	private String tname;
	private String tcategory;// veg or non-veg
	private int tprice;
	private String tdays;
	
	
	
	public ThaliMenuModel() {
		
	}
	
	public ThaliMenuModel(int tid,String tname,String tcategory,int tprice,String tdays) {
		this.tid=tid;
		this.tname=tname;
		this.tcategory=tcategory;
		this.tprice=tprice;
		this.tdays=tdays;
	}
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTcategory() {
		return tcategory;
	}
	public void setTcategory(String tcategory) {
		this.tcategory = tcategory;
	}
	public int getTprice() {
		return tprice;
	}
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public String getTdays() {
		return tdays;
	}

	public void setTdays(String tdays) {
		this.tdays = tdays;
	}
	
	
}
