package com.w3e.fitbit.service.account;

import com.w3e.fitbit.model.account.User;

/**
 * Interface of W3E user service
 * @author ZHOU WENTAO
 * */
public interface UserService {

	void save(User user);

    User findByUsername(String username);
    
    long getCurrentAuthorizedUserId();
    
    boolean deleteUserById(long id);
}
