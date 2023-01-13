package Models;
import Entity.AdminEntity;
import java.util.ArrayList;

public class AdminModel implements ModelInterface{
    private ArrayList<AdminEntity> CustomerEntityArrayList;

    public AdminModel() {
        CustomerEntityArrayList = new ArrayList<AdminEntity>();
    }
    public void insertAdmin(AdminEntity admin) {
        CustomerEntityArrayList.add(admin);
    }
    public void view() {
        for (AdminEntity adminEntity : CustomerEntityArrayList) {
            System.out.println(adminEntity.getNama());
            System.out.println(adminEntity.getPassword());
            System.out.println(adminEntity.getBios());
        }
    }

    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        for (AdminEntity AdminEntity : CustomerEntityArrayList) {
            if (AdminEntity.getNama().equals(nama) && AdminEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    public AdminEntity showDataAdmin(int index) {
        return CustomerEntityArrayList.get(index);
    }

}