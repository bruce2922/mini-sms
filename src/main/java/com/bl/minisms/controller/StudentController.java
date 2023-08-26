package com.bl.minisms.controller;

import com.bl.minisms.model.Student;
import com.bl.minisms.model.dto.PageData;
import com.bl.minisms.model.dto.ResponseData;
import com.bl.minisms.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@ResponseBody
@Validated
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list/{pageNo}")
    public ResponseData<PageData> getList(@PathVariable(value = "pageNo",required = true) @Valid @Min(value = 1, message = "Invalid page number") int pageNo){
        PageData pageData = studentService.getAllByPage(pageNo <=0 ? 1: pageNo,PageData.DEFAULT_PAGE_SIZE);
        return ResponseData.success(pageData);
    }

    @GetMapping("/info/{id}")
    public ResponseData<Student> getStudent(@PathVariable("id") @Valid @Min(value = 1, message = "Invalid id") Long id){
        Student student = studentService.getById(id);
        return ResponseData.success(student);
    }

    @PostMapping("/info")
    public ResponseData addStudent(@RequestBody @Valid Student student) throws Exception {
        verifyData(student);
        int result = studentService.add(student);
        return ResponseData.success(result);
    }

    @PutMapping("/info")
    public ResponseData updateStudent(@RequestBody @Valid Student student) throws Exception {
        verifyData(student);
        int result = studentService.update(student);
        return ResponseData.success(result);
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteStudent(@PathVariable("id") @Valid @Min(value = 1, message = "Invalid id") Long id){
        studentService.removeById(id);
        return ResponseData.success(1);
    }

    private void verifyData(Student student) throws Exception {
        studentService.verifyCategory(student.getCategory().getId());
        studentService.verifyContact(student.getContactList());
    }
}
