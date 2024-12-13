package com.khabir.supervisorrotationsystem.dao.impl;

import com.khabir.supervisorrotationsystem.dao.IncidentDao;
import com.khabir.supervisorrotationsystem.model.Incident;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;


    static {
        Properties properties = new Properties();
        try (InputStream input = IncidentDaoImpl.class.getClassLoader().getResourceAsStream("config.properties")) {
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
    public void insere(Incident incident) {
        String sql = "INSERT INTO incidents (id, time, status, member_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, incident.getId());
            pstmt.setTime(2, Time.valueOf(incident.getTime()));
            pstmt.setString(3, incident.getStatus());
            pstmt.setString(4, incident.getMember().getId());
            pstmt.executeUpdate();
            System.out.println("Incident inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insere(Set<Incident> incidents) {
        String sql = "INSERT INTO incidents (id, time, status, member_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Incident incident : incidents) {
                pstmt.setString(1, incident.getId());
                pstmt.setTime(2, Time.valueOf(incident.getTime()));
                pstmt.setString(3, incident.getStatus());
                pstmt.setString(4, incident.getMember().getId());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("Incidents inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
