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
public class CartObj {
    
    private Produk produk;
    private int amount = 0;
    
    public CartObj(Produk produk, int amount)
    {
        this.produk = produk;
        this.amount = amount;
    }
    
    public Produk getProduk()
    {
        return this.produk;
    }
    
    public void setProduk(Produk produk)
    {
        this.produk = produk;
    }
    
    public int getAmount()
    {
        return this.amount;
    }
    
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
}
