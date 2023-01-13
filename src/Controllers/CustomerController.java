package Controllers;
import Entity.DaftarCustomerEntity;
import Entity.CustomerEntity;
import javax.swing.table.DefaultTableModel;

public class CustomerController implements ControllerInterface {
    int indexLogin = 0;
    public CustomerController() {
    }
    public CustomerEntity getData() {
        return  AllObjectModel.customer.getCustomerEntityArrayList(indexLogin);
    }

    public void daftarfilm(int indexfilm, CustomerEntity pembeliEntity, boolean isVerified) {
        AllObjectModel.daftar.insertDataDaftar(new DaftarCustomerEntity(pembeliEntity,isVerified, indexfilm));
    }

    @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel.customer.cekData(nama, password);
    }

    public void insert(String nama, String password, String notelp) {
        AllObjectModel.customer.insert(new CustomerEntity(nama,password,notelp));
    }

    public CustomerEntity customerEntity() {
        return AllObjectModel.customer.getCustomerEntityArrayList(indexLogin);
    }

    public int cekDaftarCustomer(String nama) {
        int cek = AllObjectModel.daftar.cekData(nama, null);
        return cek;
    }
    public DaftarCustomerEntity showDaftarPembeli(int index) {
        return AllObjectModel.daftar.showDaftarCustomer(index);
    }

    public void update(String Film, int UpdateFilm) {
        AllObjectModel.daftar.update(Film, UpdateFilm);
    }

    public void deleteDatapembeli(int index) {
        AllObjectModel.daftar.hapuscustomerModel(index);
    }

    public DefaultTableModel daftarcustomer() {
        DefaultTableModel dtmdaftarpembeli = new DefaultTableModel() ;
        Object[] kolom = {"nama","password","notelp","verifikasi"};
        dtmdaftarpembeli.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftar.alldatacustomer().size();
        String verif = null;
        for(int i=0; i<size;i++){
            if(AllObjectModel.daftar.alldatacustomer().get(i).isIsVerified()==false) {
                verif = "NO";
            } else {
                verif = "DONE";
            }
            Object [] data = new Object[5];
            data[0] = AllObjectModel.daftar.alldatacustomer().get(i).getCustomer().getNama();
            data[1] = AllObjectModel.daftar.alldatacustomer().get(i).getCustomer().getPassword();
            data[2] = AllObjectModel.daftar.alldatacustomer().get(i).getCustomer().getEmail();
            data[3] = verif;
            dtmdaftarpembeli.addRow(data);
        }
        return dtmdaftarpembeli;
    }
}