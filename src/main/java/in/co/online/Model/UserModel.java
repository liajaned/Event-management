package in.co.online.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.online.Bean.RoleBean;
import in.co.online.Bean.UserBean;
import in.co.online.Utility.JDBCDataSource;

public class UserModel {

	public Integer Rolenextpk() {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM role");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return pk + 1;
	}

	public long Roleadd(RoleBean bean) throws Exception {
		System.out.println("in ROle ADD");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			pk = Rolenextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO role VALUES(?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getRolename());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getCreatedby());
			ps.setString(5, bean.getModifiedby());
			ps.setTimestamp(6, bean.getCreateddatetime());
			ps.setTimestamp(7, bean.getModifieddatetime());
			ps.executeUpdate();
			System.out.println("IN End Add Method");
			conn.commit();
			ps.close();

		} catch (Exception e) {
			try {
				conn.rollback();

			} catch (Exception e2) {

			}
		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}

	public RoleBean RolefindByPK(long pk) {
		Connection conn = null;
		RoleBean bean = null;
		StringBuffer sql = new StringBuffer("SELECT * FROM role WHERE ID=?");

		try {
			conn = JDBCDataSource.getconnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getLong(1));
				bean.setRolename(rs.getString(2));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public Integer nextpk() {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return pk + 1;
	}

	public long add(UserBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getFirstName());
			ps.setString(3, bean.getLastName());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getPassword());
			ps.setString(6, bean.getGender());
			ps.setLong(7, bean.getRoleid());
			ps.setString(8, bean.getCreatedby());
			ps.setString(9, bean.getModifiedby());
			ps.setTimestamp(10, bean.getCreateddatetime());
			ps.setTimestamp(11, bean.getModifieddatetime());
            ps.executeUpdate();
            conn.commit();
            ps.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {

			}
		}finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}
	public UserBean findByPK(long pk) {
		Connection conn = null;
		UserBean bean = null;
		StringBuffer sql = new StringBuffer("SELECT * FROM user WHERE ID=?");

		try {
			conn = JDBCDataSource.getconnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setGender(rs.getString(6));
				bean.setRoleid(rs.getLong(7));
				bean.setCreatedby(rs.getString(8));
				bean.setModifiedby(rs.getString(9));
				bean.setCreateddatetime(rs.getTimestamp(10));
				bean.setModifieddatetime(rs.getTimestamp(11));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public long Update(UserBean bean) {

		System.out.println("in model update method");
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getconnection();
			PreparedStatement ps = conn.prepareStatement(
					"update user set firstName=?, lastName=?, email=?,password=?,gender=?, roleid=? where id=?");
			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getLastName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getGender());
			ps.setLong(6, bean.getRoleid());
			ps.setLong(7, bean.getId());
			 ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

	
	public UserBean Authenticate(String email,String password) throws Exception{
		UserBean bean = null;
		Connection conn = null;
		conn = JDBCDataSource.getconnection();
	     PreparedStatement ps =	conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
	     ps.setString(1, email);
	     ps.setString(2, password);
	     ResultSet rs = ps.executeQuery();
	     while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setGender(rs.getString(6));
			bean.setRoleid(rs.getLong(7));
			bean.setCreatedby(rs.getString(8));
			bean.setModifiedby(rs.getString(9));
			bean.setCreateddatetime(rs.getTimestamp(10));
			bean.setModifieddatetime(rs.getTimestamp(11));
		}
		return bean;
	}
	
	public List list() throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getconnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UserBean bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setGender(rs.getString(6));
			bean.setRoleid(rs.getLong(7));
			bean.setCreatedby(rs.getString(8));
			bean.setModifiedby(rs.getString(9));
			bean.setCreateddatetime(rs.getTimestamp(10));
			bean.setModifieddatetime(rs.getTimestamp(11));
			list.add(bean);
		}
		return list;
	}
	
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getconnection();
			 PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE ID=?");
			 ps.setLong(1, id);
			i =  ps.executeUpdate();
			
		} catch (Exception e) {
		}
		return i;
	}
}
