package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Рейчел", "Грин", (byte)24);
        userDaoJDBC.saveUser("Моника", "Геллер", (byte)24);
        userDaoJDBC.saveUser("Джо", "Триббиани", (byte)26);
        userDaoJDBC.saveUser("Чендлер", "Бинг", (byte)26);

      userDaoJDBC.getAllUsers();

        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();
    }
}
