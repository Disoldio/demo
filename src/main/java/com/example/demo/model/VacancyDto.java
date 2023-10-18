package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VacancyDto {

    private Integer id;

    @JsonProperty("job_title")
    private String title;

    @JsonProperty("job_wages")
    private String wages;

    @JsonProperty("job_skills")
    private String skills;

    @JsonProperty("job_experience")
    private String experience;

}
