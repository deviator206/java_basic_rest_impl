package com.test;

import com.main.impl.LoginServiceImpl;

public class TestLoginServiceImpl {
	public static void main(String[] args) {
		LoginServiceImpl lo = new LoginServiceImpl();
		lo.setUserName("tech");
		lo.setUserPassword("tech");
		lo.execute();
		lo.getLoginResponse();
	}
}
