package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Рейчел", "Грин", (byte) 24);
        userDaoHibernate.saveUser("Моника", "Геллер", (byte) 24);
        userDaoHibernate.saveUser("Джо", "Триббиани", (byte) 26);
        userDaoHibernate.saveUser("Чендлер", "Бинг", (byte) 26);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.removeUserById(4);
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();


    }
}
