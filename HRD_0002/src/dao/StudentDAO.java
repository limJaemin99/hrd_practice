package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.StudentDTO;
import util.OracleUtility;

//STUDENT_TBL_03
public class StudentDAO {
	
	//학생 목록 출력
	public List<StudentDTO> getList() throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "select sno,\r\n" + 
				"	sname,\r\n" + 
				"	substr(sno,1,1) as grade,\r\n" + 
				"	substr(sno,2,2) as class,\r\n" + 
				"	substr(sno,4,2) as num,\r\n" + 
				"	case\r\n" + 
				"		when sgender = 'M' then '남'\r\n" + 
				"		when sgender = 'F' then '여'\r\n" + 
				"	end as sgender,\r\n" + 
				"	sphone,\r\n" + 
				"	saddress\r\n" + 
				"from STUDENT_TBL_03";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<StudentDTO> list = new ArrayList<>();
		while(rs.next()) {
			StudentDTO dto = new StudentDTO(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8));
			
			list.add(dto);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	
	/*
	 	[SQL]
	 	select sno,
			sname,
			substr(sno,1,1) as grade,	-- substr(대상,~번째부터,~개) 문자열 추출
			substr(sno,2,2) as class,
			substr(sno,4,2) as num,
			case
				when sgender = 'M' then '남'
				when sgender = 'F' then '여'
			end as sgender,
			sphone,
			saddress
		from STUDENT_TBL_03;
	 */
	
}
