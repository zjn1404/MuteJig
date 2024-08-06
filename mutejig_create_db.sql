CREATE DATABASE IF NOT EXISTS `mutejig` 
DEFAULT CHARACTER SET utf8mb4 
COLLATE utf8mb4_bin 
DEFAULT ENCRYPTION='N';

USE mutejig;

CREATE TABLE `user` (
	id			varchar(50) PRIMARY KEY,
    username 	varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE ,
    `password` 	varchar(150) NOT NULL,
    email 		varchar(150) NOT NULL
);

CREATE TABLE `user_detail` (
    user_id			varchar(50) PRIMARY KEY NOT NULL,
    first_name		varchar(150) DEFAULT NULL,
    last_name		varchar(150) DEFAULT NULL,
    phone_number	varchar(10)	DEFAULT NULL,
    dob				datetime,
    CONSTRAINT fk_userdetail_user FOREIGN KEY (user_id) REFERENCES `user`(id)
);

CREATE TABLE `role` (
	`name`			varchar(50) PRIMARY KEY COLLATE utf8mb4_unicode_ci,
    `description`	varchar(150)
);

CREATE TABLE `user_role` (
	user_id		varchar(50) NOT NULL,
    role_name	varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    CONSTRAINT `pk_user_role` PRIMARY KEY (`user_id`, `role_name`),
    CONSTRAINT `fk_userrole_user` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT `fk_userrole_role` FOREIGN KEY (`role_name`) REFERENCES `role`(`name`)
);

CREATE TABLE `permission` (
	`name`			varchar(50) PRIMARY KEY COLLATE utf8mb4_unicode_ci,
    `description`	varchar(150)
);

CREATE TABLE `role_permission` (
	`role_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `permission_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    CONSTRAINT `pk_role_permission` PRIMARY KEY (`role_name`, `permission_name`),
    CONSTRAINT `fk_rolepermission_role` FOREIGN KEY (`role_name`) REFERENCES `role`(`name`),
    CONSTRAINT `fk_rolepermission_permission` FOREIGN KEY (`permission_name`) REFERENCES `permission`(`name`)
);

CREATE TABLE `song` (
	id			varchar(50) PRIMARY KEY,
    poster_id	varchar(50) NOT NULL,
    `name`		varchar(150) NOT NULL COLLATE utf8mb4_unicode_ci,
    `type`		varchar(150) NOT NULL,
    upload_date	datetime,
    `file`		longblob NOT NULL,
    CONSTRAINT `fk_song_user` FOREIGN KEY (`id`) REFERENCES `user`(`id`)
);

CREATE TABLE `singer` (
	id		varchar(50) PRIMARY KEY,
    `name`	varchar(150) NOT NULL COLLATE utf8mb4_unicode_ci
);

CREATE TABLE `song_singer` (
	song_id		varchar(50) NOT NULL,
    singer_id	varchar(50) NOT NULL,
    CONSTRAINT `pk_songsinger` PRIMARY KEY (song_id, singer_id),
    CONSTRAINT `fk_songsinger_song` FOREIGN KEY (song_id) REFERENCES song(id),
    CONSTRAINT `fk_songsinger_singer` FOREIGN KEY (singer_id) REFERENCES singer(id)
);

CREATE TABLE `playlist` (
	id 		varchar(50) PRIMARY KEY,
	`name`	varchar(150) NOT NULL COLLATE utf8mb4_unicode_ci
);

CREATE TABLE `playlist_song` (
	song_id		varchar(50) NOT NULL,
    playlist_id	varchar(50) NOT NULL,
    CONSTRAINT `pk_playlistsong` PRIMARY KEY (song_id, playlist_id),
    CONSTRAINT `fk_playlist_song` FOREIGN KEY (song_id) REFERENCES song(id),
    CONSTRAINT `fk_playlist_playlist` FOREIGN KEY (playlist_id) REFERENCES playlist(id)
);

CREATE TABLE verify_code (
	verify_code varchar(6) not null unique,
    user_id varchar(50) COLLATE utf8mb4_bin,
    CONSTRAINT fk_verifycode_user FOREIGN KEY (user_id) REFERENCES `user`(id)
);

