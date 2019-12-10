package Task_Friday;

import java.util.Date;

public class Employ {
	private int empId;
    private String empName;
	private String empDepartment;
    private String empPhone;
	private String empEmail;
	private Date empDateOfJoin;
	private int empLeaveBalance;
	private int empManagerId;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public Date getEmpDateOfJoin() {
		return empDateOfJoin;
	}
	public void setEmpDateOfJoin(Date empDateOfJoin) {
		this.empDateOfJoin = empDateOfJoin;
	}
	public int getEmpLeaveBalance() {
		return empLeaveBalance;
	}
	public void setEmpLeaveBalance(int empLeaveBalance) {
		this.empLeaveBalance = empLeaveBalance;
	}
	public int getEmpManagerId() {
		return empManagerId;
	}
	public void setEmpManagerId(int empManagerId) {
		this.empManagerId = empManagerId;
	}
	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", empDepartment=" + empDepartment + ", empPhone="
				+ empPhone + ", empEmail=" + empEmail + ", empDateOfJoin=" + empDateOfJoin + ", empLeaveBalance="
				+ empLeaveBalance + ", empManagerId=" + empManagerId + "]";
	}

}
