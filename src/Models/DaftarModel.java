package Models;
import Entity.DaftarCustomerEntity;
import Entity.FilmEntity;

import java.util.ArrayList;

public class DaftarModel implements ModelInterface {
    private ArrayList<DaftarCustomerEntity> daftarArrayList;

    public DaftarModel() {
        daftarArrayList = new ArrayList<DaftarCustomerEntity>();
    }
    public void insertDataDaftar(DaftarCustomerEntity daftar) {
        daftarArrayList.add(daftar);
    }
    public ArrayList<DaftarCustomerEntity>getDaftarArrayList() {
        return daftarArrayList;
    }
    public int size() {
        return daftarArrayList.size();
    }

    @Override
    public void view() {
        for (DaftarCustomerEntity daftar : daftarArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : " + daftar.getCustomer().getNama()+"\nPassword : " + daftar.getCustomer().getPassword() + "\nNo telp : "+daftar.getCustomer().getEmail()+"\n Film : "+FilmEntity.film[daftar.getIndexFilm()] + "\n isVerified : ");
            if(daftar.isIsVerified()==false) {
                System.out.println("Belum Di Verifikasi Penjual");
            } else {
                System.out.println("Sudah Di Verifikasi Penjual");
            }
            System.out.println("==============================================");
        }
    }
    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        if(daftarArrayList.size() == 0) {
            loop = -1;
        } else {
            for (int i=0; i<daftarArrayList.size(); i++) {
                if (daftarArrayList.get(i).getCustomer().getNama().equals(nama)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public DaftarCustomerEntity showDaftarCustomer(int index) {
        return daftarArrayList.get(index);
    }
    public void updateIsVerified(int index, DaftarCustomerEntity DaftarCustomer) {
        daftarArrayList.set(index, DaftarCustomer);
    }
    public void hapuscustomerModel(int index) {
        daftarArrayList.remove(daftarArrayList.get(index));
    }

    public ArrayList <DaftarCustomerEntity> alldatacustomer() {
        return daftarArrayList;
    }

    private int cariFilm(String Film){
        int index=-1;
        for(int i=0;i <daftarArrayList.size();i++) {
            if(Film.equals(daftarArrayList.get(i).getCustomer().getNama()))
                index=i;
        }
        return index;
    }

    public void update(String Film, int UpdateFilm){
        int data;
        if(cariFilm(Film)!=-1){
            daftarArrayList.get(cariFilm(Film)).setIndexBaju(UpdateFilm);
            data = 1;
        }
        else {
            data = 0;
        }
    }

}