package com.example.demo.service;

import com.example.demo.domain.Vacancy;
import com.example.demo.model.VacancyDto;
import com.example.demo.storage.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    public List<Vacancy> getAll(){
        ArrayList<Vacancy> list = new ArrayList<>();
        return list;
    }

    public Vacancy create(VacancyDto vacancyDto){

        Vacancy vacancy = new Vacancy();
        vacancy.setTitle((vacancyDto.getTitle()));
        vacancy.setWages((vacancyDto.getWages()));
        vacancy.setSkills((vacancyDto.getSkills()));
        vacancy.setExperience((vacancyDto.getExperience()));

        log.info("Creating vacancy with title" + vacancy.getTitle());
        Vacancy result = vacancyRepository.save(vacancy);

        return result;
    }
}
