package com.ophi.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class MainScreen extends JFrame {

    private JPanel panelMain;
    private JList jListMahasiswa;
    private JTextField txtFilter;
    private JButton btnFilter;
    private JTextField txtNama;
    private JTextField txtNim;
    private JTextField txtIpk;
    private JButton btnSave;
    private JButton btnDelete;
    private JButton btnClear;
    private JPanel fieldname;
    private JLabel lblNim;
    private JLabel lblIpk;
    private JLabel lblNama;

    List<Mahasiswa> arrayListMahasiswa = new ArrayList<>();
    DefaultListModel defaultListModel = new DefaultListModel();

    class Mahasiswa {
        public String Nama;
        public String nim;
        public float ipk;

        public String getNama() {
            return Nama;
        }

        public void setNama(String nama) {
            Nama = nama;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public float getIpk() {
            return ipk;
        }

        public void setIpk(float ipk) {
            this.ipk = ipk;
        }

    }

    public MainScreen(){
        super("Data Mahasiswa");
        this.setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        this.pack();

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String nama = txtNama.getText();
            String nim = txtNim.getText();
            float ipk = Float.parseFloat(txtIpk.getText());

            Mahasiswa mahasiswa = new Mahasiswa();

            mahasiswa.setNama(nama);
            mahasiswa.setNim(nim);
            mahasiswa.setIpk(ipk);

            arrayListMahasiswa.add(mahasiswa);

            fromListMahasiswaToListModel();
            }
        });
    }

    public void fromListMahasiswaToListModel(){
        List<String> listNamaMahasiswa = new ArrayList<>();

        for (int i = 0; i < arrayListMahasiswa.size(); i++){
            listNamaMahasiswa.add(
                    arrayListMahasiswa.get(1).getNama()
            );
        }
        refreshListModel(listNamaMahasiswa);
    }

    public void  refreshListModel(List<String> list){
        defaultListModel.clear();
        defaultListModel.addAll(list);
        jListMahasiswa.setModel(defaultListModel);
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }
}
