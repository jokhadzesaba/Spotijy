package com.company;

public class SpotiJy {
    private Artist [] artists;
    private Artist [] artists1 = new Artist[5000];
    public void addArtist(Artist[] artists) {
        int counter = 0;
        int counter2 = 0;
        if (this.artists1[0] == null) {
            this.artists1[0] = artists[0];
            counter++;
        }
        for (int i = 0; i < artists.length; i++) {
            int x = lastNullIndex1();
            boolean isUnique = true;
            for (int j = 0; j < this.artists1.length; j++) {
                if (this.artists1[j] == null)
                    break;
                if (artists[i].isEqual(this.artists1[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                this.artists1[x] = artists[i];
                counter++;
            }
        }
        for (int i = 0; i < this.artists1.length; i++) {
            if (this.artists1[i] == null)
                counter2++;
        }
        Artist[] arr1 = new Artist[this.artists1.length - counter2];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = this.artists1[i];
        }
        this.artists = arr1;
    }
    private int lastNullIndex1(){
        int index = 0;
        for (int i = 0; i <artists1.length; i++) {
            if (artists1[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }
    public Artist[] getArtists() {
        return artists;
    }
    public String[] getTopTrendingArtist(){
        int totallikes = -1;
        Artist mostFamous = null;
        for (int i = 0; i < artists.length; i++) {
            if (artists[i].totalLikes()>totallikes){
                totallikes = artists[i].totalLikes();
                mostFamous = artists[i];
            }
        }
        return new String[]{"'" + mostFamous.getFirstName() + "','" + mostFamous.getLastName()+"'"};
    }
    public Album getTopTrendingAlbum(){
        int totalLikesOfAlbum = -1;
            Album album = null;
            for (int i = 0; i <artists.length; i++) {
                for (int j = 0; j <artists[i].getAlbums().length; j++) {
                    if (likeOfAlbums(artists[i].getAlbums()[j])> totalLikesOfAlbum){
                        totalLikesOfAlbum = likeOfAlbums(artists[i].getAlbums()[j]);
                        album = artists[i].getAlbums()[j];
                    }

                }
            }
        return album;
    }
    public Song getTopTrendingSong(){
        Song song = null;
        Song mostPopularInalbums = null;
        Song mostPopulaOfSingles = null;
        int likesforAlb = -1;
        int likesforSingles = -1;
            for (int i = 0; i <artists.length; i++) {
                for (int j = 0; j <artists[i].getAlbums().length; j++) {
                    if (mostLikedInAlbum(artists[i].getAlbums()[j]).getLikes() > likesforAlb){
                        likesforAlb = mostLikedInAlbum(artists[i].getAlbums()[j]).getLikes();
                        mostPopularInalbums = mostLikedInAlbum(artists[i].getAlbums()[j]);
                    }
                }
            }
            for (int i = 0; i < artists.length; i++) {
                if (mostLikedInSingles(artists[i]).getLikes() > likesforSingles){
                    likesforSingles = mostLikedInSingles(artists[i]).getLikes();
                    mostPopulaOfSingles = mostLikedInSingles(artists[i]);
                }
            }

            if (mostPopulaOfSingles.getLikes() > mostPopularInalbums.getLikes())
                return mostPopulaOfSingles;
            else if (mostPopulaOfSingles.getLikes() < mostPopularInalbums.getLikes())
                return mostPopularInalbums;
            else
                return mostPopulaOfSingles;
        }
    private Song mostLikedInAlbum(Album album){
        int likes = -1;
        Song mostliked = null;
        for (int i = 0; i < album.getSongs().length; i++) {
            if (album.getSongs()[i].getLikes()>likes){
                likes = album.getSongs()[i].getLikes();
                mostliked = album.getSongs()[i];
            }
        }
        return mostliked;
    }
    private Song mostLikedInSingles(Artist artist){
        int likes = -1;
        Song mostliked = null;
        for (int i = 0; i <artist.getSingles().length; i++){
            if (artist.getSingles()[i].getLikes() > likes){
                likes = artist.getSingles()[i].getLikes();
                mostliked = artist.getSingles()[i];
            }
        }
        return mostliked;
    }
    private int likeOfAlbums(Album album){
        int likes = 0;
        for (int i = 0; i <album.getSongs().length ; i++) {
            likes += album.getSongs()[i].getLikes();
        }
        return likes;
    }
}


