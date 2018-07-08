package rate;

import java.sql.SQLException;
import java.util.Vector;

import org.apache.commons.math3.random.RandomDataGenerator;

import DB.DAO;
import DB.DBEngine;

public class RandomRateGenerator {

	private static DBEngine mDBEngine = null;
	private static DAO mDAO;

	private static String userName = "root";
	private static String password = "root";

	public static void main(String[] args) {

		// setup DB connection
		mDBEngine = new DBEngine("jdbc:mysql://localhost:3306/rates", userName, password);

		// TODO Auto-generated method stub
		String a = "INSERT INTO DTT_TermPremium VALUES ";
		String printString = "";

		try {
			mDBEngine.EstablishConnection();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Could not connect!\nCheck username and/or password and try again!");
		}

		if (mDBEngine.getConnection() != null) {
			System.out.println("DB Connection to jdbc:mysql://localhost:3306/rates has been estabalished!");
		}

		mDAO = new DAO(mDBEngine.getConnection());
		Vector<Vector<String>> mResults = new Vector<Vector<String>>();

		String mQuery = "SELECT * FROM rates.DTT_TermPremium LIMIT 0, 10";

		System.exit(0);

		for (int i = 1; i < 100; i++) {

			double generatedDouble = Math.random();
			int generatedInteger = new RandomDataGenerator().nextInt(0, 300);

			int covTerm = new RandomDataGenerator().nextInt(1, 4) * 5;

			// System.out.println(generatedInteger + generatedDouble);

			double rate = generatedInteger + generatedDouble;
			printString += a + "('TT0'," + covTerm + ",'F','N','1980-01-01','9999-12-31'," + i + "," + rate + ");";

			// insert into DB

			printString = "";

			try {

				mDAO.runUpdate(printString);
			} catch (SQLException e) {
				System.out.println("Could not execute query!");
			}

			if (i % 10000 == 0) {
				// System.out.println("current count is " + i);

				System.gc();
			}

		}

		// printString = printString.substring(0, printString.length() - 1);

		// System.out.println(printString + ";");
	}

}
// fn
// fs
// mn
// ms

// have an interace called RateTable and it should allow query of rate