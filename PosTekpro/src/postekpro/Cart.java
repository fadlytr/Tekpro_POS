/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postekpro;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Cart {
    
    private List<CartObj> listBarang;
    private int total = 0;
    
    public void addProduk(Produk produk, int amount)
    {
        this.listBarang.add(new CartObj(produk,amount));
        this.total += (produk.getHarga()*amount);
    }
    
    public void removeProduk(int index, int amount) //modul untuk mengurangi produk dengan jumlah tertentu
    {
        int tamount = this.listBarang.get(index).getAmount();
        if(amount < tamount){
            this.listBarang.get(index).setAmount(tamount - amount);            
            this.total -= (tamount*this.listBarang.get(index).getProduk().getHarga());
        }else if(amount == tamount){
            this.listBarang.remove(index);
        }else{
            System.out.println("Jumlah benda dalam kart tidak sebanyak itu");
        }
    }
    
    public void removeProduk(int index) //jika jumlah yang dikeluarkan tidak ditentukan, maka sluruh produk tersebut dibuang
    {
        this.listBarang.remove(index);
    }
    
    public List<CartObj> getCart()
    {
        return this.listBarang;
    }
    
    public int getTotal()
    {
        return this.total;
    }
    
    public void printProduk()
    {
        System.out.println("Kode Barang | Nama Produk | Harga Satuan | Banyak Dibeli | Harga Total");
        Iterator<CartObj> produk = this.listBarang.iterator();
        while(produk.hasNext())
        {
            CartObj n = produk.next();
            System.out.println(n.getProduk().getId().getCode() + " | " + n.getProduk().getId().getNama() + " | " 
                    + n.getProduk().getHarga() + " | " + n.getAmount() + " | " + (n.getProduk().getHarga()*n.getAmount()));
        }
    }
}
