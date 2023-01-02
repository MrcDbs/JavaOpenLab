package it.jdk.wiki.controller;

import java.io.FileInputStream;
import java.util.Properties;

import jakarta.servlet.ServletConfig;

public class Configuration {

	protected static Properties views;
	protected static Properties actions;
	protected static Properties mail;
	
	public static void init(ServletConfig config) {
		String actionFile = config.getServletContext().getRealPath("WEB-INF/actions.properties");
		String viewFile = config.getServletContext().getRealPath("WEB-INF/views.properties");
		String mailFile = config.getServletContext().getRealPath("WEB-INF/config.properties");
		
		views = new Properties();
		actions = new Properties();
		mail = new Properties();
		try {
			views.load(new FileInputStream(viewFile));
			actions.load(new FileInputStream(actionFile));
			mail.load(new FileInputStream(mailFile));
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static String getViewPage(String view) {return views.getProperty(view);}
	
	public static String getAction(String action) {return actions.getProperty(action);}
	
	public static String getMailValue(String value) {return mail.getProperty(value);}
}

