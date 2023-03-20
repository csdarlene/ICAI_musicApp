-- ALBUM
select *
from albums;

-- ARTIST & ALBUM
select a.name Artist, al.name Album
from artist_albums aa
         join artists a on aa.artist_id = a.id
         JOIN albums al ON aa.album_id = al.id;

-- ARTIST & SONG
select a.name Artist, s.name Song, al.name Album
from artist_songs sa
         join artists a on sa.artist_id = a.id
         join songs s on sa.song_id = s.id
         INNER JOIN albums al ON s.album_id = al.id;

-- ARTIST
select a.name artist, rl.name record_label
from artists a
         JOIN recordlabels rl ON a.record_label_id = rl.id;

-- PLAYLIST & SONG
select p.name Playlist, s.name Song
from playlist_songs ps
         join playlists p on ps.playlist_id = p.id
         join songs s on ps.song_id = s.id;

-- PLAYLIST
select p.name Playlists, u.username User
from playlists p
         JOIN users u ON p.user_id = u.id;

-- RECORD LABEL
select *
from recordlabels;

-- SONG
select s.name Song, s.time Size, al.name Album
from songs s
         JOIN albums al ON s.album_id = al.id;


-- USERDETAIL
select *
from userdetails;

-- USER
select ud.name, ud.birthday, ud.email, u.username
from users u
         JOIN userdetails ud ON ud.id = u.userdetails_id;


-- where clause on joins
select ud.name, ud.birthday, ud.email, u.username
from users u
         JOIN userdetails ud ON ud.id = u.userdetails_id
where u.username = 'darlene111';

select a.name Artist, s.name Song, al.name Album
from artist_songs sa
         join artists a on sa.artist_id = a.id
         join songs s on sa.song_id = s.id
         INNER JOIN albums al ON s.album_id = al.id
where a.name = 'doja cat';

select a.name Artist, s.name Song, al.name Album
from artist_songs sa
         join artists a on sa.artist_id = a.id
         join songs s on sa.song_id = s.id
         INNER JOIN albums al ON s.album_id = al.id
where al.name = 'phases';


select a.name Artist, al.name Album
from artist_albums aa
         join artists a on aa.artist_id = a.id
         JOIN albums al ON aa.album_id = al.id
where a.name = 'calvin harris';

select p.name Playlist, s.name Songs
from playlist_songs ps
         join playlists p on ps.playlist_id = p.id
         join songs s on ps.song_id = s.id
where p.name = 'Favs';



select p.name Playlists, u.username User
from playlists p
         JOIN users u ON p.user_id = u.id
where u.username='snowman';

-- join tables
select *
from users;
select *
from artists;
select *
from artist_albums;
select *
from artist_songs;
select *
from playlist_songs;
select *
from songs;