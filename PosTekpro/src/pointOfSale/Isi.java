package pointOfSale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Isi {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("saldo")
    @Expose
    private long saldo;

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getSaldo() {
        return this.saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
    
}
