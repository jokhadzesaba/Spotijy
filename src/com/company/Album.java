package com.company;
import java.util.Random;
public class Album {
    private String title;
    private int releaseYear;
    private Song[] songs;
    private Song[] songs1 = new Song[5000];
    public Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }
    public int addSongs(Song[] songs) {
        int counter = 0;
        int counter2 = 0;
        if (this.songs1[0] == null){
            this.songs1[0] = songs[0];
            counter++;
        }
        for (int i = 0; i < songs.length; i++) {
            int x = lastNullIndex();
            boolean isUnique = true;
            for (int j = 0; j < this.songs1.length; j++) {
                if (this.songs1[j] == null)
                    break;
                if (songs[i].isEqual(this.songs1[j])){
                    isUnique =false;
                    break;
                }
            }
            if (isUnique){
                this.songs1[x] = songs[i];
                counter++;
            }
        }
        for (int i = 0; i <this.songs1.length; i++) {
            if (this.songs1[i] == null)
                counter2++;
        }
        Song[]arr1 = new Song[this.songs1.length-counter2];
        for (int i = 0; i <arr1.length ; i++) {
            arr1[i] = this.songs1[i];
        }
//        System.out.println(counter2);
        this.songs = arr1;
//        System.out.println(Arrays.toString(arr1));
        return counter;
    }
    private int lastNullIndex(){
        int index = 0;
        for (int i = 0; i <songs1.length; i++) {
            if (songs1[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }
    public Song[] shuffle(){
        Random rand = new Random();
        for (int i = 0; i < songs.length; i++) {
            int randomIndexToSwap = rand.nextInt(songs.length);
            Song temp = songs[randomIndexToSwap];
            songs[randomIndexToSwap] = songs[i];
            songs[i] = temp;
        }
        return songs;
    }
    public Song[] sortByTitle(boolean isAscending){
        if (!isAscending){
        for (int i = 0; i <songs.length; i++) {
            for (int j = 0; j <songs.length; j++) {
                if (songs[i].getTitle().compareTo(songs[j].getTitle()) < 0 && i != j){
                    Song temp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = temp;
                    }
                }
            }
        }else {
            for (int i = 0; i <songs.length; i++) {
                for (int j = 0; j <songs.length; j++) {
//                    if (songs[i]==null || songs[j] == null)
//                        break;
                    if (songs[i].getTitle().compareTo(songs[j].getTitle()) > 0 && i != j){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }
        return songs;
    }
    public Song[] sortByDuration(boolean isAscending){
        if (!isAscending){
            for (int i = 0; i <songs.length; i++) {
                for (int j = 0; j <songs.length; j++) {
//                    if (songs[i]==null || songs[j] == null)
//                        break;
                    if (songs[i].getDuration() > songs[j].getDuration() && i != j){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }else {
            for (int i = 0; i <songs.length; i++) {
                for (int j = 0; j <songs.length; j++) {
//                    if (songs[i]==null || songs[j] == null)
//                        break;
                    if (songs[i].getDuration() < songs[j].getDuration() && i != j){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }
        return songs;
    }
    public Song[] sortByReleaseYear(boolean isAscending){
        if (!isAscending){
            for (int i = 0; i <songs.length; i++) {
                for (int j = 0; j <songs.length; j++) {
//                    if (songs[i]==null || songs[j] == null)
//                        break;
                    if (songs[i].getReleaseYear() > songs[j].getReleaseYear() && i != j){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }else {
            for (int i = 0; i <songs.length; i++) {
                for (int j = 0; j <songs.length; j++) {
//                    if (songs[i]==null || songs[j] == null)
//                        break;
                    if (songs[i].getReleaseYear() < songs[j].getReleaseYear() && i != j){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }
        return songs;
    }
    public Song[] sortByPopularity(boolean isAscending){
        if (!isAscending){
            for (int i = 0; i <songs.length; i++) {
                for (int j = 0; j <songs.length; j++) {
//                    if (songs[i]==null || songs[j] == null)
//                        break;
                    if (songs[i].getLikes() > songs[j].getLikes() && i != j){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }else {
            for (int i = 0; i <songs.length; i++) {
                for (int j = 0; j <songs.length; j++) {
//                    if (songs[i]==null || songs[j] == null)
//                        break;
                    if (songs[i].getLikes() < songs[j].getLikes() && i != j){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }
        return songs;
    }
    public static Song[] reverse(Song[] songs){
        for (int i = 0; i < songs.length/2; i++) {
                Song temp = songs[i];
                songs[i] = songs[songs.length-i-1];
                songs[songs.length-i-1] = temp;
            }

        return songs;
    }
    @Override
    public String toString() {
        StringBuilder withoutBrackets = new StringBuilder("");
        if (songs != null){
        for (int i = 0; i <songs.length ; i++) {
            if (songs[i]==null)
                break;
            if (i != songs.length-1)
                withoutBrackets.append(songs[i].toString()).append("|");
            else
                withoutBrackets.append(songs[i].toString());

            }
        }
        return "title:" + title + '\'' +
                ", releaseYear:" + releaseYear +
                ", songs:{" + withoutBrackets +
                '}';
    }
    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {return releaseYear;}
    public Song[] getSongs() {return songs;}
}
