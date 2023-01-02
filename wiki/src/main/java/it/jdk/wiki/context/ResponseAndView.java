package it.jdk.wiki.context;

public class ResponseAndView {
	
	protected String view;
	protected ResponseObject responseObject;
	
	public ResponseAndView() {}
	
	

	public ResponseAndView(String view, ResponseObject responseObject) {
		super();
		this.view = view;
		this.responseObject = responseObject;
	}



	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public ResponseObject getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(ResponseObject responseObject) {
		this.responseObject = responseObject;
	}
	
	

}
