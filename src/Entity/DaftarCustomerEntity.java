package Entity;

public class DaftarCustomerEntity {
    private CustomerEntity customer;
    private boolean isVerified;
    private int indexFilm;

    public DaftarCustomerEntity(CustomerEntity customer, boolean isVerified, int indexFilm) {
        this.customer = customer;
        this.isVerified = isVerified;
        this.indexFilm = indexFilm;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity pembeli) {
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