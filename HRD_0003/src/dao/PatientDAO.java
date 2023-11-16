package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.PatientDTO;
import util.OracleUtility;

public class PatientDAO {
	
	//환자 조회
	public List<PatientDTO> getList() throws Exception {
		Connection conn = OracleUtility.getcConnection();
		String sql = "select p_no, p_name,\r\n" + 
				"		substr(p_birth,1,4) || '년' || substr(p_birth,5,2) || '월' || substr(p_birth,7) || '일' as p_birth,\r\n" + 
				"		case\r\n" + 
				"			when p_gender = 'M' then '남'\r\n" + 
				"			when p_gender = 'F' then '여'\r\n" + 
				"		end as p_gender,\r\n" + 
				"		p_tel1 || '-' || p_tel2 || '-' || p_tel3 as p_tel,\r\n" + 
				"		case\r\n" + 
				"			when p_city = '10' then '서울'\r\n" + 
				"			when p_city = '20' then '경기'\r\n" + 
				"			when p_city = '30' then '강원'\r\n" + 
				"			when p_city = '40' then '대구'\r\n" + 
				"		end as p_city\r\n" + 
				"from TBL_PATIENT_202004";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<PatientDTO> list = new ArrayList<>();		
		while(rs.next()) {
			PatientDTO dto = new PatientDTO(
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
	
	//지역별 검사 건수 리스트
	public List<PatientDTO> getTestCountList() throws Exception {
		Connection conn = OracleUtility.getcConnection();
		String sql = "select p_city,\r\n" + 
				"		case\r\n" + 
				"			when p_city = '10' then '서울'\r\n" + 
				"			when p_city = '20' then '경기'\r\n" + 
				"			when p_city = '30' then '강원'\r\n" + 
				"			when p_city = '40' then '대구'\r\n" + 
				"		end as cityName,\r\n" + 
				"count(*) as count\r\n" + 
				"from TBL_PATIENT_202004 a\r\n" + 
				"join tbl_result_202004 b\r\n" + 
				"on a.p_no = b.p_no\r\n" + 
				"group by p_city\r\n" + 
				"order by p_city";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<PatientDTO> list = new ArrayList<>();
		while(rs.next()) {
			PatientDTO dto = new PatientDTO(
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
