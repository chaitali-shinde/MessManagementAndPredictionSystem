package mess.predict.repository;

import java.util.ArrayList;
import java.util.List;

import mess.predict.config.DBHelper;
import mess.predict.model.AttendenceModel;
import mess.predict.model.CandidateModel;

public class AttendenceRepository extends DBHelper{
	
	// View attendence
	private List<AttendenceModel> atlist=new ArrayList<AttendenceModel>();
	public List<AttendenceModel> ViewAttendence()
	{    
		AttendenceModel aModel=null;
		List<AttendenceModel> atlist=new ArrayList<AttendenceModel>();
		try {
			pstmt=conn.prepareStatement("Select *from thalimealjoin");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
			    aModel=new AttendenceModel();
			      
				aModel.setCid(rs.getInt(1));
				aModel.setTid(rs.getInt(2));
				aModel.setMid(rs.getInt(3));
				int at=1;
				aModel.setStatus(at);
	
				atlist.add(aModel);
			}	
				System.out.println("Atlist:"+atlist);
			if(true) {
					pstmt = conn.prepareStatement("insert into attendence values (?,?,?,?)");
					pstmt.setInt(1, aModel.getCid());
					pstmt.setInt(2, aModel.getTid());
					pstmt.setInt(3, aModel.getMid());
					pstmt.setInt(4, aModel.getStatus());
					
					int value=pstmt.executeUpdate();
				}
	
			return atlist.size()>0?atlist:null;
		}catch(Exception ex)
		{
			System.out.println("\nError is:"+ex);
		}
		return null;
	}
	
	// Calculate Attendence
	int count=0,aid;
	public int calculateAttendence(int getid) {
		try 
		{
			pstmt = conn.prepareStatement("select count(status) from attendence where cid=?");
			pstmt.setInt(1, getid);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			return count;
		}
		catch(Exception ex)
		{
			System.out.println("Error is " + ex);
			return 0;
		}
	}
}



