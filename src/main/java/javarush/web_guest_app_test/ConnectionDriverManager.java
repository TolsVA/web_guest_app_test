package javarush.web_guest_app_test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConnectionDriverManager {
    private static final String URL="url";
    private static final String USERNAME="username";
    private static final String PASSWORD="password";
    private static final String DRIVER="driver";

    public static Connection open() throws ClassNotFoundException, SQLException {
        Class.forName(PropertiesConfig.get(DRIVER));

        return DriverManager.getConnection(PropertiesConfig.get(URL),
                PropertiesConfig.get(USERNAME),
                PropertiesConfig.get(PASSWORD));
    }
}
