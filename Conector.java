
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Conector {
	private static Connection con;
	private static Conector INSTANCE = null;
	
	private Conector () {
	}
	
	private synchronized static void crearInstancia () {
		if (INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}
	
	public static Conector getInstancia () {
		if (INSTANCE == null) {
			crearInstancia ();
		}
		return INSTANCE;
	}
	
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "root";
		String password = "Ctignacio8";
		String dataBase = "restaurant";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlConexion = "jdbc:mysql://"+host+"/"+dataBase+"?"+"user="+user
					+"&password="+password;
			con= DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste :)");
		}catch(Exception e) {
			System.out.println("Error al conectar a la base de datos");
			
		}
	}
	
	public ArrayList<String> getVendors() throws SQLException{
		ArrayList<String> listaVendors = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("Select * from vendors");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaVendors.add(rs.getString("companyname"));
		}
		rs.close();
		return listaVendors;
	}
	
	public ArrayList <String> getNames() throws SQLException{
		ArrayList <String> listItems = new ArrayList<String>();
			PreparedStatement ps = con.prepareStatement("select name from items\r\n" + 
					"inner join partof on items.itemid = partof.itemid\r\n" + 
					"where partof.discount < 0.02");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listItems.add(rs.getString("name"));
		}
		rs.close();
		return listItems;
	}
	}
	
	//select name from items
	//inner join partof on items.itemid = partof.itemid
	//where partof.discount < 0.02



