package mess.predict.model;

public class InventoryModel {
	
	private int inid;
	private String inname;
	private int quantity;
	private String unit;
	private int iprice;
	private String idate;
	
	
	public InventoryModel()
	{
		
	}
	
	public InventoryModel(int inid,String inname,int quantity,String unit,int iprice,String idate)
	{
		this.inid=inid;
		this.inname=inname;
		this.quantity=quantity;
		this.unit=unit;
		this.iprice=iprice;
		this.idate=idate;
	}
	public int getInid() {
		return inid;
	}
	public void setInid(int inid) {
		this.inid = inid;
	}
	public String getInname() {
		return inname;
	}
	public void setInname(String inname) {
		this.inname = inname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getIprice() {
		return iprice;
	}

	public void setIprice(int iprice) {
		this.iprice = iprice;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}
	
	

}
