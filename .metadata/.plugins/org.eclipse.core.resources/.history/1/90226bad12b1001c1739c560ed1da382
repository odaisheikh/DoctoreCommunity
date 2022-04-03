package com.codingdojo.doctors.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.doctors.models.Comment;
import com.codingdojo.doctors.models.Post;
import com.codingdojo.doctors.models.User;
import com.codingdojo.doctors.repositories.CommentRepository;
import com.codingdojo.doctors.repositories.PostRepository;
import com.codingdojo.doctors.repositories.UserRepository;

@Service
public class DoctorService {
	
	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private UserRepository userRepo;
	
	//comment
	
	
	public  List<Comment> allComments(){
		return this.commentRepo.findAll();
	}
	
    public Comment findComment(Long id) {
        Optional<Comment> optionalComment = this.commentRepo.findById(id);
        if(optionalComment.isPresent()) {
            return optionalComment.get();
        } else {
            return null;
        }
    
   }
    
  //Comment CRUD commands
    public Comment createComment( Comment comment) {
    	return this.commentRepo.save(comment);
    	
    }
    
	public Comment updateComment( Comment comment) {
		return this.commentRepo.save(comment);
		
	}
	
	
	public void deleteComment(Long id) {
		this.commentRepo.deleteById(id);
		
	}
	
	
	
	//Post
	public  List<Post> allPosts(){
		return this.postRepo.findAll();
	}
	
	public Post findPostById(Long id) {
		Optional<Post> optionalPost = this.postRepo.findById(id);
		if(optionalPost.isPresent()) {
			return optionalPost.get();
		} else {
			return null;
		}
		
	}
	
	//Post CRUD commands
	public Post createPost( Post post) {
		return this.postRepo.save(post);
		
	}
    
    
	public Post updatePost( Post post) {
		return this.postRepo.save(post);
		
	}
	
	
	public void deletePost(Long id) {
		this.postRepo.deleteById(id);
		
	}
	
	
	
	//user
	public  List<User> allUser(){
		return this.userRepo.findAll();
	}
	
	public User findUserById(Long id) {
		Optional<User> optionalUser = this.userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
		
	}
	
	//User CRUD commands
	
	public User createUser( User user) {
		return this.userRepo.save(user);
		
	}
	
	
    
	public User updateUser( User user) {
		return this.userRepo.save(user);
		
	}
	
	
	public void deleteUser(Long id) {
		this.userRepo.deleteById(id);
		
	}
	
    
	
}
