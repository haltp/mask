package co.mask.board.vo;

import java.sql.Date;

public class BoardVo {
	private int boardNumber;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardFile; // 새로추가
	private Date boardDate;
	private int boardLock;
	private String boardValue;
	private int boardHit;
	
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardLock() {
		return boardLock;
	}
	public void setBoardLock(int boardLock) {
		this.boardLock = boardLock;
	}
	public String getBoardValue() {
		return boardValue;
	}
	public void setBoardValue(String boardValue) {
		this.boardValue = boardValue;
	}
	public int getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}
	
	
	
	
	
}