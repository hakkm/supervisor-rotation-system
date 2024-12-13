package com.khabir.supervisorrotationsystem.dao;

import com.khabir.supervisorrotationsystem.model.Incident;
import com.khabir.supervisorrotationsystem.model.Member;

import java.util.List;

/**
 * @author khabir
 **/
public interface MemberDao {
    void insere(Member member);

    List<Incident> chargerListIncidents();
}
