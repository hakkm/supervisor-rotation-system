package com.khabir.supervisorrotationsystem.dao;

import com.khabir.supervisorrotationsystem.Incident;

import java.util.Set;

/**
 * @author khabir
 **/
public interface IncidentDao {
    void insere(Incident incident);
    void insere(Set<Incident> is);
}
