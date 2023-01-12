package Models;

import Entity.CustomerEntity;
import java.util.ArrayList;

public class CustomerModel implements ModelInterface {

    private ArrayList<CustomerEntity> CustomerEntityArrayList;

    public CustomerModel() {
        CustomerEntityArrayList = new ArrayList<CustomerEntity>();
    }

    public void insert(CustomerEntity pembeliEntity) {
        CustomerEntityArrayList.add(pembeliEntity);
    }
    @Override
    public void view() {
        for (CustomerEntity pembeliEntity : CustomerEntityArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : "+ pembeliEntity.getNama()+ "\nPassword : "+ pembeliEntity.getPassword()+"\n No Telp : "+pembeliEntity.getEmail());
            System.out.println("==============================================");
        }
    }

    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        while (!CustomerEntityArrayList.get(loop).getNama().equals(nama)&&!CustomerEntityArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }
        return loop;
    }
    public CustomerEntity getPembeliEntityArrayList(int index) {
        return CustomerEntityArrayList.get(index);
    }

}