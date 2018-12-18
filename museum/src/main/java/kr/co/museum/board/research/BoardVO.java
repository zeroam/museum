package kr.co.museum.board.research;

public class BoardVO {
	private int seq;
	private String cate;
	private String title;
	private String data_num;
	private String cls_material;
	private String cls_subject;
	private String cls_age;
	private String cls_location;
	private String location;
	private String size;
	private String traits;
	private String dona_date;
	private String img_src;
	private String img_name;
	private String extra2;
	private String extra3;
	
	// 페이지당 게시글 수
	public final static int BOARD_NUM = 15;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData_num() {
		return data_num;
	}
	public void setData_num(String data_num) {
		this.data_num = data_num;
	}
	public String getCls_material() {
		return cls_material;
	}
	public void setCls_material(String cls_material) {
		this.cls_material = cls_material;
	}
	public String getCls_subject() {
		return cls_subject;
	}
	public void setCls_subject(String cls_subject) {
		this.cls_subject = cls_subject;
	}
	public String getCls_age() {
		return cls_age;
	}
	public void setCls_age(String cls_age) {
		this.cls_age = cls_age;
	}
	public String getCls_location() {
		return cls_location;
	}
	public void setCls_location(String cls_location) {
		this.cls_location = cls_location;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTraits() {
		return traits;
	}
	public void setTraits(String traits) {
		this.traits = traits;
	}
	public String getDona_date() {
		return dona_date;
	}
	public void setDona_date(String dona_date) {
		this.dona_date = dona_date;
	}
	public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getExtra2() {
		return extra2;
	}
	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}
	public String getExtra3() {
		return extra3;
	}
	public void setExtra3(String extra3) {
		this.extra3 = extra3;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	
}
