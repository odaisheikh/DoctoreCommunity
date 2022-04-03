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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Comment is required!")
    @Size(min=3, message="Comment must be atleast 3 characters")
    private String content;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="commentUser_id")
	private User commentUser;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="commentPost_id")
	private Post commentPost;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "comment_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )	    
    private List<User> likedByUsers;
    
	
	public Comment() {
	}
	
	public Comment(String content) {
		this.content = content;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public User getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}
	public Post getCommentPost() {
		return commentPost;
	}
	public void setCommentPost(Post commentPost) {
		this.commentPost = commentPost;
	}
	public List<User> getLikedByUsers() {
		return likedByUsers;
	}
	public void setLikedByUsers(List<User> likedByUsers) {
		this.likedByUsers = likedByUsers;
	}

	
}