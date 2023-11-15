package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ScoreDTO;
import util.OracleUtility;

//학생 성적을 출력하기 위한 DAO
public class ScoreDAO {
	
	//학생 성적 출력
	public List<ScoreDTO> getScore() throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "select a.grade, a.class, a.num, a.sname,\r\n" + 
				"		b.ekor, b.emath, b.eeng, b.ehist, b.total, b.average, b.rank\r\n" + 
				"from\r\n" + 
				"	(select sno,\r\n" + 
				"			substr(sno,1,1) as grade,\r\n" + 
				"			substr(sno,2,2) as class,\r\n" + 
				"			substr(sno,4,2) as num,\r\n" + 
				"			sname\r\n" + 
				"		from STUDENT_TBL_03\r\n" + 
				"		order by sno) a\r\n" + 
				"left join\r\n" + 
				"	(select sno, ekor, emath, eeng, ehist,\r\n" + 
				"			ekor + emath + eeng + ehist as total,\r\n" + 
				"			(ekor + emath + eeng + ehist)/4 as average,\r\n" + 
				"			dense_rank() over(order by (ekor + emath + eeng + ehist)/4 desc) as rank\r\n" + 
				"		from exam_tbl_03) b\r\n" + 
				"on a.sno = b.sno";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<ScoreDTO> list = new ArrayList<>();
		while(rs.next()) {
			ScoreDTO dto = new ScoreDTO(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5) != null ? rs.getString(5) : "",
					rs.getString(6) != null ? rs.getString(6) : "",
					rs.getString(7) != null ? rs.getString(7) : "",
					rs.getString(8) != null ? rs.getString(8) : "",
					rs.getString(9) != null ? rs.getString(9) : "",
					rs.getString(10) != null ? rs.getString(10) : "",
					rs.getString(11) != null ? rs.getString(11) : "");
			list.add(dto);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	
	/*
	 	[SQL] ▶ 자세한 내용은 [SQL 성적 출력.txt 참고]
	 	select a.grade, a.class, a.num, a.sname,
				b.ekor, b.emath, b.eeng, b.ehist, b.total, b.average, b.rank
		from
			(select sno,
					substr(sno,1,1) as grade,
					substr(sno,2,2) as class,
					substr(sno,4,2) as num,
					sname
				from STUDENT_TBL_03
				order by sno) a
		left join
			(select sno, ekor, emath, eeng, ehist,
					ekor + emath + eeng + ehist as total,
					(ekor + emath + eeng + ehist)/4 as average,
					dense_rank() over(order by (ekor + emath + eeng + ehist)/4 desc) as rank
				from exam_tbl_03) b
		on a.sno = b.sno;
	 */
}
