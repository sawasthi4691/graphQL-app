package com.example.resolver;


import com.example.entity.Subject;
import com.example.entity.SubjectName;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentResponseResolver  {


    //Resolver
    @SchemaMapping(typeName = "StudentResponse" , field = "learningSubjects")
    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {
        List<SubjectResponse> learningSubjects = new ArrayList<>();
        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }

    @SchemaMapping(typeName = "StudentResponse" , field = "filterSubjects")
    public List<SubjectResponse> getFilterSubjects(StudentResponse studentResponse, @Argument("filter") SubjectName subjectName) {
        List<SubjectResponse> learningSubjects = new ArrayList<>();
        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                if(subjectName.name().equals("All")) {
                    learningSubjects.add(new SubjectResponse(subject));
                } else if(subjectName.name().equals(subject.getSubjectName())) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }
        }
        return learningSubjects;
    }

    @SchemaMapping(typeName = "StudentResponse" , field = "fullName")
    public String getFullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();

    }

    @SchemaMapping(typeName = "StudentResponse" , field = "totalMarks")
    public Long getTotalMarks(StudentResponse studentResponse) {
        long marks = 0;
        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                marks += subject.getMarksObtained();
            }
        }
        return marks;
    }


}
