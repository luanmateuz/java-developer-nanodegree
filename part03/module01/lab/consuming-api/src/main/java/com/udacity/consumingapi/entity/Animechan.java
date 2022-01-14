package com.udacity.consumingapi.entity;

public class Animechan {

    private String anime;
    private String character;
    private String quote;

    public Animechan() {
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Animechan{" +
                "anime='" + anime + '\'' +
                ", character='" + character + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
