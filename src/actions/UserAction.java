package actions;

import java.io.IOException;


import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import DaoUtil.UserDao;
import entity.User;

public class UserAction extends SuperAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	
	public String login()
	{	
		UserDao userDao = new UserDao();
		if(userDao.userLogin(user))
		{
			session.setAttribute("loginUserName", user.getName());
			return "login";
		}
		else
		{
			return "error";
		}
	}
	
	
	public String register() throws IOException
	{	
		
		user.getName();
		user.getPassword();
		user.getGender();
		user.getJob();
		user.getHobby();
		user.getInformation();
		UserDao userDao = new UserDao();
		userDao.saveUser(user);
			return SUCCESS;
	}
	
	
	//用户注销Action
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUserName") != null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	@Override
	public void validate() {
		if("".equals(user.getName().trim())){
			this.addFieldError("userNameError", "用户名不能为空");
		}
		
	}
	@Override
	public User getModel() {
		
		return this.user;
	}

}
