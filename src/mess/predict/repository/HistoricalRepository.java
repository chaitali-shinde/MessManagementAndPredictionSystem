package mess.predict.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mess.predict.config.DBHelper;
import mess.predict.model.CandidateModel;
import mess.predict.model.HistoricalModel;

public class HistoricalRepository extends DBHelper{

	// Add Historical Data
	public boolean addHistoricalData(HistoricalModel hModel)
	{
		try
		{
			pstmt=conn.prepareStatement("insert into historicaldata values('0',?,?)");
			pstmt.setInt(1,hModel.getXcid());
			pstmt.setInt(2, hModel.getYinid());
			
			int value=pstmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("\n Error is:"+ ex);
			return false;
		}
	}
	
	// View historical Data
	private List<HistoricalModel> hlist = new ArrayList<HistoricalModel>();
	public List<HistoricalModel> viewHistoricalData() {
		List<HistoricalModel> hlist = new ArrayList<HistoricalModel>();
		
		try {
			pstmt = conn.prepareStatement("select * from historicaldata");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HistoricalModel hModel = new HistoricalModel();
				hModel.setHid(rs.getInt(1));
				hModel.setXcid(rs.getInt(2));
				hModel.setYinid(rs.getInt(3));
				
				hlist.add(hModel);
			}
			return hlist.size()>0?hlist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}
	
	
	// Calculate Mean of X in Historical Data
	public int calculateMeanOfX(HistoricalModel hModel)
	{
		int meanofx=0;
		try
		{
			pstmt=conn.prepareStatement("select avg(xcid) from historicaldata");
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
	
	// Calculate Mean of Y in Historical Data
	public int calculateMeanOfY(HistoricalModel hModel)
	{
		int meanofy=0;
		try
		{
			pstmt=conn.prepareStatement("select avg(yinid) from historicaldata");
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
	
	// Calculate Deviation of X in Historical  Data
	private List<HistoricalModel> devXlist = new ArrayList<HistoricalModel>();
	public List<HistoricalModel> calculateDeviationOfX() {
		List<HistoricalModel> devXlist = new ArrayList<HistoricalModel>();
		//int deviationOfX=0;
		try
		{
			pstmt=conn.prepareStatement("SELECT xcid - (SELECT AVG(xcid) FROM historicaldata) AS 'xcid_minus_avg' FROM historicaldata");
			rs=pstmt.executeQuery();
			while(rs.next())	
			{
				HistoricalModel hModel = new HistoricalModel();
				hModel.setXcid(rs.getInt(1));
				//deviationOfX=(rs.getInt(1));
				devXlist.add(hModel);
			}
			return devXlist.size()>0?devXlist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}
	
	// Calculate Deviation of Y in Historical Data
	private List<HistoricalModel> devYlist = new ArrayList<HistoricalModel>();
	public List<HistoricalModel> calculateDeviationOfY() {
		List<HistoricalModel> devYlist = new ArrayList<HistoricalModel>();
		try
		{
			pstmt=conn.prepareStatement("SELECT yinid - (SELECT AVG(yinid) FROM historicaldata) AS 'yinid_minus_avg' FROM historicaldata");
			rs=pstmt.executeQuery();
			while(rs.next())	
			{
				HistoricalModel hModel = new HistoricalModel();
				hModel.setYinid(rs.getInt(1));
				
				devYlist.add(hModel);
			}
			return devYlist.size()>0?devYlist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
		
	}

}

