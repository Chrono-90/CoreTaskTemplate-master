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
        Util.getSession().beginTransaction();
        Util.getSession().save(new User(name, lastName, age));
        Util.getSession().getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        Util.getSession().beginTransaction();
        Util.getSession().delete(Util.getSession().get(User.class, id));
        Util.getSession().getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        Util.getSession().beginTransaction();
        List<User> spisok = Util.getSession().createQuery("from User").getResultList();
        Util.getSession().getTransaction().commit();
        return spisok;
    }
    @Override
    public void cleanUsersTable() {
        Util.getSession().beginTransaction();
        Util.getSession().createQuery("delete from User").executeUpdate();
        Util.getSession().getTransaction().commit();
    }
}
