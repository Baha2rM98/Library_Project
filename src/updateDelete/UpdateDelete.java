package updateDelete;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class UpdateDelete extends JFrame {
    private Statement statement = null;
    private ResultSet rs = null;
    private javax.swing.JTable bkTBL;
    private javax.swing.JLabel bIdLB;
    private javax.swing.JTextField bIdTF;
    private javax.swing.JButton cnfBTN;
    private javax.swing.JTextField courseTF;
    private javax.swing.JButton delBtn;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField phTF;
    private javax.swing.JTextField rollTF;
    private javax.swing.JTextField semTF;
    private javax.swing.JButton updBtn;
    private String bId, roll;

    public UpdateDelete() {
        initComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new UpdateDelete().setVisible(true));
    }

    private void initComponents() {

        JLabel jLabel2 = new JLabel();
        rollTF = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        nameTF = new javax.swing.JTextField();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        semTF = new javax.swing.JTextField();
        phTF = new javax.swing.JTextField();
        updBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        JButton jButton3 = new JButton();
        JLabel jLabel8 = new JLabel();
        courseTF = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        JLabel jLabel1 = new JLabel();
        JButton jButton2 = new JButton();
        JLabel jLabel6 = new JLabel();
        emailTF = new javax.swing.JTextField();
        bIdLB = new javax.swing.JLabel();
        bIdTF = new javax.swing.JTextField();
        cnfBTN = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        bkTBL = new javax.swing.JTable();
        JLabel jLabel7 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update and Delete");

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        jLabel3.setText("Roll No.");

        nameTF.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        jLabel4.setText("Semester");

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        jLabel5.setText("Phone No.");

        semTF.setEnabled(false);
        phTF.setEnabled(false);

        updBtn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        updBtn.setText("Update Record");
        updBtn.setEnabled(false);
        updBtn.addActionListener(evt -> updateData());

        delBtn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        delBtn.setText("Delete");
        delBtn.setEnabled(false);
        delBtn.addActionListener(evt -> deleteBT());

        jButton3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton3.setText("Load Data");
        jButton3.addActionListener(evt -> loadData());

        jLabel8.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel8.setText("Course");

        courseTF.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton1.setText("Clear Screen");
        jButton1.addActionListener(evt -> cleanScreen());

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        jLabel1.setText("Enter roll number of the student whose data is going to be changed :");

        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton2.setText("Cancel");
        jButton2.addActionListener(evt -> cancel());

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel6.setText("Email");

        emailTF.setEnabled(false);

        bIdLB.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        bIdLB.setText("Enter BookID to delete this record");
        bIdLB.setEnabled(false);

        bIdTF.setEnabled(false);

        cnfBTN.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        cnfBTN.setText("OK");
        cnfBTN.setEnabled(false);
        cnfBTN.addActionListener(evt -> deleteData());

        bkTBL.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"Book ID", "Book Name"}) {
            boolean[] canEdit = new boolean[]{false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(bkTBL);

        jLabel7.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel7.setText("Your Books");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(bIdLB, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(bIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(56, 56, 56)
                                                                .addComponent(cnfBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(127, 127, 127)
                                                .addComponent(updBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel7))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(145, 145, 145)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                                        .addComponent(jLabel8))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phTF, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(rollTF, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(105, 105, 105)
                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(semTF, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(courseTF, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(semTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rollTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(phTF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(courseTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(updBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bIdLB, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cnfBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
    }

    private void loadData() {
        try {
            if (rollTF.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in the blank!");
            } else {
                String ClassName = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/libraryproject";
                String user = "root";
                Class.forName(ClassName).newInstance();
                Connection connection = DriverManager.getConnection(URL, user, null);
                statement = connection.createStatement();
                DefaultTableModel model = (DefaultTableModel) bkTBL.getModel();
                String query = "Select * from infotable where roll = " + rollTF.getText() + " ;";
                rs = statement.executeQuery(query);
                if (rs.next()) {
                    String sName = rs.getString("userName");
                    String course = rs.getString("course");
                    String sem = rs.getString("sem");
                    String phone = rs.getString("ph");
                    bId = rs.getString("bookId");
                    roll = rs.getString("roll");
                    String bName = rs.getString("bookName");
                    String email = rs.getString("email");
                    model.addRow(new Object[]{bId, bName});
                    rs.close();
                    statement.close();
                    connection.close();
                    nameTF.setText(sName);
                    semTF.setText(sem);
                    courseTF.setText(course);
                    emailTF.setText(email);
                    phTF.setText(phone);
                    updBtn.setEnabled(true);
                    delBtn.setEnabled(true);
                    nameTF.setEnabled(true);
                    semTF.setEnabled(true);
                    phTF.setEnabled(true);
                    emailTF.setEnabled(true);
                    courseTF.setEnabled(true);
                } else {
                    statement.close();
                    connection.close();
                    nameTF.setText("");
                    courseTF.setText("");
                    semTF.setText("");
                    phTF.setText("");
                    emailTF.setText("");
                    JOptionPane.showMessageDialog(null, "No such Record found. May be this roll number has not been registered yet");
                }
                System.out.println(query);
            }
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Process not completed. Error in connectivity to database");
        }
    }

    private void updateData() {
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure, you want to update this details?");
        if (ans == JOptionPane.YES_OPTION) {
            try {
                String ClassName = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/libraryproject";
                String user = "root";
                Class.forName(ClassName).newInstance();
                Connection connection = DriverManager.getConnection(URL, user, null);
                statement = connection.createStatement();
                String query = "update infotable set userName = '" + nameTF.getText() + "', sem = '" + semTF.getText() + "', ph = '" + phTF.getText() + "', course = '" + courseTF.getText() + "', email = '" + emailTF.getText() + "' where roll = '" + rollTF.getText() + "' ;";
                String query_2 = "select * from infotable where roll = '" + rollTF.getText() + "' ;";
                if (!(roll.equals(rollTF.getText())))
                    JOptionPane.showMessageDialog(null, "You can't modify roll value!");
                else {
                    rs = statement.executeQuery(query_2);
                    if (rs.next()) {
                        statement.executeUpdate(query);
                        statement.close();
                        connection.close();
                        JOptionPane.showMessageDialog(null, "Record Successfully Updated!");
                    }
                }
                System.out.println(query + "\n" + query_2);
                System.out.println("changes applied...");
            } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Process not completed. Error in connectivity to database");
            }
        }
        nameTF.setText("");
        semTF.setText("");
        phTF.setText("");
        courseTF.setText("");
        emailTF.setText("");
        updBtn.setEnabled(false);
        delBtn.setEnabled(false);
    }

    private void deleteData() {
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure, you want to delete this entry?");
        if (ans == JOptionPane.YES_OPTION) {
            try {
                String ClassName = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/libraryproject";
                String user = "root";
                Class.forName(ClassName).newInstance();
                Connection connection = DriverManager.getConnection(URL, user, null);
                statement = connection.createStatement();
                String query = "delete from infotable where roll = '" + rollTF.getText() + "' and bookId = " + bIdTF.getText() + ";";
                String query_2 = "select * from infotable where roll = '" + rollTF.getText() + "' ;";
                if (!(bId.equals(bIdTF.getText()))) {
                    JOptionPane.showMessageDialog(null, "You entered wrong bookID! Try again");
                } else {
                    rs = statement.executeQuery(query_2);
                    if (rs.next()) {
                        statement.executeUpdate(query);
                        statement.close();
                        connection.close();
                        JOptionPane.showMessageDialog(null, "Entry deleted successfully.");
                    }
                    System.out.println(query + "\n" + query_2);
                    System.out.println("changes applied...");
                }
            } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Process not completed. Error in connectivity to database");
            }
            nameTF.setText("");
            semTF.setText("");
            phTF.setText("");
            courseTF.setText("");
            emailTF.setText("");
            updBtn.setEnabled(false);
            delBtn.setEnabled(false);
            bIdLB.setEnabled(false);
            bIdTF.setEnabled(false);
            cnfBTN.setEnabled(false);
        }
    }

    private void deleteBT() {
        bIdLB.setEnabled(true);
        bIdTF.setEnabled(true);
        cnfBTN.setEnabled(true);
        delBtn.setEnabled(false);
    }

    private void cleanScreen() {
        rollTF.setText("");
        nameTF.setText("");
        courseTF.setText("");
        semTF.setText("");
        phTF.setText("");
        emailTF.setText("");
        updBtn.setEnabled(false);
        delBtn.setEnabled(false);
        nameTF.setEnabled(false);
        semTF.setEnabled(false);
        phTF.setEnabled(false);
        emailTF.setEnabled(false);
        courseTF.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) bkTBL.getModel();
        int rows = model.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                model.removeRow(0);
            }
        }
    }

    private void cancel() {
        super.dispose();
    }
}