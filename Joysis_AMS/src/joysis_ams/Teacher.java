/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package joysis_ams;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JAYCEE
 */
public class Teacher extends javax.swing.JFrame {

    Connection conn = javaconnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
    /**
     * UI table
     */
    
    /**
     * Creates new form Teacher
     */
    public Teacher() {
        initComponents();
        fillTable();
        fillTable2();
        fillGender();
        fillSection();
        fillID();
        fillName();
        fillStatus();
        fillDate();
        fillID2();
        
//        setBackground(new Color(0,0,0,0));
//        
//        teacherTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//        teacherTable.getTableHeader().setOpaque(false);
//        teacherTable.getTableHeader().setBackground(new Color(32, 136, 203));
//        teacherTable.getTableHeader().setForeground(Color.white);
//        teacherTable.setRowHeight(25);
        
    }
    public void fillTable2(){
        try {
            pst = conn.prepareStatement("SELECT * FROM student");
            rs = pst.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel)studentTablee.getModel();
            tbl.setRowCount(0);
            while(rs.next()) {
                String id = String.valueOf(rs.getInt("student_id"));
                String username = rs.getString("username");  
                String password = rs.getString("password"); 
                String fname = rs.getString("firstname"); 
                String mname = rs.getString("middlename"); 
                String lname = rs.getString("lastname");
                String section = rs.getString("section");
                String gender = rs.getString("gender");

                String data[] = {id, username, password, fname, mname, lname, section, gender};
                tbl.addRow(data);
            }
        } catch (Exception e) {
        }
    }
    public void fillTable(){
        try {
            pst = conn.prepareStatement("SELECT * FROM attendance");
            rs = pst.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel)teacherTable.getModel();
            tbl.setRowCount(0);
            while(rs.next()) {
                String id = String.valueOf(rs.getInt("student_id"));
                String name = rs.getString("name");  
                String status = rs.getString("status");
                String date = rs.getString("date");
                String remarks = rs.getString("remarks");
                
                String data[] = {id, name, status, date, remarks};
                tbl.addRow(data);
            }
        } catch (Exception e) {
        }
    }
    
    private void fillID(){
        try {
            String sql = "SELECT DISTINCT student_id from attendance";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("student_id");
                idCB.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     private void fillGender(){
        try {
            String sql = "SELECT DISTINCT gender from student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("gender");
                sortGender.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
       private void fillSection(){
        try {
            String sql = "SELECT DISTINCT section from student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("section");
                sortSection.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fillName(){
        try {
            String sql = "SELECT DISTINCT name from attendance";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                nameCB.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fillStatus(){
        try {
            String sql = "SELECT DISTINCT status from attendance";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("status");
                statusCB.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fillDate(){
        try {
            String sql = "SELECT DISTINCT date from attendance";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("date");
                dateCB.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fillID2(){
        try {
            String sql = "SELECT * from student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("student_id");
                EidCB.addItem(name);
                RidCB.addItem(name);
                RCidCB.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ResetTF() {
        RusernameTF.setText("");
        RpasswordTF.setText("");
        RsectionTF.setText("");
        RgenderTF.setText("");
        RfirstnameTF.setText("");
        RmiddlenameTF.setText("");
        RlastnameTF.setText("");
        
        EusernameTF.setText("");
        EpasswordTF.setText("");
        EsectionTF.setText("");
        EgenderTF.setText("");
        EfirstnameTF.setText("");
        EmiddlenameTF.setText("");
        ElastnameTF.setText("");
        
        AusernameTF.setText("");
        ApasswordTF.setText("");
        AsectionTF.setText("");
        AgenderTF.setText("");
        AfirstnameTF.setText("");
        AmiddlenameTF.setText("");
        AlastnameTF.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderTF1 = new javax.swing.JTextField();
        clearFilter = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        AusernameTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ApasswordTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AfirstnameTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        AmiddlenameTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        AlastnameTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        AsectionTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        AgenderTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        EusernameTF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        EfirstnameTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EmiddlenameTF = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ElastnameTF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        EpasswordTF = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        EsectionTF = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        EidCB = new javax.swing.JComboBox<>();
        EgenderTF = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        RusernameTF = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        RfirstnameTF = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        RmiddlenameTF = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        RlastnameTF = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        RpasswordTF = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        RsectionTF = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        RidCB = new javax.swing.JComboBox<>();
        RgenderTF = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        RCidCB = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        RCfullnameTF = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        RCremarksTF = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        RCaddBtn = new javax.swing.JButton();
        RCdate = new com.toedter.calendar.JDateChooser();
        RCstatusTF = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTablee = new javax.swing.JTable();
        sortSection = new javax.swing.JComboBox<>();
        sortGender = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        idCB = new javax.swing.JComboBox<>();
        nameCB = new javax.swing.JComboBox<>();
        statusCB = new javax.swing.JComboBox<>();
        dateCB = new javax.swing.JComboBox<>();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        genderTF1.setText("Gender");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(790, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clearFilter.setText("Clear Filter");
        clearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterActionPerformed(evt);
            }
        });
        getContentPane().add(clearFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 90, 30));

        jPanel1.setBackground(new java.awt.Color(183, 219, 251));

        jLabel6.setText("Username");

        ApasswordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApasswordTFActionPerformed(evt);
            }
        });

        jLabel7.setText("Password");

        AfirstnameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfirstnameTFActionPerformed(evt);
            }
        });

        jLabel8.setText("First Name");

        AmiddlenameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmiddlenameTFActionPerformed(evt);
            }
        });

        jLabel9.setText("Middle Name");

        jLabel10.setText("Last Name");

        jLabel12.setText("Section");

        jLabel13.setText("Gender");

        addBtn.setText("Add");
        addBtn.setPreferredSize(new java.awt.Dimension(67, 23));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AfirstnameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AusernameTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ApasswordTF, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AmiddlenameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AlastnameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AsectionTF, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AgenderTF, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AusernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AsectionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgenderTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AfirstnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AmiddlenameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AlastnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add Student", jPanel1);

        jPanel4.setBackground(new java.awt.Color(183, 219, 251));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("Student ID");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 19));
        jPanel4.add(EusernameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 138, 29));

        jLabel15.setText("Username");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 138, 19));
        jPanel4.add(EfirstnameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 138, 29));

        jLabel16.setText("First Name");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 138, 19));
        jPanel4.add(EmiddlenameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 138, 29));

        jLabel17.setText("Middle Name");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 138, 19));
        jPanel4.add(ElastnameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 138, 29));

        jLabel18.setText("Last Name");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 138, 19));
        jPanel4.add(EpasswordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 138, 29));

        jLabel19.setText("Password");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 138, 19));
        jPanel4.add(EsectionTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 138, 29));

        jLabel20.setText("Section");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 138, 19));

        EidCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        EidCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EidCBActionPerformed(evt);
            }
        });
        jPanel4.add(EidCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 30));
        jPanel4.add(EgenderTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 138, 29));

        jLabel28.setText("Gender");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 138, 19));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel4.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 80, 30));

        jTabbedPane1.addTab("Edit Student", jPanel4);

        jPanel5.setBackground(new java.awt.Color(183, 219, 251));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Student ID");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 19));

        RusernameTF.setEditable(false);
        jPanel5.add(RusernameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 138, 29));

        jLabel22.setText("Username");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 138, 19));

        RfirstnameTF.setEditable(false);
        jPanel5.add(RfirstnameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 138, 29));

        jLabel23.setText("First Name");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 138, 19));

        RmiddlenameTF.setEditable(false);
        jPanel5.add(RmiddlenameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 138, 29));

        jLabel24.setText("Middle Name");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 138, 19));

        RlastnameTF.setEditable(false);
        jPanel5.add(RlastnameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 138, 29));

        jLabel25.setText("Last Name");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 138, 20));

        RpasswordTF.setEditable(false);
        jPanel5.add(RpasswordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 138, 29));

        jLabel26.setText("Password");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 138, 19));

        RsectionTF.setEditable(false);
        jPanel5.add(RsectionTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 138, 29));

        jLabel27.setText("Section");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 138, 19));

        RidCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        RidCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RidCBActionPerformed(evt);
            }
        });
        jPanel5.add(RidCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 30));

        RgenderTF.setEditable(false);
        jPanel5.add(RgenderTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 138, 29));

        jLabel29.setText("Gender");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 138, 19));

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        jPanel5.add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 80, 30));

        jTabbedPane1.addTab("Remove Student", jPanel5);

        jPanel2.setBackground(new java.awt.Color(183, 219, 251));

        RCidCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        RCidCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCidCBActionPerformed(evt);
            }
        });

        jLabel32.setText("Student ID");

        RCfullnameTF.setEditable(false);

        jLabel33.setText("Date");

        jLabel34.setText("Status");

        jLabel35.setText("Fullname");

        jLabel36.setText("Remarks");

        RCaddBtn.setText("Add");
        RCaddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCaddBtnActionPerformed(evt);
            }
        });

        RCdate.setDateFormatString("yyyy-MM-dd");
        RCdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RCdateMouseClicked(evt);
            }
        });

        RCstatusTF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Present", "Absent", "Late" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RCidCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RCfullnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RCstatusTF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RCdate, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RCremarksTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RCaddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RCfullnameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(RCdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RCstatusTF)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RCidCB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RCaddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RCremarksTF, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Roll Call", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 730, 160));

        studentTablee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Username", "Password", "Firstname", "Middlename", "Lastname", "Section", "Gender"
            }
        ));
        jScrollPane1.setViewportView(studentTablee);

        sortSection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Section" }));
        sortSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortSectionActionPerformed(evt);
            }
        });

        sortGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender" }));
        sortGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortGenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(sortSection, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sortGender, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Student", jPanel6);

        teacherTable.setBackground(new java.awt.Color(240, 240, 240));
        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Status", "Date", "Remarks"
            }
        ));
        teacherTable.setFocusable(false);
        teacherTable.setGridColor(new java.awt.Color(183, 219, 251));
        jScrollPane2.setViewportView(teacherTable);

        idCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student ID" }));
        idCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCBActionPerformed(evt);
            }
        });

        nameCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student Name" }));
        nameCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCBActionPerformed(evt);
            }
        });

        statusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status" }));
        statusCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusCBActionPerformed(evt);
            }
        });

        dateCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date" }));
        dateCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(idCB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateCB, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Attendance", jPanel3);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 730, 460));

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(790, 720));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFilterActionPerformed
        // TODO add your handling code here:
//        try {
//            pst = conn.prepareStatement("SELECT * FROM attendance");
//            rs = pst.executeQuery();
//            
//            if(rs.next()) {
//                teacherTable.setModel(DbUtils.resultSetToTableModel(rs));
//            }
//        } catch (Exception e) {
//        }
       
        sortGender.setSelectedIndex(0);
        sortSection.setSelectedIndex(0);
        idCB.setSelectedIndex(0);
        nameCB.setSelectedIndex(0);
        statusCB.setSelectedIndex(0);
        dateCB.setSelectedIndex(0);
        fillTable();
        fillTable2();
    }//GEN-LAST:event_clearFilterActionPerformed

    private void idCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCBActionPerformed
        // TODO add your handling code here:
        try {
            String s = idCB.getSelectedItem().toString();
            pst = conn.prepareStatement("SELECT * FROM attendance WHERE student_id = ?");  
            pst.setString(1, s);
            rs2 = pst.executeQuery();
            teacherTable.setModel(DbUtils.resultSetToTableModel(rs2)); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_idCBActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        try {
            String username = AusernameTF.getText();
            
            pst = conn.prepareStatement("SELECT * FROM student WHERE username = ?");
            pst.setString(1,username);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Username Already Taken!");
            } else {
                String password = ApasswordTF.getText();
                String firstname = AfirstnameTF.getText();
                String middlename = AmiddlenameTF.getText();
                String lastname = AlastnameTF.getText();
                String section = AsectionTF.getText();
                String gender = AgenderTF.getText();

                pst = conn.prepareStatement("INSERT INTO student (username,password,firstname,middlename,lastname,section,gender) VALUES (?,?,?,?,?,?,?)");
                pst.setString(1,username);
                pst.setString(2,password);
                pst.setString(3,firstname);
                pst.setString(4,middlename);
                pst.setString(5,lastname);
                pst.setString(6,section);
                pst.setString(7,gender);
                int result = pst.executeUpdate();
                ResetTF();

                if (result==1) {
                    JOptionPane.showMessageDialog(this, "Student "+username+" Added SUCCESSFULLY!");
                    fillID2();
                    fillTable2();
                } else {
                    JOptionPane.showMessageDialog(this, "Adding Student "+username+" FAILED!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void nameCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameCBActionPerformed
        // TODO add your handling code here:
        try {
            String s = nameCB.getSelectedItem().toString();
            pst = conn.prepareStatement("SELECT * FROM attendance WHERE name = ?");  
            pst.setString(1, s);
            rs2 = pst.executeQuery();
            teacherTable.setModel(DbUtils.resultSetToTableModel(rs2)); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_nameCBActionPerformed

    private void statusCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusCBActionPerformed
        // TODO add your handling code here:
        try {
            String s = statusCB.getSelectedItem().toString();
            pst = conn.prepareStatement("SELECT * FROM attendance WHERE status = ?");  
            pst.setString(1, s);
            rs2 = pst.executeQuery();
            teacherTable.setModel(DbUtils.resultSetToTableModel(rs2)); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_statusCBActionPerformed

    private void dateCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateCBActionPerformed
        // TODO add your handling code here:
        try {
            String s = dateCB.getSelectedItem().toString();
            pst = conn.prepareStatement("SELECT * FROM attendance WHERE date = ?");  
            pst.setString(1, s);
            rs2 = pst.executeQuery();
            teacherTable.setModel(DbUtils.resultSetToTableModel(rs2)); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_dateCBActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        try {
            String username = EusernameTF.getText();
            String password = EpasswordTF.getText();
            String firstname = EfirstnameTF.getText();
            String middlename = EmiddlenameTF.getText();
            String lastname = ElastnameTF.getText();
            String section = EsectionTF.getText();
            String gender = EgenderTF.getText();
            String id = EidCB.getSelectedItem().toString();
            
            pst = conn.prepareStatement("UPDATE `student` SET `username`=?,`password`=?,`firstname`=?,`middlename`=?,`lastname`=?,`section`=?,`gender`=? WHERE student_id = ?");
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setString(3,firstname);
            pst.setString(4,middlename);
            pst.setString(5,lastname);
            pst.setString(6,section);
            pst.setString(7,gender);
            pst.setString(8,id);
            int result = pst.executeUpdate();
            ResetTF();
            
            if (result==1) {
                JOptionPane.showMessageDialog(this, username+"'s Information has been Updated!");
                fillID2();
                fillTable2();
            } else {
                JOptionPane.showMessageDialog(this, "Updating "+username+"'s Information Failed!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void EidCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EidCBActionPerformed
        // TODO add your handling code here:
        try {
            pst = conn.prepareStatement("SELECT student_id FROM student");
            rs = pst.executeQuery();
            
            if (rs.next()) {
                String id = EidCB.getSelectedItem().toString();

                pst = conn.prepareStatement("SELECT * FROM student WHERE student_id = ?");
                pst.setString(1, id);
                rs = pst.executeQuery();

                if (rs.next()==true) {
                    EusernameTF.setText(rs.getString("username"));
                    EpasswordTF.setText(rs.getString("password"));
                    EfirstnameTF.setText(rs.getString("firstname"));
                    EmiddlenameTF.setText(rs.getString("middlename"));
                    ElastnameTF.setText(rs.getString("lastname"));
                    EsectionTF.setText(rs.getString("section"));
                    EgenderTF.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(this, "No Record Found!");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_EidCBActionPerformed

    private void RidCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RidCBActionPerformed
        // TODO add your handling code here:
        try {
            pst = conn.prepareStatement("SELECT student_id FROM student");
            rs = pst.executeQuery();
            
            if (rs.next()) {
                String id = RidCB.getSelectedItem().toString();
            
                pst = conn.prepareStatement("SELECT * FROM student WHERE student_id = ?");
                pst.setString(1, id);
                rs = pst.executeQuery();

                if (rs.next()==true) {
                    RusernameTF.setText(rs.getString("username"));
                    RpasswordTF.setText(rs.getString("password"));
                    RfirstnameTF.setText(rs.getString("firstname"));
                    RmiddlenameTF.setText(rs.getString("middlename"));
                    RlastnameTF.setText(rs.getString("lastname"));
                    RsectionTF.setText(rs.getString("section"));
                    RgenderTF.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(this, "No Record Found!");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_RidCBActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        try {
            String username = RusernameTF.getText();
            String id = RidCB.getSelectedItem().toString();
            
            pst = conn.prepareStatement("DELETE FROM `student` WHERE student_id = ?");
            pst.setString(1,id);
            int result = pst.executeUpdate();
            ResetTF();
                    
            if (result==1) {
                JOptionPane.showMessageDialog(this, username+"'s Account has been Deleted!");
                fillID2();
                fillTable2();
            } else {
                JOptionPane.showMessageDialog(this, "Deletion of "+username+"'s Account has Failed!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void ApasswordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApasswordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApasswordTFActionPerformed

    private void AfirstnameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfirstnameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfirstnameTFActionPerformed

    private void AmiddlenameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmiddlenameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmiddlenameTFActionPerformed

    private void RCdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RCdateMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_RCdateMouseClicked

    private void RCidCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCidCBActionPerformed
        // TODO add your handling code here:
        try {
            pst = conn.prepareStatement("SELECT student_id FROM student");
            rs = pst.executeQuery();
            
            if (rs.next()) {
                String id = RCidCB.getSelectedItem().toString();

                pst = conn.prepareStatement("SELECT * FROM student WHERE student_id = ?");
                pst.setString(1, id);
                rs = pst.executeQuery();

                if (rs.next()==true) {
                    String firstname = rs.getString("firstname");
                    String middlename = rs.getString("middlename");
                    String lastname = rs.getString("lastname");
                    RCfullnameTF.setText(firstname+" "+middlename+" "+lastname);
                } else {
                    JOptionPane.showMessageDialog(this, "No Record Found!");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_RCidCBActionPerformed

    private void RCaddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCaddBtnActionPerformed
        // TODO add your handling code here:
        try {
            String fullname = RCfullnameTF.getText();
            
            pst = conn.prepareStatement("SELECT * FROM student WHERE username = ?");
            pst.setString(1,fullname);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Username Already Taken!");
            } else {
                String id = RCidCB.getSelectedItem().toString();
                String status = RCstatusTF.getSelectedItem().toString();
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(RCdate.getDate());
                
                String remarks = RCremarksTF.getText();

                pst = conn.prepareStatement("INSERT INTO attendance (student_id,name,status,date,remarks) VALUES (?,?,?,?,?)");
                pst.setString(1,id);
                pst.setString(2,fullname);
                pst.setString(3,status);
                pst.setString(4,date);
                pst.setString(5,remarks);
                int result = pst.executeUpdate();
                ResetTF();

                if (result==1) {
                    JOptionPane.showMessageDialog(this, "Attendance of "+fullname+" SUCCESSFULLY Added!");
                    fillTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Adding Student "+fullname+"'s Attendance FAILED!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_RCaddBtnActionPerformed

    private void sortSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortSectionActionPerformed
        // TODO add your handling code here:
           try {
            String s = sortSection.getSelectedItem().toString();
            pst = conn.prepareStatement("SELECT * FROM student WHERE section = ?");  
            pst.setString(1, s);
            rs2 = pst.executeQuery();
            studentTablee.setModel(DbUtils.resultSetToTableModel(rs2)); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_sortSectionActionPerformed

    private void sortGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortGenderActionPerformed
        // TODO add your handling code here:
        try {
            String s = sortGender.getSelectedItem().toString();
            pst = conn.prepareStatement("SELECT * FROM student WHERE gender = ?");  
            pst.setString(1, s);
            rs2 = pst.executeQuery();
            studentTablee.setModel(DbUtils.resultSetToTableModel(rs2)); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_sortGenderActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Role rl = new Role();
        rl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AfirstnameTF;
    private javax.swing.JTextField AgenderTF;
    private javax.swing.JTextField AlastnameTF;
    private javax.swing.JTextField AmiddlenameTF;
    private javax.swing.JTextField ApasswordTF;
    private javax.swing.JTextField AsectionTF;
    private javax.swing.JTextField AusernameTF;
    private javax.swing.JTextField EfirstnameTF;
    private javax.swing.JTextField EgenderTF;
    private javax.swing.JComboBox<String> EidCB;
    private javax.swing.JTextField ElastnameTF;
    private javax.swing.JTextField EmiddlenameTF;
    private javax.swing.JTextField EpasswordTF;
    private javax.swing.JTextField EsectionTF;
    private javax.swing.JTextField EusernameTF;
    private javax.swing.JButton RCaddBtn;
    private com.toedter.calendar.JDateChooser RCdate;
    private javax.swing.JTextField RCfullnameTF;
    private javax.swing.JComboBox<String> RCidCB;
    private javax.swing.JTextField RCremarksTF;
    private javax.swing.JComboBox<String> RCstatusTF;
    private javax.swing.JTextField RfirstnameTF;
    private javax.swing.JTextField RgenderTF;
    private javax.swing.JComboBox<String> RidCB;
    private javax.swing.JTextField RlastnameTF;
    private javax.swing.JTextField RmiddlenameTF;
    private javax.swing.JTextField RpasswordTF;
    private javax.swing.JTextField RsectionTF;
    private javax.swing.JTextField RusernameTF;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearFilter;
    private javax.swing.JComboBox<String> dateCB;
    private javax.swing.JTextField genderTF1;
    private javax.swing.JComboBox<String> idCB;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> nameCB;
    private javax.swing.JButton removeBtn;
    private javax.swing.JComboBox<String> sortGender;
    private javax.swing.JComboBox<String> sortSection;
    private javax.swing.JComboBox<String> statusCB;
    private javax.swing.JTable studentTablee;
    private javax.swing.JTable teacherTable;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
