package Entity;

public class AdminEntity extends AbstractEntity {
    private String bios;

    public AdminEntity(String nama, String password) {
        super(nama, password);
        this.bios = bios;
    }
    @Override
    public String getNama() {
        return this.nama;
    }
    public String getBios(){
        return this.bios;
    }
    public void setToko(String bios) {
        this.bios = bios;
    }

}
