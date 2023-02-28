package designPatterns.patternStructural.Proxy;

public class UserDatabaseImpl implements UserDatabase {

    @Override
    public void executeDatabase( String query ) throws Exception {
        System.out.println("Going to: " + query);
    }

}

