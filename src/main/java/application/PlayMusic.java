package application;

import java.awt.*;
import java.io.File;

public class PlayMusic {
    public void Play(String songName){
        try {
            File file = new File("src/main/resources/Songs/"+songName+".mp3");
            if (!Desktop.isDesktopSupported())
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())
                desktop.open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

