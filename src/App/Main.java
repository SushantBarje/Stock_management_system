package App;

import UI.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

import Database.*;


public class Main {

	public static void main(String[] args) throws IOException {
		StartApp startApp = new StartApp();
		startApp.loginPage();
	}
}
