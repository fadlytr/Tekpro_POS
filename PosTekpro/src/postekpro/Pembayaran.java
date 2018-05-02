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
import java.util.ArrayList;
import java.util.Iterator;
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

    private int pilihan;
    private int PIN;
    private int noRek;
    private boolean replay = true;
    private List<Rekening> dataRekening;
    Scanner in = new Scanner(System.in);

    Gson g = new Gson();
    List<Rekening> listRek = new ArrayList<>();
    Iterator<Rekening> iteRek = listRek.iterator();

    Pembayaran(){}
    
    public void Transaksi() throws FileNotFoundException {
        BufferedReader byr = new BufferedReader(new FileReader("src/json/ListRekening2.json"));
        Rekening target = g.fromJson(byr, Rekening.class);
        while (replay) {
            TampilMenu();
            InputPilihan();
            OlahPilihan(pilihan);
        }

    }

    public void TampilMenu() {
//        System.out.println("PILIH METODE PEMBAYARAN : ");
//        System.out.println("1. KARTU DEBIT ");
//        System.out.println("2. TRANSFER ");
//        System.out.println("3. E-CASH ");
//        System.out.print("PILIHAN ANDA : ");
//        InputPilihan();
    }

    public void InputPilihan() {
        pilihan = in.nextInt();
    }

    public void InputPIN() {
        System.out.print("\nINPUT PIN : ");
        PIN = in.nextInt();
    }

    public void InputNomerRek() {
        System.out.print("\nINPUT NO REKENING : ");
        noRek = in.nextInt();
    }

    public boolean ValidasiKartuDebit(int noRek, int PIN) {
//        List<Rekening> listRek = new ArrayList<>();
//        Iterator<Rekening> iteRek = listRek.iterator();
        boolean run = true;
        int count = 0;
        while (iteRek.hasNext()) {
            Rekening i = iteRek.next();
            if (i.getId() == noRek) {
                if (i.getPin() == PIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ValidasiRekening(int noRek) {
//        List<Rekening> listRek = new ArrayList<>();
//        Iterator<Rekening> iteRek = listRek.iterator();
        boolean run = true;
        int count = 0;
        while (iteRek.hasNext()) {
            Rekening i = iteRek.next();
            if (i.getId() == noRek) {
                return true;
            }
        }
        return false;
    }

    public void OlahPilihan(int pilihan) {
//        if (pilihan == 1) {
//            KartuDebit();
//        }
//        if (pilihan == 2) {
//            Transfer();
//        }
//        if (pilihan == 3) {
//            ECash();
//        }
    }

    public void ShowSuccess() {
        System.out.println("\n---------------------------------------");
        System.out.println("PEMBAYARAN SUKSES");
        System.out.println("TERIMA KASIH TELAH BERBELANJA DI TOKO KAMI");
        System.out.println("------------------------------------------");
    }
    
    public void ShowFail() {
        System.out.println("\n---------------------------------------");
        System.out.println("PEMBAYARAN GAGAL");
        System.out.println("MOHON ULANGI PEMBAYARAN KEMBALI");
        System.out.println("------------------------------------------");
    }

    public void Transfer() {
        Cart harga = new Cart();
        int kode_unik = GenerateKodeUnik();
        System.out.println("---------------------------------------------");
        System.out.print("SILAHKAN TRANSFER SEBANYAK : ");
        System.out.println("Rp " + harga.getTotal() + kode_unik);
        System.out.println("KE NOMER REKENING 123-456-789 A/N FADLY TRIANSYAH");
        System.out.println("---------------------------------------------");
        System.out.println(kode_unik + " ADALAH KODE UNIK TRANSAKSI INI");
        System.out.println("MOHON UNTUK TRANSFER SESUAI JUMLAH YANG TERTERA AGAR MEMUDAHKAN VERIFIKASI");
        replay = false;
    }

    public void KartuDebit() {

        InputNomerRek();
        InputPIN();
        if (ValidasiKartuDebit(noRek, PIN)) {
            replay = false;
            ShowSuccess();
        } else
            ShowFail();
    }

    public void ECash() {
        InputNomerRek();
        if (ValidasiRekening(noRek)) {
            replay = false;
            ShowSuccess();
        } else
            ShowFail();
    }

    public int GenerateKodeUnik() {
        Random rand = new Random();
        return rand.nextInt(500) + 1;
    }
}
