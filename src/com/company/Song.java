package com.company;
public class Song {
    private String title;
    private int releaseYear;
    private int duration = 60;
    private int likes = 0;
    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }
    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }
    public Song(String title, int releaseYear, int duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }
    public boolean changeDuration(int duration){
        if (duration<0 || duration>720 || duration == this.duration){
            return false;
        }
        this.duration =duration;
        return true;
    }
    public void like(){
        likes++;
    }
    public void unlike(){
        if (likes!=0)
            likes--;
    }
    public boolean isEqual(Song otherSong){
        if (getTitle().equals(otherSong.getTitle()) && getReleaseYear() == otherSong.getReleaseYear() && getDuration() == otherSong.getDuration())
            return true;
        return false;
    }
    @Override
    public String toString() {
        int s = duration;
        double x = Math.round(((double)s/60)*100);
        return "title:" + title +
                ", releaseYear:" + releaseYear +
                ", duration:" + x/100 +
                ", likes:" + likes;
    }
    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;

    }
    public double getDuration() {
        return duration;

    }
    public int getLikes() {
        return likes;

    }
}
