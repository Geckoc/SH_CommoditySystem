package actions;

import com.opensymphony.xwork2.ActionSupport;

import DaoUtil.UserDao;
import entity.User;

public class RegisterAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String register() throws Exception 
	{
		user.getName();
		user.getPassword();
		user.getGender();
		user.getJob();
		user.getHobby();
		user.getInformation();
		UserDao userDao = new UserDao();
		userDao.savaUser(user);
		return SUCCESS;
	}

}
