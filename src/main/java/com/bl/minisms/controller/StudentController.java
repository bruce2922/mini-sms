package com.bl.minisms.controller;

import com.bl.minisms.model.Student;
import com.bl.minisms.model.dto.PageData;
import com.bl.minisms.model.dto.ResponseData;
import com.bl.minisms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@ResponseBody
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list/{pageNo}")
    public ResponseData<PageData> getList(@PathVariable(value = "pageNo",required = true) int pageNo){
        PageData pageData = studentService.getAllByPage(pageNo <=0 ? 1: pageNo,PageData.DEFAULT_PAGE_SIZE);
        return ResponseData.success(pageData);
    }

    @GetMapping("/info/{id}")
    public ResponseData<Student> getStudent(@PathVariable("id") Long id){
        Student student = studentService.getById(id);
        return ResponseData.success(student);
    }

    @PostMapping("/info")
    public ResponseData addStudent(@RequestBody Student student){
        int result = studentService.add(student);
        return ResponseData.success(result);
    }

    @PutMapping("/info")
    public ResponseData updateStudent(@RequestBody Student student){
        int result = studentService.update(student);
        return ResponseData.success(result);
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteStudent(@PathVariable("id") Long id){
        studentService.removeById(id);
        return ResponseData.success(1);
    }
}
