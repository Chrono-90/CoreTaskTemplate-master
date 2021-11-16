package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl table = new UserDaoJDBCImpl();
        table.createUsersTable();
        table.saveUser("Alex", "Enot", (byte) 31);

        table.saveUser("Alexey", "Komissar", (byte) 35);

       table.saveUser("", "", (byte) 30);
//
//        table.saveUser("Anna", "Kumiho", (byte) 34);
//
//        table.saveUser("Alexeich", "Sanich", (byte) 34);
        table.getAllUsers();
//        table.cleanUsersTable();
//        table.dropUsersTable();

    }
}
