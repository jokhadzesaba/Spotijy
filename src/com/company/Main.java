package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Song song = new Song("aink floyd", 1, 120,25);
        System.out.println(song);
        System.out.println("--------------------------------");
        var song3 = new Song("din floyd", 3, 300,450);
        var song4 = new Song("pin floyd", 3, 300,100221);
        var song5 = new Song("pin floyd", 3, 3, 1000);
        var song6 = new Song("pin floyd", 3, 3, 0);
////        System.out.println(song);
        var song1 = new Song("bink floyd", 4, 4,10);
        var song2 = new Song("cin floyd", 1978,5 ,20);
        var album = new Album("dark side of the moon", 1973);
//        System.out.println(album);
        var album1 = new Album("dark side of the moon", 1973);
        Song [] songs = {song,song1,song2};
        System.out.println(album.addSongs(songs));
        Song[]songs1 = {song3,song4};
        System.out.println(album);
        Song[]songs2 = {song5,song6};
        System.out.println(album.addSongs(songs1));
        System.out.println(album.addSongs(songs2));
//        System.out.println(Arrays.toString(album.sortByReleaseYear(false)));
////        System.out.println(Arrays.toString(album.getSongs()));
//        System.out.println(album);
        Song[]songs23 = {song5};
        Song[]singles = {song6};
//////        System.out.println(Arrays.toString(album.getSongs()));
////        System.out.println(Arrays.toString(Album.reverse(album.getSongs())));
//////        System.out.println(album);
        album1.addSongs(songs2);
////        System.out.println(album1);
////
        Album[]albums ={album,album1};
////        Song[]singles = {song6};
        var artist = new Artist("saba", "jokhadze", 2003,albums,singles);
        var artist4 = new Artist("saba1", "jokhadze", 2003,albums,singles);
        var artist5 = new Artist("saba", "jokhadze", 2003,albums,singles);
        var artist1 = new Artist("gaga", "jokhadze", 2003,albums,singles);
        var artist2 = new Artist("soso", "jokhadze", 2003,albums,singles);
        var artist3 = new Artist("soso", "jokhadze", 2003,albums,singles);
////        System.out.println(artist.leastLikedSong());
        var spotiJy = new SpotiJy();
        spotiJy.addArtist(new Artist[]{artist1,artist,artist2,artist3});
        spotiJy.addArtist(new Artist[]{artist4,artist5});
//        System.out.println(Arrays.toString(spotiJy.getArtists()));
//        System.out.println(Arrays.toString(spotiJy.getTopTrendingArtist()));
//        System.out.println(spotiJy.getTopTrendingAlbum());
//        System.out.println(spotiJy.getTopTrendingSong());
//
//
        System.out.println(Arrays.toString(spotiJy.getTopTrendingArtist()));
            int s = 34;
            double x = Math.round(((double)s/60)*100);

        System.out.println(x/100);
        System.out.println(Math.round((double)s/60));
    }
}
