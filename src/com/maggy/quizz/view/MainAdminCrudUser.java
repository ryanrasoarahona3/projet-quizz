package com.maggy.quizz.view;

import com.maggy.quizz.tableModel.UserTM;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainAdminCrudUser extends JPanel {
    public MainAdminCrudUser() throws SQLException {
        setLayout(new BorderLayout());

        JPanel tableContainer = new JPanel();
        tableContainer.setLayout(new BorderLayout());
        JLabel labelHead = new JLabel("Liste des Utilisateurs");

        UserTM tableModel = new UserTM();
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);


        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
        tableContainer.add(table, BorderLayout.CENTER);
        tableContainer.add(table.getTableHeader(), BorderLayout.NORTH);
        add(tableContainer, BorderLayout.CENTER);
        add(labelHead, BorderLayout.NORTH);
    }
}
