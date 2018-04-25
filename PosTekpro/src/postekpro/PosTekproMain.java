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
        BufferedReader br = new BufferedReader(new FileReader("*/../maps.json"));
        Barang target = gson.fromJson(br, Barang.class);
    }
    
}
