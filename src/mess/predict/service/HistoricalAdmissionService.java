package mess.predict.service;
import java.util.List;
import java.util.Map;

import mess.predict.model.HistoricalAdmissionModel;
import mess.predict.repository.HistoricalAdmissionRepository;

public class HistoricalAdmissionService {
	HistoricalAdmissionRepository haRepo= new HistoricalAdmissionRepository();
	// Add historical admission data
	public boolean addHistoricalAdmissionData(HistoricalAdmissionModel haModel) {
		
		return haRepo.addHistoricalAdmission(haModel);
	}
	
	// View historical admission data
	public List<HistoricalAdmissionModel> viewHistoricalAdmissionData() {
		return haRepo.viewHistoricalAdmissionData();
	}

	// Calculate Mean of X in historical admission data
	public int calculateMeanOfX(HistoricalAdmissionModel haModel) {
		
		return haRepo.calculateMeanOfX(haModel);
	}

	// Calculate Mean of Y in historical admission data
	public int calculateMeanOfY(HistoricalAdmissionModel haModel) {
		return haRepo.calculateMeanOfY(haModel);
	}

	// Calculate deviation of X in historical admission data
	public List<HistoricalAdmissionModel> calculateDeviationOfX() {
		
		return haRepo.calculateDeviationOfX();
	}
	
	// Calculate daviation of Y in historical admission data
	public List<HistoricalAdmissionModel> calculateDeviationOfY() {
		
		return haRepo.calculateDeviationOfY();
	}
	
}
