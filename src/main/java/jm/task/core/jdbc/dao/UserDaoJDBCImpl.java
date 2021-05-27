package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        Connection connection = null;
        try {
            connection = Util.getConnectionDB();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    "firstname VARCHAR (45) NOT NULL," +
                    "lastname VARCHAR (45) NOT NULL," +
                    "age INT NOT NULL," +
                    "PRIMARY KEY (id))");
            System.out.println("Таблица пользователей создана");
        } catch (Exception s) {
            System.out.println(s);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Connection connection = null;
        try {
            connection = Util.getConnectionDB();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE users");
            System.out.println("Таблица пользователей удалена");
        } catch (Exception s) {
            System.out.println(s);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Connection connection = null;
        try {
            connection = Util.getConnectionDB();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (firstname, lastname, age) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (Exception s) {
            System.out.println(s);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Connection connection = null;
        try {
            connection = Util.getConnectionDB();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setLong(1, id);
            statement.execute();
            System.out.printf("Пользователь по id %d удалён \n", id);
        } catch (Exception s) {
            System.out.println(s);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Util.getConnectionDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
                System.out.println(user);
            }
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Connection connection = null;
        try {
            connection = Util.getConnectionDB();
            Statement statement = connection.createStatement();
            statement.execute("TRUNCATE TABLE users");
            System.out.println("Таблица пользователей очищена");
        } catch (SQLException s) {
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
