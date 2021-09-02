/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.SplittableRandom;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Amir Ghafoor
 */
public final class login extends javax.swing.JFrame {

    /**
     * Creates new form design
     */
    String email=null,otp=null,mili=null;
    public login() {
        initComponents();
        titleicone();
        Thread t = new Thread(new Runnable(){
         public void run(){
         icon();
        pass1.setEchoChar((char)0);
        pass2.setEchoChar((char)0);
        pass3.setEchoChar((char)0);
        user.requestFocus();
        user.setCaretPosition(0);
        UIManager.put("ToolTip.background", new Color(240,240,240));
         }
         });
        t.start();
    }
    public void lgn(){
        pro.setVisible(false);
        jPanel5.setVisible(true);
    }
account_profile_employee employee=new account_profile_employee();
    database_action database=new database_action();
    fetch_data fth=new fetch_data();
    email em=new email();
    database_conection conection=new database_conection();
    int cun=0;
    int ex=0;
    Timer teem;
     void dashborad_update(){
        teem=new Timer(510, (ActionEvent arg0) -> {
             cun++;
        if(cun==14){
        if(ex!=3 && conection.conn()!=null){
        pro.setVisible(false);
        jPanel5.setVisible(true);
        user.requestFocus();
        user.setCaretPosition(0);
        teem.stop();
         }else{
            if(ex==2){
                jLabel1.setText("Error in loading");
            }
            else if(ex<2){
                jLabel1.setText("Restarting modules");
            }
            if(ex==3){
                JLabel messageLabel = new JLabel("<html><body><p style='width: 220px;'>"+"Due to server error program going to terminate"+"</p></body></html>");
        Timer timr = new Timer(6000, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messageLabel).dispose();
        });
        timr.setRepeats(false);
        timr.start();
         JOptionPane.showOptionDialog(null, messageLabel,"Server connection error", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[]{}, null);
          System.exit(0);
                return;
            }else{
            cun=0;
              ex++;
            }
        }
        }
        lod.setText(lod.getText()+"•");
        if(lod.getText().length()>7){
            lod.setText("");
        }
        });
        teem.start();
    }
    void icon(){
        URL path110=getClass().getResource("/email.png");
        ImageIcon photo110=new ImageIcon(new ImageIcon(path110).getImage().getScaledInstance(lb6.getWidth(),lb6.getHeight(),Image.SCALE_SMOOTH));
        lb6.setIcon(photo110);
       URL path11=getClass().getResource("/pro.png");
        ImageIcon photo11=new ImageIcon(new ImageIcon(path11).getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH));
        lb.setIcon(photo11);
        lb10.setIcon(photo11);
        URL path1=getClass().getResource("/forget.png");
        ImageIcon photo1=new ImageIcon(new ImageIcon(path1).getImage().getScaledInstance(lb1.getWidth(),lb1.getHeight(),Image.SCALE_SMOOTH));
        lb1.setIcon(photo1);
        lb5.setIcon(photo1);
        URL path10=getClass().getResource("/forget.png");
        ImageIcon photo10=new ImageIcon(new ImageIcon(path10).getImage().getScaledInstance(lb3.getWidth(),lb3.getHeight(),Image.SCALE_SMOOTH));
        lb3.setIcon(photo10);
        URL path12=getClass().getResource("/see.png");
        ImageIcon photo=new ImageIcon(new ImageIcon(path12).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),Image.SCALE_SMOOTH));
        lb2.setIcon(photo);
        lb8.setIcon(photo);
        lb9.setIcon(photo);
        URL path13=getClass().getResource("/then.png");
        ImageIcon photo0=new ImageIcon(new ImageIcon(path13).getImage().getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(),Image.SCALE_SMOOTH));
        jLabel2.setIcon(photo0);
        URL path14=getClass().getResource("/bank.png");
        ImageIcon photo2=new ImageIcon(new ImageIcon(path14).getImage().getScaledInstance(main.getWidth(),main.getHeight(),Image.SCALE_SMOOTH));
        main.setIcon(photo2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        main = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        pro = new javax.swing.JPanel();
        ton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lod = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new RoundedPanel(30);
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        jPanel3 = new RoundedPanel(30);
        user = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        jPanel4 = new RoundedPanel(30);
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        err = new javax.swing.JLabel();
        err1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new RoundedPanel(30);
        lb4 = new javax.swing.JLabel();
        confirm = new javax.swing.JTextField();
        jPanel10 = new RoundedPanel(30);
        f66 = new javax.swing.JTextField();
        lb6 = new javax.swing.JLabel();
        jPanel11 = new RoundedPanel(30);
        jLabel12 = new javax.swing.JLabel();
        jPanel14 = new RoundedPanel(30);
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        er = new javax.swing.JLabel();
        er2 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new RoundedPanel(30);
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new RoundedPanel(30);
        lb5 = new javax.swing.JLabel();
        pass3 = new javax.swing.JPasswordField();
        lb9 = new javax.swing.JLabel();
        jPanel18 = new RoundedPanel(30);
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        pass2 = new javax.swing.JPasswordField();
        jPanel19 = new RoundedPanel(30);
        user1 = new javax.swing.JTextField();
        lb10 = new javax.swing.JLabel();
        rr1 = new javax.swing.JLabel();
        err2 = new javax.swing.JLabel();
        err3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(63, 173, 204));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("×");
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 25));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 40, 25));

        jPanel12.setBackground(new java.awt.Color(63, 173, 204));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("–");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 25));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 40, 25));
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 150, 160));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SKY Bank Limited");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 232, 210, 40));

        jLabel10.setFont(new java.awt.Font("MV Boli", 0, 11)); // NOI18N
        jLabel10.setText("@amirghafoor");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 380, 70, 15));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 360, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Secure Bank System");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 9, 160, 15));
        jPanel1.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 15, 15));

        jPanel7.setLayout(new java.awt.CardLayout());

        pro.setBackground(new java.awt.Color(255, 255, 255));
        pro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tenor (3) (3).gif"))); // NOI18N
        pro.add(ton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 140, 150));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Starting modules");
        pro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 120, 20));
        pro.add(lod, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 210, 50, 20));

        jPanel7.add(pro, "card5");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 16, 18));

        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb2MouseEntered(evt);
            }
        });
        jPanel2.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 6, 18, 18));

        pass1.setBackground(new java.awt.Color(240, 240, 240));
        pass1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pass1.setForeground(new java.awt.Color(153, 153, 153));
        pass1.setText("Enter Password");
        pass1.setBorder(null);
        pass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass1FocusGained(evt);
            }
        });
        pass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass1MouseClicked(evt);
            }
        });
        pass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass1KeyTyped(evt);
            }
        });
        jPanel2.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 3, 160, 24));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 110, 250, 30));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setBackground(new java.awt.Color(240, 240, 240));
        user.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        user.setForeground(new java.awt.Color(153, 153, 153));
        user.setText("Enter Username");
        user.setBorder(null);
        user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userFocusGained(evt);
            }
        });
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userKeyTyped(evt);
            }
        });
        jPanel3.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 3, 195, 24));
        jPanel3.add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 22, 18));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 60, 250, 30));

        jPanel4.setBackground(new java.awt.Color(63, 173, 204));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel4MouseReleased(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Login");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 230, 20));

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 170, 250, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Forget Password?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 100, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lgo.JPG"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 100, 30));
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, -1, -1));

        err.setForeground(new java.awt.Color(204, 0, 0));
        jPanel5.add(err, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 230, 20));

        err1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel5.add(err1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 130, 20));

        jPanel7.add(jPanel5, "card2");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 20, 18));

        confirm.setEditable(false);
        confirm.setBackground(new java.awt.Color(255, 255, 255));
        confirm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        confirm.setBorder(null);
        confirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmFocusGained(evt);
            }
        });
        confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmMouseClicked(evt);
            }
        });
        confirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                confirmKeyTyped(evt);
            }
        });
        jPanel9.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 3, 180, 24));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 150, 250, 30));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        f66.setBackground(new java.awt.Color(240, 240, 240));
        f66.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        f66.setForeground(new java.awt.Color(153, 153, 153));
        f66.setText("Enter email");
        f66.setBorder(null);
        f66.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f66FocusGained(evt);
            }
        });
        f66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f66MouseClicked(evt);
            }
        });
        f66.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f66KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f66KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f66KeyTyped(evt);
            }
        });
        jPanel10.add(f66, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 3, 190, 24));
        jPanel10.add(lb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 25, 20));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 60, 250, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel11MouseReleased(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 230, 20));

        jPanel8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 195, 250, 30));

        jPanel14.setBackground(new java.awt.Color(63, 173, 204));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel14MouseReleased(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Send OTP");
        jPanel14.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 230, 20));

        jPanel8.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 105, 250, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Back to Sign In");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 110, 20));

        er.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        er.setForeground(new java.awt.Color(204, 0, 0));
        jPanel8.add(er, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 90, 230, 15));

        er2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        er2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel8.add(er2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 180, 230, 15));

        jPanel7.add(jPanel8, "card3");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(63, 173, 204));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel16MouseReleased(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Submit");
        jPanel16.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 230, 20));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 210, 250, 30));

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel17.add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 16, 18));

        pass3.setBackground(new java.awt.Color(240, 240, 240));
        pass3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        pass3.setForeground(new java.awt.Color(153, 153, 153));
        pass3.setText("Enter new Password");
        pass3.setBorder(null);
        pass3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass3FocusGained(evt);
            }
        });
        pass3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pass3MouseEntered(evt);
            }
        });
        pass3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass3KeyTyped(evt);
            }
        });
        jPanel17.add(pass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 3, 170, 24));

        lb9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb9MouseEntered(evt);
            }
        });
        jPanel17.add(lb9, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 6, 18, 18));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 100, 250, 30));

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel18.add(lb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 20, 18));

        lb8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb8MouseEntered(evt);
            }
        });
        jPanel18.add(lb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 6, 18, 18));

        pass2.setBackground(new java.awt.Color(240, 240, 240));
        pass2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        pass2.setForeground(new java.awt.Color(153, 153, 153));
        pass2.setText("Enter confirm Password");
        pass2.setBorder(null);
        pass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass2FocusGained(evt);
            }
        });
        pass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass2MouseClicked(evt);
            }
        });
        pass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass2KeyTyped(evt);
            }
        });
        jPanel18.add(pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 3, 170, 24));

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 150, 250, 30));

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user1.setBackground(new java.awt.Color(240, 240, 240));
        user1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        user1.setForeground(new java.awt.Color(153, 153, 153));
        user1.setText("Enter your username");
        user1.setBorder(null);
        user1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user1FocusGained(evt);
            }
        });
        user1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user1MouseClicked(evt);
            }
        });
        user1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                user1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user1KeyTyped(evt);
            }
        });
        jPanel19.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 3, 192, 24));
        jPanel19.add(lb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 22, 18));

        jPanel15.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 50, 250, 30));

        rr1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rr1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel15.add(rr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 240, 20));

        err2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        err2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel15.add(err2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 230, 20));

        err3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        err3.setForeground(new java.awt.Color(204, 0, 0));
        jPanel15.add(err3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 230, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 153));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Back to Sign In");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 110, 20));

        jPanel7.add(jPanel15, "card4");

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 310, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyTyped
        // TODO add your handling code here:
        String dt=user.getText();
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals("Enter Username")){
                user.setText(null);
                user.setForeground(Color.black);
                err.setText(null);
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                user.setText("Enter Username");
                user.setForeground(new Color(153,153,153));
                user.setCaretPosition(0);
            }
        }
    }//GEN-LAST:event_userKeyTyped

    private void userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            pass1.requestFocus();
            pass1.setCaretPosition(0);
        }
       else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            if(user.getText().equals("Enter Username")){
                user.setText(null);
                user.setForeground(Color.black);
                err.setText(null);
            }
        }
        else if(user.getText().equals("Enter Username")){
          user.setCaretPosition(0);
        }
    }//GEN-LAST:event_userKeyPressed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        // TODO add your handling code here:
        if(user.getText().equals("Enter Username")){
        user.setCaretPosition(0);
        }
    }//GEN-LAST:event_userMouseClicked

    private void pass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyTyped
        // TODO add your handling code here:
        String dt=pass1.getText();
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals("Enter Password")){
                pass1.setText(null);
                pass1.setEchoChar('•');
                pass1.setForeground(Color.black);
                err1.setText(null);
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                pass1.setEchoChar((char)0);
                pass1.setText("Enter Password");
                pass1.setForeground(new Color(153,153,153));
                pass1.setCaretPosition(0);
                URL path30=getClass().getResource("/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb2.setIcon(photo30);
                seee=0;
            }
        }
    }//GEN-LAST:event_pass1KeyTyped

    private void pass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass1MouseClicked
        // TODO add your handling code here:
        if(pass1.getText().equals("Enter Password")){
        pass1.setCaretPosition(0);
        }
    }//GEN-LAST:event_pass1MouseClicked

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
        // TODO add your handling code here:
        if(!(pass1.getText().equals("Enter Password"))){
            if(seee==0){
                pass1.setEchoChar((char)0);
                URL path30=getClass().getResource("/unsee.jpg");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb2.setIcon(photo30);
                seee=1;
            }
            else if(seee==1){
                pass1.setEchoChar('•');
                URL path30=getClass().getResource("/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb2.setIcon(photo30);
                seee=0;
            }
        }
    }//GEN-LAST:event_lb2MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here
            System.exit(0);
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        // TODO add your handling code here:
        jPanel13.setToolTipText("Close program");
        color = jPanel13.getBackground();
        c = jPanel13.getForeground();
        jLabel11.setForeground(Color.white);
        jPanel13.setBackground(Color.red);
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        // TODO add your handling code here:
        jLabel11.setForeground(c);
        jPanel13.setBackground(color);
    }//GEN-LAST:event_jPanel13MouseExited
String user_mail=null;
    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        // TODO add your handling code here:
        c = jPanel12.getBackground();
        jPanel12.setBackground(new Color(204,204,204));
        jPanel12.setToolTipText("Minimize Program");
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        // TODO add your handling code here:
        jPanel12.setBackground(c);
    }//GEN-LAST:event_jPanel12MouseExited
int xm,ym;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xm=evt.getX();
        ym=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xm, y-ym);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground(Color.blue);
        jLabel6.setForeground(Color.white);
        jLabel6.setFont(new Font("Tahoma",1,14));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(new Color(63,173,204));
        jLabel6.setForeground(Color.black);
        jLabel6.setFont(new Font("Tahoma",0,12));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        jPanel4.setBackground(Color.green);
        jLabel6.setForeground(Color.white);
        jLabel6.setFont(new Font("Tahoma",1,14));
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        // TODO add your handling code here:
        jPanel4.setBackground(new Color(63,173,204));
        jLabel6.setForeground(Color.black);
        jLabel6.setFont(new Font("Tahoma",0,12));
    }//GEN-LAST:event_jPanel4MouseReleased

    private void pass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jPanel4.setBackground(Color.green);
        jLabel6.setForeground(Color.white);
        jLabel6.setFont(new Font("Tahoma",1,14));
        sign();
        }
        else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            if(pass1.getText().equals("Enter Password")){
                pass1.setText(null);
                pass1.setEchoChar('•');
                pass1.setForeground(Color.black);
                err1.setText(null);
            }
        }
        else if(pass1.getText().equals("Enter Password")){
        pass1.setCaretPosition(0);
        }
    }//GEN-LAST:event_pass1KeyPressed

    private void pass1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jPanel4.setBackground(new Color(63,173,204));
        jLabel6.setForeground(Color.black);
        jLabel6.setFont(new Font("Tahoma",0,12));
        }
    }//GEN-LAST:event_pass1KeyReleased
void disbl(){
    jPanel11.setBackground(new Color(255,255,255));
        confirm.setEditable(false);
        confirm.setText(null);
        jPanel9.setBackground(new Color(255,255,255));
        confirm.setBackground(new Color(255,255,255));
        jLabel12.setText("");
        lb4.setIcon(null);
        et=0;
}
    private void f66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f66MouseClicked
        // TODO add your handling code here:
        if(f66.getText().equals("Enter email")){
        f66.setCaretPosition(0);
        }
        
    }//GEN-LAST:event_f66MouseClicked

    private void f66KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f66KeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            if(f66.getText().equals("Enter email")){
                f66.setText(null);
                f66.setForeground(Color.black);
                er.setText(null);
            }
            er.setText(null);
        }
        else if(f66.getText().equals("Enter email")){
        f66.setCaretPosition(0);
        }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jPanel14.setBackground(Color.green);
        jLabel13.setForeground(Color.white);
        jLabel13.setFont(new Font("Tahoma",1,14));
        disbl();
        mail_send();
        }
    }//GEN-LAST:event_f66KeyPressed

    private void f66KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f66KeyTyped
        // TODO add your handling code here:
        String dt=f66.getText();
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals("Enter email")){
                f66.setText(null);
                f66.setForeground(Color.black);
                er.setText(null);
            }
            er.setText(null);
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                f66.setText("Enter email");
                f66.setForeground(new Color(153,153,153));
                f66.setCaretPosition(0);
            }
        }
    }//GEN-LAST:event_f66KeyTyped

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        // TODO add your handling code here:
        if(et==1){
        jPanel11.setBackground(Color.blue);
        jLabel12.setForeground(Color.white);
        jLabel12.setFont(new Font("Tahoma",1,14));
        }
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        // TODO add your handling code here:
        if(et==1){
        jPanel11.setBackground(new Color(63,173,204));
        jLabel12.setForeground(Color.black);
        jLabel12.setFont(new Font("Tahoma",0,12));
        }
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        // TODO add your handling code here:
        if(et==1){
        jPanel11.setBackground(Color.green);
        jLabel12.setForeground(Color.white);
        jLabel12.setFont(new Font("Tahoma",1,14));
        }
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseReleased
        // TODO add your handling code here:
        if(et==1){
        jPanel11.setBackground(new Color(63,173,204));
        jLabel12.setForeground(Color.black);
        jLabel12.setFont(new Font("Tahoma",0,12));
        }
    }//GEN-LAST:event_jPanel11MouseReleased

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        user1.setText("Enter your username");
        pass3.setText("Enter new Password");
        pass2.setText("Enter confirm Password");
        user1.setForeground(new Color(153,153,153));
        pass2.setForeground(new Color(153,153,153));
        pass3.setForeground(new Color(153,153,153));
        rr1.setText(null);
        err2.setText(null);
        err3.setText(null);
        pass3.setEchoChar((char)0);
        pass2.setEchoChar((char)0);
        jPanel11.setBackground(new Color(255,255,255));
        confirm.setText(null);
        confirm.setEditable(false);
        jPanel9.setBackground(new Color(255,255,255));
        confirm.setBackground(new Color(255,255,255));
        f66.setText("Enter email");
        er.setText(null);
        er2.setText(null);
        f66.setForeground(new Color(153,153,153));
        jLabel12.setText("");
        lb4.setIcon(null);
        et=0;
        jPanel5.setVisible(false);
        jPanel8.setVisible(true);
        f66.requestFocus();
        f66.setCaretPosition(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
        jPanel14.setBackground(Color.blue);
        jLabel13.setForeground(Color.white);
        jLabel13.setFont(new Font("Tahoma",1,14));
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
        // TODO add your handling code here:
        jPanel14.setBackground(new Color(63,173,204));
        jLabel13.setForeground(Color.black);
        jLabel13.setFont(new Font("Tahoma",0,12));
    }//GEN-LAST:event_jPanel14MouseExited

    private void jPanel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MousePressed
        // TODO add your handling code here:
        jPanel14.setBackground(Color.green);
        jLabel13.setForeground(Color.white);
        jLabel13.setFont(new Font("Tahoma",1,14));
    }//GEN-LAST:event_jPanel14MousePressed

    private void jPanel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseReleased
        // TODO add your handling code here:
        jPanel14.setBackground(new Color(63,173,204));
        jLabel13.setForeground(Color.black);
        jLabel13.setFont(new Font("Tahoma",0,12));
    }//GEN-LAST:event_jPanel14MouseReleased

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        jLabel14.setForeground(Color.green);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        jLabel14.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        jPanel8.setVisible(false);
        jPanel5.setVisible(true);
        user.setText("Enter Username");
        user.setForeground(new Color(153,153,153));
        pass1.setEchoChar((char)0);
        pass1.setText("Enter Password");
        pass1.setForeground(new Color(153,153,153));
        URL path30=getClass().getResource("/see.png");
        ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        lb2.setIcon(photo30);
        seee=0;
        err.setText(null);
        err1.setText(null);
        user.setCaretPosition(0);
        user.requestFocus();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void f66KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f66KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jPanel14.setBackground(new Color(63,173,204));
        jLabel13.setForeground(Color.black);
        jLabel13.setFont(new Font("Tahoma",0,12));
        }
    }//GEN-LAST:event_f66KeyReleased
int et=0;
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
void mail_send(){
    if(f66.getText().equals("Enter email")){
            er.setText("Enter email account");
        }
        else if(isValidEmailAddress(f66.getText())==false){
            er.setText("Please enter valid email address");
        }
        else if(net()==false){
            JOptionPane.showMessageDialog(this,"Check internet connection","Error",JOptionPane.ERROR_MESSAGE);
        }else{
         if(f66.getText().equals("amirghafoorcss@gmail.com") || database.check_employee(f66.getText(),"mail")==true){
             disbl();
            if(f66.getText().equals("amirghafoorcss@gmail.com")){
                user_mail="amirghafoorcss@gmail.com";
            }else{
               user_mail=database.getPas_con();
            }
             er.setText(null);
             email=f66.getText();
             mili=f66.getText();
             SplittableRandom s1=new SplittableRandom();
         StringBuilder s2=new StringBuilder();
         for(int i=0;i<6;i++){
          s2.append(s1.nextInt(0,10));
          }
           otp=s2.toString();
          //   JOptionPane.showMessageDialog(this,"Your Request is Submit. Please wait");
          String sms_otp="Hello dear,\nYou have submit password change request. Please enter 6 digits OTP code that is : "+otp+"";
        Thread t = new Thread(new Runnable(){
        public void run(){
           em.send(mili,sms_otp,"OTP confirmation");
         }
        });
        t.start();
        JOptionPane.showMessageDialog(this,"6 digits OTP send successfully");
        f66.setText("Enter email");
        f66.setForeground(new Color(153,153,153));
        jPanel14.setBackground(new Color(63,173,204));
        jLabel13.setForeground(Color.black);
        jLabel13.setFont(new Font("Tahoma",0,12));
        enbl();
         }else{
             er.setText("Email not exits in record");
         }
        }
        
}
void enbl(){
    jPanel11.setBackground(new Color(63,173,204));
        et=1;
        confirm.setEnabled(true);
        confirm.setEditable(true);
        confirm.setText("Enter 6 digits OTP code");
        confirm.setForeground(new Color(153,153,153));
        confirm.requestFocus();
        confirm.setCaretPosition(0);
        jPanel9.setBackground(new Color(240,240,240));
        confirm.setBackground(new Color(240,240,240));
        jLabel12.setText("Confirm OTP");
        URL path111=getClass().getResource("/ok.png");
        ImageIcon photo111=new ImageIcon(new ImageIcon(path111).getImage().getScaledInstance(lb4.getWidth(),lb4.getHeight(),Image.SCALE_SMOOTH));
        lb4.setIcon(photo111);
        lb7.setIcon(photo111);
}
    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
        mail_send();
    }//GEN-LAST:event_jPanel14MouseClicked

    private void confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmMouseClicked
        // TODO add your handling code here:
        if(confirm.getText().equals("Enter 6 digits OTP code")){
        confirm.setCaretPosition(0);
        }
    }//GEN-LAST:event_confirmMouseClicked

    private void confirmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmKeyTyped
        // TODO add your handling code here:
        String dt=confirm.getText();
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals("Enter 6 digits OTP code")){
                confirm.setText(null);
                confirm.setText(null);
                confirm.setForeground(Color.black);
                er2.setText(null);
            }
            if(!(Character.isDigit(word))){
                evt.consume();
                getToolkit().beep();
                er2.setText("Enter digits only");
            }else{
                
                er2.setText(null);
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                confirm.setText("Enter 6 digits OTP code");
                confirm.setForeground(new Color(153,153,153));
                confirm.setCaretPosition(0);
            }
        }
    }//GEN-LAST:event_confirmKeyTyped

    private void confirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmKeyPressed
     //TODO add your handling code here:
       if(confirm.getText().equals("Enter 6 digits OTP code")){
        confirm.setCaretPosition(0);
        }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jPanel11.setBackground(Color.green);
        jLabel12.setForeground(Color.white);
        jLabel12.setFont(new Font("Tahoma",1,14));
         String tp=confirm.getText();
        if(tp.equals("")){
            er2.setText("Enter 6 digits OTP code");
        }else{
        if(otp.equals(tp)){
            jPanel11.setBackground(new Color(63,173,204));
           jLabel12.setForeground(Color.black);
           jLabel12.setFont(new Font("Tahoma",0,12));
            JOptionPane.showMessageDialog(this,"OTP matched","Congratulation",JOptionPane.INFORMATION_MESSAGE);
            jPanel8.setVisible(false);
            jPanel15.setVisible(true);
            user1.requestFocus();
            user1.setCaretPosition(0);
        }else{
            er2.setText("OTP not match");
        }
        }
        }
    }//GEN-LAST:event_confirmKeyPressed

    private void confirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jPanel11.setBackground(new Color(63,173,204));
        jLabel12.setForeground(Color.black);
        jLabel12.setFont(new Font("Tahoma",0,12));
        }
    }//GEN-LAST:event_confirmKeyReleased
void sign(){
    if(user.getText().equals("Enter Username") || pass1.getText().equals("Enter Password")){
            if(user.getText().equals("Enter Username")){
                 err.setText("Enter Username");
            }
            if(pass1.getText().equals("Enter Password")){
                err1.setText("Enter password");
            }
        }else{
           if(isValidEmailAddress(user.getText())==true){
            if(fth.getPassword_admin(pass1.getText(),user.getText())==true){
            mess();
            jPanel4.setBackground(new Color(63,173,204));
           jLabel6.setForeground(Color.black);
           jLabel6.setFont(new Font("Tahoma",0,12));
            home p=new home();
            p.setVisible(true);
            this.setVisible(false);
            this.dispose();
         }else{
            JOptionPane.showMessageDialog(this,"Username or Password is Invalid","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        else{
            if(employee.getPassword_emp(pass1.getText(),user.getText())==true){
            employee.emp_account_login_status(user.getText(),"online");
            mess();
            jPanel4.setBackground(new Color(63,173,204));
           jLabel6.setForeground(Color.black);
           jLabel6.setFont(new Font("Tahoma",0,12));
            employee_portal pp=new employee_portal();
            pp.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"Username or Password is Invalid","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        }
}
void mess(){
        JLabel messageLabel = new JLabel("<html><body><p style='width: 90px;'>"+"      Login successfully"+"</p></body></html>");
           Timer timr = new Timer(1000, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messageLabel).dispose();
           });
           timr.setRepeats(false);
           timr.start();
           JOptionPane.showOptionDialog(null, messageLabel,"Welcome", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
    }
public static boolean isValidEmailAddress(String email) {
   try {
      InternetAddress em = new InternetAddress(email);
      em.validate();
      return true;
   } catch (AddressException ex) {
      return false;
   }
}
    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        sign();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFocusGained
        // TODO add your handling code here:
        err.setText(null);
    }//GEN-LAST:event_userFocusGained

    private void pass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass1FocusGained
        // TODO add your handling code here:
        err1.setText(null);
    }//GEN-LAST:event_pass1FocusGained
void pass_change(String tuser){
        String pas1=user1.getText();
        String pas2=pass3.getText();
        String pas3=pass2.getText();
        if(user1.getText().equals("Enter your username") || pass3.getText().equals("Enter new Password") || pass2.getText().equals("Enter confirm Password")){
            if(user1.getText().equals("Enter your username")){
                rr1.setText("Enter Username");
            }
            if(pass3.getText().equals("Enter new Password")){
                err2.setText("Enter new password");
            }
            if(pass2.getText().equals("Enter confirm Password")){
                err3.setText("Enter Confirm password");
            }
        }else{
            if(pas2.length()>=8){
                if(pas3.length()>=8){
                    if(pas2.equals(pas3)){
                    if(user_mail.equals(user1.getText())){
                       if(tuser.equals("admin")){
                           admin_pass();
                       }else{
                           emp_pass();
                       }
                        }else{
                            rr1.setText("Username is not match with email");
                        }
                    }else{
                        err3.setText("Confirm Password not matched");
                    }
                }else{
                    err3.setText("Password lenght must be 8");
                }
            }else{
                err2.setText("Password lenght must be 8");
            }
        }
        }
void emp_pass(){
         Date nowdate = new Date(); 
        String drt="Hello dear, Your Sky Bank account password is changed at "+String.valueOf(nowdate);
        if(employee.emp_account_password_update(String.valueOf(pass3.getPassword()),user1.getText())==true){
        jPanel16.setBackground(new Color(63,173,204));
        jLabel15.setForeground(Color.black);
        jLabel15.setFont(new Font("Tahoma",0,12));
        Thread t = new Thread(new Runnable(){
            public void run(){
                if(net()==true){
                em.send(mili,drt,"Security Alert");
                }
                }
        });
        t.start();
        JOptionPane.showMessageDialog(this,"Passowrd changed successfully","Info",JOptionPane.INFORMATION_MESSAGE);
        user1.setText("Enter your username");
        pass3.setText("Enter new Password");
        pass2.setText("Enter confirm Password");
        jPanel15.setVisible(false);
        jPanel5.setVisible(true);
        user.setText("Enter Username");
        user.setForeground(new Color(153,153,153));
        pass1.setEchoChar((char)0);
        pass1.setText("Enter Password");
        pass1.setForeground(new Color(153,153,153));
        URL path30=getClass().getResource("/see.png");
        ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        lb2.setIcon(photo30);
        seee=0;
        err.setText(null);
        err1.setText(null);
        user.setCaretPosition(0);
        user.requestFocus();
        user.setCaretPosition(0);
        }else{
        JOptionPane.showMessageDialog(this,"Username not exits","Error",JOptionPane.ERROR_MESSAGE);
        user1.requestFocus();
        }
    }
void admin_pass(){
        Date nowdate = new Date(); 
        String drt="Hello dear, Your Sky Bank account password is changed at "+String.valueOf(nowdate);
        if(database.admin_account_password_update(String.valueOf(pass3.getPassword()),user1.getText())==true){
       // JOptionPane.showMessageDialog(this,"Please Wait few seconds","Info",JOptionPane.INFORMATION_MESSAGE);
        jPanel16.setBackground(new Color(63,173,204));
        jLabel15.setForeground(Color.black);
        jLabel15.setFont(new Font("Tahoma",0,12));
        Thread t = new Thread(new Runnable(){
            public void run(){
                if(net()==true){
                em.send(mili,drt,"Security Alert");
                }
                }
        });
        t.start();
        JOptionPane.showMessageDialog(this,"Passowrd changed successfully","Info",JOptionPane.INFORMATION_MESSAGE);
        user1.setText("Enter your username");
        pass3.setText("Enter new Password");
        pass2.setText("Enter confirm Password");
        jPanel15.setVisible(false);
        jPanel5.setVisible(true);
        user.setText("Enter Username");
        user.setForeground(new Color(153,153,153));
        pass1.setEchoChar((char)0);
        pass1.setText("Enter Password");
        pass1.setForeground(new Color(153,153,153));
        URL path30=getClass().getResource("/see.png");
        ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        lb2.setIcon(photo30);
        seee=0;
        err.setText(null);
        err1.setText(null);
        user.setCaretPosition(0);
        user.requestFocus();
        user.setCaretPosition(0);
        }else{
        JOptionPane.showMessageDialog(this,"Username not exits","Error",JOptionPane.ERROR_MESSAGE);
        user1.requestFocus();
        }
    }
    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
        rr1.setText(null);
        err2.setText(null);
        err3.setText(null);
        if(isValidEmailAddress(user1.getText())==true){
        pass_change("admin");
        }else{
        pass_change("emp");
        }
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
        jPanel16.setBackground(Color.blue);
        jLabel15.setForeground(Color.white);
        jLabel15.setFont(new Font("Tahoma",1,14));
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        // TODO add your handling code here:
        jPanel16.setBackground(new Color(63,173,204));
        jLabel15.setForeground(Color.black);
        jLabel15.setFont(new Font("Tahoma",0,12));
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        // TODO add your handling code here:
        jPanel16.setBackground(Color.green);
        jLabel15.setForeground(Color.white);
        jLabel15.setFont(new Font("Tahoma",1,14));
    }//GEN-LAST:event_jPanel16MousePressed

    private void jPanel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseReleased
        // TODO add your handling code here:
        jPanel16.setBackground(new Color(63,173,204));
        jLabel15.setForeground(Color.black);
        jLabel15.setFont(new Font("Tahoma",0,12));
    }//GEN-LAST:event_jPanel16MouseReleased

    private void lb8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb8MouseClicked
        // TODO add your handling code here:
        if(!(pass2.getText().equals("Enter confirm Password"))){
            if(seee==0){
                pass2.setEchoChar((char)0);
                URL path30=getClass().getResource("/unsee.jpg");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb8.setIcon(photo30);
                seee=1;
            }
            else if(seee==1){
                pass2.setEchoChar('•');
                URL path30=getClass().getResource("/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb8.setIcon(photo30);
                seee=0;
            }
        }
    }//GEN-LAST:event_lb8MouseClicked

    private void pass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass2FocusGained
        // TODO add your handling code here:
        err3.setText(null);
    }//GEN-LAST:event_pass2FocusGained

    private void pass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass2MouseClicked
        // TODO add your handling code here:
        if(pass2.getText().equals("Enter confirm Password")){
        pass2.setCaretPosition(0);
        }
        err3.setText(null);
    }//GEN-LAST:event_pass2MouseClicked

    private void pass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jPanel6.setBackground(Color.green);
        jLabel15.setForeground(Color.white);
        jLabel15.setFont(new Font("Tahoma",1,14));
        if(isValidEmailAddress(user1.getText())==true){
        pass_change("admin");
        }else{
        pass_change("emp");
        }
        }
        else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            if(pass2.getText().equals("Enter confirm Password")){
                pass2.setText(null);
                pass2.setEchoChar('•');
                pass2.setForeground(Color.black);
                err3.setText(null);
            }
        }
        else if(pass2.getText().equals("Enter confirm Password")){
        pass2.setCaretPosition(0);
        }
    }//GEN-LAST:event_pass2KeyPressed

    private void pass2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pass2KeyReleased

    private void pass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyTyped
        // TODO add your handling code here:
        String dt=pass2.getText();
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals("Enter confirm Password")){
                pass2.setText(null);
                pass2.setEchoChar('•');
                pass2.setForeground(Color.black);
                err3.setText(null);
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                pass2.setEchoChar((char)0);
                pass2.setText("Enter confirm Password");
                pass2.setForeground(new Color(153,153,153));
                pass2.setCaretPosition(0);
            }
        }
    }//GEN-LAST:event_pass2KeyTyped

    private void pass3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass3FocusGained
        // TODO add your handling code here:
        err2.setText(null);
    }//GEN-LAST:event_pass3FocusGained

    private void pass3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass3MouseClicked
        // TODO add your handling code here:
        if(pass3.getText().equals("Enter new Password")){
        pass3.setCaretPosition(0);
        }
        err2.setText(null);
    }//GEN-LAST:event_pass3MouseClicked

    private void pass3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            pass2.requestFocus();
            pass2.setCaretPosition(0);
        }
        else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            if(pass3.getText().equals("Enter new Password")){
                pass3.setText(null);
                pass3.setEchoChar('•');
                pass3.setForeground(Color.black);
                err2.setText(null);
            }
        }
        else if(pass3.getText().equals("Enter new Password")){
        pass3.setCaretPosition(0);
        }
    }//GEN-LAST:event_pass3KeyPressed

    private void pass3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pass3KeyReleased

    private void pass3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass3KeyTyped
        // TODO add your handling code here:
        String dt=pass3.getText();
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals("Enter new Password")){
                pass3.setText(null);
                pass3.setEchoChar('•');
                pass3.setForeground(Color.black);
                err2.setText(null);
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                pass3.setEchoChar((char)0);
                pass3.setText("Enter new Password");
                pass3.setForeground(new Color(153,153,153));
                pass3.setCaretPosition(0);
            }
        }
    }//GEN-LAST:event_pass3KeyTyped

    private void lb9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb9MouseClicked
        // TODO add your handling code here:
        if(!(pass3.getText().equals("Enter new Password"))){
            if(seee==0){
                pass3.setEchoChar((char)0);
                URL path30=getClass().getResource("/unsee.jpg");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb9.setIcon(photo30);
                seee=1;
            }
            else if(seee==1){
                pass3.setEchoChar('•');
                URL path30=getClass().getResource("/see.png");
                ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
                lb9.setIcon(photo30);
                seee=0;
            }
        }
    }//GEN-LAST:event_lb9MouseClicked

    private void f66FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f66FocusGained
        // TODO add your handling code here:
        er.setText(null);
    }//GEN-LAST:event_f66FocusGained

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        if(et==1){
        String tp=confirm.getText();
        if(tp.equals("")){
            er2.setText("Enter 6 digits OTP code");
        }else{
        if(otp.equals(tp)){
            jPanel11.setBackground(new Color(63,173,204));
        jLabel12.setForeground(Color.black);
        jLabel12.setFont(new Font("Tahoma",0,12));
            JOptionPane.showMessageDialog(this,"OTP matched","Congratulation",JOptionPane.INFORMATION_MESSAGE);
            jPanel8.setVisible(false);
            jPanel15.setVisible(true);
            user1.requestFocus();
            user1.setCaretPosition(0);
        }else{
            er2.setText("OTP not match");
        }
        }
        }
    }//GEN-LAST:event_jPanel11MouseClicked

    private void confirmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmFocusGained
        // TODO add your handling code here:
        er2.setText("");
    }//GEN-LAST:event_confirmFocusGained

    private void user1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user1FocusGained
        // TODO add your handling code here:
        rr1.setText(null);
    }//GEN-LAST:event_user1FocusGained

    private void user1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user1MouseClicked
        // TODO add your handling code here:
        if(user1.getText().equals("Enter your username")){
        user1.setCaretPosition(0);
        }
        rr1.setText(null);
    }//GEN-LAST:event_user1MouseClicked

    private void user1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            pass3.requestFocus();
            pass3.setCaretPosition(0);
        }
        else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            if(user1.getText().equals("Enter your username")){
                user1.setText(null);
                user1.setForeground(Color.black);
                rr1.setText(null);
            }
        }
        else if(user1.getText().equals("Enter your username")){
          user1.setCaretPosition(0);
        }
    }//GEN-LAST:event_user1KeyPressed

    private void user1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user1KeyTyped
        // TODO add your handling code here:
        String dt=user1.getText();
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE || word==KeyEvent.VK_ENTER)){
            if(dt.equals("Enter your username")){
                user1.setText(null);
                user1.setForeground(Color.black);
                rr1.setText(null);
            }
        }
        if(((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            if(dt.length()==0){
                user1.setText("Enter your username");
                user1.setForeground(new Color(153,153,153));
                user1.setCaretPosition(0);
            }
        }
    }//GEN-LAST:event_user1KeyTyped

    private void pass3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pass3MouseEntered

    private void lb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseEntered
        // TODO add your handling code here:
        if(seee==0){
        lb2.setToolTipText("Show Password");
        }else{
            lb2.setToolTipText("Hide Password");
        }
    }//GEN-LAST:event_lb2MouseEntered

    private void lb9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb9MouseEntered
        // TODO add your handling code here:
        if(seee==0){
        lb9.setToolTipText("Show Password");
        }else{
            lb9.setToolTipText("Hide Password");
        }
    }//GEN-LAST:event_lb9MouseEntered

    private void lb8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb8MouseEntered
        // TODO add your handling code here:
        if(seee==0){
        lb8.setToolTipText("Show Password");
        }else{
            lb8.setToolTipText("Hide Password");
        }
    }//GEN-LAST:event_lb8MouseEntered

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        jPanel15.setVisible(false);
        jPanel5.setVisible(true);
        user.setText("Enter Username");
        user.setForeground(new Color(153,153,153));
        pass1.setEchoChar((char)0);
        pass1.setText("Enter Password");
        pass1.setForeground(new Color(153,153,153));
        URL path30=getClass().getResource("/see.png");
        ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(lb2.getWidth(),lb2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        lb2.setIcon(photo30);
        seee=0;
        err.setText(null);
        err1.setText(null);
        user.setCaretPosition(0);
        user.requestFocus();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
        jLabel16.setForeground(Color.green);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
        jLabel16.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel16MouseExited
int seee=0;Color c,color;
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirm;
    private javax.swing.JLabel er;
    private javax.swing.JLabel er2;
    private javax.swing.JLabel err;
    private javax.swing.JLabel err1;
    private javax.swing.JLabel err2;
    private javax.swing.JLabel err3;
    private javax.swing.JTextField f66;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb10;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lod;
    private javax.swing.JLabel main;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JPasswordField pass3;
    private javax.swing.JPanel pro;
    private javax.swing.JLabel rr1;
    private javax.swing.JLabel ton;
    public static javax.swing.JTextField user;
    private javax.swing.JTextField user1;
    // End of variables declaration//GEN-END:variables

    private void titleicone() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("t.png")));
    }
}
class rond extends JProgressBar {
    protected int strokeSize = 0;
    protected Color shadowColor = Color.black;
    protected boolean shady = false;
    protected boolean highQuality =true;
    protected Dimension arcs;
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 0;
    public rond(int d) {
       super();
       arcs = new Dimension(d, d);
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
class RoundedPanel extends JPanel {
    protected int strokeSize = 0;
    protected Color shadowColor = Color.black;
    protected boolean shady = false;
    protected boolean highQuality =true;
    protected Dimension arcs;
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 0;
    public RoundedPanel(int d) {
       super();
       arcs = new Dimension(d, d);
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
