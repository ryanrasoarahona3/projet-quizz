package com.maggy.quizz;

import com.maggy.quizz.dao.UserDAO;
import com.maggy.quizz.model.User;
import com.maggy.quizz.service.DatabaseManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserTest {
    UserDAO ud;
    DatabaseManager dm;

    @BeforeEach
    public void init() throws SQLException {
        ud = UserDAO.getInstance();
        dm = DatabaseManager.getInstance();
        dm.init();

        ud.destroySQLTable();
        ud.buildSQLTable();
    }

    @Test
    public void testInsertion() throws SQLException {
        User u = new User();
        u.setEmail("maggy@gmail.com");
        u.setPseudo("maggy");
        u.setPassword("password");
        u.setPrivilege("user");

        ud.add(u);
        assertEquals(u.getId(), 1);

        ArrayList<User> user_list = ud.getAll();
        assertEquals(user_list.size(), 1);
    }

    @AfterEach
    public void tearDown(){

    }
}
