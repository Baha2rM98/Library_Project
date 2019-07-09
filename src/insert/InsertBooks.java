package insert;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBooks extends JFrame {

    private javax.swing.JTextField abtTF;
    private javax.swing.JTextField bookAuthorTF;
    private javax.swing.JTextField bookIdTF;
    private javax.swing.JTextField bookNameTF;
    private javax.swing.JTextField courseTF;
    private javax.swing.JTextField edTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField userNameTF;
    private javax.swing.JTextField phTF;
    private javax.swing.JTextField rollTF;
    private javax.swing.JTextField semTF;

    public InsertBooks() {
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
            java.util.logging.Logger.getLogger(InsertBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new InsertBooks().setVisible(true));
    }

    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        rollTF = new javax.swing.JTextField();
        userNameTF = new javax.swing.JTextField();
        semTF = new javax.swing.JTextField();
        phTF = new javax.swing.JTextField();
        bookNameTF = new javax.swing.JTextField();
        bookAuthorTF = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        JLabel jLabel10 = new JLabel();
        courseTF = new javax.swing.JTextField();
        JLabel jLabel11 = new JLabel();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel13 = new JLabel();
        bookIdTF = new javax.swing.JTextField();
        abtTF = new javax.swing.JTextField();
        edTF = new javax.swing.JTextField();
        JButton jButton2 = new JButton();
        JLabel jLabel9 = new JLabel();
        emailTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertion of Data");

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        jLabel1.setText("InsertBooks New Entries Here");

        jLabel3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel3.setText("Name *");

        jLabel4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel4.setText("Semester");

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel5.setText("Phone No. *");

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel6.setText("Book Title * ");

        jLabel7.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel7.setText("Book Author *");

        jLabel8.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel8.setText("Roll No. *");

        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton1.setText("Submit");
        jButton1.addActionListener(evt -> insert());

        jLabel10.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel10.setText("Course");

        jLabel11.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel11.setText("Book ID *");

        jLabel12.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel12.setText("About");

        jLabel13.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel13.setText("Edition *");

        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton2.setText("Cancel");
        jButton2.addActionListener(evt -> cancel());

        jLabel9.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel9.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rollTF, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(courseTF, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phTF, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(emailTF, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(semTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))))
                                .addGap(193, 193, 193)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bookNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                        .addComponent(bookIdTF)
                                        .addComponent(bookAuthorTF)
                                        .addComponent(abtTF)
                                        .addComponent(edTF))
                                .addContainerGap(98, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rollTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bookNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(userNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(courseTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(bookIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(abtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(semTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel12)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(emailTF)
                                                                                .addGap(1, 1, 1))))))
                                        .addComponent(bookAuthorTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(edTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
        );
        pack();
    }

    private void insert() {
        try {
            if (bookAuthorTF.getText().equals("") || bookIdTF.getText().equals("") || bookNameTF.getText().equals("") || edTF.getText().equals("") || userNameTF.getText().equals("") || phTF.getText().equals("") || rollTF.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in the blanks!");
            } else {
                String ClassName = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/libraryproject";
                String user = "root";
                Class.forName(ClassName).newInstance();
                Connection connection = DriverManager.getConnection(URL, user, null);
                Statement statement = connection.createStatement();
                String query = "insert into infotable (abt, bookAuthor, bookId, bookName, course, ed, email, userName, ph, roll, sem) values ('%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s') ";
                query = String.format(query, abtTF.getText(), bookAuthorTF.getText(), Integer.parseInt(bookIdTF.getText()), bookNameTF.getText(), courseTF.getText(), edTF.getText(), emailTF.getText(), userNameTF.getText(), phTF.getText(), rollTF.getText(), semTF.getText());
                statement.executeUpdate(query);
                statement.close();
                connection.close();
                System.out.println(query);
                JOptionPane.showMessageDialog(null, "New record has been saved successfully! \n You may view your profile and books by clicking on \n Update or Delete.");
                System.out.println("changes applied...");
                rollTF.setText("");
                userNameTF.setText("");
                courseTF.setText("");
                semTF.setText("");
                phTF.setText("");
                emailTF.setText("");
                bookIdTF.setText("");
                bookNameTF.setText("");
                abtTF.setText("");
                edTF.setText("");
                bookAuthorTF.setText("");
                rollTF.setText("");
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Process not completed. Error in connectivity to database");
        }
    }

    private void cancel() {
        super.dispose();
    }
}
