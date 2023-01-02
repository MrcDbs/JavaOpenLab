package it.jdk.wiki.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RequestObject {
	
	protected Map<String,Object> request = new HashMap<>();
	protected Map<String,Object> session = new HashMap<>();
	protected String requestComand;
	
	protected RequestObject() {}
	
	public void setValue(String key,Object value){request.put(key,value);}
	
	public void setValueInSession(String key,Object value) {session.put(key,value);}
	
	
	public Object getValue(String key) {
		Object value = request.get(key);
		if(value==null) {
			return value = session.get(key);
		}
		if(value instanceof Object[]) {
			value = ((Object[])value)[0];
		}
		return value;
	}
	
	public String getRequestComand() {
		return requestComand;
	}

	public void setRequestComand(String requestComand) {
		this.requestComand = requestComand;
	}

	public Set<String> getRequestKeys(){
		return request.keySet();
	}
	
	public Set<String> getSessionKeys(){
		return session.keySet();
	}
		
}
