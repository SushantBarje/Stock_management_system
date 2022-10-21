package App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import UI.ClearConsole;
import UI.Dashboard;
import UI.Login;
import UI.StaticViews;

public class StartApp extends Stock{
	
	/**
	 * Constants variable declaration and initialization for user choices. 
	 * */
	public final static int ADD_STOCK = 1;
	public final static int VIEW_STOCK = 2;
	public final static int SELL_STOCK = 3;
	public final static int EXIT = 4;

	public void printLine(String s) {
		System.out.print(s);
	}
	
	public void printNLine(String s) {
		System.out.println(s);
	}
	
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
	
	public void adminDashboard() throws NumberFormatException, IOException {
		Dashboard dashboard = new Dashboard();
		dashboard.getDashboard();
		this.printLine("\n\t\t\t\t\t\t Enter Your Choice : ");
		int choice = Integer.parseInt(br.readLine());
		if(choice == ADD_STOCK) {
			this.addStock();
		}else if(choice == VIEW_STOCK) {
			this.viewStock();
		}else if(choice == SELL_STOCK) {
			this.sellStock();
		}else {
			System.exit(1);
		}
	}
	
	public void addStock() throws IOException {
		
		Product product = new Product();
		ClearConsole.clearConsole();
		staticViews.addStockBannerView();
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\tProduct Name           : ");
		product.setProductName(br.readLine());
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\tProduct Brand          : ");
		product.setProductBrand(br.readLine());
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\tProduct Quantity       : ");
		product.setProductQuantity(Integer.parseInt(br.readLine()));
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\tProduct Price Per Unit : ");
		product.setProductPricePerUnit(Double.parseDouble(br.readLine()));
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\tProduct Total Price    : "+ (product.getProductPricePerUnit() * product.getProductQuantity()));
		
		this.printNLine("");
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\tSupplier Name          : ");
		product.setSupplierName(br.readLine());
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t\tConfirm Add Stock ? ");
		this.printNLine("");
		this.printNLine("\t\t\t\t\t\t\t\t\t\t\t  Y) Yes    N) No");
		String choice = br.readLine();
		if(choice.toLowerCase().equals("y")) {
			if(Stock.addStockToDb(product)) {
				this.printNLine("");
				this.printLine("\t\t\t\t\t\t\t\t\t\t\t Stock Added..");
			}else {
				this.printNLine("");
				this.printLine("\t\t\t\t\t\t\t\t\t\t\t\t Stock Not Added...");
			}
			this.printNLine("");
			this.printLine("Press any key and enter to continue...");
			String s = br.readLine();
		}
		ClearConsole.clearConsole();
		this.adminDashboard();
	}
	
	
	public void viewStock() throws IOException {
		ClearConsole.clearConsole();
		staticViews.showAllStocksView(Stock.viewAllStocks(), 1);
		this.printNLine("");
		int lastChoice;
		int id = 0;
		while(true) {
			this.printLine("\t\t\t\t\t\t\t\t\t\t\t\tEnter your choice: ");
			String choice = new String(br.readLine());
			if(choice.length() <= 0) {
				ClearConsole.clearConsole();
				lastChoice = 1;
				break;
				
			}
			
			if(Pattern.matches("[DE]-[0-9]*", choice)) {
				String[] splitArray = choice.split("-");
				if(splitArray[0].toLowerCase().equals("e")) {
					lastChoice = 2;
					id = Integer.parseInt(splitArray[1]);
					break;
					
				}else {
					id = Integer.parseInt(splitArray[1]);
					lastChoice = 3;
					break;
				}
			}else {
				this.printNLine("\t\t\t\t\t\t\t\t\t\t\t\tYou entered wrong choice..");
				this.printNLine("");
			}
		}
		
		if(lastChoice == 1) {
			this.adminDashboard();
		}else if(lastChoice == 2) {
			this.editStock(id);
		}else {
			this.removeStock(id);
		}
		
	}
	
	public void editStock(int id) throws IOException {
		ClearConsole.clearConsole();
		Product product = Stock.getStockById(id);
		staticViews.updateStockView();
		this.printNLine("");
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t Product ID: " + product.getProductId());
		this.printNLine("");
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t Product Name : ( "+product.getProductName()+ " ) : ");
		String product_name = br.readLine().trim();
		if(product_name.length() > 0) {
			product.setProductName(product_name);
		}
		this.printNLine("");
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t Product Brand : ( "+product.getProductBrand()+ " ) : ");
		String product_brand = br.readLine().trim();
		if(product_brand.length() > 0) {
			product.setProductBrand(product_brand);
		}
		this.printNLine("");
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t Product Quantity : ( "+product.getProductQuantity()+ " ) : ");
		String product_quantity = br.readLine().trim();
		if(product_quantity.length() > 0) {
			product.setProductQuantity(Integer.parseInt(product_quantity));
		}
		this.printNLine("");
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t Product Price Per unit : ( "+product.getProductPricePerUnit()+ " ) : ");
		String product_price_per_unit = br.readLine().trim();
		if(product_price_per_unit.length() > 0) {
			product.setProductPricePerUnit(Double.parseDouble(product_price_per_unit));
		}
		this.printNLine("");
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t Product Total Price : "+product.getProductPricePerUnit()*product.getProductQuantity());
		product.setProductPriceTotal(product.getProductPricePerUnit()*product.getProductQuantity());
		this.printNLine("");
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t Supplier Name : ( "+product.getSupplierName()+ " ) : ");
		String supplier_name = br.readLine().trim();
		if(supplier_name.length() > 0) {
			product.setSupplierName(supplier_name);
		}
		
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t\tConfirm Update Stock ? ");
		this.printNLine("");
		this.printNLine("\t\t\t\t\t\t\t\t\t\t\t  Y) Yes    N) No");
		String choice = br.readLine();
		if(choice.toLowerCase().equals("y")) {
			if(Stock.updateStock(product)) {
				this.printNLine("");
				this.printLine("\t\t\t\t\t\t\t\t\t\t\t Stock Updated..");
			}else {
				this.printNLine("");
				this.printLine("\t\t\t\t\t\t\t\t\t\t\t\t Stock Not Updated...");
			}
			this.printNLine("");
			this.printLine("Press any key and enter to continue...");
			String s = br.readLine();
		}
		ClearConsole.clearConsole();
		this.adminDashboard();
		
	}
	
	public void removeStock(int id) throws IOException {
		this.printNLine("");
		this.printNLine("");
		this.printLine("\t\t\t\t\t\t\t\t\t\t\tConfirm Delete Stock ? ");
		this.printNLine("");
		this.printNLine("\t\t\t\t\t\t\t\t\t\t\t  Y) Yes    N) No");
		String choice = br.readLine();
		if(choice.toLowerCase().equals("y")) {
			if(Stock.deleteStock(id)) {
				this.printNLine("");
				this.printLine("\t\t\t\t\t\t\t\t\t\t\t Stock Deleted..");
			}else {
				this.printNLine("");
				this.printLine("\t\t\t\t\t\t\t\t\t\t\t\t Stock Not Deleted...");
			}
			this.printNLine("");
			this.printLine("Press any key and enter to continue...");
			String s = br.readLine();
		}
		ClearConsole.clearConsole();
		this.adminDashboard();
	}
	
	public void sellStock() throws IOException {
		ClearConsole.clearConsole();
		staticViews.showAllStocksView(Stock.viewAllStocks(), 2);
		this.printNLine("");
		int lastChoice;
		int id = 0;
		while(true) {
			this.printLine("\t\t\t\t\t\t\t\t\t\t\t\tEnter your choice: ");
			String choice = new String(br.readLine());
			if(choice.length() <= 0) {
				ClearConsole.clearConsole();
				lastChoice = 1;
				break;
				
			}
			
			if(Pattern.matches("[S]-[0-9]*", choice)) {
				String[] splitArray = choice.split("-");
				if(splitArray[0].toLowerCase().equals("s")) {
					lastChoice = 2;
					id = Integer.parseInt(splitArray[1]);
					break;
					
				}else {
					this.printNLine("\t\t\t\t\t\t\t\t\t\t\t\tYou entered wrong choice..");
					this.printNLine("");
				}
			}else {
				this.printNLine("\t\t\t\t\t\t\t\t\t\t\t\tYou entered wrong choice..");
				this.printNLine("");
			}
		}
		
		if(lastChoice == 1) {
			this.adminDashboard();
		}else if(lastChoice == 2) {
			this.printNLine("");
			Product product = Stock.getStockById(id);
			while(true) {
				this.printLine("\t\t\t\t\t\t\t\t\t\t\t\tEnter the Quantity : ");
				int quantity = 0;
				try {
					quantity = Integer.parseInt(br.readLine());
				}catch(Exception e) {
					ClearConsole.clearConsole();
					this.adminDashboard();
				}
				
				int totalQuantity = product.getProductQuantity()-quantity;
				if(totalQuantity < 0) {
					this.printNLine("");
					this.printLine("\t\t\t\t\t\t\t\t\t\t\t\t\tQuantity is greater than stock available !...");
					this.printNLine("");
				}else {
					this.printNLine("");
					this.printNLine("");
					this.printLine("\t\t\t\t\t\t\t\t\t\t\t\tTotal Price : " + product.getProductPricePerUnit()*quantity);
					this.printNLine("");
					this.printNLine("");
					this.printLine("\t\t\t\t\t\t\t\t\t\t\t\tConfirm Sell Stock ? ");
					this.printNLine("");
					this.printNLine("");
					this.printNLine("\t\t\t\t\t\t\t\t\t\t\t\t  Y) Yes    N) No");
					String choice = br.readLine();
					if(choice.toLowerCase().equals("y")) {
						if(Stock.sellStockFromDb(id, totalQuantity)) {
							this.printNLine("");
							this.printLine("\t\t\t\t\t\t\t\t\t\t\t Stock Sold..");
						}else {
							this.printNLine("");
							this.printLine("\t\t\t\t\t\t\t\t\t\t\t\t Stock Not Sold...");
						}
						this.printNLine("");
						this.printLine("Press any key and enter to continue...");
						String s = br.readLine();
					}
					ClearConsole.clearConsole();
					this.adminDashboard();
				}
			}
			
		}
		
	}
	
	public void wrongAuth() throws IOException {
		ClearConsole.clearConsole();
		staticViews.getWrongPasswordPage();
		this.printLine("\n\tEnter Your Choice: ");
		String s = br.readLine();
		if(s.toLowerCase().equals("y")) {
			this.loginPage();
		}
		System.exit(0);
	}
	
}
