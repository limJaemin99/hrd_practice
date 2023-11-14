package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;
import util.OracleUtility;

//TBL_MEMBER_202005
public class MemberDAO {
	
	//후보 조회
	public List<MemberDTO> getList() throws SQLException {
		Connection conn = OracleUtility.getConnection();
		String sql = "SELECT * FROM TBL_MEMBER_202005";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<MemberDTO> list = new ArrayList<>();
		while(rs.next()) {
			//list.add(new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			MemberDTO dto = new MemberDTO(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6));
			list.add(dto);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	
	
	
}
