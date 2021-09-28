package kr.kedu.java01.spms.vo;

import java.util.Date;

public class MemberVO {
	private int no;
	private String name;
	private String email;
	private String password;
	private Date createDate;
	private Date modifiedDate;
	
	
	public int getNo() {
		return no;
	}	public MemberVO setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberVO setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberVO setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public MemberVO setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public MemberVO setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}

	
	
	
	

}
