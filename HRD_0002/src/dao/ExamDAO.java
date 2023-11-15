package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.ExamDTO;
import util.OracleUtility;

//exam_tbl_03
public class ExamDAO {
	
	//시험 점수 입력
	public int insert(ExamDTO dto) throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "insert into exam_tbl_03 values(? , ? , ? , ? , ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getSno());
		ps.setInt(2, dto.getEkor());
		ps.setInt(3, dto.getEmath());
		ps.setInt(4, dto.getEeng());
		ps.setInt(5, dto.getEhist());
		
		int result = ps.executeUpdate();
		
		ps.close();
		conn.close();
		
		return result;
	}
}
