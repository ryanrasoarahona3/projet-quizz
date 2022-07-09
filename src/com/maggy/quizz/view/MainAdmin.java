package com.maggy.quizz.view;

import com.maggy.quizz.dao.UserDAO;
import com.maggy.quizz.model.User;
import com.maggy.quizz.service.DatabaseManager;
import com.maggy.quizz.tableModel.UserTM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainAdmin extends JFrame {
    DatabaseManager dm;

    public MainAdmin() throws SQLException {
        dm = DatabaseManager.getInstance();
        dm.init();

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);

        // CRUD USER
        MainAdminCrudUser maCrudUser = new MainAdminCrudUser();
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(maCrudUser, c);

        // CRUD Quizz
        MainAdminCrudQuizz maCrudQuizz = new MainAdminCrudQuizz();
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(maCrudQuizz, c);

        // USER EDITION Form

        //

        setContentPane(contentPane);
        setSize(new Dimension(600, 600));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws SQLException {
        new MainAdmin();
    }
}
