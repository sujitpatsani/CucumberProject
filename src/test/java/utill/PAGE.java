package utill;

public enum PAGE {
	
	HOMEPAGE("utill.HomePage"),
	BOOKBUSPAGE("utill.BookBusPage");
	String className;
	
	PAGE(String className){
		this.className=className;
	}
	
	public String getClassName(){
		return className;
	}
	}
