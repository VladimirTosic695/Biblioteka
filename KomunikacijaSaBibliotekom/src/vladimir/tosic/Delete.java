package vladimir.tosic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username = "root";
		String password = "";
		
	try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Konekcija uspesna.");
			
			String delete = "DELETE FROM clanovi WHERE brojClanskeKarte = ?";
			
			PreparedStatement ps = conn.prepareStatement(delete);
			
			ps.setInt(1, 666);
			
			int unos = ps.executeUpdate();
			
			if(unos > 0) {
				System.out.println("Uspesno obrisani podaci.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
