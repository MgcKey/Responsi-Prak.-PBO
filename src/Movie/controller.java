package Movie;

import javax.swing.*;
import java.awt.event.*;

public class controller {
    model m;
    view v;
    public String dataTerpilih;

    public controller(model m, view v) {
        this.m = m;
        this.v = v;
        
        if (m.getBanyakData()==0) {
            JOptionPane.showMessageDialog(null, "Data film masih kosong");
        }
        else {
            String data[][] = m.listFilm();
            v.tabel.setModel((new JTable(data, v.namaKolom)).getModel());
        }
        v.tabel.addMouseListener(new MouseAdapter(){    
            public void mouseClicked(MouseEvent me) {
                super.mousePressed(me);
                int baris = v.tabel.getSelectedRow();
                dataTerpilih = v.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataTerpilih);     
        }
        });
        
        v.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = v.getJudul();
                String alur = v.getAlur();
                String penokohan = v.getPenokohan();
                String akting = v.getAkting();
                System.out.println(filterInput());
                if(filterInput()==0){
                    m.tambahFilm(judul, alur, penokohan, akting);
                    String data[][] = m.listFilm();
                    v.tabel.setModel((new JTable(data, v.namaKolom)).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Range inputan 0-5");
                }
                
            }
        });
        
        v.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = v.getJudul();
                String alur = v.getAlur();
                String penokohan = v.getPenokohan();
                String akting = v.getAkting();
                if(filterInput()==0){
                    m.updateFilm(judul, alur, penokohan, akting);
                    String data[][] = m.listFilm();
                    v.tabel.setModel((new JTable(data, v.namaKolom)).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Range inputan 0-5");
                }
            }
        });
        
        v.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int hapus = JOptionPane.showConfirmDialog(null,
                    "Apa anda ingin menghapus Film " + dataTerpilih + "?", "Opsi Hapus", JOptionPane.YES_NO_OPTION);
                    if (hapus == 0) {
                        m.hapusFilm(dataTerpilih);
                        String data[][] = m.listFilm();
                        v.tabel.setModel((new JTable(data, v.namaKolom)).getModel());
                    } else {
                        JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                    }
            }
        });
        
        v.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v.fJudul.setText("");
                v.fAlur.setText("");
                v.fPenokohan.setText("");
                v.fAlur.setText("");
            }
        });
    }
    
    public int filterInput(){
        double nAlur = Double.parseDouble(v.fAlur.getText());
        double nPenokohan = Double.parseDouble(v.fPenokohan.getText());
        double nAkting = Double.parseDouble(v.fAkting.getText());
        if(nAlur < 0 || nAlur > 5 || nPenokohan < 0 || nPenokohan > 5 || nAkting < 0 || nAkting > 5 ){
            return 1;
        } 
        else{
            return 0;
        }
    }
    
}
