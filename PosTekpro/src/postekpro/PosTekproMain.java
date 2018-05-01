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
import java.util.Scanner;

/**
 *
 * @author Ahmad_Aji_Naufal_Ali
 */
public class PosTekproMain {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("src/json/ListBarang3.json"));
        Barang target = gson.fromJson(br, Barang.class);
        
        BufferedReader rek = new BufferedReader(new FileReader("src/json/ListRekening2.json"));
        Rekening target_2 = gson.fromJson(rek, Barang.class);
        
        Scanner baca = new Scanner(System.in);
        int filter;

        do {
            System.out.println("1. print semua barang");
            System.out.println("2. print Minuman");
            System.out.println("3. print Makanan");
            System.out.println("4. print Minuman Keras");
            System.out.println("5. print Minuman Ringan");
            System.out.println("6. print Makanan Berat");
            System.out.println("7. print Makanan Ringan\n");
            System.out.print("pilih menu filter: ");
            filter = baca.nextInt();
        } while (filter < 1 || filter > 7);

        //List <Produk> barang = target.getAllData();
        List<Produk> barang = target.filterData(filter);
        Scanner scan = new Scanner(System.in);

        Iterator<Produk> n = barang.iterator();
        while (n.hasNext()) {
            Produk z = n.next();
            System.out.print("\n" + z.getId().getCode() + " " + z.getId().getNama() + " " + z.getHarga());
        }
        System.out.print("\nMasukkan kode barang : ");

        String kode = scan.next();

        boolean temu = false;
        n = barang.iterator();
        while (n.hasNext() && !temu) {
            Produk z = n.next();
            if (z.getId().getCode().equalsIgnoreCase(kode)) {
                temu = true;
                System.out.println(z.getId().getNama() + " " + z.getHarga());
            }
        }

        if (temu == false) {
            System.out.println("Kode tidak ditemukan ");
        }
    }
}
