package com.codingdojo.doctors.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.doctors.models.User;
import com.codingdojo.doctors.services.UserService;
import com.codingdojo.doctors.validator.UserValidator;

@Controller
public class Users {
	 private UserService userService;	    
	 private UserValidator userValidator;
	    
     public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
	    
//Patient registration form	    
    @RequestMapping("/registration")
    public String patientReg(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @PostMapping("/registration")
    public String patientReg(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        // NEW
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
//Doctor Registration form template render
    @RequestMapping("/registration/doctor")
    public String doctorReg(@Valid @ModelAttribute("user") User user) {
        return "regPageDoctor.jsp";
    }
    
    @PostMapping("/registration/doctor")
    public String doctorReg(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        // NEW
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "regPageDoctor.jsp";
        }
        
        userService.saveWithDoctorRole(user);
        return "redirect:/login";
    }
    
    
  //Admin Registration form template render
    @RequestMapping("/registration/977")
    public String adminReg(@Valid @ModelAttribute("user") User user) {
        return "regPageAdmin.jsp";
    }
    
    @PostMapping("/registration/977")
    public String adminReg(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        // NEW
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "regPageAdmin.jsp";
        }
        
        userService.saveUserWithAdminRole(user);
        return "redirect:/login";
    }
    
    
//Login form template render  
        
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }
    
// Admin page template render
    @GetMapping("/admin")
    public String adminPage( Model model,Principal principal) {
    	String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        List<User> siteUsers = userService.allUsers();
        model.addAttribute("siteUsers", siteUsers);
        return "adminPage.jsp";
    }
    
// Delete user 
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
    	userService.deleteUser(id);
        return "redirect:/admin";
    }
    
    
}