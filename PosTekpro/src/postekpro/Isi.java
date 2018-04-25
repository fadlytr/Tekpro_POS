package postekpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Isi {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("saldo")
    @Expose
    private Integer saldo;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

}
