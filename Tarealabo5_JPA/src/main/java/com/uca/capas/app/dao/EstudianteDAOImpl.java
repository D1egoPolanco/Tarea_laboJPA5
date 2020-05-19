package com.uca.capas.app.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.app.domain.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insert(Estudiante estudiante) throws DataAccessException {
        entityManager.persist(estudiante);
    }
    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.estudiante");
        Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
        List<Estudiante> estudiantes = query.getResultList();

        return estudiantes;
    }
}
