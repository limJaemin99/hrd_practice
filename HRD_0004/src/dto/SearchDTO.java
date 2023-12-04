package dto;

public class SearchDTO {
	private int resvno;
	private String name;
	private String gender;
	private String hospname;
	private String resvdate;
	private String resvtime;
	private String vcode;
	private String hospaddr;
	
	public SearchDTO() {}

	public SearchDTO(int resvno, String name, String gender, String hospname, String resvdate, String resvtime,
			String vcode, String hospaddr) {
		super();
		this.resvno = resvno;
		this.name = name;
		this.gender = gender;
		this.hospname = hospname;
		this.resvdate = resvdate;
		this.resvtime = resvtime;
		this.vcode = vcode;
		this.hospaddr = hospaddr;
	}

	public int getResvno() {
		return resvno;
	}

	public void setResvno(int resvno) {
		this.resvno = resvno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHospname() {
		return hospname;
	}

	public void setHospname(String hospname) {
		this.hospname = hospname;
	}

	public String getResvdate() {
		return resvdate;
	}

	public void setResvdate(String resvdate) {
		this.resvdate = resvdate;
	}

	public String getResvtime() {
		return resvtime;
	}

	public void setResvtime(String resvtime) {
		this.resvtime = resvtime;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getHospaddr() {
		return hospaddr;
	}

	public void setHospaddr(String hospaddr) {
		this.hospaddr = hospaddr;
	}
	
}
