package com.user.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.AddRepo;
import com.user.dao.ValidRepo;
import com.user.dao.registerRepo;
import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;

@Service
public class RegisterServiceImpl implements RegisterService{
//	 @Autowired(required=true)
//	  RegisterDAO registerDAO;
	  @Autowired(required=true)
	  registerRepo registerrepo;
	 
	  @Autowired(required=true)
	  AddRepo addrepo;
	  
	  @Autowired(required=true)
	  ValidRepo validrepo;
	  
	  
	@Transactional
    public void saveData(User user,Add add,Valid valid) {
    	System.out.println("reached");
    	registerrepo.save(user);
    	addrepo.save(add);
    	validrepo.save(valid);
    }
	

	
	
	
	public void deleteData(Valid valid) {
		registerrepo.deleteById(valid.getEmailid());
		addrepo.deleteById(valid.getEmailid());
		validrepo.deleteById(valid.getEmailid());
	}
	
	public Optional<User> search(String emailid) {
//		String id=valid.getEmailid();
		return registerrepo.findById(emailid);
		
	}
	public boolean authenticate(Valid valid) {
		String id=valid.getEmailid();
		return validrepo.findById(id) != null;
	}
}
