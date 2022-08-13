package com.pagination.controller;

import com.pagination.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/pagination/v1")
public class Controller {

    @Autowired
    ServiceClass serviceClass;


    @GetMapping("/findall")
    @ResponseBody
    public ResponseEntity getReceivablesForConciliation(@RequestParam(value = "currentPage") int page,
                                                        @RequestParam(value = "perPage") int pageSize) {
        try {
            return new ResponseEntity<>(serviceClass.findAll(page, pageSize), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
