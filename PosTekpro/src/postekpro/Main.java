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
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ahmad_Aji_Naufal_Ali
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner Reader = new Scanner(System.in);
        String kodbar;
        boolean temu;
        char ch;

        Cart cart = new Cart();
        Iterator<Produk> n;
        Iterator<CartObj> m;
        int menuUtama = 0, menu = 0, amount = 0, k = 0, pilihan, hargaFix;
        String noRek, PIN;
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/json/ListBarang3.json"));
        Barang target = gson.fromJson(br, Barang.class);
        BufferedReader rk = new BufferedReader(new FileReader("src/json/ListRekening2.json"));
        Rekening[] R = gson.fromJson(rk, Rekening[].class);
        List<Produk> barang;
        Rekening[] rekening = null;
        do {
            System.out.println("||-----------Menu Utama-----------|| \n\n||----------Isi Cart----------||");
            barang = target.getAllData();
            cart.printProduk(); //isi Cart ditampilkan
            do {
                System.out.println("\n||--------Menu--------|| \n1. Mulai Belanja \n2. Keluarkan barang dari cart \n3. Bayar \nApa yang ingin dilakukan : ");
                menuUtama = Reader.nextInt();
                if (menuUtama < 1 && menuUtama > 3);
                System.out.println("PILIHAN ANDA TIDAK VALID !");
            } while (menuUtama < 1 && menuUtama > 3);

            switch (menuUtama) {
                case 1:
                    do {
                        n = barang.iterator();
                        while (n.hasNext()) {
                            Produk z = n.next();
                            System.out.print("\n" + z.getId().getCode() + " " + z.getId().getNama() + " " + z.getHarga());
                        }
                        do {
                            System.out.println("\n\n||---------Menu Belanja---------|| \n1. Filter List \n2. Tambah barang ke kart \n3. Menu utama \nPilihan Menu : ");
                            menu = Reader.nextInt();
                            if (menu < 1 && menu > 3) {
                                System.out.println("PILIHAN ANDA TIDAK VALID !");
                            }
                        } while (menu < 1 && menu > 3);
                        if (menu == 1) {
                            int filter = 0;
                            System.out.println("Filter data agar menampilkan : ");
                            System.out.println("1. print Semua Barang");
                            System.out.println("2. print Minuman");
                            System.out.println("3. print Makanan");
                            System.out.println("4. print Minuman Keras");
                            System.out.println("5. print Minuman Ringan");
                            System.out.println("6. print Makanan Berat");
                            System.out.println("7. print Makanan Ringan");
                            System.out.print("pilih menu filter: ");
                            filter = Reader.nextInt();
                            barang = target.filterData(filter);
                        } else if (menu == 2) {
                            System.out.println("Masukkan kode barang yang diinginkan : ");
                            kodbar = Reader.next();
                            System.out.println("Berapa jumlah barang yang diinginkan : ");
                            amount = Reader.nextInt();
                            temu = false;
                            n = barang.iterator();
                            while (n.hasNext() && !temu) {
                                Produk z = n.next();
                                if (z.getId().getCode().equalsIgnoreCase(kodbar)) {
                                    temu = true;
                                    System.out.println(z.getId().getNama() + " " + z.getHarga());
                                    cart.addProduk(z, amount);
                                }
                            }
                            if (temu == false) {
                                System.out.println("Barang tidak ditemukan ");
                            }
                        } else if (menu != 3) {
                            System.out.println("Menu tidak tersedia");
                        }
                    } while (menu != 3);
                    break;

                case 2:
                    menu = 0;
                    while (menu != 4 && !cart.getCart().isEmpty()) {
                        cart.printProduk();
                        System.out.println("\n||-----Cancel Kart------|| \n1. Kurangi jumlah suatu barang \n2. Keluarkan satu tipe barang \n3. Kosongkan kart \n4. Menu utama \nPilihan Menu : ");
                        menu = Reader.nextInt();
                        if (menu == 1) {
                            System.out.println("Masukkan kode barang : ");
                            kodbar = Reader.next();
                            System.out.println("Berapa jumlah barang yang ingin dikeluarkan : ");
                            amount = Reader.nextInt();
                            int index = 0;
                            temu = false;
                            m = cart.getCart().iterator();
                            while (m.hasNext() && !temu) {
                                Produk z = m.next().getProduk();
                                if (z.getId().getCode().equalsIgnoreCase(kodbar)) {
                                    temu = true;
                                    System.out.println(z.getId().getNama() + " " + z.getHarga());
                                    cart.removeProduk(index, amount);
                                }
                                index++;
                            }
                            if (temu == false) {
                                System.out.println("Barang tidak ditemukan ");
                            }
                        } else if (menu == 2) {
                            System.out.println("Masukkan kode barang : ");
                            kodbar = Reader.next();
                            int index = 0;
                            temu = false;
                            m = cart.getCart().iterator();
                            while (m.hasNext() && !temu) {
                                Produk z = m.next().getProduk();
                                if (z.getId().getCode().equalsIgnoreCase(kodbar)) {
                                    temu = true;
                                    System.out.println(z.getId().getNama() + " " + z.getHarga());
                                    cart.removeProduk(index);
                                }
                                index++;
                            }
                            if (temu == false) {
                                System.out.println("Barang tidak ditemukan ");
                            }
                        } else if (menu == 3) {
                            cart = new Cart();
                        } else if (menu != 4) {
                            System.out.println("Menu tidak tersedia");
                        }

                    }
                    break;

                case 3:
                    System.out.println("Anda membeli : ");
                    cart.printProduk();
                    System.out.println("Dengan harga total : " + cart.getTotal());
                    Pembayaran pay = new Pembayaran();
//                    pay.Transaksi();
                    Pembayaran bayar = new Pembayaran();
                    boolean replay = true;
                    boolean saldo = true;
                    while (replay) {
                        saldo = true;
                        System.out.println("PILIH METODE PEMBAYARAN : ");
                        System.out.println("1. KARTU DEBIT ");
                        System.out.println("2. TRANSFER ");
                        System.out.println("3. E-CASH ");
                        System.out.print("PILIHAN ANDA : ");
                        pilihan = Reader.nextInt();
//                        ch = Reader.next().charAt(0);
                        if (pilihan == 1) {
                            replay = true;
                            System.out.print("\nINPUT NO REKENING : ");
                            noRek = Reader.nextLine();
                            noRek = Reader.nextLine();
                            System.out.print("\nINPUT PIN : ");
                            PIN = Reader.nextLine();
                            k = 1;
                            rekening = R;
                            while (k < 20 && replay) {
//                                Rekening i = R.next();
                                if (rekening[k].getId().equals(noRek)) {
                                    if (rekening[k].getPin().equals(PIN)) {
                                        if (rekening[k].getIsi().getSaldo() >= cart.getTotal()) {
                                            replay = false;
                                            saldo = true;
                                        } else {
                                            saldo = false;
                                        }
                                    }
                                }
                                k++;
                            }
                        }
                        if (pilihan == 2) {
                            noRek = "";
                            Random rand = new Random();
                            rekening = R;
                            int kode_unik = rand.nextInt(500) + 1;
                            System.out.println("---------------------------------------------");
                            System.out.print("SILAHKAN TRANSFER SEBANYAK : ");
                            System.out.println("Rp " + cart.getTotal());
                            System.out.println("KODE PEMBAYARAN : " + kode_unik);
                            System.out.println("KE NOMER REKENING 123-456-789 A/N FADLY TRIANSYAH");
                            System.out.println("---------------------------------------------");
                            System.out.println(kode_unik + " ADALAH KODE UNIK TRANSAKSI INI");
                            System.out.println("MOHON UNTUK TRANSFER SESUAI JUMLAH YANG TERTERA AGAR MEMUDAHKAN VERIFIKASI");
                            replay = false;
                        }
                        if (pilihan == 3) {
                            noRek = "";
                            k = 0;
                            replay = true;
                            rekening = R;
                            System.out.print("\nINPUT ID KARTU : ");
                            noRek = Reader.nextLine();
                            noRek = Reader.nextLine();
                            while (k < 20 && replay) {
//                                Rekening i = R.next();
                                if (rekening[k].getId().equals(noRek)) {
                                    if (rekening[k].getIsi().getSaldo() >= cart.getTotal()) {
                                        replay = false;
                                        saldo = true;
                                    } else {
                                        saldo = false;
                                    }
                                }
                                k++;
                            }
                        }

                        if (!saldo) {
                            System.out.println("\n---------------------------------------");
                            System.out.println(">>>>>>>>SALDO ANDA TIDAK CUKUP<<<<<<<<<");
                            System.out.println("-----------------------------------------");
                        }
                        if (replay) {
                            System.out.println("\n---------------------------------------");
                            System.out.println(">>>>>PEMBAYARAN GAGAL<<<<<");
                            System.out.println("MOHON ULANGI PEMBAYARAN KEMBALI");
                            System.out.println("-----------------------------------------");
                        } else {
                            System.out.println("\n---------------------------------------");
                            System.out.println(">>>>>PEMBAYARAN SUKSES<<<<<");
                            if (pilihan != 2) {
                                System.out.println(">>BELANJA DENGAN NOMINAL : Rp." + cart.getTotal() + "<<<");
                                System.out.println(">>ATAS NAMA : " + rekening[k - 1].getIsi().getNama() + "<<<");
                                System.out.println(">>SISA SALDO ANDA : Rp." + (rekening[k - 1].getIsi().getSaldo() - cart.getTotal()) + "<<<");

                            }
                            System.out.println("TERIMA KASIH TELAH BERBELANJA DI TOKO KAMI");
                            System.out.println("------------------------------------------");
                        }
                    }

                    break;
            }
//
//    //        new Main().tampilBarang();
//            Scanner baca = new Scanner(System.in);
//            int filter;
//            do {
//                System.out.println("1. print Semua Barang");
//                System.out.println("2. print Minuman");
//                System.out.println("3. print Makanan");
//                System.out.println("4. print Minuman Keras");
//                System.out.println("5. print Minuman Ringan");
//                System.out.println("6. print Makanan Berat");
//                System.out.println("7. print Makanan Ringan");
//                System.out.println("8. Selesai\n");
//                System.out.print("pilih menu filter: ");
//                filter = baca.nextInt();
//            } while (filter < 1 || filter > 7);
//            List<Produk> barang = target.filterData(filter);
//    //        List <Produk> barang = target.getAllData();
//            Scanner scan = new Scanner(System.in);
//
//            Iterator<Produk> n = barang.iterator();
//            while (n.hasNext()) {
//                Produk z = n.next();
//                System.out.print("\n" + z.getId().getCode() + " " + z.getId().getNama() + " " + z.getHarga());
//            }
//            System.out.print("\nMasukkan kode barang : ");
//
//            String kode = scan.next();
//
//            boolean temu = false;
//            n = barang.iterator();
//            while (n.hasNext() && !temu) {
//                Produk z = n.next();
//                if (z.getId().getCode().equalsIgnoreCase(kode)) {
//                    temu = true;
//                    System.out.println(z.getId().getNama() + " " + z.getHarga());
//                }
//            }
//
//            if (temu == false) {
//                System.out.println("Kode tidak ditemukan ");
//            }
//
//            Cart cart = new Cart();
//            Pembayaran pembayaran = new Pembayaran();
        } while (menuUtama
                != 3);
    }
}
