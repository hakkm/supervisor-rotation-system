package com.khabir.supervisorrotationsystem.dao.impl;

import com.khabir.supervisorrotationsystem.dao.MemberDao;
import com.khabir.supervisorrotationsystem.model.Incident;
import com.khabir.supervisorrotationsystem.model.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.io.InputStream;
import java.util.Properties;
/**
 * @author khabir
 **/
public class MembreDaoImpl implements MemberDao {

    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;


    static {
        Properties properties = new Properties();
        try (InputStream input = MembreDaoImpl.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new ExceptionInInitializerError("Failed to load database configuration");
        }
        URL = properties.getProperty("db.url");
        USER = properties.getProperty("db.user");
        PASSWORD = properties.getProperty("db.password");
    }

    @Override
    public void insere(Member member) {
        String sql = "INSERT INTO members (nom, prenom, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getNom());
            pstmt.setString(2, member.getPrenom());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getPhone());
            pstmt.executeUpdate();
            System.out.println("Member inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Incident> chargerListIncidents() {
        String sql = "Select * from incidents where member_id = ?";
        List<Incident> incidents = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "1");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Incident incident = new Incident();
                incident.setId(rs.getString("ref"));
                incident.setTime(rs.getTime("time").toLocalTime());
                incident.setStatus(rs.getString("status"));
                incidents.add(incident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }

    public Set<Member> chargerListeMembre(String nomFichier) {
        Set<Member> members = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 5) {
                    Member member = new Member();
                    member.setId(values[0]);
                    member.setNom(values[1]);
                    member.setPrenom(values[2]);
                    member.setEmail(values[3]);
                    member.setPhone(values[4]);
                    members.add(member);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }
}
