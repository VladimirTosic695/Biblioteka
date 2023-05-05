package vladimir.tosic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username = "root";
		String password = "";
		
		try(Connection connection = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Konekcija uspesna! ");
			
			String insert = "INSERT INTO clanovi(brojClanskeKarte, ime, prezime, "
					+ "datumRodjenja, telefon, ulica, broj, grad, bibliotekaID) VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(insert);
			
			ps.setInt(1, 666);
			ps.setString(2, "Vladimir");
			ps.setString(3, "Tosic");
			ps.setString(4, "11-09-1992");
			ps.setString(5, "064/333-55-66");
			ps.setString(6, "Sremska");
			ps.setString(7, "5");
			ps.setString(8, "Novi Sad");
			ps.setInt(9, 123456789);
			
			int unos = ps.executeUpdate();
			
			if(unos > 0) {
				System.out.println("Uspesno ste insertovali podatke. ");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
