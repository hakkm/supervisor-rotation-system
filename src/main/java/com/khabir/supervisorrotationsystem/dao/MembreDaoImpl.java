package com.khabir.supervisorrotationsystem.dao;

import com.khabir.supervisorrotationsystem.Incident;
import com.khabir.supervisorrotationsystem.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author khabir
 **/
public class MembreDaoImpl implements MemberDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/supervisor_rotation_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "890??jomo";

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
        return null;
    }

    public static void main(String[] args) {
        // create the database and the table
        // String sql = "CREATE DATABASE supervisor_rotation_system";
        // try (Connection conn =
        // DriverManager.getConnection("jdbc:postgresql://localhost:5432/", USER,
        // PASSWORD);
        // Statement stmt = conn.createStatement()) {
        // stmt.executeUpdate(sql);
        // System.out.println("Database created successfully");
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        // create the members table
        String sql = "drop table members; CREATE TABLE members (id SERIAL PRIMARY KEY, nom VARCHAR(50), prenom VARCHAR(50), email VARCHAR(50), phone VARCHAR(20))";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
