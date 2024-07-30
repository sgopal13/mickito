package com.junit.service;

import com.junit.dao.ILoginDao;

public class ILoginServiceImpl implements ILoginService {

	private ILoginDao loginDAO;
	
	public ILoginServiceImpl(ILoginDao iLoginDao) {
		this.loginDAO=iLoginDao;
	}
	
	@Override
	public boolean login(String username, String pwd) {
		if(username.equals("") || pwd.equals("")) {
			throw new IllegalArgumentException("Empty Credentialss");
		}
		//use ILoginDao
		int count = loginDAO.authenticate(username, pwd);
		if(count==0) {
			return false;
		}else {
			return true;
		}
	}
}
