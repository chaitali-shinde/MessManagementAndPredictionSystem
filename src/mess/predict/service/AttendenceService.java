package mess.predict.service;

import java.util.List;

import mess.predict.model.AttendenceModel;
import mess.predict.repository.AttendenceRepository;

public class AttendenceService {

	AttendenceRepository aRepo = new AttendenceRepository();
	
	// View Attendence
	public List<AttendenceModel> viewAttendence()
	{		
		return aRepo.ViewAttendence();
	}
		
	// Calculate Attendence
	public int calculateAttendence(int getid) {
		
		return aRepo.calculateAttendence(getid);
	}
}
