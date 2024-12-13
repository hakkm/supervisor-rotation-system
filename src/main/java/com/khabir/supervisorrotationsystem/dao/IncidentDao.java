package com.khabir.supervisorrotationsystem.dao;

import com.khabir.supervisorrotationsystem.model.Incident;

import java.util.Set;

/**
 * @author khabir
 **/
public interface IncidentDao {
    void insere(Incident incident);
    void insere(Set<Incident> is);
}
