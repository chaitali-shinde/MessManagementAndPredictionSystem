package mess.predict.repository;

import java.util.ArrayList;
import java.util.List;

import mess.predict.config.DBHelper;
import mess.predict.model.CandidateModel;
import mess.predict.model.ThaliMenuModel;

public class ThaliMenuRepository extends DBHelper{
	
	// Add ThaliMenu
	public boolean isAddThaliInMess(ThaliMenuModel tModel) {
		try {
			pstmt = conn.prepareStatement("insert into thalimenu values('0',?,?,?,?)");
			
			//pstmt.setInt(1, tModel.getTid());
			pstmt.setString(1, tModel.getTname());
			pstmt.setString(2, tModel.getTcategory());
			pstmt.setInt(3, tModel.getTprice());
			pstmt.setString(4,tModel.getTdays() );
			
			int value=pstmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error in add thali " + ex);
			return false;
		}	
	}
	
	// View ThaliMenu
	private List<ThaliMenuModel> tlist = new ArrayList<ThaliMenuModel>();
		public List<ThaliMenuModel> viewThaliInMess(){
				
			List<ThaliMenuModel> tlist = new ArrayList<ThaliMenuModel>();
			try {
					pstmt = conn.prepareStatement("select * from thalimenu");
					rs = pstmt.executeQuery();
					while(rs.next()) {
						
						ThaliMenuModel tModel = new ThaliMenuModel();
						tModel.setTid(rs.getInt(1));
						tModel.setTname(rs.getString(2));
						tModel.setTcategory(rs.getString(3));
						tModel.setTprice(rs.getInt(4));
						tModel.setTdays(rs.getString(5));
		
						tlist.add(tModel);
					}
					return tlist.size()>0?tlist:null;
				}
				catch(Exception ex) {
					System.out.println("Error is " + ex);
					return null;
				}
				
	}	

	// Delete ThaliMenu
	public  boolean deleteThaliInMess(ThaliMenuModel tModel)
	{
		try
		{
			pstmt=conn.prepareStatement(" delete from thalimenu where tid=?");
			pstmt.setInt(1, tModel.getTid());
			int value=pstmt.executeUpdate();
			return value>0?true:false;
			
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}
	
	// Update ThaliMenu
	public boolean updateThaliInMess(ThaliMenuModel tModel,int eutid) 
	{
		try {
			pstmt = conn.prepareStatement("update thalimenu set tid=?,tname=?,tcategory=?,tprice=?,tdays=? where tid=?");
			pstmt.setInt(1, tModel.getTid());
			pstmt.setString(2, tModel.getTname());
			pstmt.setString(3, tModel.getTcategory());
			pstmt.setInt(4, tModel.getTprice());
			pstmt.setString(5, tModel.getTdays());
			pstmt.setInt(6, eutid);
			
			int value = pstmt.executeUpdate();

			return value>0?true:false;
	
		}
		catch(Exception ex) {
			System.out.println("Error in Update" + ex);
			return false;
		}
	}

	// Get monthly bill
	public int getMonthlyBill(String caname,int sum)
	{
		return sum;
	}
}


