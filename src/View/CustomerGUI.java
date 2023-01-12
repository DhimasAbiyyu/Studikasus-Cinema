package View;

import Entity.FilmEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CustomerGUI {

    JFrame customer = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarFilm;
    JComboBox pilFilm = new JComboBox(FilmEntity.film);
    int cek = AllObjctrl.pembeli.cekDaftarPembeli(AllObjctrl.pembeli.getData().getNama());

    public CustomerGUI() {
        customer.setSize(720, 600);
        customer.setLayout(null);
        customer.getContentPane().setBackground(Color.LIGHT_GRAY);

        datadiri = new JLabel("Data Customer");
        datadiri.setFont(new Font("Timer New Roman", Font.BOLD, 25));
        datadiri.setBounds(150, 30, 220, 30);
        customer.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        customer.add(area);

        daftarFilm = new JLabel("Daftar Film");
        daftarFilm.setBounds(450, 30, 250, 30);

        customer.add(daftarFilm);
        pilFilm.setBounds(450, 90, 230, 30);
        customer.add(pilFilm);

        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 120, 30);
        daftarbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
        daftarbtn.setBackground(Color.WHITE);
        customer.add(daftarbtn);

        back = new JButton("Back");
        back.setBounds(320, 460, 100, 30);
        back.setFont(new Font("Times New Roman", Font.BOLD, 30));
        back.setBackground(Color.WHITE);
        customer.add(back);

        customer.setVisible(true);
        customer.setLocationRelativeTo(null);
        customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Film", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Film", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datapembeli());
        }
        daftarbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexfilm = pilFilm.getSelectedIndex();
                AllObjctrl.pembeli.daftarfilm(indexfilm, AllObjctrl.pembeli.getData(), false);
                area.setText(datapembeli());
            }

        });
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                customer.dispose();
                GUI men = new GUI();
            }

        });
    }

    String datapembeli() {
        int cek = AllObjctrl.pembeli.cekDaftarPembeli(AllObjctrl.pembeli.getData().getNama());
        String cekverif;
        if (AllObjctrl.pembeli.showDaftarPembeli(cek).isIsVerified() == false) {
            cekverif = "belum di verifikasi";
        } else {
            cekverif = "Sudah di verifikasi";
        }
        String text = "Nama = " + AllObjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getNama() + "\n"
                + "Email = " + AllObjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getEmail() + "\n"
                + "Verifikasi = " + cekverif + "\n"
                + "Film = " + FilmEntity.film[AllObjctrl.pembeli.showDaftarPembeli(cek).getIndexFilm()];
        return text;
    }
}