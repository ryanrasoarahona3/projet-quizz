package com.maggy.quizz;

import com.maggy.quizz.service.DatabaseManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseManagerTest {
    @Test
    void databaseWorks() throws SQLException {
        DatabaseManager dm = DatabaseManager.getInstance();
        dm.init();
        assertNotNull(dm.getConnection());
    }
}
