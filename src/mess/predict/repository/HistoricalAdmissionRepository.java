package mess.predict.repository;

import java.util.ArrayList;
import java.util.List;

import mess.predict.config.DBHelper;
import mess.predict.model.HistoricalAdmissionModel;
import mess.predict.model.HistoricalModel;

public class HistoricalAdmissionRepository extends DBHelper {
	//Add Historical Admission
	public boolean addHistoricalAdmission(HistoricalAdmissionModel haModel) {
		try
		{
			pstmt=conn.prepareStatement("insert into historicalAdmission values('0',?,?)");
			pstmt.setInt(1,haModel.getXmonth());
			pstmt.setInt(2, haModel.getCountycid());
			
			int value=pstmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("\n Error is:"+ ex);
			return false;
		}
	}
	
	// View Historical Admission
	private List<HistoricalAdmissionModel> halist = new ArrayList<HistoricalAdmissionModel>();
	public List<HistoricalAdmissionModel> viewHistoricalAdmissionData() {
		List<HistoricalAdmissionModel> halist = new ArrayList<HistoricalAdmissionModel>();
		
		try {
			pstmt = conn.prepareStatement("select * from historicaladmission");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HistoricalAdmissionModel haModel = new HistoricalAdmissionModel();
				haModel.setHid(rs.getInt(1));
				haModel.setXmonth(rs.getInt(2));
				haModel.setCountycid(rs.getInt(3));
				
				halist.add(haModel);
			}
			return halist.size()>0?halist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}
	
	// Calculate Mean of X in Historical Admission Data
	public int calculateMeanOfX(HistoricalAdmissionModel haModel)
	{
		int meanofx=0;
		try
		{
			pstmt=conn.prepareStatement("select avg(xmonth) from historicalAdmission");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				meanofx=(rs.getInt(1));
			}
		
			return meanofx>0?meanofx:0;
			
		}
		
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return 0;
		}
	}
	
	// Calculate Mean of Y in Historical Admission Data
	public int calculateMeanOfY(HistoricalAdmissionModel haModel)
	{
		int meanofy=0;
		try
		{
			pstmt=conn.prepareStatement("select avg(countycid) from historicalAdmission");
			rs=pstmt.executeQuery();
			while(rs.next())	
			{
				meanofy=(rs.getInt(1));
			}
			return meanofy>0?meanofy:0;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return 0;
		}
	}
	
	// Calculate Deviation of X in Historical Admission Data
	private List<HistoricalAdmissionModel> devXlist = new ArrayList<HistoricalAdmissionModel>();
	public List<HistoricalAdmissionModel> calculateDeviationOfX() {
		List<HistoricalAdmissionModel> devXlist = new ArrayList<HistoricalAdmissionModel>();
		try
		{
			pstmt=conn.prepareStatement("SELECT xmonth - (SELECT AVG(xmonth) FROM historicalAdmission) AS 'xcid_minus_avg' FROM historicalAdmission");
			rs=pstmt.executeQuery();
			while(rs.next())	
			{
				HistoricalAdmissionModel haModel = new HistoricalAdmissionModel();
				haModel.setXmonth(rs.getInt(1));

				devXlist.add(haModel);
			}
			return devXlist.size()>0?devXlist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
		
	}
	
	// // Calculate Deviation of Y in Historical Admission Data
	private List<HistoricalAdmissionModel> devYlist = new ArrayList<HistoricalAdmissionModel>();
	public List<HistoricalAdmissionModel> calculateDeviationOfY() {
		List<HistoricalAdmissionModel> devYlist = new ArrayList<HistoricalAdmissionModel>();

		try
		{
			pstmt=conn.prepareStatement("SELECT countycid - (SELECT AVG(countycid) FROM historicalAdmission) AS 'yinid_minus_avg' FROM historicalAdmission");
			rs=pstmt.executeQuery();
			while(rs.next())	
			{
				HistoricalAdmissionModel haModel = new HistoricalAdmissionModel();
				haModel.setCountycid(rs.getInt(1));
				
				devYlist.add(haModel);
			}
			return devYlist.size()>0?devYlist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
		
	}
}
