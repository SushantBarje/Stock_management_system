package App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import UI.Dashboard;
import UI.Login;
import UI.StaticViews;

public class StartApp {
	
	/**
	 * Constants variable declaration and initialization for user choices. 
	 * */
	public final static int LOGIN = 1;
	public final static int EXIT = 2;
	public final static int PURCHASE_STOCK = 3;
	public final static int VIEW_STOCK = 4;
	public final static int UPDATE_STOCK = 5;
	public final static int DELETE_STOCK = 6;
	public final static int PREV_PAGE = 7;
	public final static int SAVE_CHANGES = 8;
	
	/**
	 * Stream to read data.
	 * */
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 	Static View.
	 * */
	StaticViews staticViews;
	
	/**
	 * Constructor to display static View on console.
	 * */
	
	public StartApp() {
		staticViews = new StaticViews();
	}
	
	/**
	 * Login Page Authentication 
	 * @return boolean 
	 * if true move to admin dashboard page else go to authentication error page.
	 * */
	
	public void loginPage() throws IOException {
		if(Login.displayLoginScreen()) {
			this.adminDashboard();
		}else {
			this.wrongAuth();
		}
	}
	
	public void adminDashboard() {
		Dashboard dashboard = new Dashboard();
		dashboard.getDashboard();
	}
	
	public void wrongAuth() throws IOException {
		staticViews.getWrongPasswordPage();
		String s = br.readLine();
		this.loginPage();
	}
	
}
