package dto;

public class StudentDTO {
	private String sno;
	private String sname;
	private String sphone;
	private String sgender;
	private String saddress;
	
	private String grade;	//학년
	private String s_class;	//반 (class는 자바꺼라 s 붙임)
	private String num;		//번호
	
	
	public StudentDTO() {}
	public StudentDTO(String sno, String sname, String sphone, String sgender, String saddress) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sgender = sgender;
		this.saddress = saddress;
	}
	
	//학년, 반, 번호가 있는 생성자
	public StudentDTO(String sno, String sname, String grade, String s_class, String num, String sgender,
			String sphone, String saddress) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sgender = sgender;
		this.saddress = saddress;
		this.grade = grade;
		this.s_class = s_class;
		this.num = num;
	}
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
