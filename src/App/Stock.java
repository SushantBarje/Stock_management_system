package App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DbConnection;

public class Stock {
	
	
	public static boolean addStockToDb(Product product) {
		Connection conn = DbConnection.connectDb();
		String query = "INSERT INTO stock(product_name, product_brand, product_quantity, product_price_per_unit,supplier_name) VALUES(?,?,?,?,?)";
		try {
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductBrand());
			stmt.setInt(3, product.getProductQuantity());
			stmt.setDouble(4, product.getProductPricePerUnit());
			stmt.setString(5, product.getSupplierName());
			
			int result = stmt.executeUpdate();
			System.out.println(result);
			if(result >= 1) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<Product> viewAllStocks(){
		Connection conn = DbConnection.connectDb();
		String query = "SELECT * FROM stock";
		ArrayList<Product> stockList = new ArrayList<Product>();
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Product product = new Product();
				product.setProductId(result.getInt(1));
				product.setProductName(result.getString(2));
				product.setProductBrand(result.getString(3));
				product.setProductQuantity(result.getInt(4));
				product.setProductPricePerUnit(result.getDouble(5));
				product.setProductPriceTotal(product.getProductPricePerUnit()*product.getProductQuantity());
				product.setSupplierName(result.getString(6));
				stockList.add(product);
			}
			return stockList;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Product getStockById(int id) {
		Product product = new Product();
		
		Connection conn = DbConnection.connectDb();
		String query = "SELECT * FROM stock WHERE product_id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,id);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				product.setProductId(result.getInt(1));
				product.setProductName(result.getString(2));
				product.setProductBrand(result.getString(3));
				product.setProductQuantity(result.getInt(4));
				product.setProductPricePerUnit(result.getDouble(5));
				product.setProductPriceTotal(product.getProductPricePerUnit()*product.getProductQuantity());
				product.setSupplierName(result.getString(6));
			}
			return product;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean updateStock(Product product) {
		Connection conn = DbConnection.connectDb();
		String query = "UPDATE stock SET product_name = ? , product_brand = ? , product_quantity = ? , product_price_per_unit = ? , supplier_name = ? WHERE product_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductBrand());
			stmt.setInt(3, product.getProductQuantity());
			stmt.setDouble(4, product.getProductPricePerUnit());
			stmt.setString(5, product.getSupplierName());
			stmt.setInt(6, product.getProductId());
			int result = stmt.executeUpdate();
			if(result > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteStock(int id) {
		Connection conn = DbConnection.connectDb();
		String query = "DELETE FROM stock WHERE product_id = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			int result = stmt.executeUpdate();
			return result > 0 ? true : false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean sellStockFromDb(int id, int quantity) {
		Connection conn = DbConnection.connectDb();
		String query = "UPDATE stock SET product_quantity = ? WHERE product_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,quantity);
			stmt.setInt(2, id);
			int result = stmt.executeUpdate();
			if(result > 0 ) {
				return true;
			}
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
