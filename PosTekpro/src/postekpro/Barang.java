/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postekpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Asus
 */
public class Barang {
    
    @SerializedName("makanan")
    @Expose
    private Makanan makanan;
    @SerializedName("Minuman")
    @Expose
    private Minuman minuman;
    
    public Makanan getMakanan()
    {
        return this.makanan;
    }
    
    public Minuman getMinuman()
    {
        return this.minuman;
    }
    
    public void setMakanan(Makanan makanan)
    {
        this.makanan = makanan;
    }
    
    public void setMinuman(Minuman minuman)
    {
        this.minuman = minuman;
    }
    
    public List<Produk> getAllMakanan()
    {
        List<Produk> listBarang = new ArrayList<>(makanan.getBerat());
        listBarang.addAll(makanan.getRingan());
        return listBarang;
    }
    
    public List<Produk> getAllMinuman()
    {
        List<Produk> listBarang = new ArrayList<>(minuman.getKeras());
        listBarang.addAll(minuman.getRingan());
        return listBarang;
    }
    
    public List<Produk> getAllData()
    {
        List<Produk> listBarang = new ArrayList<>(getAllMakanan());
        listBarang.addAll(getAllMinuman());
        return listBarang;
    }
    
    public List<Produk> filterData(int i)
    {
        List<Produk> listBarang=null;
        
        switch (i) {
            case 1:
                //filter minuman
                listBarang = getAllData();
                break;
            case 2:
                //filter minuman
                listBarang = getAllMinuman();
                break;
            case 3:
                //filter makanan
                listBarang = getAllMakanan();
                break;
            case 4:
                //minuman keras
                listBarang = new ArrayList<>(minuman.getKeras());
                break;
            case 5:
                // minuman ringan
                listBarang = new ArrayList<>(minuman.getRingan());
                break;
            case 6:
                //makanan berat
                listBarang = new ArrayList<>(makanan.getBerat());
                break;
            case 7:
                //makanan ringan
                listBarang = new ArrayList<>(makanan.getRingan());
                break;
        }
        return listBarang;
    }
}
