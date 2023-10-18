package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "general_info", length = 1000)
    private String generalInfo;

    @Column(name = "spec", length = 2000)
    private String spec;

    @Column(name = "experience", length = 5000)
    private String experience;

    @Column(name = "skills", length = 1500)
    private String skills;

    @Column(name = "education", length = 1000)
    private String education;

    @Column(name = "about", length = 1000)
    private String about;

}
