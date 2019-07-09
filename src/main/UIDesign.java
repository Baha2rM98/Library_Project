package main;

import insert.InsertBooks;
import search.SearchBooks;
import updateDelete.UpdateDelete;

import javax.swing.*;
import java.awt.*;

public class UIDesign extends JFrame {

    UIDesign() {
        initComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new UIDesign().setVisible(true));
    }

    private void initComponents() {
        JPanel jPanel2 = new JPanel();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();
        JButton jButton5 = new JButton();
        JLabel jLabel2 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");

        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton1.setText("Search Books");
        jButton1.addActionListener(evt -> searchBook());
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 10, 270, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton2.setText("Add A New Book Record");
        jButton2.addActionListener(evt -> addBook());
        jPanel2.add(jButton2);
        jButton2.setBounds(633, 10, 280, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton3.setText("Update and Delete Books");
        jButton3.addActionListener(evt -> updateAndDeleteBook());
        jPanel2.add(jButton3);
        jButton3.setBounds(10, 443, 290, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton4.setText("Exit");
        jButton4.addActionListener(evt -> exit());
        jPanel2.add(jButton4);
        jButton4.setBounds(643, 433, 270, 50);

        jButton5.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        jButton5.setText("Info");
        jButton5.addActionListener(evt -> showInfo());
        jPanel2.add(jButton5);
        jButton5.setBounds(10, 70, 80, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/background/books-1614215_1920.jpg")));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 1030, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }

    private void addBook() {
        InsertBooks insert = new InsertBooks();
        insert.setVisible(true);
    }

    private void updateAndDeleteBook() {
        UpdateDelete ud = new UpdateDelete();
        ud.setVisible(true);
    }

    private void searchBook() {
        SearchBooks bc = new SearchBooks();
        bc.setVisible(true);
    }

    private void exit() {
        System.exit(0);
    }

    private void showInfo() {
        JOptionPane.showMessageDialog(null, "Library System Management\nDeveloped by Baha2rM98");
    }
}
