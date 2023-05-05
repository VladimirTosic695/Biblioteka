package vladimir.tosic;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {

			System.out.println("Konekcija ka bazi uspostavljena. ");

			Statement stmt = connection.createStatement();
			String upit = "Select * From Clanovi";

			ResultSet result = stmt.executeQuery(upit);

			int brojac = 1;
			while (result.next()) {

				System.out.println("\nPodaci o " + brojac + ". clanu.");

				String brojClanske = "\nBroj clasnke karte: " + result.getInt(1);
				String ime = "\nIme: " + result.getString(2);
				String prezime = "\nPrezime: " + result.getString(3);
				String datumRodjenja = "\nDatum rodjenja: " + result.getString(4);
				String telefon = "\nTelefon: " + result.getString(5);
				String ulica = "\nUlica: " + result.getString(6);
				String broj = "\nBroj: " + result.getString(7);
				String grad = "\nGrad: " + result.getString(8);
				String biblioteka = "\nBiblioteka ID: " + result.getString(9);

				StringBuilder sb = new StringBuilder();

				sb.append(brojClanske);
				sb.append(ime);
				sb.append(prezime);
				sb.append(datumRodjenja);
				sb.append(telefon);
				sb.append(ulica);
				sb.append(broj);
				sb.append(grad);
				sb.append(biblioteka);

				System.out.println(sb.toString());

				brojac++;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
