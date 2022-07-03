package com.githrd.www.vo;

public class SingVO {
	private String gn, gen, name, stype;
	private char scode;
	private int no, num, s_type, gno;
	
	public String getGn() {
		return gn;
	}
	public void setGn(String gn) {
		this.gn = gn;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getS_type() {
		return s_type;
	}
	public void setS_type(int s_type) {
		this.s_type = s_type;
	}
	
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public char getScode() {
		return scode;
	}
	public void setScode(char scode) {
		this.scode = scode;
	}
	@Override
	public String toString() {
		return "SingVO [gn=" + gn + ", gen=" + gen + ", name=" + name + ", stype=" + stype + ", no=" + no + ", num="
				+ num + ", s_type=" + s_type + ", gno=" + gno + ", scode=" + scode + "]";
	}
	
	
	
}
