package mess.predict.model;

public class AttendenceModel {
	
	private int cid;
	private int tid;
	private int mid;
	private int status;
	
	
	public AttendenceModel() {
		
	}
	
	public AttendenceModel(int cid,int tid, int mid, int status) {
		
		this.cid=cid;
		this.tid=tid;
		this.mid=mid;
		this.status=status;
		
	}
	


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


	
	
	
}
