package in.co.online.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.online.Bean.EventTypeBean;
import in.co.online.Utility.JDBCDataSource;

public class EventTypeModel {

	public Integer nextpk() {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM eventtype");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {

		}
		return pk + 1;
	}

	public long add(EventTypeBean bean) throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getconnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO eventtype VALUES(?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getEventname());
			ps.setString(3, bean.getDescription());
			ps.setString(4, bean.getCreatedby());
			ps.setString(5, bean.getModifiedby());
			ps.setTimestamp(6, bean.getCreateddatetime());
			ps.setTimestamp(7, bean.getModifieddatetime());
			ps.executeUpdate();
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

	public List list() throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getconnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM eventtype");
		ResultSet rs = ps.executeQuery();
        while (rs.next()) {
			EventTypeBean  bean = new EventTypeBean();
			bean.setId(rs.getLong(1));
			bean.setEventname(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setCreatedby(rs.getString(4));
			bean.setModifiedby(rs.getString(5));
			bean.setCreateddatetime(rs.getTimestamp(6));
			bean.setModifieddatetime(rs.getTimestamp(7));
			list.add(bean);
			
		}
		return list;
	}

}
