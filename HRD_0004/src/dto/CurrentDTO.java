package dto;

public class CurrentDTO {
	private String hospaddr;
	private String addrname;
	private int counts;
	
	public CurrentDTO() {}

	public CurrentDTO(String hospaddr, String addrname, int counts) {
		super();
		this.hospaddr = hospaddr;
		this.addrname = addrname;
		this.counts = counts;
	}

	public String getHospaddr() {
		return hospaddr;
	}

	public void setHospaddr(String hospaddr) {
		this.hospaddr = hospaddr;
	}

	public String getAddrname() {
		return addrname;
	}

	public void setAddrname(String addrname) {
		this.addrname = addrname;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}
	
}
