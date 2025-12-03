/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemParkir;
import sistemParkir.Motor;
import sistemParkir.ParkingSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingSystem ps = new ParkingSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== SISTEM PARKIR MALL =====");
            System.out.println("1. Motor Masuk");
            System.out.println("2. Motor Keluar");
            System.out.println("3. Tampilkan Data Parkir");
            System.out.println("4. Sorting Berdasarkan Jam");
            System.out.println("5. Cari Motor (Plat)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    ps.motorMasuk();
                    break;
                case 2:
                    ps.motorKeluar();
                    break;
                case 3:
                    ps.tampilkanData();
                    break;
                case 4:
                    ps.sortByJam();
                    break;
                case 5:
                    ps.cariMotor();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }
}

