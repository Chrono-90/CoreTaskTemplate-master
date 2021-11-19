package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private final static String HOST = "jdbc:mysql://localhost:3306/wwww";
    private final static String USERNAME = "root";
    private final static String PASS = "Romastebyapivo";

    private static SessionFactory sessionFactory;

    public static Session getSession() {


        if (sessionFactory == null) {

                Configuration config = new Configuration();
                Properties set = new Properties();
                set.setProperty("Hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                set.setProperty("Hibernate.connection.url", HOST);
                set.setProperty("Hibernate.connection.user", USERNAME);
                set.setProperty("Hibernate.connection.pass", PASS);
                set.setProperty("Hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                set.setProperty("Hibernate.show_sql", "true");
                set.setProperty("Hibernate.current_session_context_class", "thread");
                set.setProperty("Hibernate.hbm2ddl_auto", "update");
                config.setProperties(set);
                config.addAnnotatedClass(User.class);
                ServiceRegistry serv = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
                sessionFactory = config.buildSessionFactory(serv);

        }
        return sessionFactory.getCurrentSession();
    }

    public Connection getConnect() {
        Connection connection = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(HOST, USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

