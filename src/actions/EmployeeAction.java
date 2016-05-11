package actions;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import DaoUtil.EmployeeDao;
import entity.Employees;

public class EmployeeAction extends SuperAction implements ModelDriven<Employees>{

	private static final long serialVersionUID = 1L;
	private Employees employee = new Employees();

	/*
	 * ��ѯ����Ա����Ϣ
	 */
	public String query()
	{
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employees> list = employeeDao.queryAllEmployees();
		//�Ž�Session��
		if( list != null && list.size() > 0){
			session.setAttribute("employee_list", list);
		}else{
			session.setAttribute("employee_list", null);
		}
		return "query_information";
	}
	/*
	 * ����number�޸�Ա����Ϣ
	 */
	public String modifyEmployee()
	{
		EmployeeDao employeeDao = new EmployeeDao();
		Employees emp = employeeDao.queryEmployeeByNum(employee.getEmployee_num());
		//������Session��
		session.setAttribute("modify_employee", emp);
		return "modify_success";
	}
	/*
	 * ɾ��Ա��
	 */
	public String deleteEmployee()
	{
		EmployeeDao employeeDao = new EmployeeDao();
		String employee_num = request.getParameter("employee_num");
		employeeDao.deleteEmployee(employee_num);  
		
		return "delete_success";
	}
	
	/*
	 * ���Ա��
	 */
	public String addEmployee() throws Exception
	{	
		employee.getEmployee_num();
		employee.getEmployee_name();
		employee.getEmployee_birthday();
		employee.getEmployee_gender();
		employee.getEmployee_phone();
		employee.getEmployee_email();  
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.addEmployee(employee);
		return SUCCESS;
	}

	@Override
	public Employees getModel() {
		return this.employee;
	}
}
