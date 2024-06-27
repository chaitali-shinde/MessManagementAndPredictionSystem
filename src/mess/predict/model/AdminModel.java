package mess.predict.model;

public class AdminModel {
	private String aname;
	private String apassword;
	
	
	public AdminModel(){
	
	}
	
	public AdminModel(String aname,String apassword) {
		this.aname=aname;
		this.apassword=apassword;
	}
	

	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
	
}
