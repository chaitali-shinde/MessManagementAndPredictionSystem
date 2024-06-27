package mess.predict.model;

public class HistoricalAdmissionModel {
	private int hid;
	private int xmonth;
	private int countycid;
	
	public HistoricalAdmissionModel() {
		
	}
	
	public HistoricalAdmissionModel(int hid,int xmonth,int countycid) {
		this.hid=hid;
		this.xmonth=xmonth;
		this.countycid=countycid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getXmonth() {
		return xmonth;
	}

	public void setXmonth(int xmonth) {
		this.xmonth = xmonth;
	}

	public int getCountycid() {
		return countycid;
	}

	public void setCountycid(int countycid) {
		this.countycid = countycid;
	}
	
	
	
}
