/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postekpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Produk {
    
    @SerializedName("id")
    @Expose
    private ID id;
    @SerializedName("harga")
    @Expose
    private int harga;
    
    public ID getId()
    {
        return this.id;
    }
    
    public int getHarga()
    {
        return this.harga;
    }
    
    public void setId(ID id)
    {
        this.id = id;
    }
    
    public void setHarga(int harga)
    {
        this.harga = harga;
    }
}
