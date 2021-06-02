package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Util {

    public static Connection getConnectionDB() throws Exception {
        final String DB_URL = "jdbc:mysql://localhost:3306/pp_1";
        final String USERNAME = "varejjjka";
        final String PASSWORD = "varejjjka";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/pp_1");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.USER, "varejjjka");
        properties.put(Environment.PASS, "varejjjka");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(jm.task.core.jdbc.model.User.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }


}
