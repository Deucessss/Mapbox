package com.example.mapbox.Model;

public class SearchResult {
    private String text;

    private String placeName;

    public SearchResult(String text, String placeName) {
        this.text = text;
        this.placeName = placeName;
    }
    public String getText() {
        return text;
    }

    public String getPlaceName() {
        return placeName;
    }

}
