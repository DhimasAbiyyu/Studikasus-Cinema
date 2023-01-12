package Entity;

public class DaftarCustomerEntity {
    private CustomerEntity pembeli;
    private boolean isVerified;
    private int indexFilm;

    public DaftarCustomerEntity(CustomerEntity pembeli, boolean isVerified, int indexFilm) {
        this.pembeli = pembeli;
        this.isVerified = isVerified;
        this.indexFilm = indexFilm;
    }

    public CustomerEntity getPembeli() {
        return pembeli;
    }

    public void setPembeli(CustomerEntity pembeli) {
        this.pembeli = pembeli;
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