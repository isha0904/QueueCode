package uce2022447;

import java.sql.*;
import java.util.*;

public class myJDBC {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/anu447";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String query;
		Scanner sc = new Scanner(System.in);
		int mid, phno;
		boolean sub_loop;
		String name, address, dept;

		try {

			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				boolean loop = true;
				do {
					int choice = 0;
//				MENU
					System.out.println("Enter\tTo\n" + "1\tInsert\n" + "2\tDelete\n" + "3\tUpdate\n" + "4\tSearch\n"
							+ "5\tDisplay ALL\n" + "0\tEXIT\n");
					choice = sc.nextInt();
					sc.nextLine();

					switch (choice) {

					case 1:
//					1. Insert
						System.out.println("============INSERT============");

						query = "INSERT INTO members(mid,mname,aadr,phno,department) values (?,?,?,?,?)";
						pstmt = conn.prepareStatement(query);
						System.out.println("Enter Member id:");
						mid = sc.nextInt();
						sc.nextLine();

						System.out.println("Enter Member Name:");
						name = sc.next();
						name = name.toUpperCase();

						System.out.println("Address:");
						address = sc.next();

						System.out.println("Phone number:");
						phno = sc.nextInt();
						sc.nextLine();

						System.out.println("Department:");
						dept = sc.next();

						pstmt.setInt(1, mid);
						pstmt.setString(2, name);
						pstmt.setString(3, address);
						pstmt.setInt(4, phno);
						pstmt.setString(5, dept);

						pstmt.executeUpdate();

						System.out.println("Record added successfully");
						break;

					case 2:
//					2. Delete
						sub_loop = true;
						do {
							System.out.println("============DELETE============");

							int sub_choice = sc.nextInt();
							sc.nextLine();

							System.out
									.println("Enter\tTo DELETE Member BY\n" + "1\tID\n" + "2\tName\n" + "0\tGO BACK\n");
							switch (sub_choice) {
							case 1:
//						Delete by mid
								query = "DELETE FROM members WHERE mid=\"?\";";
								pstmt = conn.prepareStatement(query);
								System.out.println("Enter Member id:");
								mid = sc.nextInt();
								sc.nextLine();

								pstmt.setInt(1, mid);
								break;

							case 2:
//						Delete by name
								query = "DELETE FROM members WHERE mid=\"?\";";
								pstmt = conn.prepareStatement(query);
								System.out.println("Enter Member NAME:");
								name = sc.nextLine();
								name = name.toUpperCase();

								pstmt.setString(1, name);
								break;

							case 0:
								System.out.println("RE-DIRECTING TO MENU.....");
								sub_loop = false;
								break;

							default:
								System.out.println("Incorrect Choice");
							}

							pstmt.executeUpdate();

							System.out.println("Record deleted successfully");
						} while (sub_loop);
						break;

					case 3:
//					3. Update
						sub_loop = true;
						do {
							int sub_choice = sc.nextInt();
							sc.nextLine();

							System.out.println("============UPDATE============");
							System.out.println("Enter Member id to UPDATE:");
							mid = sc.nextInt();
							sc.nextLine();

							System.out.println("Enter\tTo UPDATE Member\n" + "1\tPhone Number\n" + "2\tAddress\n"
									+ "3\tDepartment\n" + "0\tGO BACK\n");
							switch (sub_choice) {
							case 1:
//								Update Phone number
								query = "UPDATE members SET phno = ? WHERE mid = ?;";
								pstmt = conn.prepareStatement(query);
								System.out.println("Enter NEW Phone number:");
								phno = sc.nextInt();
								sc.nextLine();
								pstmt.setInt(1, phno);
								pstmt.setInt(2, mid);
								break;

							case 2:
//								Update Address
								query = "UPDATE members SET aadr = ? WHERE mid = ?;";
								pstmt = conn.prepareStatement(query);
								System.out.println("Enter NEW Address:");
								address = sc.nextLine();
								address = address.toUpperCase();
								pstmt.setString(1, address);
								pstmt.setInt(2, mid);

								break;

							case 3:
//								Update Department
								query = "UPDATE members SET department = ? WHERE mid = ?;";
								pstmt = conn.prepareStatement(query);
								System.out.println("Enter NEW Department:");
								dept = sc.nextLine();
								dept = dept.toUpperCase();
								pstmt.setString(1, dept);
								pstmt.setInt(2, mid);

								break;

							case 0:
								System.out.println("RE-DIRECTING TO MENU.....");
								sub_loop = false;
								break;

							default:
								System.out.println("Incorrect Choice");
							}

							pstmt.executeUpdate();

							System.out.println("Record updated successfully");
						} while (sub_loop);
						break;

					case 4:
//					4. Search	
						sub_loop = true;
						do {
							System.out.println("============SEARCH============");

							int sub_choice = sc.nextInt();
							sc.nextLine();

							System.out
									.println("Enter\tTo Search Member BY\n" + "1\tID\n" + "2\tName\n" + "0\tGO BACK\n");
							switch (sub_choice) {
							case 1:
//						Search by mid
								query = "SELECT * FROM members WHERE mid=\"?\";";
								pstmt = conn.prepareStatement(query);
								System.out.println("Enter Member id:");
								mid = sc.nextInt();
								sc.nextLine();

								pstmt.setInt(1, mid);
								break;

							case 2:
//						Search by name
								query = "SELECT * FROM members WHERE mid=\"?\";";
								pstmt = conn.prepareStatement(query);
								System.out.println("Enter Member NAME:");
								name = sc.nextLine();
								name = name.toUpperCase();

								pstmt.setString(1, name);
								break;

							case 0:
								System.out.println("RE-DIRECTING TO MENU.....");
								sub_loop = false;
								break;

							default:
								System.out.println("Incorrect Choice");
							}

							pstmt.executeUpdate();

							System.out.println("Record SEARCHED FOR...");
						} while (sub_loop);
						break;

					case 5:
//					5. Display all	
						System.out.println("============DISPLAY============");

						query = "SELECT * FROM members;";
						pstmt = conn.prepareStatement(query);
						
						pstmt.executeUpdate();
						break;

					case 0:
						System.out.println("EXITING.....");
						loop = false;
						break;

					default:
						System.out.println("Incorrect Input");
					}
				} while (loop);

				pstmt.close();
				conn.close();
				sc.close();

			} // End of try
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			System.out.println();
		}

	}
	// end of main()
}