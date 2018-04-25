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
public class Makanan {
    
    @SerializedName("berat")
    @Expose
    private List<Produk> berat;
    @SerializedName("Ringan")
    @Expose
    private List<Produk> ringan;
    
    public List<Produk> getBerat()
    {
        return this.berat;
    }
    
    public List<Produk> getRingan()
    {
        return this.ringan;
    }
    
    public void setBerat(List<Produk> berat)
    {
        this.berat = berat;
    }
    
    public void setRingan(List<Produk> ringan)
    {
        this.ringan = ringan;
    }
}
