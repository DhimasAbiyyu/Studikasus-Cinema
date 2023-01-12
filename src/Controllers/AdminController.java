package Controllers;
import Entity.AdminEntity;
import Entity.DaftarCustomerEntity;
import Entity.CustomerEntity;
import java.util.ArrayList;

public class AdminController implements ControllerInterface {
    int indexLogin = 0;
    public AdminController() {
    }

    public void dataPenjual() {
        String namaAdmin[] = {"Dhimas","Rakha","Safir"};
        String passwordAdmin[] = {"dhimas","rakha","safir"};


        for (int i=0; i<namaAdmin.length;i++) {
            AllObjectModel.penjual.inserPenjual(new AdminEntity(namaAdmin[i], passwordAdmin[i]));
        }
    }
    public void viewpenjual() {
        AllObjectModel.penjual.view();
    }


    @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel.penjual.cekData(nama, password);
    }

    public AdminEntity penjualEntity() {
        return AllObjectModel.penjual.showDataPenjual(indexLogin);
    }

    public void updateIsVerified(int index, int indexBaju, CustomerEntity pembeliEntity) {
        AllObjectModel.daftar.updateIsVerified(index, new DaftarCustomerEntity(pembeliEntity, true, indexBaju));
    }

    public ArrayList<DaftarCustomerEntity> cekDaftarModel() {
        return AllObjectModel.daftar.getDaftarArrayList();
    }
}