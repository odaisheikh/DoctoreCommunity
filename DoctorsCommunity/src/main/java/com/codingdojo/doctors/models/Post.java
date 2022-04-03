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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="posts")
public class Post {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull(message="Title is required!")
	    @Size(min=3, message="Title must be greater than 3 characters")
	    private String title;
	    
	    @NotNull(message="Description is required!")
	    @Size(min=3, message="Description must be greater than 3 characters")
	    private String description;
	    
	    @NotNull(message="Category is required!")
	    private String category;
	    
	    private String photo;
	    
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
	    @JoinColumn(name="user_id")
	    private User postUser;
	    
	    @OneToMany(mappedBy="commentPost", fetch = FetchType.LAZY)
	    private List<Comment> postComments;

		public Post() {

		}
		public Post(
				@NotNull(message = "Title is required!") @Size(min = 3, message = "Title must be greater than 3 characters") String title,
				@NotNull(message = "Description is required!") @Size(min = 3, message = "Description must be greater than 3 characters") String description,
				@NotNull(message = "Category is required!") String category, String photo) {
			this.title = title;
			this.description = description;
			this.category = category;
			this.photo = photo;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
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
		public User getPostUser() {
			return postUser;
		}
		public void setPostUser(User postUser) {
			this.postUser = postUser;
		}
		public List<Comment> getPostComments() {
			return postComments;
		}
		public void setPostComments(List<Comment> postComments) {
			this.postComments = postComments;
		}

}