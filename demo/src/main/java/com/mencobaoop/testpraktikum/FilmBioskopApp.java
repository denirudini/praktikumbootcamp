package com.mencobaoop.testpraktikum;

// AplikasiFilmBioskop.java
import java.util.Scanner;

public class FilmBioskopApp {

    // Menggunakan array of Film objects
    private static Film[] daftarFilm;
    private static int jumlahFilmSaatIni;
    private static final int MAX_FILM = 10; 


    private static Scanner input = new Scanner(System.in);

    // Constructor untuk inisialisasi aplikasi
    public FilmBioskopApp() {
        daftarFilm = new Film[MAX_FILM]; // Inisialisasi array dengan kapasitas maksimum
        jumlahFilmSaatIni = 0;

        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("John Wick 4", "Action", "166 menit", "8.5/10");
        }
        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("The Raid 2", "Action", "145 menit", "7.8/10");
        }
        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("Inside Out 2", "Animation", "96 menit", "7.9/10");
        }
        if (jumlahFilmSaatIni < MAX_FILM) {
            daftarFilm[jumlahFilmSaatIni++] = new Film("Furiosa: A Mad Max Saga", "Action", "148 menit", "8.2/10");
        }
    }

    public static void main(String[] args) {
        FilmBioskopApp app = new FilmBioskopApp(); // Membuat objek dari kelas aplikasi

        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            isLoggedIn = app.login(); // Memanggil method login melalui objek app
            if (!isLoggedIn) {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }
        }

        int pilihan;
        do {
            app.tampilkanMenu(); // Memanggil method tampilkanMenu melalui objek app
            System.out.print("Pilih menu: ");
            try {
                pilihan = input.nextInt();
                input.nextLine(); // Konsumsi newline
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                input.nextLine(); // Kosongkan buffer scanner
                pilihan = 0; // Set pilihan ke 0 agar loop berlanjut
            }

            switch (pilihan) {
                case 1:
                    app.tampilkanDaftarFilm(); // Memanggil method melalui objek app
                    break;
                case 2:
                    app.inputDataFilm(); // Memanggil method melalui objek app
                    break;
                case 3:
                    app.cariFilm(); // Memanggil method melalui objek app
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
            }
            System.out.println(); // Baris kosong untuk kerapian
        } while (pilihan != 4);

        input.close(); // Tutup scanner saat aplikasi selesai
    }

    // Method untuk Login Sistem (instance method karena tidak static)
    public boolean login() {
        System.out.println("===== Login Aplikasi Film Bioskop =====");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        return username.equals("admin") && password.equals("12345");
    }

    // Method untuk Menampilkan Menu Utama
    public void tampilkanMenu() {
        System.out.println("===== Menu Utama =====");
        System.out.println("1. Tampilkan Daftar Film");
        System.out.println("2. Input Data Film");
        System.out.println("3. Cari Film");
        System.out.println("4. Keluar");
    }

    // Method untuk Input Data Film
    public void inputDataFilm() {
        if (jumlahFilmSaatIni >= MAX_FILM) {
            System.out.println("Kapasitas penyimpanan film penuh (maks. " + MAX_FILM + " film).");
            return;
        }

        System.out.println("===== Input Data Film =====");
        System.out.print("Judul Film: ");
        String judul = input.nextLine();
        System.out.print("Genre Film: ");
        String genre = input.nextLine();
        System.out.print("Durasi Film (contoh: 120 menit): ");
        String durasi = input.nextLine();
        System.out.print("Rating Film (contoh: 5/10): ");
        String rating = input.nextLine();

        // Membuat objek Film baru dan menyimpannya ke dalam array
        daftarFilm[jumlahFilmSaatIni] = new Film(judul, genre, durasi, rating);
        jumlahFilmSaatIni++;
        System.out.println("Film berhasil ditambahkan!");
    }

    // Method untuk Menampilkan Daftar Film
    public void tampilkanDaftarFilm() {
        System.out.println("===== Daftar Film =====");
        if (jumlahFilmSaatIni == 0) {
            System.out.println("Belum ada film yang tersimpan.");
            return;
        }

        for (int i = 0; i < jumlahFilmSaatIni; i++) {
            System.out.println("----------------------------------");
            System.out.println("Film ke-" + (i + 1));
            daftarFilm[i].tampilkanInfo(); // Memanggil method dari objek Film
        }
        System.out.println("----------------------------------");
    }

    // Method untuk Mencari Film berdasarkan Judul
    public void cariFilm() {
        System.out.println("===== Cari Film =====");
        if (jumlahFilmSaatIni == 0) {
            System.out.println("Belum ada film untuk dicari.");
            return;
        }

        System.out.print("Masukkan judul film yang dicari: ");
        String judulCari = input.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilmSaatIni; i++) {
            // Mengakses judul film melalui getter method (enkapsulasi)
            if (daftarFilm[i].getJudul().equalsIgnoreCase(judulCari)) {
                System.out.println("----------------------------------");
                System.out.println("Film Ditemukan!");
                daftarFilm[i].tampilkanInfo(); // Memanggil method dari objek Film
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