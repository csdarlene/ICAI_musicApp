package designPatterns.patternStructural.Composite;


import entity.Songs;

public class MainComposite {
    public static void MainComposite(){

        ServiceStructural userService1 = new UserService(new Songs("Get Into (Yuh)",2.18));
        ServiceStructural userService2 = new UserService(new Songs("Need to Know",3.31));
        ServiceStructural adminService1 = new AdminService(new Songs("On BS",4.22));
        ServiceStructural adminService2 = new AdminService(new Songs("There He Go",3.16));

        ServiceProvider serviceProvider = new ServiceProvider();

        serviceProvider.addSong(userService1);
        serviceProvider.addSong(userService2);
        serviceProvider.service("Added songs");

        Double totalLength = serviceProvider.getLength();
        System.out.println("Total length: "+totalLength+"\n");

        serviceProvider.deleteSong(userService1);

        serviceProvider.service("Song kept");
        Double newtotalLength = serviceProvider.getLength();
        System.out.println("Total length: "+ newtotalLength+"\n");

        serviceProvider.clearServices();

        serviceProvider.addSong(adminService2);
        serviceProvider.addSong(adminService1);
        serviceProvider.service("Added songs");

        Double newTotalLength = serviceProvider.getLength();
        System.out.println("Total length: "+ newTotalLength+"\n");

        serviceProvider.clearServices();

        serviceProvider.addSong(userService1);
        serviceProvider.service("Updated List");

    }
}
