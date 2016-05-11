package actions;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import DaoUtil.UserDao;
import entity.User;

public class UserAction extends SuperAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//用户登录Action
	public String login() throws Exception
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
	
	//用户注销Action
	@SkipValidation
	public String logout() throws Exception
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
		if(user.getPassword().length() < 6){
			this.addFieldError("passwordError", "密码最小长度为6位");
		}
	}
	@Override
	public User getModel() {
		
		return this.user;
	}

}
