package Entity;

public class CustomerEntity extends AbstractEntity {
    private String email;

    public CustomerEntity(String nama, String password, String email) {
        super(nama, password);
        this.email = email;
    }
    @Override
    public String getNama() {
        return nama;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}