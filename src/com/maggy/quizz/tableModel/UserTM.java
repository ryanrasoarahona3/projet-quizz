package com.maggy.quizz.tableModel;

import com.maggy.quizz.dao.UserDAO;
import com.maggy.quizz.model.User;
import com.maggy.quizz.service.DataSeedManager;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTM extends AbstractTableModel {

    private final String[] entetes = { "Id", "Email", "Pseudo", "Password"};

    DataSeedManager dsm = DataSeedManager.getInstance();
    UserDAO ud = UserDAO.getInstance();
    private ArrayList<User> user_list;

    public UserTM() throws SQLException {
        dsm.sow();
        user_list = ud.getAll();

    }

    @Override
    public int getRowCount() {
        return user_list.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                // ID
                return user_list.get(rowIndex).getId();

            case 1:
                // Email
                return user_list.get(rowIndex).getEmail();

            case 2:
                // PSeudo
                return user_list.get(rowIndex).getPseudo();

            case 3:
                //Password
                return user_list.get(rowIndex).getPassword();

            default:
                throw new IllegalArgumentException();
        }
    }
}
