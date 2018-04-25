/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postekpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Asus
 */
public class ID {
    
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("code")
    @Expose
    private String code;
    
    public String getNama()
    {
        return this.nama;
    }
    
    public String getCode()
    {
        return this.code;
    }
    
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
}
