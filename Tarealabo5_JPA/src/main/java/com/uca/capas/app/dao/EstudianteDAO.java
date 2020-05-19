package com.uca.capas.app.dao;

import org.springframework.dao.DataAccessException;

import com.uca.capas.app.domain.Estudiante;

import java.util.List;

public interface EstudianteDAO {

    public List<Estudiante> findAll() throws DataAccessException;
    public void insert(Estudiante estudiante) throws DataAccessException;
}
