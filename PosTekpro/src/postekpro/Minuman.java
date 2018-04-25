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
public class Minuman {
    
    @SerializedName("keras")
    @Expose
    private List<Produk> keras;
    @SerializedName("ringan")
    @Expose
    private List<Produk> ringan;
    
    public List<Produk> getKeras()
    {
        return this.keras;
    }
    
    public List<Produk> getRingan()
    {
        return this.ringan;
    }
    
    public void setKeras(List<Produk> berat)
    {
        this.keras = berat;
    }
    
    public void setRingan(List<Produk> ringan)
    {
        this.ringan = ringan;
    }
}
