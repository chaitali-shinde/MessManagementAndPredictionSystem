package mess.predict.repository;

import java.util.ArrayList;
import java.util.List;

import mess.predict.config.DBHelper;
import mess.predict.model.CandidateModel;
import mess.predict.model.InventoryModel;

public class InventoryRepository extends DBHelper{
	// Add inventory
	public boolean addInventory(InventoryModel iModel) {
		try
		{
			pstmt=conn.prepareStatement("insert into inventory values('0',?,?,?,?,?)");
			pstmt.setString(1, iModel.getInname());
			pstmt.setInt(2, iModel.getQuantity());
			pstmt.setString(3, iModel.getUnit());
			pstmt.setInt(4, iModel.getIprice());
			pstmt.setString(5, iModel.getIdate());
			
			int value=pstmt.executeUpdate();
			return  value>0?true:false;			
		}
		catch(Exception ex)
		{
			System.out.println("\nError is:"+ex);
		}
		return false;
	}
	
	// View inventory
	private List<InventoryModel> ilist= new ArrayList<InventoryModel>();
	public List<InventoryModel> viewInventory(){
		try {
			pstmt = conn.prepareStatement("select * from inventory");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				InventoryModel iModel = new InventoryModel();
				iModel.setInid(rs.getInt(1));
				iModel.setInname(rs.getString(2));
				iModel.setQuantity(rs.getInt(3));
				iModel.setUnit(rs.getString(4));
				iModel.setIprice(rs.getInt(5));
				iModel.setIdate(rs.getString(6));
					
				ilist.add(iModel);
			}
			return ilist.size()>0?ilist:null;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
		
	}

	//sum price of inventory month wise...purchase
	public int getSumofPriceMonthWise(String idate) {
		int sum=0;
		try
		{
			pstmt=conn.prepareStatement("select sum(iprice) from inventory where month(idate)=?");
			pstmt.setString(1, idate);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				sum=rs.getInt(1);
			}
			
			return sum>0?sum:0;
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
			return 0;
		}
	}

}
