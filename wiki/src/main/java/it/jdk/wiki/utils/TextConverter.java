package it.jdk.wiki.utils;

public class TextConverter {

	public static String convert(String input){
        input = input.replaceAll("\n"," <br/> ");
        String[] tokens = input.split(" ");
        for(int i=0;i<tokens.length;i++){
            if(isWikiWord(tokens[i])){
                tokens[i]=creaLink(tokens[i]);
            }
        }
        return componiToken(tokens);
    }
	private static String componiToken(String[] tokens){
        StringBuilder output = new StringBuilder();
        for(String token: tokens){
            output.append(token).append(" ");
        }
        return output.toString();
    }
	private static boolean isWikiWord(String word){
        if(word == null || word.length()<4){
            return false;
        }
        if(Character.isUpperCase(word.charAt(0)) && Character.isLowerCase(word.charAt(1)) &&
        !(word.substring(2).toLowerCase().equals(word.substring(2))) ){
            return true;
        }
        return false;
    }
	 private static String creaLink(String word){
	        return "<a href='main.action?titolo="+word+"'>"+word+"</a>"+
	                "<a href='edit.action?titolo="+word+"'>"+"#"+"</a>" ;
	 }
}
