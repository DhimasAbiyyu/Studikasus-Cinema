package Controllers;
import Entity.DaftarCustomerEntity;
import Entity.CustomerEntity;
import javax.swing.table.DefaultTableModel;

public class CustomerController implements ControllerInterface {
    int indexLogin = 0;
    public CustomerController() {
    }
    public CustomerEntity getData() {
        return  AllObjectModel.pembeli.getPembeliEntityArrayList(indexLogin);
    }

    public void daftarfilm(int indexfilm, CustomerEntity pembeliEntity, boolean isVerified) {
        AllObjectModel.daftar.insertDataDaftar(new DaftarCustomerEntity(pembeliEntity,isVerified, indexfilm));
    }

    @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel.pembeli.cekData(nama, password);
    }

    public void insert(String nama, String password, String notelp) {
        AllObjectModel.pembeli.insert(new CustomerEntity(nama,password,notelp));
    }

    public CustomerEntity pembeliEntity() {
        return AllObjectModel.pembeli.getPembeliEntityArrayList(indexLogin);
    }

    public int cekDaftarPembeli(String nama) {
        int cek = AllObjectModel.daftar.cekData(nama, null);
        return cek;
    }
    public DaftarCustomerEntity showDaftarPembeli(int index) {
        return AllObjectModel.daftar.showDaftarPembeli(index);
    }

    public void update(String Film, int UpdateFilm) {
        AllObjectModel.daftar.update(Film, UpdateFilm);
    }

    public void deleteDatapembeli(int index) {
        AllObjectModel.daftar.hapuspembeliModel(index);
    }

    public DefaultTableModel daftarpembeli() {
        DefaultTableModel dtmdaftarpembeli = new DefaultTableModel() ;
        Object[] kolom = {"nama","password","notelp","verifikasi"};
        dtmdaftarpembeli.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftar.alldatapembeli().size();
        String verif = null;
        for(int i=0; i<size;i++){
            if(AllObjectModel.daftar.alldatapembeli().get(i).isIsVerified()==false) {
                verif = "NO";
            } else {
                verif = "DONE";
            }
            Object [] data = new Object[5];
            data[0] = AllObjectModel.daftar.alldatapembeli().get(i).getPembeli().getNama();
            data[1] = AllObjectModel.daftar.alldatapembeli().get(i).getPembeli().getPassword();
            data[2] = AllObjectModel.daftar.alldatapembeli().get(i).getPembeli().getEmail();
            data[3] = verif;
            dtmdaftarpembeli.addRow(data);
        }
        return dtmdaftarpembeli;
    }
}