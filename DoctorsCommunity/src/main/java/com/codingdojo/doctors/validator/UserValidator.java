package com.codingdojo.doctors.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.doctors.models.User;
import com.codingdojo.doctors.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	
	private final UserRepository userRepo;
	
    
    public UserValidator(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	//    1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        User emailUser = userRepo.findByEmail(user.getEmail());
        User nameUser = userRepo.findByUsername(user.getUsername());
    
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        } 
        
        if (nameUser != null) {
            errors.rejectValue("username", "Exist");
        } 
        
        if (emailUser != null) {
        	errors.rejectValue("email", "Exist");
        } 
        
        if (user.getAge() != null) {
        	if (user.getAge() < 18) {
        		errors.rejectValue("age", "Compare");
        	} 
        } else {
        	errors.rejectValue("age", "Exist");
        	
        }
        
        
    }
}