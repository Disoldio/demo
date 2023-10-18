package com.example.demo.controller;


import com.example.demo.domain.Vacancy;
import com.example.demo.model.VacancyDto;
import com.example.demo.service.VacancyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @PostMapping
    public ResponseEntity create(@RequestBody VacancyDto vacancyDto){

        Vacancy res = vacancyService.create(vacancyDto);

        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity getAll(){

        List<Vacancy> all = vacancyService.getAll();

        return ResponseEntity.ok(all);
    }
}
