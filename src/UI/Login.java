package UI;

import java.io.Console;

import App.User;

public class Login {
	
	public static void displayLoginScreen() {
		ClearConsole.clearConsole();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t\t\t********************* Welcome to Stocker *********************");
		System.out.println();
		User user = new User();
		
		Console c = System.console();
		if(c == null) {
			System.out.println("NO console");
		}
		
		user.setUsername(c.readLine("\n\t\t\t\t\t\t\tEnter Username: "));
		System.out.println();
	
		user.setPassword(new String(c.readPassword("\t\t\t\t\t\t\tEnter Password: ")));
	}
	
}
