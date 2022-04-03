package com.codingdojo.doctors.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Size(min=3)
 private String username;
 @Min(18)
 private Integer age;
 @Size(min=3, message="E-mail must be atleast 3 characters")
 private String email;
 @Size(min=5)
 private String password;
 @Transient
 private String passwordConfirmation;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @PrePersist
 protected void onCreate(){
	 this.createdAt = new Date();
 }
 @PreUpdate
 protected void onUpdate(){
	 this.updatedAt = new Date();
 }
 
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(
	     name = "users_roles", 
	     joinColumns = @JoinColumn(name = "user_id"), 
	     inverseJoinColumns = @JoinColumn(name = "role_id"))
	 private List<Role> roles;
	 
	 @OneToMany(mappedBy="postUser", fetch = FetchType.LAZY)
	 private List<Post> userPosts;
	 
	@OneToMany(mappedBy="commentUser", fetch = FetchType.LAZY)
	private List<Comment> userComments;
	 
 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	 name = "likes", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "comment_id")
	 )
	 private List<Comment> likedComments;
 

	public User() {
	
	}
	public User(@Size(min = 3) String username, @Min(18) Integer age,
			@Size(min = 3, message = "E-mail must be atleast 3 characters") String email, @Size(min = 5) String password) {
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Post> getUserPosts() {
		return userPosts;
	}
	public void setUserPosts(List<Post> userPosts) {
		this.userPosts = userPosts;
	}
	public List<Comment> getUserComments() {
		return userComments;
	}
	public void setUserComments(List<Comment> userComments) {
		this.userComments = userComments;
	}
	public List<Comment> getLikedComments() {
		return likedComments;
	}
	public void setLikedComments(List<Comment> likedComments) {
		this.likedComments = likedComments;
	}

 
}

