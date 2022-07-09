package com.maggy.quizz.tableModel;

import com.maggy.quizz.dao.QuizzDAO;
import com.maggy.quizz.model.Quizz;
import com.maggy.quizz.service.DataSeedManager;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuizzTM extends AbstractTableModel {

    private final String[] entetes = { "Id", "Question", "R1", "R2", "R3", "R4", "Réponse"};

    DataSeedManager dsm = DataSeedManager.getInstance();
    QuizzDAO qd = QuizzDAO.getInstance();
    private ArrayList<Quizz> quizz_list;

    public QuizzTM() throws SQLException {
        dsm.sow();
        quizz_list = qd.getAll();
    }

    @Override
    public int getRowCount() {
        return quizz_list.size();
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
                return quizz_list.get(rowIndex).getId();

            case 1:
                // Email
                return quizz_list.get(rowIndex).getQuestion();

            case 2:
                // PSeudo
                return quizz_list.get(rowIndex).getReponse1();

            case 3:
                //Password
                return quizz_list.get(rowIndex).getReponse2();

            case 4:
                //Password
                return quizz_list.get(rowIndex).getReponse3();

            case 5:
                //Password
                return quizz_list.get(rowIndex).getReponse4();

            case 6:
                //Password
                return quizz_list.get(rowIndex).getAnswer();

            default:
                throw new IllegalArgumentException();
        }
    }
}
