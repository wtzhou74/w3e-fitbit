package com.w3e.fitbit.service.account;

/**
 * Interface of W3E security service
 * @author ZHOU WENTAO
 * */
public interface SecurityService {

	String findLoggedInUsername();

    void autologin(String username, String password);
}
