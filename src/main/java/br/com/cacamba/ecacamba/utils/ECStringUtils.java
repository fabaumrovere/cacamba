package br.com.cacamba.ecacamba.utils;

public class ECStringUtils {

   public static String trim( String text ) {
	  
	  if( text == null ) {
		 return "";
	  }
	  
	  return text.trim();
   }

   public static boolean isEmpty( String text ) {
	  
	  if( text == null ) {
		 return true;
	  }
	  
	  return text.trim().length() > 0;
   }
}
