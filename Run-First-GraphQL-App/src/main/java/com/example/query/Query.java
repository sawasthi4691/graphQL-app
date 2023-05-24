package com.example.query;

import com.example.entity.Student;
import com.example.request.SampleRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Query {

	@Autowired
	private StudentService studentService;

	@QueryMapping
	public String firstQuery () {
		return "First Query";
	}

	@QueryMapping
	public String secondQuery () {
		return "Second Query";
	}

	@QueryMapping
	public Integer thirdQuery () { return  10;}

	@QueryMapping
	public String fullName (String firstName, String lastName) {
		return firstName + " " + lastName;
	}

	@QueryMapping
	public String fullNameJSON (@Argument  SampleRequest sampleRequest) {
		return sampleRequest.getFirstName() + " " + sampleRequest.getLastName() ;
		//+ "  " + sampleRequest.getAddress().getCity() + " " + sampleRequest.getAddress().getState();

	}

	@QueryMapping
	public StudentResponse student(@Argument  Long id) {
		Student student = studentService.getStudentById(id);
		return new StudentResponse(student);
	}

}
