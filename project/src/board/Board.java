package board;

public class Board {
	private int board_num;
	private String board_sub;
	private String board_content; 
	private String board_date;
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_sub() {
		return board_sub;
	}
	public void setBoard_sub(String board_sub) {
		this.board_sub = board_sub;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	} 
}
