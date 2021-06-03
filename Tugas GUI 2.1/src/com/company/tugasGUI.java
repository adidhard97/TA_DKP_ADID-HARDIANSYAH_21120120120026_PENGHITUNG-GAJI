package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tugasGUI {
    private JPanel panel1;
    private JTextField tfNama;
    private JTextField tfDivisi;
    private JTextField tfJam;
    private JButton hapusButton;
    private JButton kirimButton;
    private JButton selesaiButton;
    private JTextArea taHasil;



    public tugasGUI() {
        kirimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer Divisi, jam, bonus, gaji, tgaji, upah;

                if(tfNama.getText().equals("") || tfJam.getText().equals("") || tfDivisi.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Divisi dan Jam Kerja Tidak Boleh Kosong");
                } else {

                    jam = Integer.parseInt(tfJam.getText());
                    Divisi = Integer.parseInt(tfDivisi.getText());


                    upah = 0;
                    switch (Divisi) {
                        case (1):
                            upah = 25000;
                            break;
                        case (2):
                            upah = 20000;
                            break;
                        case (3):
                            upah = 15000;
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Divisi Salah !\nHanya Tersedia Divisi 1-3");

                    }

                    if (Divisi > 0 && Divisi < 6){
                        gaji = jam * upah;
                    bonus = 0;
                    if (jam > 72) {
                        bonus = 10000 * (jam - 72);
                    }
                    tgaji = gaji + bonus;

                    taHasil.setText("\tKWITANSI GAJI MEMBER My Project\t\t" +
                            "\n\n" +
                            "\nNAMA\t\t: " + tfNama.getText() +
                            "\nDIVISI\t\t: " + tfDivisi.getText() +
                            "\nJUMLAH JAM KERJA\t: " + tfJam.getText() +
                            "\nGAJI POKOK\t\t: Rp. " + gaji +
                            "\nBONUS\t\t: Rp. " + bonus +
                            "\nTOTAL PENDAPATAN\t: Rp. " + tgaji);

                }

                }




            }
        });

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tfNama.setText("");
                tfJam.setText("");
                tfDivisi.setText("");
            }
        });
        selesaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNama.setText("");
                tfJam.setText("");
                tfDivisi.setText("");
                taHasil.setText("");
            }
        });



        
    };


    public static void main(String[] args) {
        JFrame frame = new JFrame("tugasGUI");
        frame.setContentPane(new tugasGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
