package com.mencobaoop.oopflim;

// AplikasiFilmBioskop.java
import java.util.Scanner;

public class AplikasiFilmBioskop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner dibuat di main dan di-pass

        // Inisialisasi objek dari kelas-kelas lain
        AppMenu appMenu = new AppMenu();
        FilmManager filmManager = new FilmManager(10); // Kapasitas maks 10 film

        // 1. Proses Login
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            isLoggedIn = appMenu.doLogin(scanner); // Memanggil metode login dari AppMenu
            if (!isLoggedIn) {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }
        }

        // 2. Loop Menu Utama
        int pilihan;
        do {
            appMenu.displayMenu(); // Memanggil metode tampilkan menu dari AppMenu
            pilihan = appMenu.getMenuChoice(scanner); // Memanggil metode get pilihan dari AppMenu

            switch (pilihan) {
                case 1:
                    filmManager.tampilkanSemuaFilm(); // Memanggil metode dari FilmManager
                    break;
                case 2:
                    filmManager.tambahFilm(scanner); // Memanggil metode dari FilmManager, pass scanner
                    break;
                case 3:
                    filmManager.cariFilm(scanner); // Memanggil metode dari FilmManager, pass scanner
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
            }
            System.out.println(); // Baris kosong untuk kerapian
        } while (pilihan != 4);

        scanner.close(); // Tutup scanner
    }
}
