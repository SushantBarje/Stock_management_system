package UI;

import java.io.IOException;

public class ClearConsole {
	public static void clearConsole() {
		try {
	        if (System.getProperty("os.name").contains("Windows")) {
	        	System.out.println("s");
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else {
	        	System.out.println("d");
	            System.out.print("\033\143");
	        }
	    } catch (IOException | InterruptedException  ex) {
	    	System.out.println("Exception");
	    }
	}
}
