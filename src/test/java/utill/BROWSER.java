package utill;

public enum BROWSER {	
	
	FIREFOX("firefox"),
	CHROME("chrome"),
	IE("ie");
	
	String browsername;
	
	BROWSER(String browsername){
		this.browsername=browsername;
		}
	public String getBrowserName(){
		return browsername;
	}
	

}
