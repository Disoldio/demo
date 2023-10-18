package com.example.demo.controller;

import com.example.demo.domain.Resume;
import com.example.demo.service.CVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/resume")
public class CVController {

    @Autowired
    CVService cvService;

    @PostMapping
    public ResponseEntity filler(@RequestParam("file") MultipartFile multipartFile){

        Resume resume = cvService.create(multipartFile);

        return ResponseEntity.ok(resume);
    }

    @GetMapping
    public ResponseEntity getAll(){

        List<Resume> all = cvService.getAll();

        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){

        Resume byId = cvService.getById(id);

        return  ResponseEntity.ok(byId);
    }
}
