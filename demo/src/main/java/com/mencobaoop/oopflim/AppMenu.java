package com.mencobaoop.oopflim;

// AppMenu.java
import java.util.Scanner;

public class AppMenu {

    // Metode untuk login (bisa statis jika tidak butuh data instance)
    public boolean doLogin(Scanner scanner) {
        System.out.println("===== Login Aplikasi Film Bioskop =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        return username.equals("admin") && password.equals("12345");
    }

    // Metode untuk menampilkan menu
    public void displayMenu() {
        System.out.println("===== Menu Utama =====");
        System.out.println("1. Tampilkan Daftar Film");
        System.out.println("2. Input Data Film");
        System.out.println("3. Cari Film");
        System.out.println("4. Keluar");
    }

    // Metode untuk mendapatkan pilihan menu dari user
    public int getMenuChoice(Scanner scanner) {
        System.out.print("Pilih menu: ");
        try {
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            return pilihan;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka.");
            scanner.nextLine(); // Kosongkan buffer scanner
            return 0; // Mengembalikan 0 atau nilai non-valid lainnya
        }
    }
}
