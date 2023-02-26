package com.company;
public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;
    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }
    public Song mostLikedSong(){
        if(mostLikedInAlbum()!=null && mostlikedInSingles()!=null){
        if (mostLikedInAlbum().getLikes()>mostlikedInSingles().getLikes())
            return mostLikedInAlbum();
        }else
            return mostlikedInSingles();
        return null;
    }
    private Song mostlikedInSingles(){
        int likes = -1;
        Song mostliked = null;
        for (int i = 0; i < singles.length; i++) {
            if (singles[i].getLikes()>likes){
                likes = singles[i].getLikes();
                mostliked = singles[i];
            }
        }
        return mostliked;
    }
    private Song mostLikedInAlbum(){
        int likes = -1;
        Song mostliked = null;
        for (int i = 0; i <albums.length; i++) {
            for (int j = 0; j <albums[i].getSongs().length ; j++) {
                if (albums[i].getSongs()[j].getLikes() > likes){
                    likes = albums[i].getSongs()[j].getLikes();
                    mostliked = albums[i].getSongs()[j];
                }
            }
        }
        return mostliked;
    }
    public Song leastLikedSong() {
        if (leastLikedinAlbum().getLikes()<leastLikedInSingles().getLikes())
            return leastLikedinAlbum();
        return leastLikedInSingles();
    }
    private Song leastLikedinAlbum(){
        int min = albums[0].getSongs()[0].getLikes();
        Song leastLiked = albums[0].getSongs()[0];
        for (int i = 0; i <albums.length; i++) {
            for (int j = 0; j <albums[i].getSongs().length ; j++) {
                if (albums[i].getSongs()[j].getLikes() < min){
                    min = albums[i].getSongs()[j].getLikes();
                    leastLiked = albums[i].getSongs()[j];
                }
            }
        }return leastLiked;
    }
    private Song leastLikedInSingles(){
        int min = Integer.MAX_VALUE;
        Song leastliked = null;
        for (int i = 0; i < singles.length; i++) {
            if (singles[i].getLikes()<min){
                min = singles[i].getLikes();
                leastliked = singles[i];
            }
        }
        return leastliked;
    }
    public boolean isEqual(Artist other){
        if (this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName()) && this.getBirthYear() == other.getBirthYear())
            return true;
        return false;
    }
    public int totalLikes(){
        int totallikes = 0;
        int likesInalbums = 0;
        int likesofsingles = 0;
        for (int i = 0; i <albums.length; i++) {
            for (int j = 0; j <albums[i].getSongs().length; j++) {
                if (albums[i].getSongs()[j] == null)
                    break;
                likesInalbums+= albums[i].getSongs()[j].getLikes();
            }
        }
        for (int i = 0; i <singles.length ; i++) {
            likesofsingles+= singles[i].getLikes();
        }
        totallikes = likesInalbums + likesofsingles;
        return totallikes;
    }
    @Override
    public String toString() {
        return "Artist{" +
                "Name:" + firstName +" " + lastName  +
                ", Birth Year:" + birthYear + ", Total likes:{"+totalLikes()+"}";

    }
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getBirthYear() {return birthYear;}
    public Album[] getAlbums() {return albums;}
    public Song[] getSingles() {return singles;}
}
