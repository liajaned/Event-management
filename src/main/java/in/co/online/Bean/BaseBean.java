package in.co.online.Bean;

import java.sql.Timestamp;

public class BaseBean {
	
	private long id;
	private String createdby;
	private String modifiedby;
	private Timestamp createddatetime;
	private Timestamp modifieddatetime;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public Timestamp getCreateddatetime() {
		return createddatetime;
	}
	public void setCreateddatetime(Timestamp createddatetime) {
		this.createddatetime = createddatetime;
	}
	public Timestamp getModifieddatetime() {
		return modifieddatetime;
	}
	public void setModifieddatetime(Timestamp modifieddatetime) {
		this.modifieddatetime = modifieddatetime;
	}
	

}
