package com.khabir.supervisorrotationsystem.dao;

import com.khabir.supervisorrotationsystem.Incident;
import com.khabir.supervisorrotationsystem.Member;

import java.util.List;

/**
 * @author khabir
 **/
public interface MemberDao {
    void insere(Member member);

    List<Incident> chargerListIncidents();
}
