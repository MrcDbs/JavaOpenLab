package it.esercizi.controller;

public class EmailException extends Exception{
	
	public EmailException() {}
	
	public EmailException(String message) {super(message);}
	
	public EmailException(Throwable cause) {super(cause);}
	
	public EmailException(String message,Throwable cause) {super(message,cause);}

}
