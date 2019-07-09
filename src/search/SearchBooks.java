package search;

import insert.InsertBooks;
import updateDelete.UpdateDelete;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class SearchBooks extends JFrame {

    private javax.swing.JTextField authorNameTF;
    private javax.swing.JTextField bookNameTF;
    private javax.swing.JButton clrBTN;
    private javax.swing.JTable dataBase;
    private boolean flag = false;

    public SearchBooks() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new SearchBooks().setVisible(true));
    }

    private void initComponents() {

        bookNameTF = new javax.swing.JTextField();
        JScrollPane jScrollPane1 = new JScrollPane();
        dataBase = new javax.swing.JTable();
        JLabel jLabel1 = new JLabel();
        JButton jButton1 = new JButton();
        clrBTN = new javax.swing.JButton();
        JLabel jLabel2 = new JLabel();
        authorNameTF = new javax.swing.JTextField();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Books");
        dataBase.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{" Roll No.", "Name ", "Course", "Semester  ", "Phone No", "Book ID", "Book Title", "About", "Edition", "Author", "E-mail "}) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(dataBase);
        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel1.setText("Book  Title");
        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton1.setText("Search");
        jButton1.addActionListener(evt -> search());

        clrBTN.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        clrBTN.setText("Clear");
        clrBTN.addActionListener(evt -> cleanTable());

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel2.setText("Author Name");

        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton2.setText("Add Record");
        jButton2.addActionListener(evt -> addBook());

        jButton3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton3.setText("Update or Delete Record");
        jButton3.addActionListener(evt -> updateAndDeleteBook());

        jButton4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton4.setText("Close");
        jButton4.addActionListener(evt -> close());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(bookNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(53, 53, 53)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(56, 56, 56)
                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                                                .addComponent(jButton3))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(authorNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(175, 607, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clrBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bookNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(authorNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                                                .addGap(2, 2, 2)))
                                                .addGap(32, 32, 32))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(clrBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43))
        );
        pack();
    }

    private void search() {
        clrBTN.doClick();
        DefaultTableModel model = (DefaultTableModel) dataBase.getModel();
        try {
            String ClassName = "com.mysql.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/libraryproject";
            String user = "root";
            Class.forName(ClassName).newInstance();
            Connection connection = DriverManager.getConnection(URL, user, null);
            Statement statement = connection.createStatement();
            String bookName = bookNameTF.getText();
            String authorName = authorNameTF.getText();
            if (bookName.equals("") && authorName.equals(""))
                JOptionPane.showMessageDialog(null, "Please enter book name or author name!");
            else {
                String query = "select * from infotable " + "where bookName like '%" + bookName + "%' and bookAuthor like '%" + authorName + "%';";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String roll = rs.getString("roll");
                    String uName = rs.getString("userName");
                    String course = rs.getString("course");
                    String sem = rs.getString("sem");
                    String phone = rs.getString("ph");
                    String bId = rs.getString("bookId");
                    String bName = rs.getString("bookName");
                    String abt = rs.getString("abt");
                    String ed = rs.getString("ed");
                    String bAuthor = rs.getString("bookAuthor");
                    String email = rs.getString("email");
                    model.addRow(new Object[]{roll, uName, course, sem, phone, bId, bName, abt, ed, bAuthor, email});
                    flag = true;
                    System.out.println(query);
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "No such Record found. May be this roll number has not been registered yet.");
                    rs.close();
                }
                flag = false;
                System.out.println(query);
            }
            statement.close();
            connection.close();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Process not completed. Error in connectivity to database");
        }
    }

    private void cleanTable() {
        DefaultTableModel model = (DefaultTableModel) dataBase.getModel();
        int rows = model.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                model.removeRow(0);
            }
        }


    }

    private void addBook() {
        InsertBooks insertBooks = new InsertBooks();
        insertBooks.setVisible(true);
    }

    private void updateAndDeleteBook() {
        UpdateDelete ud = new UpdateDelete();
        ud.setVisible(true);
    }

    private void close() {
        super.dispose();
    }

}
