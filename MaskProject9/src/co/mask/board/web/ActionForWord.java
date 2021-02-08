package co.mask.board.web;

public class ActionForWord {
	private boolean isRedirect = false;
	private String nextPath = null; // 이동할 다음 화면
	
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getNextPath() {
		return nextPath;
	}
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
	
}
