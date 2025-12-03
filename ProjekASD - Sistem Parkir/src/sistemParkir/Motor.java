/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemParkir;

/**
 *
 * @author Hpvic
 */
public class Motor {
    String plat;
    int jamMasuk;

    public Motor(String plat, int jamMasuk) {
        this.plat = plat;
        this.jamMasuk = jamMasuk;
    }

    @Override
    public String toString() {
        return "Plat: " + plat + " | Jam Masuk: " + jamMasuk;
    }
}

