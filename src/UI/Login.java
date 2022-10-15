package UI;

import java.io.Console;

import java.util.*;

import App.*;

public class Login {
	
	public static boolean displayLoginScreen() {
		ClearConsole.clearConsole();
		StaticViews.banner();
		User user = new User();
		
		Console c = System.console();
		if(c == null) {
			System.out.println("NO console");
		}
		
		user.setUsername(c.readLine("\n\t\t\t\t\t\t\tEnter Username: "));
		System.out.println();
	
		user.setPassword(new String(c.readPassword("\t\t\t\t\t\t\tEnter Password: ")));
		Auth auth = new Auth();
		if(auth.auth_user(user.getUsername(), user.getPassword())){
			Dashboard dashboard = new Dashboard();
			ClearConsole.clearConsole();
			return true;
		}
		return false;
	}
	
}
