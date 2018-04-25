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
import java.util.Scanner;
import java.util.Iterator;

/**
 *
 * @author Ahmad_Aji_Naufal_Ali
 */
public class PosTekproMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Gson gson = new Gson(); 
        BufferedReader br = new BufferedReader(new FileReader("src/json/ListBarang3.json"));
        Barang target = gson.fromJson(br, Barang.class);
        List <Produk> barang = target.getAllData();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Masukkan kode barang :");
     
        String kode = scan.next();
        
        boolean temu = false;
        Iterator<Produk> n = barang.iterator();
        while ( n.hasNext() && !temu )
        {
            if (n.next().getId().getCode().equalsIgnoreCase(kode))
                    {
                        temu = true;
                        System.out.println(n.next().getId().getNama() + " " + n.next().getHarga() );
                    }
        }
        
        if (temu == false) 
        {
            System.out.println(" Kode tidak ditemukan ");
        }
        
        
                
    }
    
}
