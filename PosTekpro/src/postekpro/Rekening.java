package postekpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rekening {
    
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("isi")
    @Expose
    private Isi isi; 
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * @return the isi
     */
    public Isi getIsi() {
        return this.isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(Isi isi) {
        this.isi = isi;
    }
    
     
}
