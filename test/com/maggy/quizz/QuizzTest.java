package com.maggy.quizz;

import com.maggy.quizz.dao.QuizzDAO;
import com.maggy.quizz.model.Quizz;
import com.maggy.quizz.service.DatabaseManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuizzTest {
    QuizzDAO qd;
    DatabaseManager dm;

    @BeforeEach
    public void init() throws SQLException {
        qd = QuizzDAO.getInstance();
        dm = DatabaseManager.getInstance();
        dm.init();

        qd.destroySQLTable();
        qd.buildSQLTable();
    }

    @Test
    public void testInsertion() throws SQLException {
        Quizz q = new Quizz();
        q.setQuestion("3+3 ?");
        q.setReponse1("3");
        q.setReponse2("6");
        q.setReponse3("9");
        q.setReponse4("10");
        q.setAnswer(2);

        qd.add(q);
        assertEquals(q.getId(), 1);

        ArrayList<Quizz> quizz_list = qd.getAll();
        assertEquals(1, quizz_list.size());
    }
}
