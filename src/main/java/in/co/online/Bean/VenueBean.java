package in.co.online.Bean;

import java.sql.Blob;
import java.util.Date;

public class VenueBean extends BaseBean {
	
	private  long eventtypeid;
	private String location;
	private String capacity;
	private String cost;
	private Date date;
	private String contact;
	private Blob image;
	private String eventtype;
	
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	public long getEventtypeid() {
		return eventtypeid;
	}
	public void setEventtypeid(long eventtypeid) {
		this.eventtypeid = eventtypeid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	

}
