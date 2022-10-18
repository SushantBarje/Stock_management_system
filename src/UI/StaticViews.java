package UI;

import java.util.ArrayList;
import App.Product;

public class StaticViews {
	
	public StaticViews() {
		this.banner();
	}
	
	public void banner() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t+----------------------- Stock Management System -----------------------+");
		System.out.println("\t\t\t\t\t\t\t\t==========================================================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public void getWrongPasswordPage() {
		this.banner();
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t\t\t   Incorrect username or password.\n");
		System.out.println("\t\t\t\t\t\t\t\t\t\t Do you want to continue. Y)Yes    any key)No");
	}
	
	public void dashboardView() {
		System.out.println("\t\t\t\t\t\t+---------------------------+-----------------------+-------------------------+-------------------------+");
		System.out.println("\t\t\t\t\t\t|                           |                       |                         |                         |");
		System.out.println("\t\t\t\t\t\t|       3) Add Stock        |     4) View Stock     |     5) Update Stock     |     6) Delete Stock     |");
		System.out.println("\t\t\t\t\t\t|                           |                       |                         |                         |");
		System.out.println("\t\t\t\t\t\t+---------------------------+-----------------------+-------------------------+-------------------------+");
	}
	
	public void addStockBannerView() {
		this.banner();
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t\t\t    ------- Add Stock -------");
		System.out.println("\t\t\t\t\t\t\t\t\t\t=================================");
		System.out.println("");
	}
	
	public void showAllStocksView(ArrayList<Product> stockList) {
		this.banner();
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t\t\t       ------- View Stock -------");
		System.out.println("\t\t\t\t\t\t\t\t\t\t    =================================");
		System.out.println("");
		System.out.println("");
		System.out.print("\t\t\t\t\t\t\t  For Edit product   :  Type E-[ID] ");
		System.out.println("\t\t\t For Delete product :  Type D-[ID] ");
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t   Press any key for back.");
		System.out.format("%30s+------------+-------------------------+---------------------+--------------------+--------------------+-------------------+--------------------+%n"," ");
		System.out.format("%30s|     ID     |       Product Name      |    Product Brand    |      Quantity      |   Price per Unit   |    Total Price    |    Supplier Name   |%n"," ");
		System.out.format("%30s+------------+-------------------------+---------------------+--------------------+--------------------+-------------------+--------------------+%n"," ");
	
		
		String leftAlignment = "%30s| %-10d | %-23s | %-19s | %18d | %14.2f Rs. | %13.2f Rs. | %-18s |%n";
		for(int i = 0; i < stockList.size(); i++) {
			Product product = stockList.get(i);
			System.out.format(leftAlignment," ", product.getProductId(), product.getProductName(), product.getProductBrand(), product.getProductQuantity(), product.getProductPricePerUnit(), product.getProductPriceTotal(), product.getSupplierName());
		}
		System.out.format("%30ss+------------+-------------------------+---------------------+--------------------+--------------------+-------------------+--------------------+%n"," ");
	}
	
	public void updateStockView() {
		this.banner();
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t\t\t      ------- Update Stock -------");
		System.out.println("\t\t\t\t\t\t\t\t\t\t    =================================");
		System.out.println("");
		System.out.println("");
		
	}
}




















