package com.w3e.fitbit.service.account;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.w3e.fitbit.model.account.User;
import com.w3e.fitbit.repository.RoleRepository;
import com.w3e.fitbit.repository.UserRepository;

/**
 * Implementation of W3E user service
 * @author ZHOU WENTAO
 * */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public long getCurrentAuthorizedUserId() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
        	User user = findByUsername(authentication.getName());
        	return user.getId();
    	}
    	return -1;
    }
    
    @Override
    public boolean deleteUserById(long id){
    	userRepository.delete(id);
    	return false;
    }
}
