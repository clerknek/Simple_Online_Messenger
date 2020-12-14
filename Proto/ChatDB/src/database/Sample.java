package database;

// 코드 수행 전 아래 명령을 command 창에 입력해서 코드에서 사용하는 데이터베이스 생성
// $ mysql -uroot -p000110 -e 'CREATE SCHEMA testdb'
// 아래 명령으로 해당 database가 생성된 것을 확인
// $ mysql -uroot -p000110 -e 'SHOW databases'

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Sample {

	public Sample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		createTable();
		post();
		get();
		delete();
	}
	
	public static ArrayList<String> get() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT first,last FROM testtable");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("first"));
				System.out.print(" ");
				System.out.println(result.getString("last"));
				
				array.add(result.getString("last"));
			}
			System.out.println("All records have been selected!");
			return array;
		} catch(Exception e) {System.out.println(e);}
		return null;
		
	}

	
	public static void delete() throws Exception{
		final String var1 = "John";
		final String var2 = "Miller";
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM testtable WHERE first = '"+var1 + "' AND last = '" + var2 +"'");
			posted.executeUpdate();
		} catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("delete Completed.");
		}
		
		// 함수 수행 후 아래 명령으로 해당 데이터 생성 여부확인 가능
		// $ mysql -uroot -p000110 -e 'SELECT * FROM testdb.testtable'
	}
	
	
	
	public static void post() throws Exception{
		final String var1 = "John";
		final String var2 = "Miller";
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO testtable (first, last) VALUES ('"+var1 + "','" + var2 +"')");
			posted.executeUpdate();
		} catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Insert Completed.");
		}
		
		// 함수 수행 후 아래 명령으로 해당 데이터 생성 여부확인 가능
		// $ mysql -uroot -p000110 -e 'SELECT * FROM testdb.testtable'
	}

	public static void createTable() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS testtable(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();
		} catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Function complete.");};
		
		// 함수 수행 후 아래 명령으로 해당테이블 생성 여부확인 가능
		// $ mysql -uroot -p000110 -e 'DESCRIBE testdb.testtable'
	}
	
	public static Connection getConnection() throws Exception{
		// 함수 수행 전 아래 명령으로 해당 데이터베이스 존재 여부 & 접근 가능 확인 가능
		// $ mysql -uroot -p000110 -e 'SHOW DATABASES'

		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "root";
			String password = "000110";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {System.out.println(e);}
		
		System.out.println("Not Connected");
		return null;
		
	}

}
