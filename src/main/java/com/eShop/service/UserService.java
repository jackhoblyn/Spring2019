package com.eShop.service;

import com.eShop.model.User;

public interface UserService {
	
	public void saveUser(User user);
	public boolean isUserAlreadyPresent(User user);

}
