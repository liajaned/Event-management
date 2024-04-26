package in.co.online.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.online.Bean.PaymentBean;
import in.co.online.Exception.ApplicationException;
import in.co.online.Utility.JDBCDataSource;

public class PaymentModel {

	public Integer nextpk() {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM payment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return pk+1;
	}
	
	public long add(PaymentBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO payment VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getPersonname());
			ps.setString(3, bean.getCardnumber());
			ps.setString(4, bean.getExpire());
			ps.setString(5, bean.getCvv());
			ps.setString(6, bean.getCreatedby());
			ps.setString(7, bean.getModifiedby());
			ps.setTimestamp(8, bean.getCreateddatetime());
			ps.setTimestamp(9, bean.getModifieddatetime());
			ps.setLong(10, bean.getUserid());
			ps.executeUpdate();
			conn.commit();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception : add rollback exception " + e.getMessage());
		}finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}
	
	public List list() throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getconnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM payment");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setPersonname(rs.getString(2));
			bean.setCardnumber(rs.getString(3));
			bean.setExpire(rs.getString(4));
			bean.setCvv(rs.getString(5));
			bean.setCreatedby(rs.getString(6));
			bean.setModifiedby(rs.getString(7));
			bean.setCreateddatetime(rs.getTimestamp(8));
			bean.setModifieddatetime(rs.getTimestamp(9));
			
			list.add(bean);
		}
		return list;
}
	
	public List showPayment(long userid) throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getconnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM payment where userid=?");
		ps.setLong(1, userid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setPersonname(rs.getString(2));
			bean.setCardnumber(rs.getString(3));
			bean.setExpire(rs.getString(4));
			bean.setCvv(rs.getString(5));
			bean.setCreatedby(rs.getString(6));
			bean.setModifiedby(rs.getString(7));
			bean.setCreateddatetime(rs.getTimestamp(8));
			bean.setModifieddatetime(rs.getTimestamp(9));
			
			list.add(bean);
		}
		return list;
}
}