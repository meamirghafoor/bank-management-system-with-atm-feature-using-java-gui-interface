

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.SplittableRandom;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
/**
 *
 * @author Amir Ghafoor
 */
public class atm_portal extends JFrame {
    public atm_portal() {
        initComponents();
        title_icon();
        Thread t = new Thread(new Runnable(){
         public void run(){
        icon();
        UIManager.put("ToolTip.background", new Color(204,204,204));
        UIManager.put("OptionPane.background", new Color(204,204,204));
        UIManager.put("Panel.background", new Color(204,204,204));
        UIManager.put("Button.background", new Color(142,142,142));
        UIManager.put("Button.foreground", Color.white);
        pass1.setEchoChar((char)0);
        newpass1.setEchoChar((char)0);
        newpass2.setEchoChar((char)0);
        atm.setCaretPosition(0);
            }
        });
        t.start();
    }
    
    atm_account_database db=new atm_account_database();
    database_conection conection=new database_conection();
    email em=new email();
    final void icon(){
        URL path30=getClass().getResource("/atm_project/see.png");
        ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        lb2.setIcon(photo30);
        lb10.setIcon(photo30);
        lb11.setIcon(photo30);
        URL path09 = getClass().getResource("/atm_project/nta.jpg");
        ImageIcon phot09 = new ImageIcon(new ImageIcon(path09).getImage().getScaledInstance(main.getWidth(), main.getHeight(), java.awt.Image.SCALE_SMOOTH));
        main.setIcon(phot09);
        URL path1=getClass().getResource("/atm_project/bt.png");
        ImageIcon photo1=new ImageIcon(new ImageIcon(path1).getImage().getScaledInstance(b10.getWidth(),b10.getHeight(),java.awt.Image.SCALE_SMOOTH));
        URL path=getClass().getResource("/atm_project/btn.png");
        ImageIcon photo=new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(b1.getWidth(),b1.getHeight(),java.awt.Image.SCALE_SMOOTH));
        b10.setIcon(photo);
        b11.setIcon(photo);
        b12.setIcon(photo);
        bt4.setIcon(photo1);
        bt5.setIcon(photo1);
        bt6.setIcon(photo1);
        bt13.setIcon(photo1);
        bt14.setIcon(photo1);
        bt15.setIcon(photo1);
        b16.setIcon(photo);
        b17.setIcon(photo);
        b18.setIcon(photo);
        bt19.setIcon(photo1);
        bt20.setIcon(photo1);
        bt21.setIcon(photo1);
        b19.setIcon(photo);
        b20.setIcon(photo);
        b21.setIcon(photo);
        bt25.setIcon(photo1);
        bt26.setIcon(photo1);
        bt27.setIcon(photo1);
        b13.setIcon(photo);
        b14.setIcon(photo);
        b15.setIcon(photo);
        bt31.setIcon(photo1);
        bt32.setIcon(photo1);
        bt33.setIcon(photo1);
        b22.setIcon(photo);
        b23.setIcon(photo);
        b24.setIcon(photo);
        bt37.setIcon(photo1);
        bt38.setIcon(photo1);
        bt39.setIcon(photo1);
        b25.setIcon(photo);
        b26.setIcon(photo);
        b27.setIcon(photo);
        bt43.setIcon(photo1);
        bt44.setIcon(photo1);
        bt45.setIcon(photo1);
        b28.setIcon(photo);
        b29.setIcon(photo);
        b30.setIcon(photo);
        bt49.setIcon(photo1);
        bt50.setIcon(photo1);
        bt51.setIcon(photo1);
        b31.setIcon(photo);
        b32.setIcon(photo);
        b33.setIcon(photo);
        bt55.setIcon(photo1);
        bt56.setIcon(photo1);
        bt57.setIcon(photo1);
        b1.setIcon(photo);
        b2.setIcon(photo);
        b3.setIcon(photo);
        bt61.setIcon(photo1);
        bt62.setIcon(photo1);
        bt63.setIcon(photo1);
        b4.setIcon(photo);
        b5.setIcon(photo);
        b6.setIcon(photo);
        bt67.setIcon(photo1);
        bt68.setIcon(photo1);
        bt69.setIcon(photo1);
        b7.setIcon(photo);
        b8.setIcon(photo);
        b9.setIcon(photo);
        b35.setIcon(photo);
        b34.setIcon(photo);
        b36.setIcon(photo);
        bt34.setIcon(photo);
        bt35.setIcon(photo);
        bt36.setIcon(photo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        main_panel = new javax.swing.JPanel();
        keypad = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        lb1 = new ronds(30,60);
        lb01 = new javax.swing.JLabel();
        jPanel15 = new ronds(30,60);
        lb0 = new javax.swing.JLabel();
        jPanel14 = new ronds(30,60);
        lb00 = new javax.swing.JLabel();
        jPanel8 = new ronds(30,60);
        lb3 = new javax.swing.JLabel();
        pn7 = new ronds(30,60);
        lb7 = new javax.swing.JLabel();
        jPanel5 = new ronds(30,60);
        lb8 = new javax.swing.JLabel();
        jPanel6 = new ronds(30,60);
        lb9 = new javax.swing.JLabel();
        jPanel7 = new ronds(30,60);
        jLabel1 = new javax.swing.JLabel();
        jPanel17 = new ronds(30,60);
        lb02 = new javax.swing.JLabel();
        jPanel12 = new ronds(30,60);
        lb6 = new javax.swing.JLabel();
        jPanel11 = new ronds(30,60);
        lb5 = new javax.swing.JLabel();
        jPanel9 = new ronds(30,60);
        lb4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        screen = new javax.swing.JPanel();
        atm_num = new javax.swing.JPanel();
        er2 = new javax.swing.JLabel();
        atm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        p21 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        p22 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        bt55 = new javax.swing.JLabel();
        bt56 = new javax.swing.JLabel();
        bt57 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        b1 = new javax.swing.JLabel();
        b2 = new javax.swing.JLabel();
        b3 = new javax.swing.JLabel();
        pincode = new javax.swing.JPanel();
        err1 = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        lb2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        p23 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        p24 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        bt61 = new javax.swing.JLabel();
        bt62 = new javax.swing.JLabel();
        bt63 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        b4 = new javax.swing.JLabel();
        b5 = new javax.swing.JLabel();
        b6 = new javax.swing.JLabel();
        p25 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        new_pass = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        newpass1 = new javax.swing.JPasswordField();
        newerr1 = new javax.swing.JLabel();
        lb10 = new javax.swing.JLabel();
        newpass2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        newerr2 = new javax.swing.JLabel();
        lb11 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        bt67 = new javax.swing.JLabel();
        bt68 = new javax.swing.JLabel();
        bt69 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        b7 = new javax.swing.JLabel();
        b8 = new javax.swing.JLabel();
        b9 = new javax.swing.JLabel();
        p26 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        p27 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        p4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        p1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        p3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        p6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        p5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        bt4 = new javax.swing.JLabel();
        bt5 = new javax.swing.JLabel();
        bt6 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        b10 = new javax.swing.JLabel();
        b11 = new javax.swing.JLabel();
        b12 = new javax.swing.JLabel();
        transfer = new javax.swing.JPanel();
        atm1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        er3 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        bt25 = new javax.swing.JLabel();
        bt26 = new javax.swing.JLabel();
        bt27 = new javax.swing.JLabel();
        p13 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        p14 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        b13 = new javax.swing.JLabel();
        b14 = new javax.swing.JLabel();
        b15 = new javax.swing.JLabel();
        amount = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        bt13 = new javax.swing.JLabel();
        bt14 = new javax.swing.JLabel();
        bt15 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        b16 = new javax.swing.JLabel();
        b17 = new javax.swing.JLabel();
        b18 = new javax.swing.JLabel();
        p9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        p10 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        atm2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        er4 = new javax.swing.JLabel();
        reciever = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        p11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        p12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        bt19 = new javax.swing.JLabel();
        bt20 = new javax.swing.JLabel();
        bt21 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        b19 = new javax.swing.JLabel();
        b20 = new javax.swing.JLabel();
        b21 = new javax.swing.JLabel();
        snd = new javax.swing.JTextField();
        tit = new javax.swing.JTextField();
        rc = new javax.swing.JTextField();
        am = new javax.swing.JTextField();
        recipt = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        bt31 = new javax.swing.JLabel();
        bt32 = new javax.swing.JLabel();
        bt33 = new javax.swing.JLabel();
        p15 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        p16 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        lbb3 = new javax.swing.JLabel();
        lbb2 = new javax.swing.JLabel();
        lbb1 = new javax.swing.JLabel();
        lbb4 = new javax.swing.JLabel();
        lbb5 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        b22 = new javax.swing.JLabel();
        b23 = new javax.swing.JLabel();
        b24 = new javax.swing.JLabel();
        acc_type = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        bt37 = new javax.swing.JLabel();
        bt38 = new javax.swing.JLabel();
        bt39 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        b25 = new javax.swing.JLabel();
        b26 = new javax.swing.JLabel();
        b27 = new javax.swing.JLabel();
        p7 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        p8 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        p17 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        withdraw = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        bt43 = new javax.swing.JLabel();
        bt44 = new javax.swing.JLabel();
        bt45 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        b28 = new javax.swing.JLabel();
        b29 = new javax.swing.JLabel();
        b30 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        atm3 = new javax.swing.JTextField();
        er5 = new javax.swing.JLabel();
        p18 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        p19 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        balance_details = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        bt49 = new javax.swing.JLabel();
        bt50 = new javax.swing.JLabel();
        bt51 = new javax.swing.JLabel();
        p20 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        b31 = new javax.swing.JLabel();
        b32 = new javax.swing.JLabel();
        b33 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        lbb7 = new javax.swing.JLabel();
        lbb8 = new javax.swing.JLabel();
        lbb9 = new javax.swing.JLabel();
        withdraw_recipt = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        bt34 = new javax.swing.JLabel();
        bt35 = new javax.swing.JLabel();
        bt36 = new javax.swing.JLabel();
        p28 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        p29 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        lbb10 = new javax.swing.JLabel();
        lbb11 = new javax.swing.JLabel();
        lbb12 = new javax.swing.JLabel();
        lbb13 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        b34 = new javax.swing.JLabel();
        b35 = new javax.swing.JLabel();
        b36 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        main = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recpt = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        a_bnc = new javax.swing.JLabel();
        card = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        st_table = new javax.swing.JTable();
        s_date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("×");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 0, 45, 35));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("–");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 0, 45, 35));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("Welcome to SKY Bank ATM Service");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 380, 30));

        main_panel.setOpaque(false);
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        keypad.setOpaque(false);
        keypad.setLayout(new java.awt.CardLayout());

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Show Keypad");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jPanel21.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 10, 100, 20));

        keypad.add(jPanel21, "card3");

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb1.setBackground(new java.awt.Color(142, 142, 142));
        lb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lb1MouseReleased(evt);
            }
        });
        lb1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb01.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb01.setText("1");
        lb1.add(lb01, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 60, -1));

        jPanel20.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 112, 60, 30));

        jPanel15.setBackground(new java.awt.Color(142, 142, 142));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel15MouseReleased(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb0.setText("0");
        jPanel15.add(lb0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, 60, 30));

        jPanel14.setBackground(new java.awt.Color(142, 142, 142));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel14MouseReleased(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb00.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb00.setText("00");
        jPanel14.add(lb00, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 112, 60, 30));

        jPanel8.setBackground(new java.awt.Color(142, 142, 142));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel8MouseReleased(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("3");
        jPanel8.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 72, 60, 30));

        pn7.setBackground(new java.awt.Color(142, 142, 142));
        pn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pn7MouseReleased(evt);
            }
        });
        pn7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("7");
        pn7.add(lb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(pn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 33, 60, 30));

        jPanel5.setBackground(new java.awt.Color(142, 142, 142));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel5MouseReleased(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setText("8");
        jPanel5.add(lb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 33, 60, 30));

        jPanel6.setBackground(new java.awt.Color(142, 142, 142));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel6MouseReleased(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb9.setText("9");
        jPanel6.add(lb9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 60, -1));

        jPanel20.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 33, 60, 30));

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel7MouseReleased(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("×");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 28));

        jPanel20.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 33, 60, 30));

        jPanel17.setBackground(new java.awt.Color(142, 142, 142));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel17MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel17MouseReleased(evt);
            }
        });
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb02.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb02.setText("2");
        jPanel17.add(lb02, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 112, 60, 30));

        jPanel12.setBackground(new java.awt.Color(142, 142, 142));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel12MouseReleased(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("6");
        jPanel12.add(lb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 72, 60, 30));

        jPanel11.setBackground(new java.awt.Color(142, 142, 142));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel11MouseReleased(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("5");
        jPanel11.add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 72, 60, 30));

        jPanel9.setBackground(new java.awt.Color(142, 142, 142));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel9MouseReleased(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("4");
        jPanel9.add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jPanel20.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 72, 60, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Hide Keypad");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
        });
        jPanel20.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 3, 80, 20));

        keypad.add(jPanel20, "card2");

        main_panel.add(keypad, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 208, 290, 150));

        screen.setOpaque(false);
        screen.setLayout(new java.awt.CardLayout());

        atm_num.setOpaque(false);
        atm_num.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        er2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        er2.setForeground(new java.awt.Color(255, 0, 0));
        atm_num.add(er2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 103, 190, 15));

        atm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        atm.setForeground(new java.awt.Color(102, 102, 102));
        atm.setText("Enter ATM account number");
        atm.setBorder(null);
        atm.setOpaque(false);
        atm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atmMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atmMousePressed(evt);
            }
        });
        atm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                atmKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                atmKeyTyped(evt);
            }
        });
        atm_num.add(atm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 78, 190, 20));

        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        atm_num.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 100, 190, -1));

        p21.setBackground(new java.awt.Color(204, 204, 204));
        p21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p21MouseClicked(evt);
            }
        });
        p21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Cancel");
        p21.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 95, 25));

        atm_num.add(p21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        p22.setBackground(new java.awt.Color(204, 204, 204));
        p22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p22MouseClicked(evt);
            }
        });
        p22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Enter");
        p22.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 95, 25));

        atm_num.add(p22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 100, 25));

        jPanel43.setBackground(new java.awt.Color(142, 142, 142));
        jPanel43.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt55.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt55.setName(""); // NOI18N
        jPanel43.add(bt55, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt56.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel43.add(bt56, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt57.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt57MouseClicked(evt);
            }
        });
        jPanel43.add(bt57, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        atm_num.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel44.setBackground(new java.awt.Color(142, 142, 142));
        jPanel44.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel44.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel44.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);
            }
        });
        jPanel44.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        atm_num.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        screen.add(atm_num, "card2");

        pincode.setOpaque(false);
        pincode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        err1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        err1.setForeground(new java.awt.Color(204, 0, 0));
        pincode.add(err1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 83, 150, 15));

        pass1.setBackground(new java.awt.Color(240, 240, 240));
        pass1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pass1.setForeground(new java.awt.Color(102, 102, 102));
        pass1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass1.setText("Enter Pincode");
        pass1.setBorder(null);
        pass1.setOpaque(false);
        pass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass1FocusGained(evt);
            }
        });
        pass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pass1MousePressed(evt);
            }
        });
        pass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass1KeyTyped(evt);
            }
        });
        pincode.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 55, 100, 20));

        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb2MouseEntered(evt);
            }
        });
        pincode.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 58, 18, 18));

        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        pincode.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 145, -1));

        p23.setBackground(new java.awt.Color(204, 204, 204));
        p23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p23MouseClicked(evt);
            }
        });
        p23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Cancel");
        p23.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 95, 25));

        pincode.add(p23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        p24.setBackground(new java.awt.Color(204, 204, 204));
        p24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p24MouseClicked(evt);
            }
        });
        p24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Enter");
        p24.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 95, 25));

        pincode.add(p24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 100, 25));

        jPanel45.setBackground(new java.awt.Color(142, 142, 142));
        jPanel45.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt61.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt61.setName(""); // NOI18N
        jPanel45.add(bt61, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt62.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel45.add(bt62, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt63MouseClicked(evt);
            }
        });
        jPanel45.add(bt63, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        pincode.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel46.setBackground(new java.awt.Color(142, 142, 142));
        jPanel46.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel46.add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);
            }
        });
        jPanel46.add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b6MouseClicked(evt);
            }
        });
        jPanel46.add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        pincode.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        p25.setBackground(new java.awt.Color(204, 204, 204));
        p25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p25MouseClicked(evt);
            }
        });
        p25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Reset Pincode");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p25.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 25));

        pincode.add(p25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 100, 25));

        screen.add(pincode, "card3");

        new_pass.setOpaque(false);
        new_pass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, 200, -1));

        newpass1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        newpass1.setForeground(new java.awt.Color(102, 102, 102));
        newpass1.setText("Enter new Pincode");
        newpass1.setBorder(null);
        newpass1.setOpaque(false);
        newpass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newpass1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newpass1MousePressed(evt);
            }
        });
        newpass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newpass1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newpass1KeyTyped(evt);
            }
        });
        jPanel2.add(newpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 30, 150, 20));

        newerr1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newerr1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(newerr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 53, 190, 15));

        lb10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb10MouseClicked(evt);
            }
        });
        jPanel2.add(lb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 30, 18, 18));

        newpass2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        newpass2.setForeground(new java.awt.Color(102, 102, 102));
        newpass2.setText("Enter confirm Pincode");
        newpass2.setBorder(null);
        newpass2.setOpaque(false);
        newpass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newpass2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newpass2MousePressed(evt);
            }
        });
        newpass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newpass2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newpass2KeyTyped(evt);
            }
        });
        jPanel2.add(newpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 80, 150, 20));

        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 100, 200, -1));

        newerr2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newerr2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(newerr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 103, 190, 15));

        lb11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb11MouseClicked(evt);
            }
        });
        jPanel2.add(lb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 80, 18, 18));

        jPanel47.setBackground(new java.awt.Color(142, 142, 142));
        jPanel47.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt67.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt67.setName(""); // NOI18N
        jPanel47.add(bt67, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt68.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel47.add(bt68, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt69.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt69MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt69MouseReleased(evt);
            }
        });
        jPanel47.add(bt69, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        jPanel2.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel48.setBackground(new java.awt.Color(142, 142, 142));
        jPanel48.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel48.add(b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel48.add(b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b9MouseClicked(evt);
            }
        });
        jPanel48.add(b9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        jPanel2.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        p26.setBackground(new java.awt.Color(204, 204, 204));
        p26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p26MouseClicked(evt);
            }
        });
        p26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Cancel");
        p26.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 95, 25));

        jPanel2.add(p26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        p27.setBackground(new java.awt.Color(204, 204, 204));
        p27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p27MouseClicked(evt);
            }
        });
        p27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Enter");
        p27.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 95, 25));

        jPanel2.add(p27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 100, 25));

        new_pass.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 160));

        screen.add(new_pass, "card4");

        home.setOpaque(false);
        home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setOpaque(false);
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p4.setBackground(new java.awt.Color(204, 204, 204));
        p4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p4MouseClicked(evt);
            }
        });
        p4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Transfer Fund");
        p4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 90, 20));

        jPanel24.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 100, 25));

        p1.setBackground(new java.awt.Color(204, 204, 204));
        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });
        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Balance Inquiry");
        p1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        jPanel24.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 61, 100, 25));

        p3.setBackground(new java.awt.Color(204, 204, 204));
        p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p3MouseClicked(evt);
            }
        });
        p3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cancel Card");
        p3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        jPanel24.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 123, 100, 25));

        p6.setBackground(new java.awt.Color(204, 204, 204));
        p6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p6MouseClicked(evt);
            }
        });
        p6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Change Pincode");
        p6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 95, 20));

        jPanel24.add(p6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 100, 25));

        p2.setBackground(new java.awt.Color(204, 204, 204));
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
        });
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cash Withdraw");
        p2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        jPanel24.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 92, 100, 25));

        p5.setBackground(new java.awt.Color(204, 204, 204));
        p5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p5MouseClicked(evt);
            }
        });
        p5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText(" Mini Statement");
        p5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        jPanel24.add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 100, 25));

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Select your choice here");
        jPanel24.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 25, 190, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Welcome");
        jPanel24.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 3, 190, 20));

        home.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 2, 226, 156));

        jPanel25.setBackground(new java.awt.Color(142, 142, 142));
        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt4.setName(""); // NOI18N
        bt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt4MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt4MouseReleased(evt);
            }
        });
        jPanel25.add(bt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt5MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt5MouseReleased(evt);
            }
        });
        jPanel25.add(bt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt6MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt6MouseReleased(evt);
            }
        });
        jPanel25.add(bt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        home.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel26.setBackground(new java.awt.Color(142, 142, 142));
        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b10MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b10MouseReleased(evt);
            }
        });
        jPanel26.add(b10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b11MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b11MouseReleased(evt);
            }
        });
        jPanel26.add(b11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b12MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b12MouseReleased(evt);
            }
        });
        jPanel26.add(b12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        home.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        screen.add(home, "card5");

        transfer.setOpaque(false);
        transfer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atm1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        atm1.setForeground(new java.awt.Color(102, 102, 102));
        atm1.setText("Enter reciever atm account");
        atm1.setBorder(null);
        atm1.setOpaque(false);
        atm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atm1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atm1MousePressed(evt);
            }
        });
        atm1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                atm1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                atm1KeyTyped(evt);
            }
        });
        transfer.add(atm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 65, 190, 25));

        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        transfer.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 190, -1));

        er3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        er3.setForeground(new java.awt.Color(255, 0, 0));
        transfer.add(er3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 94, 190, 15));

        jPanel33.setBackground(new java.awt.Color(142, 142, 142));
        jPanel33.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt25.setName(""); // NOI18N
        jPanel33.add(bt25, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel33.add(bt26, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt27MouseClicked(evt);
            }
        });
        jPanel33.add(bt27, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        transfer.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        p13.setBackground(new java.awt.Color(204, 204, 204));
        p13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p13MouseClicked(evt);
            }
        });
        p13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Back");
        p13.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 95, 20));

        transfer.add(p13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        p14.setBackground(new java.awt.Color(204, 204, 204));
        p14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p14MouseClicked(evt);
            }
        });
        p14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Next");
        p14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        transfer.add(p14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 100, 25));

        jPanel34.setBackground(new java.awt.Color(142, 142, 142));
        jPanel34.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel34.add(b13, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel34.add(b14, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b15MouseClicked(evt);
            }
        });
        jPanel34.add(b15, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        transfer.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        screen.add(transfer, "card6");

        amount.setOpaque(false);
        amount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(142, 142, 142));
        jPanel29.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt13.setName(""); // NOI18N
        jPanel29.add(bt13, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel29.add(bt14, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt15MouseClicked(evt);
            }
        });
        jPanel29.add(bt15, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        amount.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel30.setBackground(new java.awt.Color(142, 142, 142));
        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel30.add(b16, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel30.add(b17, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b18MouseClicked(evt);
            }
        });
        jPanel30.add(b18, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        amount.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        p9.setBackground(new java.awt.Color(204, 204, 204));
        p9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p9MouseClicked(evt);
            }
        });
        p9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Back");
        p9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 95, 20));

        amount.add(p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        p10.setBackground(new java.awt.Color(204, 204, 204));
        p10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p10MouseClicked(evt);
            }
        });
        p10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Next");
        p10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        amount.add(p10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 100, 25));

        atm2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        atm2.setForeground(new java.awt.Color(102, 102, 102));
        atm2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        atm2.setText("Enter amount");
        atm2.setBorder(null);
        atm2.setOpaque(false);
        atm2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atm2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atm2MousePressed(evt);
            }
        });
        atm2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                atm2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                atm2KeyTyped(evt);
            }
        });
        amount.add(atm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, 190, 25));

        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        amount.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 190, -1));

        er4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        er4.setForeground(new java.awt.Color(255, 0, 0));
        amount.add(er4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, 190, 15));

        screen.add(amount, "card7");

        reciever.setOpaque(false);
        reciever.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel31.setText("Amount");
        reciever.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel32.setText("From Account");
        reciever.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 15, -1, 20));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel33.setText("To Account");
        reciever.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 75, -1, 20));

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel34.setText("Beneficiary");
        reciever.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 45, -1, 20));

        p11.setBackground(new java.awt.Color(204, 204, 204));
        p11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p11MouseClicked(evt);
            }
        });
        p11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Back");
        p11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 95, 25));

        reciever.add(p11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 127, 100, 25));

        p12.setBackground(new java.awt.Color(204, 204, 204));
        p12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p12MouseClicked(evt);
            }
        });
        p12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Conform");
        p12.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 95, 25));

        reciever.add(p12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 127, 100, 25));

        jPanel31.setBackground(new java.awt.Color(142, 142, 142));
        jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt19.setName(""); // NOI18N
        jPanel31.add(bt19, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel31.add(bt20, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt21MouseClicked(evt);
            }
        });
        jPanel31.add(bt21, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        reciever.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel32.setBackground(new java.awt.Color(142, 142, 142));
        jPanel32.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel32.add(b19, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel32.add(b20, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b21MouseClicked(evt);
            }
        });
        jPanel32.add(b21, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        reciever.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        snd.setEditable(false);
        snd.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        snd.setOpaque(false);
        reciever.add(snd, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 15, 128, 20));

        tit.setEditable(false);
        tit.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tit.setOpaque(false);
        reciever.add(tit, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 45, 128, 20));

        rc.setEditable(false);
        rc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rc.setOpaque(false);
        reciever.add(rc, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 75, 128, 20));

        am.setEditable(false);
        am.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        am.setOpaque(false);
        reciever.add(am, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 100, 128, 20));

        screen.add(reciever, "card8");

        recipt.setOpaque(false);
        recipt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBackground(new java.awt.Color(142, 142, 142));
        jPanel35.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt31.setName(""); // NOI18N
        jPanel35.add(bt31, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel35.add(bt32, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt33MouseClicked(evt);
            }
        });
        jPanel35.add(bt33, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        recipt.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        p15.setBackground(new java.awt.Color(204, 204, 204));
        p15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p15MouseClicked(evt);
            }
        });
        p15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Save receipt");
        p15.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 95, 25));

        recipt.add(p15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 127, 100, 25));

        p16.setBackground(new java.awt.Color(204, 204, 204));
        p16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Cancel");
        p16.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 95, 25));

        recipt.add(p16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 127, 100, 25));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("SKY Bank ATM Service");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 220, -1));

        lbb3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb3.setText("To Account   : 112108211221 ");
        jPanel4.add(lbb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 55, 220, 20));

        lbb2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb2.setText("Beneficiary   : Amir Ghafoor ");
        jPanel4.add(lbb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 35, 210, 20));

        lbb1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb1.setText("From Account : 112108211221");
        jPanel4.add(lbb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 15, 210, 20));

        lbb4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb4.setText("Amount  : RS 2000000.00 PKR");
        jPanel4.add(lbb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 75, 220, 20));

        lbb5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb5.setText("Date : 03/30/2021   Time : 20:42:51");
        jPanel4.add(lbb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 97, 220, 20));

        recipt.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 3, 220, 120));

        jPanel36.setBackground(new java.awt.Color(142, 142, 142));
        jPanel36.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel36.add(b22, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel36.add(b23, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b24MouseClicked(evt);
            }
        });
        jPanel36.add(b24, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        recipt.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        screen.add(recipt, "card9");

        acc_type.setOpaque(false);
        acc_type.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(142, 142, 142));
        jPanel37.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt37.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt37.setName(""); // NOI18N
        jPanel37.add(bt37, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt38.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel37.add(bt38, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc_back(evt);
            }
        });
        jPanel37.add(bt39, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        acc_type.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel38.setBackground(new java.awt.Color(142, 142, 142));
        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel38.add(b25, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b26MouseClicked(evt);
            }
        });
        jPanel38.add(b26, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b27MouseClicked(evt);
            }
        });
        jPanel38.add(b27, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        acc_type.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        p7.setBackground(new java.awt.Color(204, 204, 204));
        p7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc_back(evt);
            }
        });
        p7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Back");
        p7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 95, 20));

        acc_type.add(p7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        p8.setBackground(new java.awt.Color(204, 204, 204));
        p8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p8MouseClicked(evt);
            }
        });
        p8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Saving Account");
        p8.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        acc_type.add(p8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 100, 25));

        p17.setBackground(new java.awt.Color(204, 204, 204));
        p17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p17MouseClicked(evt);
            }
        });
        p17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Current Account");
        p17.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        acc_type.add(p17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 100, 25));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Select your account type");
        acc_type.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 210, 30));

        screen.add(acc_type, "card10");

        withdraw.setOpaque(false);
        withdraw.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel39.setBackground(new java.awt.Color(142, 142, 142));
        jPanel39.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt43.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt43.setName(""); // NOI18N
        jPanel39.add(bt43, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt44.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel39.add(bt44, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt45MouseClicked(evt);
            }
        });
        jPanel39.add(bt45, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        withdraw.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        jPanel40.setBackground(new java.awt.Color(142, 142, 142));
        jPanel40.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel40.add(b28, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel40.add(b29, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b30MouseClicked(evt);
            }
        });
        jPanel40.add(b30, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        withdraw.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        jLabel51.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        withdraw.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 190, -1));

        atm3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        atm3.setForeground(new java.awt.Color(102, 102, 102));
        atm3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        atm3.setText("Enter withdrawal amount");
        atm3.setBorder(null);
        atm3.setOpaque(false);
        atm3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atm3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atm3MousePressed(evt);
            }
        });
        atm3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                atm3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                atm3KeyTyped(evt);
            }
        });
        withdraw.add(atm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, 190, 25));

        er5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        er5.setForeground(new java.awt.Color(255, 0, 0));
        withdraw.add(er5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, 190, 15));

        p18.setBackground(new java.awt.Color(204, 204, 204));
        p18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Withdraw");
        p18.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 95, 20));

        withdraw.add(p18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 100, 25));

        p19.setBackground(new java.awt.Color(204, 204, 204));
        p19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Back");
        p19.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 95, 20));

        withdraw.add(p19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        screen.add(withdraw, "card11");

        balance_details.setOpaque(false);
        balance_details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel41.setBackground(new java.awt.Color(142, 142, 142));
        jPanel41.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt49.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt49.setName(""); // NOI18N
        jPanel41.add(bt49, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt50.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel41.add(bt50, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt51MouseClicked(evt);
            }
        });
        jPanel41.add(bt51, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        balance_details.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        p20.setBackground(new java.awt.Color(204, 204, 204));
        p20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Back");
        p20.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 95, 20));
        jLabel55.getAccessibleContext().setAccessibleName("");

        balance_details.add(p20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 125, 100, 25));

        jPanel42.setBackground(new java.awt.Color(142, 142, 142));
        jPanel42.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel42.add(b31, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel42.add(b32, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b33.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel42.add(b33, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        balance_details.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        jPanel16.setOpaque(false);
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("SKY Bank ATM Service");
        jPanel16.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 220, -1));

        lbb7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb7.setText("Account Title   : Amir Ghafoor ");
        jPanel16.add(lbb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 55, 210, 20));

        lbb8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb8.setText("ATM Account   : 112108211221");
        jPanel16.add(lbb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 30, 210, 20));
        lbb8.getAccessibleContext().setAccessibleName("ATM Account : 112108211221");

        lbb9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb9.setText("Balance  :  2000000.00 PKR");
        jPanel16.add(lbb9, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 80, 217, 20));

        balance_details.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 3, 220, 120));

        screen.add(balance_details, "card12");

        withdraw_recipt.setOpaque(false);
        withdraw_recipt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel49.setBackground(new java.awt.Color(142, 142, 142));
        jPanel49.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt34.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt34.setName(""); // NOI18N
        jPanel49.add(bt34, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 25, 20));

        bt35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel49.add(bt35, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 95, 25, 20));

        bt36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt36MouseClicked(evt);
            }
        });
        jPanel49.add(bt36, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 127, 25, 20));

        withdraw_recipt.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 33, 160));

        p28.setBackground(new java.awt.Color(204, 204, 204));
        p28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p28MouseClicked(evt);
            }
        });
        p28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Save receipt");
        p28.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 95, 25));

        withdraw_recipt.add(p28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 127, 100, 25));

        p29.setBackground(new java.awt.Color(204, 204, 204));
        p29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Back");
        p29.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 95, 25));

        withdraw_recipt.add(p29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 127, 100, 25));

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("SKY Bank ATM Service");
        jPanel18.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 220, -1));

        lbb10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb10.setText("Account Title : Amir Ghafoor ");
        jPanel18.add(lbb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 50, 210, 20));

        lbb11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb11.setText("ATM Account : 112108211221");
        jPanel18.add(lbb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 25, 210, 20));

        lbb12.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb12.setText("Withdraw Amount  : 2000000.00 PKR");
        jPanel18.add(lbb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 72, 220, 20));

        lbb13.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbb13.setText("Date : 03/30/2021   Time : 20:42:51");
        jPanel18.add(lbb13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 95, 220, 20));

        withdraw_recipt.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 3, 220, 120));

        jPanel50.setBackground(new java.awt.Color(142, 142, 142));
        jPanel50.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b34.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel50.add(b34, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 25, 20));

        b35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel50.add(b35, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, 25, 20));

        b36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b36MouseClicked(evt);
            }
        });
        jPanel50.add(b36, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 25, 20));

        withdraw_recipt.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, 33, 160));

        screen.add(withdraw_recipt, "card9");

        main_panel.add(screen, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, 290, 160));

        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        main_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, 290, 160));

        jPanel1.add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 350, 380));

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("@amirghafoor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 480, 85, 20));

        main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm_project/nta.jpg"))); // NOI18N
        main.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainMouseDragged(evt);
            }
        });
        main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainMousePressed(evt);
            }
        });
        jPanel1.add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 500));

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.CardLayout());

        jPanel13.setOpaque(false);
        jPanel10.add(jPanel13, "card3");

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recpt.setEditable(false);
        recpt.setColumns(20);
        recpt.setRows(5);
        recpt.setBorder(null);
        recpt.setOpaque(false);
        jScrollPane1.setViewportView(recpt);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 390));

        jPanel10.add(jPanel3, "card2");

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel19.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 380, -1));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("SKY BANK ATM SERVICE");
        jPanel19.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 15, 370, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Receipt Type  : Mini Statement");
        jPanel19.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 55, 180, -1));

        a_bnc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        a_bnc.setText("Avail Balance : 3298329832");
        jPanel19.add(a_bnc, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 385, 350, -1));

        card.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        card.setText("Card Number : 112108211222");
        jPanel19.add(card, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 55, -1, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        st_table.setBackground(new java.awt.Color(240, 240, 240));
        st_table.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        st_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "History Type", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        st_table.setRowHeight(23);
        st_table.setShowHorizontalLines(false);
        st_table.setShowVerticalLines(false);
        jScrollPane2.setViewportView(st_table);

        jPanel19.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 355, 260));

        s_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        s_date.setText("Date : Sun Aug 08 18:45:37 PKT 2021");
        jPanel19.add(s_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, -1, -1));

        jPanel10.add(jPanel19, "card4");

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 380, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
Color color,c;
    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        jLabel11.setForeground(Color.red);
        jLabel11.setToolTipText("Close Pogram");
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
         jLabel11.setForeground(Color.white);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jLabel9.setForeground(Color.LIGHT_GRAY);
        jLabel9.setToolTipText("Minimize Program");
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jLabel9.setForeground(Color.white);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        jPanel21.setVisible(false);
        jPanel20.setVisible(true);
        keypad.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        //jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,102,102)), "Keypad Screen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10)));
    }//GEN-LAST:event_jLabel20MouseClicked

    private void lb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseClicked
        // TODO add your handling code here:
        print_num("1");
    }//GEN-LAST:event_lb1MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
        print_num("0");
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
        print_num("00");
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        print_num("3");
    }//GEN-LAST:event_jPanel8MouseClicked

    private void pn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn7MouseClicked
        // TODO add your handling code here:
        print_num("7");
    }//GEN-LAST:event_pn7MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        print_num("8");
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        print_num("9");
    }//GEN-LAST:event_jPanel6MouseClicked
void text_field_remove(JTextField at,JLabel lb,String text){
     if(!(at.getText().equals(text))){
                String std=at.getText();
                std= std.substring(0, std.length()-1);
                if(std.length()==0){
                    at.setText(text);
                    at.setForeground(new Color(102,102,102));
                    at.setFont(new Font("Verdana",0,12));
                    at.setCaretPosition(0);
                    lb.setText(null);
                }else{
                    at.setText(std);
                }
            }
}
void pass_field_remove(JPasswordField pass,JLabel lb,JLabel ico,String text){
    if(!(pass.getText().equals(text))){
                String std=pass.getText();
                std= std.substring(0, std.length()-1);
                if(std.length()==0){
                    pass.setEchoChar((char)0);
                    pass.setText(text);
                    pass.setForeground(new Color(102,102,102));
                    pass.setCaretPosition(0);
                    pass.setFont(new Font("Verdana",0,12));
                    URL path30=getClass().getResource("/atm_project/see.png");
                    ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(ico.getWidth(),ico.getHeight(),java.awt.Image.SCALE_SMOOTH));
                    ico.setIcon(photo30);
                    lb.setText(null);
                    seee=0;
                }else{
                    pass.setText(std);
                }
            }
}
    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        if(acc==0){
            text_field_remove(atm,er2,"Enter ATM account number");
        }
        else if(acc==1){
            pass_field_remove(pass1,err1,lb2,"Enter Pincode");
        }
        else if(acc==24){
            text_field_remove(atm1,er3,"Enter reciever atm account");
        }
        else if(acc==241){
            text_field_remove(atm2,er4,"Enter amount");
        }
        else if(acc==22){
            text_field_remove(atm3,er5,"Enter withdrawal amount");
        }
        else if(acc==31){
            pass_field_remove(newpass1,newerr1,lb10,pin_text1);
        }
        else if(acc==32){
            pass_field_remove(newpass2,newerr2,lb11,pin_text2);
        }
        
    }//GEN-LAST:event_jPanel7MouseClicked
void field_clear(JTextField f,JLabel lb,String text){
    f.setText(text);
    f.setForeground(new Color(102,102,102));
    f.setFont(new Font("Verdana",0,12));
    f.setCaretPosition(0);
    lb.setText(null);
}
void pass_field_clear(JPasswordField p,JLabel pic,JLabel lb,String text){
    p.setEchoChar((char)0);
    p.setText(text);
    p.setForeground(new Color(102,102,102));
    p.setCaretPosition(0);
    p.setFont(new Font("Verdana",0,12));
    URL path30=getClass().getResource("/atm_project/see.png");
    ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(pic.getWidth(),pic.getHeight(),java.awt.Image.SCALE_SMOOTH));
    pic.setIcon(photo30);
    lb.setText(null);
    seee=0;
}
    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
        print_num("2");
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        print_num("6");
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        print_num("5");
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        print_num("4");
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        jPanel20.setVisible(false);
        jPanel21.setVisible(true);
        jPanel20.setBorder(null);
        keypad.setBorder(null);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void atmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atmMouseClicked
        // TODO add your handling code here:
        if(atm.getText().equals("Enter ATM account number")){
            atm.setCaretPosition(0);
        }
    }//GEN-LAST:event_atmMouseClicked

String atm_acc;
String atm_a;
String atm_pass,atm_mail,atm_tpy,bnk;
int blnc;
String name,title;
void atm_sign(){
    atm_acc=atm.getText();
            if(db.check_atm_account(atm_acc)==true){
             if(db.getAtm_status().equals("Active")){
                 acc=1;
                 atm_pass=db.getAtm_pass();
                 atm_mail=db.getEmail();
                 blnc=db.getBlnc();
                 title=db.getTitle();
                 name=db.getName();
                 atm_a=db.getAtm_acc();
                 atm_tpy=db.getAcc_type();
                 bnk=db.getBnk();
                 atm_num.setVisible(false);
                 pincode.setVisible(true);
                 pass1.requestFocus();
                 pass1.setCaretPosition(0);
             }else{
                 JOptionPane.showMessageDialog(this,"This ATM account is blocked","Error",JOptionPane.ERROR_MESSAGE);
             }
             
         }else{
            JOptionPane.showMessageDialog(this,"This ATM account not exist in record","Error",JOptionPane.ERROR_MESSAGE);
         }
}
    private void atmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atmKeyPressed
        // TODO add your handling code here:
        if(atm.getText().equals("Enter ATM account number")){
            atm.setCaretPosition(0);
        }
    }//GEN-LAST:event_atmKeyPressed
void atm_num_action(java.awt.event.KeyEvent evt,JTextField fl,JLabel lb,String sms){
    String dt=fl.getText();
    char word=evt.getKeyChar();
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
               if(dt.equals(sms)){
                   fl.setText(null);
               }
        }else{
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals(sms) &&(Character.isDigit(word))){
                fl.setText(null);
                fl.setText(null);
                fl.setForeground(Color.black);
                fl.setFont(new Font("Tahoma",0,18));
                lb.setText(null);
            }
            if(!(Character.isDigit(word))){
                evt.consume();
                getToolkit().beep();
                lb.setText("Enter digits only");
            }else{
                lb.setText(null);
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                fl.setText(sms);
                fl.setForeground(new Color(102,102,102));
                fl.setFont(new Font("Verdana",0,12));
                fl.setCaretPosition(0);
                lb.setText(null);
            }
        }
        }
}
    private void atmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atmKeyTyped
        // TODO add your handling code here:
        atm_num_action(evt,atm,er2,"Enter ATM account number");
    }//GEN-LAST:event_atmKeyTyped

    private void pass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass1FocusGained
        // TODO add your handling code here:
        err1.setText(null);
    }//GEN-LAST:event_pass1FocusGained

    private void pass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass1MouseClicked
        // TODO add your handling code here:
        if(pass1.getText().equals("Enter Pincode")){
            pass1.setCaretPosition(0);
        }
        err1.setText(null);
    }//GEN-LAST:event_pass1MouseClicked
int pass_action=121;
    private void pass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyPressed
        // TODO add your handling code here:
        if(pass1.getText().equals("Enter Pincode")){
            pass1.setCaretPosition(0);
        }
    }//GEN-LAST:event_pass1KeyPressed

    private void pass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyTyped
        // TODO add your handling code here:
      new_pin_effect(evt,pass1,lb2,err1,pass1.getText(),"Enter Pincode");
    }//GEN-LAST:event_pass1KeyTyped

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
        // TODO add your handling code here:
        if(!(pass1.getText().equals("Enter Pincode"))){
            if(seee==0){
                pass1.setEchoChar((char)0);
                URL path30=getClass().getResource("/atm_project/unsee.jpg");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb2.setIcon(photo30);
                seee=1;
            }
            else if(seee==1){
                pass1.setEchoChar('•');
                URL path30=getClass().getResource("/atm_project/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb2.setIcon(photo30);
                seee=0;
            }
        }
    }//GEN-LAST:event_lb2MouseClicked

    private void lb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseEntered
        // TODO add your handling code here:
        if(seee==0){
            lb2.setToolTipText("Show Pincode");
        }else{
            lb2.setToolTipText("Hide Pincode");
        }
    }//GEN-LAST:event_lb2MouseEntered
boolean net(){
    try {
         URL url = new URL("http://www.google.com");
         URLConnection connection = url.openConnection();
         connection.connect();
         return true;
      } catch (MalformedURLException e) {
         return false;
      } catch (IOException e) {
         return false;
      }
}
    String new_pass_atm=null;
    void mail_send(){
    if(net()==false){
            JOptionPane.showMessageDialog(this,"Check internet connection","Error",JOptionPane.ERROR_MESSAGE);
    }else{
        SplittableRandom s1=new SplittableRandom();
         StringBuilder s2=new StringBuilder();
         for(int i=0;i<4;i++){
          s2.append(s1.nextInt(0,10));
          }
           new_pass_atm=s2.toString();
           String sms_df="Hello dear \nYou have submit request to change Pincode of ATM account of SKY Bank Limitted.\nYour new Pincode is : "+new_pass_atm+" ";
      Thread t = new Thread(new Runnable(){
      public void run(){
        em.send(atm_mail,sms_df,"ATM new Pincode");
       }
    });
    t.start();
        }   
}
    private void mainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xm, y-ym);
    }//GEN-LAST:event_mainMouseDragged
int xm,ym;
    private void mainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMousePressed
        // TODO add your handling code here:
        xm=evt.getX();
        ym=evt.getY();
    }//GEN-LAST:event_mainMousePressed

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
        jLabel20.setToolTipText("Click to show Keypad");
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
        jLabel19.setToolTipText("Click to hide Keypad");
    }//GEN-LAST:event_jLabel19MouseEntered

    private void lb10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb10MouseClicked
        // TODO add your handling code here:
        if(!(newpass1.getText().equals(pin_text1))){
            if(seee==0){
                newpass1.setEchoChar((char)0);
                URL path30=getClass().getResource("/atm_project/unsee.jpg");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb10.setIcon(photo30);
                seee=1;
            }
            else if(seee==1){
                newpass1.setEchoChar('•');
                URL path30=getClass().getResource("/atm_project/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb10.setIcon(photo30);
                seee=0;
            }
        }
    }//GEN-LAST:event_lb10MouseClicked

    private void lb11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb11MouseClicked
        // TODO add your handling code here:
        if(!(newpass2.getText().equals(pin_text2))){
            if(seee==0){
                newpass2.setEchoChar((char)0);
                URL path30=getClass().getResource("/atm_project/unsee.jpg");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb11.setIcon(photo30);
                seee=1;
            }
            else if(seee==1){
                newpass2.setEchoChar('•');
                URL path30=getClass().getResource("/atm_project/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb11.setIcon(photo30);
                seee=0;
            }
        }
    }//GEN-LAST:event_lb11MouseClicked

    private void newpass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass1KeyTyped
        // TODO add your handling code here:
         new_pin_effect(evt,newpass1,lb10,newerr1,newpass1.getText(),pin_text1);
    }//GEN-LAST:event_newpass1KeyTyped

    private void newpass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass1KeyPressed
        // TODO add your handling code here:
        if(newpass1.getText().equals(pin_text1)){
            newpass1.setCaretPosition(0);
        }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            newpass2.requestFocus();
            newpass2.setCaretPosition(0);
            acc=32;
        }
    }//GEN-LAST:event_newpass1KeyPressed
void new_pin_effect(java.awt.event.KeyEvent evt,JPasswordField f,JLabel lb1,JLabel lb,String dt,String match){
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals(match) && Character.isDigit(word)){
                f.setText(null);
                f.setEchoChar('•');
                f.setFont(new Font("Tahoma",0,18));
                f.setForeground(Color.black);
                lb.setText(null);
            }
            else if(dt.length()<4  || match.equals(dt)){
                if(!(Character.isDigit(word))){
                    evt.consume();
                    getToolkit().beep();
                    lb.setText("Enter digits only");
                }else{

                    lb.setText(null);
                }
            }else{
                evt.consume();
                lb.setText("Enter only 4 digits Pincode");
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                f.setEchoChar((char)0);
                f.setText(match);
                f.setForeground(new Color(102,102,102));
                f.setCaretPosition(0);
                f.setFont(new Font("Verdana",0,12));
                URL path30=getClass().getResource("/atm_project/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb1.getWidth(),lb1.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb1.setIcon(photo30);
                lb.setText(null);
                seee=0;
            }
        }
}
    private void newpass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass2KeyTyped
        // TODO add your handling code here
       new_pin_effect(evt,newpass2,lb11,newerr2,newpass2.getText(),pin_text2);
    }//GEN-LAST:event_newpass2KeyTyped

    private void newpass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass2KeyPressed
        // TODO add your handling code here:
        if(newpass2.getText().equals(pin_text1)){
            newpass2.setCaretPosition(0);
        }
    }//GEN-LAST:event_newpass2KeyPressed

    private void newpass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newpass2MouseClicked
        // TODO add your handling code here:
        if(newpass2.getText().equals(pin_text2)){
            newpass2.setCaretPosition(0);
        }
        acc=32;
    }//GEN-LAST:event_newpass2MouseClicked

    private void newpass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newpass1MouseClicked
        // TODO add your handling code here:
        if(newpass1.getText().equals(pin_text1)){
            newpass1.setCaretPosition(0);
        }
        acc=31;
    }//GEN-LAST:event_newpass1MouseClicked

    private void newpass1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newpass1MousePressed
        // TODO add your handling code here:
        if(newpass1.getText().equals(pin_text1)){
            newpass1.setCaretPosition(0);
        }
    }//GEN-LAST:event_newpass1MousePressed

    private void newpass2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newpass2MousePressed
        // TODO add your handling code here:
        if(newpass2.getText().equals(pin_text2)){
            newpass2.setCaretPosition(0);
        }
    }//GEN-LAST:event_newpass2MousePressed

    private void pn7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn7MousePressed
        // TODO add your handling code here:
        hover(pn7);
        lb7.setForeground(Color.white);
    }//GEN-LAST:event_pn7MousePressed

    private void pn7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn7MouseReleased
        // TODO add your handling code here:
        pn7.setBackground(color);
        lb7.setForeground(Color.black);
    }//GEN-LAST:event_pn7MouseReleased

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
        hover(jPanel5);
        lb8.setForeground(Color.white);
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseReleased
        // TODO add your handling code here:
        jPanel5.setBackground(color);
        lb8.setForeground(Color.black);
    }//GEN-LAST:event_jPanel5MouseReleased

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        // TODO add your handling code here:
        hover(jPanel6);
        lb9.setForeground(Color.white);
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseReleased
        // TODO add your handling code here:
        jPanel6.setBackground(color);
        lb9.setForeground(Color.black);
    }//GEN-LAST:event_jPanel6MouseReleased

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        // TODO add your handling code here:
        jPanel7.setBackground(Color.red);
    }//GEN-LAST:event_jPanel7MousePressed

    private void jPanel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseReleased
        // TODO add your handling code here:
        jPanel7.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_jPanel7MouseReleased

    private void jPanel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MousePressed
        // TODO add your handling code here:
        hover(jPanel12);
        lb6.setForeground(Color.white);
    }//GEN-LAST:event_jPanel12MousePressed

    private void jPanel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseReleased
        // TODO add your handling code here:
        jPanel12.setBackground(color);
        lb6.setForeground(Color.black);
    }//GEN-LAST:event_jPanel12MouseReleased

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        // TODO add your handling code here:
         hover(jPanel11);
        lb5.setForeground(Color.white);
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseReleased
        // TODO add your handling code here:
        jPanel11.setBackground(color);
        lb5.setForeground(Color.black);
    }//GEN-LAST:event_jPanel11MouseReleased

    private void jPanel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MousePressed
        // TODO add your handling code here:
        hover(jPanel9);
        lb4.setForeground(Color.white);
    }//GEN-LAST:event_jPanel9MousePressed

    private void jPanel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseReleased
        // TODO add your handling code here:
        jPanel9.setBackground(color);
        lb4.setForeground(Color.black);
    }//GEN-LAST:event_jPanel9MouseReleased

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MousePressed
        // TODO add your handling code here:
        hover(jPanel8);
        lb3.setForeground(Color.white);
    }//GEN-LAST:event_jPanel8MousePressed

    private void jPanel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseReleased
        // TODO add your handling code here:
        jPanel8.setBackground(color);
        lb3.setForeground(Color.black);
    }//GEN-LAST:event_jPanel8MouseReleased

    private void jPanel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MousePressed
        // TODO add your handling code here:
        hover(jPanel14);
        lb00.setForeground(Color.white);
    }//GEN-LAST:event_jPanel14MousePressed

    private void jPanel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseReleased
        // TODO add your handling code here:
        jPanel14.setBackground(color);
        lb00.setForeground(Color.black);
    }//GEN-LAST:event_jPanel14MouseReleased

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        // TODO add your handling code here:
        hover(jPanel15);
        lb0.setForeground(Color.white);
    }//GEN-LAST:event_jPanel15MousePressed

    private void jPanel15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseReleased
        // TODO add your handling code here:
        jPanel15.setBackground(color);
        lb0.setForeground(Color.black);
    }//GEN-LAST:event_jPanel15MouseReleased

    private void lb1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MousePressed
        // TODO add your handling code here:
        hover(lb1);
        lb01.setForeground(Color.white);
    }//GEN-LAST:event_lb1MousePressed

    private void lb1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseReleased
        // TODO add your handling code here:
        lb1.setBackground(color);
        lb01.setForeground(Color.black);
    }//GEN-LAST:event_lb1MouseReleased

    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
        // TODO add your handling code here:
        hover(jPanel17);
        lb02.setForeground(Color.white);
    }//GEN-LAST:event_jPanel17MousePressed

    private void jPanel17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseReleased
        // TODO add your handling code here:
        jPanel17.setBackground(color);
        lb02.setForeground(Color.black);
    }//GEN-LAST:event_jPanel17MouseReleased

    private void b10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MouseEntered
        // TODO add your handling code here:
        b10.setToolTipText("Press to perform Balance inquiry task");
    }//GEN-LAST:event_b10MouseEntered

    private void b11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseEntered
        // TODO add your handling code here:
        b11.setToolTipText("Press to perform Bill payment task");
    }//GEN-LAST:event_b11MouseEntered

    private void b12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseEntered
        // TODO add your handling code here:
        b12.setToolTipText("Press to perform Cash Withdraw task");
    }//GEN-LAST:event_b12MouseEntered

    private void bt4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt4MouseEntered
        // TODO add your handling code here:
        bt4.setToolTipText("Press to perform Transfer fund task");
    }//GEN-LAST:event_bt4MouseEntered

    private void bt5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt5MouseEntered
        // TODO add your handling code here:
        bt5.setToolTipText("Press to perform Mini Statement task");
    }//GEN-LAST:event_bt5MouseEntered

    private void bt6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt6MouseEntered
        // TODO add your handling code here:
        bt6.setToolTipText("Press to perform Mobile load task");
    }//GEN-LAST:event_bt6MouseEntered

    private void bt4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt4MousePressed
        // TODO add your handling code here:
        p4.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_bt4MousePressed

    private void bt5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt5MousePressed
        // TODO add your handling code here:
        p5.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_bt5MousePressed

    private void bt6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt6MousePressed
        // TODO add your handling code here:
        p6.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_bt6MousePressed

    private void b12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MousePressed
        // TODO add your handling code here:
        p3.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_b12MousePressed

    private void b11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MousePressed
        // TODO add your handling code here:
        p2.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_b11MousePressed

    private void b10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MousePressed
        // TODO add your handling code here:
        p1.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_b10MousePressed

    private void b10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MouseReleased
        // TODO add your handling code here:
        p1.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_b10MouseReleased

    private void b11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseReleased
        // TODO add your handling code here:
        p2.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_b11MouseReleased

    private void b12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseReleased
        // TODO add your handling code here:
        p3.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_b12MouseReleased

    private void bt4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt4MouseReleased
        // TODO add your handling code here:
        p4.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bt4MouseReleased

    private void bt5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt5MouseReleased
        // TODO add your handling code here:
        p5.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bt5MouseReleased

    private void bt6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt6MouseReleased
        // TODO add your handling code here:
        p6.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bt6MouseReleased

    private void atm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm1MouseClicked
        // TODO add your handling code here:
        if(atm1.getText().equals("Enter reciever atm account")){
            atm1.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm1MouseClicked

    private void atm1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atm1KeyPressed
        // TODO add your handling code here:
        if(atm1.getText().equals("Enter reciever atm account")){
            atm1.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm1KeyPressed

    private void atm1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atm1KeyTyped
        // TODO add your handling code here:
        atm_num_action(evt,atm1,er3,"Enter reciever atm account");
    }//GEN-LAST:event_atm1KeyTyped

    private void atm1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm1MousePressed
        // TODO add your handling code here:
        if(atm1.getText().equals("Enter reciever atm account")){
            atm1.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm1MousePressed

    private void atmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atmMousePressed
        // TODO add your handling code here:
        if(atm1.getText().equals("Enter ATM account number")){
            atm1.setCaretPosition(0);
        }
    }//GEN-LAST:event_atmMousePressed

    private void atm2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm2MouseClicked
        // TODO add your handling code here:
        if(atm2.getText().equals("Enter amount")){
            atm2.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm2MouseClicked

    private void atm2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm2MousePressed
        // TODO add your handling code here:
        if(atm2.getText().equals("Enter amount")){
            atm2.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm2MousePressed

    private void atm2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atm2KeyPressed
        // TODO add your handling code here:
        if(atm2.getText().equals("Enter amount")){
            atm2.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm2KeyPressed

    private void atm2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atm2KeyTyped
        // TODO add your handling code here:
        atm_num_action(evt,atm2,er4,"Enter amount");
    }//GEN-LAST:event_atm2KeyTyped

    private void atm3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm3MouseClicked
        // TODO add your handling code here:
        if(atm3.getText().equals("Enter amount")){
            atm3.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm3MouseClicked

    private void atm3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm3MousePressed
        // TODO add your handling code here:
        if(atm3.getText().equals("Enter amount")){
            atm3.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm3MousePressed

    private void atm3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atm3KeyPressed
        // TODO add your handling code here:
        if(atm3.getText().equals("Enter withdrawal amount")){
            atm3.setCaretPosition(0);
        }
    }//GEN-LAST:event_atm3KeyPressed

    private void atm3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atm3KeyTyped
        // TODO add your handling code here:
        atm_num_action(evt,atm3,er5,"Enter withdrawal amount");
    }//GEN-LAST:event_atm3KeyTyped

    private void bt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt4MouseClicked
        // TODO add your handling code here:
        clear_screen();
        home.setVisible(false);
        transfer.setVisible(true);
        atm1.requestFocus();
        atm1.setCaretPosition(0);
        acc=24;
    }//GEN-LAST:event_bt4MouseClicked
String mail_2;
String re_atm;
String bnk1,name1,title1;
int blnc1;
    private void b15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b15MouseClicked
        // TODO add your handling code here:
        re_atm=atm1.getText();
        if(re_atm.equals(atm_acc)){
            er3.setText("Use different account");
        }else{
            if(db.check_atm_account(re_atm)==true){
             if(db.getAtm_status().equals("Active")){
                 mail_2=db.getEmail();
                 bnk1=db.getBnk();
                 blnc1=db.getBlnc();
                 name1=db.getName();
                 title1=db.getTitle();
                 transfer.setVisible(false);
                 amount.setVisible(true);
                 acc=241;
                 atm2.requestFocus();
                 atm2.setCaretPosition(0);
             }else{
                 JOptionPane.showMessageDialog(this,"This ATM account is blocked","Error",JOptionPane.ERROR_MESSAGE);
             }
             
         }else{
            JOptionPane.showMessageDialog(this,"ATM account not exist","Error",JOptionPane.ERROR_MESSAGE);
         }
        }
    }//GEN-LAST:event_b15MouseClicked

    private void p22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p22MouseClicked
        // TODO add your handling code here:
        if(!"Enter ATM account number".equals(atm.getText())){
        atm_sign();
        }else{
            er2.setText("Enter atm account");
        }
    }//GEN-LAST:event_p22MouseClicked

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
        // TODO add your handling code here:
        if(!"Enter ATM account number".equals(atm.getText())){
        atm_sign();
        }else{
            er2.setText("Enter atm account");
        }
    }//GEN-LAST:event_b3MouseClicked

    private void p21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p21MouseClicked
        // TODO add your handling code here:
        atm.setText("Enter ATM account number");
                    atm.setForeground(new Color(102,102,102));
                    atm.setFont(new Font("Verdana",0,12));
                    atm.setCaretPosition(0);
                    er2.setText(null);
    }//GEN-LAST:event_p21MouseClicked

    private void bt57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt57MouseClicked
        // TODO add your handling code here:
        atm.setText("Enter ATM account number");
                    atm.setForeground(new Color(102,102,102));
                    atm.setFont(new Font("Verdana",0,12));
                    atm.setCaretPosition(0);
                    er2.setText(null);
    }//GEN-LAST:event_bt57MouseClicked

    private void b6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseClicked
        // TODO add your handling code here:
        if(pass1.getText().equals(atm_pass)){
                 acc=2;
                 pass_action=1;
                 pincode.setVisible(false);
                 home.setVisible(true);
        }else if(pass1.getText().equals(new_pass_atm)){
                 acc=31;
                 new_pass_rule=1;
                 pass_action=0;
                 pincode.setVisible(false);
                 new_pass.setVisible(true);
                 newpass1.requestFocus();
                 newpass1.setCaretPosition(0);
                 pin_text1="Enter new Pincode";
                 pin_text2="Enter confirm Pincode";
             }
             else{
                 JOptionPane.showMessageDialog(this,"Invalid Pincode","Error",JOptionPane.ERROR_MESSAGE);
             }
    }//GEN-LAST:event_b6MouseClicked

    private void b5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseClicked
        // TODO add your handling code here:
        mail_send();
        JOptionPane.showMessageDialog(null,"New pincode sent on your email that is linked with your account","Message",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_b5MouseClicked

    private void p25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p25MouseClicked
        // TODO add your handling code here:
        mail_send();
        JOptionPane.showMessageDialog(null,"New pincode sent on your email that is linked with your account","Message",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_p25MouseClicked
void cancle_operation(){
    pass1.setEchoChar((char)0);
        pass1.setText("Enter Pincode");
                pass1.setForeground(new Color(102,102,102));
                pass1.setCaretPosition(0);
                pass1.setFont(new Font("Verdana",0,12));
                URL path30=getClass().getResource("/atm_project/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb2.setIcon(photo30);
                err1.setText(null);
                seee=0;
                acc=0;
                atm_num.setVisible(true);
                pincode.setVisible(false);
                atm.setText("Enter ATM account number");
                atm.setForeground(new Color(102,102,102));
                atm.setFont(new Font("Verdana",0,12));
                atm.setCaretPosition(0);
                er2.setText(null);
                newpass1.setEchoChar((char)0);
                newpass1.setForeground(new Color(102,102,102));
                newpass1.setFont(new Font("Verdana",0,12));
                newpass2.setEchoChar((char)0);
                newpass2.setForeground(new Color(102,102,102));
                newpass2.setFont(new Font("Verdana",0,12));
                lb10.setIcon(photo30);
                lb11.setIcon(photo30);
                newerr1.setText(null);
                newerr2.setText(null);
                newpass1.setText("Enter new Pincode");
                newpass2.setText("Enter confirm Pincode");
}
    private void bt63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt63MouseClicked
        // TODO add your handling code here:
        cancle_operation();
    }//GEN-LAST:event_bt63MouseClicked

    private void p23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p23MouseClicked
        // TODO add your handling code here:
        cancle_operation();
    }//GEN-LAST:event_p23MouseClicked
int new_pass_rule=0;
void pinc_new(){
    newpass1.setEchoChar((char)0);
                newpass1.setText(pin_text1);
                newpass1.setForeground(new Color(102,102,102));
                newpass1.setFont(new Font("Verdana",0,12));
                newpass2.setEchoChar((char)0);
                newpass2.setText(pin_text2);
                newpass2.setForeground(new Color(102,102,102));
                newpass2.setFont(new Font("Verdana",0,12));
                pass1.setEchoChar((char)0);
                pass1.setText("Enter Pincode");
                pass1.setForeground(new Color(102,102,102));
                pass1.setFont(new Font("Verdana",0,12));
                URL path30=getClass().getResource("/atm_project/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb10.getWidth(),lb10.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb10.setIcon(photo30);
                lb11.setIcon(photo30);
                lb2.setIcon(photo30);
                newerr1.setText(null);
                newerr2.setText(null);
                err1.setText(null);
                seee=0;
}
    private void bt69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt69MouseClicked
        // TODO add your handling code here:
        pinc_new();
                if(new_pass_rule==1){
                    pincode.setVisible(true);
                    new_pass.setVisible(false);
                    pass1.requestFocus();
                    pass1.setCaretPosition(0);
                    acc=1;
                }else{
                    home.setVisible(true);
                    new_pass.setVisible(false);
                    acc=2;
                }
                
    }//GEN-LAST:event_bt69MouseClicked

    private void bt69MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt69MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_bt69MouseReleased

void atm_new_pass_change() {
        String pas2 = newpass1.getText();
        String pas3 = newpass2.getText();
        if (newpass1.getText().isEmpty() || newpass2.getText().isEmpty()) {
            if (newpass1.getText().isEmpty()) {
                newerr1.setText("Enter pincode");
            }
            if (newpass2.getText().isEmpty()) {
                newerr2.setText("Enter pincode");
            }
        } else {
            if (pas2.length() == 4) {
                    if (pas3.length()== 4) {
                        if(pas2.equals(pas3)){
                            java.util.Date nowdate = new java.util.Date();
                            String drt = "Hello dear !\nYour Sky Bank ATM account pincode is changed at " + String.valueOf(nowdate);
                            if (db.atm_account_password_update(pas2,atm_acc) == true) {
                               Thread t = new Thread(new Runnable(){
                                public void run(){
                                    if (net() == true) {
                                       em.send(atm_mail, drt, "Security Alert");
                                       }
                                    }
                                });
                                t.start();
                                JOptionPane.showMessageDialog(this, "Passowrd changed successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                                atm_pass=pas2;
                                new_pass.setVisible(false);
                                pincode.setVisible(true);
                                pinc_new();
                                pass1.requestFocus();
                                pass1.setCaretPosition(0);
                                acc=1;
                            }else{
                                newerr2.setText("Pincode not match");
                            }
                            } else {
                                JOptionPane.showMessageDialog(this, "Passowrd not change", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    } else {
                        newerr2.setText("Enter 4 digits pincode");
                    }
            } else {
                    newerr1.setText("Enter 4 digits pincode");
                }
        }
    }
    void atm_pass_change() {
        String pas2 = newpass1.getText();
        String pas3 = newpass2.getText();
        if (newpass1.getText().isEmpty() || newpass2.getText().isEmpty()) {
            if (newpass1.getText().isEmpty()) {
                newerr1.setText("Enter pincode");
            }
            if (newpass2.getText().isEmpty()) {
                newerr2.setText("Enter pincode");
            }
        } else {
            if (pas2.length() == 4) {
            if (db.getPassword_emp(pas2, atm_acc) == true) {
                    if (pas3.length()== 4) {
                            java.util.Date nowdate = new java.util.Date();
                            String drt = "Hello dear !\nYour Sky Bank ATM account pincode is changed at " + String.valueOf(nowdate);
                            if (db.atm_account_password_update(pas3,atm_acc) == true) {
                               Thread t = new Thread(new Runnable(){
                                public void run(){
                                    if (net() == true) {
                                       em.send(atm_mail, drt, "Security Alert");
                                       }
                                    }
                                });
                                t.start();
                                JOptionPane.showMessageDialog(this, "Passowrd changed successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                                new_pass.setVisible(false);
                                home.setVisible(true);
                                acc=2;
                            } else {
                                JOptionPane.showMessageDialog(this, "Passowrd not change", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    } else {
                        newerr2.setText("Enter 4 digits pincode");
                    }
            } else {
                newerr1.setText("Old password did't match");
            }
            } else {
                    newerr1.setText("Enter 4 digits pincode");
                }
        }
    }
    private void b9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseClicked
        // TODO add your handling code here:
        if(new_pass_rule==1){
            atm_new_pass_change();
        }else{
            atm_pass_change();
        }
    }//GEN-LAST:event_b9MouseClicked

    private void p26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p26MouseClicked
        // TODO add your handling code here:
        pinc_new();
                if(new_pass_rule==1){
                    pincode.setVisible(true);
                    new_pass.setVisible(false);
                    pass1.requestFocus();
                    pass1.setCaretPosition(0);
                    acc=1;
                }else{
                    home.setVisible(true);
                    new_pass.setVisible(false);
                    acc=2;
                }
    }//GEN-LAST:event_p26MouseClicked
void new_red(){
    home.setVisible(false);
        new_pass.setVisible(true);
        newpass1.setEchoChar((char)0);
                newpass1.setForeground(new Color(102,102,102));
                newpass1.setFont(new Font("Verdana",0,12));
                newpass2.setEchoChar((char)0);
                newpass2.setForeground(new Color(102,102,102));
                newpass2.setFont(new Font("Verdana",0,12));
                URL path30=getClass().getResource("/atm_project/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb10.getWidth(),lb10.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb10.setIcon(photo30);
                lb11.setIcon(photo30);
                newerr1.setText(null);
                newerr2.setText(null);
                seee=0;
                acc=31;
        newpass1.setText("Enter Old Pincode");
        newpass2.setText("Enter new Pincode");
        newpass1.requestFocus();
        newpass1.setCaretPosition(0);
        pin_text1="Enter Old Pincode";
        pin_text2="Enter new Pincode";
        new_pass_rule=10;
}
    private void bt6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt6MouseClicked
        // TODO add your handling code here:
        new_red();
        
    }//GEN-LAST:event_bt6MouseClicked

    private void b12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        clear_screen();
        cancle_operation();
        atm_num.setVisible(true);
    }//GEN-LAST:event_b12MouseClicked

    private void acc_back(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc_back
        // TODO add your handling code here:
        if(acc==241){
            amount.setVisible(true);
            acc_type.setVisible(false);
            acc=241;
            atm2.requestFocus();
        }else{
            home.setVisible(true);
            acc_type.setVisible(false);
        }
    }//GEN-LAST:event_acc_back

    private void b18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b18MouseClicked
        // TODO add your handling code here:
        if(!"Enter amount".equals(atm2.getText())){
        amount.setVisible(false);
        acc_type.setVisible(true);
        }else{
            er4.setText("Enter amount");
        }
    }//GEN-LAST:event_b18MouseClicked

    private void bt15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt15MouseClicked
        // TODO add your handling code here:
        atm2.setText("Enter amount");
        atm2.setForeground(new Color(102,102,102));
        atm2.setFont(new Font("Verdana",0,12));
        er4.setText(null);
        amount.setVisible(false);
        acc=24;
        transfer.setVisible(true);
        atm1.requestFocus();
    }//GEN-LAST:event_bt15MouseClicked

    private void bt27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt27MouseClicked
        // TODO add your handling code here:
        atm1.setText("Enter reciever atm account");
        atm1.setForeground(new Color(102,102,102));
        atm1.setFont(new Font("Verdana",0,12));
        er3.setText(null);
        transfer.setVisible(false);
        acc=2;
        home.setVisible(true);
    }//GEN-LAST:event_bt27MouseClicked
 void done_sending() {
                    int ot = Integer.parseInt(atm2.getText());
                    if (ot < 100) {
                        JOptionPane.showMessageDialog(this, "Minimum 100 PKR balance required for transection", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (blnc < ot || blnc < 100) {
                            JOptionPane.showMessageDialog(this, "Your Current balance is low", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            int pt=ot;
                            int tex=0;
                            if(ot>5000){
                                ot=ot+20;
                                tex=20;
                            }
                            if (db.money_transection(bnk, blnc - ot) == true && db.money_transection(bnk1, blnc1 + pt) == true) {
                                db.account_histroy(atm_acc, name, name1,re_atm, atm2.getText(), "Transection", bnk, name);
                                db.account_histroy(atm_acc, name, name1, re_atm, atm2.getText(), "Received", bnk1, name1);
                                int bn=blnc - ot;
                                int bn1=blnc + pt;
                                java.util.Date nowdate = new  java.util.Date(); 
                                String drt1=String.valueOf((nowdate));
                                String didf="Your ATM transaction is successful on "+drt1+".\n" +
                                          "Transaction details are given below\n\n" +
                                          "Sender Account Number:  "+atm_acc+"\n" +
                                          "Sender Account Title:  "+title+"\n" +
                                          "Sender Bank Name: SKY Bank Limited Pakistan\n" +
                                          "Transaction to:  SKY Bank Limited Pakistan\n" +
                                          "Receiver's Name: "+name1+"\n" +
                                          "Receiver's Account Number: "+re_atm+"\n" +
                                          "Amount: Rs. "+pt+".00 PKR\n" +
                                          "Fee (Exclusive of tax): "+tex+".00PKR\n" +
                                          "Total Amount:  Rs "+ot+".00 PKR\n"+
                                          "Remaining account Balance: "+bn+".00 PKR"+
                                          "\n\n_______________________________________________\n"+
                                          "\n     Thank you for using SKY Bank Account       \n" +
                                          "_______________________________________________\n";
                                String diif="You have recieved amount RS "+pt+".00 PKR  on "+drt1+
                                          ".\nSender details are given below\n\n" +
                                          "Sender Account Number:  "+atm_acc+"\n" +
                                          "Sender Account Title:  "+title+"\n" +
                                          "Sender Bank Name:  SKY Bank Limited Pakistan\n" +
                                          "Recieved Amount:  Rs "+pt+".00 PKR\n" +
                                          "Current account Balance:  Rs "+bn1+".00 PKR\n"+
                                          "\n_______________________________________________\n"+
                                          "\n     Thank you for using SKY Bank Account       \n" +
                                          "_______________________________________________\n";
                                
                                String didff="\n\t       SKY BANK ATM SERVICE\n" +
                                          " __________________________________________________\n"
                                        + "\n    Your ATM transaction is successful on \n"
                                        + "    "+nowdate+".\n" +
                                          "    Transaction details are given below:\n\n" +
                                          "    Sender Account Number: "+atm_acc+"\n" +
                                          "    Sender Account Title:  "+title+"\n" +
                                          "    Sender Bank Name: SKY Bank Limited Pakistan\n" +
                                          "    Transaction to:  SKY Bank Limited Pakistan\n" +
                                          "    Receiver's Name: "+name1+"\n" +
                                          "    Receiver's Account Number: "+re_atm+"\n" +
                                          "    Amount: Rs. "+pt+".00 PKR\n" +
                                          "    Fee (Exclusive of tax): "+tex+".00PKR\n" +
                                          "    Total Amount:  Rs "+ot+".00 PKR\n"+
                                          "    Remaining account Balance: "+bn+".00 PKR"+
                                          "\n __________________________________________________\n"+
                                          "\n\tThank you for using SKY Bank Account  \n" +
                                          " __________________________________________________\n";
                                Thread t = new Thread(new Runnable(){
                                 public void run(){
                                 if (net() == true) {
                                em.send(atm_mail, didf, "Message Alert ATM Transection");
                                em.send(mail_2, diif, "Message Alert Balance recieved");
                                }
                                 }
                                   });
                                 t.start();
                                 SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
                                 SimpleDateFormat date2=new SimpleDateFormat("hh:mm:ss");
                                 String date=String.valueOf(date1.format(nowdate));
                                 String time=String.valueOf(date2.format(nowdate));
                                 JOptionPane.showMessageDialog(this, "Transection done successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                                 lbb1.setText("From Account : "+atm_a);
                                 lbb2.setText("Beneficiary   : "+name1);
                                 lbb3.setText("To Account   : "+re_atm);
                                 lbb4.setText("Amount  : RS "+ot+".00 PKR");
                                 lbb5.setText("Date : "+date+"   Time : "+time);
                                 blnc=blnc-ot;
                                 jPanel13.setVisible(true);
                                 jPanel3.setVisible(false);
                                 recpt.setText(didff);
                                 reciever.setVisible(false);
                                 recipt.setVisible(true);
                                 
                            }
                        }
                    }
}
    private void b26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b26MouseClicked
        // TODO add your handling code here:
        if(atm_tpy.equals("Current")){
           if(acc==241){
                acc_type.setVisible(false);
                reciever.setVisible(true);
                snd.setText(atm_acc);
                tit.setText(title1);
                rc.setText(re_atm);
                am.setText(atm2.getText()+".00");
            }
            else if(acc==21){//balance details block
                acc_type.setVisible(false);
                balance_details.setVisible(true);
                lbb8.setText("ATM Account : "+atm_a);
                lbb7.setText("Account Title : "+title);
                lbb9.setText("Balance : "+blnc+".00 PKR");
            }
            else if(acc==25){//mini-statement
                mini_statement();
            }
             else if(acc==22){//withdraw balance block
                acc_type.setVisible(false);
                withdraw.setVisible(true);
                atm3.requestFocus();
                atm3.setCaretPosition(0);
            }
        }else{
            JOptionPane.showMessageDialog(this,"Something went wrong","Error",JOptionPane.ERROR_MESSAGE);
            acc_type.setVisible(false);
            cancle_operation();
            clear_screen();
            atm_num.setVisible(true);
        }
    }//GEN-LAST:event_b26MouseClicked

    private void b27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b27MouseClicked
        // TODO add your handling code here:
        if(atm_tpy.equals("Saving")){
             if(acc==241){
                acc_type.setVisible(false);
                reciever.setVisible(true);
                snd.setText(atm_acc);
                tit.setText(title1);
                rc.setText(re_atm);
                am.setText(atm2.getText()+".00");
            }
            else if(acc==21){//balance details block
                acc_type.setVisible(false);
                balance_details.setVisible(true);
                lbb8.setText("ATM Account : "+atm_a);
                lbb7.setText("Account Title : "+title);
                lbb9.setText("Balance : "+blnc+".00 PKR");
            }
            else if(acc==25){//mini-statement
                mini_statement();
            }
             else if(acc==22){//withdraw balance block
                acc_type.setVisible(false);
                withdraw.setVisible(true);
                atm3.requestFocus();
                atm3.setCaretPosition(0);
            }
        }else{
            JOptionPane.showMessageDialog(this,"Something went wrong","Error",JOptionPane.ERROR_MESSAGE);
            acc_type.setVisible(false);
            cancle_operation();
            clear_screen();
            atm_num.setVisible(true);
        }
    }//GEN-LAST:event_b27MouseClicked
void clear_screen(){
    atm1.setText("Enter reciever atm account");
    atm1.setForeground(new Color(102,102,102));
    atm1.setFont(new Font("Verdana",0,12));
    er3.setText(null);
    atm2.setText("Enter amount");
    atm2.setForeground(new Color(102,102,102));
    atm2.setFont(new Font("Verdana",0,12));
    er4.setText(null);
    atm3.setText("Enter withdrawal amount");
    atm3.setForeground(new Color(102,102,102));
    atm3.setFont(new Font("Verdana",0,12));
    er5.setText(null);
}
    private void b21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b21MouseClicked
        // TODO add your handling code here:
        done_sending();
    }//GEN-LAST:event_b21MouseClicked
void rpct(){
    JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(name+" trasection receipt"));
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                File theFileToSave = chooser.getSelectedFile();
                try {
                    BufferedImage img = new BufferedImage(jPanel3.getWidth(), jPanel3.getHeight(), BufferedImage.TYPE_INT_RGB);
                    jPanel3.paint(img.getGraphics());
                    ImageIO.write(img, "png", new File(theFileToSave + ".png"));
                    jPanel3.setOpaque(true);
                    JOptionPane.showMessageDialog(this, "Receipt save successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                    recipt.setVisible(false);
                     home.setVisible(true);
                } catch (HeadlessException | IOException ex) {
                    System.out.print(ex);
                }
            }
        }
}
    private void b24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b24MouseClicked
        // TODO add your handling code here:
        rpct();
    }//GEN-LAST:event_b24MouseClicked

    private void bt21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt21MouseClicked
        // TODO add your handling code here:
        reciever.setVisible(false);
        amount.setVisible(true);
        acc=241;
        atm2.requestFocus();
    }//GEN-LAST:event_bt21MouseClicked

    private void bt33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt33MouseClicked
        // TODO add your handling code here:
        recipt.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_bt33MouseClicked

    private void pass1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass1MousePressed
        // TODO add your handling code here:
        if(pass1.getText().equals("Enter Pincode")){
            pass1.setCaretPosition(0);
        }
        err1.setText(null);
    }//GEN-LAST:event_pass1MousePressed

    private void p9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p9MouseClicked
        // TODO add your handling code here:
        atm2.setText("Enter amount");
        atm2.setForeground(new Color(102,102,102));
        atm2.setFont(new Font("Verdana",0,12));
        er4.setText(null);
        amount.setVisible(false);
        transfer.setVisible(true);
        atm1.requestFocus();
    }//GEN-LAST:event_p9MouseClicked

    private void p10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p10MouseClicked
        // TODO add your handling code here:
        if(!"Enter amount".equals(atm2.getText())){
        amount.setVisible(false);
        acc_type.setVisible(true);
        }else{
            er4.setText("Enter amount");
        }
    }//GEN-LAST:event_p10MouseClicked

    private void p13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p13MouseClicked
        // TODO add your handling code here:
        atm1.setText("Enter reciever atm account");
        atm1.setForeground(new Color(102,102,102));
        atm1.setFont(new Font("Verdana",0,12));
        er3.setText(null);
        transfer.setVisible(false);
        acc=2;
        home.setVisible(true);
    }//GEN-LAST:event_p13MouseClicked

    private void p14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p14MouseClicked
        // TODO add your handling code here:
        re_atm=atm1.getText();
        if(re_atm.equals(atm_acc)){
            er3.setText("Use different account");
        }else{
            if(db.check_atm_account(re_atm)==true){
             if(db.getAtm_status().equals("Active")){
                 acc=1;
                 mail_2=db.getEmail();
                 bnk1=db.getBnk();
                 blnc1=db.getBlnc();
                 name1=db.getName();
                 title1=db.getTitle();
                 transfer.setVisible(false);
                 amount.setVisible(true);
                 acc=241;
                 atm2.requestFocus();
                 atm2.setCaretPosition(0);
             }else{
                 JOptionPane.showMessageDialog(this,"This ATM account is blocked","Error",JOptionPane.ERROR_MESSAGE);
             }
             
         }else{
            JOptionPane.showMessageDialog(this,"ATM account not exist","Error",JOptionPane.ERROR_MESSAGE);
         }
        }
    }//GEN-LAST:event_p14MouseClicked

    private void p8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p8MouseClicked
        // TODO add your handling code here:
        if(atm_tpy.equals("Saving")){
             if(acc==241){
                acc_type.setVisible(false);
                reciever.setVisible(true);
                snd.setText(atm_acc);
                tit.setText(title1);
                rc.setText(re_atm);
                am.setText(atm2.getText());
            }
        }else{
            JOptionPane.showMessageDialog(this,"Something went wrong","Error",JOptionPane.ERROR_MESSAGE);
            acc_type.setVisible(false);
            cancle_operation();
            clear_screen();
            atm_num.setVisible(true);
        }
    }//GEN-LAST:event_p8MouseClicked

    private void p17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p17MouseClicked
        // TODO add your handling code here:
        if(atm_tpy.equals("Current")){
            if(acc==241){
                acc_type.setVisible(false);
                reciever.setVisible(true);
                snd.setText(atm_acc);
                tit.setText(title1);
                rc.setText(re_atm);
                am.setText(atm2.getText());
            }
        }else{
            JOptionPane.showMessageDialog(this,"Something went wrong","Error",JOptionPane.ERROR_MESSAGE);
            acc_type.setVisible(false);
            cancle_operation();
            clear_screen();
            atm_num.setVisible(true);
        }
    }//GEN-LAST:event_p17MouseClicked

    private void p11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p11MouseClicked
        // TODO add your handling code here:
        clear_screen();
        reciever.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_p11MouseClicked

    private void p12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p12MouseClicked
        // TODO add your handling code here:
         done_sending();
    }//GEN-LAST:event_p12MouseClicked

    private void p15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p15MouseClicked
        // TODO add your handling code here:
        rpct();
    }//GEN-LAST:event_p15MouseClicked

    private void p24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p24MouseClicked
        // TODO add your handling code here:
        if(pass1.getText().equals(atm_pass)){
                 acc=2;
                 pass_action=1;
                 pincode.setVisible(false);
                 home.setVisible(true);
             }else if(pass1.getText().equals(new_pass_atm)){
                 acc=31;
                 new_pass_rule=1;
                 pass_action=0;
                 pincode.setVisible(false);
                 new_pass.setVisible(true);
                 newpass1.requestFocus();
                 newpass1.setCaretPosition(0);
                 pin_text1="Enter new Pincode";
                 pin_text2="Enter confirm Pincode";
             }
             else{
                 JOptionPane.showMessageDialog(this,"Invalid Pincode","Error",JOptionPane.ERROR_MESSAGE);
             }
    }//GEN-LAST:event_p24MouseClicked

    private void p27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p27MouseClicked
        // TODO add your handling code here:
        if(new_pass_rule==1){
            atm_new_pass_change();
        }else{
            atm_pass_change();
        }
    }//GEN-LAST:event_p27MouseClicked

    private void p6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p6MouseClicked
        // TODO add your handling code here:
        new_red();
    }//GEN-LAST:event_p6MouseClicked

    private void p3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        clear_screen();
        cancle_operation();
        atm_num.setVisible(true);
        atm.requestFocus();
        atm.setCaretPosition(0);
    }//GEN-LAST:event_p3MouseClicked

    private void p4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4MouseClicked
        // TODO add your handling code here:
        clear_screen();
        home.setVisible(false);
        transfer.setVisible(true);
        atm1.requestFocus();
        atm1.setCaretPosition(0);
        acc=24;
    }//GEN-LAST:event_p4MouseClicked

    private void b10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        acc_type.setVisible(true);
        acc=21;
    }//GEN-LAST:event_b10MouseClicked

    private void b11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseClicked
        // TODO add your handling code here:
        clear_screen();
        home.setVisible(false);
        acc_type.setVisible(true);
        acc=22;
    }//GEN-LAST:event_b11MouseClicked

    
    void mini_statement(){
        try{
        Statement pst = conection.conn().createStatement();
        String sql="select * from history where bnk='"+bnk+"' and se_acc='"+atm_a+"' ORDER by time DESC";
        ResultSet rs = pst.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) st_table.getModel();
        model.setRowCount(0);
        JTableHeader tb = st_table.getTableHeader();
        tb.setBackground(new Color(240,240,240));
        tb.setFont(new java.awt.Font("Tahoma", com.itextpdf.text.Font.BOLD, 12));
        int count=0;
        java.util.Date stdate = new java.util.Date(); 
        String st_date=String.valueOf((stdate));
        card.setText("Card Number : "+atm_a);
        s_date.setText("Date : "+st_date);
        a_bnc.setText("Avail Balance : "+blnc+".00 PKR");
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            TableModel tableModel = st_table.getModel();
            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                st_table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }
        while (rs.next() && count<10) {
            Object[] tbl = {rs.getString("date"), rs.getString("type"), rs.getString("amount")};
            model.addRow(tbl);
           count++; 
        }
        // screeshot
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(name+" Mini-Statement"));
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                File theFileToSave = chooser.getSelectedFile();
                try {
                    BufferedImage img = new BufferedImage(jPanel19.getWidth(), jPanel19.getHeight(), BufferedImage.TYPE_INT_RGB);
                    jPanel19.paint(img.getGraphics());
                    ImageIO.write(img, "png", new File(theFileToSave + ".png"));
                    jPanel19.setOpaque(true);
                    JOptionPane.showMessageDialog(this, "Mini-Statement save successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                    acc_type.setVisible(false);
                     home.setVisible(true);
                } catch (HeadlessException | IOException ex) {
                    System.out.print(ex);
                }
            }
        }
        //end
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    private void bt5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt5MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        acc_type.setVisible(true);
        acc=25;
    }//GEN-LAST:event_bt5MouseClicked

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        acc_type.setVisible(true);
        acc=21;
    }//GEN-LAST:event_p1MouseClicked

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        // TODO add your handling code here:
        clear_screen();
        home.setVisible(false);
        acc_type.setVisible(true);
        acc=22;
    }//GEN-LAST:event_p2MouseClicked

    private void p5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseClicked
        // TODO add your handling code here:
        home.setVisible(false);
        acc_type.setVisible(true);
        acc=25;
    }//GEN-LAST:event_p5MouseClicked

    private void bt51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt51MouseClicked
        // TODO add your handling code here:
        balance_details.setVisible(false);
        home.setVisible(true);
        acc=2;
    }//GEN-LAST:event_bt51MouseClicked

    private void b30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b30MouseClicked
        // TODO add your handling code here:
        int ot = Integer.parseInt(atm3.getText());
                    if (ot < 100) {
                        JOptionPane.showMessageDialog(this, "Minimum 100 PKR balance required for withdrawal", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (blnc < ot || blnc < 100) {
                            JOptionPane.showMessageDialog(this, "Your Current balance is low", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (db.money_transection(bnk, blnc - ot) == true) {
                                db.account_histroy(atm_a, name,"----","----", atm3.getText(), "Withdrawal", bnk, name);
                                java.util.Date nowdate = new java.util.Date(); 
                                String drt1=String.valueOf((nowdate));
                                blnc=blnc-ot;
                                 String dif = "Hy dear "+name+" !..\nYour ATM account No: "+atm_a+" is debited with Rs. "+ot+" on "+drt1+" towards ATM cash withdrawal. Your remaining account balance is Rs. "+blnc+".\nThank you for using SKY Bank Account.";
                                String didff="\n\n\n\t       SKY BANK ATM SERVICE\n\n\n" +
                                          " __________________________________________________\n"
                                        + "\n    ATM Withdrawal is successful on \n"
                                        + "    "+nowdate+".\n" +
                                          "    Withdrawal details are given below:\n\n" +
                                          "    ATM Account Number: "+atm_a+"\n" +
                                          "    Account Title:  "+title+"\n" +
                                          "    Bank Name: SKY Bank Limited Pakistan\n" +
                                          "    Withdraw Amount:  Rs "+ot+".00 PKR\n"+
                                          "    Remaining account Balance: "+blnc+".00 PKR"+
                                          "\n __________________________________________________\n"+
                                          "\n\tThank you for using SKY Bank Account  \n" +
                                          " __________________________________________________\n";
                                Thread t = new Thread(new Runnable(){
                                 public void run(){
                                 if (net() == true) {
                                em.send(atm_mail, dif, "Message Alert ATM Withdraw");
                                }
                                 }
                                   });
                                 t.start();
                                 SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
                                 SimpleDateFormat date2=new SimpleDateFormat("hh:mm:ss");
                                 String date=String.valueOf(date1.format(nowdate));
                                 String time=String.valueOf(date2.format(nowdate));
                                 JOptionPane.showMessageDialog(this, "Withdrawal done successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                                 lbb11.setText("ATM Account : "+atm_acc);
                                 lbb10.setText("Account Title   : "+title);
                                 lbb12.setText("Withdraw Amount  : "+ot+".00 PKR");
                                 lbb13.setText("Date : "+date+"   Time : "+time);
                                 jPanel13.setVisible(true);
                                 jPanel3.setVisible(false);
                                 recpt.setText(didff);
                                 withdraw.setVisible(false);
                                 withdraw_recipt.setVisible(true);
                                 
                            }
                        }
                    }
    }//GEN-LAST:event_b30MouseClicked

    private void bt36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt36MouseClicked
        // TODO add your handling code here:
        withdraw_recipt.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_bt36MouseClicked

    private void p28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_p28MouseClicked

    private void b36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b36MouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(name+" withdrwal receipt"));
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                File theFileToSave = chooser.getSelectedFile();
                try {
                    BufferedImage img = new BufferedImage(jPanel3.getWidth(), jPanel3.getHeight(), BufferedImage.TYPE_INT_RGB);
                    jPanel3.paint(img.getGraphics());
                    ImageIO.write(img, "png", new File(theFileToSave + ".png"));
                    jPanel3.setOpaque(true);
                    JOptionPane.showMessageDialog(this, "Receipt save successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                    clear_screen();
                    withdraw_recipt.setVisible(false);
                     home.setVisible(true);
                } catch (HeadlessException | IOException ex) {
                    System.out.print(ex);
                }
            }
        }
        
    }//GEN-LAST:event_b36MouseClicked

    private void bt45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt45MouseClicked
        // TODO add your handling code here:
        withdraw.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_bt45MouseClicked

    void pass_effect(JPasswordField pass,JLabel lb,String text,String tp){
        if(pass.getText().equals(text)){
                pass.setText(null);
                pass.setEchoChar('•');
                pass.setForeground(Color.black);
                lb.setText(null);
                pass.setFont(new Font("Tahoma",0,18));
                pass.setText(tp);
        }else{
            if(pass.getText().length()<4){
                pass.setText(pass.getText()+tp);
                lb.setText(null);
            }else{
                lb.setText("Enter only 4 digits Pincode");
            }
        }
    }
    void text_field_effect(JTextField fl,JLabel lb,String tp,String text){
        if(fl.getText().equals(text)){
            fl.setForeground(Color.black);
            fl.setFont(new Font("Tahoma",0,18));
           lb.setText(null);
           fl.setText(tp);
        }else{
            fl.setText(fl.getText()+tp);
            lb.setText(null);
        }
    }
    int acc=0;
    String pin_text1;
    String pin_text2;
    void print_num(String tp){
    if(acc==0){
        text_field_effect(atm,er2,tp,"Enter ATM account number");
    }
    else if(acc==1){
        pass_effect(pass1,err1,"Enter Pincode",tp);
    }
    else if(acc==31){
        pass_effect(newpass1,newerr1,pin_text1,tp);
    }
    else if(acc==32){
        pass_effect(newpass2,newerr2,pin_text2,tp);
    }
    if(acc==24){
        text_field_effect(atm1,er3,tp,"Enter reciever atm account");
    }
    if(acc==241){
        text_field_effect(atm2,er4,tp,"Enter amount");
    }
    if(acc==22){
        text_field_effect(atm3,er5,tp,"Enter withdrawal amount");
    }
}void hover(JPanel p){
    color=p.getBackground();
        p.setBackground(new Color(51,0,153));
}int seee=0;
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
            java.util.logging.Logger.getLogger(atm_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(atm_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(atm_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(atm_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new atm_portal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a_bnc;
    private javax.swing.JPanel acc_type;
    private javax.swing.JTextField am;
    private javax.swing.JPanel amount;
    private javax.swing.JTextField atm;
    private javax.swing.JTextField atm1;
    private javax.swing.JTextField atm2;
    private javax.swing.JTextField atm3;
    private javax.swing.JPanel atm_num;
    private javax.swing.JLabel b1;
    private javax.swing.JLabel b10;
    private javax.swing.JLabel b11;
    private javax.swing.JLabel b12;
    private javax.swing.JLabel b13;
    private javax.swing.JLabel b14;
    private javax.swing.JLabel b15;
    private javax.swing.JLabel b16;
    private javax.swing.JLabel b17;
    private javax.swing.JLabel b18;
    private javax.swing.JLabel b19;
    private javax.swing.JLabel b2;
    private javax.swing.JLabel b20;
    private javax.swing.JLabel b21;
    private javax.swing.JLabel b22;
    private javax.swing.JLabel b23;
    private javax.swing.JLabel b24;
    private javax.swing.JLabel b25;
    private javax.swing.JLabel b26;
    private javax.swing.JLabel b27;
    private javax.swing.JLabel b28;
    private javax.swing.JLabel b29;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel b30;
    private javax.swing.JLabel b31;
    private javax.swing.JLabel b32;
    private javax.swing.JLabel b33;
    private javax.swing.JLabel b34;
    private javax.swing.JLabel b35;
    private javax.swing.JLabel b36;
    private javax.swing.JLabel b4;
    private javax.swing.JLabel b5;
    private javax.swing.JLabel b6;
    private javax.swing.JLabel b7;
    private javax.swing.JLabel b8;
    private javax.swing.JLabel b9;
    private javax.swing.JPanel balance_details;
    private javax.swing.JLabel bt13;
    private javax.swing.JLabel bt14;
    private javax.swing.JLabel bt15;
    private javax.swing.JLabel bt19;
    private javax.swing.JLabel bt20;
    private javax.swing.JLabel bt21;
    private javax.swing.JLabel bt25;
    private javax.swing.JLabel bt26;
    private javax.swing.JLabel bt27;
    private javax.swing.JLabel bt31;
    private javax.swing.JLabel bt32;
    private javax.swing.JLabel bt33;
    private javax.swing.JLabel bt34;
    private javax.swing.JLabel bt35;
    private javax.swing.JLabel bt36;
    private javax.swing.JLabel bt37;
    private javax.swing.JLabel bt38;
    private javax.swing.JLabel bt39;
    private javax.swing.JLabel bt4;
    private javax.swing.JLabel bt43;
    private javax.swing.JLabel bt44;
    private javax.swing.JLabel bt45;
    private javax.swing.JLabel bt49;
    private javax.swing.JLabel bt5;
    private javax.swing.JLabel bt50;
    private javax.swing.JLabel bt51;
    private javax.swing.JLabel bt55;
    private javax.swing.JLabel bt56;
    private javax.swing.JLabel bt57;
    private javax.swing.JLabel bt6;
    private javax.swing.JLabel bt61;
    private javax.swing.JLabel bt62;
    private javax.swing.JLabel bt63;
    private javax.swing.JLabel bt67;
    private javax.swing.JLabel bt68;
    private javax.swing.JLabel bt69;
    private javax.swing.JLabel card;
    private javax.swing.JLabel er2;
    private javax.swing.JLabel er3;
    private javax.swing.JLabel er4;
    private javax.swing.JLabel er5;
    private javax.swing.JLabel err1;
    private javax.swing.JPanel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel keypad;
    private javax.swing.JLabel lb0;
    private javax.swing.JLabel lb00;
    private javax.swing.JLabel lb01;
    private javax.swing.JLabel lb02;
    private javax.swing.JPanel lb1;
    private javax.swing.JLabel lb10;
    private javax.swing.JLabel lb11;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lbb1;
    private javax.swing.JLabel lbb10;
    private javax.swing.JLabel lbb11;
    private javax.swing.JLabel lbb12;
    private javax.swing.JLabel lbb13;
    private javax.swing.JLabel lbb2;
    private javax.swing.JLabel lbb3;
    private javax.swing.JLabel lbb4;
    private javax.swing.JLabel lbb5;
    private javax.swing.JLabel lbb7;
    private javax.swing.JLabel lbb8;
    private javax.swing.JLabel lbb9;
    private javax.swing.JLabel main;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel new_pass;
    private javax.swing.JLabel newerr1;
    private javax.swing.JLabel newerr2;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JPasswordField newpass2;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p10;
    private javax.swing.JPanel p11;
    private javax.swing.JPanel p12;
    private javax.swing.JPanel p13;
    private javax.swing.JPanel p14;
    private javax.swing.JPanel p15;
    private javax.swing.JPanel p16;
    private javax.swing.JPanel p17;
    private javax.swing.JPanel p18;
    private javax.swing.JPanel p19;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p20;
    private javax.swing.JPanel p21;
    private javax.swing.JPanel p22;
    private javax.swing.JPanel p23;
    private javax.swing.JPanel p24;
    private javax.swing.JPanel p25;
    private javax.swing.JPanel p26;
    private javax.swing.JPanel p27;
    private javax.swing.JPanel p28;
    private javax.swing.JPanel p29;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel p6;
    private javax.swing.JPanel p7;
    private javax.swing.JPanel p8;
    private javax.swing.JPanel p9;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPanel pincode;
    private javax.swing.JPanel pn7;
    private javax.swing.JTextField rc;
    private javax.swing.JPanel reciever;
    private javax.swing.JPanel recipt;
    private javax.swing.JTextArea recpt;
    private javax.swing.JLabel s_date;
    private javax.swing.JPanel screen;
    private javax.swing.JTextField snd;
    private javax.swing.JTable st_table;
    private javax.swing.JTextField tit;
    private javax.swing.JPanel transfer;
    private javax.swing.JPanel withdraw;
    private javax.swing.JPanel withdraw_recipt;
    // End of variables declaration//GEN-END:variables

    private void title_icon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("t.png")));
    }
}
class ronds extends JPanel {
    protected int strokeSize = 0;
  //  protected Color shadowColor = Color.black;
    protected boolean shady = false;
    protected boolean highQuality =true;
    protected Dimension arcs;
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 0;
    public ronds(int d,int x) {
       super();
       arcs = new Dimension(d, x);
       setOpaque(false);
      }
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       int width = getWidth();
       int height = getHeight();
       int shadowGap = this.shadowGap;
       Graphics2D graphics = (Graphics2D) g;
       if (highQuality) {
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
           RenderingHints.VALUE_ANTIALIAS_ON);
       }
       shadowGap = 1;
       graphics.setColor(getBackground());
       graphics.fillRoundRect(0, 0, width - shadowGap,
       height - shadowGap, arcs.width, arcs.height);
       graphics.setColor(getForeground());
       graphics.setStroke(new BasicStroke(strokeSize));
       graphics.drawRoundRect(0, 0, width - shadowGap,
       height - shadowGap, arcs.width, arcs.height);
       graphics.setStroke(new BasicStroke());
   }
    }