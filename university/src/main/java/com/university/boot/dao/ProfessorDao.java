package com.university.boot.dao;

import java.util.List;


import com.university.boot.domain.Professor;

public interface ProfessorDao {

    void save(Professor professor );

    void update(Professor professor);

    void delete(Long id);

    Professor findById(Long id);

    List<Professor> findAll();
}
