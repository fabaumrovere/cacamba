package br.com.cacamba.ecacamba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacambaApplication {

   public static void main(String[] args) {
	  try {
		 SpringApplication.run(CacambaApplication.class, args);
	  } catch (Throwable e) {
		 if (e.getClass().getName().contains("SilentExitException")) {
//			Logger.debug("Spring is restarting the main thread - See spring-boot-devtools");
		 } else {
//			Logger.error("Application crashed!", e);
		 }
	  }
   }

}
