package com.khabir.dao;

import com.khabir.Incident;

import java.util.Set;

/**
 * @author khabir
 **/
public class IncidentDaoImpl implements IncidentDao {
    @Override
    public void insere(Incident incident) {
        System.out.println("IncidentDaoImpl.insere");
    }

    @Override
    public void insere(Set<Incident> is) {
        System.out.println("IncidentDaoImpl.insere");
    }
}
