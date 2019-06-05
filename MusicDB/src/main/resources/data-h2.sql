--Artists----------------------------------------------------------------------
insert into artist(id, name) values (1, 'Muse')
insert into artist(id, name) values (2, 'Duran Duran')
insert into artist(id, name) values (3, 'Van Halen')

--Albums----------------------------------------------------------------------
insert into album(id, artist_id,  name, year_released) values (1, 1,  'Drones', 2015)
insert into album(id, artist_id,  name, year_released) values (2, 1, 'Origin of Symmetry', 2001)
insert into album(id, artist_id,  name, year_released) values (3, 2, 'Rio', 1982)
insert into album(id, artist_id,  name, year_released) values (4, 2, '1984', 1984)

--insert into artist_albums(artist_id, albums_id) values(1, 1)
--insert into artist_albums(artist_id, albums_id) values(1, 2)
--insert into artist_albums(artist_id, albums_id) values(2, 3)
--insert into artist_albums(artist_id, albums_id) values(3, 4)

--Songs----------------------------------------------------------------------
--Muse-Drones
insert into song(id, album_id, track, name) values(1, 1, 1, 'Dead Inside')
insert into song(id, album_id, track, name) values(2, 1, 2, 'Drill Sargeant')
insert into song(id, album_id, track, name) values(3, 1, 3, 'Psycho')
insert into song(id, album_id, track, name) values(4, 1, 4, 'Mercy')
insert into song(id, album_id, track, name) values(5, 1, 5, 'Reapers')
insert into song(id, album_id, track, name) values(6, 1, 6, 'The Handler')
insert into song(id, album_id, track, name) values(7, 1, 7, 'JFK')
insert into song(id, album_id, track, name) values(8, 1, 8, 'Defector')
insert into song(id, album_id, track, name) values(9, 1, 9, 'Revolt')
insert into song(id, album_id, track, name) values(10, 1, 10, 'Aftermath')
insert into song(id, album_id, track, name) values(11, 1, 11, 'The Globalist')
insert into song(id, album_id, track, name) values(12, 1, 12, 'Drones')
