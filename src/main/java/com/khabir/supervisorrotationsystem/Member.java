package com.khabir.supervisorrotationsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
  private String id;
  private String nom;
  private String prenom;
  private String email;
  private String phone;
  private List<Incident> incidents;

  public Member(String lname, String fname, String email, String phone) {
    this.nom = lname;
    this.prenom = fname;
    this.email = email;
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Member member))
      return false;
    return Objects.equals(getId(), member.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}