package com.mencobaoop.oopflim;

public class Film {
    private String judul;
    private String genre;
    private String durasi;
    private String rating;

    public Film(String judul, String genre, String durasi, String rating) {
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.rating = rating;
    }

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public String getDurasi() {
        return durasi;
    }

    public String getRating() {
        return rating;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void tampilkanInfo() {
        System.out.println("Judul  : " + this.judul);
        System.out.println("Genre  : " + this.genre);
        System.out.println("Durasi : " + this.durasi);
        System.out.println("Rating : " + this.rating);
    }
}