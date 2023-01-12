package Models;
import Entity.AdminEntity;
import java.util.ArrayList;

public class AdminModel implements ModelInterface{
    private ArrayList<AdminEntity> CustomerEntityArrayList;

    public AdminModel() {
        CustomerEntityArrayList = new ArrayList<AdminEntity>();
    }
    public void inserPenjual(AdminEntity penjual) {
        CustomerEntityArrayList.add(penjual);
    }
    public void view() {
        for (AdminEntity penjualEntity : CustomerEntityArrayList) {
            System.out.println(penjualEntity.getNama());
            System.out.println(penjualEntity.getPassword());
            System.out.println(penjualEntity.getBios());
        }
    }

    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        for (AdminEntity penjualEntity : CustomerEntityArrayList) {
            if (penjualEntity.getNama().equals(nama) && penjualEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    public AdminEntity showDataPenjual(int index) {
        return CustomerEntityArrayList.get(index);
    }

}