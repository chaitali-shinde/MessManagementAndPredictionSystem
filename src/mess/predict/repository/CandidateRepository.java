package mess.predict.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mess.predict.config.DBHelper;
import mess.predict.model.CandidateModel;
import mess.predict.model.ThaliMenuModel;


public class CandidateRepository extends DBHelper { //ithe DBConfig la inherit kely bcoz dbconfig mdhe jevhde variables aahet te pass hotat
	// Add candidateInfo
	public boolean isAddCandidateInMess(CandidateModel cModel) {
		
		try {
				pstmt=conn.prepareStatement("insert into CandidateInfo values('0',?,?,?,?,?,?,?)");
				pstmt.setString(2, cModel.getCname());
				pstmt.setString(3, cModel.getCemail());
				pstmt.setInt(4, cModel.getCcontact());
				pstmt.setString(5,cModel.getCaddress());
				pstmt.setString(6, cModel.getCmembership());
				pstmt.setString(7, cModel.getCregdate());
				pstmt.setInt(8, cModel.getCdeposit());
				
				int value=pstmt.executeUpdate();
				return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}
	
	// View candidateinfo
	private List<CandidateModel> clist= new ArrayList<CandidateModel>();
	
	public List<CandidateModel> viewAllCandidateInMess(){
		List<CandidateModel> clist = new ArrayList<CandidateModel>();
		try {
			pstmt = conn.prepareStatement("select * from CandidateInfo");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CandidateModel cModel = new CandidateModel();
				cModel.setCid(rs.getInt(1));
				cModel.setCname(rs.getString(2));
				cModel.setCemail(rs.getString(3));
				cModel.setCcontact(rs.getInt(4));
				cModel.setCaddress(rs.getString(5));
				cModel.setCmembership(rs.getString(6));
				cModel.setCregdate(rs.getString(7));
				cModel.setCdeposit(rs.getInt(8));
				
				clist.add(cModel);
			}
			return clist.size()>0?clist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}
	
	// Delete Candidate Info in Mess
	public boolean deleteCandidateInMess(CandidateModel cModel)
	{
		try
		{
			pstmt=conn.prepareStatement("delete from candidateinfo where cid=?");
			pstmt.setInt(1, cModel.getCid());
			
			int value=pstmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}
	
	// Update Candidate Info in Mess
	public boolean updateCandidateInfoInMess(CandidateModel cModel,int ucontact) 
	{
		try {
			pstmt = conn.prepareStatement("update candidateinfo set cemail=?,ccontact=?,caddress=?,cdeposite=? where ccontact=?");
			pstmt.setString(1, cModel.getCemail());
			pstmt.setInt(2, cModel.getCcontact());
			pstmt.setString(3,cModel.getCaddress());
			pstmt.setInt(4, cModel.getCdeposit());
			pstmt.setInt(5, ucontact);
			
			int value = pstmt.executeUpdate();
			return value>0?true:false;	
		}
		catch(Exception ex) {
			System.out.println("Error in Update" + ex);
			return false;
		}
	}

	// User LOGIN
	public int userLogIn(String uname,String uemail)
	{
		int value=0;
		int id=0;
		try {
			
			 pstmt=conn.prepareStatement("select cname,cemail,cid from candidateinfo where cname=? and cemail=?");
			 
			 pstmt.setString(1, uname);
			 pstmt.setString(2, uemail);
			 rs = pstmt.executeQuery();
			
			 while(rs.next()) 
				{
					String cn=(rs.getString(1));
					String cp=(rs.getString(2));
					 id=(rs.getInt(3));
					//System.out.println("cn"+cn+"cp"+cp);
						if(cn.equals(uname)&& cp.equals(uemail)) 
						{
							value=1;
						}
				}
		}
		catch(Exception ex) {
			System.out.println("Error is" + ex);
		}
		return (value==1)? id:0;
	}

	// ThaliMeal-join table
	public boolean thalimealjoin(int id, int c, int fid) //cid,mid,fid
	{	
		 try {
			 pstmt=conn.prepareStatement("insert into thalimealjoin values(?,?,?)");
			 
			 pstmt.setInt(1, id);//candidate id
			 pstmt.setInt(2, fid);//food/thali id
			 pstmt.setInt(3, c);//mealtype id
			 
			 int value=pstmt.executeUpdate();
			 return value>0?true:false;
		} 
		catch (Exception ex) {
			System.out.println("Error is " + ex);
			
		}
		return false;
	}
	
	// View candidatefood
	ThaliMenuModel tModel=null;
	public Map<List, List> isViewCandidateFood(String caname) {
		int cid=0;
		String mtype = null;
		Map<List,List> joinmap=new HashMap<List,List>();
		List<ThaliMenuModel> tmlist=new ArrayList<ThaliMenuModel>();//thali model list
		List<String> key=new ArrayList<String>();//lunch or dinner
	
		try 
		{
			pstmt=conn.prepareStatement("select cid from candidateinfo where cname=?");
			pstmt.setString(1, caname);//ram
			rs=pstmt.executeQuery();

			while(rs.next()) {
				cid=rs.getInt(1);//2
			}

			if(cid!=0)//2!=0 
			{
				pstmt=conn.prepareStatement("select t.tname,t.tcategory,t.tprice,t.tdays,m.mtype from thalimenu t inner join thalimealjoin th on t.tid=th.tid inner join mealtype m on m.mid=th.mid inner join candidateinfo c on c.cid=th.cid where th.cid=?");
				pstmt.setInt(1, cid);//2-ky jevan kele ram ne tyach data milnar
				
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					ThaliMenuModel tModel=new ThaliMenuModel();
					tModel.setTname(rs.getString(1));
					tModel.setTcategory(rs.getString(2));
					tModel.setTprice(rs.getInt(3));
					tModel.setTdays(rs.getString(4));
					
					key.add(rs.getString(4)); //Menu Type As A Key
					
					tmlist.add(tModel);// Thali Info Added to list
				}
				joinmap.put(key, tmlist);//Menu Type As A Key And List As Value 
			}
			else {
				System.out.println("Sorry.... \n No Customer Found \n Please Try Again....");
			}	
		}
		catch(Exception ex) {
			System.out.println("erro is " +ex);
			return null;
		}
		return joinmap.size()>0?joinmap:null;
	}
	
	// View Pending fees..Admin
	public int getIdByName(String aname)
	{
		int gid=0;
		try {
			pstmt=conn.prepareStatement("select cid from candidateinfo where cname=?");
			pstmt.setString(1, aname);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				gid=rs.getInt(1);
			}
			return gid>0?gid:0;
		}
		catch(Exception ex)
		{
			System.out.println("\n Error is:"+ex);
		}
		return 0;
	}
	

	// View Pending fees...Admin
	public int getDepositCandidateWise(int getid)
	{
		int getDeposit=0;
		try
		{
			pstmt=conn.prepareStatement("select cdeposite from candidateinfo where cid=?");
			pstmt.setInt(1, getid);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				getDeposit=rs.getInt(1);
			}
			return getDeposit>0?getDeposit:0;
		}
		catch(Exception ex)
		{
			System.out.println("\n Error is:"+ex);
		}
		return 0;
	}

	// ADD HISTORICALDATA FOR Implementation of algorithm
	public int getCountMonthWise(int cdate) {
		int count=0;
		try
		{
			pstmt=conn.prepareStatement("select count(month(cregdate)) from candidateinfo where month(cregdate)=?");
			pstmt.setInt(1, cdate);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			return count>0?count:0;
		}
		catch(Exception ex)
		{
		System.out.println("\n Error is:"+ex);
		}
		return 0;
	}
	
	// get month..Admin
	public int getMonth(int month)
	{
		int m=0;
		//int c=0;
		try
		{
			pstmt=conn.prepareStatement(" SELECT MONTH(cregdate) AS xmonth FROM candidateinfo GROUP BY MONTH(cregdate) HAVING xmonth =?");
			pstmt.setInt(1, month);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				m=rs.getInt(1);
			}
			return m>0?m:0;
		}
		catch(Exception ex)
		{
		System.out.println("\n Error is:"+ex);
		}
		return 0;
	}
}