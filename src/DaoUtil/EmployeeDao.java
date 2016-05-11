package DaoUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Employees;

public class EmployeeDao {
	
	/*
	 * ���Ա���б�
	 */
	public List<Employees> queryAllEmployees()
	{
		Transaction trans = null;
		List<Employees> list = null;
		String hql = "";
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "from Employees";
			Query query = session.createQuery(hql);
			list = query.list();
			trans.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return list;
		}finally {
			if(trans != null)
			{
				trans = null;
			}
		}
	}
	/*
	 * ����number���Ա����Ϣ
	 */
	public Employees queryEmployeeByNum(String employee_num)
	{
		Transaction trans = null;
		Employees employee = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			employee = (Employees)session.get(Employees.class, employee_num);
			trans.commit();
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return employee;
		}finally {
			if(trans != null)
			{
				trans = null;
			}
		}
	}
	/*
	 * ɾ��Ա����Ϣ
	 */
	public boolean deleteEmployee(String employee_num)
	{
		Transaction trans = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			Employees employees = (Employees)session.get(Employees.class,employee_num);
			session.delete(employees);
			trans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return false;
		}finally {
			if(trans != null)
			{
				trans = null;
			}
		}
	}
	
	/*
	 * ���Ա��
	 */
	public boolean addEmployee(Employees employee)
	{
		Transaction trans = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			session.save(employee);
			trans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return false;
		}finally {
			if(trans != null)
			{
				trans = null;
			}
		}
	}
	/*
	 * 
	 */
	
}
