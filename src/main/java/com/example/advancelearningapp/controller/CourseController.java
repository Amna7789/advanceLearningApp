package com.example.advancelearningapp.controller;

import com.example.advancelearningapp.controller.annotation.Verification;
import com.example.advancelearningapp.domain.CourseDTO;
import com.example.advancelearningapp.domain.ErrorDTO;
import com.example.advancelearningapp.domain.inboud.CourseDTOIn;
import com.example.advancelearningapp.services.ICourseService;
import com.example.advancelearningapp.services.IUserService;
import com.example.advancelearningapp.services.common.IAuthService;
import com.example.advancelearningapp.services.impl.CourseServiceImpl;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    ICourseService courseService;

    @Autowired
    IAuthService authService;
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/course/createCourse")
    public CourseDTO createNewCourse(@RequestBody CourseDTOIn courseDTOIn){
        Boolean validUser = authService.isAdminUser();
        if(validUser == false)
            throw new InputMismatchException("");
        return courseService.createCourse(courseDTOIn);

    }
    @PutMapping("course/updateCourse/{courseId}")
    public void updateExistingCourse(@PathVariable("courseId")String courseId,
                                          @RequestBody CourseDTOIn courseDTOIn){

        Boolean validUser = authService.isAdminUser();
        //authentication is done here
        if(validUser == false)
            throw new InputMismatchException("");
        courseService.updateCourse(courseId,courseDTOIn);


         courseService.updateCourse(courseId, courseDTOIn);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("course/deleteCourse/{courseId}")
    public void deleteExistingCourse(@PathVariable("courseId")String courseId){
        Boolean validUser = authService.isAdminUser();
        if(validUser == false)
            throw new InputMismatchException("");

        courseService.deleteCourse(courseId);
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleCourseException() {
        return "Course Id is not valid";
    }*/

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleCourseException() {

        // response using hashmap
        /*HashMap<String, String> res = new HashMap<>();
        res.put("message", "Course Id is not valid" );
        res.put("ErrorCode", HttpStatus.BAD_REQUEST.toString());*/

        //response using ErrorDTO
        ErrorDTO errorDTO = new ErrorDTO("courseId is not valid", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/course/allCourses")
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }

    /*HttpServletRequest request1 =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String base64Auth = request1.getHeader("Authorization").substring(6);
    String credentials = new String(Base64.getDecoder().decode(base64Auth));
    String email = credentials.split(":")[0];
    String password = credentials.split(":")[1];
    //authentication or authorization  line
    Boolean validUser = userService.isAdminUser(email, password);

    //authentication is done here
        if(validUser == false)
            throw new InputMismatchException("");
        return courseService.createCourse(courseDTOIn)*/
}
