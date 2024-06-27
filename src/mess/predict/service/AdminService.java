package mess.predict.service;

import mess.predict.repository.AdminRepository;

public class AdminService {
    AdminRepository aRepo= new AdminRepository();
    // Admin LOGIN
	public Boolean adminLogIn(String aname, String apassword) {
		
		return aRepo.adminLogIn(aname,apassword);
	}

}
