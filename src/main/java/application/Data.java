package application;


import entity.*;
import service.*;

public class Data {

    AlbumService albumService = new AlbumService();
    RecordLabelService recordLabelService = new RecordLabelService();
    PlaylistService playlistService = new PlaylistService();
    ArtistService artistService = new ArtistService();
    UserService userService = new UserService();
    UserDetailService userDetailService = new UserDetailService();
    SongService songService = new SongService();

    public void infromation() {
        //Albums
        Albums album1 = new Albums();
        Albums album2 = new Albums();
        Albums album3 = new Albums();
        Albums album4 = new Albums();

        album1.setName("Planet Her");
        album1.setYear(2021);
        album2.setName("Suripop XV");
        album2.setYear(2008);
        album3.setName("Painting Pictures");
        album3.setYear(2017);
        album4.setName("Louder");
        album4.setYear(2013);

        Albums album5 = new Albums("Funk Wav Bounces Vol. 2", 2022);
        albumService.createAlbums(album5);

        Albums album6 = new Albums("FI Created Disco", 2009);
        albumService.createAlbums(album6);

        Albums album7 = new Albums("18 Months", 2012);
        albumService.createAlbums(album7);

        Albums album8 = new Albums("Motion", 2014);
        albumService.createAlbums(album8);

        albumService.createAlbums(album1);
        albumService.createAlbums(album2);
        albumService.createAlbums(album3);
        albumService.createAlbums(album4);

        Albums album9 = new Albums("Phases", 2019);
        albumService.createAlbums(album9);

        Albums album10 = new Albums("Twelve Carat Toothache", 2022);
        albumService.createAlbums(album10);

        Albums album11 = new Albums("Her Loss", 2022);
        albumService.createAlbums(album11);

        // Userdetails
        UserDetails userDetail1 = new UserDetails();
        UserDetails userDetail2 = new UserDetails();
        UserDetails userDetail3 = new UserDetails();

        userDetail1.setName("Darlene");
        userDetail1.setBirthday("16-05-2000");
        userDetail1.setEmail("darlene@mail.sr");

        userDetail2.setName("Alex");
        userDetail2.setBirthday("20-02-1982");
        userDetail2.setEmail("alex@mail.sr");

        userDetail3.setName("Britney");
        userDetail3.setBirthday("09-11-1998");
        userDetail3.setEmail("britney@mail.sr");


        userDetailService.createUserDetails(userDetail1);
        userDetailService.createUserDetails(userDetail2);
        userDetailService.createUserDetails(userDetail3);

        //RecordLabel
        RecordLabels recordLabels1 = new RecordLabels();
        RecordLabels recordLabels2 = new RecordLabels();
        RecordLabels recordLabels3 = new RecordLabels();

        recordLabels1.setName("Republic Records");
        recordLabels2.setName("RCA Records");
        recordLabels3.setName("Atlantic Records");

        recordLabelService.createRecordLabel(recordLabels1);
        recordLabelService.createRecordLabel(recordLabels2);
        recordLabelService.createRecordLabel(recordLabels3);

        RecordLabels recordLabels4 = new RecordLabels("Columbia Records");
        recordLabelService.createRecordLabel(recordLabels4);

        RecordLabels recordLabels5 = new RecordLabels("Slaughter Gang");
        recordLabelService.createRecordLabel(recordLabels5);

        RecordLabels recordLabels6 = new RecordLabels("OVO Sound");
        recordLabelService.createRecordLabel(recordLabels6);

        //Artists
        Artists artist1 = new Artists();
        Artists artist2 = new Artists();
        Artists artist3 = new Artists();

        artist1.setName("Doja Cat");
        artist1.setRecordLabelID(recordLabels2);
        artist2.setName("Ariana Grande");
        artist2.setRecordLabelID(recordLabels1);
        artist3.setName("Kodak Black");
        artist3.setRecordLabelID(recordLabels3);

        artistService.createArtist(artist1);
        artistService.createArtist(artist2);
        artistService.createArtist(artist3);

        Artists artist4 = new Artists("Calvin Harris", recordLabels4);
        artistService.createArtist(artist4);

        Artists artist5 = new Artists("PrettyMuch", null);
        artistService.createArtist(artist5);

        Artists artist6 = new Artists("Post Malone", recordLabels1);
        artistService.createArtist(artist6);


        Artists artist7 = new Artists("Drake", recordLabels6);
        artistService.createArtist(artist7);

        Artists artist8 = new Artists("21 Savage", recordLabels5);
        artistService.createArtist(artist8);

        Artists artist9 = new Artists("Clinton Kearsenhout", null);
        artistService.createArtist(artist9);

        // Songs
        Songs song1 = new Songs();
        Songs song2 = new Songs();
        Songs song3 = new Songs();

        song1.setName("Sori mi na pasi");
        song1.setTime(4.22);
        song1.setAlbumID(album2);
        song2.setName("You Right");
        song2.setTime(3.06);
        song2.setAlbumID(album1);
        song3.setName("Tunnel Vision");
        song3.setTime(4.28);
        song3.setAlbumID(album3);

        songService.createSongs(song1);
        songService.createSongs(song2);
        songService.createSongs(song3);

        Songs song4 =new Songs("Phases",3.36, album9);
        Songs song5 =new Songs("Eyes Off You",3.24, album9);
        Songs song6 =new Songs("4U",3.24, album9);
        Songs song7 =new Songs("Gone 2 Long",3.15, album9);
        Songs song8 =new Songs("Temporary",3.12, album9);
        Songs song9 =new Songs("One Shot",3.08, album9);
        Songs song10 =new Songs("I Like You (A Happier Song)",3.12, album10);

        songService.createSongs(song4);
        songService.createSongs(song5);
        songService.createSongs(song6);
        songService.createSongs(song7);
        songService.createSongs(song8);
        songService.createSongs(song9);
        songService.createSongs(song10);

        // Users
        Users user1 = new Users();
        Users user2 = new Users();
        Users user3 = new Users();
        Users user0 ;

        user1.setUsername("darlene111");
        user1.setPassword("Password");
        user1.setUserDetails(userDetail1);
        user2.setUsername("snowman");
        user2.setPassword("q1w2e3r4t5");
        user2.setUserDetails(userDetail2);
        user3.setUsername("something");
        user3.setPassword("qwertyuiop");
        user3.setUserDetails(userDetail3);


        userService.createUsers(new Users("admin","ADMIN",null));
        userService.createUsers(user1);
        userService.createUsers(user2);
        userService.createUsers(user3);

        userService.createUsers(user0 = new Users("darlene","darlene",null));
        userService.createUsers(user0);

        // Playlists
        Playlists playlist1 = new Playlists();
        Playlists playlist2 = new Playlists();
        Playlists playlist3 = new Playlists();

        playlist1.setName("Favs");
        playlist1.setUserID(user2);
        playlist2.setName("Best Of 2022");
        playlist2.setUserID(user1);
        playlist3.setName("Workout Playlist");
        playlist3.setUserID(user1);

        playlistService.createPlaylists(playlist1);
        playlistService.createPlaylists(playlist2);
        playlistService.createPlaylists(playlist3);

//      join playlist en songs
        playlist1.getSongSet().add(song1);
        song1.getPlaylistSet().add(playlist1);

        playlist2.getSongSet().add(song2);
        song2.getPlaylistSet().add(playlist2);

        playlist3.getSongSet().add(song2);
        song2.getPlaylistSet().add(playlist3);

        playlist2.getSongSet().add(song4);
        song4.getPlaylistSet().add(playlist2);

        playlist1.getSongSet().add(song7);
        song7.getPlaylistSet().add(playlist1);

        playlist2.getSongSet().add(song9);
        song9.getPlaylistSet().add(playlist2);

        playlist3.getSongSet().add(song10);
        song10.getPlaylistSet().add(playlist3);

        playlist3.getSongSet().add(song5);
        song5.getPlaylistSet().add(playlist3);

        playlist3.getSongSet().add(song6);
        song6.getPlaylistSet().add(playlist3);

        playlist1.getSongSet().add(song8);
        song8.getPlaylistSet().add(playlist1);

//       join artist en song
        artist1.getSongSet().add(song2);
        song2.getArtistSet().add(artist1);

        artist9.getSongSet().add(song1);
        song1.getArtistSet().add(artist9);

        artist3.getSongSet().add(song3);
        song3.getArtistSet().add(artist3);

        artist5.getSongSet().add(song4);
        song4.getArtistSet().add(artist5);

        artist5.getSongSet().add(song5);
        song5.getArtistSet().add(artist5);

        artist5.getSongSet().add(song6);
        song6.getArtistSet().add(artist5);

        artist5.getSongSet().add(song7);
        song7.getArtistSet().add(artist5);

        artist5.getSongSet().add(song8);
        song8.getArtistSet().add(artist5);

//      join album en artist
        artist9.getAlbumSet().add(album1);
        album1.getArtistSet().add(artist9);

        artist2.getAlbumSet().add(album2);
        album2.getArtistSet().add(artist2);

        artist3.getAlbumSet().add(album3);
        album3.getArtistSet().add(artist3);

        artist4.getAlbumSet().add(album5);
        album5.getArtistSet().add(artist1);

        artist4.getAlbumSet().add(album6);
        album6.getArtistSet().add(artist4);

        artist4.getAlbumSet().add(album7);
        album7.getArtistSet().add(artist4);

        artist4.getAlbumSet().add(album8);
        album8.getArtistSet().add(artist4);

        artist5.getAlbumSet().add(album9);
        album9.getArtistSet().add(artist5);

        artist6.getAlbumSet().add(album10);
        album10.getArtistSet().add(artist6);

        artist7.getAlbumSet().add(album11);
        album11.getArtistSet().add(artist7);

        artist8.getAlbumSet().add(album11);
        album11.getArtistSet().add(artist8);

    }
}

