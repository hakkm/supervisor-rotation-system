package com.khabir.supervisorrotationsystem.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.khabir.supervisorrotationsystem.model.Member;
import com.khabir.supervisorrotationsystem.dao.impl.MembreDaoImpl;

public class SupervisorController {
    @FXML
    public Button addButton;
    public TextField lnameField;
    public TextField fnameField;
    public TextField emailField;
    public TextField phoneField;
    @FXML
    private Label welcomeText;

    private MembreDaoImpl membreDao;

    public SupervisorController() {
        membreDao = new MembreDaoImpl();
    }

    @FXML
    public void addMember(ActionEvent actionEvent) {
        String lname = lnameField.getText();
        String fname = fnameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        Member member = new Member(lname, fname, email, phone);
        membreDao.insere(member);

        lnameField.setText("");
        fnameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }
}