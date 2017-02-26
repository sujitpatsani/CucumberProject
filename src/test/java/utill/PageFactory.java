package utill;

import java.util.HashMap;
import java.util.Map;

public class PageFactory {
	
	public static final Map<PAGE,Base> instances= new HashMap<PAGE,Base>();

	private PageFactory() {
		
	}
	
	public static synchronized Base pages(PAGE key){
		
		Base instance= instances.get(key);
		
		if(instance==null){
			
			String className=key.getClassName();
			try {
				instance= (Base) Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			instances.put(key, instance);
			
		}
		return instance;
		
	}
	
	
	

}
