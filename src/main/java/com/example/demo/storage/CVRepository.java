package com.example.demo.storage;

import com.example.demo.domain.Resume;
import com.example.demo.domain.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CVRepository extends JpaRepository<Resume, Integer> {

}
