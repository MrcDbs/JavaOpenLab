package it.jdk.wiki.controller;

public class MyWikiException extends Exception{
	
	public MyWikiException() {}
	
	public MyWikiException(String message) {super(message);}
	
	public MyWikiException(Throwable cause) {super(cause);}
	
	public MyWikiException(String message,Throwable cause) {super(message,cause);}

}
