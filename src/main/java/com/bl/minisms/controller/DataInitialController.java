package com.bl.minisms.controller;

import com.bl.minisms.model.dto.ResponseData;
import com.bl.minisms.service.DataInitialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class DataInitialController {

    @Autowired
    DataInitialService dataInitialService;

    @GetMapping("/initial")
    public ResponseData<String> initData(){
        dataInitialService.init();
        return ResponseData.success("Data initialized");
    }
}
