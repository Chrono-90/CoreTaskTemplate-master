package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl table = new UserServiceImpl();
        table.createUsersTable();
        table.saveUser("Alex", "Enot", (byte) 31);
        table.saveUser("Alexey", "Komissar", (byte) 35);
        table.saveUser("Arcasha", "Pocemon", (byte) 30);
        table.saveUser("Anna", "Kumiho", (byte) 34);
        table.saveUser("Alexeich", "Sanich", (byte) 34);
        table.getAllUsers();
        table.cleanUsersTable();
        table.dropUsersTable();
    }
}