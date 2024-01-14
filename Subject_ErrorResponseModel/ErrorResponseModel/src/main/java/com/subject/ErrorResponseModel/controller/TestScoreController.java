package com.subject.ErrorResponseModel.controller;

import com.subject.ErrorResponseModel.dto.ApiResponse;
import com.subject.ErrorResponseModel.dto.Student;
import com.subject.ErrorResponseModel.exception.CustomException;
import com.subject.ErrorResponseModel.exception.ErrorCode;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/test-score")
public class TestScoreController {


    // 이름과 성적을 입력받아 저장하는 API
    @PostMapping("/student")
    public ResponseEntity<ApiResponse<Student>> addStudentInfo(@RequestBody Student student, HttpSession httpSession) {
        List<Student> list = (List<Student>) httpSession.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }
        int grade = student.getGrade();


        if (grade >= 6) {
            throw new CustomException(ErrorCode.SERVER_ERROR, grade);
        }
        list.add(student);
        httpSession.setAttribute("list", list);

        return new ResponseEntity<>(ApiResponse.makeResponse(list), HttpStatus.OK);
    }


    @GetMapping("/student")
    ResponseEntity<ApiResponse<Student>> searchStudents(HttpSession httpSession) {
        List<Student> list = (List<Student>) httpSession.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getGrade() - o2.getGrade();
            }
        });

        return new ResponseEntity<>(ApiResponse.makeResponse(list), HttpStatus.OK);
    }

    @GetMapping("/specific-student")
    ResponseEntity<ApiResponse<Student>> getSpecificStudents(@RequestParam int grade, HttpSession httpSession) {
        List<Student> list = (List<Student>) httpSession.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }
        List<Student> resultList = list.stream().filter(v -> {
            return v.getGrade() == grade;
        }).toList();

        return new ResponseEntity<>(ApiResponse.makeResponse(resultList), HttpStatus.OK);
    }


}
