package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.CurrentDTO;
import dto.SearchDTO;
import dto.VaccresvDTO;
import util.OracleUtility;

public class VaccresvDAO {
	
	//예약번호 출력
	public int getResvNo() throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "SELECT Max(resvno)+1 FROM tbl_vaccresv";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		int result = 0;
		
		while(rs.next()) {
			result = rs.getInt(1);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return result;
	}
	
	//예약 등록
	public void regist(VaccresvDTO dto) throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "INSERT INTO tbl_vaccresv VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, dto.getResvno());
		ps.setString(2, dto.getJumin());
		ps.setString(3, dto.getHospcode());
		ps.setString(4, dto.getResvdate());
		ps.setInt(5, dto.getResvtime());
		ps.setString(6, dto.getVcode());
		
		ps.execute();
		
		ps.close();
		conn.close();
	}
	
	//예약 여부 조회
	public int isReserved(int resvno) throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "SELECT Count(*) FROM tbl_vaccresv WHERE resvno = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, resvno);

		ResultSet rs = ps.executeQuery();
		
		int result = 0;
		
		while(rs.next()) {
			result = rs.getInt(1);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return result;
	}
	
	//예약 내역 조회
	public SearchDTO getReserveInfo(int resvno) throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "select resvno, name, gender, hospname, resvdate, resvtime, vcode, hospaddr\r\n" + 
				"from tbl_hosp a\r\n" + 
				"join(\r\n" + 
				"	select a.resvno, name, \r\n" + 
				"			case\r\n" + 
				"				when substr(a.jumin,8,1)='1' then '남'\r\n" + 
				"				when substr(a.jumin,8,1)='2' then '여'\r\n" + 
				"			end as gender,\r\n" + 
				"			hospcode, to_char(resvdate, 'yyyymmdd') as resvdate, resvtime, vcode\r\n" + 
				"	from tbl_vaccresv a\r\n" + 
				"	join tbl_jumin b\r\n" + 
				"	on a.jumin = b.jumin\r\n" + 
				"	where resvno = ?) b\r\n" + 
				"on a.hospcode = b.hospcode";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, resvno);
		
		ResultSet rs = ps.executeQuery();
		
		SearchDTO dto = new SearchDTO();
		
		while(rs.next()) {
			String name = rs.getString(2);
			String gender = rs.getString(3);
			String hospname = rs.getString(4);
			String resvdate = rs.getString(5);
			String resvtime = rs.getString(6);
			String vcode = rs.getString(7);
			String hospaddr = rs.getString(8);
			
			String year = resvdate.substring(0,4);
			String month = resvdate.substring(4,6);
			String date = resvdate.substring(6);
			resvdate = year + "년" + month + "월" + date + "일";
			
			if(resvtime.length() == 3) resvtime = "0"+resvtime;
			String hour = resvtime.substring(0,2);
			String minute = resvtime.substring(2);
			resvtime = hour + ":" + minute;
			
			switch(vcode) {
			case "V001" :
				vcode = "A백신";
				break;
			case "V002" :
				vcode = "B백신";
				break;
			case "V003" :
				vcode = "C백신";
				break;
			}
			
			switch(hospaddr) {
			case "10" :
				hospaddr = "서울";
				break;
			case "20" :
				hospaddr = "대전";
				break;
			case "30" :
				hospaddr = "대구";
				break;
			case "40" :
				hospaddr = "광주";
				break;
			}
			
			dto = new SearchDTO(resvno, name, gender, hospname, resvdate, resvtime, vcode, hospaddr);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return dto;
	}
	
	//백신 예약 현황 조회
	public List<CurrentDTO> getCurrentView() throws Exception {
		Connection conn = OracleUtility.getConnection();
		String sql = "select hospaddr, addrname, counts\r\n" + 
				"from (\r\n" + 
				"	select hospcode, hospaddr,\r\n" + 
				"			case\r\n" + 
				"				when hospaddr = '10' then '서울'\r\n" + 
				"				when hospaddr = '20' then '대전'\r\n" + 
				"				when hospaddr = '30' then '대구'\r\n" + 
				"				when hospaddr = '40' then '광주'\r\n" + 
				"			end as addrname\r\n" + 
				"	from tbl_hosp) a\r\n" + 
				"left join (\r\n" + 
				"	select hospcode, count(*) as counts\r\n" + 
				"	from tbl_vaccresv\r\n" + 
				"	group by (hospcode)\r\n" + 
				"	order by hospcode\r\n" + 
				") b\r\n" + 
				"on a.hospcode = b.hospcode";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<CurrentDTO> list = new ArrayList<>();
		
		while(rs.next()) {
			CurrentDTO dto = new CurrentDTO(
					rs.getString(1),
					rs.getString(2),
					rs.getInt(3));
			list.add(dto);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
}
