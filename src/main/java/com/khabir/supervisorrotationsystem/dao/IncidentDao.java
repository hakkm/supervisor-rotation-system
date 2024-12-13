package com.khabir.dao;

import com.khabir.Incident;

import java.util.Set;

/**
 * @author khabir
 **/
public interface IncidentDao {
    void insere(Incident incident);
    void insere(Set<Incident> is);
}
