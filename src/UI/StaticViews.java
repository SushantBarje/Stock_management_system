package UI;

public class StaticViews {
	
	public StaticViews() {
		StaticViews.banner();
	}
	
	public static void banner() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t+----------------------- Stock Management System -----------------------+");
		System.out.println("\t\t\t\t\t\t\t\t==========================================================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public void dashboardView() {
		System.out.println("\t\t\t\t\t\t+---------------------------+-----------------------+-------------------------+-------------------------+");
		System.out.println("\t\t\t\t\t\t|                           |                       |                         |                         |");
		System.out.println("\t\t\t\t\t\t|     3) Purchase Stock     |     4) View Stock     |     5) Update Stock     |     6) Delete Stock     |");
		System.out.println("\t\t\t\t\t\t|                           |                       |                         |                         |");
		System.out.println("\t\t\t\t\t\t+---------------------------+-----------------------+-------------------------+-------------------------+");
	}
	
	public void getWrongPasswordPage() {
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIncorrect username or password.");
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t Do you want to continue.");
	}
}
