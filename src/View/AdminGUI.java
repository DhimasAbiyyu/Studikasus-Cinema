package View;
import Controllers.AllObjectModel;
import Controllers.CustomerController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class AdminGUI {
    private static CustomerController pembeli = new CustomerController();
    JFrame admin = new JFrame();
    JTable tabelcustomer = new JTable();
    JScrollPane scrollpenjual = new JScrollPane(tabelcustomer);
    JButton back,verif,hapus;
    JLabel Penjual,namalabel,passwordlabel;
    JTextField namatext,passtext;

    public AdminGUI() {
        admin.setSize(650,500);
        admin.setLayout(null);
        admin.getContentPane().setBackground(Color.LIGHT_GRAY);
        Penjual = new JLabel("ADMIN");
        Penjual.setBounds(230,30,200,30);
        Penjual.setFont(new Font("Times New Roman",Font.BOLD,40));
        admin.add(Penjual);

        scrollpenjual.setBounds(30,100,570,200);
        tabelcustomer.setModel(pembeli.daftarpembeli());
        admin.add(scrollpenjual);

        namalabel = new JLabel("Nama");
        namalabel.setBounds(50,320,100,30);
        admin.add(namalabel);
        namatext = new JTextField();
        namatext.setBounds(50,350,100,30);
        admin.add(namatext);

        passwordlabel = new JLabel("Password");
        passwordlabel.setBounds(200,320,100,30);
        admin.add(passwordlabel);
        passtext = new JTextField();
        passtext.setBounds(200,350,100,30);
        admin.add(passtext);

        verif = new JButton("verifikasi");
        verif.setBounds(350, 350, 120, 30);
        verif.setBackground(Color.WHITE);
        admin.add(verif);

        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.WHITE);
        admin.add(back);

        hapus = new JButton("Hapus");
        hapus.setBounds(480, 400, 100, 30);
        hapus.setBackground(Color.WHITE);
        admin.add(hapus);

        admin.setLocationRelativeTo(null);
        admin.setVisible(true);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                admin.dispose();
                GUI men = new GUI();
            }

        });

        verif.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = namatext.getText();
                String password = passtext.getText();
                int index = AllObjectModel.daftar.cekData(nama, password);
                AllObjctrl.penjual.updateIsVerified(index,AllObjctrl.pembeli.showDaftarPembeli(index).getIndexFilm(),AllObjctrl.pembeli.showDaftarPembeli(index).getPembeli());
                tabelcustomer.setModel(pembeli.daftarpembeli());
            }

        });

        hapus.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                AllObjctrl.pembeli.deleteDatapembeli(0);
                tabelcustomer.setModel(pembeli.daftarpembeli());
            }

        });
        tabelcustomer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelcustomer.getSelectedRow();
                namatext.setText(AllObjctrl.pembeli.daftarpembeli().getValueAt(i, 0).toString());
                passtext.setText(AllObjctrl.pembeli.daftarpembeli().getValueAt(i, 1).toString());
            }
        });
    }
}