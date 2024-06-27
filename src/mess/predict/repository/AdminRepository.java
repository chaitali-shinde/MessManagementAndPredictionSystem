package mess.predict.repository;
import mess.predict.config.DBHelper;
public class AdminRepository extends DBHelper{

	//Admin LOGIN
	public Boolean adminLogIn(String aname, String apassword) {
		 int value=0;
		 try {
			 pstmt=conn.prepareStatement("select aname,apassword from admin where aname=? and apassword=?");
			 
			 pstmt.setString(1, aname);
			 pstmt.setString(2, apassword);
			 
			 rs = pstmt.executeQuery();
				while(rs.next()) {
				String cn=(rs.getString(1));
				String cp=(rs.getString(2));
				
				if(cn.equals(aname)&& cp.equals(apassword)) 
				{
					value=1;
				}
			}
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
		return (value==1)?true:false;
	}
}
