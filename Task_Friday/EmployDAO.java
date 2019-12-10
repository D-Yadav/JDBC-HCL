package Task_Friday;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployDAO {
	static List<Employ> lstEmploy = null;
	static ResourceBundle rb=null;
	static {
		lstEmploy = new ArrayList<Employ>();
		rb=ResourceBundle.getBundle("employ");
	}
	public String addEmployDao(Employ employ) {
		lstEmploy.add(employ);
		return rb.getString("add");
	}
	public List<Employ> showEmployDao() {
		return lstEmploy;
	}
	public Employ searchEmployDao(int empId) {
		Employ objEmploy = null;
		for (Employ employ : lstEmploy) {
			if(employ.getEmpId()==empId) {
				objEmploy = employ;
			}
		}
		return objEmploy;
	}
	public void writeEmployFileDao() {
		try {
			FileOutputStream fout=new FileOutputStream("c:/files/employ.txt");
			ObjectOutputStream objout=new ObjectOutputStream(fout);
			objout.writeObject(lstEmploy);
			objout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readEmployFileDao() {
		try {
			FileInputStream fin=new FileInputStream("c:/files/employ.txt");
			ObjectInputStream objin=new ObjectInputStream(fin);
			lstEmploy =(List<Employ>)objin.readObject();
			objin.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
