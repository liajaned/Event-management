package in.co.online.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.online.Bean.VenueBean;
import in.co.online.Exception.ApplicationException;
import in.co.online.Utility.JDBCDataSource;

public class VenueModel {

	public Integer nextpk() {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM venue");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {

		}
		return pk + 1;
	}

	public long add(VenueBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO venue VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setLong(2, bean.getEventtypeid());
			ps.setString(3, bean.getLocation());
			ps.setString(4, bean.getCapacity());
			ps.setString(5, bean.getCost());
			ps.setDate(6, new Date(bean.getDate().getTime()));
			ps.setString(7, bean.getContact());
			ps.setBlob(8, bean.getImage());
			ps.setString(9, bean.getCreatedby());
			ps.setString(10, bean.getModifiedby());
			ps.setTimestamp(11, bean.getCreateddatetime());
			ps.setTimestamp(12, bean.getModifieddatetime());
			ps.executeUpdate();
			conn.commit();
			ps.close();
			
		} catch (Exception e) {
			throw new ApplicationException("Exception : add rollback exception " + e.getMessage());
		}finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}

	public List list() throws Exception {
		ArrayList list = new ArrayList();
		try {
			Connection conn = null;
			conn = JDBCDataSource.getconnection();
			PreparedStatement ps = 
	conn.prepareStatement("SELECT venue.id,eventtype.eventname,capacity,cost,image,date,contact,location FROM venue INNER JOIN eventtype ON venue.eventtypeid=eventtype.id");
			ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
				VenueBean  bean = new VenueBean();
				bean.setId(rs.getLong(1));
				bean.setEventtype(rs.getString(2));
				bean.setCapacity(rs.getString(3));
				bean.setCost(rs.getString(4));
				bean.setImage(rs.getBlob(5));
				bean.setDate(rs.getDate(6));
				bean.setContact(rs.getString(7));
				bean.setLocation(rs.getString(8));
				list.add(bean);
	        }
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
}
}