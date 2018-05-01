/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postekpro;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import static java.util.Locale.filter;
import java.util.Scanner;
import java.util.Random;

/**
 * Description : Date :
 *
 * @author Ahmad_Aji_Naufal_Ali
 */
public class Pembayaran {

    Gson gson = new Gson();
    private int pilihan;
    private int PIN;
    private int nomer_rek;
    Scanner in = new Scanner(System.in);

    public void TampilMenu() {
        System.out.println("PILIH METODE PEMBAYARAN : ");
        System.out.println("1. KARTU DEBIT ");
        System.out.println("2. TRANSFER ");
        System.out.println("3. E-CASH ");
        System.out.println("PILIHAN ANDA : ");
        InputPilihan();
    }

    public void InputPilihan() {
        pilihan = in.nextInt();
    }

    public void InputPIN() {
        PIN = in.nextInt();
    }

    public void InputNomerRek() {
        nomer_rek = in.nextInt();
    }

    public boolean CekNomerRek(int nomer_rek) {
        List<Rekening> data = target.filterData(filter);
        Iterator<Rekening> n = data.iterator();
        boolean temu = false;
        n = barang.iterator();
        while (n.hasNext() && !temu) {
            Produk z = n.next();
            if (z.getId().getCode().equalsIgnoreCase(kode)) {
                temu = true;
                System.out.println(z.getId().getNama() + " " + z.getHarga());
            }
        }
        return false;
    }

    public void OlahPilihan(int pilihan) {
        if (pilihan == 1) {

        }
        if (pilihan == 2) {
            Transfer();
        }

        if (pilihan == 3) {

        }
    }

    public void KartuDebit() {

    }

    public void Transfer() {
        Cart harga = new Cart();
        int kode_unik = GenerateKodeUnik();
        System.out.println("---------------------------------------------");
        System.out.print("SILAHKAN TRANSFER SEBANYAK : ");
        System.out.println("Rp " + harga.getTotal() + kode_unik);
        System.out.println("---------------------------------------------");
        System.out.println(kode_unik + " ADALAH KODE UNIK TRANSAKSI INI");
        System.out.println("MOHON UNTUK TRANSFER SESUAI JUMLAH YANG TERTERA AGAR MEMUDAHKAN VERIFIKASI");
    }

    public void ECash() {

    }

    public int GenerateKodeUnik() {
        Random rand = new Random();
        return rand.nextInt(500) + 1;
    }
}
