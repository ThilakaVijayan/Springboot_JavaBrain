package com.thilaka.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thilaka.springbootstarter.topic.Topic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Course of the Topic")
public class Course {
	
	@Id
	@ApiModelProperty(notes = "The unique id of the Course")
	private String id;
	
	@ApiModelProperty(notes = "Course name")
	private String name;
	
	@ApiModelProperty(notes = "Course description")
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
		
	}
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId,"","");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	

}
