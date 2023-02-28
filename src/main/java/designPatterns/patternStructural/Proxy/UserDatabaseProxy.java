package designPatterns.patternStructural.Proxy;

import entity.Users;

import java.util.Objects;

public class UserDatabaseProxy implements UserDatabase {
    boolean ifAdmin;
    UserDatabaseImpl Executer;

    public UserDatabaseProxy( Users users ) {
        if (Objects.equals(users.getUsername(), "admin") && Objects.equals(users.getPassword(), "ADMIN")) {
            ifAdmin = true;
        }
        Executer = new UserDatabaseImpl();
    }

    @Override
    public void executeDatabase( String query ) throws Exception {
        if (ifAdmin) {
            Executer.executeDatabase(query);
        } else {
            if (query.equals("DELETE SONG")) {
                throw new Exception("DELETE not allowed for non-admin user");
            } else {
                Executer.executeDatabase(query);
            }
        }
    }

}
