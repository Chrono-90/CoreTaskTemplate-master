package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    UserDao dao = new UserDaoJDBCImpl();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        dao.createUsersTable();
    }


    @Override
    public void dropUsersTable() {
        dao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
        Util.getSession().beginTransaction();
        Util.getSession().save(new User(name, lastName, age));
        Util.getSession().getTransaction().commit();
    } catch (Exception e) {
            if (Util.getSession() != null) {
                Util.getSession().getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            Util.getSession().close();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Util.getSession().beginTransaction();
            Util.getSession().delete(Util.getSession().get(User.class, id));
            Util.getSession().getTransaction().commit();
        } catch (Exception e) {
            if (Util.getSession() != null) {
                Util.getSession().getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            Util.getSession().close();
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> spisok = null;
        try {
            Util.getSession().beginTransaction();
            spisok = Util.getSession().createQuery("from User").getResultList();
            Util.getSession().getTransaction().commit();

        } catch (Exception e) {
            if (Util.getSession() != null) {
                Util.getSession().getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            Util.getSession().close();
        }
        return spisok;
    }
    @Override
    public void cleanUsersTable() {
        try {
        Util.getSession().beginTransaction();
        Util.getSession().createQuery("delete from User").executeUpdate();
        Util.getSession().getTransaction().commit();
        } catch (Exception e) {
            if (Util.getSession() != null) {
                Util.getSession().getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            Util.getSession().close();
        }

    }
}
