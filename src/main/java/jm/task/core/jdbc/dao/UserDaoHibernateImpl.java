//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//import org.hibernate.Session;
//
//import java.util.List;
//
//public class UserDaoHibernateImpl implements UserDao {
//    UserDao dao = new UserDaoJDBCImpl();
//    public UserDaoHibernateImpl() {
//
//    }
//
//
//    @Override
//    public void createUsersTable() {
//        dao.createUsersTable();
//    }
//
//
//    @Override
//    public void dropUsersTable() {
//        dao.dropUsersTable();
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        Session session = Util.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.save(new User(name, lastName, age));
//        session.getTransaction().commit();
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        Session session = Util.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.delete(session.get(User.class, id));
//        session.getTransaction().commit();
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return null;
//    }
//    Session session = Util.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//    List<User> userList = session.createQuery("from User").getResultList();
//        session.getTransaction().commit();
//        return userList;
//    @Override
//    public void cleanUsersTable() {
//        Session session = Util.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.createQuery("delete from User").executeUpdate();
//        session.getTransaction().commit();
//    }
//}
