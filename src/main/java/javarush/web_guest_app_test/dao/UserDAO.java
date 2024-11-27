package javarush.web_guest_app_test.dao;

import javarush.web_guest_app_test.ConnectionDriverManager;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {


    public UserDAO() {
    }

    public boolean authenticate(String username, String password) {
//        return addUser(username, password);
        return addUser2(username, password);
    }

    private boolean addUser2(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = ConnectionDriverManager.open();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            return stmt.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            return false;
        }
    }

    public boolean addUser(String username, String password) {
        // Строка SQL для вставки нового пользователя
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        Context context = null;
        try {
            context = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        DataSource dataSource = null;
        try {
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MyDB");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Создаем PreparedStatement
            conn.setAutoCommit(false);
            // Устанавливаем параметры для запроса
            stmt.setString(1, username);  // Устанавливаем username
            stmt.setString(2, password);  // Устанавливаем password

            // Выполняем запрос
            int rowsAffected = stmt.executeUpdate();

            conn.commit(); // Явное подтверждение транзакции
            // Если количество затронутых строк больше 0, значит запись успешна
            return rowsAffected > 0;

        } catch (SQLException e) {
            return false;
        }
    }
}