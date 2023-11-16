package dto;

//tbl_patient_202004
public class PatientDTO {
	private String p_no;
	private String p_name;
	private String p_birth;
	private String p_gender;
	private String p_tel1;
	private String p_tel2;
	private String p_tel3;
	private String p_city;
	
	private String p_tel;	//전체 전화번호
	
	private String cityName;	//지역명
	private String count;		//검사건수
	
	public PatientDTO() {}
	public PatientDTO(String p_no, String p_name, String p_birth, String p_gender, String p_tel1, String p_tel2,
			String p_tel3, String p_city) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_birth = p_birth;
		this.p_gender = p_gender;
		this.p_tel1 = p_tel1;
		this.p_tel2 = p_tel2;
		this.p_tel3 = p_tel3;
		this.p_city = p_city;
	}
	
	//전화번호 합친 p_tel 전용 생성자
	public PatientDTO(String p_no, String p_name, String p_birth, String p_gender, String p_tel, String p_city) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_birth = p_birth;
		this.p_gender = p_gender;
		this.p_tel = p_tel;
		this.p_city = p_city;
	}
	
	//지역별 검사 건수 리스트용 생성자
	public PatientDTO(String p_city, String cityName, String count) {
		super();
		this.p_city = p_city;
		this.cityName = cityName;
		this.count = count;
	}
	
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_birth() {
		return p_birth;
	}
	public void setP_birth(String p_birth) {
		this.p_birth = p_birth;
	}
	public String getP_gender() {
		return p_gender;
	}
	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}
	public String getP_tel1() {
		return p_tel1;
	}
	public void setP_tel1(String p_tel1) {
		this.p_tel1 = p_tel1;
	}
	public String getP_tel2() {
		return p_tel2;
	}
	public void setP_tel2(String p_tel2) {
		this.p_tel2 = p_tel2;
	}
	public String getP_tel3() {
		return p_tel3;
	}
	public void setP_tel3(String p_tel3) {
		this.p_tel3 = p_tel3;
	}
	public String getP_city() {
		return p_city;
	}
	public void setP_city(String p_city) {
		this.p_city = p_city;
	}
	public String getP_tel() {
		return p_tel;
	}
	public void setP_tel(String p_tel) {
		this.p_tel = p_tel;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
