package com.mencobaoop.oopflim;

// FilmManager.java
import java.util.Scanner;

public class FilmManager {
    private Film[] daftarFilm;
    private int jumlahFilmSaatIni;
    private final int MAX_FILM; // Kapasitas maksimum

    // Scanner bisa di-pass dari main atau dibuat di sini jika FilmManager satu-satunya yang butuh input
    // Namun untuk memisahkan tanggung jawab, kita akan pass Scanner ke metode yang membutuhkannya.

    public FilmManager(int maxFilm) {
        this.MAX_FILM = maxFilm;
        this.daftarFilm = new Film[MAX_FILM];
        this.jumlahFilmSaatIni = 0;
        initDataFilm(); // Panggil method untuk inisialisasi data hardcode
    }

    // Method untuk inisialisasi data film hardcode
    private void initDataFilm() {
        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("Dune: Part Two", "Sci-Fi", "166 menit", "PG-13");
        }
        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("Kingdom of the Planet of the Apes", "Sci-Fi", "145 menit", "PG-13");
        }
        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("Inside Out 2", "Animation", "96 menit", "G");
        }
        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("Furiosa: A Mad Max Saga", "Action", "148 menit", "R");
        }
    }

    // Metode untuk menambah film
    public void tambahFilm(Scanner scanner) {
        if (jumlahFilmSaatIni >= MAX_FILM) {
            System.out.println("Kapasitas penyimpanan film penuh (maks. " + MAX_FILM + " film).");
            return;
        }

        System.out.println("===== Input Data Film =====");
        System.out.print("Judul Film: ");
        String judul = scanner.nextLine();
        System.out.print("Genre Film: ");
        String genre = scanner.nextLine();
        System.out.print("Durasi Film (contoh: 120 menit): ");
        String durasi = scanner.nextLine();
        System.out.print("Rating Film (contoh: PG-13): ");
        String rating = scanner.nextLine();

        daftarFilm[this.jumlahFilmSaatIni] = new Film(judul, genre, durasi, rating);
        this.jumlahFilmSaatIni++;
        System.out.println("Film berhasil ditambahkan!");
    }

    // Metode untuk menampilkan daftar film
    public void tampilkanSemuaFilm() {
        System.out.println("===== Daftar Film =====");
        if (jumlahFilmSaatIni == 0) {
            System.out.println("Belum ada film yang tersimpan.");
            return;
        }

        for (int i = 0; i < jumlahFilmSaatIni; i++) {
            System.out.println("----------------------------------");
            System.out.println("Film ke-" + (i + 1));
            daftarFilm[i].tampilkanInfo();
        }
        System.out.println("----------------------------------");
    }

    // Metode untuk mencari film
    public void cariFilm(Scanner scanner) {
        System.out.println("===== Cari Film =====");
        if (jumlahFilmSaatIni == 0) {
            System.out.println("Belum ada film untuk dicari.");
            return;
        }

        System.out.print("Masukkan judul film yang dicari: ");
        String judulCari = scanner.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilmSaatIni; i++) {
            if (daftarFilm[i].getJudul().equalsIgnoreCase(judulCari)) {
                System.out.println("----------------------------------");
                System.out.println("Film Ditemukan!");
                daftarFilm[i].tampilkanInfo();
                System.out.println("----------------------------------");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Film dengan judul '" + judulCari + "' tidak ditemukan.");
        }
    }
}
