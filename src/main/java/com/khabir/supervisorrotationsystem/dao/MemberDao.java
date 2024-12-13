package com.khabir.dao;

import com.khabir.Incident;
import com.khabir.Member;

import java.util.List;

/**
 * @author khabir
 **/
public interface MemberDao {
    void insere(Member member);
    List<Incident> chargerListIncidents();
}
