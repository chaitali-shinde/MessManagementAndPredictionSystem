package mess.predict.service;

import java.util.List;

import mess.predict.model.InventoryModel;
import mess.predict.repository.InventoryRepository;

public class InventoryService {

	InventoryRepository iRepo=new InventoryRepository();
	
	// Add inventory
	public boolean addInventory(InventoryModel iModel) {
		
		return iRepo.addInventory(iModel);
	}
	
	// View inventory
	public List<InventoryModel> viewInventory() {
		
		return iRepo.viewInventory();
	}
	
	//sum price of inventory month wise...purchase
	public int getSumofPriceMonthWise(String idate) {
	
		return iRepo.getSumofPriceMonthWise(idate);
	}

}
