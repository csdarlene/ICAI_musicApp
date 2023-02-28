package designPatterns.patternStructural.Proxy;

import entity.UserDetails;
import entity.Users;

public class MainProxy {
    public static void MainProxy() throws Exception {
        UserDatabase user1 = new UserDatabaseProxy(new Users("dani","1233",new UserDetails("Dan","11-11-1975", "dani@mail.com")));
        user1.executeDatabase("INSERT SONG");

        UserDatabase admin = new UserDatabaseProxy(new Users("admin","ADMIN",null));
        admin.executeDatabase("DELETE SONG");

        UserDatabase user2 = new UserDatabaseProxy(new Users("jan","1234",new UserDetails("Nelle","16-09-1988", "nel@mail.com")));
        user2.executeDatabase("DELETE SONG");




    }

}
