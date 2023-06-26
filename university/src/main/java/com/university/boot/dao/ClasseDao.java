package com.university.boot.dao;

import java.util.List;

import com.university.boot.domain.Classe;



public interface ClasseDao {

    void save(Classe classe);

    void update(Classe classe);

    void delete(Long id);

   Classe findById(Long id);

    List<Classe> findAll();
}
