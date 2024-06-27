package mess.predict.service;

import java.util.List;
import java.util.Map;

import mess.predict.model.HistoricalModel;
import mess.predict.repository.HistoricalRepository;

public class HistoricalService {

	HistoricalRepository hRepo= new HistoricalRepository();
	// Add Historical Data
	public boolean addHistoricalData(HistoricalModel hModel) {
		
		return hRepo.addHistoricalData(hModel);
	}
	
	// View Historical Data
	public List<HistoricalModel> viewHistoricalData() {
		return hRepo.viewHistoricalData();
	}

	// Calculate mean of X in Historical Data
	public int calculateMeanOfX(HistoricalModel hModel) {
		
		return hRepo.calculateMeanOfX(hModel);
	}

	// Calculate mean of Y in Historical Data
	public int calculateMeanOfY(HistoricalModel hModel) {
		return hRepo.calculateMeanOfY(hModel);
	}

	// Calculate deviationn of X in Historical Data
	public List<HistoricalModel> calculateDeviationOfX() {
		
		return hRepo.calculateDeviationOfX();
	}
	
	// Calculate deviation of Y in Historical Data
	public List<HistoricalModel> calculateDeviationOfY() {
		
		return hRepo.calculateDeviationOfY();
	}
}
