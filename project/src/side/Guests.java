package side;
//POJO

import java.util.Date;

public class Guests {

	private int age;
	private String name;
	private String email;
	private long mobile;
	private Date CheckIn_Date;
	private Date CheckOut_Date;

	public Guests() {
		// TODO Auto-generated constructor stub
	}

	public Guests(String name, int age, String email, long mobile, Date CheckIn_Date, Date CheckOut_Date) {
		super();
		this.age = age;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.CheckIn_Date = CheckIn_Date;
		this.CheckOut_Date = CheckOut_Date;
	}
	
	public Guests(Long mobile2, String email2) {
		super();
		this.mobile=mobile2;
		this.email=email2;
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Date getInDate() {
		return CheckIn_Date;
	}

	public void setInDate(Date CheckIn_Date) {
		this.CheckIn_Date = CheckIn_Date;
	}
	

	public Date getOutDate() {
		return CheckIn_Date;
	}

	public void setOutDate(Date CheckOut_Date) {
		this.CheckOut_Date = CheckOut_Date;
	}
	
	@Override
	public String toString() {
		return "Guests [age=" + age + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", CheckIn_Date="
				+ CheckIn_Date + ", CheckOut_Date=" + CheckOut_Date + "]";
	}

}
