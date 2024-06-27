package mess.predict.model;

import java.sql.Date;

public class CandidateModel {
	
	private int cid;
	private String cname;
	private String cemail;
	private int ccontact;
	private String caddress;
	private String cmembership;
	private String cregdate;
	private int cdeposit;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public int getCcontact() {
		return ccontact;
	}
	public void setCcontact(int ccontact) {
		this.ccontact = ccontact;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCmembership() {
		return cmembership;
	}
	public void setCmembership(String cmembership) {
		this.cmembership = cmembership;
	}
	public String getCregdate() {
		return cregdate;
	}
	public void setCregdate(String cregdate) {
		this.cregdate = cregdate;
	}
	public int getCdeposit() {
		return cdeposit;
	}
	public void setCdeposit(int cdeposit) {
		this.cdeposit = cdeposit;
	}
	public CandidateModel()
	{
		
	}
	public CandidateModel(int cid,String cname,String cemail,int ccontact,String caddress,String cmembership,String cregdate,int cdeposit)
	{
		this.cid=cid;
		this.cname=cname;
		this.cemail=cemail;
		this.ccontact=ccontact;
		this.caddress=caddress;
		this.cmembership=cmembership;
		this.cregdate=cregdate;
		this.cdeposit=cdeposit;
		
	}
	
	
}



