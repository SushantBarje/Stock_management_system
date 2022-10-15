package UI;

public class Dashboard {
	StaticViews staticViews;
	
	public Dashboard() {
		staticViews= new StaticViews();
	}
	
	public void getDashboard() {
		staticViews.dashboardView();
	}
}
