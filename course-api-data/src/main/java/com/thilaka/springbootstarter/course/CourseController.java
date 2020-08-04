package com.thilaka.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thilaka.springbootstarter.topic.Topic;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}/courses")
	@ApiOperation(value = "List of Courses for a Topic",
				notes = "List all the Courses for a Topic Id",
				response = Course.class)
	public List<Course> getAllCourses(@ApiParam(value = "Topic Id for which the courses you need to retrieve",
										required = true)
							@PathVariable String id) {
		return courseService.getAllCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{id}")
	@ApiOperation(value = "Get Course for an Id",
				notes = "Get Course for an Id",
				response = Course.class)
	public Course getCourse(@ApiParam(value = "Topic Id for which the course you need to retrieve",
								required = true)
						@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	@ApiOperation(value = "Add a Course to a Topic",
				notes = "Add a Course to a Topic id",
				response = void.class)
	public void addCourse(@RequestBody Course course, 
						@ApiParam(value = "Topic Id for which the courses you need to retrieve",
						required = true)
						@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	@ApiOperation(value = "Update a Course to a Topic",
				notes = "Update a Course to a Topic Id",
				response = void.class)
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId ,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	@ApiOperation(value = "Delete a Course",
				notes = "Delete a Course",
				response = void.class)
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
