package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        Statement ave;
        String s = "create table if not exists table_user\n" +
                "(\n" +
                "\tid int auto_increment,\n" +
                "\tname varchar(15) null,\n" +
                "\tlastName varchar(15) null,\n" +
                "\tage int null,\n" +
                "\tconstraint table_user\n" +
                "\t\tprimary key (id)\n" +
                ");";

        try {
            ave = getConnect().createStatement();
            ave.execute(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void dropUsersTable() {
        Statement ave;
        String dr = "drop table if exists table_user";
        try {
            ave = getConnect().createStatement();
            ave.execute(dr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement pg;
        String sv = "insert into table_user (name, lastname, age)values(?, ?, ?)";
        try {
            getConnect().setAutoCommit(false);
            pg = getConnect().prepareStatement(sv);
            pg.setString(1,name);
            pg.setString(2,lastName);
            pg.setByte(3, age);
            pg.execute();
            getConnect().commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                getConnect().rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeUserById(long id) {
        PreparedStatement gg;
        String ss = "delete from table_user where id = ?";
        try {
            getConnect().setAutoCommit(false);
            gg = getConnect().prepareStatement(ss);
            gg.setLong(1, id);
            gg.execute();
            getConnect().commit();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {
            try {
                getConnect().rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> spisok = new ArrayList<>();
        Statement ave;
        try {
            getConnect().setAutoCommit(false);
            ave = getConnect().createStatement();
            ResultSet sqa = ave.executeQuery("select name, lastname, age from table_user");
            getConnect().commit();
            while (sqa.next()) {
                String name = sqa.getString(1);
                String lastname = sqa.getString(2);
                long age = sqa.getLong(3);
                User Vasya = new User(name, lastname, (byte) age);
                spisok.add(Vasya);

            }
            System.out.println(spisok);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return spisok;
    }
    public void cleanUsersTable() {
        Statement ave;
        String clean = "truncate table table_user";
        try {
            ave = getConnect().createStatement();
            ave.execute(clean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
}
