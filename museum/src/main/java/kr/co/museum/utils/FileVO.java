package kr.co.museum.utils;

public class FileVO {
	private int seq;
	private String board_cate;
	private int board_seq;
	private String origin_name;
	private String stored_name;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBoard_cate() {
		return board_cate;
	}
	public void setBoard_cate(String board_cate) {
		this.board_cate = board_cate;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getOrigin_name() {
		return origin_name;
	}
	public void setOrigin_name(String orgin_name) {
		this.origin_name = orgin_name;
	}
	public String getStored_name() {
		return stored_name;
	}
	public void setStored_name(String stored_name) {
		this.stored_name = stored_name;
	}
	
}
