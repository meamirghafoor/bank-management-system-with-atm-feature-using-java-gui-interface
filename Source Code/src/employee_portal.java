
import com.itextpdf.text.BaseColor;
import java.sql.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.SplittableRandom;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.UIManager;

public final class employee_portal extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    int l = 0;
    Timer tm;
    int atm_back = 0;
    int count;
    String change_typ;
    String actn = "", employee_id;
    File path;
    int employeeid;
    String save_type = null;
 public static String emplogin =login.user.getText();
    byte[] mg;
    Color color, c;
    int see = 0;
    int seee = 0;
    int len = 200, o = 0;
    String mal = null;
    String home_name = null;
    int atmvalue = 0, bnkvalue = 0;
    int balance = 0;
    int snbnc = 0, rcbnc = 0;
    int action_pnl = 0;
    String like_s =null;
    String back_rule = null, back_rule2 = null;


    public employee_portal() {
        initComponents();
        icon();
        dashborad_update();
        titleicone();
        UIManager.put("ToolTip.background", new Color(240,240,240));
    }
    account_database_action act = new account_database_action();
    database_conection conect = new database_conection();
    fetch_account_data fth = new fetch_account_data();
    email em=new email();
    account_profile_employee pp = new account_profile_employee();
    JLabel messageLabel = new JLabel("<html><body><p style='width: 150px;'>"+"Please wait...."+"</p></body></html>");
    int cun=0;
    Timer teem;
    void dashborad_update(){
        teem=new Timer(25, (ActionEvent arg0) -> {
             cun++;
        if(cun==10){
        JLabel messageLabel = new JLabel("<html><body><p style='width: 200px;'>"+"Try to connect with database server"+"</p></body></html>");
        Timer timr = new Timer(1800, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messageLabel).dispose();
        });
        timr.setRepeats(false);
        timr.start();
        JOptionPane.showOptionDialog(null, messageLabel,"Message", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
        dashboard();
        show_emp_profile();
        slomo_d();
        slomo();
        if(conect.conn()!=null){
        JLabel messagelabel = new JLabel("<html><body><p style='width: 200px;'>"+"Database Server connected successfully"+"</p></body></html>");
        Timer tmr = new Timer(1000, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messagelabel).dispose();
        });
        tmr.setRepeats(false);
        tmr.start();
        JOptionPane.showOptionDialog(null, messagelabel,"Congratulations", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
         }
        teem.setRepeats(false);
         }
        });
        teem.start();
    }
    boolean net() {
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
int cont=0;
    void slomo_d(){
    Thread t = new Thread(new Runnable(){
        public void run(){
                Timer tem=new Timer(1000, (ActionEvent arg0) -> {
                cont++;
                if(cont>5){
                dashboard();
                cont=0;
            }
            });
        tem.start();
        }
     });
    t.start();  
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

    void check_balance(String acc) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            quiry = "SELECT * FROM accounts WHERE bank_acc='" + acc + "'";
            ResultSet rs = pst.executeQuery(quiry);
            if (rs.next()) {
                bnc1.setText(rs.getString("title"));
                bnc2.setText(rs.getString("bank_acc"));
                bnc3.setText(String.valueOf(rs.getInt("blnc"))+".00 PKR");
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    void check_deposit_details(String acc) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            quiry = "SELECT * FROM accounts WHERE bank_acc='" + acc + "'";
            ResultSet rs = pst.executeQuery(quiry);
            if (rs.next()) {
                dp1.setText(rs.getString("title"));
                dp2.setText(rs.getString("bank_acc"));
                email_acc=rs.getString("email");
                snbnc = rs.getInt("blnc");
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    void sender_money_details(String acc) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            quiry = "SELECT * FROM accounts WHERE bank_acc='" + acc + "'";
            ResultSet rs = pst.executeQuery(quiry);
            if (rs.next()) {
                sn1.setText(rs.getString("title"));
                sn2.setText(rs.getString("bank_acc"));
                email_acc=rs.getString("email");
                snbnc = rs.getInt("blnc");
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
String email_acc;
    void withdraw_money_details(String acc) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            quiry = "SELECT * FROM accounts WHERE bank_acc='" + acc + "'";
            ResultSet rs = pst.executeQuery(quiry);
            if (rs.next()) {
                wth1.setText(rs.getString("title"));
                wth2.setText(rs.getString("bank_acc"));
                email_acc=rs.getString("email");
                snbnc = rs.getInt("blnc");
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
String email_acc1;
    void receiver_money_details(String acc) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            quiry = "SELECT * FROM accounts WHERE bank_acc='" + acc + "'";
            ResultSet rs = pst.executeQuery(quiry);
            if (rs.next()) {
                rc1.setText(rs.getString("title"));
                rc2.setText(rs.getString("bank_acc"));
                email_acc1=rs.getString("email");
                rcbnc = rs.getInt("blnc");
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    private void titleicone() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("t.png")));
    }

    class LebelRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }

    void atm_account_datils(String type, String ser, String likee,String st,String end) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            if ("all".equals(type)) {
                quiry = "SELECT * FROM accounts";
            }
            if ("active".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE atm_status='Active'";
            }
            if ("block".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE atm_status='Block'";
            }
            if ("like".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE name LIKE '%" + ser + "%'";
            }
            if ("date".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE atm_join BETWEEN '"+st+"' AND '"+end+"'";
            }
            if("date_s".equals(type)){
                quiry="SELECT * FROM accounts WHERE name LIKE'%"+ser+"%' AND atm_join BETWEEN '"+st+"' AND '"+end+"'";
            }
            ResultSet rs = pst.executeQuery(quiry);
            atm_table.setRowHeight(60);
            DefaultTableModel model = (DefaultTableModel) atm_table.getModel();
            model.setRowCount(0);
            atm_table.getColumnModel().getColumn(0).setPreferredWidth(40);
            atm_table.getColumnModel().getColumn(1).setPreferredWidth(145);
            atm_table.getColumnModel().getColumn(2).setPreferredWidth(140);
            atm_table.getColumnModel().getColumn(3).setPreferredWidth(110);
            atm_table.getColumnModel().getColumn(4).setPreferredWidth(65);
            atm_table.getColumnModel().getColumn(5).setPreferredWidth(150);
            atm_table.getColumnModel().getColumn(6).setPreferredWidth(80);
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            TableModel tableModel = atm_table.getModel();
            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                atm_table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }
            JTableHeader tb = atm_table.getTableHeader();
            tb.setBackground(new Color(153, 153, 255));
            tb.setFont(new java.awt.Font("Tahoma", Font.BOLD, 13));
            byte[] im;
            int i = 1;
            if(likee.equals("not")){
                return;
            }
            while (rs.next()) {
                String str = rs.getString("atm_acc");
                String str3 = rs.getString("atm_status");
                if ("like".equals(type) || "date".equals(type) || "date_s".equals(type)) {
                    if (!"Not Registered".equals(str)) {
                        JLabel lb = new JLabel();
                        im = rs.getBytes("image");
                        ImageIcon mgi = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
                        lb.setIcon(mgi);
                        if (str3.equals("Active") && likee.equals("a")) {
                            Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("atm_acc"), rs.getString("atm_status"), rs.getString("cnic"), lb};
                            model.addRow(tbl);
                            atm_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                            i = i + 1;
                        }
                        if (str3.equals("Block") && likee.equals("b")) {
                            Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("atm_acc"), rs.getString("atm_status"), rs.getString("cnic"), lb};
                            model.addRow(tbl);
                            atm_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                            i = i + 1;
                        }
                        if (likee.equals("all")) {
                            Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("atm_acc"), rs.getString("atm_status"), rs.getString("cnic"), lb};
                            model.addRow(tbl);
                            atm_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                            i = i + 1;
                        }
                    }
                }else{
                  if (!"Not Registered".equals(str)) {
                        JLabel lb = new JLabel();
                        im = rs.getBytes("image");
                        ImageIcon mgi = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
                        lb.setIcon(mgi);
                        Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("atm_acc"), rs.getString("atm_status"), rs.getString("cnic"), lb};
                        model.addRow(tbl);
                        atm_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                        i = i + 1;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    void account_history_datils(String type, String bnk, String ser,String st,String end) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            if ("all".equals(type)) {
                quiry = "SELECT * FROM history";
            }
            if ("deposit".equals(type)) {
                quiry = "SELECT * FROM history WHERE type='Deposit'";
            }
            if ("withdraw".equals(type)) {
                quiry = "SELECT * FROM history WHERE type='Withdrawal'";
            }
            if ("like".equals(type)) {
                quiry = "SELECT * FROM history WHERE name LIKE '%" + ser + "%'";
            }
            if ("date".equals(type)) {
                quiry = "SELECT * FROM history WHERE date BETWEEN '"+st+"' AND '"+end+"'";
            }
            if("date_s".equals(type)){
                quiry="SELECT * FROM history WHERE name LIKE'%"+ser+"%' AND date BETWEEN '"+st+"' AND '"+end+"'";
            }
            ResultSet rs = pst.executeQuery(quiry);
            bnc_history.setRowHeight(40);
            DefaultTableModel model = (DefaultTableModel) bnc_history.getModel();
            model.setRowCount(0);
            bnc_history.getColumnModel().getColumn(0).setPreferredWidth(35);
            bnc_history.getColumnModel().getColumn(1).setPreferredWidth(130);
            bnc_history.getColumnModel().getColumn(2).setPreferredWidth(135);
            bnc_history.getColumnModel().getColumn(3).setPreferredWidth(205);
            bnc_history.getColumnModel().getColumn(4).setPreferredWidth(95);
            bnc_history.getColumnModel().getColumn(5).setPreferredWidth(90);
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            TableModel tableModel = bnc_history.getModel();
            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                bnc_history.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }
            JTableHeader tb = bnc_history.getTableHeader();
            tb.setBackground(new Color(153, 153, 255));
            tb.setFont(new java.awt.Font("Tahoma", Font.BOLD, 13));
            byte[] im;
            int i = 1;
            while (rs.next()) {
                String tit = rs.getString("name");
                String accoun_bnk = rs.getString("bnk");
                if (type.equals("deposit")) {
                    hit1.setText("Deposit history");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (type.equals("withdraw")) {
                    hit1.setText("Withdrawal history");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (type.equals("all")) {
                    hit1.setText("All accounts history");
                    String tpy = rs.getString("type");
                    if (tpy.equals("Received")) {
                        Object[] tbl = {i, rs.getString("re_name"), rs.getString("re_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                        model.addRow(tbl);
                        i++;
                    } else {
                        Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                        model.addRow(tbl);
                        i++;
                    }
                }
                if (type.equals("like") || type.equals("date_s") || type.equals("date")) {
                    String tpy = rs.getString("type");
                    if (tpy.equals("Deposit") && bnk.equals("d")) {
                        Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                        model.addRow(tbl);
                        i++;
                    }
                    if (tpy.equals("Withdrawal") && bnk.equals("w")) {
                        Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                        model.addRow(tbl);
                        i++;
                    }
                    if (bnk.equals("all")) {
                        if (tpy.equals("Received")) {
                            Object[] tbl = {i, rs.getString("re_name"), rs.getString("re_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                            model.addRow(tbl);
                            i++;
                        } else {
                            Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                            model.addRow(tbl);
                            i++;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    void account_history_datils_search(String typ, String bnk,String st,String end,String tp) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry=null;
            if(tp.equals("date")){
                 quiry = "SELECT * FROM history WHERE date BETWEEN '"+st+"' AND '"+end+"'";
            }else{
                quiry = "SELECT * FROM history WHERE bnk='" + bnk + "'";
            }  
            ResultSet rs = pst.executeQuery(quiry);
            bnc_history1.setRowHeight(40);
            DefaultTableModel model = (DefaultTableModel) bnc_history1.getModel();
            model.setRowCount(0);
            bnc_history1.getColumnModel().getColumn(0).setPreferredWidth(35);
            bnc_history1.getColumnModel().getColumn(1).setPreferredWidth(135);
            bnc_history1.getColumnModel().getColumn(2).setPreferredWidth(135);
            bnc_history1.getColumnModel().getColumn(3).setPreferredWidth(205);
            bnc_history1.getColumnModel().getColumn(4).setPreferredWidth(95);
            bnc_history1.getColumnModel().getColumn(5).setPreferredWidth(90);
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            TableModel tableModel = bnc_history1.getModel();
            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                bnc_history1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }
            JTableHeader tb = bnc_history1.getTableHeader();
            tb.setBackground(new Color(153, 153, 255));
            tb.setFont(new java.awt.Font("Tahoma", Font.BOLD, 13));
            int i = 1;
            while (rs.next()) {
                String tit = rs.getString("name");
                String accoun_bnk = rs.getString("bnk");
                String ty = rs.getString("type");
                if(tp.equals("date")){
                    if(accoun_bnk.equals(bnk)){
                    if (typ.equals("dep") && ty.equals("Deposit")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Account No");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (typ.equals("with") && ty.equals("Withdrawal")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Account No");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (typ.equals("get") && ty.equals("Received")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Sender name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Sender Account");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (typ.equals("send") && ty.equals("Transection")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Receiver name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Receiver Account");
                    Object[] tbl = {i, rs.getString("re_name"), rs.getString("re_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                    }
                }else{
                tr1.setText(tit);
                tr2.setText(accoun_bnk);
                if (typ.equals("dep") && ty.equals("Deposit")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Account No");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (typ.equals("with") && ty.equals("Withdrawal")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Account No");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (typ.equals("get") && ty.equals("Received")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Sender name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Sender Account");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                if (typ.equals("send") && ty.equals("Transection")) {
                    bnc_history1.getColumnModel().getColumn(1).setHeaderValue("Receiver name");
                    bnc_history1.getColumnModel().getColumn(2).setHeaderValue("Receiver Account");
                    Object[] tbl = {i, rs.getString("re_name"), rs.getString("re_acc"), rs.getString("time"), rs.getString("type"), rs.getString("amount")};
                    model.addRow(tbl);
                    i++;
                }
                }
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    void bank_account_datils(String type, String ser, String lik,String st,String end) {
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            if ("block".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE bank_status='Block'";
            }
            if ("current".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE acc_type='Current'";
            }
            if ("saving".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE acc_type='Saving'";
            }
            if ("like".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE name LIKE '%" + ser + "%'";
            }
            if ("date".equals(type)) {
                quiry = "SELECT * FROM accounts WHERE join_date BETWEEN '"+st+"' AND '"+end+"'";
            }
            if("date_s".equals(type)){
                quiry="SELECT * FROM accounts WHERE name LIKE'%"+ser+"%' AND join_date BETWEEN '"+st+"' AND '"+end+"'";
            }
            ResultSet rs = pst.executeQuery(quiry);
            accounts_table.setRowHeight(60);
            DefaultTableModel model = (DefaultTableModel) accounts_table.getModel();
            model.setRowCount(0);
            accounts_table.getColumnModel().getColumn(0).setPreferredWidth(40);
            accounts_table.getColumnModel().getColumn(1).setPreferredWidth(145);
            accounts_table.getColumnModel().getColumn(2).setPreferredWidth(140);
            accounts_table.getColumnModel().getColumn(3).setPreferredWidth(110);
            accounts_table.getColumnModel().getColumn(4).setPreferredWidth(65);
            accounts_table.getColumnModel().getColumn(5).setPreferredWidth(150);
            accounts_table.getColumnModel().getColumn(6).setPreferredWidth(80);
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            TableModel tableModel = accounts_table.getModel();
            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                accounts_table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }
            JTableHeader tb = accounts_table.getTableHeader();
            tb.setBackground(new Color(153, 153, 255));
            tb.setFont(new java.awt.Font("Tahoma", Font.BOLD, 13));
            byte[] im;
            int i = 1;
            while (rs.next()) {
                String tpy = rs.getString("acc_type");
                String tpy1 = rs.getString("bank_status");
                if ("like".equals(type) || "date".equals(type) || "date_s".equals(type) ) {
                   
                     JLabel lb = new JLabel();
                    im = rs.getBytes("image");
                    ImageIcon mgi = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
                    lb.setIcon(mgi);
                    if (lik.equals("c") && tpy.equals("Current")) {
                        Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("acc_type"), rs.getString("bank_status"), rs.getString("cnic"), lb};
                        model.addRow(tbl);
                        accounts_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                        i = i + 1;
                    }
                    if (lik.equals("s") && tpy.equals("Saving")) {
                        Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("acc_type"), rs.getString("bank_status"), rs.getString("cnic"), lb};
                        model.addRow(tbl);
                        accounts_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                        i = i + 1;
                    }
                    if (lik.equals("b") && tpy1.equals("Block")) {
                        Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("acc_type"), rs.getString("bank_status"), rs.getString("cnic"), lb};
                        model.addRow(tbl);
                        accounts_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                        i = i + 1;
                    }
                }else{
                     JLabel lb = new JLabel();
                    im = rs.getBytes("image");
                    ImageIcon mgi = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
                    lb.setIcon(mgi);
                    Object[] tbl = {i, rs.getString("name"), rs.getString("bank_acc"), rs.getString("acc_type"), rs.getString("bank_status"), rs.getString("cnic"), lb};
                    model.addRow(tbl);
                    accounts_table.getColumnModel().getColumn(6).setCellRenderer(new LebelRenderer());
                    i = i + 1;
                }
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    void account_data_all(String data, String type) {
        fth.papulate_data(data, type);
        m1j.setText(fth.getBnk_acc());
        m16o.setText(fth.getAtm_acc());
        m2b.setText(fth.getBnk_status());
        m3j.setText(fth.getName());
        m4p.setText(fth.getDat());
        m5o.setText(fth.getFaher());
        m6i.setText(fth.getCnic());
        m7t.setText(fth.getMail());
        m10v.setText(fth.getAcc_type());
        m15t.setText(fth.getAddress());
        m8y.setText(fth.getPostal());
        m11i.setText(fth.getGender());
        m12y.setText(fth.getContect());
        m17n.setText(fth.getTitle());
        m13o.setText(fth.getAtm_status());
        m9o.setText(fth.getJoindate());
        atm_date.setText(fth.getAtm_date());
        ImageIcon mig = new ImageIcon(new ImageIcon(fth.getImage()).getImage().getScaledInstance(pics1k.getWidth(), pics1k.getHeight(), java.awt.Image.SCALE_SMOOTH));
        pics1k.setIcon(mig);
    }
void dashboard() {
                d1_l17.setText(act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Active'"));//
                d1_l20.setText(act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Block'"));//
                d1_l11.setText(act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE bank_status='Block'"));///
                String curr=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Current'");
                d1_l1.setText(curr);//
                d1_l5.setText(curr);///
                String atm_s=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Block' OR atm_status='Active'");
                d2_l1.setText(atm_s);//home
                d1_l14.setText(atm_s);//
                String sav_acc=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Saving'");
                d3_l1.setText(sav_acc);//
                d1_l8.setText(sav_acc);////
                String b_balance=act.dashboad_value("SELECT SUM(blnc) as total FROM accounts");
                d7_l1.setText(b_balance+".00");//home
                d7_l51.setText(b_balance+".00");//
                String d_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Deposit'");
                d8_l1.setText(d_balance+".00");//home
                d8_l5.setText(d_balance+".00");//
                String w_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Withdrawal'");
                d9_l1.setText(w_balance+".00");//home
                d9_l5.setText(w_balance+".00");
    }
    void search_account_data(String data, String type) {
        fth.papulate_data(data, type);
        s1f.setText(fth.getBnk_acc());
        s13f.setText(fth.getAtm_acc());
        s2f.setText(fth.getBnk_status());
        s3f.setText(fth.getName());
        s4zf.setText(fth.getDat());
        s5f.setText(fth.getFaher());
        s6f.setText(fth.getCnic());
        s7f.setText(fth.getMail());
        s8f.setText(fth.getAcc_type());
        s9cf.setText(fth.getAddress());
        s10sf.setText(fth.getPostal());
        s15sf.setText(fth.getGender());
        s12af.setText(fth.getContect());
        s16f.setText(fth.getTitle());
        s17df.setText(fth.getAtm_status());
        joindatek.setText(fth.getJoindate());
        atm_date1.setText(fth.getAtm_date());
        ImageIcon mig = new ImageIcon(new ImageIcon(fth.getImage()).getImage().getScaledInstance(picsff.getWidth(), picsff.getHeight(), java.awt.Image.SCALE_SMOOTH));
        picsff.setIcon(mig);
    }

    void search_update_acc_data(String data, String type) {
        fth.papulate_data(data, type);
        employee_id = fth.getBnk_acc();
        u1.setText(fth.getName());
        u2.setText(fth.getFaher());
        u3.setDate(fth.getDob());
        change_typ = fth.getAcc_type();
        u4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{fth.getAcc_type(), "Saving", "Current"}));
        u8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{fth.getGender(), "Male", "Female"}));
        u5.setText(fth.getCnic());
        u6.setText(fth.getMail());
        u7.setText(fth.getPostal());
        u12.setText(fth.getAddress());
        u9.setText(fth.getContect());
        u13.setText(fth.getTitle());
        String v1 = u4.getSelectedItem().toString();
        if (v1.equals("Saving")) {
            u13.setEditable(false);
        }
        mg = fth.getImage();
        ImageIcon pho = new ImageIcon(new ImageIcon(mg).getImage().getScaledInstance(upic.getWidth(), upic.getHeight(), java.awt.Image.SCALE_SMOOTH));
        upic.setIcon(pho);
    }
void update_value(){
    try {
            Statement pst = conect.conn().createStatement();
            String qury = "SELECT * FROM strength WHERE id='1'";
            ResultSet rs = pst.executeQuery(qury);
            if(rs.next()){
            atmvalue = rs.getInt("acc_atm");
            bnkvalue = rs.getInt("acc_bank");
            }
    }catch(SQLException e){
        System.out.print(e);
    }
}
    void dashboraddat() {
       d1_l17.setText(act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Active'"));//
                d1_l20.setText(act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Block'"));//
                d1_l11.setText(act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE bank_status='Block'"));///
                String curr=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Current'");
                d1_l1.setText(curr);//
                d1_l5.setText(curr);///
                String atm_s=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Block' OR atm_status='Active'");
                d2_l1.setText(atm_s);//home
                d1_l14.setText(atm_s);//
                String sav_acc=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Saving'");
                d3_l1.setText(sav_acc);//
                d1_l8.setText(sav_acc);////
                String b_balance=act.dashboad_value("SELECT SUM(blnc) as total FROM accounts");
                d7_l1.setText(b_balance+".00");//home
                d7_l51.setText(b_balance+".00");//
                String d_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Deposit'");
                d8_l1.setText(d_balance+".00");//home
                d8_l5.setText(d_balance+".00");//
                String w_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Withdrawal'");
                d9_l1.setText(w_balance+".00");//home
                d9_l5.setText(w_balance+".00");
    }

    String auto_bank_accounts() {
        String acc = null;
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            quiry = "SELECT acc_bank FROM strength WHERE id='1'";
            ResultSet rs = pst.executeQuery(quiry);
            if (rs.next()) {
                bnkvalue = rs.getInt("acc_bank");
                bnkvalue = bnkvalue + 1;
                acc = "PKR1082" + String.valueOf(bnkvalue);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        return acc;
    }

    String auto_atm_accounts() {
        String acc = null;
        try {
            Statement pst = conect.conn().createStatement();
            String quiry = null;
            quiry = "SELECT acc_atm FROM strength WHERE id='1'";
            ResultSet rs = pst.executeQuery(quiry);
            if (rs.next()) {
                atmvalue = rs.getInt("acc_atm");
                atmvalue = atmvalue + 1;
                acc = "928974" + String.valueOf(atmvalue);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        return acc;
    }

    void slomo() {
        Thread t = new Thread(new Runnable(){
        public void run(){  
        String text = "Hello dear, " + home_name + " !!";
        l = text.length();
        tm = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                count++;
                if (count > l) {
                    slo.setText("");
                    count = 0;
                } else {
                    slo.setText(text.substring(0, count));
                }
            }

        });
        tm.start();
            }
        });
        t.start();
    }

    void show_emp_profile() {
        pp.employee_profile(emplogin);
        em1.setText(pp.getId());
        em2.setText(pp.getName());
        home_name = pp.getName();
        em3.setText(pp.getDob());
        em4.setText(pp.getFather());
        em5.setText(pp.getCinc());
        em6.setText(pp.getEmail());
        em7.setText(pp.getPostalcode());
        em8.setText(pp.getJoin());
        em9.setText(pp.getMarital());
        em10.setText(pp.getGen());
        em11.setText(pp.getContect());
        em12.setText(pp.getEdu());
        em13.setText(pp.getIncom());
        em14.setText(pp.getAddress());
        ImageIcon ph = new ImageIcon(new ImageIcon(pp.getImage()).getImage().getScaledInstance(empic.getWidth(), empic.getHeight(), java.awt.Image.SCALE_SMOOTH));
        ImageIcon photo2 = new ImageIcon(new ImageIcon(pp.getImage()).getImage().getScaledInstance(profile.getWidth(), profile.getHeight(), java.awt.Image.SCALE_SMOOTH));
        profile.setIcon(photo2);
        empic.setIcon(ph);
    }

    void icon() {
        URL path50 = getClass().getResource("/sendico.png");
        ImageIcon photo50 = new ImageIcon(new ImageIcon(path50).getImage().getScaledInstance(sender.getWidth(), sender.getHeight(), java.awt.Image.SCALE_SMOOTH));
        sender.setIcon(photo50);
        sender1.setIcon(photo50);
        sender2.setIcon(photo50);
        sender3.setIcon(photo50);
        URL path51 = getClass().getResource("/receiver.png");
        ImageIcon photo51 = new ImageIcon(new ImageIcon(path51).getImage().getScaledInstance(receiver.getWidth(), receiver.getHeight(), java.awt.Image.SCALE_SMOOTH));
        receiver.setIcon(photo51);
        URL pat1 = getClass().getResource("/atm.png");
        ImageIcon atmicon = new ImageIcon(new ImageIcon(pat1).getImage().getScaledInstance(atmpic.getWidth(), atmpic.getHeight(), java.awt.Image.SCALE_SMOOTH));
        atmpic.setIcon(atmicon);
        URL path = getClass().getResource("/bank.png");
        ImageIcon photoo = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(home_logo.getWidth(), home_logo.getHeight(), java.awt.Image.SCALE_SMOOTH));
        home_logo.setIcon(photoo);
        URL pathp = getClass().getResource("/his.png");
        ImageIcon photoop = new ImageIcon(new ImageIcon(pathp).getImage().getScaledInstance(e15.getWidth(), e15.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e15.setIcon(photoop);
        URL path09 = getClass().getResource("/tag.png");
        ImageIcon phot09 = new ImageIcon(new ImageIcon(path09).getImage().getScaledInstance(b16.getWidth(), b16.getHeight(), java.awt.Image.SCALE_SMOOTH));
        b16.setIcon(phot09);
        b8v.setIcon(phot09);
        n40.setIcon(phot09);
        b19b.setIcon(phot09);
        URL pathh = getClass().getResource("/social_network-512.png");
        ImageIcon photo = new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(cus_logo0.getWidth(), cus_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo0.setIcon(photo);
        URL path1 = getClass().getResource("/acc.png");
        ImageIcon photo1 = new ImageIcon(new ImageIcon(path1).getImage().getScaledInstance(cus_logo20.getWidth(), cus_logo20.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo20.setIcon(photo1);;
        URL path3 = getClass().getResource("/atm.png");
        ImageIcon photo3 = new ImageIcon(new ImageIcon(path3).getImage().getScaledInstance(cus_logo40.getWidth(), cus_logo40.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo40.setIcon(photo3);
        URL path4 = getClass().getResource("/pro.png");
        ImageIcon photo4 = new ImageIcon(new ImageIcon(path4).getImage().getScaledInstance(cus_logo50.getWidth(), cus_logo50.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo50.setIcon(photo4);
        URL path5 = getClass().getResource("/pass.jpg");
        ImageIcon photo5 = new ImageIcon(new ImageIcon(path5).getImage().getScaledInstance(cus_logo60.getWidth(), cus_logo60.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo60.setIcon(photo5);
        URL path6 = getClass().getResource("/out.png");
        ImageIcon photo6 = new ImageIcon(new ImageIcon(path6).getImage().getScaledInstance(cus_logo10.getWidth(), cus_logo10.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo10.setIcon(photo6);
        URL path7 = getClass().getResource("/manu.png");
        ImageIcon photo7 = new ImageIcon(new ImageIcon(path7).getImage().getScaledInstance(cus_logo7.getWidth(), cus_logo7.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo7.setIcon(photo7);
        URL path8 = getClass().getResource("/bank.png");
        ImageIcon photo8 = new ImageIcon(new ImageIcon(path8).getImage().getScaledInstance(cus_logo84.getWidth(), cus_logo84.getHeight(), java.awt.Image.SCALE_SMOOTH));
        cus_logo84.setIcon(photo8);
        URL path9 = getClass().getResource("/bank.png");
        ImageIcon photo9 = new ImageIcon(new ImageIcon(path9).getImage().getScaledInstance(top_logo0.getWidth(), top_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        top_logo0.setIcon(photo9);
        URL path011 = getClass().getResource("/bck.jpg");
        URL path11 = getClass().getResource("/pro.png");
        ImageIcon photo111 = new ImageIcon(new ImageIcon(path11).getImage().getScaledInstance(n12.getWidth(), n12.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n12.setIcon(photo111);
        n11v.setIcon(photo111);
        n33.setIcon(photo111);
        n45o.setIcon(photo111);
        n57.setIcon(photo111);
        URL path12 = getClass().getResource("/s.png");
        ImageIcon photo12 = new ImageIcon(new ImageIcon(path12).getImage().getScaledInstance(st8.getWidth(), st8.getHeight(), java.awt.Image.SCALE_SMOOTH));
        st2.setIcon(photo12);
        st3.setIcon(photo12);
        st4.setIcon(photo12);
        st5.setIcon(photo12);
        st7.setIcon(photo12);
        st8.setIcon(photo12);
        st10.setIcon(photo12);
        st11.setIcon(photo12);
        st12.setIcon(photo12);
        st13.setIcon(photo12);
        st14.setIcon(photo12);
        st15.setIcon(photo12);
        st16.setIcon(photo12);
        st17.setIcon(photo12);
        st18.setIcon(photo12);
        URL path15 = getClass().getResource("/bncc.png");
        ImageIcon photo15 = new ImageIcon(new ImageIcon(path15).getImage().getScaledInstance(emp9.getWidth(), emp9.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp9.setIcon(photo15);
        emp13.setIcon(photo15);
        URL path16 = getClass().getResource("/atm.png");
        ImageIcon photo16 = new ImageIcon(new ImageIcon(path16).getImage().getScaledInstance(emp6.getWidth(), emp6.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp6.setIcon(photo16);
        emp21.setIcon(photo16);
        URL path17 = getClass().getResource("/depo.png");
        ImageIcon photo17 = new ImageIcon(new ImageIcon(path17).getImage().getScaledInstance(emp1.getWidth(), emp1.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp1.setIcon(photo17);
        emp14.setIcon(photo17);
        emp17.setIcon(photo17);
        emp18.setIcon(photo17);
        ImageIcon photo107 = new ImageIcon(new ImageIcon(path17).getImage().getScaledInstance(e11.getWidth(), e11.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e11.setIcon(photo107);
        e12.setIcon(photo107);
        URL path18 = getClass().getResource("/blnc.png");
        ImageIcon photo18 = new ImageIcon(new ImageIcon(path18).getImage().getScaledInstance(emp3.getWidth(), emp3.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp3.setIcon(photo18);
        emp1.setIcon(photo18);
        emp166.setIcon(photo18);
        URL path19 = getClass().getResource("/depo.png");
        ImageIcon photo19 = new ImageIcon(new ImageIcon(path19).getImage().getScaledInstance(emp2.getWidth(), emp2.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp2.setIcon(photo19);
        URL path20 = getClass().getResource("/depo.png");
        ImageIcon photo20 = new ImageIcon(new ImageIcon(path20).getImage().getScaledInstance(emp7.getWidth(), emp7.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp7.setIcon(photo20);
        URL path21 = getClass().getResource("/pro.png");
        ImageIcon photo21 = new ImageIcon(new ImageIcon(path21).getImage().getScaledInstance(e1.getWidth(), e1.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e1.setIcon(photo21);
        URL path22 = getClass().getResource("/ser.png");
        ImageIcon photo22 = new ImageIcon(new ImageIcon(path22).getImage().getScaledInstance(e2.getWidth(), e2.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e2.setIcon(photo22);
        e5.setIcon(photo22);
        e16.setIcon(photo22);
        URL path23 = getClass().getResource("/del.png");
        ImageIcon photo23 = new ImageIcon(new ImageIcon(path23).getImage().getScaledInstance(e4.getWidth(), e4.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e4.setIcon(photo23);

        ImageIcon photo230 = new ImageIcon(new ImageIcon(path23).getImage().getScaledInstance(b44l.getWidth(), b44l.getHeight(), java.awt.Image.SCALE_SMOOTH));
        b44l.setIcon(photo230);
        URL path24 = getClass().getResource("/upd.png");
        ImageIcon photo24 = new ImageIcon(new ImageIcon(path24).getImage().getScaledInstance(e3.getWidth(), e3.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e3.setIcon(photo24);
        ImageIcon photo240 = new ImageIcon(new ImageIcon(path24).getImage().getScaledInstance(b3.getWidth(), b3.getHeight(), java.awt.Image.SCALE_SMOOTH));
        b3.setIcon(photo240);
        URL path25 = getClass().getResource("/blck.png");
        ImageIcon photo25 = new ImageIcon(new ImageIcon(path25).getImage().getScaledInstance(e8.getWidth(), e8.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e8.setIcon(photo25);
        e6.setIcon(photo25);
        ImageIcon photo251 = new ImageIcon(new ImageIcon(path25).getImage().getScaledInstance(emp15.getWidth(), emp15.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp15.setIcon(photo251);
        emp19.setIcon(photo251);
        ImageIcon photo250 = new ImageIcon(new ImageIcon(path25).getImage().getScaledInstance(b12d.getWidth(), b12d.getHeight(), java.awt.Image.SCALE_SMOOTH));
        b12d.setIcon(photo250);
        URL path26 = getClass().getResource("/act.png");
        ImageIcon photo26 = new ImageIcon(new ImageIcon(path26).getImage().getScaledInstance(e7.getWidth(), e7.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e7.setIcon(photo26);
        e10.setIcon(photo26);
        ImageIcon photo260 = new ImageIcon(new ImageIcon(path26).getImage().getScaledInstance(emp20.getWidth(), emp20.getHeight(), java.awt.Image.SCALE_SMOOTH));
        emp20.setIcon(photo260);
        URL path27 = getClass().getResource("/phone.png");
        ImageIcon photo270 = new ImageIcon(new ImageIcon(path27).getImage().getScaledInstance(n26.getWidth(), n26.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n26.setIcon(photo270);
        n16k.setIcon(photo270);
        n37.setIcon(photo270);
        n49.setIcon(photo270);
        n61.setIcon(photo270);
        URL path28 = getClass().getResource("/idcard.png");
        ImageIcon photo280 = new ImageIcon(new ImageIcon(path28).getImage().getScaledInstance(n27.getWidth(), n27.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n27.setIcon(photo280);
        n17v.setIcon(photo280);
        n38.setIcon(photo280);
        n50o.setIcon(photo280);
        n62.setIcon(photo280);
        URL path29 = getClass().getResource("/email.png");
        ImageIcon photo290 = new ImageIcon(new ImageIcon(path29).getImage().getScaledInstance(n30.getWidth(), n30.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n30.setIcon(photo290);
        n20v.setIcon(photo290);
        n41.setIcon(photo290);
        n53o.setIcon(photo290);
        n65.setIcon(photo290);
        URL path30 = getClass().getResource("/see.png");
        ImageIcon photo30 = new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se1.getWidth(), se1.getHeight(), java.awt.Image.SCALE_SMOOTH));
        se1.setIcon(photo30);
        se2.setIcon(photo30);
        URL path31 = getClass().getResource("/ok.png");
        ImageIcon photo31 = new ImageIcon(new ImageIcon(path31).getImage().getScaledInstance(ok.getWidth(), ok.getHeight(), java.awt.Image.SCALE_SMOOTH));
        ok.setIcon(photo31);
        ok4.setIcon(photo31);
        e14.setIcon(photo31);
        aok.setIcon(photo31);
        ImageIcon photo310 = new ImageIcon(new ImageIcon(path31).getImage().getScaledInstance(b23kk.getWidth(), b23kk.getHeight(), java.awt.Image.SCALE_SMOOTH));
        b23kk.setIcon(photo310);
        URL path301 = getClass().getResource("/send.png");
        ImageIcon photo301 = new ImageIcon(new ImageIcon(path301).getImage().getScaledInstance(e13.getWidth(), e13.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e13.setIcon(photo301);
        URL path3001 = getClass().getResource("/pro.png");
        ImageIcon photo3001 = new ImageIcon(new ImageIcon(path3001).getImage().getScaledInstance(e5.getWidth(), e5.getHeight(), java.awt.Image.SCALE_SMOOTH));
        e5.setIcon(photo3001);
        URL path32 = getClass().getResource("/reset.png");
        ImageIcon photo32 = new ImageIcon(new ImageIcon(path32).getImage().getScaledInstance(ok1.getWidth(), ok1.getHeight(), java.awt.Image.SCALE_SMOOTH));
        ok1.setIcon(photo32);
        ok5.setIcon(photo32);
        URL path33 = getClass().getResource("/location.png");
        ImageIcon photo330 = new ImageIcon(new ImageIcon(path33).getImage().getScaledInstance(n28.getWidth(), n28.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n28.setIcon(photo330);
        n18v.setIcon(photo330);
        n39.setIcon(photo330);
        n51o.setIcon(photo330);
        n63.setIcon(photo330);
        URL path34 = getClass().getResource("/parent.jpg");
        ImageIcon photo340 = new ImageIcon(new ImageIcon(path34).getImage().getScaledInstance(n24.getWidth(), n24.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n24.setIcon(photo340);
        n14v.setIcon(photo340);
        b6v.setIcon(photo340);
        b13.setIcon(photo340);
        b17.setIcon(photo340);
        b14.setIcon(photo340);
        b12n.setIcon(photo340);
        n35.setIcon(photo340);
        n47o.setIcon(photo340);
        n59.setIcon(photo340);
        URL path35 = getClass().getResource("/dob.png");
        ImageIcon photo35 = new ImageIcon(new ImageIcon(path35).getImage().getScaledInstance(n13lk.getWidth(), n13lk.getHeight(), java.awt.Image.SCALE_SMOOTH));
        ImageIcon photo350 = new ImageIcon(new ImageIcon(path35).getImage().getScaledInstance(n23.getWidth(), n23.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n23.setIcon(photo350);
        n13lk.setIcon(photo35);
        n34.setIcon(photo35);
        n44v.setIcon(photo35);
        n29o.setIcon(photo35);
        n44.setIcon(photo35);
        n46.setIcon(photo35);
        n56o.setIcon(photo35);
        n58.setIcon(photo35);
        n68.setIcon(photo35);
        URL path36 = getClass().getResource("/gen.png");
        ImageIcon photo36 = new ImageIcon(new ImageIcon(path36).getImage().getScaledInstance(n25.getWidth(), n25.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n25.setIcon(photo36);
        n15sk.setIcon(photo36);
        n36.setIcon(photo36);
        n48.setIcon(photo36);
        n60.setIcon(photo36);
        URL path37 = getClass().getResource("/back.png");
        ImageIcon photo37 = new ImageIcon(new ImageIcon(path37).getImage().getScaledInstance(back.getWidth(), back.getHeight(), java.awt.Image.SCALE_SMOOTH));
        back.setIcon(photo37);
        back1e.setIcon(photo37);
        back22.setIcon(photo37);
        back3.setIcon(photo37);
        back4.setIcon(photo37);
        back5k.setIcon(photo37);
        back6.setIcon(photo37);
        back7.setIcon(photo37);
        back8.setIcon(photo37);
        back9.setIcon(photo37);
        back10.setIcon(photo37);
        back11.setIcon(photo37);
        back12.setIcon(photo37);
        back13.setIcon(photo37);
        back14.setIcon(photo37);
        back15.setIcon(photo37);
        URL path38 = getClass().getResource("/edu.png");
        ImageIcon photo38 = new ImageIcon(new ImageIcon(path38).getImage().getScaledInstance(n52.getWidth(), n52.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n52.setIcon(photo38);
        n64.setIcon(photo38);
        URL path39 = getClass().getResource("/postal.jpg");
        ImageIcon photo39 = new ImageIcon(new ImageIcon(path39).getImage().getScaledInstance(n21ks.getWidth(), n21ks.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n21ks.setIcon(photo39);
        n31.setIcon(photo39);
        n42.setIcon(photo39);
        n54.setIcon(photo39);
        n66.setIcon(photo39);
        URL path40 = getClass().getResource("/slry.png");
        ImageIcon photo40 = new ImageIcon(new ImageIcon(path40).getImage().getScaledInstance(n32.getWidth(), n32.getHeight(), java.awt.Image.SCALE_SMOOTH));
        n32.setIcon(photo40);
        n43.setIcon(photo40);
        n67.setIcon(photo40);
        URL path41 = getClass().getResource("/srch.png");
        ImageIcon photo41 = new ImageIcon(new ImageIcon(path41).getImage().getScaledInstance(srchjsjs.getWidth(), srchjsjs.getHeight(), java.awt.Image.SCALE_SMOOTH));
        srchjsjs.setIcon(photo41);
        srch1.setIcon(photo41);
        URL path42 = getClass().getResource("/status.png");
        ImageIcon photo42 = new ImageIcon(new ImageIcon(path42).getImage().getScaledInstance(b5v.getWidth(), b5v.getHeight(), java.awt.Image.SCALE_SMOOTH));
        b5v.setIcon(photo42);
        b9j.setIcon(photo42);
        n52.setIcon(photo42);
        b11u.setIcon(photo42);
        URL path43 = getClass().getResource("/empid.png");
        ImageIcon photo43 = new ImageIcon(new ImageIcon(path43).getImage().getScaledInstance(b7v.getWidth(), b7v.getHeight(), java.awt.Image.SCALE_SMOOTH));
        b7v.setIcon(photo43);
        n19v.setIcon(photo43);
        b15.setIcon(photo43);
        n69h.setIcon(photo43);
        b18.setIcon(photo43);
        emp.setIcon(photo43);
        top_title.setText("Home");
        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Male", "Female", "Other" }));
        home_p.setBackground(new Color(0, 153, 102));
    }

    void f_reset() {
        er1.setText(null);
        f13.setText(null);
        er2.setText(null);
        er3.setText(null);
        er4.setText(null);
        er5.setText(null);
        er6.setText(null);
        er7.setText(null);
        er8.setText(null);
        er9.setText(null);
        er10.setText(null);
        er12.setText(null);
        er13.setText(null);
        f2.setText(null);
        f3.setText(null);
        dob.setDate(null);
        f4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Account Type", "Saving", "Current"}));
        f8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select Gender", "Male", "Female"}));
        f5.setText(null);
        f6.setText(null);
        f7.setText(null);
        f9.setText(null);
        pic.setIcon(null);
        f11.setText(null);
        f12.setText(null);
        f1.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cus_logo10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        a2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cus_logo40 = new javax.swing.JLabel();
        a4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cus_logo20 = new javax.swing.JLabel();
        a6 = new javax.swing.JPanel();
        cus_logo50 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        a7 = new javax.swing.JPanel();
        cus_logo60 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        home_logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        a1 = new javax.swing.JPanel();
        cus_logo0 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        home_p = new javax.swing.JPanel();
        cus_logo84 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        cus_logo7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        top_title = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        top_logo0 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        home_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        slo = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        d2_1 = new javax.swing.JPanel();
        d2_l2 = new javax.swing.JLabel();
        d2_l1 = new javax.swing.JLabel();
        emp6 = new javax.swing.JLabel();
        d2_2 = new javax.swing.JPanel();
        d2_l3 = new javax.swing.JLabel();
        st4 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        d3_1 = new javax.swing.JPanel();
        d3_l2 = new javax.swing.JLabel();
        d3_l1 = new javax.swing.JLabel();
        emp1 = new javax.swing.JLabel();
        d3_2 = new javax.swing.JPanel();
        d3_l3 = new javax.swing.JLabel();
        st5 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        d9_1 = new javax.swing.JPanel();
        d9_l2 = new javax.swing.JLabel();
        emp7 = new javax.swing.JLabel();
        d9_l1 = new javax.swing.JLabel();
        d9_2 = new javax.swing.JPanel();
        d9_l3 = new javax.swing.JLabel();
        st7 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        d8_1 = new javax.swing.JPanel();
        d8_l2 = new javax.swing.JLabel();
        emp2 = new javax.swing.JLabel();
        d8_l1 = new javax.swing.JLabel();
        d8_2 = new javax.swing.JPanel();
        d8_l3 = new javax.swing.JLabel();
        st2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        d7_1 = new javax.swing.JPanel();
        d7_l2 = new javax.swing.JLabel();
        emp3 = new javax.swing.JLabel();
        d7_l1 = new javax.swing.JLabel();
        d7_2 = new javax.swing.JPanel();
        d7_l3 = new javax.swing.JLabel();
        st3 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        d1_1 = new javax.swing.JPanel();
        d1_l2 = new javax.swing.JLabel();
        d1_l1 = new javax.swing.JLabel();
        emp9 = new javax.swing.JLabel();
        d1_2 = new javax.swing.JPanel();
        d1_l3 = new javax.swing.JLabel();
        st8 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jPanel6 = new rounds(30);
        acc5 = new rounds(30);
        lacc5 = new javax.swing.JLabel();
        e5 = new javax.swing.JLabel();
        acc6 = new rounds(30);
        lac6 = new javax.swing.JLabel();
        e16 = new javax.swing.JLabel();
        acc9 = new rounds(30);
        lac9 = new javax.swing.JLabel();
        e6 = new javax.swing.JLabel();
        acc10 = new rounds(30);
        lac10 = new javax.swing.JLabel();
        e10 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        d1_9 = new javax.swing.JPanel();
        d1_l13 = new javax.swing.JLabel();
        d1_l14 = new javax.swing.JLabel();
        emp21 = new javax.swing.JLabel();
        d1_10 = new javax.swing.JPanel();
        d1_l15 = new javax.swing.JLabel();
        st13 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        d1_11 = new javax.swing.JPanel();
        d1_l16 = new javax.swing.JLabel();
        d1_l17 = new javax.swing.JLabel();
        emp20 = new javax.swing.JLabel();
        d1_12 = new javax.swing.JPanel();
        d1_l18 = new javax.swing.JLabel();
        st14 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        d1_13 = new javax.swing.JPanel();
        d1_l19 = new javax.swing.JLabel();
        d1_l20 = new javax.swing.JLabel();
        emp19 = new javax.swing.JLabel();
        d1_14 = new javax.swing.JPanel();
        d1_l21 = new javax.swing.JLabel();
        st15 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        d7_3 = new javax.swing.JPanel();
        d7_l41 = new javax.swing.JLabel();
        emp166 = new javax.swing.JLabel();
        d7_l51 = new javax.swing.JLabel();
        d7_4 = new javax.swing.JPanel();
        d7_l6 = new javax.swing.JLabel();
        st16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        d8_3 = new javax.swing.JPanel();
        d8_l4 = new javax.swing.JLabel();
        emp17 = new javax.swing.JLabel();
        d8_l5 = new javax.swing.JLabel();
        d8_4 = new javax.swing.JPanel();
        d8_l6 = new javax.swing.JLabel();
        st17 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        d9_3 = new javax.swing.JPanel();
        d9_l4 = new javax.swing.JLabel();
        emp18 = new javax.swing.JLabel();
        d9_l5 = new javax.swing.JLabel();
        d9_4 = new javax.swing.JPanel();
        d9_l6 = new javax.swing.JLabel();
        st18 = new javax.swing.JLabel();
        jPanel7 = new rounds(30);
        ac11 = new rounds(30);
        lac11 = new javax.swing.JLabel();
        e11 = new javax.swing.JLabel();
        ac12 = new rounds(30);
        lac12 = new javax.swing.JLabel();
        e12 = new javax.swing.JLabel();
        ac13 = new rounds(30);
        lac13 = new javax.swing.JLabel();
        e13 = new javax.swing.JLabel();
        ac14 = new rounds(30);
        lac14 = new javax.swing.JLabel();
        e14 = new javax.swing.JLabel();
        ac15 = new rounds(30);
        lac15 = new javax.swing.JLabel();
        e15 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        aspane4 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        n57 = new javax.swing.JLabel();
        n58 = new javax.swing.JLabel();
        n59 = new javax.swing.JLabel();
        empic = new javax.swing.JLabel();
        n60 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        n61 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        em4 = new javax.swing.JTextField();
        n62 = new javax.swing.JLabel();
        em5 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        n63 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        em6 = new javax.swing.JTextField();
        em12 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        n64 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        n65 = new javax.swing.JLabel();
        em11 = new javax.swing.JTextField();
        em13 = new javax.swing.JTextField();
        em7 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        n66 = new javax.swing.JLabel();
        n67 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        b17 = new javax.swing.JLabel();
        b18 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        em14 = new javax.swing.JTextField();
        em1 = new javax.swing.JTextField();
        em2 = new javax.swing.JTextField();
        em3 = new javax.swing.JTextField();
        em9 = new javax.swing.JTextField();
        em10 = new javax.swing.JTextField();
        em8 = new javax.swing.JTextField();
        n68 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        newpass2 = new javax.swing.JPasswordField();
        oldpass = new javax.swing.JPasswordField();
        newpass1 = new javax.swing.JPasswordField();
        se1 = new javax.swing.JLabel();
        se2 = new javax.swing.JLabel();
        pac2 = new rounds(30);
        ok = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pac1 = new rounds(30);
        ok1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        olderr = new javax.swing.JLabel();
        newerr2 = new javax.swing.JLabel();
        newerr1 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        d1_3 = new javax.swing.JPanel();
        d1_l4 = new javax.swing.JLabel();
        d1_l5 = new javax.swing.JLabel();
        emp13 = new javax.swing.JLabel();
        d1_4 = new javax.swing.JPanel();
        d1_l6 = new javax.swing.JLabel();
        st10 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        d1_5 = new javax.swing.JPanel();
        d1_l7 = new javax.swing.JLabel();
        d1_l8 = new javax.swing.JLabel();
        emp14 = new javax.swing.JLabel();
        d1_6 = new javax.swing.JPanel();
        d1_l9 = new javax.swing.JLabel();
        st11 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        d1_7 = new javax.swing.JPanel();
        d1_l10 = new javax.swing.JLabel();
        d1_l11 = new javax.swing.JLabel();
        emp15 = new javax.swing.JLabel();
        d1_8 = new javax.swing.JPanel();
        d1_l12 = new javax.swing.JLabel();
        st12 = new javax.swing.JLabel();
        jPanel3 = new rounds(30);
        ac1 = new rounds(30);
        lac1 = new javax.swing.JLabel();
        e1 = new javax.swing.JLabel();
        ac2 = new rounds(30);
        lac2 = new javax.swing.JLabel();
        e2 = new javax.swing.JLabel();
        ac3 = new rounds(30);
        lac3 = new javax.swing.JLabel();
        e3 = new javax.swing.JLabel();
        ac4 = new rounds(30);
        lac4 = new javax.swing.JLabel();
        e4 = new javax.swing.JLabel();
        ac7 = new rounds(30);
        lac7 = new javax.swing.JLabel();
        e7 = new javax.swing.JLabel();
        ac8 = new rounds(30);
        lac8 = new javax.swing.JLabel();
        e8 = new javax.swing.JLabel();
        insertion_acc = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        aspane1 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        n12 = new javax.swing.JLabel();
        n23 = new javax.swing.JLabel();
        n24 = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        n25 = new javax.swing.JLabel();
        f4 = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        n26 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        f3 = new javax.swing.JTextField();
        n27 = new javax.swing.JLabel();
        f5 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        n28 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        f6 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        f12 = new javax.swing.JTextArea();
        jLabel79 = new javax.swing.JLabel();
        n30 = new javax.swing.JLabel();
        f9 = new javax.swing.JTextField();
        f11 = new javax.swing.JTextField();
        f7 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        n31 = new javax.swing.JLabel();
        n32 = new javax.swing.JLabel();
        b13 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        f8 = new javax.swing.JComboBox<>();
        f2 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        pac5 = new rounds(30);
        ok4 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        pac6 = new rounds(30);
        ok5 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        er1 = new javax.swing.JLabel();
        er2 = new javax.swing.JLabel();
        er3 = new javax.swing.JLabel();
        er4 = new javax.swing.JLabel();
        er5 = new javax.swing.JLabel();
        er6 = new javax.swing.JLabel();
        er7 = new javax.swing.JLabel();
        er8 = new javax.swing.JLabel();
        er9 = new javax.swing.JLabel();
        er10 = new javax.swing.JLabel();
        er12 = new javax.swing.JLabel();
        er13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        f13 = new javax.swing.JTextField();
        b16 = new javax.swing.JLabel();
        er11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        emp = new javax.swing.JLabel();
        f1 = new javax.swing.JTextField();
        action_acc = new javax.swing.JPanel();
        aspane = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        s2f = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        n11v = new javax.swing.JLabel();
        n13lk = new javax.swing.JLabel();
        n14v = new javax.swing.JLabel();
        picsff = new javax.swing.JLabel();
        n15sk = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        n16k = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        s5f = new javax.swing.JTextField();
        n17v = new javax.swing.JLabel();
        s6f = new javax.swing.JTextField();
        n18v = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        s7f = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        n20v = new javax.swing.JLabel();
        s12af = new javax.swing.JTextField();
        s8f = new javax.swing.JTextField();
        n21ks = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        b5v = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        b6v = new javax.swing.JLabel();
        b7v = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        s9cf = new javax.swing.JTextField();
        s1f = new javax.swing.JTextField();
        s3f = new javax.swing.JTextField();
        s4zf = new javax.swing.JTextField();
        s10sf = new javax.swing.JTextField();
        joindatek = new javax.swing.JTextField();
        n44v = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        n19v = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        s13f = new javax.swing.JTextField();
        s15sf = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        s16f = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        b8v = new javax.swing.JLabel();
        s17df = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        b9j = new javax.swing.JLabel();
        n29o = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        atm_date1 = new javax.swing.JTextField();
        jPanel23w = new javax.swing.JPanel();
        back1e = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        pac77 = new rounds(30);
        b44l = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        pac99 = new rounds(30);
        b23kk = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        pac101 = new rounds(30);
        b12d = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        search_acc = new javax.swing.JPanel();
        spane = new javax.swing.JPanel();
        search1j = new javax.swing.JTextField();
        jPanel27jj = new rounds(30);
        srchjsjs = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        rd32 = new javax.swing.JRadioButton();
        rd11 = new javax.swing.JRadioButton();
        searcherr = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        back22 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        update_acc = new javax.swing.JPanel();
        aspane2 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        u3 = new com.toedter.calendar.JDateChooser();
        n33 = new javax.swing.JLabel();
        n34 = new javax.swing.JLabel();
        n35 = new javax.swing.JLabel();
        upic = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        n36 = new javax.swing.JLabel();
        u4 = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        n37 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        u2 = new javax.swing.JTextField();
        n38 = new javax.swing.JLabel();
        u5 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        n39 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        u6 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        u12 = new javax.swing.JTextArea();
        jLabel94 = new javax.swing.JLabel();
        n41 = new javax.swing.JLabel();
        u9 = new javax.swing.JTextField();
        u7 = new javax.swing.JTextField();
        n42 = new javax.swing.JLabel();
        n43 = new javax.swing.JLabel();
        b14 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        u8 = new javax.swing.JComboBox<>();
        u1 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        pac8 = new rounds(30);
        b3 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        u13 = new javax.swing.JTextField();
        n40 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        back3 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        up_search_acc = new javax.swing.JPanel();
        spane1 = new javax.swing.JPanel();
        serupdate = new javax.swing.JTextField();
        jPanel29 = new rounds(30);
        srch1 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        rd4 = new javax.swing.JRadioButton();
        rd5 = new javax.swing.JRadioButton();
        uperror = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        back4 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        bnk_block = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        back9 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        back16 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        bnc_history1 = new javax.swing.JTable();
        tr1 = new javax.swing.JTextField();
        tr2 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        r1 = new javax.swing.JRadioButton();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jLabel168 = new javax.swing.JLabel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel169 = new javax.swing.JLabel();
        atm_table_pnl = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        atm_table = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        back8 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel166 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel167 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        accounts_pnl = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        back7 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accounts_table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel165 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton12 = new javax.swing.JButton();
        saving_acc_pnl = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        back6 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        main_profile = new javax.swing.JPanel();
        aspane3 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        m2b = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        n45o = new javax.swing.JLabel();
        n46 = new javax.swing.JLabel();
        n47o = new javax.swing.JLabel();
        pics1k = new javax.swing.JLabel();
        n48 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        n49 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        m5o = new javax.swing.JTextField();
        n50o = new javax.swing.JLabel();
        m6i = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        n51o = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        m7t = new javax.swing.JTextField();
        m13o = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        n52 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        n53o = new javax.swing.JLabel();
        m12y = new javax.swing.JTextField();
        m8y = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        n54 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        b11u = new javax.swing.JLabel();
        b12n = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        m15t = new javax.swing.JTextField();
        m3j = new javax.swing.JTextField();
        m4p = new javax.swing.JTextField();
        m10v = new javax.swing.JTextField();
        m11i = new javax.swing.JTextField();
        m9o = new javax.swing.JTextField();
        n56o = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        n69h = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        m16o = new javax.swing.JTextField();
        b19b = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        m17n = new javax.swing.JTextField();
        m1j = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        b15 = new javax.swing.JLabel();
        n44 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        atm_date = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        back5k = new javax.swing.JLabel();
        jLabel117j = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        newatm = new javax.swing.JPanel();
        atmpic = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new rounds(30);
        aok = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        aterr = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        back11 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        withdraw_money_pnl = new javax.swing.JPanel();
        out = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        dpb = new javax.swing.JButton();
        jLabel137 = new javax.swing.JLabel();
        wth2 = new javax.swing.JTextField();
        wth1 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        sender2 = new javax.swing.JLabel();
        with = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        accerr6 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        accerr7 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        back12 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        balance_history_pnl = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        bnc_history = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        back10 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        hit1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel159 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel163 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton11 = new javax.swing.JButton();
        send_money_pnl = new javax.swing.JPanel();
        snd1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        snd2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        receiver = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        sender = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        rc2 = new javax.swing.JTextField();
        sn1 = new javax.swing.JTextField();
        sn2 = new javax.swing.JTextField();
        rc1 = new javax.swing.JTextField();
        snd = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        sndbtn = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        accerr2 = new javax.swing.JLabel();
        accerr3 = new javax.swing.JLabel();
        accerr4 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        back13 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        deposit_mony_pnl = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        dpvalue2 = new javax.swing.JTextField();
        dpbtn = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        dp2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        dp1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        dpvalue = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        sender1 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        accerr = new javax.swing.JLabel();
        accerr5 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        back14 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        check_blnc_pnl = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        sender3 = new javax.swing.JLabel();
        check = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        bnc1 = new javax.swing.JTextField();
        bnc2 = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        bnc3 = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        accerr1 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        back15 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(cus_logo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 8, 35, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Log Out");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 90, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 485, 220, 40));

        a2.setBackground(new java.awt.Color(102, 153, 255));
        a2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a2MouseExited(evt);
            }
        });
        a2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ATM Accounts");
        a2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));
        a2.add(cus_logo40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 35, 25));

        jPanel1.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 285, 220, 40));

        a4.setBackground(new java.awt.Color(102, 153, 255));
        a4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a4MouseExited(evt);
            }
        });
        a4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Account Queries");
        a4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));
        a4.add(cus_logo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 35, 25));

        jPanel1.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 335, 220, 40));

        a6.setBackground(new java.awt.Color(102, 153, 255));
        a6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a6mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a6MouseExited(evt);
            }
        });
        a6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a6.add(cus_logo50, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 5, 35, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Account Profile");
        a6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));

        jPanel1.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, 220, 40));

        a7.setBackground(new java.awt.Color(102, 153, 255));
        a7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a7mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a7MouseExited(evt);
            }
        });
        a7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a7.add(cus_logo60, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 5, 35, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Change Password");
        a7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 7, 140, 30));

        jPanel1.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 435, 220, 40));

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(home_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 10, 110, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sky Bank Limited");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 134));

        a1.setBackground(new java.awt.Color(102, 153, 255));
        a1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a1MouseExited(evt);
            }
        });
        a1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a1.add(cus_logo0, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 8, 35, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Bank Accounts");
        a1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));

        jPanel1.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 220, 40));

        home_p.setBackground(new java.awt.Color(102, 153, 255));
        home_p.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        home_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_pmouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_pMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_pMouseExited(evt);
            }
        });
        home_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        home_p.add(cus_logo84, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, 35, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Home");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_p.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 3, 100, 30));

        jPanel1.add(home_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 185, 220, 40));

        jPanel20.setBackground(new java.awt.Color(102, 153, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        jPanel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel20.add(cus_logo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 5, 40, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Menu List");
        jPanel20.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 3, 100, 30));

        jPanel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 220, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 541));

        jPanel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel11MouseDragged(evt);
            }
        });
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top_title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel11.add(top_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 9, 180, 25));

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
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 35));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, 37));

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
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 37));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 37));
        jPanel11.add(top_logo0, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 7, 35, 25));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        jPanel21.setLayout(new java.awt.CardLayout());

        home_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Welcome to Dashboard", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slo.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        slo.setForeground(new java.awt.Color(102, 0, 102));
        slo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(slo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 410, 30));

        profile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 11, 55, 45));

        home_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 490, 60));

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d2_1.setBackground(new java.awt.Color(102, 102, 255));
        d2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d2_l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d2_l2.setForeground(new java.awt.Color(255, 255, 255));
        d2_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d2_l2.setText("ATM Accounts");
        d2_1.add(d2_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 60, 150, 30));

        d2_l1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        d2_l1.setForeground(new java.awt.Color(255, 255, 255));
        d2_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d2_l1.setText("0");
        d2_1.add(d2_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 180, 30));
        d2_1.add(emp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        jPanel22.add(d2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 92));

        d2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d2_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d2_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d2_2dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d2_2dash_e(evt);
            }
        });
        d2_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d2_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d2_l3.setText("View Details");
        d2_2.add(d2_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d2_2.add(st4, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 8, 22, 15));

        jPanel22.add(d2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        home_panel.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 250, 120));

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d3_1.setBackground(new java.awt.Color(102, 102, 255));
        d3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d3_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d3_l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d3_l2.setForeground(new java.awt.Color(255, 255, 255));
        d3_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d3_l2.setText("Saving Accounts");
        d3_1.add(d3_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 60, 150, 30));

        d3_l1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        d3_l1.setForeground(new java.awt.Color(255, 255, 255));
        d3_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d3_l1.setText("0");
        d3_1.add(d3_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 180, 30));
        d3_1.add(emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        jPanel25.add(d3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 92));

        d3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d3_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d3_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d3_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d3_2dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d3_2dash_e(evt);
            }
        });
        d3_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d3_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d3_l3.setText("View Details");
        d3_2.add(d3_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 110, 20));
        d3_2.add(st5, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 8, 22, 15));

        jPanel25.add(d3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        home_panel.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 230, 250, 120));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_1.setBackground(new java.awt.Color(102, 102, 255));
        d9_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d9_l2.setForeground(new java.awt.Color(255, 255, 255));
        d9_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d9_l2.setText("Withdraw Balance");
        d9_1.add(d9_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 60, 150, 30));
        d9_1.add(emp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        d9_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d9_l1.setForeground(new java.awt.Color(255, 255, 255));
        d9_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d9_l1.setText("0.00");
        d9_1.add(d9_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 15, 192, 30));

        jPanel31.add(d9_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 92));

        d9_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d9_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d9_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d9_2dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d9_2dash_e(evt);
            }
        });
        d9_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d9_l3.setText("View Details");
        d9_2.add(d9_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 110, 20));
        d9_2.add(st7, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 8, 22, 15));

        jPanel31.add(d9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        home_panel.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 250, 120));

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_1.setBackground(new java.awt.Color(102, 102, 255));
        d8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d8_l2.setForeground(new java.awt.Color(255, 255, 255));
        d8_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d8_l2.setText("Deposite Balance");
        d8_1.add(d8_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 60, 150, 30));
        d8_1.add(emp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        d8_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d8_l1.setForeground(new java.awt.Color(255, 255, 255));
        d8_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d8_l1.setText("0.00");
        d8_1.add(d8_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 15, 192, 30));

        jPanel14.add(d8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 92));

        d8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d8_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d8_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d8_2dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d8_2dash_e(evt);
            }
        });
        d8_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d8_l3.setText("View Details");
        d8_2.add(d8_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d8_2.add(st2, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 8, 22, 15));

        jPanel14.add(d8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        home_panel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 250, 120));

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_1.setBackground(new java.awt.Color(102, 102, 255));
        d7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d7_l2.setForeground(new java.awt.Color(255, 255, 255));
        d7_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d7_l2.setText("Bank Balance");
        d7_1.add(d7_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 60, 150, 30));
        d7_1.add(emp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        d7_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d7_l1.setForeground(new java.awt.Color(255, 255, 255));
        d7_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d7_l1.setText("0.00");
        d7_1.add(d7_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 15, 192, 30));
        d7_l1.getAccessibleContext().setAccessibleName("0.00");

        jPanel17.add(d7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 92));

        d7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d7_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d7_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d7_2dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d7_2dash_e(evt);
            }
        });
        d7_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d7_l3.setText("View Details");
        d7_2.add(d7_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 130, 20));
        d7_2.add(st3, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 8, 22, 15));

        jPanel17.add(d7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        home_panel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 360, 250, 120));

        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_1.setBackground(new java.awt.Color(102, 102, 255));
        d1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l2.setForeground(new java.awt.Color(255, 255, 255));
        d1_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l2.setText("Current Accounts");
        d1_1.add(d1_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 60, 150, 30));

        d1_l1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        d1_l1.setForeground(new java.awt.Color(255, 255, 255));
        d1_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l1.setText("0");
        d1_1.add(d1_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 180, 30));
        d1_1.add(emp9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        jPanel34.add(d1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 92));

        d1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d1_2dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d1_2dash_e(evt);
            }
        });
        d1_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l3.setText("View Details");
        d1_2.add(d1_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_2.add(st8, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 8, 22, 15));

        jPanel34.add(d1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        home_panel.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 100, 250, 120));

        jPanel21.add(home_panel, "card2");

        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acc5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acc5an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acc5an_mexit(evt);
            }
        });
        acc5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lacc5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lacc5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacc5.setText("New Account");
        acc5.add(lacc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        acc5.add(e5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(acc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 160, 40));

        acc6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acc6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acc6an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acc6an_mexit(evt);
            }
        });
        acc6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac6.setText("Search Account");
        acc6.add(lac6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        acc6.add(e16, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(acc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 35, 160, 40));

        acc9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acc9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acc9an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acc9an_mexit(evt);
            }
        });
        acc9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac9.setText("Delete Account");
        acc9.add(lac9, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        acc9.add(e6, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(acc9, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, 160, 40));

        acc10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acc10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acc10an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acc10an_mexit(evt);
            }
        });
        acc10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac10.setText("Activate / Block");
        acc10.add(lac10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        acc10.add(e10, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(acc10, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 90, 160, 40));

        panel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 470, 150));

        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_9.setBackground(new java.awt.Color(102, 102, 255));
        d1_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l13.setForeground(new java.awt.Color(255, 255, 255));
        d1_l13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l13.setText("Total ATM accounts");
        d1_9.add(d1_l13, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 60, 140, 30));

        d1_l14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        d1_l14.setForeground(new java.awt.Color(255, 255, 255));
        d1_l14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l14.setText("0");
        d1_9.add(d1_l14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));
        d1_9.add(emp21, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        jPanel39.add(d1_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d1_10and_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d1_10and_mexit(evt);
            }
        });
        d1_10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l15.setText("View Details");
        d1_10.add(d1_l15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_10.add(st13, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 8, 22, 15));

        jPanel39.add(d1_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        panel2.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 110, 200, 120));

        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_11.setBackground(new java.awt.Color(102, 102, 255));
        d1_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l16.setForeground(new java.awt.Color(255, 255, 255));
        d1_l16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l16.setText("Active ATM accounts");
        d1_11.add(d1_l16, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 60, 150, 30));

        d1_l17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        d1_l17.setForeground(new java.awt.Color(255, 255, 255));
        d1_l17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l17.setText("0");
        d1_11.add(d1_l17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));
        d1_11.add(emp20, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        jPanel40.add(d1_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d1_12and_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d1_12and_mexit(evt);
            }
        });
        d1_12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l18.setText("View Details");
        d1_12.add(d1_l18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_12.add(st14, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 8, 22, 15));

        jPanel40.add(d1_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        panel2.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 200, 120));

        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_13.setBackground(new java.awt.Color(102, 102, 255));
        d1_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l19.setForeground(new java.awt.Color(255, 255, 255));
        d1_l19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l19.setText("Blocked ATM accounts");
        d1_13.add(d1_l19, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 60, 160, 30));

        d1_l20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        d1_l20.setForeground(new java.awt.Color(255, 255, 255));
        d1_l20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l20.setText("0");
        d1_13.add(d1_l20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));
        d1_13.add(emp19, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        jPanel41.add(d1_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d1_14and_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d1_14and_mexit(evt);
            }
        });
        d1_14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l21.setText("View Details");
        d1_14.add(d1_l21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_14.add(st15, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 8, 22, 15));

        jPanel41.add(d1_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        panel2.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 200, 120));

        jPanel21.add(panel2, "card3");

        panel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_3.setBackground(new java.awt.Color(102, 102, 255));
        d7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d7_l41.setForeground(new java.awt.Color(255, 255, 255));
        d7_l41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d7_l41.setText("Bank Balance");
        d7_3.add(d7_l41, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 115, 180, 30));
        d7_3.add(emp166, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d7_l51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d7_l51.setForeground(new java.awt.Color(255, 255, 255));
        d7_l51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d7_l51.setText("0.00");
        d7_3.add(d7_l51, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 70, 190, 30));

        jPanel18.add(d7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 152));

        d7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d7_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d7_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d7_4bn_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d7_4bn_mexit(evt);
            }
        });
        d7_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d7_l6.setText("View Details");
        d7_4.add(d7_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 130, 40));
        d7_4.add(st16, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 18, 22, 15));

        jPanel18.add(d7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        panel4.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 75, 200, 200));

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_3.setBackground(new java.awt.Color(102, 102, 255));
        d8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d8_l4.setForeground(new java.awt.Color(255, 255, 255));
        d8_l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d8_l4.setText("Deposite Balance");
        d8_3.add(d8_l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 115, 180, 30));
        d8_3.add(emp17, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d8_l5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d8_l5.setForeground(new java.awt.Color(255, 255, 255));
        d8_l5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d8_l5.setText("0.00");
        d8_3.add(d8_l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 70, 190, 30));

        jPanel15.add(d8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 152));

        d8_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d8_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d8_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d8_4bn_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d8_4bn_mexit(evt);
            }
        });
        d8_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d8_l6.setText("View Details");
        d8_4.add(d8_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 40));
        d8_4.add(st17, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 18, 22, 15));

        jPanel15.add(d8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        panel4.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 75, 200, 200));

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_3.setBackground(new java.awt.Color(102, 102, 255));
        d9_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d9_l4.setForeground(new java.awt.Color(255, 255, 255));
        d9_l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d9_l4.setText("Withdraw Balance");
        d9_3.add(d9_l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 115, 180, 30));
        d9_3.add(emp18, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d9_l5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d9_l5.setForeground(new java.awt.Color(255, 255, 255));
        d9_l5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d9_l5.setText("0.00");
        d9_3.add(d9_l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 70, 190, 30));

        jPanel32.add(d9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 152));

        d9_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d9_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d9_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d9_4bn_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d9_4bn_mexit(evt);
            }
        });
        d9_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d9_l6.setText("View Details");
        d9_4.add(d9_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 110, 40));
        d9_4.add(st18, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 18, 22, 15));

        jPanel32.add(d9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        panel4.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 75, 200, 200));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ac11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac11an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac11an_mexit(evt);
            }
        });
        ac11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac11.setText("Depsoit money");
        ac11.add(lac11, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 115, 30));
        ac11.add(e11, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel7.add(ac11, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 160, 40));

        ac12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac12an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac12an_mexit(evt);
            }
        });
        ac12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac12.setText("Withdraw money");
        ac12.add(lac12, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 115, 30));
        ac12.add(e12, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel7.add(ac12, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 35, 160, 40));

        ac13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac13an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac13an_mexit(evt);
            }
        });
        ac13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac13.setText("Transection");
        ac13.add(lac13, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 115, 30));
        ac13.add(e13, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel7.add(ac13, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 87, 160, 40));

        ac14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac14an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac14an_mexit(evt);
            }
        });
        ac14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac14.setText("Check Balance");
        ac14.add(lac14, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 115, 30));
        ac14.add(e14, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel7.add(ac14, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 87, 160, 40));

        ac15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac15an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac15an_mexit(evt);
            }
        });
        ac15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac15.setText("Account History");
        ac15.add(lac15, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 115, 30));
        ac15.add(e15, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel7.add(ac15, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 140, 160, 40));

        panel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 470, 190));

        jPanel21.add(panel4, "card5");

        panel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Profile", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        panel5.setForeground(new java.awt.Color(0, 0, 153));
        panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aspane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Data Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel84.setText("Employee Name");
        aspane4.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 90, 25));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel95.setText("Father Name");
        aspane4.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 80, 25));

        jTextField13.setEditable(false);
        jTextField13.setText("+92");
        aspane4.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 30, 25));

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel108.setText("CNIC");
        aspane4.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 80, 25));
        aspane4.add(n57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 30, 25));
        aspane4.add(n58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 30, 25));
        aspane4.add(n59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 30, 25));

        empic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane4.add(empic, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 90, 90));
        aspane4.add(n60, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 30, 25));

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel109.setText("Contect");
        aspane4.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 50, 25));
        aspane4.add(n61, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 30, 25));

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel110.setText("DateOfBirth");
        aspane4.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 25));

        em4.setEditable(false);
        aspane4.add(em4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 25));
        aspane4.add(n62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 30, 25));

        em5.setEditable(false);
        aspane4.add(em5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 25));

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel122.setText("Marital");
        aspane4.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 60, 25));
        aspane4.add(n63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 30, 25));

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel123.setText("Email");
        aspane4.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 80, 25));

        em6.setEditable(false);
        em6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                em6MouseEntered(evt);
            }
        });
        aspane4.add(em6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 25));

        em12.setEditable(false);
        aspane4.add(em12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 130, 25));

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel124.setText("Postal Code");
        aspane4.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 25));
        aspane4.add(n64, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 30, 25));

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel125.setText("Address");
        aspane4.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 70, 30));
        aspane4.add(n65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 30, 25));

        em11.setEditable(false);
        aspane4.add(em11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 100, 25));

        em13.setEditable(false);
        aspane4.add(em13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 130, 25));

        em7.setEditable(false);
        aspane4.add(em7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 25));

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel126.setText("Education");
        aspane4.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 60, 25));

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel127.setText("Income");
        aspane4.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 60, 25));
        aspane4.add(n66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 30, 25));
        aspane4.add(n67, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 30, 25));

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel129.setText("Employee Id");
        aspane4.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));
        aspane4.add(b17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 30, 25));
        aspane4.add(b18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, 25));

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel130.setText("Gender");
        aspane4.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 50, 25));

        em14.setEditable(false);
        aspane4.add(em14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 380, 30));

        em1.setEditable(false);
        aspane4.add(em1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 140, 25));

        em2.setEditable(false);
        aspane4.add(em2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 25));

        em3.setEditable(false);
        em3.setText("18-02-2000 |dd/MM/yyyy");
        em3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                em3MouseEntered(evt);
            }
        });
        aspane4.add(em3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 25));

        em9.setEditable(false);
        aspane4.add(em9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 130, 25));

        em10.setEditable(false);
        aspane4.add(em10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 130, 25));

        em8.setEditable(false);
        em8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                em8MouseEntered(evt);
            }
        });
        aspane4.add(em8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 140, 25));
        aspane4.add(n68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 30, 25));

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel131.setText("Date Of Joining");
        aspane4.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 90, 25));

        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Change Profile Image");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        aspane4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 122, 140, 25));

        panel5.add(aspane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 560, 400));

        jPanel21.add(panel5, "card6");

        panel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Change Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Confirm Password");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, 100, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Old Password");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 80, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("New Password");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 100, 30));

        newpass2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newpass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newpass2FocusGained(evt);
            }
        });
        newpass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newpass2KeyPressed(evt);
            }
        });
        jPanel9.add(newpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 200, 30));

        oldpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        oldpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                oldpassFocusGained(evt);
            }
        });
        oldpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                oldpassKeyPressed(evt);
            }
        });
        jPanel9.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 200, 30));

        newpass1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newpass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newpass1FocusGained(evt);
            }
        });
        newpass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newpass1KeyPressed(evt);
            }
        });
        jPanel9.add(newpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 200, 30));

        se1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                se1MouseClicked(evt);
            }
        });
        jPanel9.add(se1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 52, 35, 25));

        se2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                se2MouseClicked(evt);
            }
        });
        jPanel9.add(se2, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 112, 35, 25));

        pac2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac2pac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac2pac_mexit(evt);
            }
        });
        pac2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac2.add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Change");
        pac2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        jPanel9.add(pac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 85, 30));

        pac1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac1pac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac1pac_mexit(evt);
            }
        });
        pac1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac1.add(ok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 28, 24));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Reset");
        pac1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 30));

        jPanel9.add(pac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 70, 30));

        olderr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel9.add(olderr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 200, 20));

        newerr2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel9.add(newerr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 200, 20));

        newerr1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel9.add(newerr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 200, 20));

        panel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 400, 260));

        jPanel21.add(panel6, "card7");

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_3.setBackground(new java.awt.Color(102, 102, 255));
        d1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l4.setForeground(new java.awt.Color(255, 255, 255));
        d1_l4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l4.setText("Current Accounts");
        d1_3.add(d1_l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));

        d1_l5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        d1_l5.setForeground(new java.awt.Color(255, 255, 255));
        d1_l5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l5.setText("0");
        d1_3.add(d1_l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));
        d1_3.add(emp13, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        jPanel35.add(d1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d1_4emp_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d1_4emp_mexit(evt);
            }
        });
        d1_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l6.setText("View Details");
        d1_4.add(d1_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_4.add(st10, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 8, 22, 15));

        jPanel35.add(d1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        panel1.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 110, 200, 120));

        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_5.setBackground(new java.awt.Color(102, 102, 255));
        d1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l7.setForeground(new java.awt.Color(255, 255, 255));
        d1_l7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l7.setText("Saving Accounts");
        d1_5.add(d1_l7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));

        d1_l8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        d1_l8.setForeground(new java.awt.Color(255, 255, 255));
        d1_l8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l8.setText("0");
        d1_5.add(d1_l8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));
        d1_5.add(emp14, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        jPanel36.add(d1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d1_6emp_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d1_6emp_mexit(evt);
            }
        });
        d1_6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l9.setText("View Details");
        d1_6.add(d1_l9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_6.add(st11, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 8, 22, 15));

        jPanel36.add(d1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        panel1.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 200, 120));

        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_7.setBackground(new java.awt.Color(102, 102, 255));
        d1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l10.setForeground(new java.awt.Color(255, 255, 255));
        d1_l10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l10.setText("Blocked Accounts");
        d1_7.add(d1_l10, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));

        d1_l11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        d1_l11.setForeground(new java.awt.Color(255, 255, 255));
        d1_l11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l11.setText("0");
        d1_7.add(d1_l11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));
        d1_7.add(emp15, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        jPanel38.add(d1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                d1_8emp_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                d1_8emp_mexit(evt);
            }
        });
        d1_8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l12.setText("View Details");
        d1_8.add(d1_l12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_8.add(st12, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 8, 22, 15));

        jPanel38.add(d1_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        panel1.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 200, 120));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ac1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ms_enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ms_exit(evt);
            }
        });
        ac1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac1.setText("Create account");
        ac1.add(lac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        ac1.add(e1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel3.add(ac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 160, 40));

        ac2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac2action_emp(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ms_enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ms_exit(evt);
            }
        });
        ac2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac2.setText("Search account");
        ac2.add(lac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        ac2.add(e2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel3.add(ac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 160, 40));

        ac3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ms_enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ms_exit(evt);
            }
        });
        ac3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac3.setText("Update account");
        ac3.add(lac3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        ac3.add(e3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel3.add(ac3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 85, 160, 40));

        ac4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac4action_emp(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ms_enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ms_exit(evt);
            }
        });
        ac4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac4.setText("Delete account");
        ac4.add(lac4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        ac4.add(e4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel3.add(ac4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 85, 160, 40));

        ac7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac7action_emp(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac7ac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac7ac_mexit(evt);
            }
        });
        ac7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac7.setText("Activate Account");
        ac7.add(lac7, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        ac7.add(e7, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel3.add(ac7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 160, 40));

        ac8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac8action_emp(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac8ac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac8ac_mexit(evt);
            }
        });
        ac8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac8.setText("Block Account");
        ac8.add(lac8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 5, 110, 30));
        ac8.add(e8, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel3.add(ac8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 160, 40));

        panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 470, 200));

        jPanel21.add(panel1, "card8");

        insertion_acc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "New Account", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        insertion_acc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel16.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Back");
        jPanel16.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        insertion_acc.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        aspane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Entry Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane1.setFocusCycleRoot(true);
        aspane1.setFocusTraversalPolicyProvider(true);
        aspane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setText("Name");
        aspane1.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));

        jLabel70.setText("Father Name");
        aspane1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, 25));

        jTextField22.setEditable(false);
        jTextField22.setText("+92");
        aspane1.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 30, 25));

        jLabel71.setText("CNIC");
        aspane1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 80, 25));

        dob.setAutoscrolls(true);
        dob.setFocusCycleRoot(true);
        dob.setFocusTraversalPolicyProvider(true);
        dob.setInheritsPopupMenu(true);
        aspane1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 25));
        aspane1.add(n12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, 25));
        aspane1.add(n23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 30, 25));
        aspane1.add(n24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 30, 25));

        pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 80, 80));

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 0, 153));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Upload Image");
        jLabel73.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel73MouseClicked(evt);
            }
        });
        aspane1.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 80, 30));
        aspane1.add(n25, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 30, 25));

        f4.setBackground(new java.awt.Color(240, 240, 240));
        f4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        f4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Account Type", "Saving", "Current" }));
        f4.setBorder(null);
        f4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f4ActionPerformed(evt);
            }
        });
        f4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f4KeyPressed(evt);
            }
        });
        aspane1.add(f4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 25));

        jLabel74.setText("Contect");
        aspane1.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 50, 25));
        aspane1.add(n26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 30, 25));

        jLabel75.setText("DateOfBirth");
        aspane1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 25));

        f3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f3KeyTyped(evt);
            }
        });
        aspane1.add(f3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 25));
        aspane1.add(n27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 30, 25));

        f5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f5KeyTyped(evt);
            }
        });
        aspane1.add(f5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 25));

        jLabel76.setText("Account type");
        aspane1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 90, 25));
        aspane1.add(n28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 312, 30, 25));

        jLabel77.setText("Email");
        aspane1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 80, 25));

        f6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f6KeyTyped(evt);
            }
        });
        aspane1.add(f6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 25));

        jLabel78.setText("Postal No");
        aspane1.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 60, 25));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        f12.setColumns(20);
        f12.setRows(5);
        f12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f12KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(f12);

        aspane1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 380, 30));

        jLabel79.setText("Address");
        aspane1.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 60, 30));
        aspane1.add(n30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 30, 25));

        f9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f9KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f9KeyTyped(evt);
            }
        });
        aspane1.add(f9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 100, 25));

        f11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f11KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f11KeyTyped(evt);
            }
        });
        aspane1.add(f11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 130, 25));

        f7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f7KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f7KeyTyped(evt);
            }
        });
        aspane1.add(f7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 130, 25));

        jLabel85.setText("Balance");
        aspane1.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 60, 25));
        aspane1.add(n31, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 30, 25));
        aspane1.add(n32, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 30, 25));
        aspane1.add(b13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 30, 25));

        jLabel88.setText("Gender");
        aspane1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 50, 25));

        f8.setBackground(new java.awt.Color(240, 240, 240));
        f8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        f8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));
        f8.setBorder(null);
        f8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f8ActionPerformed(evt);
            }
        });
        f8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f8KeyPressed(evt);
            }
        });
        aspane1.add(f8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 130, 25));

        f2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foc_entry(evt);
            }
        });
        f2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f2KeyTyped(evt);
            }
        });
        aspane1.add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 140, 25));

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(204, 0, 0));
        jLabel89.setText("All fields required*");
        aspane1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 355, 120, 30));

        pac5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac5en_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac5en_mexit(evt);
            }
        });
        pac5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac5.add(ok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Submit");
        pac5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        aspane1.add(pac5, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 355, 85, -1));

        pac6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac6en_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac6en_mexit(evt);
            }
        });
        pac6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac6.add(ok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 28, 24));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Reset");
        pac6.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 30));

        aspane1.add(pac6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 355, 75, 30));

        er1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er1.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 55, 140, 15));

        er2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er2.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 140, 15));

        er3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er3.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 135, 140, 15));

        er4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er4.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 140, 15));

        er5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er5.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 255, 140, 15));

        er6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er6.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 295, 140, 15));

        er7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er7.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 175, 130, 15));

        er8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er8.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 140, 15));

        er9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er9.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 215, 130, 15));

        er10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er10.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 255, 130, 15));

        er12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er12.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 295, 130, 15));

        er13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er13.setForeground(new java.awt.Color(204, 0, 0));
        er13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aspane1.add(er13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 133, 110, 15));

        jLabel5.setText("Account Title");
        aspane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 90, 25));

        f13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f13FocusGained(evt);
            }
        });
        f13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f13KeyPressed(evt);
            }
        });
        aspane1.add(f13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 25));
        aspane1.add(b16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 30, 25));

        er11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er11.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 215, 140, 15));

        insertion_acc.add(aspane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 75, 560, 400));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Account No");
        insertion_acc.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 90, 30));
        insertion_acc.add(emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 30, 30));

        f1.setEditable(false);
        f1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        f1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        f1.setText("emp0047");
        f1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insertion_acc.add(f1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 140, 30));

        jPanel21.add(insertion_acc, "card8");

        action_acc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N
        action_acc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                action_accred_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                action_accred_mexit(evt);
            }
        });
        action_acc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aspane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Profile Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("Name");
        aspane.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 168, 90, 25));

        s2f.setEditable(false);
        aspane.add(s2f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 100, 165, 25));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Father Name");
        aspane.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 204, 90, 25));

        jTextField11.setEditable(false);
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("+92");
        aspane.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 205, 32, 25));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("CNIC");
        aspane.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 90, 25));
        aspane.add(n11v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 168, 30, 25));
        aspane.add(n13lk, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 30, 25));
        aspane.add(n14v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 204, 30, 25));

        picsff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane.add(picsff, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 30, 100, 95));
        aspane.add(n15sk, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 30, 25));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("Contect");
        aspane.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 205, 75, 25));
        aspane.add(n16k, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 205, 30, 25));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("DateOfBirth");
        aspane.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 75, 25));

        s5f.setEditable(false);
        aspane.add(s5f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 204, 165, 25));
        aspane.add(n17v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 30, 25));

        s6f.setEditable(false);
        aspane.add(s6f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 240, 165, 25));
        aspane.add(n18v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 30, 25));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setText("Email");
        aspane.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 345, 90, 25));

        s7f.setEditable(false);
        s7f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                s7fMouseEntered(evt);
            }
        });
        aspane.add(s7f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 345, 420, 25));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setText("Account type");
        aspane.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 275, 90, 25));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel55.setText("Address");
        aspane.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 90, 25));
        aspane.add(n20v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 345, 30, 25));

        s12af.setEditable(false);
        aspane.add(s12af, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 205, 96, 25));

        s8f.setEditable(false);
        aspane.add(s8f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 275, 165, 25));
        aspane.add(n21ks, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 275, 30, 25));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel63.setText("Account Status");
        aspane.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 25));
        aspane.add(b5v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 30, 25));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel64.setText("Account No");
        aspane.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));
        aspane.add(b6v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 275, 30, 25));
        aspane.add(b7v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, 25));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel67.setText("Gender");
        aspane.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 75, 25));

        s9cf.setEditable(false);
        aspane.add(s9cf, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 380, 420, 25));

        s1f.setEditable(false);
        aspane.add(s1f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 30, 165, 25));

        s3f.setEditable(false);
        aspane.add(s3f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 168, 165, 25));

        s4zf.setEditable(false);
        s4zf.setText("18-02-2000 |dd/MM/y");
        s4zf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                s4zfMouseEntered(evt);
            }
        });
        aspane.add(s4zf, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 240, 130, 25));

        s10sf.setEditable(false);
        aspane.add(s10sf, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 275, 130, 25));

        joindatek.setEditable(false);
        joindatek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                joindatekMouseEntered(evt);
            }
        });
        aspane.add(joindatek, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 310, 165, 25));
        aspane.add(n44v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 30, 25));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel72.setText("Register Date");
        aspane.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 90, 25));
        aspane.add(n19v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 30, 25));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setText("ATM Account");
        aspane.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 65, 90, 25));

        s13f.setEditable(false);
        aspane.add(s13f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 65, 165, 25));

        s15sf.setEditable(false);
        aspane.add(s15sf, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 170, 130, 25));

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel128.setText("Postal Code");
        aspane.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 275, 75, 25));

        s16f.setEditable(false);
        aspane.add(s16f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 134, 165, 25));

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel132.setText("Account Title");
        aspane.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 134, 90, 25));
        aspane.add(b8v, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 134, 30, 25));

        s17df.setEditable(false);
        aspane.add(s17df, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 135, 130, 25));

        jLabel133.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel133.setText("ATM Status");
        aspane.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 135, 75, 25));
        aspane.add(b9j, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 135, 30, 25));
        aspane.add(n29o, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 30, 25));

        jLabel170.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel170.setText("ATM Register");
        aspane.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 75, 25));

        atm_date1.setEditable(false);
        atm_date1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atm_date1MouseEntered(evt);
            }
        });
        aspane.add(atm_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 310, 130, 25));

        action_acc.add(aspane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 600, 415));

        jPanel23w.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel23wMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel23wMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel23wMouseExited(evt);
            }
        });
        jPanel23w.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back1e.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel23w.add(back1e, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Back");
        jPanel23w.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        action_acc.add(jPanel23w, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        pac77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac77MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac77red_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac77red_mexit(evt);
            }
        });
        pac77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac77.add(b44l, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("Delete");
        pac77.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        action_acc.add(pac77, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 460, 85, 30));

        pac99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac99MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac99blu_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac99blu_mexit(evt);
            }
        });
        pac99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac99.add(b23kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("Unblock");
        pac99.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        action_acc.add(pac99, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 460, 85, 30));

        pac101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac101MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac101red_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac101red_mexit(evt);
            }
        });
        pac101.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac101.add(b12d, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Block");
        pac101.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        action_acc.add(pac101, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 460, 85, 30));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setText("Save Profile");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        action_acc.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 110, 30));

        jPanel21.add(action_acc, "card9");

        search_acc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Searching", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        search_acc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        spane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search1j.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search1jFocusGained(evt);
            }
        });
        search1j.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search1jKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1jKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search1jKeyTyped(evt);
            }
        });
        spane.add(search1j, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 290, 30));

        jPanel27jj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27jjMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel27jjMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel27jjMouseExited(evt);
            }
        });
        jPanel27jj.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27jj.add(srchjsjs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 35, 35));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Search");
        jPanel27jj.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, 53, 35));

        spane.add(jPanel27jj, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 155, 100, 35));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Account Data");
        spane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 30));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("Search by");
        spane.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 30));

        rd32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd32.setText("Account number");
        rd32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd32redio_action(evt);
            }
        });
        spane.add(rd32, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        rd11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd11.setSelected(true);
        rd11.setText("CNIC");
        rd11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd11redio_action(evt);
            }
        });
        spane.add(rd11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 80, -1));

        searcherr.setForeground(new java.awt.Color(204, 0, 0));
        spane.add(searcherr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 290, 20));

        search_acc.add(spane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 530, 200));

        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel24MouseExited(evt);
            }
        });
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back22.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel24.add(back22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setText("Back");
        jPanel24.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        search_acc.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(search_acc, "card10");

        update_acc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Update Record", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        update_acc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aspane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Entry Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel80.setText("Name");
        aspane2.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel81.setText("Father Name");
        aspane2.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, 25));

        jTextField31.setEditable(false);
        jTextField31.setText("+92");
        aspane2.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 30, 25));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel82.setText("CNIC");
        aspane2.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 80, 25));
        aspane2.add(u3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 25));
        aspane2.add(n33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, 25));
        aspane2.add(n34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 30, 25));
        aspane2.add(n35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 30, 25));

        upic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane2.add(upic, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 80, 80));

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 153));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Update Image");
        jLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel86MouseClicked(evt);
            }
        });
        aspane2.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 80, 30));
        aspane2.add(n36, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 30, 25));

        u4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        u4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Account type", "Saving", "Current" }));
        u4.setBorder(null);
        u4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u4ActionPerformed(evt);
            }
        });
        aspane2.add(u4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 25));

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel87.setText("Contect");
        aspane2.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 50, 25));
        aspane2.add(n37, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 30, 25));

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel90.setText("DateOfBirth");
        aspane2.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 25));
        aspane2.add(u2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 25));
        aspane2.add(n38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 30, 25));

        u5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                u5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                u5KeyTyped(evt);
            }
        });
        aspane2.add(u5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 25));

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel91.setText("Account type");
        aspane2.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 80, 25));
        aspane2.add(n39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 312, 30, 25));

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel92.setText("Email");
        aspane2.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 80, 25));

        u6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                u6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                u6KeyTyped(evt);
            }
        });
        aspane2.add(u6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 25));

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel93.setText("Postal Code");
        aspane2.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 25));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        u12.setColumns(20);
        u12.setRows(5);
        jScrollPane4.setViewportView(u12);

        aspane2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 380, 30));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel94.setText("Address");
        aspane2.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 60, 30));
        aspane2.add(n41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 30, 25));

        u9.setText("3051738594");
        u9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                u9KeyTyped(evt);
            }
        });
        aspane2.add(u9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 100, 25));

        u7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                u7KeyTyped(evt);
            }
        });
        aspane2.add(u7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 25));
        aspane2.add(n42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 30, 25));
        aspane2.add(n43, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 30, 25));
        aspane2.add(b14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 30, 25));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel97.setText("Gender");
        aspane2.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 50, 25));

        u8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        u8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female", "Other" }));
        u8.setBorder(null);
        aspane2.add(u8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 130, 25));
        aspane2.add(u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 140, 25));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(204, 0, 0));
        jLabel98.setText("All fields required*");
        aspane2.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 120, 30));

        pac8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pac8blu_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac8blu_mexit(evt);
            }
        });
        pac8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac8.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Update");
        pac8.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        aspane2.add(pac8, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 360, 85, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Title");
        aspane2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 60, 25));
        aspane2.add(u13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 130, 25));
        aspane2.add(n40, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 30, 25));

        update_acc.add(aspane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 560, 400));

        jPanel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel26MouseClicked(evt);
            }
        });
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel26.add(back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel99.setText("Back");
        jPanel26.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        update_acc.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(update_acc, "card11");

        up_search_acc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Update", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        up_search_acc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        spane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serupdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                serupdateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serupdateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                serupdateKeyTyped(evt);
            }
        });
        spane1.add(serupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 290, 30));

        jPanel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel29MouseExited(evt);
            }
        });
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel29.add(srch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 35, 35));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Search");
        jPanel29.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, 53, 35));

        spane1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 100, 35));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Account Data");
        spane1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 30));

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setText("Search by");
        spane1.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 80, 25));

        rd4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd4.setText("Account number");
        rd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd4rd_action(evt);
            }
        });
        spane1.add(rd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        rd5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd5.setSelected(true);
        rd5.setText("CNIC");
        rd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd5rd_action(evt);
            }
        });
        spane1.add(rd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 80, -1));

        uperror.setForeground(new java.awt.Color(204, 0, 0));
        spane1.add(uperror, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 290, 15));

        up_search_acc.add(spane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 530, 190));

        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel30MouseClicked(evt);
            }
        });
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back4.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel30.add(back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel102.setText("Back");
        jPanel30.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        up_search_acc.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(up_search_acc, "card12");

        bnk_block.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Accounts history details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        bnk_block.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel44MouseClicked(evt);
            }
        });
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back9.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel44.add(back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel121.setText("Back");
        jPanel44.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        bnk_block.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel49MouseClicked(evt);
            }
        });
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back16.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel49.add(back16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel155.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel155.setText("Back");
        jPanel49.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        bnk_block.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        bnc_history1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Account No", "Date & Time", "History Type", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(bnc_history1);

        bnk_block.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 630, 380));

        tr1.setEditable(false);
        bnk_block.add(tr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 462, 150, 30));

        tr2.setEditable(false);
        bnk_block.add(tr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 462, 140, 30));

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton10.setText("Save as PDF");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        bnk_block.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 462, 120, 30));

        jLabel160.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel160.setText("Account Title");
        bnk_block.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 462, 90, 30));

        jLabel161.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("Account Number");
        bnk_block.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 462, 110, 30));

        r2.setText("Withdrawal history");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });
        bnk_block.add(r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 140, -1));

        r3.setText("Recieved history");
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });
        bnk_block.add(r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 45, 120, -1));

        r4.setText("Transection history");
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });
        bnk_block.add(r4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 45, 140, -1));

        r1.setSelected(true);
        r1.setText("Deposit history");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });
        bnk_block.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 120, -1));

        jDateChooser7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser7PropertyChange(evt);
            }
        });
        bnk_block.add(jDateChooser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 45, 100, 20));

        jLabel168.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel168.setText("From Date");
        bnk_block.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 60, 20));

        jDateChooser8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser8PropertyChange(evt);
            }
        });
        bnk_block.add(jDateChooser8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 45, 100, 20));

        jLabel169.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel169.setText("Date To");
        bnk_block.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 45, -1, 20));

        jPanel21.add(bnk_block, "card13");

        atm_table_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ATM Accounts Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        atm_table_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atm_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Bank Account", "ATM Account", "Status", "CNIC", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        atm_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atm_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(atm_table);

        atm_table_pnl.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 75, 635, 380));

        jPanel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel43MouseClicked(evt);
            }
        });
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back8.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel43.add(back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel120.setText("Back");
        jPanel43.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        atm_table_pnl.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jButton5.setText("Save as PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        atm_table_pnl.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 462, 110, 30));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        atm_table_pnl.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 45, 140, 20));

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel117.setText("Search by Name");
        atm_table_pnl.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 100, 20));

        jDateChooser5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser5PropertyChange(evt);
            }
        });
        atm_table_pnl.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 45, 125, 20));

        jLabel166.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel166.setText("From Date");
        atm_table_pnl.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 45, 60, 20));

        jDateChooser6.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser6PropertyChange(evt);
            }
        });
        atm_table_pnl.add(jDateChooser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 45, 120, 20));

        jLabel167.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel167.setText("To Date");
        atm_table_pnl.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 45, -1, 20));

        jButton13.setText("Refresh");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        atm_table_pnl.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 462, 90, 30));

        jPanel21.add(atm_table_pnl, "card14");

        accounts_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Accounts Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        accounts_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel42MouseClicked(evt);
            }
        });
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back7.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel42.add(back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel119.setText("Back");
        jPanel42.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        accounts_pnl.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        accounts_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Bank Account", "Account Type", "Status", "CNIC", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accounts_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accounts_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accounts_table);

        accounts_pnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 75, 635, 380));

        jButton3.setText("Save as PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        accounts_pnl.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 462, 110, 30));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        accounts_pnl.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 45, 150, 22));

        jLabel158.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel158.setText("Search by Name");
        accounts_pnl.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 95, 22));

        jLabel164.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel164.setText("From Date");
        accounts_pnl.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 45, 60, 22));

        jDateChooser3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser3PropertyChange(evt);
            }
        });
        accounts_pnl.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 45, 125, 22));

        jLabel165.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel165.setText("To Date");
        accounts_pnl.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 45, -1, 22));

        jDateChooser4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser4PropertyChange(evt);
            }
        });
        accounts_pnl.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 45, 120, 22));

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton12.setText("Refresh");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        accounts_pnl.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 462, 100, 30));

        jPanel21.add(accounts_pnl, "card15");

        saving_acc_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Saving Accounts Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        saving_acc_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel33MouseClicked(evt);
            }
        });
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back6.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel33.add(back6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel118.setText("Back");
        jPanel33.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        saving_acc_pnl.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Bank Account", "CNIC", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        saving_acc_pnl.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 580, 420));

        jPanel21.add(saving_acc_pnl, "card16");

        main_profile.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Account Profile", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        main_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aspane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Profile Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Name");
        aspane3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 90, 25));

        m2b.setEditable(false);
        aspane3.add(m2b, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 105, 165, 25));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setText("Father Name");
        aspane3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 245, 90, 25));

        jTextField12.setEditable(false);
        jTextField12.setText("+92");
        aspane3.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 245, 30, 25));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setText("CNIC");
        aspane3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 90, 25));
        aspane3.add(n45o, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 30, 25));
        aspane3.add(n46, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 175, 30, 25));
        aspane3.add(n47o, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, 30, 25));

        pics1k.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane3.add(pics1k, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 30, 100, 100));
        aspane3.add(n48, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 30, 25));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel83.setText("Contect");
        aspane3.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 245, 75, 25));
        aspane3.add(n49, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 245, 30, 25));

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel103.setText("DateOfBirth");
        aspane3.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 175, 75, 25));

        m5o.setEditable(false);
        aspane3.add(m5o, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 245, 165, 25));
        aspane3.add(n50o, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 30, 25));

        m6i.setEditable(false);
        aspane3.add(m6i, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 280, 165, 25));

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel104.setText("Account type");
        aspane3.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 90, 25));
        aspane3.add(n51o, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 385, 30, 25));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel105.setText("Email");
        aspane3.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 90, 25));

        m7t.setEditable(false);
        m7t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m7tMouseEntered(evt);
            }
        });
        aspane3.add(m7t, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 350, 420, 25));

        m13o.setEditable(false);
        aspane3.add(m13o, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 140, 130, 25));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel106.setText("Postal Code");
        aspane3.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 75, 25));
        aspane3.add(n52, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 30, 25));

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel107.setText("Address");
        aspane3.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 385, 90, 25));
        aspane3.add(n53o, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 30, 25));

        m12y.setEditable(false);
        aspane3.add(m12y, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 245, 98, 25));

        m8y.setEditable(false);
        aspane3.add(m8y, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 280, 130, 25));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel111.setText("ATM Status");
        aspane3.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 75, 25));
        aspane3.add(n54, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 30, 25));

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel113.setText("Account Status");
        aspane3.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 105, 90, 25));
        aspane3.add(b11u, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 105, 30, 25));
        aspane3.add(b12n, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 30, 25));

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel115.setText("Gender");
        aspane3.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 75, 25));

        m15t.setEditable(false);
        aspane3.add(m15t, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 385, 420, 25));

        m3j.setEditable(false);
        aspane3.add(m3j, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 210, 165, 25));

        m4p.setEditable(false);
        m4p.setText("18-02-2000 |dd/MM/yyyy");
        m4p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m4pMouseEntered(evt);
            }
        });
        aspane3.add(m4p, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 175, 130, 25));

        m10v.setEditable(false);
        aspane3.add(m10v, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 140, 165, 25));

        m11i.setEditable(false);
        aspane3.add(m11i, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 210, 130, 25));

        m9o.setEditable(false);
        m9o.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m9oMouseEntered(evt);
            }
        });
        aspane3.add(m9o, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 315, 165, 25));
        aspane3.add(n56o, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 315, 30, 25));

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel116.setText("Register Date");
        aspane3.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 315, 90, 25));
        aspane3.add(n69h, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 175, 30, 25));

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel134.setText("ATM Account");
        aspane3.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 175, 90, 25));

        m16o.setEditable(false);
        aspane3.add(m16o, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 175, 165, 25));
        aspane3.add(b19b, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 30, 25));

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel135.setText("Account Title");
        aspane3.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 90, 25));

        m17n.setEditable(false);
        aspane3.add(m17n, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 70, 165, 25));

        m1j.setEditable(false);
        aspane3.add(m1j, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 30, 165, 25));

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel114.setText("Account No");
        aspane3.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));
        aspane3.add(b15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, 25));
        aspane3.add(n44, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 315, 30, 25));

        jLabel171.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel171.setText("ATM Register");
        aspane3.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 315, 75, 25));

        atm_date.setEditable(false);
        atm_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atm_dateMouseEntered(evt);
            }
        });
        aspane3.add(atm_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 315, 130, 25));

        main_profile.add(aspane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 600, 420));

        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back5k.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel19.add(back5k, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel117j.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117j.setText("Back");
        jPanel19.add(jLabel117j, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        main_profile.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jButton8.setText("Save Profile ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        main_profile.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 120, 30));

        jPanel21.add(main_profile, "card17");

        newatm.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "New ATM Account", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        newatm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newatm.add(atmpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 220, 220));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 153));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Welcome to ATM service");
        newatm.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 300, 50));

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        newatm.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 220, 30));

        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(aok, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 40, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Create");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 50, 30));

        newatm.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 100, 30));

        aterr.setForeground(new java.awt.Color(204, 0, 0));
        newatm.add(aterr, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 280, 20));

        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
        });
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back11.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel28.add(back11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel150.setText("Back");
        jPanel28.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        newatm.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jLabel157.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(0, 0, 204));
        jLabel157.setText("Bank Account Number");
        newatm.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 304, 180, 20));

        jPanel21.add(newatm, "card18");

        withdraw_money_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Withdrawal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        withdraw_money_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        out.setEditable(false);
        out.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        out.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                outFocusGained(evt);
            }
        });
        out.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                outKeyTyped(evt);
            }
        });
        withdraw_money_pnl.add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 250, 30));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel96.setText("Amount");
        withdraw_money_pnl.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 70, 30));

        dpb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dpb.setText("Withdraw Money");
        dpb.setEnabled(false);
        dpb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpbActionPerformed(evt);
            }
        });
        withdraw_money_pnl.add(dpb, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 150, 30));

        jLabel137.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Withdrawal Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        withdraw_money_pnl.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 460, 130));

        wth2.setEditable(false);
        withdraw_money_pnl.add(wth2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 250, 30));

        wth1.setEditable(false);
        withdraw_money_pnl.add(wth1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 250, 30));

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel138.setText("Account Title");
        withdraw_money_pnl.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 110, 30));

        jLabel139.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel139.setText("Account Number");
        withdraw_money_pnl.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 110, 30));

        jLabel140.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        withdraw_money_pnl.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 460, 140));

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel142.setText("Account Number");
        withdraw_money_pnl.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 100, 30));
        withdraw_money_pnl.add(sender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 40, 30));

        with.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        with.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                withFocusGained(evt);
            }
        });
        with.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                withKeyPressed(evt);
            }
        });
        withdraw_money_pnl.add(with, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 250, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Check Account");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        withdraw_money_pnl.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 150, 30));

        accerr6.setForeground(new java.awt.Color(204, 0, 0));
        withdraw_money_pnl.add(accerr6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 250, 20));

        jLabel141.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Action board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        withdraw_money_pnl.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 460, 140));

        accerr7.setForeground(new java.awt.Color(204, 0, 0));
        withdraw_money_pnl.add(accerr7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 250, 20));

        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel37MouseClicked(evt);
            }
        });
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back12.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel37.add(back12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel151.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel151.setText("Back");
        jPanel37.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        withdraw_money_pnl.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(withdraw_money_pnl, "card19");

        balance_history_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Balance Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        balance_history_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bnc_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Account No", "Date  & Time", "History Type", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(bnc_history);

        balance_history_pnl.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 630, 380));

        jPanel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel45MouseClicked(evt);
            }
        });
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back10.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel45.add(back10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel136.setText("Back");
        jPanel45.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        balance_history_pnl.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jLabel156.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel156.setText("History type");
        balance_history_pnl.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 462, 80, 30));

        hit1.setEditable(false);
        balance_history_pnl.add(hit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 462, 160, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Save as PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        balance_history_pnl.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 462, 110, 30));

        jLabel159.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel159.setText("Search by Name");
        balance_history_pnl.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 95, 22));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        balance_history_pnl.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 45, 150, 22));

        jLabel162.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel162.setText("From Date");
        balance_history_pnl.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 45, 60, 22));

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        balance_history_pnl.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 45, 125, 22));

        jLabel163.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel163.setText("To Date");
        balance_history_pnl.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 45, -1, 22));

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        balance_history_pnl.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 45, 120, 22));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton11.setText("Refresh");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        balance_history_pnl.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 462, 90, 30));

        jPanel21.add(balance_history_pnl, "card20");

        send_money_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Transection", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        send_money_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snd1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        snd1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                snd1FocusGained(evt);
            }
        });
        snd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snd1ActionPerformed(evt);
            }
        });
        snd1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                snd1KeyPressed(evt);
            }
        });
        send_money_pnl.add(snd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 260, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Sender Account");
        send_money_pnl.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 120, 30));

        snd2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        snd2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                snd2FocusGained(evt);
            }
        });
        snd2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                snd2KeyPressed(evt);
            }
        });
        send_money_pnl.add(snd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 260, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Amount");
        send_money_pnl.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 80, 30));
        send_money_pnl.add(receiver, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 40, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        send_money_pnl.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 120, 30));
        send_money_pnl.add(sender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 40, 30));

        jLabel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Receiver Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 51, 204))); // NOI18N
        send_money_pnl.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 280, 130));

        jLabel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sender Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        send_money_pnl.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 290, 130));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Account Title");
        send_money_pnl.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 100, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Account Number");
        send_money_pnl.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 100, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Account Number");
        send_money_pnl.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 100, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Account Title");
        send_money_pnl.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 100, 30));

        rc2.setEditable(false);
        send_money_pnl.add(rc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 160, 30));

        sn1.setEditable(false);
        send_money_pnl.add(sn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 160, 30));

        sn2.setEditable(false);
        send_money_pnl.add(sn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 160, 30));

        rc1.setEditable(false);
        send_money_pnl.add(rc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 160, 30));

        snd.setEditable(false);
        snd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        snd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sndFocusGained(evt);
            }
        });
        snd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sndKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sndKeyTyped(evt);
            }
        });
        send_money_pnl.add(snd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 250, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Receiver Account");
        send_money_pnl.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 120, 30));

        sndbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sndbtn.setText("Send");
        sndbtn.setEnabled(false);
        sndbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sndbtnActionPerformed(evt);
            }
        });
        send_money_pnl.add(sndbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 120, 30));

        jLabel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Transection Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        send_money_pnl.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 570, 120));

        jLabel149.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Action board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        send_money_pnl.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 570, 170));

        accerr2.setForeground(new java.awt.Color(204, 0, 0));
        send_money_pnl.add(accerr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 260, 20));

        accerr3.setForeground(new java.awt.Color(204, 0, 0));
        send_money_pnl.add(accerr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 260, 20));

        accerr4.setForeground(new java.awt.Color(204, 0, 0));
        send_money_pnl.add(accerr4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 250, 20));

        jPanel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel46MouseClicked(evt);
            }
        });
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back13.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel46.add(back13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel152.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel152.setText("Back");
        jPanel46.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        send_money_pnl.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(send_money_pnl, "card21");

        deposit_mony_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Deposit", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        deposit_mony_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Amount");
        deposit_mony_pnl.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 110, 30));

        dpvalue2.setEditable(false);
        dpvalue2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dpvalue2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dpvalue2FocusGained(evt);
            }
        });
        dpvalue2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dpvalue2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dpvalue2KeyTyped(evt);
            }
        });
        deposit_mony_pnl.add(dpvalue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 250, 30));

        dpbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dpbtn.setText("Deposit Money");
        dpbtn.setEnabled(false);
        dpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpbtnActionPerformed(evt);
            }
        });
        deposit_mony_pnl.add(dpbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 130, 30));

        jLabel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Deposit Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        deposit_mony_pnl.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 470, 140));

        dp2.setEditable(false);
        deposit_mony_pnl.add(dp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 250, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Account Number");
        deposit_mony_pnl.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 110, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Account Title");
        deposit_mony_pnl.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 110, 30));

        dp1.setEditable(false);
        deposit_mony_pnl.add(dp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 250, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Check Account");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        deposit_mony_pnl.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, 30));

        dpvalue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dpvalue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dpvalueFocusGained(evt);
            }
        });
        dpvalue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dpvalueKeyPressed(evt);
            }
        });
        deposit_mony_pnl.add(dpvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 250, 30));

        jLabel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Action board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        deposit_mony_pnl.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 470, 140));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("Account Number");
        deposit_mony_pnl.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 110, 30));
        deposit_mony_pnl.add(sender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 40, 30));

        jLabel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        deposit_mony_pnl.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 470, 140));

        accerr.setForeground(new java.awt.Color(204, 0, 0));
        deposit_mony_pnl.add(accerr, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 250, 20));

        accerr5.setForeground(new java.awt.Color(204, 0, 0));
        deposit_mony_pnl.add(accerr5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 250, 20));

        jPanel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel47MouseClicked(evt);
            }
        });
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back14.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel47.add(back14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel153.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel153.setText("Back");
        jPanel47.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        deposit_mony_pnl.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(deposit_mony_pnl, "card22");

        check_blnc_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Balance Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        check_blnc_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel143.setText("Account Number");
        check_blnc_pnl.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 110, 30));
        check_blnc_pnl.add(sender3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 40, 30));

        check.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        check.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                checkFocusGained(evt);
            }
        });
        check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMouseClicked(evt);
            }
        });
        check.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                checkKeyPressed(evt);
            }
        });
        check_blnc_pnl.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 250, 30));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Check Account");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        check_blnc_pnl.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 130, 30));

        jLabel144.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        check_blnc_pnl.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 480, 180));

        bnc1.setEditable(false);
        check_blnc_pnl.add(bnc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 250, 30));

        bnc2.setEditable(false);
        check_blnc_pnl.add(bnc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 250, 30));

        jLabel145.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel145.setText("Account Number");
        check_blnc_pnl.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 110, 30));

        jLabel146.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel146.setText("Account Title");
        check_blnc_pnl.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 110, 30));

        jLabel147.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Action board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        check_blnc_pnl.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 480, 140));

        bnc3.setEditable(false);
        check_blnc_pnl.add(bnc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 250, 30));

        jLabel148.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel148.setText("Account Balance");
        check_blnc_pnl.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 110, 30));

        accerr1.setForeground(new java.awt.Color(204, 0, 0));
        check_blnc_pnl.add(accerr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 250, 20));

        jPanel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel48MouseClicked(evt);
            }
        });
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back15.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel48.add(back15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel154.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel154.setText("Back");
        jPanel48.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        check_blnc_pnl.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(check_blnc_pnl, "card23");

        getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 42, 660, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        color = jPanel5.getBackground();
        c = jPanel5.getForeground();
        jLabel3.setForeground(Color.white);
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jPanel5.setBackground(Color.blue);
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        jLabel3.setForeground(c);
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jPanel5.setBackground(color);

    }//GEN-LAST:event_jPanel5MouseExited

    private void a2mouseclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2mouseclick

        URL pathh = getClass().getResource("/atm.png");
        ImageIcon photo = new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo0.getWidth(), top_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        top_logo0.setIcon(photo);
        top_title.setText("ATM Accounts");
        oldpass.setText(null);
        empy();
        newpass1.setText(null);
        newpass2.setText(null);
        olderr.setText(null);
        newerr1.setText(null);
        newerr2.setText(null);
        home_p.setBackground(new Color(102, 153, 255));
        a1.setBackground(new Color(102, 153, 255));
        a2.setBackground(new Color(0, 153, 102));
        a4.setBackground(new Color(102, 153, 255));
        a6.setBackground(new Color(102, 153, 255));
        a7.setBackground(new Color(102, 153, 255));
        color = a2.getBackground();
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(true);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        search1j.setText(null);
        serupdate.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        rd5.setSelected(true);
        rd4.setSelected(false);
        f_reset();
    }//GEN-LAST:event_a2mouseclick

    private void a2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseEntered
        // TODO add your handling code here:
        color = a2.getBackground();
        c = a2.getForeground();
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setForeground(Color.white);
        a2.setBackground(Color.blue);
    }//GEN-LAST:event_a2MouseEntered

    private void a2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseExited
        // TODO add your handling code here:
        jLabel4.setForeground(c);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        a2.setBackground(color);
    }//GEN-LAST:event_a2MouseExited

    private void a4mouseclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4mouseclick

        URL pathh = getClass().getResource("/acc.png");
        ImageIcon photo = new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo0.getWidth(), top_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        top_logo0.setIcon(photo);
        oldpass.setText(null);
        empy();
        newpass1.setText(null);
        newpass2.setText(null);
        olderr.setText(null);
        newerr1.setText(null);
        newerr2.setText(null);
        top_title.setText("Account Queries");
        home_p.setBackground(new Color(102, 153, 255));
        a1.setBackground(new Color(102, 153, 255));
        a2.setBackground(new Color(102, 153, 255));
        a4.setBackground(new Color(0, 153, 102));
        a6.setBackground(new Color(102, 153, 255));
        a7.setBackground(new Color(102, 153, 255));
        color = a4.getBackground();
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        search1j.setText(null);
        serupdate.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        rd5.setSelected(true);
        rd4.setSelected(false);
        f_reset();
    }//GEN-LAST:event_a4mouseclick

    private void a4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseEntered
        // TODO add your handling code here:
        color = a4.getBackground();
        c = a4.getForeground();
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setForeground(Color.white);
        a4.setBackground(Color.blue);

    }//GEN-LAST:event_a4MouseEntered

    private void a4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseExited
        // TODO add your handling code here:
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setForeground(c);
        a4.setBackground(color);
    }//GEN-LAST:event_a4MouseExited

    private void a6mouseclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6mouseclick

        URL pathh = getClass().getResource("/pro.png");
        ImageIcon photo = new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo0.getWidth(), top_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        top_logo0.setIcon(photo);
        oldpass.setText(null);
        empy();
        newpass1.setText(null);
        newpass2.setText(null);
        olderr.setText(null);
        newerr1.setText(null);
        newerr2.setText(null);
        top_title.setText("Account Profile");
        home_p.setBackground(new Color(102, 153, 255));
        a1.setBackground(new Color(102, 153, 255));
        a2.setBackground(new Color(102, 153, 255));
        a4.setBackground(new Color(102, 153, 255));
        a6.setBackground(new Color(0, 153, 102));
        a7.setBackground(new Color(102, 153, 255));
        color = a6.getBackground();
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(true);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        search1j.setText(null);
        serupdate.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        rd5.setSelected(true);
        rd4.setSelected(false);
        f_reset();
    }//GEN-LAST:event_a6mouseclick

    private void a6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseEntered
        // TODO add your handling code here:
        color = a6.getBackground();
        c = a6.getForeground();
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setForeground(Color.white);
        a6.setBackground(Color.blue);
    }//GEN-LAST:event_a6MouseEntered

    private void a6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseExited
        // TODO add your handling code here:
        jLabel7.setForeground(c);
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        a6.setBackground(color);
    }//GEN-LAST:event_a6MouseExited

    private void a7mouseclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7mouseclick
        URL pathh = getClass().getResource("/pass.jpg");
        ImageIcon photo = new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo0.getWidth(), top_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        top_logo0.setIcon(photo);
        top_title.setText("Change Password");
        empy();
        home_p.setBackground(new Color(102, 153, 255));
        a1.setBackground(new Color(102, 153, 255));
        a2.setBackground(new Color(102, 153, 255));
        a4.setBackground(new Color(102, 153, 255));
        a6.setBackground(new Color(102, 153, 255));
        a7.setBackground(new Color(0, 153, 102));
        color = a7.getBackground();
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(true);
        oldpass.requestFocus();
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        search1j.setText(null);
        serupdate.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        rd5.setSelected(true);
        rd4.setSelected(false);
        f_reset();
    }//GEN-LAST:event_a7mouseclick

    private void a7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseEntered
        // TODO add your handling code here:
        color = a7.getBackground();
        c = a7.getForeground();
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel8.setForeground(Color.white);
        a7.setBackground(Color.blue);
    }//GEN-LAST:event_a7MouseEntered

    private void a7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseExited
        // TODO add your handling code here:
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setForeground(c);
        a7.setBackground(color);
    }//GEN-LAST:event_a7MouseExited

    private void a1mouseclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1mouseclick
        // TODO add your handling code here
        oldpass.setText(null);
        newpass1.setText(null);
        newpass2.setText(null);
        olderr.setText(null);
        newerr1.setText(null);
        newerr2.setText(null);
        empy();
        URL pathh = getClass().getResource("/social_network-512.png");
        ImageIcon photo = new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo0.getWidth(), top_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        top_logo0.setIcon(photo);
        top_title.setText("Bank Accounts");
        home_p.setBackground(new Color(102, 153, 255));
        a1.setBackground(new Color(0, 153, 102));
        a2.setBackground(new Color(102, 153, 255));
        a4.setBackground(new Color(102, 153, 255));
        a6.setBackground(new Color(102, 153, 255));
        a7.setBackground(new Color(102, 153, 255));
        color = a1.getBackground();
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(true);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        search1j.setText(null);
        serupdate.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        rd5.setSelected(true);
        rd4.setSelected(false);
        f_reset();
    }//GEN-LAST:event_a1mouseclick

    private void a1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseEntered
        // TODO add your handling code here:
        color = a1.getBackground();
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        c = a1.getForeground();
        jLabel1.setForeground(Color.white);
        a1.setBackground(Color.blue);
    }//GEN-LAST:event_a1MouseEntered

    private void a1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseExited

        jLabel1.setForeground(c);
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        a1.setBackground(color);
    }//GEN-LAST:event_a1MouseExited

    private void home_pmouseclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_pmouseclick
        // TODO add your handling code here:
        URL pathh = getClass().getResource("/bank.png");
        ImageIcon photo = new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo0.getWidth(), top_logo0.getHeight(), java.awt.Image.SCALE_SMOOTH));
        top_logo0.setIcon(photo);
        top_title.setText("Home");
        oldpass.setText(null);
        empy();
        newpass1.setText(null);
        newpass2.setText(null);
        olderr.setText(null);
        newerr1.setText(null);
        newerr2.setText(null);
        home_p.setBackground(new Color(0, 153, 102));
        a1.setBackground(new Color(102, 153, 255));
        a2.setBackground(new Color(102, 153, 255));
        a4.setBackground(new Color(102, 153, 255));
        a6.setBackground(new Color(102, 153, 255));
        a7.setBackground(new Color(102, 153, 255));
        color = home_p.getBackground();
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(true);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        search1j.setText(null);
        serupdate.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        rd5.setSelected(true);
        rd4.setSelected(false);
        f_reset();
    }//GEN-LAST:event_home_pmouseclick

    private void home_pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_pMouseEntered
        // TODO add your handling code here:
        color = home_p.getBackground();
        c = home_p.getForeground();
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel19.setForeground(Color.white);
        home_p.setBackground(Color.blue);
    }//GEN-LAST:event_home_pMouseEntered

    private void home_pMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_pMouseExited
        // TODO add your handling code here:
        jLabel19.setForeground(c);
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14));
        home_p.setBackground(color);
    }//GEN-LAST:event_home_pMouseExited

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:
       int u = JOptionPane.showConfirmDialog(null, "Confirm to Cancle?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (u == JOptionPane.YES_OPTION) {
        pp.emp_account_login_status(em1.getText(),"offline");
        System.exit(0);
        }
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        // TODO add your handling code here:
        color = jPanel13.getBackground();
        c = jPanel13.getForeground();
        jLabel11.setForeground(Color.white);
        jPanel13.setBackground(Color.red);
        jPanel13.setToolTipText("Close Program");
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        // TODO add your handling code here:
        jLabel11.setForeground(c);
        jPanel13.setBackground(color);
    }//GEN-LAST:event_jPanel13MouseExited

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        // TODO add your handling code here:
        c = jPanel12.getBackground();
        jPanel12.setBackground(new Color(204, 204, 204));
        jPanel12.setToolTipText("Minimize Program");

    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        // TODO add your handling code here:
        jPanel12.setBackground(c);
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel11MouseDragged

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel11MousePressed

    private void d2_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2_2MouseClicked
        // TODO add your handling code here:
        back_rule2 = "home";
        like_s = "all";
        atm_account_datils("all", "", "","","");
        save_type = "ATM accounts list";
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(true);
         jTextField2.requestFocus();
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d2_2MouseClicked

    private void d2_2dash_h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2_2dash_h
        // TODO add your handling code here:
        d2_1.setBackground(new Color(240, 240, 240));
        d2_l1.setForeground(Color.black);
        d2_l2.setForeground(Color.black);
        d2_2.setBackground(new Color(102, 102, 255));
        d2_l3.setForeground(Color.white);
        d2_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d2_2dash_h

    private void d2_2dash_e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2_2dash_e
        // TODO add your handling code here:
        d2_1.setBackground(new Color(102, 102, 255));
        d2_l1.setForeground(Color.white);
        d2_l2.setForeground(Color.white);
        d2_2.setBackground(new Color(240, 240, 240));
        d2_l3.setForeground(Color.black);
        d2_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d2_2dash_e

    private void d3_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d3_2MouseClicked
        // TODO add your handling code here:
        back_rule2 = "home";
        like_s = "s";
        bank_account_datils("saving", "", "",null,null);
        save_type = "Saving Bank accounts list";
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d3_2MouseClicked

    private void d3_2dash_h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d3_2dash_h

        d3_1.setBackground(new Color(240, 240, 240));
        d3_l1.setForeground(Color.black);
        d3_l2.setForeground(Color.black);
        d3_2.setBackground(new Color(102, 102, 255));
        d3_l3.setForeground(Color.white);
        d3_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d3_2dash_h

    private void d3_2dash_e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d3_2dash_e
        // TODO add your handling code here:
        d3_1.setBackground(new Color(102, 102, 255));
        d3_l1.setForeground(Color.white);
        d3_l2.setForeground(Color.white);
        d3_2.setBackground(new Color(240, 240, 240));
        d3_l3.setForeground(Color.black);
        d3_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d3_2dash_e

    private void d9_2dash_h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_2dash_h
        // TODO add your handling code here:
        d9_1.setBackground(new Color(240, 240, 240));
        d9_l1.setForeground(Color.black);
        d9_l2.setForeground(Color.black);
        d9_2.setBackground(new Color(102, 102, 255));
        d9_l3.setForeground(Color.white);
        d9_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d9_2dash_h

    private void d9_2dash_e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_2dash_e
        // TODO add your handling code here:
        d9_1.setBackground(new Color(102, 102, 255));
        d9_l1.setForeground(Color.white);
        d9_l2.setForeground(Color.white);
        d9_2.setBackground(new Color(240, 240, 240));
        d9_l3.setForeground(Color.black);
        d9_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d9_2dash_e

    private void d8_2dash_h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_2dash_h
        // TODO add your handling code here:
        d8_1.setBackground(new Color(240, 240, 240));
        d8_l1.setForeground(Color.black);
        d8_l2.setForeground(Color.black);
        d8_2.setBackground(new Color(102, 102, 255));
        d8_l3.setForeground(Color.white);
        d8_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d8_2dash_h

    private void d8_2dash_e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_2dash_e
        // TODO add your handling code here:
        d8_1.setBackground(new Color(102, 102, 255));
        d8_l1.setForeground(Color.white);
        d8_l2.setForeground(Color.white);
        d8_2.setBackground(new Color(240, 240, 240));
        d8_l3.setForeground(Color.black);
        d8_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d8_2dash_e

    private void d7_2dash_h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_2dash_h

        d7_1.setBackground(new Color(240, 240, 240));
        d7_l1.setForeground(Color.black);
        d7_l2.setForeground(Color.black);
        d7_2.setBackground(new Color(102, 102, 255));
        d7_l3.setForeground(Color.white);
        d7_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d7_2dash_h

    private void d7_2dash_e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_2dash_e

        d7_1.setBackground(new Color(102, 102, 255));
        d7_l1.setForeground(Color.white);
        d7_l2.setForeground(Color.white);
        d7_2.setBackground(new Color(240, 240, 240));
        d7_l3.setForeground(Color.black);
        d7_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d7_2dash_e

    private void d1_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_2MouseClicked
        // TODO add your handling code here:
        back_rule2 = "home";
        like_s = "c";
        bank_account_datils("current", "", "",null,null);
        save_type = "Current Bank accounts list";
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d1_2MouseClicked

    private void d1_2dash_h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_2dash_h

        d1_1.setBackground(new Color(240, 240, 240));
        d1_l1.setForeground(Color.black);
        d1_l2.setForeground(Color.black);
        d1_2.setBackground(new Color(102, 102, 255));
        d1_l3.setForeground(Color.white);
        d1_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d1_2dash_h

    private void d1_2dash_e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_2dash_e

        d1_1.setBackground(new Color(102, 102, 255));
        d1_l1.setForeground(Color.white);
        d1_l2.setForeground(Color.white);
        d1_2.setBackground(new Color(240, 240, 240));
        d1_l3.setForeground(Color.black);
        d1_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d1_2dash_e

    private void d7_4bn_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_4bn_menter
        // TODO add your handling code here:
        d7_3.setBackground(new Color(240, 240, 240));
        d7_l41.setForeground(Color.black);
        d7_l51.setForeground(Color.black);
        d7_4.setBackground(new Color(102, 102, 255));
        d7_l6.setForeground(Color.white);
        d7_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d7_4bn_menter

    private void d7_4bn_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_4bn_mexit

        d7_3.setBackground(new Color(102, 102, 255));
        d7_l41.setForeground(Color.white);
        d7_l51.setForeground(Color.white);
        d7_4.setBackground(new Color(240, 240, 240));
        d7_l6.setForeground(Color.black);
        d7_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d7_4bn_mexit

    private void d8_4bn_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_4bn_menter

        d8_3.setBackground(new Color(240, 240, 240));
        d8_l4.setForeground(Color.black);
        d8_l5.setForeground(Color.black);
        d8_4.setBackground(new Color(102, 102, 255));
        d8_l6.setForeground(Color.white);
        d8_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d8_4bn_menter

    private void d8_4bn_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_4bn_mexit
        // TODO add your handling code here:
        d8_3.setBackground(new Color(102, 102, 255));
        d8_l4.setForeground(Color.white);
        d8_l5.setForeground(Color.white);
        d8_4.setBackground(new Color(240, 240, 240));
        d8_l6.setForeground(Color.black);
        d8_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d8_4bn_mexit

    private void d9_4bn_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_4bn_menter
        // TODO add your handling code here:
        d9_3.setBackground(new Color(240, 240, 240));
        d9_l4.setForeground(Color.black);
        d9_l5.setForeground(Color.black);
        d9_4.setBackground(new Color(102, 102, 255));
        d9_l6.setForeground(Color.white);
        d9_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d9_4bn_menter

    private void d9_4bn_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_4bn_mexit

        d9_3.setBackground(new Color(102, 102, 255));
        d9_l4.setForeground(Color.white);
        d9_l5.setForeground(Color.white);
        d9_4.setBackground(new Color(240, 240, 240));
        d9_l6.setForeground(Color.black);
        d9_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d9_4bn_mexit

    private void newpass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newpass2FocusGained
        // TODO add your handling code here:
        newerr2.setText(null);
    }//GEN-LAST:event_newpass2FocusGained

    private void newpass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            emp_pass_change();
        }
    }//GEN-LAST:event_newpass2KeyPressed

    private void oldpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldpassFocusGained
        // TODO add your handling code here:
        olderr.setText(null);
    }//GEN-LAST:event_oldpassFocusGained

    private void oldpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldpassKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            newpass1.requestFocus();
        }
    }//GEN-LAST:event_oldpassKeyPressed

    private void newpass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newpass1FocusGained
        // TODO add your handling code here:
        newerr1.setText(null);
    }//GEN-LAST:event_newpass1FocusGained

    private void newpass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            newpass2.requestFocus();
        }
    }//GEN-LAST:event_newpass1KeyPressed

    private void se1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se1MouseClicked

        if (see == 0) {
            oldpass.setEchoChar((char) 0);
            URL path30 = getClass().getResource("/unsee.jpg");
            ImageIcon photo30 = new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se1.getWidth(), se1.getHeight(), java.awt.Image.SCALE_SMOOTH));
            se1.setIcon(photo30);
            see = 1;
        } else if (see == 1) {
            oldpass.setEchoChar('•');
            oldpass.setForeground(Color.black);
            URL path30 = getClass().getResource("/see.png");
            ImageIcon photo30 = new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se1.getWidth(), se1.getHeight(), java.awt.Image.SCALE_SMOOTH));
            se1.setIcon(photo30);
            see = 0;
        }

    }//GEN-LAST:event_se1MouseClicked

    private void se2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se2MouseClicked
        // TODO add your handling code here:
        if (seee == 0) {
            newpass1.setEchoChar((char) 0);
            newpass2.setEchoChar((char) 0);
            URL path30 = getClass().getResource("/unsee.jpg");
            ImageIcon photo30 = new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se2.getWidth(), se2.getHeight(), java.awt.Image.SCALE_SMOOTH));
            se2.setIcon(photo30);
            seee = 1;
        } else if (seee == 1) {
            newpass1.setEchoChar('•');
            newpass2.setEchoChar('•');
            oldpass.setForeground(Color.black);
            URL path30 = getClass().getResource("/see.png");
            ImageIcon photo30 = new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se2.getWidth(), se2.getHeight(), java.awt.Image.SCALE_SMOOTH));
            se2.setIcon(photo30);
            seee = 0;
        }
    }//GEN-LAST:event_se2MouseClicked
    void emp_pass_change() {
        String pas1 = oldpass.getText();
        String pas2 = newpass1.getText();
        String pas3 = newpass2.getText();
        if (oldpass.getText().isEmpty() || newpass1.getText().isEmpty() || newpass2.getText().isEmpty()) {
            if (oldpass.getText().isEmpty()) {
                olderr.setText("Enter old password");
            }
            if (newpass1.getText().isEmpty()) {
                newerr1.setText("Enter new password");
            }
            if (newpass2.getText().isEmpty()) {
                newerr2.setText("Enter Confirm password");
            }
        } else {
            if (pp.getPassword_emp(pas1, em1.getText()) == true) {
                if (pas2.length() >= 8) {
                    if (pas3.length() >= 8) {
                        if (pas2.equals(pas3)) {
                            java.util.Date nowdate = new java.util.Date();
                            String drt = "Hello dear "+em2.getText()+"!\nYour Sky Bank account password is changed at " + String.valueOf(nowdate);
                            if (pp.emp_account_password_update(pas2, em1.getText()) == true) {
                               Thread t = new Thread(new Runnable(){
                                public void run(){
                                    if (net() == true) {
                                       em.send(em6.getText(), drt, "Security Alert");
                                       }
                                    }
                                });
                                t.start();
                                JOptionPane.showMessageDialog(this, "Passowrd changed successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                                oldpass.setText(null);
                                newpass1.setText(null);
                                newpass2.setText(null);
                                oldpass.requestFocus();
                            } else {
                                JOptionPane.showMessageDialog(this, "Passowrd not change", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            newerr2.setText("Confirm Password not matched");
                        }
                    } else {
                        newerr2.setText("Password lenght must be 8");
                    }
                } else {
                    newerr1.setText("Password lenght must be 8");
                }
            } else {
                olderr.setText("Old password did't match");
            }
        }
    }
    private void pac2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac2MouseClicked
        // TODO add your handling code here:
        emp_pass_change();
    }//GEN-LAST:event_pac2MouseClicked

    private void pac2pac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac2pac_menter
        // TODO add your handling code here:
        pac2.setBackground(Color.blue);
        jLabel25.setForeground(Color.white);
    }//GEN-LAST:event_pac2pac_menter

    private void pac2pac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac2pac_mexit
        // TODO add your handling code here:
        pac2.setBackground(new Color(240, 240, 240));
        jLabel25.setForeground(Color.black);
    }//GEN-LAST:event_pac2pac_mexit

    private void pac1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac1MouseClicked
        // TODO add your handling code here:
        oldpass.setText(null);
        newpass1.setText(null);
        newpass2.setText(null);
        olderr.setText(null);
        newerr1.setText(null);
        newerr2.setText(null);
    }//GEN-LAST:event_pac1MouseClicked

    private void pac1pac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac1pac_menter
        // TODO add your handling code here:
        pac1.setBackground(new Color(255, 51, 51));
        jLabel26.setForeground(Color.white);
    }//GEN-LAST:event_pac1pac_menter

    private void pac1pac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac1pac_mexit
        // TODO add your handling code here:
        pac1.setBackground(new Color(240, 240, 240));
        jLabel26.setForeground(Color.black);
    }//GEN-LAST:event_pac1pac_mexit

    private void d1_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_4MouseClicked
        // TODO add your handling code here:
        bank_account_datils("current", "", "",null,null);
        like_s = "c";
        back_rule2 = "panel";
        save_type = "Current Bank accounts list";
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d1_4MouseClicked

    private void d1_4emp_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_4emp_menter

        d1_3.setBackground(new Color(240, 240, 240));
        d1_l4.setForeground(Color.black);
        d1_l5.setForeground(Color.black);
        d1_4.setBackground(new Color(102, 102, 255));
        d1_l6.setForeground(Color.white);
        d1_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d1_4emp_menter

    private void d1_4emp_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_4emp_mexit
        // TODO add your handling code here:
        d1_3.setBackground(new Color(102, 102, 255));
        d1_l4.setForeground(Color.white);
        d1_l5.setForeground(Color.white);
        d1_4.setBackground(new Color(240, 240, 240));
        d1_l6.setForeground(Color.black);
        d1_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d1_4emp_mexit

    private void d1_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_6MouseClicked
        // TODO add your handling code here:
        back_rule2 = "panel";
        like_s = "s";
        bank_account_datils("saving", "", "",null,null);
        save_type = "Saving Bank accounts list";
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        panel1.setVisible(false);
        main_profile.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_d1_6MouseClicked

    private void d1_6emp_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_6emp_menter
        // TODO add your handling code here:
        d1_5.setBackground(new Color(240, 240, 240));
        d1_l7.setForeground(Color.black);
        d1_l8.setForeground(Color.black);
        d1_6.setBackground(new Color(102, 102, 255));
        d1_l9.setForeground(Color.white);
        d1_l9.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d1_6emp_menter

    private void d1_6emp_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_6emp_mexit

        d1_5.setBackground(new Color(102, 102, 255));
        d1_l7.setForeground(Color.white);
        d1_l8.setForeground(Color.white);
        d1_6.setBackground(new Color(240, 240, 240));
        d1_l9.setForeground(Color.black);
        d1_l9.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d1_6emp_mexit

    private void d1_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_8MouseClicked
        // TODO add your handling code here:
        like_s = "b";
        bank_account_datils("block", "", "",null,null);
        save_type = "Block Bank accounts list";
        atm_table_pnl.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_d1_8MouseClicked

    private void d1_8emp_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_8emp_menter
        // TODO add your handling code here:
        d1_7.setBackground(new Color(240, 240, 240));
        d1_l10.setForeground(Color.black);
        d1_l11.setForeground(Color.black);
        d1_8.setBackground(new Color(102, 102, 255));
        d1_l12.setForeground(Color.white);
        d1_l12.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d1_8emp_menter

    private void d1_8emp_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_8emp_mexit
        // TODO add your handling code here:
        d1_7.setBackground(new Color(102, 102, 255));
        d1_l10.setForeground(Color.white);
        d1_l11.setForeground(Color.white);
        d1_8.setBackground(new Color(240, 240, 240));
        d1_l12.setForeground(Color.black);
        d1_l12.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d1_8emp_mexit

    private void ac1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac1MouseClicked

        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        insertion_acc.setVisible(true);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        f1.setText(auto_bank_accounts());
        f2.requestFocusInWindow();
    }//GEN-LAST:event_ac1MouseClicked

    private void ac2action_emp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac2action_emp
        // TODO add your handling code here:
        atm_back = 1;
        action_pnl = 1;
        rd32.setText("Bank Account number");
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        update_acc.setVisible(false);
        search1j.requestFocus();
    }//GEN-LAST:event_ac2action_emp

    private void ac3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac3MouseClicked
        // TODO add your handling code here:
        atm_back = 1;
        rd32.setText("Bank Account number");
        up_search_acc.setVisible(true);
        serupdate.requestFocus();
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_ac3MouseClicked

    private void ac4action_emp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac4action_emp
        // TODO add your handling code here:
        atm_back = 1;
        action_pnl = 1;
        rd32.setText("Bank Account number");
        main_profile.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        update_acc.setVisible(false);
        search1j.requestFocus();
    }//GEN-LAST:event_ac4action_emp

    private void ac7action_emp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac7action_emp
        // TODO add your handling code here:
        atm_back = 1;
        action_pnl = 1;
        rd32.setText("Bank Account number");
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        update_acc.setVisible(false);
        search1j.requestFocus();
    }//GEN-LAST:event_ac7action_emp

    private void ac7ac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac7ac_menter
        // TODO add your handling code here:
        lac7.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac7.setBackground(Color.blue);
        lac7.setForeground(Color.white);
    }//GEN-LAST:event_ac7ac_menter

    private void ac7ac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac7ac_mexit
        // TODO add your handling code here:
        lac7.setFont(new java.awt.Font("Tahoma", 1, 12));
        ac7.setBackground(new Color(102, 102, 255));
        lac7.setForeground(Color.black);
        ac7.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ac7ac_mexit

    private void ac8action_emp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac8action_emp
        // TODO add your handling code here:
        main_profile.setVisible(false);
        action_pnl = 1;
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        atm_back = 1;
        rd32.setText("Bank Account number");
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        update_acc.setVisible(false);
        search1j.requestFocus();
    }//GEN-LAST:event_ac8action_emp

    private void ac8ac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac8ac_menter

        lac8.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac8.setBackground(Color.blue);
        lac8.setForeground(Color.white);
    }//GEN-LAST:event_ac8ac_menter

    private void ac8ac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac8ac_mexit
        // TODO add your handling code here:
        lac8.setFont(new java.awt.Font("Tahoma", 1, 12));
        ac8.setBackground(new Color(102, 102, 255));
        lac8.setForeground(Color.black);
        ac8.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ac8ac_mexit

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
        f_reset();
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(true);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);

    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
        jLabel41.setForeground(Color.blue);
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        // TODO add your handling code here:
        jLabel41.setForeground(Color.black);
    }//GEN-LAST:event_jPanel16MouseExited

    private void jLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseClicked
        // TODO add your handling code here:
        er13.setText(null);
        JFileChooser ch = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg,png", "jpg", "png");
        ch.setFileFilter(filter);
        int choice = ch.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            path = ch.getSelectedFile();
            String p = path.getAbsolutePath();
            ImageIcon pc = new ImageIcon(new ImageIcon(p).getImage().getScaledInstance(pic.getWidth(), pic.getHeight(), java.awt.Image.SCALE_SMOOTH));
            pic.setIcon(pc);
        }

    }//GEN-LAST:event_jLabel73MouseClicked

    private void f4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f4ActionPerformed
        // TODO add your handling code here:
        if (f4.getSelectedItem() != "Account Type") {
            er4.setText(null);
        }
        if (f4.getSelectedItem() == "Saving") {
            // f13.setEnabled(false);
            f13.setEditable(false);
        } else {
            // f13.setEnabled(true);
            f13.setEditable(true);
        }
    }//GEN-LAST:event_f4ActionPerformed

    private void f4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f4KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        if (f4.getSelectedItem() == "Current") {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                f13.requestFocus();
            }
        } else {
            f5.requestFocus();
        }
        }
    }//GEN-LAST:event_f4KeyPressed

    private void f3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SwingUtilities.invokeLater(() -> {
                f4.showPopup();
                f4.requestFocus();
            });
        }
    }//GEN-LAST:event_f3KeyPressed

    private void f3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f3KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isAlphabetic(word) || Character.isWhitespace(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE)) {
            evt.consume();
            getToolkit().beep();
            er2.setText("Enter only alphabet");
        } else {
            er2.setText(null);
        }
    }//GEN-LAST:event_f3KeyTyped

    private void f5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f5KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f6.requestFocus();
        }
    }//GEN-LAST:event_f5KeyPressed

    private void f5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f5KeyReleased
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE)) {
            if (f5.getText().length() == 5) {
                f5.setText(f5.getText() + "-");
            }
            if (f5.getText().length() == 13) {
                f5.setText(f5.getText() + "-");
            }
        }
    }//GEN-LAST:event_f5KeyReleased

    private void f5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f5KeyTyped

        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
            er5.setText("Enter only numbers");
        } else {
            if (f5.getText().length() > 14) {
                evt.consume();
            }
            er5.setText(null);
        }
    }//GEN-LAST:event_f5KeyTyped

    private void f6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f6KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f7.requestFocus();
        }
    }//GEN-LAST:event_f6KeyPressed

    private void f6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f6KeyReleased
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (word == '@') {
            f6.setText(f6.getText() + "gmail.com");
            len = f6.getText().length();
            o = 0;
        }

    }//GEN-LAST:event_f6KeyReleased

    private void f6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f6KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (word == '@') {
            mal = f6.getText();
        }
        if ((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE) {
            if (o == 0) {
                f6.setText(mal);
                o++;
            }
        }
        if (!((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            if (f6.getText().length() >= len) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_f6KeyTyped

    private void f12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f12KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            data_insertion_action();
        }
    }//GEN-LAST:event_f12KeyPressed

    private void f9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f9KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f11.requestFocus();
        }
    }//GEN-LAST:event_f9KeyPressed

    private void f9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f9KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
            er10.setText("Enter only digits");
        } else {
            if (f9.getText().length() > 9) {
                evt.consume();
            }
            er10.setText(null);
        }
    }//GEN-LAST:event_f9KeyTyped

    private void f11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f11KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f12.requestFocus();
        }
    }//GEN-LAST:event_f11KeyPressed

    private void f11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f11KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
            er12.setText("Enter only digits");
        } else {
            er12.setText(null);
        }
    }//GEN-LAST:event_f11KeyTyped

    private void f7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f7KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SwingUtilities.invokeLater(() -> {
                f8.showPopup();
                f8.requestFocus();
            });
        }
    }//GEN-LAST:event_f7KeyPressed

    private void f7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f7KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
            er7.setText("Enter only digits");
        } else {
            er7.setText(null);
        }
    }//GEN-LAST:event_f7KeyTyped

    private void f8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f8ActionPerformed
        // TODO add your handling code here:
        if (f8.getSelectedItem() != "Select Gender") {
            er9.setText(null);
        }
    }//GEN-LAST:event_f8ActionPerformed

    private void f8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f8KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f9.requestFocus();
        }
    }//GEN-LAST:event_f8KeyPressed

    private void f2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f3.requestFocus();
        }
    }//GEN-LAST:event_f2KeyPressed

    private void f2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f2KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isAlphabetic(word) || Character.isWhitespace(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE)) {
            evt.consume();
            getToolkit().beep();
            er1.setText("Enter only alphabet");
        } else {
            er1.setText(null);
        }
    }//GEN-LAST:event_f2KeyTyped

    private void pac5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac5MouseClicked
        // TODO add your handling code 
        int blnc = 0;
        if (!(f11.getText().isEmpty())) {
            blnc = Integer.parseInt(f11.getText());
        }
        if (f1.getText().isEmpty() || pic.getIcon() == null || dob.getDate() == null || f2.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty() || f4.getSelectedItem() == "Marital Status" || f5.getText().isEmpty() || f6.getText().isEmpty() || f7.getText().isEmpty() || f8.getSelectedItem() == "Select Gender" || f9.getText().isEmpty() || f11.getText().isEmpty() || f12.getText().isEmpty()) {
            if (pic.getIcon() == null) {
                er13.setText("Upload image");
            }
            if (dob.getDate() == null) {
                er3.setText("Enter Date of birth");
            }
            if(f1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Refresh page again","Error",JOptionPane.ERROR_MESSAGE);
            }
            if (f2.getText().isEmpty()) {
                er1.setText("Enter name");
            }
            if (f3.getText().isEmpty()) {
                er2.setText("Enter father name");
            }
            if (f4.getSelectedItem() == "Account Type") {
                er4.setText("Select account type");
            }
            if (f5.getText().isEmpty()) {
                er5.setText("Enter CNIC number");
            }
            if (f6.getText().isEmpty()) {
                er6.setText("Enter email");
            }
            if (f7.getText().isEmpty()) {
                er7.setText("Enter postal code");
            }
            if (f8.getSelectedItem() == "Select Gender") {
                er9.setText("Select gender");
            }
            if (f9.getText().isEmpty()) {
                er10.setText("Enter contect number");
            }
            if (f11.getText().isEmpty()) {
                er12.setText("Enter new Balance");
            }
            if (f12.getText().isEmpty()) {
                er8.setText("Enter address");
            }
        } else if (isValidEmailAddress(f6.getText()) == false || f5.getText().length() != 15 || f9.getText().length() != 10 || blnc < 2000) {
            if (isValidEmailAddress(f6.getText()) == false) {
                er6.setText("Enter valid email address");
            }
            if (f5.getText().length() != 15) {
                er5.setText("Enter valid CNIC number");
            }
            if (f9.getText().length() != 10) {
                er10.setText("Enter valid contect");
            }
            if (blnc < 2000) {
                er12.setText("Enter minimum 2000 Balance");
            }
        } else if (f4.getSelectedItem() == "Current" && f13.getText().isEmpty()) {
            er11.setText("Enter account title");
        } else {
            String title = null;
            if (f4.getSelectedItem() == "Current") {
                title = f13.getText();
            } else {
                title = f2.getText();
            }
            SimpleDateFormat thedate = new SimpleDateFormat("dd-MM-yyyy");
            String dat = thedate.format(dob.getDate());
            if (act.check_duplycate_entry(f5.getText()) == true) {
                JOptionPane.showMessageDialog(this, "Account already open on this CNIC number", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String acc=auto_bank_accounts();
                if (act.account_insertion(acc, f2.getText(), f3.getText(), dat, f5.getText(), f6.getText(), f4.getSelectedItem().toString(), f7.getText(), f8.getSelectedItem().toString(), f9.getText(), blnc, f12.getText(), path, title) == true) {
                    act.account_histroy(title, acc, "----", "----", String.valueOf(blnc), "Deposit",acc,title);
                    update_value();
                    act.dashboard_update(atmvalue,bnkvalue+1);
                    dashboraddat();
                    String df = "Hello dear " + s3f.getText() + "\nThank you for registering account in SKY Bank Limited. Welcome to SKY Bank Service.Your account opening fee RS "+blnc+" deposit in your account\nIf you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                    Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                                em.send(f6.getText(), df, "Message");
                                 }
                           }
                    });
                    t.start();
                    JOptionPane.showMessageDialog(this, "New Account Registered Successfully");
                    f_reset();
                }
            }
        }
    }//GEN-LAST:event_pac5MouseClicked

    private void pac5en_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac5en_menter
        // TODO add your handling code here:
        if (evt.getSource() == pac6) {
            pac6.setBackground(new Color(255, 51, 51));
            jLabel44.setForeground(Color.white);
        }
        if (evt.getSource() == pac5) {
            pac5.setBackground(Color.blue);
            jLabel43.setForeground(Color.white);
        }
    }//GEN-LAST:event_pac5en_menter

    private void pac5en_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac5en_mexit
        // TODO add your handling code here:
        if (evt.getSource() == pac6) {
            pac6.setBackground(new Color(240, 240, 240));
            jLabel44.setForeground(Color.black);
        }
        if (evt.getSource() == pac5) {
            pac5.setBackground(new Color(240, 240, 240));
            jLabel43.setForeground(Color.black);
        }
    }//GEN-LAST:event_pac5en_mexit

    private void pac6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac6MouseClicked
        // TODO add your handling code here:
        f_reset();
    }//GEN-LAST:event_pac6MouseClicked

    private void pac6en_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac6en_menter
        // TODO add your handling code here:
        if (evt.getSource() == pac6) {
            pac6.setBackground(new Color(255, 51, 51));
            jLabel44.setForeground(Color.white);
        }
        if (evt.getSource() == pac5) {
            pac5.setBackground(Color.blue);
            jLabel43.setForeground(Color.white);
        }
    }//GEN-LAST:event_pac6en_menter

    private void pac6en_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac6en_mexit
        // TODO add your handling code here:
        if (evt.getSource() == pac6) {
            pac6.setBackground(new Color(240, 240, 240));
            jLabel44.setForeground(Color.black);
        }
        if (evt.getSource() == pac5) {
            pac5.setBackground(new Color(240, 240, 240));
            jLabel43.setForeground(Color.black);
        }
    }//GEN-LAST:event_pac6en_mexit

    private void pac77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac77MouseClicked
        // TODO add your handling code here
        if (action_pnl == 1) {
            int sts = JOptionPane.showConfirmDialog(this, "Confirm to delete Account", "Confirm", JOptionPane.YES_NO_OPTION);
            if (sts == JOptionPane.YES_OPTION) {
                if (act.delete_account(s1f.getText()) == true) {
                   // JOptionPane.showMessageDialog(this, "Please Wait few Seconds", "Info", JOptionPane.INFORMATION_MESSAGE);
                    String df = "Hello dear " + s3f.getText() + " !\nYour Sky Bank account is deleted. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                    String as = s8f.getText();
                    String tma = s13f.getText();
                    String ste = s17df.getText();
                    String ste2 = s2f.getText();
                    dashboraddat();
                      Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(s7f.getText(), df, "Message");
                        }
                           }
                        });
                    t.start();
                    JOptionPane.showMessageDialog(this, "Account deleted successfully");
                    search_acc.setVisible(true);
                    action_acc.setVisible(false);
                } else {
                    search_acc.setVisible(false);
                    action_acc.setVisible(true);
                }
                main_profile.setVisible(false);
                accounts_pnl.setVisible(false);
                atm_table_pnl.setVisible(false);
                bnk_block.setVisible(false);
                saving_acc_pnl.setVisible(false);
                up_search_acc.setVisible(false);
                panel1.setVisible(false);
                home_panel.setVisible(false);
                panel2.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel6.setVisible(false);
                insertion_acc.setVisible(false);
                update_acc.setVisible(false);
            }
        } else {
            String mta = s13f.getText();
            if (mta.equals("Not Registered")) {
                JOptionPane.showMessageDialog(this, "ATM account not register on this account", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int sts = JOptionPane.showConfirmDialog(this, "Confirm to delete ATM Account", "Confirm", JOptionPane.YES_NO_OPTION);
                if (sts == JOptionPane.YES_OPTION) {
                    if (act.atm_account_new(s1f.getText(), "del","") == true) {
                       // JOptionPane.showMessageDialog(this, "Please Wait few Seconds", "Info", JOptionPane.INFORMATION_MESSAGE);
                        String df = "Hello dear " + s3f.getText() + " !\nYour Sky Bank ATM account is deleted. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                        dashboraddat();
                        search_account_data(s1f.getText(), "account");
                        Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(s7f.getText(), df, "Message");
                        }
                           }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "ATM account delete successfully");
                    }
                }
            }
        }
    }//GEN-LAST:event_pac77MouseClicked

    private void pac77red_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac77red_menter
        pac77.setBackground(new Color(255, 102, 102));
        jLabel56.setForeground(Color.white);
    }//GEN-LAST:event_pac77red_menter

    private void pac77red_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac77red_mexit
        // TODO add your handling code here:
        pac77.setBackground(new Color(240, 240, 240));
        jLabel56.setForeground(Color.black);
    }//GEN-LAST:event_pac77red_mexit

    private void pac99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac99MouseClicked
        // TODO add your handling code here:
        if (action_pnl == 1) {
            if (s2f.getText().length() == 6) {
                JOptionPane.showMessageDialog(null, "Account is already Activated", "Warnning", JOptionPane.WARNING_MESSAGE);
            } else {
                int sts = JOptionPane.showConfirmDialog(null, "Confirm to Activate this account", "Confirm", JOptionPane.YES_NO_OPTION);
                if (sts == JOptionPane.YES_OPTION) {
                    String stm = s13f.getText();
                    String atms = null;
                    if (stm.equals("Not Registered")) {
                        atms = "Not Registered";
                    } else {
                        atms = "Active";
                    }
                    if (act.account_status_update(s1f.getText(), "Active", atms) == true) {
                        dashboraddat();
                        search_account_data(s1f.getText(), "account");
                        String df = "Hello dear " + s3f.getText() + " !\nYour Sky Bank account is unblocked\nWelcome again for join our service";
                        Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(s7f.getText(), df, "Message");
                        }
                           }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "Account Unblock successfully");
                        
                    }
                }
            }
        } else {
            String str = s13f.getText();
            String mta = s13f.getText();
            if (s17df.getText().length() == 6) {
                JOptionPane.showMessageDialog(null, "ATM Account is already Activated", "Warnning", JOptionPane.WARNING_MESSAGE);
            } else if (s2f.getText().length() == 5 || mta.equals("Not Registered")) {
                if (mta.equals("Not Registered")) {
                    JOptionPane.showMessageDialog(this, "ATM account not register on this account", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Bank Account is Blocked\nATM account cannot activate still", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                int sts = JOptionPane.showConfirmDialog(null, "Confirm to Activate this ATM account", "Confirm", JOptionPane.YES_NO_OPTION);
                if (sts == JOptionPane.YES_OPTION) {
                    if (act.account_status_update(s1f.getText(), s2f.getText(), "Active") == true) {
                            dashboraddat();
                            search_account_data(s1f.getText(), "account");
                        String df = "Hello dear " + s3f.getText() + " !\nYour Sky Bank ATM account is unblocked\nWelcome again for join our service";
                        Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(s7f.getText(), df, "Message");
                        }
                           }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "Account Unblock successfully");
                    }
                }
            }
        }
    }//GEN-LAST:event_pac99MouseClicked

    private void pac99blu_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac99blu_menter
        // TODO add your handling code here:
        if (evt.getSource() == pac99) {
            pac99.setBackground(new Color(102, 102, 255));
            jLabel58.setForeground(Color.white);
        }
        if (pac8 == evt.getSource()) {
            pac8.setBackground(new Color(102, 102, 255));
            jLabel57.setForeground(Color.white);
        }

    }//GEN-LAST:event_pac99blu_menter

    private void pac99blu_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac99blu_mexit
        // TODO add your handling code here:
        if (evt.getSource() == pac99) {
            pac99.setBackground(new Color(240, 240, 240));
            jLabel58.setForeground(Color.black);
        }
        if (pac8 == evt.getSource()) {
            pac8.setBackground(new Color(240, 240, 240));
            jLabel57.setForeground(Color.black);
        }

    }//GEN-LAST:event_pac99blu_mexit

    private void pac101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac101MouseClicked
        // TODO add your handling code here:
        if (action_pnl == 1) {
            if (s2f.getText().length() == 5) {
                JOptionPane.showMessageDialog(null, "Account is already Blocked", "Warnning", JOptionPane.WARNING_MESSAGE);
            } else {
                int sts = JOptionPane.showConfirmDialog(null, "Confirm to Block this account", "Confirm", JOptionPane.YES_NO_OPTION);
                if (sts == JOptionPane.YES_OPTION) {
                    String stm = s13f.getText();
                    String tm = s17df.getText();
                    String atms = null;
                    if (stm.equals("Not Registered")) {
                        atms = "Not Registered";
                    } else {
                            atms = "Block";
                    }
                    if (act.account_status_update(s1f.getText(), "Block", atms) == true) {
                      //  JOptionPane.showMessageDialog(this, "Please Wait few Seconds", "Info", JOptionPane.INFORMATION_MESSAGE);
                        String df = "Hello dear " + s3f.getText() + " !\nYour Sky Bank account is blocked. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                        dashboraddat();
                        search_account_data(s1f.getText(), "account");
                        Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                              em.send(s7f.getText(), df, "Message");
                             }
                           }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "Account Blocked successfully");
                    }
                }
            }
        } else {
            String str = s13f.getText();
            if (s17df.getText().length() == 5) {
                JOptionPane.showMessageDialog(null, "ATM account is already Blocked", "Warnning", JOptionPane.WARNING_MESSAGE);
            } else if (str.equals("Not Registered")) {
                JOptionPane.showMessageDialog(null, "ATM account not registered on this account", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int sts = JOptionPane.showConfirmDialog(null, "Confirm to Block this ATM account", "Confirm", JOptionPane.YES_NO_OPTION);
                if (sts == JOptionPane.YES_OPTION) {
                    if (act.account_status_update(s1f.getText(), "Active", "Block") == true) {
                       dashboraddat();
                       search_account_data(s1f.getText(), "account");
                        String dief = "Hello dear " + s3f.getText() + " !\nYour Sky Bank ATM account is blocked. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                       Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(s7f.getText(), dief, "Message");
                        }
                           }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "ATM Account Blocked successfully"); 
                    }
                }
            }
        }
    }//GEN-LAST:event_pac101MouseClicked

    private void pac101red_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac101red_menter
        // TODO add your handling code here:
        pac101.setBackground(new Color(255, 102, 102));
        jLabel59.setForeground(Color.white);
    }//GEN-LAST:event_pac101red_menter

    private void pac101red_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac101red_mexit

        pac101.setBackground(new Color(240, 240, 240));
        jLabel59.setForeground(Color.black);
    }//GEN-LAST:event_pac101red_mexit

    private void jPanel23wMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23wMouseClicked
        // TODO add your handling code here:
        main_profile.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        update_acc.setVisible(false);
        search1j.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        search1j.requestFocus();
    }//GEN-LAST:event_jPanel23wMouseClicked

    private void jPanel23wMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23wMouseEntered
        // TODO add your handling code here:
        jLabel60.setForeground(Color.blue);
    }//GEN-LAST:event_jPanel23wMouseEntered

    private void jPanel23wMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23wMouseExited
        // TODO add your handling code here:
        jLabel60.setForeground(Color.black);
    }//GEN-LAST:event_jPanel23wMouseExited

    private void action_accred_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_accred_menter
        // TODO add your handling code here:
        if (evt.getSource() == pac101) {
            pac101.setBackground(new Color(255, 102, 102));
            jLabel59.setForeground(Color.white);
        }
        if (evt.getSource() == pac77) {
            pac77.setBackground(new Color(255, 102, 102));
            jLabel56.setForeground(Color.white);
        }
    }//GEN-LAST:event_action_accred_menter

    private void action_accred_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_accred_mexit
        // TODO add your handling code here:
        if (evt.getSource() == pac101) {
            pac101.setBackground(new Color(240, 240, 240));
            jLabel59.setForeground(Color.black);
        }
        if (evt.getSource() == pac77) {
            pac77.setBackground(new Color(240, 240, 240));
            jLabel56.setForeground(Color.black);
        }
    }//GEN-LAST:event_action_accred_mexit

    private void search1jFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search1jFocusGained
        // TODO add your handling code here:
        searcherr.setText(null);
    }//GEN-LAST:event_search1jFocusGained

    private void search1jKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1jKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_button_task();
        }
    }//GEN-LAST:event_search1jKeyPressed

    private void search1jKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1jKeyReleased
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (rd11.isSelected()) {
            if (!((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE)) {
                if (search1j.getText().length() == 5) {
                    search1j.setText(search1j.getText() + "-");
                }
                if (search1j.getText().length() == 13) {
                    search1j.setText(search1j.getText() + "-");
                }
            }
        }
    }//GEN-LAST:event_search1jKeyReleased

    private void search1jKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1jKeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (rd11.isSelected()) {
            if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
                evt.consume();
                getToolkit().beep();
                searcherr.setText("Enter only numbers");
            } else {
                if (search1j.getText().length() > 14) {
                    evt.consume();
                }
                searcherr.setText(null);
            }
        }
    }//GEN-LAST:event_search1jKeyTyped
    void search_button_task() {
        if (search1j.getText().isEmpty()) {
            search_acc.setVisible(true);
            searcherr.setText("Please enter data for searching");
        } else {
            if (rd11.isSelected()) {
                String opr = rd32.getText();
                String typ = null;
                if (opr.equals("Bank Account number")) {
                    typ = "account";
                    if (act.check_account(search1j.getText(), "cnic") == true) {
                        search_account_data(search1j.getText(), "cnic");
                        search_acc.setVisible(false);
                        action_acc.setVisible(true);
                    } else {
                        search_acc.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Bank Account record not found", "Info", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    typ = "atm";
                    if (act.check_atm_account(search1j.getText(), "cnic") == true) {
                        search_account_data(search1j.getText(), "cnic");
                        search_acc.setVisible(false);
                        action_acc.setVisible(true);
                    } else {
                        search_acc.setVisible(true);
                        JOptionPane.showMessageDialog(null, "ATM account record not found", "Info", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (rd32.isSelected()) {
                String opr = rd32.getText();
                String typ = null;
                if (opr.equals("Bank Account number")) {
                    typ = "account";
                    if (act.check_account(search1j.getText(), "account") == true) {
                        search_account_data(search1j.getText(), typ);
                        search_acc.setVisible(false);
                        action_acc.setVisible(true);
                    } else {
                        search_acc.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Bank Account record not found", "Info", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    typ = "atm";
                    if (act.check_atm_account(search1j.getText(), "atm") == true) {
                        search_account_data(search1j.getText(), typ);
                        search_acc.setVisible(false);
                        action_acc.setVisible(true);
                    } else {
                        search_acc.setVisible(true);
                        JOptionPane.showMessageDialog(null, "ATM account record not found", "Info", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
    }
    private void jPanel27jjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27jjMouseClicked
        // TODO add your handling code her
        search_button_task();
    }//GEN-LAST:event_jPanel27jjMouseClicked

    private void jPanel27jjMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27jjMouseEntered
        // TODO add your handling code here:
        jPanel27jj.setBackground(new Color(0, 204, 0));
        jLabel66.setForeground(Color.white);
    }//GEN-LAST:event_jPanel27jjMouseEntered

    private void jPanel27jjMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27jjMouseExited
        // TODO add your handling code here:
        jPanel27jj.setBackground(new Color(240, 240, 240));
        jLabel66.setForeground(Color.black);
    }//GEN-LAST:event_jPanel27jjMouseExited

    private void rd32redio_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd32redio_action
        // TODO add your handling code here:
        if (evt.getSource() == rd11) {
            rd11.isSelected();
            rd32.setSelected(false);
            search1j.setText("");
            search1j.requestFocus();
        }
        if (evt.getSource() == rd32) {
            rd32.isSelected();
            rd11.setSelected(false);
            search1j.setText("");
            searcherr.setText(null);
            search1j.requestFocus();
        }
    }//GEN-LAST:event_rd32redio_action

    private void rd11redio_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd11redio_action
        // TODO add your handling code here:
        if (evt.getSource() == rd11) {
            rd11.isSelected();
            rd32.setSelected(false);
            search1j.setText("");
            search1j.requestFocus();
        }
        if (evt.getSource() == rd32) {
            rd32.isSelected();
            rd11.setSelected(false);
            search1j.setText("");
            searcherr.setText(null);
            search1j.requestFocus();
        }
    }//GEN-LAST:event_rd11redio_action

    private void jPanel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseClicked
        // TODO add your handling code here:
        if (atm_back == 1) {
            panel2.setVisible(false);
            panel1.setVisible(true);
        } else {
            panel2.setVisible(true);
            panel1.setVisible(false);
        }
        search1j.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        home_panel.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_jPanel24MouseClicked

    private void jPanel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseEntered
        // TODO add your handling code here:
        jLabel68.setForeground(Color.blue);
    }//GEN-LAST:event_jPanel24MouseEntered

    private void jPanel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseExited
        // TODO add your handling code here:
        jLabel68.setForeground(Color.black);
    }//GEN-LAST:event_jPanel24MouseExited

    private void jLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseClicked
        // TODO add your handling code here:
        JFileChooser ch = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg,png", "jpg", "png");
        ch.setFileFilter(filter);
        int choice = ch.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            try {
                path = ch.getSelectedFile();
                mg = Files.readAllBytes(path.toPath());
                String p = path.getAbsolutePath();
                ImageIcon pc = new ImageIcon(new ImageIcon(p).getImage().getScaledInstance(upic.getWidth(), upic.getHeight(), java.awt.Image.SCALE_SMOOTH));
                upic.setIcon(pc);
            } catch (IOException e) {
                System.out.print(e);
            }
        }
    }//GEN-LAST:event_jLabel86MouseClicked

    private void u5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u5KeyReleased
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE)) {
            if (u5.getText().length() == 5) {
                u5.setText(u5.getText() + "-");
            }
            if (u5.getText().length() == 13) {
                u5.setText(u5.getText() + "-");
            }
        }
    }//GEN-LAST:event_u5KeyReleased

    private void u5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u5KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
        } else {
            if (u5.getText().length() > 14) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_u5KeyTyped

    private void u6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u6KeyReleased
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (word == '@') {
            u6.setText(u6.getText() + "gmail.com");
            len = u6.getText().length();
            o = 0;
        }
    }//GEN-LAST:event_u6KeyReleased

    private void u6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u6KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (word == '@') {
            mal = u6.getText();
        }
        if ((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE) {
            if (o == 0) {
                u6.setText(mal);
                o++;
            }
        }
        if (!((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            if (u6.getText().length() >= len) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_u6KeyTyped

    private void u9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u9KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
        } else {
            if (u9.getText().length() > 9) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_u9KeyTyped

    private void u7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u7KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_u7KeyTyped

    private void pac8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac8MouseClicked
        // TODO add your handling code here:
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(true);
        String v1 = u4.getSelectedItem().toString();
        if (upic.getIcon() == null || u3.getDate() == null || u1.getText().isEmpty() || u2.getText().isEmpty() || u4.getSelectedItem() == "Marital Status" || u5.getText().isEmpty() || u6.getText().isEmpty() || u7.getText().isEmpty() || u8.getSelectedItem() == "Select Gender" || u9.getText().isEmpty() || u12.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (u5.getText().length() != 15) {
            JOptionPane.showMessageDialog(this, "Please enter valid CNIC number", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (u9.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "Please enter valid contect", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (v1.equals("Current") && u13.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter account Title", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String tit = null;
            if (u4.getSelectedItem().equals("Current")) {
                tit = u13.getText();
                System.out.append(tit);
            } else {
                tit = u1.getText();
                System.out.append(tit);
            }
            SimpleDateFormat thedate = new SimpleDateFormat("dd-MM-yyyy");
            String dab = thedate.format(u3.getDate()).toString();
            if (act.update_account_data(employee_id, u1.getText(), u2.getText(), dab, u4.getSelectedItem().toString(), u5.getText(), u6.getText(), u7.getText(), u8.getSelectedItem().toString(), u9.getText(), u12.getText(), mg, tit) == true) {
                String dief = "Hello dear " +u1.getText() + " !\nYour Sky Bank account profile update successfully. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                dashboraddat();
                Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(u6.getText(), dief, "Message");
                        }
                           }
                        });
                        t.start();
                JOptionPane.showMessageDialog(this, "Account record update");
            } else {
                JOptionPane.showMessageDialog(this, "Account not record update");
            }
        }

    }//GEN-LAST:event_pac8MouseClicked

    private void pac8blu_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac8blu_menter
        // TODO add your handling code here:
        if (evt.getSource() == pac99) {
            pac99.setBackground(new Color(102, 102, 255));
            jLabel58.setForeground(Color.white);
        }
        if (pac8 == evt.getSource()) {
            pac8.setBackground(new Color(102, 102, 255));
            jLabel57.setForeground(Color.white);
        }

    }//GEN-LAST:event_pac8blu_menter

    private void pac8blu_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac8blu_mexit
        // TODO add your handling code here:
        if (evt.getSource() == pac99) {
            pac99.setBackground(new Color(240, 240, 240));
            jLabel58.setForeground(Color.black);
        }
        if (pac8 == evt.getSource()) {
            pac8.setBackground(new Color(240, 240, 240));
            jLabel57.setForeground(Color.black);
        }

    }//GEN-LAST:event_pac8blu_mexit

    private void jPanel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel26MouseClicked
        // TODO add your handling code here:
        up_search_acc.setVisible(true);
        serupdate.requestFocus();
        serupdate.setText("");
        rd5.setSelected(true);
        rd4.setSelected(false);
        main_profile.setVisible(true);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_jPanel26MouseClicked

    private void serupdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serupdateKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            update_search_button_task();
        }
    }//GEN-LAST:event_serupdateKeyPressed

    private void serupdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serupdateKeyReleased
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (rd5.isSelected()) {
            if (!((word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE)) {
                if (serupdate.getText().length() == 5) {
                    serupdate.setText(serupdate.getText() + "-");
                }
                if (serupdate.getText().length() == 13) {
                    serupdate.setText(serupdate.getText() + "-");
                }
            }
        }
    }//GEN-LAST:event_serupdateKeyReleased

    private void serupdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serupdateKeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (rd5.isSelected()) {
            if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
                evt.consume();
                getToolkit().beep();
                uperror.setText("Enter only numbers");
            } else {
                if (serupdate.getText().length() > 14) {
                    evt.consume();
                }
                uperror.setText(null);
            }
        }
    }//GEN-LAST:event_serupdateKeyTyped
    void update_search_button_task() {
        if (serupdate.getText().isEmpty()) {
            up_search_acc.setVisible(true);
            uperror.setText("Please enter data for searching");
        } else {
            if (rd5.isSelected()) {
                if (act.check_account(serupdate.getText(), "cnic") == true) {
                    search_update_acc_data(serupdate.getText(), "cnic");
                    update_acc.setVisible(true);
                    up_search_acc.setVisible(false);
                } else {
                    up_search_acc.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Employee record not found", "Info", JOptionPane.ERROR_MESSAGE);
                }

            } else if (rd4.isSelected()) {
                if (act.check_account(serupdate.getText(), "bank_acc") == true) {
                    search_update_acc_data(serupdate.getText(), "bank_acc");
                    update_acc.setVisible(true);
                    up_search_acc.setVisible(false);
                } else {
                    up_search_acc.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Employee record not found", "Info", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
    }
    private void jPanel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseClicked
        update_search_button_task();
    }//GEN-LAST:event_jPanel29MouseClicked

    private void jPanel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseEntered
        // TODO add your handling code here:
        jPanel29.setBackground(new Color(0, 204, 0));
        jLabel100.setForeground(Color.white);
    }//GEN-LAST:event_jPanel29MouseEntered

    private void jPanel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseExited
        // TODO add your handling code here:
        jPanel29.setBackground(new Color(240, 240, 240));
        jLabel100.setForeground(Color.black);
    }//GEN-LAST:event_jPanel29MouseExited

    private void rd4rd_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd4rd_action
        // TODO add your handling code here:
        if (evt.getSource() == rd4) {
            rd4.isSelected();
            rd5.setSelected(false);
            serupdate.setText("");
            serupdate.requestFocus();
        }
        if (evt.getSource() == rd5) {
            rd5.isSelected();
            rd4.setSelected(false);
            serupdate.setText("");
            serupdate.requestFocus();
        }
    }//GEN-LAST:event_rd4rd_action

    private void rd5rd_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd5rd_action
        // TODO add your handling code here:
        if (evt.getSource() == rd4) {
            rd4.isSelected();
            rd5.setSelected(false);
            serupdate.setText("");
            serupdate.requestFocus();
        }
        if (evt.getSource() == rd5) {
            rd5.isSelected();
            rd4.setSelected(false);
            serupdate.setText("");
            serupdate.requestFocus();
        }
    }//GEN-LAST:event_rd5rd_action

    private void jPanel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseClicked
        // TODO add your handling code here:
        up_search_acc.setVisible(false);
        panel1.setVisible(true);
        serupdate.setText(null);
        rd5.setSelected(true);
        rd4.setSelected(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
    }//GEN-LAST:event_jPanel30MouseClicked

    private void atm_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm_tableMouseClicked
        // TODO add your handling code here:
        int i = atm_table.getSelectedRow();
        int column = 2;
        String value = atm_table.getModel().getValueAt(i, column).toString();
        account_data_all(value, "account");
        back_rule = "atmacc";
        home_panel.setVisible(false);
        panel2.setVisible(false);
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(true);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_atm_tableMouseClicked

    private void jPanel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseClicked
        // TODO add your handling code here:
        if (back_rule2 == "home") {
            home_panel.setVisible(true);
            panel2.setVisible(false);
        } else {
            home_panel.setVisible(false);
            panel2.setVisible(true);
        }
        jDateChooser5.setDate(null);
        jDateChooser6.setDate(null);
        jTextField2.setText(null);
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_jPanel43MouseClicked

    private void jPanel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MouseClicked
        // TODO add your handling code here:
        if (back_rule2 == "home") {
            panel1.setVisible(false);
            home_panel.setVisible(true);
        } else {
            panel1.setVisible(true);
            home_panel.setVisible(false);
        }
        like_s = "c";
        jTextField3.setText(null);
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        bank_account_datils("current", "", "",null,null);
        bnk_block.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_jPanel42MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
        if (back_rule == "atm") {
            accounts_pnl.setVisible(false);
            atm_table_pnl.setVisible(false);
            bnk_block.setVisible(false);
            saving_acc_pnl.setVisible(false);
            newatm.setVisible(true);
            jTextField1.setText(null);
            jTextField1.requestFocus();
        }
        if (back_rule == "accnt") {
            accounts_pnl.setVisible(true);
            jTextField3.requestFocus();
            atm_table_pnl.setVisible(false);
            bnk_block.setVisible(false);
            saving_acc_pnl.setVisible(false);
            newatm.setVisible(false);
        }
        if (back_rule == "atmacc") {
            accounts_pnl.setVisible(false);
            atm_table_pnl.setVisible(true);
            jTextField2.requestFocus();
            bnk_block.setVisible(false);
            saving_acc_pnl.setVisible(false);
            newatm.setVisible(false);
        }
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        main_profile.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);

    }//GEN-LAST:event_jPanel19MouseClicked

    private void d1_14and_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_14and_mexit

        d1_13.setBackground(new Color(102, 102, 255));
        d1_l19.setForeground(Color.white);
        d1_l20.setForeground(Color.white);
        d1_14.setBackground(new Color(240, 240, 240));
        d1_l21.setForeground(Color.black);
        d1_l21.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d1_14and_mexit

    private void d1_14and_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_14and_menter
        // TODO add your handling code here:
        d1_13.setBackground(new Color(240, 240, 240));
        d1_l19.setForeground(Color.black);
        d1_l20.setForeground(Color.black);
        d1_14.setBackground(new Color(102, 102, 255));
        d1_l21.setForeground(Color.white);
        d1_l21.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d1_14and_menter

    private void d1_12and_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_12and_mexit
        // TODO add your handling code here:
        d1_11.setBackground(new Color(102, 102, 255));
        d1_l16.setForeground(Color.white);
        d1_l17.setForeground(Color.white);
        d1_12.setBackground(new Color(240, 240, 240));
        d1_l18.setForeground(Color.black);
        d1_l18.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d1_12and_mexit

    private void d1_12and_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_12and_menter
        // TODO add your handling code here:
        d1_11.setBackground(new Color(240, 240, 240));
        d1_l16.setForeground(Color.black);
        d1_l17.setForeground(Color.black);
        d1_12.setBackground(new Color(102, 102, 255));
        d1_l18.setForeground(Color.white);
        d1_l18.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d1_12and_menter

    private void d1_10and_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_10and_mexit
        // TODO add your handling code here:
        d1_9.setBackground(new Color(102, 102, 255));
        d1_l13.setForeground(Color.white);
        d1_l14.setForeground(Color.white);
        d1_10.setBackground(new Color(240, 240, 240));
        d1_l15.setForeground(Color.black);
        d1_l15.setFont(new java.awt.Font("Tahoma", 1, 12));
    }//GEN-LAST:event_d1_10and_mexit

    private void d1_10and_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_10and_menter

        d1_9.setBackground(new Color(240, 240, 240));
        d1_l13.setForeground(Color.black);
        d1_l14.setForeground(Color.black);
        d1_10.setBackground(new Color(102, 102, 255));
        d1_l15.setForeground(Color.white);
        d1_l15.setFont(new java.awt.Font("Tahoma", 1, 14));
    }//GEN-LAST:event_d1_10and_menter

    private void acc10an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc10an_mexit
        // TODO add your handling code here:
        lac10.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac10.setForeground(Color.black);
        acc10.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_acc10an_mexit

    private void acc10an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc10an_menter

        lac10.setFont(new java.awt.Font("Tahoma", 1, 13));
        acc10.setBackground(Color.blue);
        lac10.setForeground(Color.white);
    }//GEN-LAST:event_acc10an_menter

    private void acc9an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc9an_mexit

        lac9.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac9.setForeground(Color.black);
        acc9.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_acc9an_mexit

    private void acc9an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc9an_menter
        // TODO add your handling code here
        lac9.setFont(new java.awt.Font("Tahoma", 1, 13));
        acc9.setBackground(Color.blue);
        lac9.setForeground(Color.white);
    }//GEN-LAST:event_acc9an_menter

    private void acc6an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc6an_mexit

        lac6.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac6.setForeground(Color.black);
        acc6.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_acc6an_mexit

    private void acc6an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc6an_menter
        // TODO add your handling code here:
        lac6.setFont(new java.awt.Font("Tahoma", 1, 13));
        acc6.setBackground(Color.blue);
        lac6.setForeground(Color.white);
    }//GEN-LAST:event_acc6an_menter

    private void acc5an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc5an_mexit
        // TODO add your handling code here:
        lacc5.setFont(new java.awt.Font("Tahoma", 1, 12));
        lacc5.setForeground(Color.black);
        acc5.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_acc5an_mexit

    private void acc5an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc5an_menter

        lacc5.setFont(new java.awt.Font("Tahoma", 1, 13));
        acc5.setBackground(Color.blue);
        lacc5.setForeground(Color.white);
    }//GEN-LAST:event_acc5an_menter

    private void ms_enter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ms_enter
        // TODO add your handling code here:
        if (evt.getSource() == ac1) {
            lac1.setFont(new java.awt.Font("Tahoma", 1, 13));
            lac1.setForeground(Color.white);
            ac1.setBackground(Color.blue);
        }
        if (evt.getSource() == ac2) {
            lac2.setFont(new java.awt.Font("Tahoma", 1, 13));
            ac2.setBackground(Color.blue);
            lac2.setForeground(Color.white);
        }
        if (evt.getSource() == ac3) {
            lac3.setFont(new java.awt.Font("Tahoma", 1, 13));
            ac3.setBackground(Color.blue);
            lac3.setForeground(Color.white);
        }
        if (evt.getSource() == ac4) {
            lac4.setFont(new java.awt.Font("Tahoma", 1, 13));
            ac4.setBackground(Color.blue);
            lac4.setForeground(Color.white);
        }
    }//GEN-LAST:event_ms_enter

    private void ms_exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ms_exit
        // TODO add your handling code here:
        if (evt.getSource() == ac1) {
            lac1.setFont(new java.awt.Font("Tahoma", 1, 12));
            lac1.setForeground(Color.black);
            ac1.setBackground(new Color(240, 240, 240));
        }
        if (evt.getSource() == ac2) {
            lac2.setFont(new java.awt.Font("Tahoma", 1, 12));
            lac2.setForeground(Color.black);
            ac2.setBackground(new Color(240, 240, 240));
        }
        if (evt.getSource() == ac3) {
            lac3.setFont(new java.awt.Font("Tahoma", 1, 12));
            lac3.setForeground(Color.black);
            lac3.setForeground(Color.black);
            ac3.setBackground(new Color(240, 240, 240));
        }
        if (evt.getSource() == ac4) {
            lac4.setFont(new java.awt.Font("Tahoma", 1, 12));
            lac4.setForeground(Color.black);
            ac4.setBackground(new Color(240, 240, 240));
        }
    }//GEN-LAST:event_ms_exit

    private void foc_entry(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_foc_entry
        // TODO add your handling code here:
        if (evt.getSource() == dob) {
            er3.setText(null);
        }
        if (evt.getSource() == f2) {
            er1.setText(null);
        }
        if (evt.getSource() == f3) {
            er2.setText(null);
        }
        if (evt.getSource() == f4) {
            er4.setText(null);
        }
        if (evt.getSource() == f5) {
            er5.setText(null);
        }
        if (evt.getSource() == f6) {
            er6.setText(null);
        }
        if (evt.getSource() == f7) {
            er7.setText(null);
        }
        if (evt.getSource() == f8) {
            er9.setText(null);
        }
        if (evt.getSource() == f9) {
            er10.setText(null);
        }
        if (evt.getSource() == f11) {
            er12.setText(null);
        }
        if (evt.getSource() == f12) {
            er8.setText(null);
        }
    }//GEN-LAST:event_foc_entry

    private void ac11an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac11an_menter
        // TODO add your handling code here:
        lac11.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac11.setBackground(Color.blue);
        lac11.setForeground(Color.white);
    }//GEN-LAST:event_ac11an_menter

    private void ac11an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac11an_mexit
        // TODO add your handling code here:
        lac11.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac11.setForeground(Color.black);
        ac11.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ac11an_mexit

    private void ac12an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac12an_menter
        // TODO add your handling code here:
        lac12.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac12.setBackground(Color.blue);
        lac12.setForeground(Color.white);
    }//GEN-LAST:event_ac12an_menter

    private void ac12an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac12an_mexit
        // TODO add your handling code here:
        lac12.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac12.setForeground(Color.black);
        ac12.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ac12an_mexit

    private void ac13an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac13an_menter
        // TODO add your handling code here:
        lac13.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac13.setBackground(Color.blue);
        lac13.setForeground(Color.white);
    }//GEN-LAST:event_ac13an_menter

    private void ac13an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac13an_mexit
        // TODO add your handling code here:
        lac13.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac13.setForeground(Color.black);
        ac13.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ac13an_mexit

    private void ac14an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac14an_menter
        // TODO add your handling code here:
        lac14.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac14.setBackground(Color.blue);
        lac14.setForeground(Color.white);
    }//GEN-LAST:event_ac14an_menter

    private void ac14an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac14an_mexit
        // TODO add your handling code here:
        lac14.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac14.setForeground(Color.black);
        ac14.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ac14an_mexit

    private void f13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f13FocusGained
        // TODO add your handling code here:
        er11.setText(null);
    }//GEN-LAST:event_f13FocusGained

    private void f13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f13KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f5.requestFocus();
        }
    }//GEN-LAST:event_f13KeyPressed

    private void u4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u4ActionPerformed
        // TODO add your handling code here:
        String v1 = u4.getSelectedItem().toString();
        if (v1.equals("Saving")) {
            u13.setEditable(false);
        } else {
            u13.setEditable(true);
        }
    }//GEN-LAST:event_u4ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        JFileChooser ch = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg,png", "jpg", "png");
        ch.setFileFilter(filter);
        int choice = ch.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File pah = ch.getSelectedFile();
            String p = pah.getAbsolutePath();
            if (pp.employee_account_profile_update(pah, emplogin) == true) {
                JOptionPane.showMessageDialog(this, "Profile image change successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                ImageIcon pc = new ImageIcon(new ImageIcon(p).getImage().getScaledInstance(empic.getWidth(), empic.getHeight(), java.awt.Image.SCALE_SMOOTH));
                empic.setIcon(pc);
                show_emp_profile();
            }
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void acc5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc5MouseClicked
        // TODO add your handling code here:
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(true);
        jTextField1.requestFocus();
    }//GEN-LAST:event_acc5MouseClicked

    private void acc6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc6MouseClicked
        // TODO add your handling code here:
        atm_back = 10;
        action_pnl = 00;
        rd32.setText("ATM Account number");
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        newatm.setVisible(false);
        update_acc.setVisible(false);
        search1j.requestFocus();
    }//GEN-LAST:event_acc6MouseClicked

    private void acc9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc9MouseClicked
        // TODO add your handling code here:
        atm_back = 10;
        action_pnl = 00;
        rd32.setText("ATM Account number");
        main_profile.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        update_acc.setVisible(false);
        search1j.requestFocus();
    }//GEN-LAST:event_acc9MouseClicked

    private void acc10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc10MouseClicked
        // TODO add your handling code here:
        atm_back = 10;
        action_pnl = 00;
        rd32.setText("ATM Account number");
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        jTextField1.setText(null);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(true);
        update_acc.setVisible(false);
        search1j.requestFocus();
    }//GEN-LAST:event_acc10MouseClicked

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        aterr.setText("");
    }//GEN-LAST:event_jTextField1FocusGained

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
        jPanel8.setBackground(Color.blue);
        jLabel20.setForeground(Color.white);
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(240, 240, 240));
        jLabel20.setForeground(Color.black);
    }//GEN-LAST:event_jPanel8MouseExited
    void atm_insertion() {
        if (jTextField1.getText().isEmpty()) {
            aterr.setText("Enter your bank account number");
        } else {
            aterr.setText(null);
            if (act.check_account(jTextField1.getText(), "account") == true) {
                if (act.check_account_status(jTextField1.getText()) == true) {
                    String miil=act.getMail();
                    String nm=act.getNm();
                    SplittableRandom s1=new SplittableRandom();
                    StringBuilder s2=new StringBuilder();
                    for(int i=0;i<4;i++){
                    s2.append(s1.nextInt(0,10));
                      }
                   String pass=s2.toString();
                    if (act.check_atm_account(jTextField1.getText(), "bnk") == false) {
                        String tem=auto_atm_accounts();
                        if (act.atm_account_new(jTextField1.getText(),tem,pass)) {
                            update_value();
                            act.dashboard_update(atmvalue+1, bnkvalue);
                            account_data_all(jTextField1.getText(), "account");
                            dashboraddat();
                            String df="Hello dear "+nm+"\nWelcome to Sky Bank limited Pakistan. Your ATM account is registerd in SKY bank linked with your bank accounts\nYour username and password is given below\nUsername : "+tem+"\nPincode : "+pass;
                            if(net()==true){
                            Thread t = new Thread(new Runnable(){
                                 public void run(){
                                 em.send(miil,df,"Welcome to SKY Bank ATM Service");
                                 }
                            });
                            t.start();
                            JOptionPane.showMessageDialog(this, "ATM account activate on this account");
                            }else{
                            JOptionPane.showMessageDialog(this, "ATM account activate on given account\nYour ATM information given below:\nUsername : "+tem+"\nPincode: "+pass+"\nPlease Change Pincode");
                            }
                            back_rule = "atm";
                            main_profile.setVisible(true);
                            accounts_pnl.setVisible(false);
                            atm_table_pnl.setVisible(false);
                            bnk_block.setVisible(false);
                            saving_acc_pnl.setVisible(false);
                            up_search_acc.setVisible(false);
                            panel1.setVisible(false);
                            home_panel.setVisible(false);
                            panel2.setVisible(false);
                            panel4.setVisible(false);
                            panel5.setVisible(false);
                            panel6.setVisible(false);
                            insertion_acc.setVisible(false);
                            action_acc.setVisible(false);
                            search_acc.setVisible(false);
                            update_acc.setVisible(false);
                            newatm.setVisible(false);
                            withdraw_money_pnl.setVisible(false);
                            balance_history_pnl.setVisible(false);
                            send_money_pnl.setVisible(false);
                            deposit_mony_pnl.setVisible(false);
                            check_blnc_pnl.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "ATM account already registered on this account", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This account is Blocked", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "This account not found in record", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        atm_insertion();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            atm_insertion();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jPanel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel45MouseClicked

        if ("home".equals(back_rule2)) {
            home_panel.setVisible(true);
            panel4.setVisible(false);
        } else {
            home_panel.setVisible(false);
            panel4.setVisible(true);
        }
        jTextField4.setText(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jTextField4.setEditable(true);
        jTextField4.setText(null);
        jTextField4.setEnabled(true);
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_jPanel45MouseClicked

    private void d9_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_2MouseClicked
        // TODO add your handling code here:
        back_rule2 = "home";
        like_s = "w";
        account_history_datils("withdraw", "", "", "", "");
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(true);
        jTextField4.requestFocus();
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d9_2MouseClicked

    private void d7_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_2MouseClicked
        // TODO add your handling code here:
        back_rule2 = "home";
        like_s = "all";
        account_history_datils("all", "", "", "", "");
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(true);
        jTextField4.requestFocus();
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d7_2MouseClicked

    private void d8_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_2MouseClicked
        // TODO add your handling code here:
        back_rule2 = "home";
        like_s = "d";
        account_history_datils("deposit", "", "", "", "");
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(true);
        jTextField4.requestFocus();
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d8_2MouseClicked

    private void d7_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_4MouseClicked
        // TODO add your handling code here:
        back_rule2 = "panel";
        like_s = "all";
        account_history_datils("all", "", "", "", "");
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(true);
        jTextField4.requestFocus();
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d7_4MouseClicked

    private void d8_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_4MouseClicked
        // TODO add your handling code here:
        back_rule2 = "panel";
        like_s = "d";
        account_history_datils("deposit", "", "", "", "");
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(true);
        jTextField4.requestFocus();
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d8_4MouseClicked

    private void d9_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_4MouseClicked
        // TODO add your handling code here:
        back_rule2 = "panel";
        like_s = "w";
        account_history_datils("withdraw", "", "", "", "");
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(true);
        jTextField4.requestFocus();
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d9_4MouseClicked

    private void d1_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_10MouseClicked
        // TODO add your handling code here:
        back_rule2 = "panel";
        save_type = "ATM accounts list";
        like_s = "all";
        atm_account_datils("all", "","","","");
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(true);
        jTextField2.requestFocus();
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d1_10MouseClicked

    private void d1_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_12MouseClicked
        // TODO add your handling code here:
        back_rule2 = "panel";
        like_s = "a";
        atm_account_datils("active", "", "","","");
        save_type = "Active ATM accounts list";
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(true);
        jTextField2.requestFocus();
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d1_12MouseClicked

    private void d1_14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_14MouseClicked
        // TODO add your handling code here:
        back_rule2 = "panel";
        like_s = "b";
        atm_account_datils("block", "", "","","");
        save_type = "Block ATM accounts list";
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(true);
        jTextField2.requestFocus();
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_d1_14MouseClicked

    private void jPanel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel44MouseClicked
        // TODO add your handling code here:
        accounts_pnl.setVisible(false);
        main_profile.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(true);
        jDateChooser7.setDate(null);
        jDateChooser8.setDate(null);
        tr1.setText(null);
        tr2.setText(null);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_jPanel44MouseClicked

    private void checkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkFocusGained
        // TODO add your handling code here:
        accerr.setText(null);
    }//GEN-LAST:event_checkFocusGained
    void withdraw_money() {
        String df = out.getText();
        if (out.getText().isEmpty() || df.equals("Enter balance you want to withdraw")) {
            accerr7.setText("Enter amount");
        } else {
            if (act.check_account_status(wth2.getText()) == true) {
                int ot = Integer.parseInt(out.getText());
                if (snbnc < ot || snbnc < 100) {
                    JOptionPane.showMessageDialog(this, "Your Current balance is low", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (act.money_transection(wth2.getText(), snbnc - ot) == true) {
                        int bn=snbnc - ot;
                        dashboraddat();
                        act.account_histroy(wth1.getText(), wth2.getText(), "----", "----", out.getText(), "Withdrawal", wth2.getText(), wth1.getText());
                        java.util.Date nowdate = new java.util.Date(); 
                        String drt1=String.valueOf((nowdate));
                        String dif = "Hy dear "+wth1.getText()+" !..\nYour account No: "+wth2.getText()+" is debited with Rs. "+ot+" on "+drt1+" towards Bank cash withdrawal. Your remaining account balance is Rs. "+bn;
                       Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(email_acc, dif, "Message Alert");
                            }
                        }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "Withdrawal done successfully\nWithdraw Amount: "+ot+".00 PKR\nRemaining account Balance: "+bn+".00 PKR\nWithdraw Time :"+drt1, "Withdraw Receipt", JOptionPane.INFORMATION_MESSAGE);
                        out.setText(null);
                        with.setText(null);
                        with.requestFocus();
                        out.setEditable(false);
                        wth1.setText(null);
                        wth2.setText(null);
                        dpb.setEnabled(false);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "This Account is Blocked", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void dpbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpbActionPerformed
        // TODO add your handling code here:
        withdraw_money();
    }//GEN-LAST:event_dpbActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (with.getText().isEmpty()) {
            accerr6.setText("Enter bank account number");
        } else {
            if (act.check_account(with.getText(), "account") == true) {
                withdraw_money_details(with.getText());
                out.setEditable(true);
                out.setEnabled(true);
                out.requestFocus();
                dpb.setEnabled(true);
            } else {
                accerr6.setText("Account not found");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void outKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outKeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
            accerr7.setText("Enter only digits");
        } else {
            accerr7.setText(null);
        }
    }//GEN-LAST:event_outKeyTyped

    private void outFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_outFocusGained
        // TODO add your handling code here:
        accerr7.setText(null);
    }//GEN-LAST:event_outFocusGained

    private void withFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_withFocusGained
        // TODO add your handling code here:
        accerr6.setText(null);
    }//GEN-LAST:event_withFocusGained

    private void ac12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac12MouseClicked
        // TODO add your handling code here:
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(true);
        with.requestFocus();
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_ac12MouseClicked

    private void ac13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac13MouseClicked
        // TODO add your handling code here:
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(true);
        snd1.requestFocus();
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_ac13MouseClicked

    private void ac14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac14MouseClicked
        // TODO add your handling code here:
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(true);
        check.requestFocus();
        newatm.setVisible(false);
    }//GEN-LAST:event_ac14MouseClicked

    private void ac11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac11MouseClicked
        // TODO add your handling code here:
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(true);
        dpvalue.requestFocus();
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_ac11MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (check.getText().isEmpty()) {
            accerr1.setText("Enter account number");
        } else {
            accerr1.setText(null);
            if (act.check_account(check.getText(), "account") == true) {
                check_balance(check.getText());
            } else {
                accerr1.setText("Account not found");
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void checkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMouseClicked
        // TODO add your handling code here:
        accerr1.setText(null);
    }//GEN-LAST:event_checkMouseClicked

    private void dpvalueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dpvalueFocusGained
        // TODO add your handling code here:
        accerr.setText(null);
    }//GEN-LAST:event_dpvalueFocusGained
    void deposit_money() {
        if (dpvalue.getText().isEmpty()) {
            accerr.setText("Enter account number");
        } else {
            accerr.setText(null);
            if (act.check_account(dpvalue.getText(), "account") == true) {
                check_deposit_details(dpvalue.getText());
                dpvalue2.setEnabled(true);
                dpvalue2.setEditable(true);
                dpvalue2.requestFocus();
                dpbtn.setEnabled(true);
            } else {
                accerr.setText("Account not found");
            }
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        deposit_money();
    }//GEN-LAST:event_jButton4ActionPerformed
    void done_deposit() {
        String df = dpvalue2.getText();
        if (dpvalue2.getText().isEmpty() || df.equals("Enter balance you want to deposit")) {
            accerr5.setText("Enter amount");
        } else {
            if (act.check_account_status(dp2.getText()) == true) {
                int ot = Integer.parseInt(dpvalue2.getText());
                if (ot < 1000) {
                    JOptionPane.showMessageDialog(this, "Minimum 1000 PKR balance required for deposit", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int bn=snbnc + ot;
                    if (act.money_transection(dp2.getText(), snbnc + ot) == true) {
                        dashboraddat();
                        act.account_histroy(dp1.getText(), dp2.getText(), "----", "----", dpvalue2.getText(), "Deposit", dp2.getText(), dp1.getText());
                        java.util.Date nowdate = new java.util.Date(); 
                        String drt1=String.valueOf((nowdate));
                        String sm="Hy dear "+dp1.getText()+" !..\nThis message is to confirm that we received a deposit of RS "+ot+".00 PKR in your account "+dp2.getText()+" on "+drt1+".Your account current balance is "+bn+".00 PKR. Thank you!";
                        Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(email_acc, sm, "Message Alert");
                            }
                        }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "Amount deposit successfully\nDeposit Amount: "+ot+".00 PKR\nCurrent Balance: "+bn+".00 PKR\nDeposit Time :"+drt1, "Deposit Receipt", JOptionPane.INFORMATION_MESSAGE);
                        dpvalue.setText(null);
                        dpvalue.requestFocus();
                        dpvalue2.setText(null);
                        with.setText(null);
                        dpvalue2.setEditable(false);
                        dp1.setText(null);
                        dp2.setText(null);
                        dpbtn.setEnabled(false);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "This Account is Blocked", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void dpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpbtnActionPerformed
        // TODO add your handling code here:
        done_deposit();
    }//GEN-LAST:event_dpbtnActionPerformed

    private void dpvalue2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dpvalue2FocusGained
        // TODO add your handling code here:
        accerr5.setText(null);
    }//GEN-LAST:event_dpvalue2FocusGained
    void done_sending() {
        String df = snd.getText();
        if (snd.getText().isEmpty() || df.equals("Enter balance you want to transfer")) {
            accerr4.setText("Enter amount");
        } else {
            if (act.check_account_status(sn2.getText()) == true) {
                if (act.check_account_status(rc2.getText()) == true) {
                    int ot = Integer.parseInt(snd.getText());
                    if (ot < 1000) {
                        JOptionPane.showMessageDialog(this, "Minimum 1000 PKR balance required for transection", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (snbnc < ot || snbnc < 100) {
                            JOptionPane.showMessageDialog(this, "Your Current balance is low for this transection", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            int pt=ot;
                            int tex=0;
                            if(ot>5000){
                                ot=ot+20;
                                tex=20;
                            }
                            if (act.money_transection(sn2.getText(), snbnc - ot) == true && act.money_transection(rc2.getText(), rcbnc + pt) == true) {
                                act.account_histroy(sn1.getText(), sn2.getText(), rc1.getText(), rc2.getText(), snd.getText(), "Transection", sn2.getText(), sn1.getText());
                                act.account_histroy(sn1.getText(), sn2.getText(), rc1.getText(), rc2.getText(), snd.getText(), "Received", rc2.getText(), rc1.getText());
                                int bn=snbnc - ot;
                                int bn1=rcbnc + pt;
                                java.util.Date nowdate = new java.util.Date(); 
                                String drt1=String.valueOf((nowdate));
                                String dif="Your transaction is successful on "+drt1+".\n" +
                                          "Transaction details are given below\n\n" +
                                          "Sender Account Number:  "+sn2.getText()+"\n" +
                                          "Sender Account Title:  "+sn1.getText()+"\n" +
                                          "Bank Name: SKY Bank Limited Pakistan\n" +
                                          "Transaction to:  SKY Bank Limited Pakistan\n" +
                                          "Receiver's Name: "+rc1.getText()+"\n" +
                                          "Receiver's Account Number: "+rc2.getText()+"\n" +
                                          "Amount: Rs. "+pt+".00 PKR\n" +
                                          "Fee (Exclusive of tax): "+tex+".00PKR\n" +
                                          "Total Amount:  Rs "+ot+".00 PKR\n"+
                                          "Remaining account Balance: "+bn+".00 PKR"+
                                          "\n\n_______________________________________________\n"+
                                          "\n     Thank you for using SKY Bank Account       \n" +
                                          "_______________________________________________\n";
                                String diif="You have recieved amount RS "+pt+".00 PKR  on "+drt1+
                                          ".\nSender details are given below\n\n" +
                                          "Sender Account Number:  "+sn2.getText()+"\n" +
                                          "Sender Account Title:  "+sn1.getText()+"\n" +
                                          "Sender Bank Name:  SKY Bank Limited Pakistan\n" +
                                          "Recieved Amount:  Rs "+pt+".00 PKR\n" +
                                          "Current account Balance:  Rs "+bn1+".00 PKR\n"+
                                          "\n_______________________________________________\n"+
                                          "\n     Thank you for using SKY Bank Account       \n" +
                                          "_______________________________________________\n";
                                Thread t = new Thread(new Runnable(){
                                 public void run(){
                                 if (net() == true) {
                                em.send(email_acc, dif, "Message Alert");
                                em.send(email_acc1, diif, "Message Alert");
                                }
                                 }
                                   });
                                 t.start();
                                JOptionPane.showMessageDialog(this, dif, "Transection Receipt", JOptionPane.INFORMATION_MESSAGE);
                                snd1.setText(null);
                                snd2.setText(null);
                                snd.setText(null);
                                snd.setEditable(false);
                                sn1.setText(null);
                                snd1.requestFocus();
                                sn2.setText(null);
                                rc1.setText(null);
                                rc2.setText(null);
                                sndbtn.setEnabled(false);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Receiver Account is Blocked", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sender Account is Blocked", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void sndbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sndbtnActionPerformed
        // TODO add your handling code here:
        done_sending();
    }//GEN-LAST:event_sndbtnActionPerformed
    void send_money() {
        if (snd1.getText().isEmpty() || snd2.getText().isEmpty()) {
            if (snd1.getText().isEmpty()) {
                accerr2.setText("Enter Sender bank account number");
            }
            if (snd2.getText().isEmpty()) {
                accerr3.setText("Enter Receiver bank account number");
            }
        } else {
            accerr2.setText(null);
            accerr3.setText(null);
            String sd1 = snd1.getText();
            String sd2 = snd2.getText();
            if (sd1.equals(sd2)) {
                JOptionPane.showMessageDialog(this, "Use different accounts for transection", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (act.check_account(snd1.getText(), "account") == true) {
                    if (act.check_account(snd2.getText(), "account") == true) {;
                        receiver_money_details(sd2);
                        sender_money_details(sd1);
                        snd.setEditable(true);
                        snd.setEnabled(true);
                        snd.requestFocus();
                        sndbtn.setEnabled(true);
                    } else {
                        accerr3.setText("Receiver account not found");
                    }
                } else {
                    accerr2.setText("Sender account not found");
                }
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        send_money();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void snd1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_snd1FocusGained
        // TODO add your handling code here:
        accerr2.setText(null);
    }//GEN-LAST:event_snd1FocusGained

    private void snd2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_snd2FocusGained
        // TODO add your handling code here:
        accerr3.setText(null);
    }//GEN-LAST:event_snd2FocusGained

    private void snd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snd1ActionPerformed

    private void sndFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sndFocusGained
        // TODO add your handling code here:
        accerr4.setText(null);
    }//GEN-LAST:event_sndFocusGained

    private void sndKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sndKeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
            accerr4.setText("Enter only digits");
        } else {
            accerr4.setText(null);
        }
    }//GEN-LAST:event_sndKeyTyped

    private void dpvalue2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpvalue2KeyTyped
        // TODO add your handling code here:
        char word = evt.getKeyChar();
        if (!(Character.isDigit(word) || (word == KeyEvent.VK_BACK_SPACE) || word == KeyEvent.VK_DELETE || word == KeyEvent.VK_ENTER)) {
            evt.consume();
            getToolkit().beep();
            accerr5.setText("Enter only digits");
        } else {
            accerr5.setText(null);
        }
    }//GEN-LAST:event_dpvalue2KeyTyped

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked
        // TODO add your handling code here:
        bnk_block.setVisible(false);
        panel1.setVisible(false);
        jTextField1.setText(null);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(true);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        newatm.setVisible(false);
    }//GEN-LAST:event_jPanel28MouseClicked

    private void jPanel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseClicked
        // TODO add your handling code here:
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        with.setText(null);
        wth1.setText(null);
        wth2.setText(null);
        out.setText(null);
        out.setEditable(false);
        dpb.setEnabled(false);
    }//GEN-LAST:event_jPanel37MouseClicked

    private void jPanel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel46MouseClicked
        // TODO add your handling code here:
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        snd1.setText(null);
        snd2.setText(null);
        snd.setText(null);
        sn1.setText(null);
        sn2.setText(null);
        rc1.setText(null);
        sndbtn.setEnabled(false);
        snd.setEditable(false);
        rc2.setText(null);
    }//GEN-LAST:event_jPanel46MouseClicked

    private void jPanel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel47MouseClicked
        // TODO add your handling code here:
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        dpvalue2.setText(null);
        dpvalue.setText(null);
        dp1.setText(null);
        dp2.setText(null);
        dpbtn.setEnabled(false);
        dpvalue2.setEditable(false);
    }//GEN-LAST:event_jPanel47MouseClicked
    void empy() {
        check.setText(null);
        bnc1.setText(null);
        jDateChooser5.setDate(null);
        jDateChooser6.setDate(null);
        jTextField2.setText(null);
        jDateChooser7.setDate(null);
        jDateChooser8.setDate(null);
        jDateChooser4.setDate(null);
        jDateChooser3.setDate(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jTextField4.setText(null);
        jTextField3.setText(null);
        bnc2.setText(null);
        bnc3.setText(null);
        dpvalue2.setText(null);
        dpvalue.setText(null);
        dp1.setText(null);
        dp2.setText(null);
        dpbtn.setEnabled(false);
        dpvalue2.setEditable(false);
        snd1.setText(null);
        snd2.setText(null);
        snd.setText(null);
        sn1.setText(null);
        sn2.setText(null);
        rc1.setText(null);
        sndbtn.setEnabled(false);
        snd.setEditable(false);
        rc2.setText(null);
        with.setText(null);
        wth1.setText(null);
        wth2.setText(null);
        out.setText(null);
        out.setEditable(false);
        dpb.setEnabled(false);
    }
    private void jPanel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseClicked
        // TODO add your handling code here:
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
        newatm.setVisible(false);
        withdraw_money_pnl.setVisible(false);
        balance_history_pnl.setVisible(false);
        send_money_pnl.setVisible(false);
        deposit_mony_pnl.setVisible(false);
        check_blnc_pnl.setVisible(false);
        check.setText(null);
        bnc1.setText(null);
        bnc2.setText(null);
        bnc3.setText(null);
    }//GEN-LAST:event_jPanel48MouseClicked

    private void snd2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_snd2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (snd1.getText().isEmpty() || snd2.getText().isEmpty()) {
                if (snd1.getText().isEmpty()) {
                    accerr2.setText("Enter Sender account");
                }
                if (snd2.getText().isEmpty()) {
                    accerr3.setText("Enter Receiver account");
                }
            } else {
                send_money();
            }
        }
    }//GEN-LAST:event_snd2KeyPressed

    private void sndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sndKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (snd.getText().isEmpty()) {
                accerr4.setText("Enter amount");
            } else {
                done_sending();
            }
        }
    }//GEN-LAST:event_sndKeyPressed

    private void dpvalueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpvalueKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (dpvalue.getText().isEmpty()) {
                accerr.setText("Enter account number");
            } else {
                deposit_money();
            }
        }
    }//GEN-LAST:event_dpvalueKeyPressed

    private void dpvalue2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpvalue2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (dpvalue2.getText().isEmpty()) {
                accerr5.setText("Enter amount");
            } else {
                done_deposit();
            }
        }
    }//GEN-LAST:event_dpvalue2KeyPressed

    private void checkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_checkKeyPressed
        // TODO add your handling code here:\
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (check.getText().isEmpty()) {
                accerr1.setText("Enter account number");
            } else {
                accerr1.setText(null);
                if (act.check_account(check.getText(), "account") == true) {
                    check_balance(check.getText());
                } else {
                    accerr1.setText("Account not found");
                }
            }
        }
    }//GEN-LAST:event_checkKeyPressed

    private void withKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (with.getText().isEmpty()) {
                accerr6.setText("Enter bank account number");
            } else {
                if (act.check_account(with.getText(), "account") == true) {
                    withdraw_money_details(with.getText());
                    out.setEditable(true);
                    out.requestFocus();
                    dpb.setEnabled(true);
                } else {
                    accerr6.setText("Account not found");
                }
            }
        }
    }//GEN-LAST:event_withKeyPressed

    private void outKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (out.getText().isEmpty()) {
                accerr7.setText("Enter amount");
            } else {
                withdraw_money();
            }
        }
    }//GEN-LAST:event_outKeyPressed

    private void ac15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac15MouseClicked
        // TODO add your handling code here:
        String vl = JOptionPane.showInputDialog(this, "Enter your Bank Account number", "Account history", JOptionPane.QUESTION_MESSAGE);
        if (vl.length() > 0) {
            if (act.check_account(vl, "account") == true) {
                account_history_datils_search("dep", vl,"","","");
                bnk_block.setVisible(true);
                panel1.setVisible(false);
                main_profile.setVisible(false);
                accounts_pnl.setVisible(false);
                atm_table_pnl.setVisible(false);
                saving_acc_pnl.setVisible(false);
                up_search_acc.setVisible(false);
                panel1.setVisible(false);
                home_panel.setVisible(false);
                panel2.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel6.setVisible(false);
                insertion_acc.setVisible(false);
                action_acc.setVisible(false);
                search_acc.setVisible(false);
                update_acc.setVisible(false);
                withdraw_money_pnl.setVisible(false);
                balance_history_pnl.setVisible(false);
                send_money_pnl.setVisible(false);
                deposit_mony_pnl.setVisible(false);
                check_blnc_pnl.setVisible(false);
                newatm.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter account number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ac15MouseClicked

    private void ac15an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac15an_menter
        // TODO add your handling code here:
        lac15.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac15.setBackground(Color.blue);
        lac15.setForeground(Color.white);
    }//GEN-LAST:event_ac15an_menter

    private void ac15an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac15an_mexit
        // TODO add your handling code here:
        lac15.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac15.setForeground(Color.black);
        ac15.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ac15an_mexit

    private void jPanel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseClicked
        // TODO add your handling code here:
        accounts_pnl.setVisible(false);
        main_profile.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(true);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_jPanel33MouseClicked

    private void accounts_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accounts_tableMouseClicked
        // TODO add your handling code here:
        int i = accounts_table.getSelectedRow();
        int column = 2;
        String value = accounts_table.getModel().getValueAt(i, column).toString();
        account_data_all(value, "account");
        back_rule = "accnt";
        main_profile.setVisible(true);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        bnk_block.setVisible(false);
        saving_acc_pnl.setVisible(false);
        up_search_acc.setVisible(false);
        panel1.setVisible(false);
        home_panel.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        insertion_acc.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
        update_acc.setVisible(false);
    }//GEN-LAST:event_accounts_tableMouseClicked

    private void snd1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_snd1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            snd2.requestFocus();
        }
    }//GEN-LAST:event_snd1KeyPressed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        int u = JOptionPane.showConfirmDialog(null, "Are you sure to logout your account", "Confirm", JOptionPane.YES_NO_OPTION);
        if (u == JOptionPane.YES_OPTION) {
            JLabel messageLabel = new JLabel("<html><body><p style='width: 180px;'>"+"Please wait...."+"</p></body></html>");
        Timer timr = new Timer(3000, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messageLabel).dispose();
        });
        timr.setRepeats(false);
        timr.start();
        JOptionPane.showOptionDialog(null, messageLabel,"Message", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
        pp.emp_account_login_status(em1.getText(),"offline");
            login gh = new login();
            gh.setVisible(true);
            gh.lgn();
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_jPanel5MouseClicked
    void pdf_his(JTable tb, String sm, String nam,String acc,String head,String from,String to) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(sm));
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                File theFileToSave = chooser.getSelectedFile();
                Document document = new Document();
                PdfWriter writer;
                try {
                    java.util.Date dt = new java.util.Date();
                    writer = PdfWriter.getInstance(document, new FileOutputStream(theFileToSave + ".pdf"));
                    document.open();
                    BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\Calibri.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    Font font1 = new Font(bf, 15, Font.BOLD);
                    document.add(new Paragraph("                SKY Bank Limited Pakistan",font1));
                    if(nam!=null){
                    document.add(new Paragraph("                Account Title  : "+nam));
                    document.add(new Paragraph("                Account Number : "+acc));
                    }else{
                    if(from!=null){
                        document.add(new Paragraph("                Accounts history from : "+from+" to : "+to+" date format MM/dd/yyyy."));
                    }else{
                        document.add(new Paragraph("                Accounts history from : Start  to : "+to));
                    }
                    document.add(new Paragraph("                Accounts history of balance"));
                    }
                    document.add(new Paragraph("                Print date : "+dt.toString()));
                    document.add(new Paragraph("                --------------------------------------------------------------------------------------"));
                    document.add(new Paragraph("                .                  "));
                    String[] headers=new String[7];
                    headers[0]="No";
                    if(head.equals("send")){
                        headers[1]="Reciever Name";
                        headers[2]="Receiver Account";
                    }
                    else if(head.equals("get")){
                        headers[1]="Sender Name";
                        headers[2]="Sender Account";
                    }else{
                        headers[1]="Name";
                        headers[2]="Account No";
                    }
                    headers[3]="Date & Time";
                    headers[4]="History Type";
                    headers[5]="Amount";
                    PdfPTable pdfTable = new PdfPTable(tb.getColumnCount());
                    int tableWidths[] = new int[tb.getColumnCount()];
                    Font font = new Font(bf, 10);
                    Font fonth = new Font(bf, 10, Font.BOLD);
                    for (int i = 0; i < tb.getColumnCount(); i++) {
                        TableColumn column = tb.getColumnModel().getColumn(i);
                        tableWidths[i] = column.getWidth();
                    }
                    pdfTable.setWidths(tableWidths);
                    pdfTable.setSpacingAfter(20);
                    for (int i = 0; i < tb.getColumnCount(); i++) {
                        PdfPCell cell1 = new PdfPCell(new Phrase(headers[i],fonth));
                        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        cell1.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell1.setPaddingBottom(9);
                        pdfTable.addCell(cell1);
                    }
                    for (int rows = 0; rows < tb.getRowCount(); rows++) {
                        for (int cols = 0; cols < tb.getColumnCount(); cols++) {
                            PdfPCell cell2 = new PdfPCell(new Phrase(tb.getModel().getValueAt(rows, cols).toString(), font));
                            cell2.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell2.setPaddingBottom(6);
                            pdfTable.addCell(cell2);
                        }
                    }
                    document.add(pdfTable);
                    document.add(new Paragraph("                If you have any quiry please send email on  amirghafoorcss@gmail.com "));
                    document.close();
                    JOptionPane.showMessageDialog(this, "File save successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (DocumentException | IOException ex) {
                    Logger.getLogger(employee_portal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String dit=null;
        String drt=null;
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date(); 
        if (jDateChooser1.getDate()!=null) {
            if(jDateChooser2.getDate()!=null){
                drt = date1.format(jDateChooser2.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser1.getDate());
        }else{
            drt=String.valueOf(date1.format(nowdate));
        }
        pdf_his(bnc_history, hit1.getText(),null,null,"none",dit,drt);
    }//GEN-LAST:event_jButton2ActionPerformed
    void pdf_acc(JTable tb, String name,String from,String to) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(name));
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                File theFileToSave = chooser.getSelectedFile();
                Document document = new Document();
                PdfWriter writer;
                try {
                    writer = PdfWriter.getInstance(document, new FileOutputStream(theFileToSave + ".pdf"));
                    document.open();
                    java.util.Date dt = new java.util.Date();
                     BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\Calibri.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    Font font1 = new Font(bf, 15, Font.BOLD);
                    document.add(new Paragraph("                SKY Bank Limited Pakistan",font1));
                    document.add(new Paragraph("                "+name));
                    if(from!=null){
                        document.add(new Paragraph("                Accounts record from : "+from+" to : "+to+" date format MM/dd/yyyy."));
                    }else{
                        document.add(new Paragraph("                Accounts record from : Start  to : "+to));
                    }
                    document.add(new Paragraph("                Print date : "+dt.toString()));
                    document.add(new Paragraph("                --------------------------------------------------------------------------------------"));
                    document.add(new Paragraph("                .                  "));
                    PdfPTable pdfTable = new PdfPTable(tb.getColumnCount());
                    int tableWidths[] = new int[tb.getColumnCount()];
                    Font font = new Font(bf, 10);
                    Font fonth = new Font(bf, 10, Font.BOLD);
                    for (int i = 0; i < tb.getColumnCount(); i++) {
                        TableColumn column = tb.getColumnModel().getColumn(i);
                        tableWidths[i] = column.getWidth();
                    }
                    pdfTable.setWidths(tableWidths);
                    pdfTable.setSpacingAfter(20);
                    for (int i = 0; i < tb.getColumnCount(); i++) {
                        PdfPCell cell1 = new PdfPCell(new Phrase(tb.getColumnName(i), fonth));
                        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        cell1.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell1.setPaddingBottom(9);
                        pdfTable.addCell(cell1);
                    }
                    int siz = (tb.getColumnCount());
                    for (int rows = 0; rows < tb.getRowCount(); rows++) {
                        for (int cols = 0; cols < siz; cols++) {
                            if (cols == 6) {
                                JLabel image1 = (JLabel) tb.getModel().getValueAt(rows, cols);
                                ImageIcon mgh = (ImageIcon) image1.getIcon();
                                java.awt.Image awtImage = mgh.getImage();
                                Image img = Image.getInstance(awtImage, null);
                                pdfTable.addCell(img);
                            } else {
                                PdfPCell cell2 = new PdfPCell(new Phrase(tb.getModel().getValueAt(rows, cols).toString(), font));
                                cell2.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                cell2.setPaddingBottom(6);
                                pdfTable.addCell(cell2);
                            }
                        }
                    }
                    document.add(pdfTable);
                    document.add(new Paragraph("                If any quiry please send email on  amirghafoorcss@gmail.com "));
                    document.close();
                    JOptionPane.showMessageDialog(this, "File save successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (DocumentException | IOException ex) {
                    Logger.getLogger(employee_portal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String dit=null;
        String drt=null;
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date(); 
        if (jDateChooser3.getDate()!=null) {
            if(jDateChooser4.getDate()!=null){
                drt = date1.format(jDateChooser4.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser3.getDate());
        }else{
            drt=String.valueOf(date1.format(nowdate));
        }
        pdf_acc(accounts_table, save_type,dit,drt);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(m3j.getText()));
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                File theFileToSave = chooser.getSelectedFile();
                try {
                    BufferedImage img = new BufferedImage(aspane3.getWidth(), aspane3.getHeight(), BufferedImage.TYPE_INT_RGB);
                    aspane3.paint(img.getGraphics());
                    ImageIO.write(img, "png", new File(theFileToSave + ".png"));
                    JOptionPane.showMessageDialog(this, "Profile data saved successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | IOException ex) {
                    System.out.print(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String dit=null;
        String drt=null;
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date(); 
        if (jDateChooser5.getDate()!=null) {
            if(jDateChooser6.getDate()!=null){
                drt = date1.format(jDateChooser6.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser5.getDate());
        }else{
            drt=String.valueOf(date1.format(nowdate));
        }
        pdf_acc(atm_table, save_type,dit,drt);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(s3f.getText()));
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                File theFileToSave = chooser.getSelectedFile();
                try {
                    BufferedImage img = new BufferedImage(aspane.getWidth(), aspane.getHeight(), BufferedImage.TYPE_INT_RGB);
                    aspane.paint(img.getGraphics());
                    ImageIO.write(img, "png", new File(theFileToSave + ".png"));
                    JOptionPane.showMessageDialog(this, "Profile data saved successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | IOException ex) {
                    System.out.print(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            String dit =null;
        if (jTextField2.getText().isEmpty()) {
            if(jDateChooser5.getDate()!=null){
            if(jDateChooser6.getDate()!=null){
                drt = date1.format(jDateChooser6.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit= date1.format(jDateChooser5.getDate());
          atm_account_datils("date",jTextField2.getText(), like_s,dit,drt);
        }else{
            if (like_s.equals("all")) {
                atm_account_datils("all", "", "","","");
            }
            if (like_s.equals("a")) {
                atm_account_datils("active", "", "","","");
            }
            if (like_s.equals("b")) {
                atm_account_datils("block", "", "","","");
            }
            }
        } else {
            if(jDateChooser5.getDate()!=null){
            if(jDateChooser6.getDate()!=null){
                drt = date1.format(jDateChooser6.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit= date1.format(jDateChooser5.getDate());
          atm_account_datils("date_s",jTextField2.getText(), like_s,dit,drt);
        }else{
            atm_account_datils("like", jTextField2.getText(), like_s,"","");
            }
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            String dit=null;
        String nk=jTextField3.getText();
        if (jTextField3.getText().isEmpty()) {
            if(jDateChooser3.getDate()!=null){
            if(jDateChooser4.getDate()!=null){
                drt = date1.format(jDateChooser4.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser3.getDate());
            bank_account_datils("date","",like_s,dit,drt);
        }else{
            if (like_s.equals("c")) {
                bank_account_datils("current", "", "","","");
            }
            if (like_s.equals("s")) {
                bank_account_datils("saving", "", "","","");
            }
            if (like_s.equals("b")) {
                bank_account_datils("block", "", "","","");
            }
            }
        } else if(nk!=null) {
            if(jDateChooser3.getDate()!=null){
            if(jDateChooser4.getDate()!=null){
                drt = date1.format(jDateChooser4.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser3.getDate());
            bank_account_datils("date_s",jTextField3.getText(),like_s,dit,drt);
        }else{
            bank_account_datils("like", jTextField3.getText(), like_s,"","");
            }
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            String dit=null;
        if (jTextField4.getText().isEmpty()) {
            if (jDateChooser1.getDate()!=null) {
            if(jDateChooser2.getDate()!=null){
                drt = date1.format(jDateChooser2.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser1.getDate());
            account_history_datils("date", like_s,"",dit,drt);
        }else{
            if (like_s.equals("all")) {
                account_history_datils("all", "", "", "", "");
            }
            if (like_s.equals("d")) {
                account_history_datils("deposit", "", "", "", "");
            }
            if (like_s.equals("w")) {
                account_history_datils("withdraw", "", "", "", "");
            }
            }
        } else {
            if (jDateChooser1.getDate()!=null) {
            if(jDateChooser2.getDate()!=null){
                drt = date1.format(jDateChooser2.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser1.getDate());
            account_history_datils("date_s", like_s,jTextField4.getText(),dit,drt);
        }else{
            account_history_datils("like", like_s, jTextField4.getText(), "", "");
            }
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jPanel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel49MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel49MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String heds=null;
        String drt=null;
        String dit=null;
        if(r1.isSelected() || r2.isSelected()){
            heds="none";
        }
        if(r3.isSelected()){
            heds="get";
        }
        if(r4.isSelected()){
            heds="send";
        }
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date(); 
        if (jDateChooser7.getDate()!=null) {
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser7.getDate());
        }else{
            drt=String.valueOf(date1.format(nowdate));
        }
        pdf_his(bnc_history1, tr1.getText(), tr1.getText(),tr2.getText(),heds,dit,drt);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
        r2.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        r1.setSelected(true);
        if (jDateChooser7.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser7.getDate());
                account_history_datils_search("dep", tr2.getText(),dit,drt,"date");
        }else{
           account_history_datils_search("dep", tr2.getText(),"","","");
        }
    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
        r1.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        r2.setSelected(true);
        if (jDateChooser7.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser7.getDate());
                account_history_datils_search("with", tr2.getText(),dit,drt,"date");
        }else{
           account_history_datils_search("with", tr2.getText(),"","","");
        }
    }//GEN-LAST:event_r2ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        // TODO add your handling code here:
        r2.setSelected(false);
        r1.setSelected(false);
        r4.setSelected(false);
        r3.setSelected(true);
        if (jDateChooser7.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser7.getDate());
                account_history_datils_search("get", tr2.getText(),dit,drt,"date");
        }else{
            account_history_datils_search("get", tr2.getText(),"","","");
        }
    }//GEN-LAST:event_r3ActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        // TODO add your handling code here:
        r2.setSelected(false);
        r3.setSelected(false);
        r1.setSelected(false);
        r4.setSelected(true);
        if (jDateChooser7.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser7.getDate());
                account_history_datils_search("send", tr2.getText(),dit,drt,"date");
        }else{
            account_history_datils_search("send", tr2.getText(),"","","");
        }
    }//GEN-LAST:event_r4ActionPerformed

    private void jDateChooser5PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser5PropertyChange
        // TODO add your handling code here:
        if(jDateChooser5.getDate()!=null){
            //SimpleDateFormat date1=new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser6.getDate()!=null){
                drt = date1.format(jDateChooser6.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser5.getDate());
         atm_account_datils("date","", like_s,dit,drt);
        }
        else{
            if(like_s!=null){
            if (like_s.equals("all")) {
                atm_account_datils("all", "", "","","");
            }
            if (like_s.equals("a")) {
                atm_account_datils("active", "", "","","");
            }
            if (like_s.equals("b")) {
                atm_account_datils("block", "", "","","");
            }
            }
        }
    }//GEN-LAST:event_jDateChooser5PropertyChange

    private void jDateChooser6PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser6PropertyChange
        // TODO add your handling code here:
        if(jDateChooser5.getDate()!=null && jDateChooser6.getDate()!=null){
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy"); 
            String drt=date1.format(jDateChooser6.getDate());
            String dit = date1.format(jDateChooser5.getDate());
         atm_account_datils("date","", like_s,dit,drt);
        }
        else{
            if(like_s!=null){
            if (like_s.equals("all")) {
                atm_account_datils("all", "", "","","");
            }
            if (like_s.equals("a")) {
                atm_account_datils("active", "", "","","");
            }
            if (like_s.equals("b")) {
                atm_account_datils("block", "", "","","");
            }
            }
        }
    }//GEN-LAST:event_jDateChooser6PropertyChange

    private void jDateChooser3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser3PropertyChange
        // TODO add your handling code here:
        jTextField3.setText(null);
        if(jDateChooser3.getDate()!=null){
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser4.getDate()!=null){
                drt = date1.format(jDateChooser4.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser3.getDate());
         bank_account_datils("date","",like_s,dit,drt);
        }else{
            if(like_s!=null){
            if (like_s.equals("c")) {
                bank_account_datils("current","", "","","");
            }
            if (like_s.equals("s")) {
                bank_account_datils("saving", "", "","","");
            }
            if (like_s.equals("b")) {
                bank_account_datils("block", "", "","","");
            }
            }
        }
        
    }//GEN-LAST:event_jDateChooser3PropertyChange

    private void jDateChooser4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser4PropertyChange
        // TODO add your handling code here:
        jTextField3.setText(null);
        if(jDateChooser3.getDate()!=null  && jDateChooser4.getDate()!=null){
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            String drt=date1.format(jDateChooser4.getDate());
            String dit = date1.format(jDateChooser3.getDate());
         bank_account_datils("date","", like_s,dit,drt);
        }else{
            if(like_s!=null){
            if (like_s.equals("c")) {
                bank_account_datils("current","", "","","");
            }
            if (like_s.equals("s")) {
                bank_account_datils("saving", "", "","","");
            }
            if (like_s.equals("b")) {
                bank_account_datils("block", "", "","","");
            }
            }
        }
    }//GEN-LAST:event_jDateChooser4PropertyChange

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
         if (jDateChooser1.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser2.getDate()!=null){
                drt = date1.format(jDateChooser2.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser1.getDate());
            account_history_datils("date", like_s,"",dit,drt);
        } else {
             if(like_s!=null){
            if (like_s.equals("all")) {
                account_history_datils("all", "", "", "", "");
            }
            if (like_s.equals("d")) {
                account_history_datils("deposit", "", "", "", "");
            }
            if (like_s.equals("w")) {
                account_history_datils("withdraw", "", "", "", "");
            }
             }
        }
        
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        // TODO add your handling code here:
        if (jDateChooser1.getDate()!=null && jDateChooser2.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            String drt=date1.format(jDateChooser2.getDate());
            String dit = date1.format(jDateChooser1.getDate());
            account_history_datils("date", like_s,"",dit,drt);
        } else {
             if(like_s!=null){
            if (like_s.equals("all")) {
                account_history_datils("all", "", "", "", "");
            }
            if (like_s.equals("d")) {
                account_history_datils("deposit", "", "", "", "");
            }
            if (like_s.equals("w")) {
                account_history_datils("withdraw", "", "", "", "");
            }
             }
        }
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jDateChooser7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser7PropertyChange
        // TODO add your handling code here:
        if (jDateChooser7.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser7.getDate());
             if (r1.isSelected()) {
                account_history_datils_search("dep", tr2.getText(),dit,drt,"date");
            }
            if (r2.isSelected()) {
                account_history_datils_search("with", tr2.getText(),dit,drt,"date");
            }
            if (r3.isSelected()) {
                account_history_datils_search("get", tr2.getText(),dit,drt,"date");
            }
            if (r4.isSelected()) {
                account_history_datils_search("send", tr2.getText(),dit,drt,"date");
            }
        } else {
             if(!(tr2.getText().isEmpty())){
            if (r1.isSelected()) {
                account_history_datils_search("dep", tr2.getText(),"","","");
            }
            if (r2.isSelected()) {
                account_history_datils_search("with", tr2.getText(),"","","");
            }
            if (r3.isSelected()) {
                account_history_datils_search("get", tr2.getText(),"","","");
            }
            if (r4.isSelected()) {
                account_history_datils_search("send", tr2.getText(),"","","");
            }
             }
        }
    }//GEN-LAST:event_jDateChooser7PropertyChange

    private void jDateChooser8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser8PropertyChange
        // TODO add your handling code here:
        if (jDateChooser7.getDate()!=null && jDateChooser8.getDate()!=null) {
             SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            String drt = date1.format(jDateChooser8.getDate());
            String dit = date1.format(jDateChooser7.getDate());
             if (r1.isSelected()) {
                account_history_datils_search("dep", tr2.getText(),dit,drt,"date");
            }
            if (r2.isSelected()) {
                account_history_datils_search("with", tr2.getText(),dit,drt,"date");
            }
            if (r3.isSelected()) {
                account_history_datils_search("get", tr2.getText(),dit,drt,"date");
            }
            if (r4.isSelected()) {
                account_history_datils_search("send", tr2.getText(),dit,drt,"date");
            }
        } else {
             if(!(tr2.getText().isEmpty())){
            if (r1.isSelected()) {
                account_history_datils_search("dep", tr2.getText(),"","","");
            }
            if (r2.isSelected()) {
                account_history_datils_search("with", tr2.getText(),"","","");
            }
            if (r3.isSelected()) {
                account_history_datils_search("get", tr2.getText(),"","","");
            }
            if (r4.isSelected()) {
                account_history_datils_search("send", tr2.getText(),"","","");
            }
             }
        }
    }//GEN-LAST:event_jDateChooser8PropertyChange

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jTextField4.setText(null);
        if (like_s.equals("all")) {
                account_history_datils("all", "", "", "", "");
            }
        if (like_s.equals("d")) {
                account_history_datils("deposit", "", "", "", "");
            }
        if (like_s.equals("w")) {
                account_history_datils("withdraw", "", "", "", "");
            }
        jTextField4.requestFocus();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if (like_s.equals("c")) {
                bank_account_datils("current", "", "","","");
        }
        else if (like_s.equals("s")) {
                bank_account_datils("saving", "", "","","");
        }
        else if (like_s.equals("b")) {
                bank_account_datils("block", "", "","","");
        }
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        jTextField3.setText(null);
        jTextField3.requestFocus();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText(null);
        jDateChooser5.setDate(null);
        jDateChooser6.setDate(null);
        if (like_s.equals("all")) {
                atm_account_datils("all", "", "","","");
        }
        if (like_s.equals("a")) {
                atm_account_datils("active", "", "","","");
         }
         if (like_s.equals("b")) {
                atm_account_datils("block", "", "","","");
        }
         jTextField2.requestFocus();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void em3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_em3MouseEntered
        // TODO add your handling code here:
        em3.setToolTipText("Date format (dd/MM/YYYY)");
    }//GEN-LAST:event_em3MouseEntered

    private void em8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_em8MouseEntered
        // TODO add your handling code here:
        em8.setToolTipText("Date Format (MM/dd/YYYY)");
    }//GEN-LAST:event_em8MouseEntered

    private void s4zfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s4zfMouseEntered
        // TODO add your handling code here:
        s4zf.setToolTipText("Date format (dd/MM/YYYY)");
    }//GEN-LAST:event_s4zfMouseEntered

    private void atm_date1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm_date1MouseEntered
        // TODO add your handling code here:
        if(!(atm_date1.getText().equals("Not Registered"))){
        atm_date1.setToolTipText("Date Formate (MM/dd/yyyy)");
    }
    }//GEN-LAST:event_atm_date1MouseEntered

    private void joindatekMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joindatekMouseEntered
        // TODO add your handling code here:
        joindatek.setToolTipText("Date Formate (MM/dd/yyyy)");
    }//GEN-LAST:event_joindatekMouseEntered

    private void atm_dateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm_dateMouseEntered
        // TODO add your handling code here:
         if(!(atm_date.getText().equals("Not Registered"))){
        atm_date.setToolTipText("Date Formate (MM/dd/yyyy)");
    }
    }//GEN-LAST:event_atm_dateMouseEntered

    private void m9oMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m9oMouseEntered
        // TODO add your handling code here:
        m9o.setToolTipText("Date Formate (MM/dd/yyyy)");
    }//GEN-LAST:event_m9oMouseEntered

    private void m4pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m4pMouseEntered
        // TODO add your handling code here:
        m4p.setToolTipText("Date Formate (dd/MM/yyyy)");
    }//GEN-LAST:event_m4pMouseEntered

    private void em6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_em6MouseEntered
        // TODO add your handling code here:
        em6.setToolTipText("Email : "+em6.getText());
    }//GEN-LAST:event_em6MouseEntered

    private void s7fMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s7fMouseEntered
        // TODO add your handling code here:
        s7f.setToolTipText("Email : "+s7f.getText());
    }//GEN-LAST:event_s7fMouseEntered

    private void m7tMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m7tMouseEntered
        // TODO add your handling code here:
        m7t.setToolTipText("Email : "+m7t.getText());
    }//GEN-LAST:event_m7tMouseEntered

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
            java.util.logging.Logger.getLogger(employee_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee_portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee_portal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel a1;
    private javax.swing.JPanel a2;
    private javax.swing.JPanel a4;
    private javax.swing.JPanel a6;
    private javax.swing.JPanel a7;
    private javax.swing.JPanel ac1;
    private javax.swing.JPanel ac11;
    private javax.swing.JPanel ac12;
    private javax.swing.JPanel ac13;
    private javax.swing.JPanel ac14;
    private javax.swing.JPanel ac15;
    private javax.swing.JPanel ac2;
    private javax.swing.JPanel ac3;
    private javax.swing.JPanel ac4;
    private javax.swing.JPanel ac7;
    private javax.swing.JPanel ac8;
    private javax.swing.JPanel acc10;
    private javax.swing.JPanel acc5;
    private javax.swing.JPanel acc6;
    private javax.swing.JPanel acc9;
    private javax.swing.JLabel accerr;
    private javax.swing.JLabel accerr1;
    private javax.swing.JLabel accerr2;
    private javax.swing.JLabel accerr3;
    private javax.swing.JLabel accerr4;
    private javax.swing.JLabel accerr5;
    private javax.swing.JLabel accerr6;
    private javax.swing.JLabel accerr7;
    private javax.swing.JPanel accounts_pnl;
    private javax.swing.JTable accounts_table;
    private javax.swing.JPanel action_acc;
    private javax.swing.JLabel aok;
    private javax.swing.JPanel aspane;
    private javax.swing.JPanel aspane1;
    private javax.swing.JPanel aspane2;
    private javax.swing.JPanel aspane3;
    private javax.swing.JPanel aspane4;
    private javax.swing.JLabel aterr;
    private javax.swing.JTextField atm_date;
    private javax.swing.JTextField atm_date1;
    private javax.swing.JTable atm_table;
    private javax.swing.JPanel atm_table_pnl;
    private javax.swing.JLabel atmpic;
    private javax.swing.JLabel b11u;
    private javax.swing.JLabel b12d;
    private javax.swing.JLabel b12n;
    private javax.swing.JLabel b13;
    private javax.swing.JLabel b14;
    private javax.swing.JLabel b15;
    private javax.swing.JLabel b16;
    private javax.swing.JLabel b17;
    private javax.swing.JLabel b18;
    private javax.swing.JLabel b19b;
    private javax.swing.JLabel b23kk;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel b44l;
    private javax.swing.JLabel b5v;
    private javax.swing.JLabel b6v;
    private javax.swing.JLabel b7v;
    private javax.swing.JLabel b8v;
    private javax.swing.JLabel b9j;
    private javax.swing.JLabel back;
    private javax.swing.JLabel back10;
    private javax.swing.JLabel back11;
    private javax.swing.JLabel back12;
    private javax.swing.JLabel back13;
    private javax.swing.JLabel back14;
    private javax.swing.JLabel back15;
    private javax.swing.JLabel back16;
    private javax.swing.JLabel back1e;
    private javax.swing.JLabel back22;
    private javax.swing.JLabel back3;
    private javax.swing.JLabel back4;
    private javax.swing.JLabel back5k;
    private javax.swing.JLabel back6;
    private javax.swing.JLabel back7;
    private javax.swing.JLabel back8;
    private javax.swing.JLabel back9;
    private javax.swing.JPanel balance_history_pnl;
    private javax.swing.JTextField bnc1;
    private javax.swing.JTextField bnc2;
    private javax.swing.JTextField bnc3;
    private javax.swing.JTable bnc_history;
    private javax.swing.JTable bnc_history1;
    private javax.swing.JPanel bnk_block;
    private javax.swing.JTextField check;
    private javax.swing.JPanel check_blnc_pnl;
    private javax.swing.JLabel cus_logo0;
    private javax.swing.JLabel cus_logo10;
    private javax.swing.JLabel cus_logo20;
    private javax.swing.JLabel cus_logo40;
    private javax.swing.JLabel cus_logo50;
    private javax.swing.JLabel cus_logo60;
    private javax.swing.JLabel cus_logo7;
    private javax.swing.JLabel cus_logo84;
    private javax.swing.JPanel d1_1;
    private javax.swing.JPanel d1_10;
    private javax.swing.JPanel d1_11;
    private javax.swing.JPanel d1_12;
    private javax.swing.JPanel d1_13;
    private javax.swing.JPanel d1_14;
    private javax.swing.JPanel d1_2;
    private javax.swing.JPanel d1_3;
    private javax.swing.JPanel d1_4;
    private javax.swing.JPanel d1_5;
    private javax.swing.JPanel d1_6;
    private javax.swing.JPanel d1_7;
    private javax.swing.JPanel d1_8;
    private javax.swing.JPanel d1_9;
    private javax.swing.JLabel d1_l1;
    private javax.swing.JLabel d1_l10;
    private javax.swing.JLabel d1_l11;
    private javax.swing.JLabel d1_l12;
    private javax.swing.JLabel d1_l13;
    private javax.swing.JLabel d1_l14;
    private javax.swing.JLabel d1_l15;
    private javax.swing.JLabel d1_l16;
    private javax.swing.JLabel d1_l17;
    private javax.swing.JLabel d1_l18;
    private javax.swing.JLabel d1_l19;
    private javax.swing.JLabel d1_l2;
    private javax.swing.JLabel d1_l20;
    private javax.swing.JLabel d1_l21;
    private javax.swing.JLabel d1_l3;
    private javax.swing.JLabel d1_l4;
    private javax.swing.JLabel d1_l5;
    private javax.swing.JLabel d1_l6;
    private javax.swing.JLabel d1_l7;
    private javax.swing.JLabel d1_l8;
    private javax.swing.JLabel d1_l9;
    private javax.swing.JPanel d2_1;
    private javax.swing.JPanel d2_2;
    private javax.swing.JLabel d2_l1;
    private javax.swing.JLabel d2_l2;
    private javax.swing.JLabel d2_l3;
    private javax.swing.JPanel d3_1;
    private javax.swing.JPanel d3_2;
    private javax.swing.JLabel d3_l1;
    private javax.swing.JLabel d3_l2;
    private javax.swing.JLabel d3_l3;
    private javax.swing.JPanel d7_1;
    private javax.swing.JPanel d7_2;
    private javax.swing.JPanel d7_3;
    private javax.swing.JPanel d7_4;
    private javax.swing.JLabel d7_l1;
    private javax.swing.JLabel d7_l2;
    private javax.swing.JLabel d7_l3;
    private javax.swing.JLabel d7_l41;
    private javax.swing.JLabel d7_l51;
    private javax.swing.JLabel d7_l6;
    private javax.swing.JPanel d8_1;
    private javax.swing.JPanel d8_2;
    private javax.swing.JPanel d8_3;
    private javax.swing.JPanel d8_4;
    private javax.swing.JLabel d8_l1;
    private javax.swing.JLabel d8_l2;
    private javax.swing.JLabel d8_l3;
    private javax.swing.JLabel d8_l4;
    private javax.swing.JLabel d8_l5;
    private javax.swing.JLabel d8_l6;
    private javax.swing.JPanel d9_1;
    private javax.swing.JPanel d9_2;
    private javax.swing.JPanel d9_3;
    private javax.swing.JPanel d9_4;
    private javax.swing.JLabel d9_l1;
    private javax.swing.JLabel d9_l2;
    private javax.swing.JLabel d9_l3;
    private javax.swing.JLabel d9_l4;
    private javax.swing.JLabel d9_l5;
    private javax.swing.JLabel d9_l6;
    private javax.swing.JPanel deposit_mony_pnl;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField dp1;
    private javax.swing.JTextField dp2;
    private javax.swing.JButton dpb;
    private javax.swing.JButton dpbtn;
    private javax.swing.JTextField dpvalue;
    private javax.swing.JTextField dpvalue2;
    private javax.swing.JLabel e1;
    private javax.swing.JLabel e10;
    private javax.swing.JLabel e11;
    private javax.swing.JLabel e12;
    private javax.swing.JLabel e13;
    private javax.swing.JLabel e14;
    private javax.swing.JLabel e15;
    private javax.swing.JLabel e16;
    private javax.swing.JLabel e2;
    private javax.swing.JLabel e3;
    private javax.swing.JLabel e4;
    private javax.swing.JLabel e5;
    private javax.swing.JLabel e6;
    private javax.swing.JLabel e7;
    private javax.swing.JLabel e8;
    private javax.swing.JTextField em1;
    private javax.swing.JTextField em10;
    private javax.swing.JTextField em11;
    private javax.swing.JTextField em12;
    private javax.swing.JTextField em13;
    private javax.swing.JTextField em14;
    private javax.swing.JTextField em2;
    private javax.swing.JTextField em3;
    private javax.swing.JTextField em4;
    private javax.swing.JTextField em5;
    private javax.swing.JTextField em6;
    private javax.swing.JTextField em7;
    private javax.swing.JTextField em8;
    private javax.swing.JTextField em9;
    private javax.swing.JLabel emp;
    private javax.swing.JLabel emp1;
    private javax.swing.JLabel emp13;
    private javax.swing.JLabel emp14;
    private javax.swing.JLabel emp15;
    private javax.swing.JLabel emp166;
    private javax.swing.JLabel emp17;
    private javax.swing.JLabel emp18;
    private javax.swing.JLabel emp19;
    private javax.swing.JLabel emp2;
    private javax.swing.JLabel emp20;
    private javax.swing.JLabel emp21;
    private javax.swing.JLabel emp3;
    private javax.swing.JLabel emp6;
    private javax.swing.JLabel emp7;
    private javax.swing.JLabel emp9;
    private javax.swing.JLabel empic;
    private javax.swing.JLabel er1;
    private javax.swing.JLabel er10;
    private javax.swing.JLabel er11;
    private javax.swing.JLabel er12;
    private javax.swing.JLabel er13;
    private javax.swing.JLabel er2;
    private javax.swing.JLabel er3;
    private javax.swing.JLabel er4;
    private javax.swing.JLabel er5;
    private javax.swing.JLabel er6;
    private javax.swing.JLabel er7;
    private javax.swing.JLabel er8;
    private javax.swing.JLabel er9;
    private javax.swing.JTextField f1;
    private javax.swing.JTextField f11;
    private javax.swing.JTextArea f12;
    private javax.swing.JTextField f13;
    private javax.swing.JTextField f2;
    private javax.swing.JTextField f3;
    private javax.swing.JComboBox<String> f4;
    private javax.swing.JTextField f5;
    private javax.swing.JTextField f6;
    private javax.swing.JTextField f7;
    private javax.swing.JComboBox<String> f8;
    private javax.swing.JTextField f9;
    private javax.swing.JTextField hit1;
    private javax.swing.JLabel home_logo;
    private javax.swing.JPanel home_p;
    private javax.swing.JPanel home_panel;
    private javax.swing.JPanel insertion_acc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel117j;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
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
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23w;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27jj;
    private javax.swing.JPanel jPanel28;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField joindatek;
    private javax.swing.JLabel lac1;
    private javax.swing.JLabel lac10;
    private javax.swing.JLabel lac11;
    private javax.swing.JLabel lac12;
    private javax.swing.JLabel lac13;
    private javax.swing.JLabel lac14;
    private javax.swing.JLabel lac15;
    private javax.swing.JLabel lac2;
    private javax.swing.JLabel lac3;
    private javax.swing.JLabel lac4;
    private javax.swing.JLabel lac6;
    private javax.swing.JLabel lac7;
    private javax.swing.JLabel lac8;
    private javax.swing.JLabel lac9;
    private javax.swing.JLabel lacc5;
    private javax.swing.JTextField m10v;
    private javax.swing.JTextField m11i;
    private javax.swing.JTextField m12y;
    private javax.swing.JTextField m13o;
    private javax.swing.JTextField m15t;
    private javax.swing.JTextField m16o;
    private javax.swing.JTextField m17n;
    private javax.swing.JTextField m1j;
    private javax.swing.JTextField m2b;
    private javax.swing.JTextField m3j;
    private javax.swing.JTextField m4p;
    private javax.swing.JTextField m5o;
    private javax.swing.JTextField m6i;
    private javax.swing.JTextField m7t;
    private javax.swing.JTextField m8y;
    private javax.swing.JTextField m9o;
    private javax.swing.JPanel main_profile;
    private javax.swing.JLabel n11v;
    private javax.swing.JLabel n12;
    private javax.swing.JLabel n13lk;
    private javax.swing.JLabel n14v;
    private javax.swing.JLabel n15sk;
    private javax.swing.JLabel n16k;
    private javax.swing.JLabel n17v;
    private javax.swing.JLabel n18v;
    private javax.swing.JLabel n19v;
    private javax.swing.JLabel n20v;
    private javax.swing.JLabel n21ks;
    private javax.swing.JLabel n23;
    private javax.swing.JLabel n24;
    private javax.swing.JLabel n25;
    private javax.swing.JLabel n26;
    private javax.swing.JLabel n27;
    private javax.swing.JLabel n28;
    private javax.swing.JLabel n29o;
    private javax.swing.JLabel n30;
    private javax.swing.JLabel n31;
    private javax.swing.JLabel n32;
    private javax.swing.JLabel n33;
    private javax.swing.JLabel n34;
    private javax.swing.JLabel n35;
    private javax.swing.JLabel n36;
    private javax.swing.JLabel n37;
    private javax.swing.JLabel n38;
    private javax.swing.JLabel n39;
    private javax.swing.JLabel n40;
    private javax.swing.JLabel n41;
    private javax.swing.JLabel n42;
    private javax.swing.JLabel n43;
    private javax.swing.JLabel n44;
    private javax.swing.JLabel n44v;
    private javax.swing.JLabel n45o;
    private javax.swing.JLabel n46;
    private javax.swing.JLabel n47o;
    private javax.swing.JLabel n48;
    private javax.swing.JLabel n49;
    private javax.swing.JLabel n50o;
    private javax.swing.JLabel n51o;
    private javax.swing.JLabel n52;
    private javax.swing.JLabel n53o;
    private javax.swing.JLabel n54;
    private javax.swing.JLabel n56o;
    private javax.swing.JLabel n57;
    private javax.swing.JLabel n58;
    private javax.swing.JLabel n59;
    private javax.swing.JLabel n60;
    private javax.swing.JLabel n61;
    private javax.swing.JLabel n62;
    private javax.swing.JLabel n63;
    private javax.swing.JLabel n64;
    private javax.swing.JLabel n65;
    private javax.swing.JLabel n66;
    private javax.swing.JLabel n67;
    private javax.swing.JLabel n68;
    private javax.swing.JLabel n69h;
    private javax.swing.JPanel newatm;
    private javax.swing.JLabel newerr1;
    private javax.swing.JLabel newerr2;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JPasswordField newpass2;
    private javax.swing.JLabel ok;
    private javax.swing.JLabel ok1;
    private javax.swing.JLabel ok4;
    private javax.swing.JLabel ok5;
    private javax.swing.JLabel olderr;
    private javax.swing.JPasswordField oldpass;
    private javax.swing.JTextField out;
    private javax.swing.JPanel pac1;
    private javax.swing.JPanel pac101;
    private javax.swing.JPanel pac2;
    private javax.swing.JPanel pac5;
    private javax.swing.JPanel pac6;
    private javax.swing.JPanel pac77;
    private javax.swing.JPanel pac8;
    private javax.swing.JPanel pac99;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pics1k;
    private javax.swing.JLabel picsff;
    private javax.swing.JLabel profile;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JTextField rc1;
    private javax.swing.JTextField rc2;
    private javax.swing.JRadioButton rd11;
    private javax.swing.JRadioButton rd32;
    private javax.swing.JRadioButton rd4;
    private javax.swing.JRadioButton rd5;
    private javax.swing.JLabel receiver;
    private javax.swing.JTextField s10sf;
    private javax.swing.JTextField s12af;
    private javax.swing.JTextField s13f;
    private javax.swing.JTextField s15sf;
    private javax.swing.JTextField s16f;
    private javax.swing.JTextField s17df;
    private javax.swing.JTextField s1f;
    private javax.swing.JTextField s2f;
    private javax.swing.JTextField s3f;
    private javax.swing.JTextField s4zf;
    private javax.swing.JTextField s5f;
    private javax.swing.JTextField s6f;
    private javax.swing.JTextField s7f;
    private javax.swing.JTextField s8f;
    private javax.swing.JTextField s9cf;
    private javax.swing.JPanel saving_acc_pnl;
    private javax.swing.JLabel se1;
    private javax.swing.JLabel se2;
    private javax.swing.JTextField search1j;
    private javax.swing.JPanel search_acc;
    private javax.swing.JLabel searcherr;
    private javax.swing.JPanel send_money_pnl;
    private javax.swing.JLabel sender;
    private javax.swing.JLabel sender1;
    private javax.swing.JLabel sender2;
    private javax.swing.JLabel sender3;
    private javax.swing.JTextField serupdate;
    private javax.swing.JLabel slo;
    private javax.swing.JTextField sn1;
    private javax.swing.JTextField sn2;
    private javax.swing.JTextField snd;
    private javax.swing.JTextField snd1;
    private javax.swing.JTextField snd2;
    private javax.swing.JButton sndbtn;
    private javax.swing.JPanel spane;
    private javax.swing.JPanel spane1;
    private javax.swing.JLabel srch1;
    private javax.swing.JLabel srchjsjs;
    private javax.swing.JLabel st10;
    private javax.swing.JLabel st11;
    private javax.swing.JLabel st12;
    private javax.swing.JLabel st13;
    private javax.swing.JLabel st14;
    private javax.swing.JLabel st15;
    private javax.swing.JLabel st16;
    private javax.swing.JLabel st17;
    private javax.swing.JLabel st18;
    private javax.swing.JLabel st2;
    private javax.swing.JLabel st3;
    private javax.swing.JLabel st4;
    private javax.swing.JLabel st5;
    private javax.swing.JLabel st7;
    private javax.swing.JLabel st8;
    private javax.swing.JLabel top_logo0;
    private javax.swing.JLabel top_title;
    private javax.swing.JTextField tr1;
    private javax.swing.JTextField tr2;
    private javax.swing.JTextField u1;
    private javax.swing.JTextArea u12;
    private javax.swing.JTextField u13;
    private javax.swing.JTextField u2;
    private com.toedter.calendar.JDateChooser u3;
    private javax.swing.JComboBox<String> u4;
    private javax.swing.JTextField u5;
    private javax.swing.JTextField u6;
    private javax.swing.JTextField u7;
    private javax.swing.JComboBox<String> u8;
    private javax.swing.JTextField u9;
    private javax.swing.JPanel up_search_acc;
    private javax.swing.JPanel update_acc;
    private javax.swing.JLabel uperror;
    private javax.swing.JLabel upic;
    private javax.swing.JTextField with;
    private javax.swing.JPanel withdraw_money_pnl;
    private javax.swing.JTextField wth1;
    private javax.swing.JTextField wth2;
    // End of variables declaration//GEN-END:variables
}
class rounds extends JPanel{
    protected int strokeSize = 0;
    protected Color shadowColor = Color.black;
    protected boolean shady = false;
    protected boolean highQuality =true;
    protected Dimension arcs;
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 0;
    public rounds(int d) {
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