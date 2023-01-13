package Entity;

public class DaftarCustomerEntity {
    private CustomerEntity customer;
    private boolean isVerified;
    private int indexFilm;

    public DaftarCustomerEntity(CustomerEntity pembeli, boolean isVerified, int indexFilm) {
        this.customer = pembeli;
        this.isVerified = isVerified;
        this.indexFilm = indexFilm;
    }

    public CustomerEntity getPembeli() {
        return customer;
    }

    public void setPembeli(CustomerEntity pembeli) {
        this.customer = pembeli;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexFilm() {
        return indexFilm;
    }

    public void setIndexBaju(int indexFilm) {
        this.indexFilm = indexFilm;
    }

}