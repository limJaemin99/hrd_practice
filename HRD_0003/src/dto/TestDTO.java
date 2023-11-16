package dto;

//tbl_lab_test_202004
public class TestDTO {
	private String t_code;
	private String t_name;
	
	private String t_full;	//[코드]검사명 형식
	
	public TestDTO() {}
	public TestDTO(String t_code, String t_name) {
		super();
		this.t_code = t_code;
		this.t_name = t_name;
	}
	
	//코드 + [코드]검사명 형식 t_full 전용 생성자
	public TestDTO(String t_code, String t_name, String t_full) {
		super();
		this.t_code = t_code;
		this.t_name = t_name;
		this.t_full = t_full;
	}
	
	public String getT_code() {
		return t_code;
	}
	public void setT_code(String t_code) {
		this.t_code = t_code;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_full() {
		return t_full;
	}
	public void setT_full(String t_full) {
		this.t_full = t_full;
	}
	
}
