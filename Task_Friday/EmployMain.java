package Task_Friday;

import java.util.List;
import java.util.Scanner;

public class EmployMain {
	public static void main(String[] args) {
		int choice;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Options");
			System.out.println("_ _ _ _ _");
			System.out.println("1.Add Employ");
			System.out.println("2.Show Employ");
			System.out.println("3.Search Employ");
			System.out.println("4.Write Employ File");
			System.out.println("5.Read Employ File");
			System.out.println("6.Exit");
			System.out.println("Enter your choice ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				addEmploy();
				break;
			case 2:
				showEmploy();
				break;
			case 3:
				searchEmploy();
				break;
			case 4 : 
				writeEmployFile();
				break;
			case 5 : 
				readEmployFile();
				break;
			case 6:
				return;
			default :
				System.out.println("Invalid Input");
			}

	}while(choice!=6);

}
private static void readEmployFile() {
	new EmployDAO().readEmployFileDao();
	}
private static void writeEmployFile() {
	new EmployDAO().writeEmployFileDao();
		
	}


	private static void searchEmploy() {
		int empId;
		System.out.println("Enter emp Id ");
		Scanner sc = new Scanner(System.in);
		empId=sc.nextInt();
		EmployDAO obj = new EmployDAO();
		Employ employ = obj.searchEmployDao(empId);
		System.out.println(employ);
		
	}

	private static void showEmploy() {
		EmployDAO obj = new EmployDAO();
		List<Employ> employees = obj.showEmployDao();
		for (Employ employ : employees) {
			System.out.println(employ);
		}
	
		
	}

	private static void addEmploy() {
		Employ objemploy=new Employ();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emp no: ");
		objemploy.setEmpId(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter emp name ");
		objemploy.setEmpName(sc.nextLine());
		System.out.println("Enter emp dept ");
		objemploy.setEmpDepartment(sc.nextLine());
		System.out.println("Enter emp phno: ");
		objemploy.setEmpPhone(sc.nextLine());
		System.out.println("Enter emp email ");
		objemploy.setEmpEmail(sc.nextLine());
		EmployDAO obj = new EmployDAO();
		String res= obj.addEmployDao(objemploy);
		System.out.println(res);
	}
}
