package com.khabir.supervisorrotationsystem.dao;


import com.khabir.supervisorrotationsystem.Incident;

import java.util.Set;

/**
 * @author khabir
 **/
public class IncidentDaoImpl implements IncidentDao {
   private static final String URL = "jdbc:postgresql://localhost:5432/supervisor_rotation_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "890??jomo";
    @Override
    public void insere(Incident incident) {
        System.out.println("IncidentDaoImpl.insere");
    }

    @Override
    public void insere(Set<Incident> is) {
        System.out.println("IncidentDaoImpl.insere");
    }
}
