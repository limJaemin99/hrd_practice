package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ResultDTO;
import util.OracleUtility;

public class ResultDAO {
	
	//검사 결과 insert
	public int insert(ResultDTO dto) throws Exception {
		Connection conn = OracleUtility.getcConnection();
		String sql = "INSERT INTO tbl_result_202004 VALUES (? , ? , ? , ? , ? , ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getP_no());
		ps.setString(2, dto.getT_code());
		ps.setString(3, dto.getT_sdate());
		ps.setString(4, dto.getT_status());
		ps.setString(5, dto.getT_ldate());
		ps.setString(6, dto.getT_result());
		
		int result = ps.executeUpdate();
		
		ps.close();
		conn.close();
		
		return result;
	}
	
	
	//검사 결과 조회 리스트
	public List<ResultDTO> getList() throws Exception {
		Connection conn = OracleUtility.getcConnection();
		String sql = "select a.p_no, p_name, b.t_name, b.t_sdate, b.t_status, b.t_ldate, b.t_result\r\n" + 
				"from TBL_PATIENT_202004 a\r\n" + 
				"join (select p_no, t_name,\r\n" + 
				"			to_char(t_sdate,'yyyy-mm-dd') as t_sdate,\r\n" + 
				"			case\r\n" + 
				"				when t_status = '1' then '검사중'\r\n" + 
				"				when t_status = '2' then '검사완료'\r\n" + 
				"			end as t_status,\r\n" + 
				"			to_char(t_ldate,'yyyy-mm-dd') as t_ldate,\r\n" + 
				"			case\r\n" + 
				"				when t_result = 'X' then '미입력'\r\n" + 
				"				when t_result = 'P' then '양성'\r\n" + 
				"				when t_result = 'N' then '음성'\r\n" + 
				"			end as t_result\r\n" + 
				"		from tbl_result_202004 a\r\n" + 
				"		join tbl_lab_test_202004 b\r\n" + 
				"		on a.t_code = b.t_code\r\n" + 
				"		order by p_no) b\r\n" + 
				"on a.p_no = b.p_no";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<ResultDTO> list = new ArrayList<>();
		while(rs.next()) {
			ResultDTO dto = new ResultDTO(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7));
			list.add(dto);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	
}
