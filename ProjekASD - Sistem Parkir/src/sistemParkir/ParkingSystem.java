/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemParkir;

/**
 *
 * @author Hpvic
 */
import java.util.Scanner;

public class ParkingSystem {
    private Motor[] parkir = new Motor[100];
    private Scanner sc = new Scanner(System.in);

    // =======================
    // 1. MOTOR MASUK
    // =======================
    public void motorMasuk() {
        System.out.print("Masukkan Plat Motor: ");
        String plat = sc.next();
        System.out.print("Masukkan Jam Masuk (angka): ");
        int jam = sc.nextInt();

        int slotKosong = cariSlotKosong();

        if (slotKosong == -1) {
            System.out.println("Parkiran Penuh!");
        } else {
            parkir[slotKosong] = new Motor(plat, jam);
            System.out.println("Motor masuk di slot " + slotKosong);
        }
    }

    // Mencari slot kosong (Linear Search)
    private int cariSlotKosong() {
        for (int i = 0; i < parkir.length; i++) {
            if (parkir[i] == null) {
                return i; 
            }
        }
        return -1;
    }

    // =======================
    // 2. MOTOR KELUAR
    // =======================
    public void motorKeluar() {
        System.out.print("Masukkan nomor slot motor keluar: ");
        int slot = sc.nextInt();

        if (slot < 0 || slot >= 100 || parkir[slot] == null) {
            System.out.println("Slot tidak valid atau kosong!");
        } else {
            System.out.println("Motor " + parkir[slot].plat + " keluar dari slot " + slot);
            parkir[slot] = null;
        }
    }

    // =======================
    // 3. TAMPILKAN DATA
    // =======================
    public void tampilkanData() {
        System.out.println("\n=== DATA MOTOR TERPARKIR ===");

        boolean ada = false;
        for (int i = 0; i < parkir.length; i++) {
            if (parkir[i] != null) {
                System.out.println("Slot " + i + ": " + parkir[i]);
                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Parkiran masih kosong.");
        }
    }

    // =======================
    // 4. SORTING (QUICK SORT)
    // =======================
    public void sortByJam() {
        quickSort(parkir, 0, parkir.length - 1);
        System.out.println("Data berhasil disorting berdasarkan jam masuk.");
    }

    private void quickSort(Motor[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            // Rekursi
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(Motor[] arr, int low, int high) {
        Motor pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (arr[j] != null && pivot != null) {
                if (arr[j].jamMasuk < pivot.jamMasuk) {
                    i++;

                    Motor temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        Motor temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // =======================
    // 5. SEARCHING MOTOR
    // =======================
    public void cariMotor() {
        System.out.print("Masukkan plat yang dicari: ");
        String plat = sc.next();

        for (int i = 0; i < parkir.length; i++) {
            if (parkir[i] != null && parkir[i].plat.equalsIgnoreCase(plat)) {
                System.out.println("Motor ditemukan di slot " + i + " → " + parkir[i]);
                return;
            }
        }

        System.out.println("Motor tidak ditemukan.");
    }
}
