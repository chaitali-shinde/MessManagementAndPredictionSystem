package mess.predict.service;

import java.util.List;

import mess.predict.model.CandidateModel;
import mess.predict.model.ThaliMenuModel;
import mess.predict.repository.ThaliMenuRepository;

public class ThaliMenuService {
	
	ThaliMenuRepository tRepo=new ThaliMenuRepository();
	// Add Thali
	public boolean isAddThali(ThaliMenuModel tModel)
	{
		return tRepo.isAddThaliInMess(tModel);
	}
	
	// view Thali
	public List<ThaliMenuModel> viewAllThaliInMess()
	{
		return tRepo.viewThaliInMess();
	}
	
	// Delete Thali
	public  boolean deleteThaliInMess(ThaliMenuModel tModel)
	{
		boolean b=tRepo.deleteThaliInMess(tModel);
		return b;
	}
	
	// Update Thali
	public boolean updateThaliInMess(ThaliMenuModel tModel,int eutid)
	{
		 
		return tRepo.updateThaliInMess(tModel,eutid);
	}

	// Get monthly Bill
	public int getMonthlyBill(String caname,int sum) {
		return tRepo.getMonthlyBill(caname, sum);
	}
}
