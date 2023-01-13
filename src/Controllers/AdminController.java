package Controllers;
import Entity.AdminEntity;
import Entity.DaftarCustomerEntity;
import Entity.CustomerEntity;
import java.util.ArrayList;

public class AdminController implements ControllerInterface {
    int indexLogin = 0;
    public AdminController() {
    }

    public void dataAdmin() {
        String namaAdmin[] = {"Dhimas","Rakha","Saffir"};
        String passwordAdmin[] = {"dhimas","rakha","saffir"};


        for (int i=0; i<namaAdmin.length;i++) {
            AllObjectModel.admin.insertAdmin(new AdminEntity(namaAdmin[i], passwordAdmin[i]));
        }
    }
    public void viewadmin() {
        AllObjectModel.admin.view();
    }


    @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel.admin.cekData(nama, password);
    }

    public AdminEntity adminEntity() {
        return AllObjectModel.admin.showDataAdmin(indexLogin);
    }

    public void updateIsVerified(int index, int indexFilm, CustomerEntity customerEntity) {
        AllObjectModel.daftar.updateIsVerified(index, new DaftarCustomerEntity(customerEntity, true, indexFilm));
    }

    public ArrayList<DaftarCustomerEntity> cekDaftarModel() {
        return AllObjectModel.daftar.getDaftarArrayList();
    }
}