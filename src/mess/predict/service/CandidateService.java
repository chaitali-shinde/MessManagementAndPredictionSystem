package mess.predict.service;

import java.util.List;
import java.util.Map;

import mess.predict.model.CandidateModel;
import mess.predict.repository.CandidateRepository;

public class CandidateService {
	
	CandidateRepository cRepo=new CandidateRepository();
	
	// Add candidateInfo..Admin
	public boolean isAddCandidateInMess(CandidateModel cModel)
	{
		return cRepo.isAddCandidateInMess(cModel); 
	}
	
	// View candidateinfo..Admin
	public List<CandidateModel> viewAllCandidateInMess()
	{
		return cRepo.viewAllCandidateInMess();
	}
	
	// Delete Candidate Info in Mess..Admin
	public  boolean deleteCandidateInMess(CandidateModel cModel)
	{
		return cRepo.deleteCandidateInMess(cModel);
	}
	
	// Update Candidate Info in Mess..Admin
	public boolean updateCandidateInfoInMess(CandidateModel cModel,int ucontact)
	{
		 return cRepo.updateCandidateInfoInMess(cModel,ucontact);
	}
	
	// User LOGIN
	public int userLogIn(String uname, String uemail) {
		return cRepo.userLogIn(uname, uemail);
	}

	// ThalimealJoin
	public boolean thalimealjoin(int id, int c, int fid) {//cid,mid,fid
		
		return cRepo.thalimealjoin(id,c,fid);
	}

	// View Candidatefood
	public Map<List, List> isViewCandidateFood(String caname) {
		
		return cRepo.isViewCandidateFood(caname);
	}
	
	// View Pending fees..Admin
	public int getIdByName(String aname)
	{
		return cRepo.getIdByName(aname);
	}
	
	// View Pending fees..Admin
	public int getDepositCandidateWise(int getid) {
		
		return cRepo.getDepositCandidateWise(getid);
	}
	// ADD HISTORICALDATA FOR Implementation of algorithm and Add historical admission data
	public int getCountMonthWise(int cdate) {
		return cRepo.getCountMonthWise(cdate);
	}
	
	// Add historical admission data
	public int getMonth(int month) {
		
		return cRepo.getMonth(month);
	}

}
