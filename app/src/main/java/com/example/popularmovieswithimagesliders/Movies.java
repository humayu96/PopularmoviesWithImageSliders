package com.example.popularmovieswithimagesliders;

public class Movies {

    private String title;
    private String description;
    private String studio;
    private int thumbnail;
    private String streaminglink;



    public Movies(String title,  int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movies(String title, String description, String studio, int thumbnail, String streaminglink) {
        this.title = title;
        this.description = description;
        this.studio = studio;
        this.thumbnail = thumbnail;
        this.streaminglink = streaminglink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStreaminglink() {
        return streaminglink;
    }

    public void setStreaminglink(String streaminglink) {
        this.streaminglink = streaminglink;
    }
}
