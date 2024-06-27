package mess.predict.model;

public class HistoricalModel {
	private int hid;
	private int xcid;
	private int yinid;
	
	public HistoricalModel() {
		
	}
	public HistoricalModel(int hid,int xcid,int yinid) {
		this.hid=hid;
		this.xcid=xcid;
		this.yinid=yinid;
	}
	
	
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getXcid() {
		return xcid;
	}
	public void setXcid(int xcid) {
		this.xcid = xcid;
	}
	public int getYinid() {
		return yinid;
	}
	public void setYinid(int yinid) {
		this.yinid = yinid;
	}
	
	
	
}
