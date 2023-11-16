package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.TestDTO;
import util.OracleUtility;

public class TestDAO {
	
	//테스트 종류 리스트 출력
	public List<TestDTO> getList() throws Exception {
		Connection conn = OracleUtility.getcConnection();
		String sql = "select t_code, t_name,\r\n" + 
				"	'[' || t_code || ']' || t_name as t_full\r\n" + 
				"from tbl_lab_test_202004\r\n" + 
				"order by t_full";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<TestDTO> list = new ArrayList<>();
		while(rs.next()) {
			TestDTO dto = new TestDTO(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3));
			list.add(dto);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	
}
