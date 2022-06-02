package Movie;

import javax.swing.*;
import javax.swing.table.*;

public class view extends JFrame{
    JLabel lJudul = new JLabel("Judul");
    JLabel lAlur = new JLabel("Alur");
    JLabel lPenokohan = new JLabel("Penokohan");
    JLabel lAkting = new JLabel("Akting");
    public JTextField fJudul = new JTextField();
    public JTextField fAlur = new JTextField();
    public JTextField fPenokohan = new JTextField();
    public JTextField fAkting = new JTextField();
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};

    public view() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Film");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(800,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 30, 500, 300);
        
        add(lJudul);
        lJudul.setBounds(600, 20, 90, 20);
        add(fJudul);
        fJudul.setBounds(600, 40, 120, 20);
        
        add(lAlur);
        lAlur.setBounds(600, 60, 90, 20);
        add(fAlur);
        fAlur.setBounds(600, 80, 120, 20);
        
        add(lPenokohan);
        lPenokohan.setBounds(600, 100, 90, 20);
        add(fPenokohan);
        fPenokohan.setBounds(600, 120, 120, 20);
        
        add(lAkting);
        lAkting.setBounds(600, 140, 90, 20);
        add(fAkting);
        fAkting.setBounds(600, 160, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(610, 220, 100, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(610, 250, 100, 20);
        
        add(btnDelete);
        btnDelete.setBounds(610, 280, 100, 20);
        
        add(btnClear);
        btnClear.setBounds(610, 310, 100, 20);
    }
    
    public String getJudul(){
        return fJudul.getText();
    }
    
    public String getAlur(){
        return fAlur.getText();
    }
    
    public String getPenokohan(){
        return fPenokohan.getText();
    }
    
    public String getAkting(){
        return fAkting.getText();
    }   
}
