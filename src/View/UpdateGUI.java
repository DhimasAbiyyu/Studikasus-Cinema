package View;
import Entity.FilmEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;

public class UpdateGUI {
    JComboBox pilFilm = new JComboBox(FilmEntity.film);
    JButton konfirmasi,kembali;
    JFrame TampilanAwal = new JFrame();
    JTextArea area = new JTextArea();
    JLabel update,labelFilmUpdate;
    JTextField textFilmUpdate;

    public UpdateGUI() {

        TampilanAwal.setSize(720,600);
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.LIGHT_GRAY);

        update = new JLabel("Update Data");
        update.setFont(new Font("Times New Roman",Font.BOLD,43));
        update.setBounds(240,30,300,80);
        TampilanAwal.add(update);

        labelFilmUpdate = new JLabel("Nama Pembeli");
        labelFilmUpdate.setBounds(300,180,150,30);
        TampilanAwal.add(labelFilmUpdate);

        textFilmUpdate = new JTextField();
        textFilmUpdate.setBounds(250,210,200,40);
        TampilanAwal.add(textFilmUpdate);

        pilFilm.setBounds(276,270,150,40);
        TampilanAwal.add(pilFilm);

        konfirmasi = new JButton("KONFIRMASI");
        konfirmasi.setBounds(290,330,120,40);
        konfirmasi.setBackground(Color.WHITE);
        TampilanAwal.add(konfirmasi);

        kembali = new JButton("KEMBALI");
        kembali.setBounds(290,380,120,40);
        kembali.setBackground(Color.WHITE);
        TampilanAwal.add(kembali);

        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal. setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);

        konfirmasi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int FilmUpdate = pilFilm.getSelectedIndex();
                AllObjctrl.pembeli.update(textFilmUpdate.getText(), FilmUpdate);
                JOptionPane.showMessageDialog(null,"PILIHAN FILM BERHASIL DI UPDATE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                kosong();
            }

        });

        kembali.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                TampilanAwal.dispose();
                GUI men = new GUI();
            }

        });
    }
    void kosong() {
        textFilmUpdate.setText(null);
    }
}