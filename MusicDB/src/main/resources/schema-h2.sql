CREATE TABLE Artist
        (
        ID NUMBER(10) PRIMARY KEY,
        NAME VARCHAR2(55),
  		CREATED DATE,
		LASTMODIFIED DATE
        );

	CREATE TABLE ALBUM
	        (
	        ID NUMBER(10) PRIMARY KEY,
	        artist_id NUMBER(10),
	        NAME VARCHAR2(55),
	        year_released NUMBER(10),
	        CREATED DATE,
			LASTMODIFIED DATE,
	  		 foreign key (artist_id) references Artist(ID)
	        );
			
	 CREATE TABLE SONG
	        (
	        ID NUMBER(10) PRIMARY KEY,
	        album_id NUMBER(10),
	        TRACK NUMBER(55),
	        NAME VARCHAR2(125),
	        CREATED DATE,
			LASTMODIFIED DATE,
	  		 foreign key (album_id) references Album(id)
	        );
			       
      