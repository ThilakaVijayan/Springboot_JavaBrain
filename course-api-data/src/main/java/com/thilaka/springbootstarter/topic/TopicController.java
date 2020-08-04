package com.thilaka.springbootstarter.topic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@RequestMapping(method = RequestMethod.GET,value =  "/topics")
	@ApiOperation(value = "List of topics",
				notes = "List all the topics",
				response = Topic.class)
	public List<Topic> getAllTopics() {
		logger.trace("getAllTopics method is called.");
		return topicService.getAllTopics();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
	@ApiOperation(value = "Get topic",
				notes = "Get one topic by Id",
				response = Topic.class)
	public Topic getTopic(@PathVariable String id) {
		logger.info("getTopic method is called with input Id - "+ id);
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	@ApiOperation(value = "Add topic",
				notes = "Add a topic to the list of topics",
				response = void.class)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	@ApiOperation(value = "Update topic",
				notes = "Update a topic indicated by the Id",
				response = void.class)
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	@ApiOperation(value = "Delete topic",
				notes = "Delete a topic indicated by the Id",
				response = void.class)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
