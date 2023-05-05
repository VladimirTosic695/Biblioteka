package vladimir.tosic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username = "root";
		String password = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Konekcija uspesna.");
			
			String update = "UPDATE Clanovi SET ime = ? WHERE brojClanskeKarte = ?";
			
			PreparedStatement ps = conn.prepareStatement(update);
			
			ps.setString(1, "Dragan");
			ps.setInt(2, 666);
			
			int unos = ps.executeUpdate();
			
			if(unos > 0) {
				System.out.println("Uspesno azurirani podaci.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
