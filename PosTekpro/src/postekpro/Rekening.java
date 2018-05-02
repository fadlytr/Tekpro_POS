package postekpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("pin")
    @Expose
    private int pin;
    @SerializedName("isi")
    @Expose
    private List<Isi> isi; 
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * @return the isi
     */
    public List<Isi> getIsi() {
        return this.isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(List<Isi> isi) {
        this.isi = isi;
    }
    
    public List<Rekening> getAllId()
    {
        List<Rekening> listId = new ArrayList<>(getId());
        return listId;
    }
   
    public List<Rekening> getAllPIN()
    {
        List<Rekening> listPin = new ArrayList<>(getPin());
        return listPin;
    }
    
    public List<Isi> getAllIsi()
    {
        List<Isi> listIsi = new ArrayList<>(getIsi());
        return listIsi;
    }
    
     public List<Rekening> getAllRekening(){
        List<Rekening> listRek = new ArrayList<>(getAllId());
        listRek.addAll(getAllPIN());
        return listRek;
    }
}
