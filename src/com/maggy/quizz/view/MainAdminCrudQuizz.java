package com.maggy.quizz.view;

import com.maggy.quizz.tableModel.QuizzTM;
import com.maggy.quizz.tableModel.UserTM;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainAdminCrudQuizz extends JPanel {
    public MainAdminCrudQuizz() throws SQLException {
        setLayout(new BorderLayout());
        JPanel tableContainer = new JPanel();
        tableContainer.setLayout(new BorderLayout());

        QuizzTM tableModel = new QuizzTM();

        JTable table = new JTable(tableModel);
        table.setSize(600, 600);
        //JTable table = new JTable(data, columns);


        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JLabel labelHead = new JLabel("Liste des Quizz");
        labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));

        tableContainer.add(table, BorderLayout.CENTER);
        tableContainer.add(table.getTableHeader(), BorderLayout.NORTH);

        add(labelHead, BorderLayout.NORTH);
        add(tableContainer, BorderLayout.CENTER);

    }
}
