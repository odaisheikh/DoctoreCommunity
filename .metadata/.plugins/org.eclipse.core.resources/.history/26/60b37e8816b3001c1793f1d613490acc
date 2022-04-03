package com.codingdojo.doctors.controllers;



import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.doctors.models.Comment;
import com.codingdojo.doctors.models.Post;
import com.codingdojo.doctors.models.User;
import com.codingdojo.doctors.services.DoctorService;
import com.codingdojo.doctors.services.UserService;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserService userService;
    
    
    @GetMapping("/")
    public String LandingPage() {
    	return "Landing.jsp";
    }
    
//Post template render
    @GetMapping("/posts/new")
    public String newPost(@ModelAttribute("post")Post post, Principal principal, Model model) {
    	String username = principal.getName();
    	model.addAttribute("currentUser", userService.findByUsername(username));
        return "NewPost.jsp";
    }
    
    @PostMapping("/posts/new")
    public String newPost(@Valid @ModelAttribute("post")Post post, BindingResult result, Principal principal, Model model) {
    	String username = principal.getName();
    	model.addAttribute("currentUser", userService.findByUsername(username));
    	if (result.hasErrors()) {
    		return "NewPost.jsp";
    	} else {
    		
    		this.doctorService.createPost(post);
    		return "redirect:/posts/" + post.getId();
    	}
    }
    

//all posts
    @GetMapping("/posts")
    public String allPost(Principal principal, Model model) {
    	String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        User thisUser = userService.findByUsername(username);
        System.out.println(thisUser.getRoles());
        model.addAttribute("userRole", thisUser);
        List<Post> posts = this.doctorService.allPosts();
        model.addAttribute("posts", posts);
        return "AllPosts.jsp";
    }

// new comment
    @GetMapping("/posts/{id}")
    public String newComment(@ModelAttribute("postComment") Comment comment,@PathVariable("id") Long id, Model model,Principal principal) {
    	String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        Post thisPost = doctorService.findPostById(id);
        List<Comment> postComments = thisPost.getPostComments();
        model.addAttribute("post", thisPost);
        model.addAttribute("comments", postComments);
        return "ShowPost.jsp";
    }
    
    @PostMapping("/posts/{id}")
    public String newComment(@PathVariable("id") Long id, @Valid @ModelAttribute("postComment") Comment postComment, BindingResult result, Principal principal, Model model) {
    	String username = principal.getName();
    	model.addAttribute("currentUser", userService.findByUsername(username));
    	User thisUser = userService.findByUsername(username);
    	Post thisPost = doctorService.findPostById(id);
    	List<Comment> postComments = thisPost.getPostComments();
    	model.addAttribute("post", thisPost);
    	model.addAttribute("comments", postComments);
    	if (result.hasErrors()) {
    		return "ShowPost.jsp";
    	} else {
    		this.doctorService.createComment(postComment);
    		return "redirect:/posts/" + id;
    	}
    }
    
	@GetMapping("/posts/{id}/like/{comId}")
	public String likeComment (@PathVariable("id") Long id, @PathVariable("comId") Long comId, Principal principal, Model model) {
			String username = principal.getName();
	    	model.addAttribute("currentUser", userService.findByUsername(username));
			User thisUser = userService.findByUsername(username);
			Comment thisComment = doctorService.findCommentById(comId);
			doctorService.likeComment(thisUser, thisComment);
			return "redirect:/posts/"+id;
	}
	
	@GetMapping("/posts/{id}/unlike/{comId}")
	public String dislikeComment (@PathVariable("id") Long id, @PathVariable("comId") Long comId, Principal principal, Model model) {
			String username = principal.getName();
	    	model.addAttribute("currentUser", userService.findByUsername(username));
			User thisUser = userService.findByUsername(username);
			Comment thisComment = doctorService.findCommentById(comId);
			doctorService.cancelLikeComment(thisUser, thisComment);
			return "redirect:/posts/"+id;
	}
	
// render by category
    @GetMapping("/category/{name}")
    public String getByGategory(@PathVariable("name") String name, Model model, Principal principal) {
    	String username = principal.getName();
    	model.addAttribute("currentUser", userService.findByUsername(username));
    	
    	List<Post> x = this.doctorService.findCategory(name);
    	System.out.println(x);
    	model.addAttribute("posts", x);
    	return "CatPost.jsp";
    }
    
//User profiles
    
    @GetMapping("/user/{id}")
    public String patientProf(@PathVariable("id") Long id, Model model,Principal principal) {
    	String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        User thisUser = userService.findByUsername(username);
        List<Post> userPosts = thisUser.getUserPosts();
        model.addAttribute("posts", userPosts);
        return "UserProfile.jsp";
    }
    
    @GetMapping("/doctor/{id}")
    public String doctorProf(@PathVariable("id") Long id, Model model,Principal principal) {
    	String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        User thisUser = userService.findByUsername(username);
        model.addAttribute("userRole", thisUser);
        List<Comment> userComments = thisUser.getUserComments();
        model.addAttribute("comments", userComments);
        return "DoctorProfile.jsp";
    }
    
//Adminstrator user handling page
    
    @GetMapping("/admin")
    public String adminPage( Model model,Principal principal) {
    	String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        User thisUser = userService.findByUsername(username);
        model.addAttribute("userRole", thisUser);
        List<User> siteUsers = userService.findAllUser();
        model.addAttribute("users", siteUsers);
        return "adminPage.jsp";
    }



}