
import com.itextpdf.text.BaseColor;
import java.sql.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amir Ghafoor
 */

public final class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    int xMouse;
    int yMouse;
    int l=0;
    Timer tm;
    int count;
    String actn="",employee_id;
    File path;
    int employeeid;
    String save_type = null;
    byte[] mg;
    String back_rule=null,back_rule2=null,back_rule3=null;
    int atmvalue = 0,bnkvalue=0;
    int balance=0;
    int snbnc=0,rcbnc=0;
    String like_s =null;
    int action_pnl=0;
    public home() {
        initComponents();
        icon();
        dashborad_update();
        titleicone();
        UIManager.put("ToolTip.background", new Color(240,240,240));
    }
    database_action database=new database_action();
    database_conection conection=new database_conection();
    fetch_data fth=new fetch_data();
    email em=new email();
    fetch_account_data fteh=new fetch_account_data();
    account_database_action act=new account_database_action();
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
    class LebelRenderer implements TableCellRenderer{
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                   return (Component)value;
                }
    }
    void account_data_all(String data,String type){
        fteh.papulate_data(data, type);
               m1j.setText(fteh.getBnk_acc());
               m16o.setText(fteh.getAtm_acc());
               m2b.setText(fteh.getBnk_status());
               m3j.setText(fteh.getName());
               m4p.setText(fteh.getDat());
               m5o.setText(fteh.getFaher());
               m6i.setText(fteh.getCnic());
               m7t.setText(fteh.getMail());
               m10v.setText(fteh.getAcc_type());
               m15t.setText(fteh.getAddress());
               m8y.setText(fteh.getPostal());
               m11i.setText(fteh.getGender());
               m12y.setText(fteh.getContect());
               m14n.setText(fteh.getBalnce());
               m17n.setText(fteh.getTitle());
               m13o.setText(fteh.getAtm_status());
               m9o.setText(fteh.getJoindate());
                atm_date.setText(fteh.getAtm_date());
               ImageIcon mig=new ImageIcon(new ImageIcon(fteh.getImage()).getImage().getScaledInstance(pics1k.getWidth(),pics1k.getHeight(),java.awt.Image.SCALE_SMOOTH));
               pics1k.setIcon(mig); 
    }
    void search_account_data(String data,String type){
        fteh.papulate_data(data, type);
               s1f.setText(fteh.getBnk_acc());
               s13f.setText(fteh.getAtm_acc());
               s2f.setText(fteh.getBnk_status());
               s3f.setText(fteh.getName());
               s4zf.setText(fteh.getDat());
               s5f.setText(fteh.getFaher());
               s6f.setText(fteh.getCnic());
               s7f.setText(fteh.getMail());
               s8f.setText(fteh.getAcc_type());
               s9cf.setText(fteh.getAddress());
               s10sf.setText(fteh.getPostal());
               s15sf.setText(fteh.getGender());
               s12af.setText(fteh.getContect());
               s14cf.setText(fteh.getBalnce());
               s16f.setText(fteh.getTitle());
               s17df.setText(fteh.getAtm_status());
               joindatek.setText(fteh.getJoindate());
               atm_date1.setText(fteh.getAtm_date());
               ImageIcon mg=new ImageIcon(new ImageIcon(fteh.getImage()).getImage().getScaledInstance(picsff.getWidth(),picsff.getHeight(),java.awt.Image.SCALE_SMOOTH));
               picsff.setIcon(mg); 
    }
    void bank_account_datils(String type, String ser, String lik,String st,String end) {
        try {
            Statement pst = conection.conn().createStatement();
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
    void atm_account_datils(String type, String ser, String likee,String st,String end) {
        try {
            Statement pst = conection.conn().createStatement();
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
            Statement pst = conection.conn().createStatement();
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
            tb.setFont(new java.awt.Font("Tahoma", com.itextpdf.text.Font.BOLD, 13));
            byte[] im;
            int i = 1;
            while (rs.next()) {
                String tit = rs.getString("name");
                String accoun_bnk = rs.getString("bnk");
                if (type.equals("deposit")) {
                    hit1.setText("Deposit history");
                    Object[] tbl = {i, rs.getString("se_name"), rs.getString("se_acc"),rs.getString("time"), rs.getString("type"), rs.getString("amount")};
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
    void admin_profile(){
        ImageIcon photo10=new ImageIcon(new ImageIcon(fth.getPic()).getImage().getScaledInstance(profile.getWidth(),profile.getHeight(),java.awt.Image.SCALE_SMOOTH));
        profile.setIcon(photo10);
        ImageIcon photo010=new ImageIcon(new ImageIcon(fth.getPic()).getImage().getScaledInstance(apro.getWidth(),apro.getHeight(),java.awt.Image.SCALE_SMOOTH));
        apro.setIcon(photo010);
    }
    void search_emp_data(String data,String type){
        fth.papulate_data(data, type);
               s1.setText(fth.getId());
               s2.setText(fth.getStatus());
               s3.setText(fth.getName());
               s4.setText(fth.getDat());
               s5.setText(fth.getFaher());
               s6.setText(fth.getCnic());
               s7.setText(fth.getMail());
               s8.setText(fth.getPostal());
               s9.setText(fth.getAddress());
               s10.setText(fth.getMarital());
               s11.setText(fth.getGender());
               s12.setText(fth.getContect());
               s13.setText(fth.getEdu());
               s14.setText(fth.getIncom());
               joindate.setText(fth.getJoiningdate());
               ImageIcon mg=new ImageIcon(new ImageIcon(fth.getImage()).getImage().getScaledInstance(pics.getWidth(),pics.getHeight(),java.awt.Image.SCALE_SMOOTH));
               pics.setIcon(mg); 
    }
    void male_profile_show(String data,String type){
               fth.papulate_data(data, type);
               m1.setText(fth.getId());
               m2.setText(fth.getStatus());
               m3.setText(fth.getName());
               m4.setText(fth.getDat());
               m5.setText(fth.getFaher());
               m6.setText(fth.getCnic());
               m7.setText(fth.getMail());
               m8.setText(fth.getPostal());
               m15.setText(fth.getAddress());
               m10.setText(fth.getMarital());
               m11.setText(fth.getGender());
               m12.setText(fth.getContect());
               m13.setText(fth.getEdu());
               m14.setText(fth.getIncom());
               m9.setText(fth.getJoiningdate());
               ImageIcon mg=new ImageIcon(new ImageIcon(fth.getImage()).getImage().getScaledInstance(pics1.getWidth(),pics1.getHeight(),java.awt.Image.SCALE_SMOOTH));
               pics1.setIcon(mg); 
}
    void search_update_emp_data(String data,String type){
        fth.papulate_data(data, type);
                employee_id=fth.getId();
               u1.setText(fth.getName());
               u2.setText(fth.getFaher());
               u3.setDate(fth.getDob());
               u4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { fth.getMarital(), "Unmarried","Married" }));
               u8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { fth.getGender(), "Male","Female" }));
               u5.setText(fth.getCnic());
               u6.setText(fth.getMail());
               u7.setText(fth.getPostal());
               u12.setText(fth.getAddress());
               u9.setText(fth.getContect());
               u10.setText(fth.getEdu());
               u11.setText(fth.getIncom());
               mg=fth.getImage();
               ImageIcon pho=new ImageIcon(new ImageIcon(mg).getImage().getScaledInstance(upic.getWidth(),upic.getHeight(),java.awt.Image.SCALE_SMOOTH));
               upic.setIcon(pho); 
    }
    void male_employee_details(String ty,String ser,String from,String end){
        try{
        Statement pst=conection.conn().createStatement();
        String quiry=null;
        if(ty.equals("like")){
            quiry="SELECT * FROM employee WHERE name LIKE'%"+ser+"%' AND gender='Male'";
        }
        else if(ty.equals("date")){
            quiry="SELECT * FROM employee WHERE gender='Male' AND joiningdate BETWEEN '"+from+"' AND '"+end+"'";
        }else if(ty.equals("date_s")){
            quiry="SELECT * FROM employee WHERE name LIKE'%"+ser+"%' AND gender='Male' AND joiningdate BETWEEN '"+from+"' AND '"+end+"'";
        }
        else{
          quiry="SELECT * FROM employee WHERE gender='Male'";
        }
        ResultSet rs=pst.executeQuery(quiry);
        male_table.setRowHeight(60);
        
        DefaultTableModel model=(DefaultTableModel) male_table.getModel();
        model.setRowCount(0);
        male_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        male_table.getColumnModel().getColumn(1).setPreferredWidth(103);
        male_table.getColumnModel().getColumn(2).setPreferredWidth(120);
        male_table.getColumnModel().getColumn(3).setPreferredWidth(130);
        male_table.getColumnModel().getColumn(4).setPreferredWidth(130);
        male_table.getColumnModel().getColumn(5).setPreferredWidth(70);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableModel tableModel = male_table.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            male_table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        JTableHeader tb=male_table.getTableHeader();
        tb.setBackground(new Color(153,153,255));
        tb.setFont(new java.awt.Font("Tahoma",Font.BOLD, 13));
        byte[] im;
        int i=1;
        while(rs.next()){
            JLabel lb=new JLabel();
            im=rs.getBytes("image");
            ImageIcon mgi=new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
            lb.setIcon(mgi);
            Object[] tbl={i,rs.getString("id"),rs.getString("name"),"+92"+rs.getString("contect"),rs.getString("cnic"),lb};
            model.addRow(tbl);
            male_table.getColumnModel().getColumn(5).setCellRenderer(new LebelRenderer());
            i=i+1;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    void female_employee_details(String ty,String ser,String from,String end){
        try{
        Statement pst=conection.conn().createStatement();
        String quiry=null;
        if(ty.equals("like")){
            quiry="SELECT * FROM employee WHERE name LIKE'%"+ser+"%' AND gender='Female'";
        }
        else if(ty.equals("date")){
            quiry="SELECT * FROM employee WHERE gender='Female' AND joiningdate BETWEEN '"+from+"' AND '"+end+"'";
        }else if(ty.equals("date_s")){
            quiry="SELECT * FROM employee WHERE name LIKE'%"+ser+"%' AND gender='Female' AND joiningdate BETWEEN '"+from+"' AND '"+end+"'";
        }
        else{
          quiry="SELECT * FROM employee WHERE gender='Female'";
        }
        ResultSet rs=pst.executeQuery(quiry);
        female_table.setRowHeight(60);
        DefaultTableModel model=(DefaultTableModel) female_table.getModel();
        model.setRowCount(0);
        female_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        female_table.getColumnModel().getColumn(1).setPreferredWidth(103);
        female_table.getColumnModel().getColumn(2).setPreferredWidth(120);
        female_table.getColumnModel().getColumn(3).setPreferredWidth(130);
        female_table.getColumnModel().getColumn(4).setPreferredWidth(130);
        female_table.getColumnModel().getColumn(5).setPreferredWidth(70);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableModel tableModel = female_table.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            female_table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        JTableHeader tb=female_table.getTableHeader();
        tb.setBackground(new Color(153,153,255));
        tb.setFont(new java.awt.Font("Tahoma",Font.BOLD, 13));
        byte[] im;
        int i=1;
        while(rs.next()){
            JLabel lb=new JLabel();
            im=rs.getBytes("image");
            ImageIcon mgi=new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
            lb.setIcon(mgi);
            Object[] tbl={i,rs.getString("id"),rs.getString("name"),"+92"+rs.getString("contect"),rs.getString("cnic"),lb};
            model.addRow(tbl);
            female_table.getColumnModel().getColumn(5).setCellRenderer(new LebelRenderer());
            i=i+1;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    void active_employee_details(String tye,String ser){
        try{
        Statement pst=conection.conn().createStatement();
        String quiry=null;
        if ("like".equals(tye)) {
                quiry = "SELECT * FROM employee WHERE name LIKE '%"+ser+"%' AND login_status='online'";
         }else{
             quiry="SELECT * FROM employee WHERE login_status='online'";
        }
        ResultSet rs=pst.executeQuery(quiry);
        active_table.setRowHeight(60);
        DefaultTableModel model=(DefaultTableModel) active_table.getModel();
        model.setRowCount(0);
        active_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        active_table.getColumnModel().getColumn(1).setPreferredWidth(103);
        active_table.getColumnModel().getColumn(2).setPreferredWidth(120);
        active_table.getColumnModel().getColumn(3).setPreferredWidth(130);
        active_table.getColumnModel().getColumn(4).setPreferredWidth(130);
        active_table.getColumnModel().getColumn(5).setPreferredWidth(70);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableModel tableModel =active_table.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            active_table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        JTableHeader tb=active_table.getTableHeader();
        tb.setBackground(new Color(153,153,255));
        tb.setFont(new java.awt.Font("Tahoma",Font.BOLD, 13));
        byte[] im;
        int i=1;
        while(rs.next()){
            JLabel lb=new JLabel();
            im=rs.getBytes("image");
            ImageIcon mgi=new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
            lb.setIcon(mgi);
            Object[] tbl={i,rs.getString("id"),rs.getString("name"),rs.getString("log_time"),rs.getString("cnic"),lb};
            model.addRow(tbl);
            active_table.getColumnModel().getColumn(5).setCellRenderer(new LebelRenderer());
            i=i+1;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    void total_employee_details(String ty,String ser,String from,String end){
        try{
        Statement pst=conection.conn().createStatement();
        String quiry=null;
        if ("like".equals(ty)) {
                quiry = "SELECT * FROM employee WHERE name LIKE '%"+ser+"%'";
        }
        else if(ty.equals("date")){
            quiry="SELECT * FROM employee WHERE joiningdate BETWEEN '"+from+"' AND '"+end+"'";
        }else if(ty.equals("date_s")){
            quiry="SELECT * FROM employee WHERE name LIKE'%"+ser+"%' AND joiningdate BETWEEN '"+from+"' AND '"+end+"'";
        }
        else{
          quiry="SELECT * FROM employee";
        }
        ResultSet rs=pst.executeQuery(quiry);
        all_table.setRowHeight(60);
        
        DefaultTableModel model=(DefaultTableModel) all_table.getModel();
        model.setRowCount(0);
        all_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        all_table.getColumnModel().getColumn(1).setPreferredWidth(103);
        all_table.getColumnModel().getColumn(2).setPreferredWidth(120);
        all_table.getColumnModel().getColumn(3).setPreferredWidth(130);
        all_table.getColumnModel().getColumn(4).setPreferredWidth(130);
        all_table.getColumnModel().getColumn(5).setPreferredWidth(70);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableModel tableModel = all_table.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            all_table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        JTableHeader tb=all_table.getTableHeader();
        tb.setBackground(new Color(153,153,255));
        tb.setFont(new java.awt.Font("Tahoma",Font.BOLD, 13));
        byte[] im;
        int i=1;
        while(rs.next()){
            JLabel lb=new JLabel();
            im=rs.getBytes("image");
            ImageIcon mgi=new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH));
            lb.setIcon(mgi);
            Object[] tbl={i,rs.getString("id"),rs.getString("name"),"+92"+rs.getString("contect"),rs.getString("cnic"),lb};
            model.addRow(tbl);
            all_table.getColumnModel().getColumn(5).setCellRenderer(new LebelRenderer());
            i=i+1;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
    }
     void dashboard(){
             String male_s=act.dashboad_value("SELECT count(id) as total FROM employee WHERE gender='Male'");
            d1_l1.setText(male_s);
            d1_l8.setText(male_s);
            String female_s=act.dashboad_value("SELECT count(id) as total FROM employee WHERE gender='Female'");
            d2_l1.setText(female_s);
            d1_l11.setText(female_s);
            d3_l1.setText(act.dashboad_value("SELECT count(id) as total FROM employee WHERE login_status='online'"));
            d1_l5.setText(act.dashboad_value("SELECT count(id) as total FROM employee"));
            String curr=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Current'");
            d4_l1.setText(curr);
            d1_l14.setText(curr);
            String atm_s=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Block' OR atm_status='Active'");
            d5_l1.setText(atm_s);
            d1_l20.setText(atm_s);
            String sav_acc=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Saving'");
            d6_l1.setText(sav_acc);
            d1_l17.setText(sav_acc);
            String b_balance=act.dashboad_value("SELECT SUM(blnc) as total FROM accounts");
            d7_l1.setText(b_balance+".00");
            d7_l5.setText(b_balance+".00");
            String d_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Deposit'");
            d8_l1.setText(d_balance+".00");
            d8_l5.setText(d_balance+".00");
            String w_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Withdrawal'");
            d9_l1.setText(w_balance+".00");
            d9_l5.setText(w_balance+".00");
        }
    void update_value(){
    try {
            Statement pst = conection.conn().createStatement();
            String qury = "SELECT * FROM strength WHERE id='1'";
            ResultSet rs = pst.executeQuery(qury);
            if(rs.next()){
            atmvalue = rs.getInt("acc_atm");
            bnkvalue = rs.getInt("acc_bank");
            employeeid=rs.getInt("empid");
            }
    }catch(SQLException e){
        System.out.print(e);
    }
}
    void dashboraddat(){
         String male_s=act.dashboad_value("SELECT count(id) as total FROM employee WHERE gender='Male'");
        d1_l1.setText(male_s);
        d1_l8.setText(male_s);
        String female_s=act.dashboad_value("SELECT count(id) as total FROM employee WHERE gender='Female'");
        d2_l1.setText(female_s);
        d1_l11.setText(female_s);
        d3_l1.setText(act.dashboad_value("SELECT count(id) as total FROM employee WHERE login_status='online'"));
        d1_l5.setText(act.dashboad_value("SELECT count(id) as total FROM employee"));
        String curr=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Current'");
        d4_l1.setText(curr);
        d1_l14.setText(curr);
        String atm_s=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE atm_status='Block' OR atm_status='Active'");
        d5_l1.setText(atm_s);
        d1_l20.setText(atm_s);
        String sav_acc=act.dashboad_value("SELECT count(bank_acc) as total FROM accounts WHERE acc_type='Saving'");
        d6_l1.setText(sav_acc);
        d1_l17.setText(sav_acc);
        String b_balance=act.dashboad_value("SELECT SUM(blnc) as total FROM accounts");
        d7_l1.setText(b_balance+".00");
        d7_l5.setText(b_balance+".00");
        String d_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Deposit'");
        d8_l1.setText(d_balance+".00");
        d8_l5.setText(d_balance+".00");
        String w_balance=act.dashboad_value("SELECT SUM(amount) as total FROM history WHERE type='Withdrawal'");
        d9_l1.setText(w_balance+".00");
        d9_l5.setText(w_balance+".00");
        }
    void icon(){
        URL path09 = getClass().getResource("/tag.png");
        ImageIcon phot09 = new ImageIcon(new ImageIcon(path09).getImage().getScaledInstance(bn27.getWidth(), bn27.getHeight(), java.awt.Image.SCALE_SMOOTH));
        bn27.setIcon(phot09);
        bn4.setIcon(phot09);
        bn28.setIcon(phot09);
        URL path=getClass().getResource("/bank.png");
        ImageIcon photoo=new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(home_logo.getWidth(),home_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
        home_logo.setIcon(photoo);
        URL pathh=getClass().getResource("/social_network-512.png");
        ImageIcon photo=new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(cus_logo.getWidth(),cus_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo.setIcon(photo);
        URL path1=getClass().getResource("/acc.png");
        ImageIcon photo1=new ImageIcon(new ImageIcon(path1).getImage().getScaledInstance(cus_logo2.getWidth(),cus_logo2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo2.setIcon(photo1);;
        URL path3=getClass().getResource("/blnc.png");
        ImageIcon photo3=new ImageIcon(new ImageIcon(path3).getImage().getScaledInstance(cus_logo4.getWidth(),cus_logo4.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo4.setIcon(photo3);
        URL path4=getClass().getResource("/pro.png");
        ImageIcon photo4=new ImageIcon(new ImageIcon(path4).getImage().getScaledInstance(cus_logo5.getWidth(),cus_logo5.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo5.setIcon(photo4);
        URL path5=getClass().getResource("/pass.jpg");
        ImageIcon photo5=new ImageIcon(new ImageIcon(path5).getImage().getScaledInstance(cus_logo6.getWidth(),cus_logo6.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo6.setIcon(photo5);
        URL path6=getClass().getResource("/out.png");
        ImageIcon photo6=new ImageIcon(new ImageIcon(path6).getImage().getScaledInstance(cus_logo1.getWidth(),cus_logo1.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo1.setIcon(photo6);
        URL path7=getClass().getResource("/manu.png");
        ImageIcon photo7=new ImageIcon(new ImageIcon(path7).getImage().getScaledInstance(cus_logo7.getWidth(),cus_logo7.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo7.setIcon(photo7);
        URL path8=getClass().getResource("/bank.png");
        ImageIcon photo8=new ImageIcon(new ImageIcon(path8).getImage().getScaledInstance(cus_logo8.getWidth(),cus_logo8.getHeight(),java.awt.Image.SCALE_SMOOTH));
        cus_logo8.setIcon(photo8);
        URL path9=getClass().getResource("/bank.png");
        ImageIcon photo9=new ImageIcon(new ImageIcon(path9).getImage().getScaledInstance(top_logo.getWidth(),top_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
        top_logo.setIcon(photo9);
        URL path011=getClass().getResource("/bck.jpg");
        ImageIcon photo011=new ImageIcon(new ImageIcon(path011).getImage().getScaledInstance(ppro.getWidth(),ppro.getHeight(),java.awt.Image.SCALE_SMOOTH));
        ppro.setIcon(photo011);
        URL path11=getClass().getResource("/pro.png");
        ImageIcon photo11=new ImageIcon(new ImageIcon(path11).getImage().getScaledInstance(emp8.getWidth(),emp8.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp8.setIcon(photo11);
        emp11.setIcon(photo11);
        ImageIcon photo111=new ImageIcon(new ImageIcon(path11).getImage().getScaledInstance(n12.getWidth(),n12.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n12.setIcon(photo111);
        n11.setIcon(photo111);
        n33.setIcon(photo111);
        n45.setIcon(photo111);
        bn5.setIcon(photo111);
        bn32.setIcon(photo111);
        bn39.setIcon(photo111);
        URL path12=getClass().getResource("/s.png");
        ImageIcon photo12=new ImageIcon(new ImageIcon(path12).getImage().getScaledInstance(st8.getWidth(),st8.getHeight(),java.awt.Image.SCALE_SMOOTH));
        st1.setIcon(photo12);
        st2.setIcon(photo12);
        st3.setIcon(photo12);
        st4.setIcon(photo12);
        st5.setIcon(photo12);
        st6.setIcon(photo12);
        st7.setIcon(photo12);
        st8.setIcon(photo12);
        st9.setIcon(photo12);
        st10.setIcon(photo12);
        st11.setIcon(photo12);
        st12.setIcon(photo12);
        st13.setIcon(photo12);
        st14.setIcon(photo12);
        st15.setIcon(photo12);
        st16.setIcon(photo12);
        st17.setIcon(photo12);
        st18.setIcon(photo12);
        URL path13=getClass().getResource("/fe.jpg");
        ImageIcon photo13=new ImageIcon(new ImageIcon(path13).getImage().getScaledInstance(emp4.getWidth(),emp4.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp4.setIcon(photo13);
        emp12.setIcon(photo13);
        URL path14=getClass().getResource("/social_network-512.png");
        ImageIcon photo14=new ImageIcon(new ImageIcon(path14).getImage().getScaledInstance(emp5.getWidth(),emp5.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp5.setIcon(photo14);
        emp10.setIcon(photo14);
        URL path15=getClass().getResource("/bncc.png");
        ImageIcon photo15=new ImageIcon(new ImageIcon(path15).getImage().getScaledInstance(emp9.getWidth(),emp9.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp9.setIcon(photo15);
        emp13.setIcon(photo15);
        URL path16=getClass().getResource("/atm.png");
        ImageIcon photo16=new ImageIcon(new ImageIcon(path16).getImage().getScaledInstance(emp6.getWidth(),emp6.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp6.setIcon(photo16);
        emp15.setIcon(photo16);
        URL path17=getClass().getResource("/depo.png");
        ImageIcon photo17=new ImageIcon(new ImageIcon(path17).getImage().getScaledInstance(emp1.getWidth(),emp1.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp1.setIcon(photo17);
        emp14.setIcon(photo17);
        emp17.setIcon(photo17);
        emp18.setIcon(photo17);
        URL path18=getClass().getResource("/blnc.png");
        ImageIcon photo18=new ImageIcon(new ImageIcon(path18).getImage().getScaledInstance(emp3.getWidth(),emp3.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp3.setIcon(photo18);
        emp1.setIcon(photo18);
        emp16.setIcon(photo18);
        URL path19=getClass().getResource("/depo.png");
        ImageIcon photo19=new ImageIcon(new ImageIcon(path19).getImage().getScaledInstance(emp2.getWidth(),emp2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp2.setIcon(photo19);
        URL path20=getClass().getResource("/depo.png");
        ImageIcon photo20=new ImageIcon(new ImageIcon(path20).getImage().getScaledInstance(emp7.getWidth(),emp7.getHeight(),java.awt.Image.SCALE_SMOOTH));
        emp7.setIcon(photo20);
        URL path21=getClass().getResource("/pro.png");
        ImageIcon photo21=new ImageIcon(new ImageIcon(path21).getImage().getScaledInstance(e1.getWidth(),e1.getHeight(),java.awt.Image.SCALE_SMOOTH));
        e1.setIcon(photo21);
        URL path22=getClass().getResource("/ser.png");
        ImageIcon photo22=new ImageIcon(new ImageIcon(path22).getImage().getScaledInstance(e2.getWidth(),e2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        e2.setIcon(photo22);
        e5.setIcon(photo22);
        URL path23=getClass().getResource("/del.png");
        ImageIcon photo23=new ImageIcon(new ImageIcon(path23).getImage().getScaledInstance(e4.getWidth(),e4.getHeight(),java.awt.Image.SCALE_SMOOTH));
        e4.setIcon(photo23);
        e6.setIcon(photo23);
        ImageIcon photo230=new ImageIcon(new ImageIcon(path23).getImage().getScaledInstance(b4.getWidth(),b4.getHeight(),java.awt.Image.SCALE_SMOOTH));
        b4.setIcon(photo230);
        bn21.setIcon(photo230);
        URL path24=getClass().getResource("/upd.png");
        ImageIcon photo24=new ImageIcon(new ImageIcon(path24).getImage().getScaledInstance(e3.getWidth(),e3.getHeight(),java.awt.Image.SCALE_SMOOTH));
        e3.setIcon(photo24);
        ImageIcon photo240=new ImageIcon(new ImageIcon(path24).getImage().getScaledInstance(b3.getWidth(),b3.getHeight(),java.awt.Image.SCALE_SMOOTH));
        b3.setIcon(photo240);
        URL path25=getClass().getResource("/blck.png");
        ImageIcon photo25=new ImageIcon(new ImageIcon(path25).getImage().getScaledInstance(e8.getWidth(),e8.getHeight(),java.awt.Image.SCALE_SMOOTH));
        e8.setIcon(photo25);
        e9.setIcon(photo25);
        ImageIcon photo250=new ImageIcon(new ImageIcon(path25).getImage().getScaledInstance(b1.getWidth(),b1.getHeight(),java.awt.Image.SCALE_SMOOTH));
        b1.setIcon(photo250);
        bn19.setIcon(photo250);
        URL path26=getClass().getResource("/act.png");
        ImageIcon photo26=new ImageIcon(new ImageIcon(path26).getImage().getScaledInstance(e7.getWidth(),e7.getHeight(),java.awt.Image.SCALE_SMOOTH));
        e7.setIcon(photo26);
        e10.setIcon(photo26);
        URL path27=getClass().getResource("/phone.png");
        ImageIcon photo27=new ImageIcon(new ImageIcon(path27).getImage().getScaledInstance(jLabel14.getWidth(),jLabel14.getHeight(),java.awt.Image.SCALE_SMOOTH));
        jLabel14.setIcon(photo27);
        ImageIcon photo270=new ImageIcon(new ImageIcon(path27).getImage().getScaledInstance(n26.getWidth(),n26.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n26.setIcon(photo270);
        n16.setIcon(photo270);
        n37.setIcon(photo270);
        n49.setIcon(photo270);
        bn14.setIcon(photo270);
        bn43.setIcon(photo270);
        URL path28=getClass().getResource("/idcard.png");
        ImageIcon photo28=new ImageIcon(new ImageIcon(path28).getImage().getScaledInstance(idcon.getWidth(),idcon.getHeight(),java.awt.Image.SCALE_SMOOTH));
        idcon.setIcon(photo28);
        ImageIcon photo280=new ImageIcon(new ImageIcon(path28).getImage().getScaledInstance(n27.getWidth(),n27.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n27.setIcon(photo280);
        n17.setIcon(photo280);
        n38.setIcon(photo280);
        n50.setIcon(photo280);
        bn7.setIcon(photo280);
        bn34.setIcon(photo280);
        bn42.setIcon(photo280);
        URL path29=getClass().getResource("/email.png");
        ImageIcon photo29=new ImageIcon(new ImageIcon(path29).getImage().getScaledInstance(mailicon.getWidth(),mailicon.getHeight(),java.awt.Image.SCALE_SMOOTH));
        mailicon.setIcon(photo29);
        ImageIcon photo290=new ImageIcon(new ImageIcon(path29).getImage().getScaledInstance(n30.getWidth(),n30.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n30.setIcon(photo290);
        n20.setIcon(photo290);
        n41.setIcon(photo290);
        n53.setIcon(photo290);
        bn10.setIcon(photo290);
        bn36.setIcon(photo290);
        URL path30=getClass().getResource("/see.png");
        ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se1.getWidth(),se1.getHeight(),java.awt.Image.SCALE_SMOOTH));
        se1.setIcon(photo30);
        se2.setIcon(photo30);
        URL path31=getClass().getResource("/ok.png");
        ImageIcon photo31=new ImageIcon(new ImageIcon(path31).getImage().getScaledInstance(ok.getWidth(),ok.getHeight(),java.awt.Image.SCALE_SMOOTH));
        ok.setIcon(photo31);
        ok4.setIcon(photo31);
        ImageIcon photo310=new ImageIcon(new ImageIcon(path31).getImage().getScaledInstance(b2.getWidth(),b2.getHeight(),java.awt.Image.SCALE_SMOOTH));
        b2.setIcon(photo310);
        bn20.setIcon(photo310);
        URL path32=getClass().getResource("/reset.png");
        ImageIcon photo32=new ImageIcon(new ImageIcon(path32).getImage().getScaledInstance(ok1.getWidth(),ok1.getHeight(),java.awt.Image.SCALE_SMOOTH));
        ok1.setIcon(photo32);
        ok5.setIcon(photo32);
        URL path33=getClass().getResource("/location.png");
        ImageIcon photo33=new ImageIcon(new ImageIcon(path33).getImage().getScaledInstance(loc.getWidth(),loc.getHeight(),java.awt.Image.SCALE_SMOOTH));
        loc.setIcon(photo33);
        ImageIcon photo330=new ImageIcon(new ImageIcon(path33).getImage().getScaledInstance(n28.getWidth(),n28.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n28.setIcon(photo330);
         n18.setIcon(photo330);
         n39.setIcon(photo330);
         n51.setIcon(photo330);
         bn11.setIcon(photo330);
        bn37.setIcon(photo330);
        bn44.setIcon(photo330);
        URL path34=getClass().getResource("/parent.jpg");
        ImageIcon photo34=new ImageIcon(new ImageIcon(path34).getImage().getScaledInstance(pr.getWidth(),pr.getHeight(),java.awt.Image.SCALE_SMOOTH));
        pr.setIcon(photo34);
        ImageIcon photo340=new ImageIcon(new ImageIcon(path34).getImage().getScaledInstance(n24.getWidth(),n24.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n24.setIcon(photo340);
        n14.setIcon(photo340);
        b6.setIcon(photo340);
        b13.setIcon(photo340);
        b14.setIcon(photo340);
        n35.setIcon(photo340);
        n47.setIcon(photo340);
        bn6.setIcon(photo340);
        bn8.setIcon(photo340);
        bn30.setIcon(photo340);
        bn33.setIcon(photo340);
        bn41.setIcon(photo340);
        URL path35=getClass().getResource("/dob.png");
        ImageIcon photo35=new ImageIcon(new ImageIcon(path35).getImage().getScaledInstance(db.getWidth(),db.getHeight(),java.awt.Image.SCALE_SMOOTH));
        db.setIcon(photo35);
        ImageIcon photo350=new ImageIcon(new ImageIcon(path35).getImage().getScaledInstance(n23.getWidth(),n23.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n23.setIcon(photo350);
        n13.setIcon(photo35);
        n34.setIcon(photo35);
        n44.setIcon(photo35);
        n46.setIcon(photo35);
        n56.setIcon(photo35);
        bn15.setIcon(photo35);
        bn9.setIcon(photo35);
        bn18.setIcon(photo35);
        bn35.setIcon(photo35);
        bn40.setIcon(photo35);
        URL path36=getClass().getResource("/gen.png");
        ImageIcon photo36=new ImageIcon(new ImageIcon(path36).getImage().getScaledInstance(n25.getWidth(),n25.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n25.setIcon(photo36);
        n15.setIcon(photo36);
        n36.setIcon(photo36);
        n48.setIcon(photo36);
        bn13.setIcon(photo36);
        bn38.setIcon(photo36);
        URL path37=getClass().getResource("/back.png");
        ImageIcon photo37=new ImageIcon(new ImageIcon(path37).getImage().getScaledInstance(back.getWidth(),back.getHeight(),java.awt.Image.SCALE_SMOOTH));
        back.setIcon(photo37);
        back1.setIcon(photo37);
        back2.setIcon(photo37);
        back3.setIcon(photo37);
        back4.setIcon(photo37);
        back5.setIcon(photo37);
        back6.setIcon(photo37);
        back7.setIcon(photo37);
        back8.setIcon(photo37);
        back9.setIcon(photo37);
        bn22.setIcon(photo37);
        bn24.setIcon(photo37);
        bn45.setIcon(photo37);
        bn47.setIcon(photo37);
        bn26.setIcon(photo37);
        bn25.setIcon(photo37);
        URL path38=getClass().getResource("/edu.png");
        ImageIcon photo38=new ImageIcon(new ImageIcon(path38).getImage().getScaledInstance(n29.getWidth(),n29.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n29.setIcon(photo38);
        n19.setIcon(photo38);
        n40.setIcon(photo38);
        n52.setIcon(photo38);
        URL path39=getClass().getResource("/postal.jpg");
        ImageIcon photo39=new ImageIcon(new ImageIcon(path39).getImage().getScaledInstance(n21.getWidth(),n21.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n21.setIcon(photo39);
        n31.setIcon(photo39);
        n42.setIcon(photo39);
        n54.setIcon(photo39);
        bn17.setIcon(photo39);
        URL path40=getClass().getResource("/slry.png");
        ImageIcon photo40=new ImageIcon(new ImageIcon(path40).getImage().getScaledInstance(n22.getWidth(),n22.getHeight(),java.awt.Image.SCALE_SMOOTH));
        n22.setIcon(photo40);
        n32.setIcon(photo40);
        n43.setIcon(photo40);
        n55.setIcon(photo40);
        bn16.setIcon(photo40);
        URL path41=getClass().getResource("/srch.png");
        ImageIcon photo41=new ImageIcon(new ImageIcon(path41).getImage().getScaledInstance(srch.getWidth(),srch.getHeight(),java.awt.Image.SCALE_SMOOTH));
        srch.setIcon(photo41);
        srch1.setIcon(photo41);
        bn23.setIcon(photo41);
        URL path42=getClass().getResource("/status.png");
        ImageIcon photo42=new ImageIcon(new ImageIcon(path42).getImage().getScaledInstance(b5.getWidth(),b5.getHeight(),java.awt.Image.SCALE_SMOOTH));
        b5.setIcon(photo42);
        b11.setIcon(photo42);
        bn3.setIcon(photo42);
        bn12.setIcon(photo42);
        bn29.setIcon(photo42);
        URL path43=getClass().getResource("/empid.png");
        ImageIcon photo43=new ImageIcon(new ImageIcon(path43).getImage().getScaledInstance(b7.getWidth(),b7.getHeight(),java.awt.Image.SCALE_SMOOTH));
        b7.setIcon(photo43);
        b15.setIcon(photo43);
        emp.setIcon(photo43);
        bn1.setIcon(photo43);
        bn2.setIcon(photo43);
        bn31.setIcon(photo43);
        top_title.setText("Home");
        home_p.setBackground(new Color(0,153,102));
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
        admin_profile();
        slomo_d();
        slomo();
        if(conection.conn()!=null){
        JLabel messagelabel = new JLabel("<html><body><p style='width: 200px;'>"+"Database Server connected successfully"+"</p></body></html>");
        Timer tmr = new Timer(1000, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messagelabel).dispose();
        });
        tmr.setRepeats(false);
        tmr.start();
        JOptionPane.showOptionDialog(null, messagelabel,"Congratulations", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
        }
        jPanel10.setVisible(false);
        main_profile.setVisible(false);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        search_acc.setVisible(false);
        action_acc.setVisible(false);
        teem.setRepeats(false);
         }
        });
        teem.start();
    }
    void slomo(){
        Thread t = new Thread(new Runnable(){
        public void run(){ 
        String text="Hello, dear Amir Ghafoor !!";
        l=text.length();
        tm=new Timer(400, (ActionEvent arg0) -> {
            count++;
            if(count>l){
                slo.setText("");
                count=0;
            }else{
                slo.setText(text.substring(0,count));
            }
        });
        tm.start();
        }
        });
        t.start();
    }
    void f_reset(){
        er1.setText(null);
            er2.setText(null);
            er3.setText(null);
            er4.setText(null);
            er5.setText(null);
            er6.setText(null);
            er7.setText(null);
            er8.setText(null);
            er9.setText(null);
            er10.setText(null);
            er11.setText(null);
            er12.setText(null);
            er13.setText(null);
            f2.setText(null);
            f3.setText(null);
            dob.setDate(null);
            f4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marital Status", "Unmarried","Married" }));
            f8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male","Female" }));
            f5.setText(null);
            f6.setText(null);
            f7.setText(null);
            f9.setText(null);
            f10.setText(null);
            pic.setIcon(null);
            f11.setText(null);
            f12.setText(null);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cus_logo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        a2 = new javax.swing.JPanel();
        cus_logo2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        a4 = new javax.swing.JPanel();
        cus_logo4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        a6 = new javax.swing.JPanel();
        cus_logo5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        a7 = new javax.swing.JPanel();
        cus_logo6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        home_logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        a1 = new javax.swing.JPanel();
        cus_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        home_p = new javax.swing.JPanel();
        cus_logo8 = new javax.swing.JLabel();
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
        top_logo = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        home_pnl = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        slo = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        d2_1 = new javax.swing.JPanel();
        d2_l2 = new javax.swing.JLabel();
        emp4 = new javax.swing.JLabel();
        d2_l1 = new javax.swing.JLabel();
        d2_2 = new javax.swing.JPanel();
        d2_l3 = new javax.swing.JLabel();
        st4 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        d3_1 = new javax.swing.JPanel();
        d3_l2 = new javax.swing.JLabel();
        emp5 = new javax.swing.JLabel();
        d3_l1 = new javax.swing.JLabel();
        d3_2 = new javax.swing.JPanel();
        d3_l3 = new javax.swing.JLabel();
        st5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        d6_1 = new javax.swing.JPanel();
        d6_l2 = new javax.swing.JLabel();
        emp1 = new javax.swing.JLabel();
        d6_l1 = new javax.swing.JLabel();
        d6_2 = new javax.swing.JPanel();
        d6_l3 = new javax.swing.JLabel();
        st1 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        d5_1 = new javax.swing.JPanel();
        d5_l2 = new javax.swing.JLabel();
        emp6 = new javax.swing.JLabel();
        d5_l1 = new javax.swing.JLabel();
        d5_2 = new javax.swing.JPanel();
        d5_l3 = new javax.swing.JLabel();
        st6 = new javax.swing.JLabel();
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
        emp8 = new javax.swing.JLabel();
        d1_l1 = new javax.swing.JLabel();
        d1_2 = new javax.swing.JPanel();
        d1_l3 = new javax.swing.JLabel();
        st8 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        d4_1 = new javax.swing.JPanel();
        d4_l2 = new javax.swing.JLabel();
        emp9 = new javax.swing.JLabel();
        d4_l1 = new javax.swing.JLabel();
        d4_2 = new javax.swing.JPanel();
        d4_l3 = new javax.swing.JLabel();
        st9 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        jPanel6 = new round(30);
        ac5 = new round(30);
        lac5 = new javax.swing.JLabel();
        e5 = new javax.swing.JLabel();
        ac6 = new round(30);
        lac6 = new javax.swing.JLabel();
        e6 = new javax.swing.JLabel();
        ac9 = new round(30);
        lac9 = new javax.swing.JLabel();
        e9 = new javax.swing.JLabel();
        ac10 = new round(30);
        lac10 = new javax.swing.JLabel();
        e10 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        d1_9 = new javax.swing.JPanel();
        d1_l13 = new javax.swing.JLabel();
        emp13 = new javax.swing.JLabel();
        d1_l14 = new javax.swing.JLabel();
        d1_10 = new javax.swing.JPanel();
        d1_l15 = new javax.swing.JLabel();
        st13 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        d1_11 = new javax.swing.JPanel();
        d1_l16 = new javax.swing.JLabel();
        emp14 = new javax.swing.JLabel();
        d1_l17 = new javax.swing.JLabel();
        d1_12 = new javax.swing.JPanel();
        d1_l18 = new javax.swing.JLabel();
        st14 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        d1_13 = new javax.swing.JPanel();
        d1_l19 = new javax.swing.JLabel();
        emp15 = new javax.swing.JLabel();
        d1_l20 = new javax.swing.JLabel();
        d1_14 = new javax.swing.JPanel();
        d1_l21 = new javax.swing.JLabel();
        st15 = new javax.swing.JLabel();
        p4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        d7_3 = new javax.swing.JPanel();
        d7_l4 = new javax.swing.JLabel();
        emp16 = new javax.swing.JLabel();
        d7_l5 = new javax.swing.JLabel();
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
        p5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        apro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ppro = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        idcon = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        mailicon = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        loc = new javax.swing.JLabel();
        pr = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        db = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        p6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        newpass2 = new javax.swing.JPasswordField();
        oldpass = new javax.swing.JPasswordField();
        newpass1 = new javax.swing.JPasswordField();
        se1 = new javax.swing.JLabel();
        se2 = new javax.swing.JLabel();
        pac2 = new round(30);
        ok = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pac1 = new round(30);
        ok1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        olderr = new javax.swing.JLabel();
        newerr2 = new javax.swing.JLabel();
        newerr1 = new javax.swing.JLabel();
        p1 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        d1_3 = new javax.swing.JPanel();
        d1_l4 = new javax.swing.JLabel();
        emp10 = new javax.swing.JLabel();
        d1_l5 = new javax.swing.JLabel();
        d1_4 = new javax.swing.JPanel();
        d1_l6 = new javax.swing.JLabel();
        st10 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        d1_5 = new javax.swing.JPanel();
        d1_l7 = new javax.swing.JLabel();
        emp11 = new javax.swing.JLabel();
        d1_l8 = new javax.swing.JLabel();
        d1_6 = new javax.swing.JPanel();
        d1_l9 = new javax.swing.JLabel();
        st11 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        d1_7 = new javax.swing.JPanel();
        d1_l10 = new javax.swing.JLabel();
        emp12 = new javax.swing.JLabel();
        d1_l11 = new javax.swing.JLabel();
        d1_8 = new javax.swing.JPanel();
        d1_l12 = new javax.swing.JLabel();
        st12 = new javax.swing.JLabel();
        jPanel3 = new round(20);
        ac1 = new round(30);
        lac1 = new javax.swing.JLabel();
        e1 = new javax.swing.JLabel();
        ac2 = new round(30);
        lac2 = new javax.swing.JLabel();
        e2 = new javax.swing.JLabel();
        ac3 = new round(30);
        lac3 = new javax.swing.JLabel();
        e3 = new javax.swing.JLabel();
        ac4 = new round(30);
        lac4 = new javax.swing.JLabel();
        e4 = new javax.swing.JLabel();
        ac7 = new round(30);
        lac7 = new javax.swing.JLabel();
        e7 = new javax.swing.JLabel();
        ac8 = new round(30);
        lac8 = new javax.swing.JLabel();
        e8 = new javax.swing.JLabel();
        entry = new javax.swing.JPanel();
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
        f10 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        n29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        f12 = new javax.swing.JTextArea();
        jLabel79 = new javax.swing.JLabel();
        n30 = new javax.swing.JLabel();
        f9 = new javax.swing.JTextField();
        f11 = new javax.swing.JTextField();
        f7 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        n31 = new javax.swing.JLabel();
        n32 = new javax.swing.JLabel();
        b13 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        f8 = new javax.swing.JComboBox<>();
        f2 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        pac5 = new round(30);
        ok4 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        pac6 = new round(30);
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
        er11 = new javax.swing.JLabel();
        er12 = new javax.swing.JLabel();
        er13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        f1 = new javax.swing.JTextField();
        emp = new javax.swing.JLabel();
        entry2 = new javax.swing.JPanel();
        aspane = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        s2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        n11 = new javax.swing.JLabel();
        n13 = new javax.swing.JLabel();
        n14 = new javax.swing.JLabel();
        pics = new javax.swing.JLabel();
        n15 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        n16 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        s5 = new javax.swing.JTextField();
        n17 = new javax.swing.JLabel();
        s6 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        n18 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        s7 = new javax.swing.JTextField();
        s13 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        n19 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        n20 = new javax.swing.JLabel();
        s12 = new javax.swing.JTextField();
        s14 = new javax.swing.JTextField();
        s8 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        n21 = new javax.swing.JLabel();
        n22 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        b5 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        b6 = new javax.swing.JLabel();
        b7 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        s9 = new javax.swing.JTextField();
        s1 = new javax.swing.JTextField();
        s3 = new javax.swing.JTextField();
        s4 = new javax.swing.JTextField();
        s10 = new javax.swing.JTextField();
        s11 = new javax.swing.JTextField();
        joindate = new javax.swing.JTextField();
        n44 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        back1 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        pac10 = new round(30);
        b1 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        pac9 = new round(30);
        b2 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        pac7 = new round(30);
        b4 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        search = new javax.swing.JPanel();
        spane = new javax.swing.JPanel();
        search1 = new javax.swing.JTextField();
        jPanel27 = new round(30);
        srch = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        rd3 = new javax.swing.JRadioButton();
        rd1 = new javax.swing.JRadioButton();
        rd2 = new javax.swing.JRadioButton();
        searcherr = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        back2 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        updatepane = new javax.swing.JPanel();
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
        u10 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        n40 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        u12 = new javax.swing.JTextArea();
        jLabel94 = new javax.swing.JLabel();
        n41 = new javax.swing.JLabel();
        u9 = new javax.swing.JTextField();
        u11 = new javax.swing.JTextField();
        u7 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        n42 = new javax.swing.JLabel();
        n43 = new javax.swing.JLabel();
        b14 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        u8 = new javax.swing.JComboBox<>();
        u1 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        pac8 = new round(30);
        b3 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        back3 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        up_search = new javax.swing.JPanel();
        spane1 = new javax.swing.JPanel();
        serupdate = new javax.swing.JTextField();
        jPanel29 = new round(30);
        srch1 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        rd4 = new javax.swing.JRadioButton();
        rd5 = new javax.swing.JRadioButton();
        rd6 = new javax.swing.JRadioButton();
        uperror = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        back4 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        total_emplyee = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        all_table = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        back9 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        female_emp = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        female_table = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        back8 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jDateChooser12 = new com.toedter.calendar.JDateChooser();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        male_emp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        male_table = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        back7 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        male_profile_panel = new javax.swing.JPanel();
        aspane3 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        m2 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        n45 = new javax.swing.JLabel();
        n46 = new javax.swing.JLabel();
        n47 = new javax.swing.JLabel();
        pics1 = new javax.swing.JLabel();
        n48 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        n49 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        m5 = new javax.swing.JTextField();
        n50 = new javax.swing.JLabel();
        m6 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        n51 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        m7 = new javax.swing.JTextField();
        m13 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        n52 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        n53 = new javax.swing.JLabel();
        m12 = new javax.swing.JTextField();
        m14 = new javax.swing.JTextField();
        m8 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        n54 = new javax.swing.JLabel();
        n55 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        b11 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        b12 = new javax.swing.JLabel();
        b15 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        m15 = new javax.swing.JTextField();
        m1 = new javax.swing.JTextField();
        m3 = new javax.swing.JTextField();
        m4 = new javax.swing.JTextField();
        m10 = new javax.swing.JTextField();
        m11 = new javax.swing.JTextField();
        m9 = new javax.swing.JTextField();
        n56 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        back5 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        active_emp = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        back6 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel190 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        active_table = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        bn47 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane8 = new javax.swing.JScrollPane();
        bnc_history = new javax.swing.JTable();
        jLabel156 = new javax.swing.JLabel();
        hit1 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        main_profile = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        bn45 = new javax.swing.JLabel();
        jLabel117j = new javax.swing.JLabel();
        aspane6 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        m2b = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        bn32 = new javax.swing.JLabel();
        bn39 = new javax.swing.JLabel();
        bn33 = new javax.swing.JLabel();
        pics1k = new javax.swing.JLabel();
        bn40 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        bn41 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        m5o = new javax.swing.JTextField();
        bn34 = new javax.swing.JLabel();
        m6i = new javax.swing.JTextField();
        jLabel177 = new javax.swing.JLabel();
        bn37 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        m7t = new javax.swing.JTextField();
        m13o = new javax.swing.JTextField();
        jLabel179 = new javax.swing.JLabel();
        bn38 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        bn36 = new javax.swing.JLabel();
        m12y = new javax.swing.JTextField();
        m14n = new javax.swing.JTextField();
        m8y = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        bn43 = new javax.swing.JLabel();
        bn42 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        bn29 = new javax.swing.JLabel();
        bn30 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        m15t = new javax.swing.JTextField();
        m3j = new javax.swing.JTextField();
        m4p = new javax.swing.JTextField();
        m10v = new javax.swing.JTextField();
        m11i = new javax.swing.JTextField();
        m9o = new javax.swing.JTextField();
        bn35 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        bn31 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        m16o = new javax.swing.JTextField();
        bn28 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        m17n = new javax.swing.JTextField();
        m1j = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        bn27 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        bn44 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        atm_date = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        accounts_pnl = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        bn26 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accounts_table = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel167 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton12 = new javax.swing.JButton();
        atm_table_pnl = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        bn25 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        atm_table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel169 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel171 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        search_acc = new javax.swing.JPanel();
        spane2 = new javax.swing.JPanel();
        search1j = new javax.swing.JTextField();
        jPanel27jj = new round(30);
        bn23 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        rd32 = new javax.swing.JRadioButton();
        rd11 = new javax.swing.JRadioButton();
        searcherr1 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        bn24 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        action_acc = new javax.swing.JPanel();
        jPanel23w = new javax.swing.JPanel();
        bn22 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        aspane5 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        s2f = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        bn5 = new javax.swing.JLabel();
        bn15 = new javax.swing.JLabel();
        bn6 = new javax.swing.JLabel();
        picsff = new javax.swing.JLabel();
        bn13 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        bn14 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        s5f = new javax.swing.JTextField();
        bn7 = new javax.swing.JLabel();
        s6f = new javax.swing.JTextField();
        bn11 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        s7f = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        bn10 = new javax.swing.JLabel();
        s12af = new javax.swing.JTextField();
        s14cf = new javax.swing.JTextField();
        s8f = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        bn17 = new javax.swing.JLabel();
        bn16 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        bn3 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        bn8 = new javax.swing.JLabel();
        bn1 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        s9cf = new javax.swing.JTextField();
        s1f = new javax.swing.JTextField();
        s3f = new javax.swing.JTextField();
        s4zf = new javax.swing.JTextField();
        s10sf = new javax.swing.JTextField();
        joindatek = new javax.swing.JTextField();
        bn9 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        bn2 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        s13f = new javax.swing.JTextField();
        s15sf = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        s16f = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        bn4 = new javax.swing.JLabel();
        s17df = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        bn12 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        bn18 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        atm_date1 = new javax.swing.JTextField();
        pac77 = new round(30);
        bn21 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        pac99 = new round(30);
        bn20 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        pac101 = new round(30);
        bn19 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));
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
        jPanel5.add(cus_logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 8, 35, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Log Out");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 90, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 485, 220, 40));

        a2.setBackground(new java.awt.Color(102, 153, 255));
        a2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a2MouseExited(evt);
            }
        });
        a2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a2.add(cus_logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 8, 35, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Accounts Queries");
        a2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));

        jPanel1.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 285, 220, 40));

        a4.setBackground(new java.awt.Color(102, 153, 255));
        a4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a4MouseExited(evt);
            }
        });
        a4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a4.add(cus_logo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 5, 35, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Balance Record");
        a4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));

        jPanel1.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 335, 220, 40));

        a6.setBackground(new java.awt.Color(102, 153, 255));
        a6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a6MouseExited(evt);
            }
        });
        a6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a6.add(cus_logo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 5, 35, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Account Profile");
        a6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));

        jPanel1.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, 220, 40));

        a7.setBackground(new java.awt.Color(102, 153, 255));
        a7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a7MouseExited(evt);
            }
        });
        a7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a7.add(cus_logo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 5, 35, 25));

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
                mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a1MouseExited(evt);
            }
        });
        a1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        a1.add(cus_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 8, 35, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Employee Queries");
        a1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 140, 30));

        jPanel1.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 220, 40));

        home_p.setBackground(new java.awt.Color(102, 153, 255));
        home_p.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        home_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_pMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_pMouseExited(evt);
            }
        });
        home_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        home_p.add(cus_logo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, 35, 25));

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
        jPanel11.add(top_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 7, 35, 25));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        jPanel21.setLayout(new java.awt.CardLayout());

        home_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        home_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Welcome to Dashboard", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slo.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        slo.setForeground(new java.awt.Color(102, 0, 102));
        slo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(slo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 410, 30));

        profile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 11, 55, 45));

        home_pnl.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 490, 60));

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d2_1.setBackground(new java.awt.Color(102, 102, 255));
        d2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d2_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d2_l2.setForeground(new java.awt.Color(255, 255, 255));
        d2_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d2_l2.setText("Female Employees");
        d2_l2.setMinimumSize(null);
        d2_1.add(d2_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));
        d2_1.add(emp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d2_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d2_l1.setForeground(new java.awt.Color(255, 255, 255));
        d2_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d2_l1.setText("0");
        d2_1.add(d2_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 155, 40));

        jPanel22.add(d2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d2_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d2_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d2_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d2_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d2_l3.setText("View Details");
        d2_2.add(d2_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d2_2.add(st4, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel22.add(d2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 100, 200, 120));

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d3_1.setBackground(new java.awt.Color(102, 102, 255));
        d3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d3_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d3_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d3_l2.setForeground(new java.awt.Color(255, 255, 255));
        d3_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d3_l2.setText("Active Employees");
        d3_l2.setMinimumSize(null);
        d3_1.add(d3_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d3_1.add(emp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d3_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d3_l1.setForeground(new java.awt.Color(255, 255, 255));
        d3_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d3_l1.setText("0");
        d3_1.add(d3_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 155, 40));

        jPanel25.add(d3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d3_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d3_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d3_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d3_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d3_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d3_l3.setText("View Details");
        d3_2.add(d3_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 110, 20));
        d3_2.add(st5, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel25.add(d3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 100, 200, 120));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d6_1.setBackground(new java.awt.Color(102, 102, 255));
        d6_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d6_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d6_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d6_l2.setForeground(new java.awt.Color(255, 255, 255));
        d6_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d6_l2.setText("Saving Accounts");
        d6_l2.setMinimumSize(null);
        d6_1.add(d6_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d6_1.add(emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d6_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d6_l1.setForeground(new java.awt.Color(255, 255, 255));
        d6_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d6_l1.setText("0");
        d6_1.add(d6_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 155, 40));

        jPanel8.add(d6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d6_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d6_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d6_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d6_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d6_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d6_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d6_l3.setText("View Details");
        d6_2.add(d6_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 110, 20));
        d6_2.add(st1, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel8.add(d6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 230, 200, 120));

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d5_1.setBackground(new java.awt.Color(102, 102, 255));
        d5_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d5_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d5_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d5_l2.setForeground(new java.awt.Color(255, 255, 255));
        d5_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d5_l2.setText("ATM Accounts");
        d5_l2.setMinimumSize(null);
        d5_1.add(d5_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d5_1.add(emp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d5_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d5_l1.setForeground(new java.awt.Color(255, 255, 255));
        d5_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d5_l1.setText("0");
        d5_1.add(d5_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 155, 40));

        jPanel28.add(d5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d5_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d5_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d5_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d5_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d5_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d5_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d5_l3.setText("View Details");
        d5_2.add(d5_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d5_2.add(st6, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel28.add(d5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 230, 200, 120));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_1.setBackground(new java.awt.Color(102, 102, 255));
        d9_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d9_l2.setForeground(new java.awt.Color(255, 255, 255));
        d9_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d9_l2.setText("Withdraw Balance");
        d9_l2.setMinimumSize(null);
        d9_1.add(d9_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));
        d9_1.add(emp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d9_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d9_l1.setForeground(new java.awt.Color(255, 255, 255));
        d9_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d9_l1.setText("0.00");
        d9_1.add(d9_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 10, 155, 40));

        jPanel31.add(d9_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d9_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d9_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d9_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d9_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d9_l3.setText("View Details");
        d9_2.add(d9_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 110, 20));
        d9_2.add(st7, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel31.add(d9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 360, 200, 120));

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_1.setBackground(new java.awt.Color(102, 102, 255));
        d8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d8_l2.setForeground(new java.awt.Color(255, 255, 255));
        d8_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d8_l2.setText("Deposite Balance");
        d8_l2.setMinimumSize(null);
        d8_1.add(d8_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d8_1.add(emp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d8_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d8_l1.setForeground(new java.awt.Color(255, 255, 255));
        d8_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d8_l1.setText("0.00");
        d8_1.add(d8_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 10, 155, 40));

        jPanel14.add(d8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d8_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d8_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d8_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d8_l3.setText("View Details");
        d8_2.add(d8_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d8_2.add(st2, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel14.add(d8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 360, 200, 120));

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_1.setBackground(new java.awt.Color(102, 102, 255));
        d7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d7_l2.setForeground(new java.awt.Color(255, 255, 255));
        d7_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d7_l2.setText("Bank Balance");
        d7_l2.setMinimumSize(null);
        d7_1.add(d7_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d7_1.add(emp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d7_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d7_l1.setForeground(new java.awt.Color(255, 255, 255));
        d7_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d7_l1.setText("0.00");
        d7_1.add(d7_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 10, 155, 40));

        jPanel17.add(d7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d7_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d7_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d7_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d7_l3.setText("View Details");
        d7_2.add(d7_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 130, 20));
        d7_2.add(st3, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel17.add(d7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 360, 200, 120));

        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_1.setBackground(new java.awt.Color(102, 102, 255));
        d1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d1_l2.setForeground(new java.awt.Color(255, 255, 255));
        d1_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l2.setText("Male Employees");
        d1_l2.setMinimumSize(null);
        d1_1.add(d1_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d1_1.add(emp8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d1_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l1.setForeground(new java.awt.Color(255, 255, 255));
        d1_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l1.setText("0");
        d1_1.add(d1_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 155, 40));

        jPanel34.add(d1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d1_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l3.setText("View Details");
        d1_2.add(d1_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_2.add(st8, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel34.add(d1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 100, 200, 120));

        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d4_1.setBackground(new java.awt.Color(102, 102, 255));
        d4_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d4_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d4_l2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d4_l2.setForeground(new java.awt.Color(255, 255, 255));
        d4_l2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d4_l2.setText("Current Accounts");
        d4_l2.setMinimumSize(null);
        d4_1.add(d4_l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));
        d4_1.add(emp9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 40));

        d4_l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d4_l1.setForeground(new java.awt.Color(255, 255, 255));
        d4_l1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d4_l1.setText("0");
        d4_1.add(d4_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 155, 40));

        jPanel37.add(d4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d4_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d4_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d4_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d4_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash_h(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash_e(evt);
            }
        });
        d4_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d4_l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d4_l3.setText("View Details");
        d4_2.add(d4_l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d4_2.add(st9, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel37.add(d4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        home_pnl.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 230, 200, 120));

        jPanel21.add(home_pnl, "card2");

        p2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ac5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_accounts(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                an_mexit(evt);
            }
        });
        ac5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac5.setText("Search");
        ac5.add(lac5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac5.add(e5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(ac5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 36));

        ac6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_accounts(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                an_mexit(evt);
            }
        });
        ac6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac6.setText("Delete");
        ac6.add(lac6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac6.add(e6, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(ac6, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 20, 110, 36));

        ac9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_accounts(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                an_mexit(evt);
            }
        });
        ac9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac9.setText("Block");
        ac9.add(lac9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac9.add(e9, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(ac9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 110, 36));

        ac10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_accounts(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                an_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                an_mexit(evt);
            }
        });
        ac10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac10.setText("Activate");
        ac10.add(lac10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac10.add(e10, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 30, 25));

        jPanel6.add(ac10, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 20, 110, 36));

        p2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 530, 75));

        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_9.setBackground(new java.awt.Color(102, 102, 255));
        d1_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l13.setForeground(new java.awt.Color(255, 255, 255));
        d1_l13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l13.setText("Current Accounts");
        d1_9.add(d1_l13, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));
        d1_9.add(emp13, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 12, 50, 40));

        d1_l14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        d1_l14.setForeground(new java.awt.Color(255, 255, 255));
        d1_l14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l14.setText("0");
        d1_9.add(d1_l14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));

        jPanel39.add(d1_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                and_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                and_mexit(evt);
            }
        });
        d1_10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l15.setText("View Details");
        d1_10.add(d1_l15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_10.add(st13, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel39.add(d1_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        p2.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 110, 200, 120));

        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_11.setBackground(new java.awt.Color(102, 102, 255));
        d1_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l16.setForeground(new java.awt.Color(255, 255, 255));
        d1_l16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l16.setText("Saving Accounts");
        d1_11.add(d1_l16, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d1_11.add(emp14, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 12, 50, 40));

        d1_l17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        d1_l17.setForeground(new java.awt.Color(255, 255, 255));
        d1_l17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l17.setText("0");
        d1_11.add(d1_l17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));

        jPanel40.add(d1_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                and_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                and_mexit(evt);
            }
        });
        d1_12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l18.setText("View Details");
        d1_12.add(d1_l18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_12.add(st14, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel40.add(d1_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        p2.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 200, 120));

        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_13.setBackground(new java.awt.Color(102, 102, 255));
        d1_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l19.setForeground(new java.awt.Color(255, 255, 255));
        d1_l19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l19.setText("ATM Accounts");
        d1_13.add(d1_l19, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));
        d1_13.add(emp15, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 12, 50, 40));

        d1_l20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        d1_l20.setForeground(new java.awt.Color(255, 255, 255));
        d1_l20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l20.setText("0");
        d1_13.add(d1_l20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));

        jPanel41.add(d1_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                and_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                and_mexit(evt);
            }
        });
        d1_14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l21.setText("View Details");
        d1_14.add(d1_l21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_14.add(st15, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel41.add(d1_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        p2.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 200, 120));

        jPanel21.add(p2, "card3");

        p4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        p4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_3.setBackground(new java.awt.Color(102, 102, 255));
        d7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d7_l4.setForeground(new java.awt.Color(255, 255, 255));
        d7_l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d7_l4.setText("Bank Balance");
        d7_3.add(d7_l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 180, 30));
        d7_3.add(emp16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 50, 40));

        d7_l5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d7_l5.setForeground(new java.awt.Color(255, 255, 255));
        d7_l5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d7_l5.setText("0.00 PKR");
        d7_3.add(d7_l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 70, 193, 30));

        jPanel18.add(d7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 152));

        d7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d7_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d7_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_mexit(evt);
            }
        });
        d7_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d7_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d7_l6.setText("View Details");
        d7_4.add(d7_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 130, 40));
        d7_4.add(st16, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 18, 22, 15));

        jPanel18.add(d7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        p4.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 130, 200, 200));

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_3.setBackground(new java.awt.Color(102, 102, 255));
        d8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d8_l4.setForeground(new java.awt.Color(255, 255, 255));
        d8_l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d8_l4.setText("Deposite Balance");
        d8_3.add(d8_l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 180, 30));
        d8_3.add(emp17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 50, 40));

        d8_l5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d8_l5.setForeground(new java.awt.Color(255, 255, 255));
        d8_l5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d8_l5.setText("0.00 PKR");
        d8_3.add(d8_l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 70, 193, 30));

        jPanel15.add(d8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 152));

        d8_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d8_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d8_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d8_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_mexit(evt);
            }
        });
        d8_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d8_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d8_l6.setText("View Details");
        d8_4.add(d8_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 40));
        d8_4.add(st17, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 18, 22, 15));

        jPanel15.add(d8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        p4.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 130, 200, 200));

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_3.setBackground(new java.awt.Color(102, 102, 255));
        d9_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d9_l4.setForeground(new java.awt.Color(255, 255, 255));
        d9_l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d9_l4.setText("Withdraw Balance");
        d9_3.add(d9_l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 180, 30));
        d9_3.add(emp18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 50, 40));

        d9_l5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d9_l5.setForeground(new java.awt.Color(255, 255, 255));
        d9_l5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d9_l5.setText("0.00 PKR");
        d9_3.add(d9_l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 70, 193, 30));

        jPanel32.add(d9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 152));

        d9_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d9_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d9_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d9_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_mexit(evt);
            }
        });
        d9_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d9_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d9_l6.setText("View Details");
        d9_4.add(d9_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 110, 40));
        d9_4.add(st18, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 18, 22, 15));

        jPanel32.add(d9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        p4.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 130, 200, 200));

        jPanel21.add(p4, "card5");

        p5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Profile", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        p5.setForeground(new java.awt.Color(0, 0, 153));
        p5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(apro, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 110, 80, 80));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Amir Ghafoor");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 330, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("(Admin)");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 225, 330, -1));

        ppro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(ppro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 150));
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 321, 25, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("+923051738594");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 313, 120, 35));
        jPanel7.add(idcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 319, 25, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("12345-1234567-8");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 315, 120, 30));
        jPanel7.add(mailicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 358, 25, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("amirghafoorcss@gmail.com");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 353, 285, 30));

        jLabel17.setForeground(new java.awt.Color(0, 0, 204));
        jLabel17.setText("Change Profile image");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 235, 130, 30));
        jPanel7.add(loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 397, 25, 20));
        jPanel7.add(pr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 283, 25, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Abdul Ghafoor");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 120, 30));
        jPanel7.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 286, 25, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("00-00-0000");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 120, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Lahore, Pakistan");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 393, 280, 30));

        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 258, 344, 180));

        p5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 350, 440));

        jPanel21.add(p5, "card6");

        p6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Password", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        p6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                pac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac_mexit(evt);
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
                pac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pac_mexit(evt);
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

        p6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 400, 260));

        jPanel21.add(p6, "card7");

        p1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_3.setBackground(new java.awt.Color(102, 102, 255));
        d1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d1_l4.setForeground(new java.awt.Color(255, 255, 255));
        d1_l4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l4.setText("Total Employees");
        d1_3.add(d1_l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d1_3.add(emp10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 12, 50, 40));

        d1_l5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l5.setForeground(new java.awt.Color(255, 255, 255));
        d1_l5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l5.setText("0");
        d1_3.add(d1_l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));

        jPanel35.add(d1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emp_mexit(evt);
            }
        });
        d1_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l6.setText("View Details");
        d1_4.add(d1_l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_4.add(st10, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel35.add(d1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        p1.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 110, 200, 120));

        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_5.setBackground(new java.awt.Color(102, 102, 255));
        d1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d1_l7.setForeground(new java.awt.Color(255, 255, 255));
        d1_l7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l7.setText("Male Employees");
        d1_5.add(d1_l7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 60, 120, 30));
        d1_5.add(emp11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 12, 50, 40));

        d1_l8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l8.setForeground(new java.awt.Color(255, 255, 255));
        d1_l8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l8.setText("0");
        d1_5.add(d1_l8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));

        jPanel36.add(d1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emp_mexit(evt);
            }
        });
        d1_6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l9.setText("View Details");
        d1_6.add(d1_l9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_6.add(st11, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel36.add(d1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        p1.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 200, 120));

        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_7.setBackground(new java.awt.Color(102, 102, 255));
        d1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        d1_l10.setForeground(new java.awt.Color(255, 255, 255));
        d1_l10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l10.setText("Female Employees");
        d1_7.add(d1_l10, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 60, 130, 30));
        d1_7.add(emp12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 12, 50, 40));

        d1_l11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d1_l11.setForeground(new java.awt.Color(255, 255, 255));
        d1_l11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        d1_l11.setText("0");
        d1_7.add(d1_l11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, 40));

        jPanel38.add(d1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 92));

        d1_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1_8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emp_mexit(evt);
            }
        });
        d1_8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d1_l12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d1_l12.setText("View Details");
        d1_8.add(d1_l12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 120, 20));
        d1_8.add(st12, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 8, 22, 15));

        jPanel38.add(d1_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 30));

        p1.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 200, 120));

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ac1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac_mexit(evt);
            }
        });
        ac1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac1.setText("Add new");
        ac1.add(lac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac1.add(e1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 30, 25));

        jPanel3.add(ac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 110, 36));

        ac2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_emp(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac_mexit(evt);
            }
        });
        ac2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac2.setText("Search");
        ac2.add(lac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac2.add(e2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 6, 30, 25));

        jPanel3.add(ac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 110, 36));

        ac3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ac3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac_mexit(evt);
            }
        });
        ac3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac3.setText("Update");
        ac3.add(lac3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac3.add(e3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 6, 30, 25));

        jPanel3.add(ac3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 110, 36));

        ac4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_emp(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ac_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ac_mexit(evt);
            }
        });
        ac4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lac4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lac4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lac4.setText("Delete ");
        ac4.add(lac4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac4.add(e4, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 6, 30, 25));

        jPanel3.add(ac4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 85, 110, 36));

        ac7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_emp(evt);
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
        lac7.setText("Activate");
        ac7.add(lac7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac7.add(e7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 6, 30, 25));

        jPanel3.add(ac7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 85, 110, 36));

        ac8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ac8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_emp(evt);
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
        lac8.setText("Block");
        ac8.add(lac8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 80, 25));
        ac8.add(e8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 30, 25));

        jPanel3.add(ac8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 85, 110, 36));

        p1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 440, 140));

        jPanel21.add(p1, "card8");

        entry.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "New Employee", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        entry.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        aspane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Entry Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane1.setFocusCycleRoot(true);
        aspane1.setFocusTraversalPolicyProvider(true);
        aspane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel69.setText("Employee Name");
        aspane1.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel70.setText("Father Name");
        aspane1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, 25));

        jTextField22.setEditable(false);
        jTextField22.setText("+92");
        aspane1.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 30, 25));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel71.setText("CNIC");
        aspane1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 80, 25));

        dob.setAutoscrolls(true);
        dob.setFocusCycleRoot(true);
        dob.setFocusTraversalPolicyProvider(true);
        dob.setInheritsPopupMenu(true);
        aspane1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 25));
        aspane1.add(n12, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 30, 25, 20));
        aspane1.add(n23, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 110, 25, 20));
        aspane1.add(n24, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 70, 25, 20));

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
        aspane1.add(n25, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 150, 25, 20));

        f4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        f4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marital Status", "Married", "Unmarried" }));
        f4.setBorder(null);
        f4.setLightWeightPopupEnabled(false);
        f4.setOpaque(false);
        f4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel74.setText("Contect");
        aspane1.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 50, 25));
        aspane1.add(n26, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 190, 25, 20));

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel75.setText("DateOfBirth");
        aspane1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 25));

        f3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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
        aspane1.add(n27, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 190, 25, 20));

        f5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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
        aspane1.add(f5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 25));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel76.setText("Marital");
        aspane1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 60, 25));
        aspane1.add(n28, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 312, 25, 20));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel77.setText("Email");
        aspane1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 80, 25));

        f6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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
        aspane1.add(f6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 25));

        f10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
            }
        });
        f10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f10KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f10KeyTyped(evt);
            }
        });
        aspane1.add(f10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 130, 25));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel78.setText("Postal Code");
        aspane1.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 25));
        aspane1.add(n29, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 230, 25, 20));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        f12.setColumns(20);
        f12.setRows(5);
        f12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
            }
        });
        f12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f12KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(f12);

        aspane1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 380, 30));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel79.setText("Address");
        aspane1.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 60, 30));
        aspane1.add(n30, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 230, 25, 20));

        f9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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
        aspane1.add(f9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 100, 25));

        f11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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
                entry_error(evt);
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
        aspane1.add(f7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 25));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel84.setText("Education");
        aspane1.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 60, 25));

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel85.setText("Income");
        aspane1.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 60, 25));
        aspane1.add(n31, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 270, 25, 20));
        aspane1.add(n32, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 270, 25, 20));
        aspane1.add(b13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 150, 25, 20));

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel88.setText("Gender");
        aspane1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 50, 25));

        f8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        f8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));
        f8.setBorder(null);
        f8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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
        aspane1.add(f8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 130, 25));

        f2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entry_error(evt);
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
                en_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                en_mexit(evt);
            }
        });
        pac5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac5.add(ok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 25, 20));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Submit");
        pac5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        aspane1.add(pac5, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 355, 85, -1));

        pac6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                en_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                en_mexit(evt);
            }
        });
        pac6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac6.add(ok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 25, 20));

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
        aspane1.add(er5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 215, 140, 15));

        er6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er6.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 255, 140, 15));

        er7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er7.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 295, 140, 15));

        er8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er8.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 140, 15));

        er9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er9.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 175, 130, 15));

        er10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er10.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 215, 130, 15));

        er11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er11.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 255, 130, 15));

        er12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er12.setForeground(new java.awt.Color(204, 0, 0));
        aspane1.add(er12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 295, 130, 15));

        er13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        er13.setForeground(new java.awt.Color(204, 0, 0));
        er13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aspane1.add(er13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 133, 110, 15));

        entry.add(aspane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 75, 560, 400));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Employee I'd");
        entry.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 90, 30));

        f1.setEditable(false);
        f1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        f1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        f1.setText("emp0047");
        f1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        entry.add(f1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 80, 30));
        entry.add(emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 42, 25, 25));

        jPanel21.add(entry, "card8");

        entry2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ".", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N
        entry2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                red_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                red_mexit(evt);
            }
        });
        entry2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aspane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Data Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("Employee Name");
        aspane.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 25));

        s2.setEditable(false);
        aspane.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 65, 140, 25));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Father Name");
        aspane.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 80, 25));

        jTextField11.setEditable(false);
        jTextField11.setText("+92");
        aspane.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 30, 25));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("CNIC");
        aspane.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 80, 25));
        aspane.add(n11, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 100, 25, 20));
        aspane.add(n13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 140, 25, 20));
        aspane.add(n14, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 180, 25, 20));

        pics.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane.add(pics, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 90, 90));
        aspane.add(n15, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 180, 25, 20));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("Contect");
        aspane.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 50, 25));
        aspane.add(n16, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 220, 25, 20));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("DateOfBirth");
        aspane.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 80, 25));

        s5.setEditable(false);
        aspane.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, 25));
        aspane.add(n17, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 220, 25, 20));

        s6.setEditable(false);
        aspane.add(s6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, 25));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setText("Marital");
        aspane.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 60, 25));
        aspane.add(n18, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 380, 25, 20));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setText("Email");
        aspane.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 80, 25));

        s7.setEditable(false);
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });
        aspane.add(s7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 380, 25));

        s13.setEditable(false);
        aspane.add(s13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 130, 25));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setText("Postal Code");
        aspane.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 90, 25));
        aspane.add(n19, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 260, 25, 20));

        jLabel55.setText("Address");
        aspane.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 60, 25));
        aspane.add(n20, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 340, 25, 20));

        s12.setEditable(false);
        aspane.add(s12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 100, 25));

        s14.setEditable(false);
        aspane.add(s14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 130, 25));

        s8.setEditable(false);
        aspane.add(s8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 140, 25));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setText("Education");
        aspane.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 60, 25));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel62.setText("Income");
        aspane.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 60, 25));
        aspane.add(n21, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 260, 25, 20));
        aspane.add(n22, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 300, 25, 20));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel63.setText("Account Status");
        aspane.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 65, 90, 25));
        aspane.add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 65, 25, 20));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel64.setText("Employee Id");
        aspane.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));
        aspane.add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 140, 25, 20));
        aspane.add(b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 30, 25, 20));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel67.setText("Gender");
        aspane.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 50, 25));

        s9.setEditable(false);
        aspane.add(s9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 380, 25));

        s1.setEditable(false);
        aspane.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 140, 25));

        s3.setEditable(false);
        aspane.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, 25));

        s4.setEditable(false);
        s4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                s4MouseEntered(evt);
            }
        });
        aspane.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 25));

        s10.setEditable(false);
        aspane.add(s10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 130, 25));

        s11.setEditable(false);
        aspane.add(s11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 130, 25));

        joindate.setEditable(false);
        joindate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                joindateMouseEntered(evt);
            }
        });
        aspane.add(joindate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 140, 25));
        aspane.add(n44, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 300, 25, 20));

        jLabel72.setText("Date Of Joining");
        aspane.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 90, 25));
        jLabel72.getAccessibleContext().setAccessibleName("DateOf joining");

        entry2.add(aspane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 560, 415));

        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel23MouseExited(evt);
            }
        });
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel23.add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Back");
        jPanel23.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        entry2.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        pac10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                red_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                red_mexit(evt);
            }
        });
        pac10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac10.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 5, 25, 20));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Block");
        pac10.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        entry2.add(pac10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 85, -1));

        pac9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                blu_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                blu_mexit(evt);
            }
        });
        pac9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac9.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 5, 25, 20));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("Unblock");
        pac9.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        entry2.add(pac9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 85, -1));

        pac7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pac7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                red_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                red_mexit(evt);
            }
        });
        pac7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac7.add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 5, 25, 20));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("Delete");
        pac7.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        entry2.add(pac7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 85, -1));

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton16.setText("Save Profile");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        entry2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 100, 30));

        jPanel21.add(entry2, "card9");

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Searching", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        spane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search1FocusGained(evt);
            }
        });
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search1KeyTyped(evt);
            }
        });
        spane.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 290, 30));

        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel27MouseExited(evt);
            }
        });
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 25, 20));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Search");
        jPanel27.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, 53, 35));

        spane.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 155, 100, 35));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Employee data");
        spane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 30));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("Search by");
        spane.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 30));

        rd3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd3.setText("Employee Id");
        rd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redio_action(evt);
            }
        });
        spane.add(rd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        rd1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd1.setSelected(true);
        rd1.setText("CNIC");
        rd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redio_action(evt);
            }
        });
        spane.add(rd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 80, -1));

        rd2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd2.setText("Email");
        rd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redio_action(evt);
            }
        });
        spane.add(rd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 80, -1));

        searcherr.setForeground(new java.awt.Color(204, 0, 0));
        spane.add(searcherr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 290, 20));

        search.add(spane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 530, 200));

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

        back2.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel24.add(back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setText("Back");
        jPanel24.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        search.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(search, "card10");

        updatepane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Update Record", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        updatepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aspane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Entry Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel80.setText("Employee Name");
        aspane2.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel81.setText("Father Name");
        aspane2.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, 25));

        jTextField31.setEditable(false);
        jTextField31.setText("+92");
        aspane2.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 30, 25));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel82.setText("CNIC");
        aspane2.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 80, 25));
        aspane2.add(u3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 25));
        aspane2.add(n33, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 30, 25, 20));
        aspane2.add(n34, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 110, 25, 20));
        aspane2.add(n35, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 70, 25, 20));

        upic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane2.add(upic, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 80, 80));

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 153));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Update Image");
        jLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel86MouseClicked(evt);
            }
        });
        aspane2.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 80, 30));
        aspane2.add(n36, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 150, 25, 20));

        u4.setEditable(true);
        u4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        u4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status", "Married", "Unmarried" }));
        u4.setBorder(null);
        u4.setLightWeightPopupEnabled(false);
        u4.setOpaque(false);
        aspane2.add(u4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 25));

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel87.setText("Contect");
        aspane2.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 50, 25));
        aspane2.add(n37, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 190, 25, 20));

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel90.setText("DateOfBirth");
        aspane2.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 25));
        aspane2.add(u2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 25));
        aspane2.add(n38, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 190, 25, 20));

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
        jLabel91.setText("Marital");
        aspane2.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 60, 25));
        aspane2.add(n39, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 312, 25, 20));

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
        aspane2.add(u10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 130, 25));

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel93.setText("Postal Code");
        aspane2.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 25));
        aspane2.add(n40, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 230, 25, 20));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        u12.setColumns(20);
        u12.setRows(5);
        jScrollPane4.setViewportView(u12);

        aspane2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 380, 30));

        jLabel94.setText("Address");
        aspane2.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 60, 30));
        aspane2.add(n41, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 230, 25, 20));

        u9.setText("3051738594");
        u9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                u9KeyTyped(evt);
            }
        });
        aspane2.add(u9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 100, 25));

        u11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                u11KeyTyped(evt);
            }
        });
        aspane2.add(u11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 130, 25));

        u7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                u7KeyTyped(evt);
            }
        });
        aspane2.add(u7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 25));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel95.setText("Education");
        aspane2.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 60, 25));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel96.setText("Income");
        aspane2.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 60, 25));
        aspane2.add(n42, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 270, 25, 20));
        aspane2.add(n43, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 270, 25, 20));
        aspane2.add(b14, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 150, 25, 20));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel97.setText("Gender");
        aspane2.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 50, 25));

        u8.setEditable(true);
        u8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        u8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female", "Other" }));
        u8.setBorder(null);
        u8.setFocusable(false);
        aspane2.add(u8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 130, 25));
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
                blu_menter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                blu_mexit(evt);
            }
        });
        pac8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pac8.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 5, 25, 20));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Update");
        pac8.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        aspane2.add(pac8, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 360, 85, 30));

        updatepane.add(aspane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 560, 400));

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

        updatepane.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(updatepane, "card11");

        up_search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Update", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        up_search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel29.add(srch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 8, 25, 20));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Search");
        jPanel29.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, 53, 35));

        spane1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 100, 35));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Employee data");
        spane1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 30));

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setText("Search by");
        spane1.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 80, 25));

        rd4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd4.setText("Employee Id");
        rd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_action(evt);
            }
        });
        spane1.add(rd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        rd5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd5.setSelected(true);
        rd5.setText("CNIC");
        rd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_action(evt);
            }
        });
        spane1.add(rd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 80, -1));

        rd6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd6.setText("Email");
        rd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_action(evt);
            }
        });
        spane1.add(rd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 80, -1));

        uperror.setForeground(new java.awt.Color(204, 0, 0));
        spane1.add(uperror, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 290, 15));

        up_search.add(spane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 530, 190));

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

        up_search.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(up_search, "card12");

        total_emplyee.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Employees Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        total_emplyee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        all_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Employee I'd", "Name", "Contect", "CNIC", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        all_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_tableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(all_table);

        total_emplyee.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 635, 390));

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

        total_emplyee.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField6MouseEntered(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        total_emplyee.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 140, 20));

        jLabel191.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel191.setText("Date To");
        total_emplyee.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 60, 20));

        jButton4.setText("Save PDF file");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        total_emplyee.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 465, 110, -1));

        jDateChooser9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDateChooser9MouseEntered(evt);
            }
        });
        jDateChooser9.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser9PropertyChange(evt);
            }
        });
        total_emplyee.add(jDateChooser9, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 40, 110, -1));

        jDateChooser10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDateChooser10MouseEntered(evt);
            }
        });
        jDateChooser10.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser10PropertyChange(evt);
            }
        });
        total_emplyee.add(jDateChooser10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 110, -1));

        jLabel192.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel192.setText("Search by Name");
        total_emplyee.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, 20));

        jLabel193.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel193.setText("From Date");
        total_emplyee.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 60, 20));

        jButton14.setText("Refresh");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        total_emplyee.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 465, 100, -1));

        jPanel21.add(total_emplyee, "card13");

        female_emp.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Female Emplyees", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        female_emp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        female_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Employee I'd", "Name", "Contect", "CNIC", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        female_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                female_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(female_table);

        female_emp.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 70, 635, 390));

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

        female_emp.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });
        female_emp.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Date To");
        female_emp.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 70, 20));

        jButton1.setText("Save PDF file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        female_emp.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 467, 110, -1));

        jDateChooser11.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser11PropertyChange(evt);
            }
        });
        female_emp.add(jDateChooser11, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 40, 120, 20));

        jDateChooser12.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser12PropertyChange(evt);
            }
        });
        female_emp.add(jDateChooser12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 120, 20));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Search by Name");
        female_emp.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 20));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("From Date");
        female_emp.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 70, 20));

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton15.setText("Refresh");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        female_emp.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 467, 90, -1));

        jPanel21.add(female_emp, "card14");

        male_emp.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Male Emplyees", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        male_emp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        male_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Employee I'd", "Name", "Contect", "CNIC", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        male_table.setShowGrid(true);
        male_table.getTableHeader().setReorderingAllowed(false);
        male_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                male_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(male_table);

        male_emp.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 70, 635, 390));

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

        male_emp.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        male_emp.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 130, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("From Date");
        male_emp.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 65, 20));

        jButton6.setText("Save PDF file");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        male_emp.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 467, 110, 25));

        jDateChooser7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser7PropertyChange(evt);
            }
        });
        male_emp.add(jDateChooser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 40, 120, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Search by Name");
        male_emp.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, 20));

        jDateChooser8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser8PropertyChange(evt);
            }
        });
        male_emp.add(jDateChooser8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 120, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Date To");
        male_emp.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 60, 20));

        jButton10.setText("Refresh");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        male_emp.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 467, 100, 25));

        jPanel21.add(male_emp, "card15");

        male_profile_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Employee Profile", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        male_profile_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aspane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Data Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Employee Name");
        aspane3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 25));

        m2.setEditable(false);
        aspane3.add(m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 65, 140, 25));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setText("Father Name");
        aspane3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 80, 25));

        jTextField12.setEditable(false);
        jTextField12.setText("+92");
        aspane3.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 30, 25));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setText("CNIC");
        aspane3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 80, 25));
        aspane3.add(n45, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 100, 25, 20));
        aspane3.add(n46, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 140, 25, 20));
        aspane3.add(n47, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 180, 25, 20));

        pics1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane3.add(pics1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 90, 90));
        aspane3.add(n48, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 180, 25, 20));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel83.setText("Contect");
        aspane3.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 50, 25));
        aspane3.add(n49, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 220, 25, 20));

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel103.setText("DateOfBirth");
        aspane3.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 80, 25));

        m5.setEditable(false);
        aspane3.add(m5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, 25));
        aspane3.add(n50, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 220, 25, 20));

        m6.setEditable(false);
        aspane3.add(m6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, 25));

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel104.setText("Marital");
        aspane3.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 60, 25));
        aspane3.add(n51, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 380, 25, 20));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel105.setText("Email");
        aspane3.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 80, 25));

        m7.setEditable(false);
        aspane3.add(m7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 380, 25));

        m13.setEditable(false);
        aspane3.add(m13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 130, 25));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel106.setText("Postal Code");
        aspane3.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 90, 25));
        aspane3.add(n52, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 260, 25, 20));

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel107.setText("Address");
        aspane3.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 70, 25));
        aspane3.add(n53, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 340, 25, 20));

        m12.setEditable(false);
        m12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m12ActionPerformed(evt);
            }
        });
        aspane3.add(m12, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 220, 97, 25));

        m14.setEditable(false);
        aspane3.add(m14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 130, 25));

        m8.setEditable(false);
        aspane3.add(m8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 140, 25));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel111.setText("Education");
        aspane3.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 60, 25));

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel112.setText("Income");
        aspane3.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 60, 25));
        aspane3.add(n54, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 260, 25, 20));
        aspane3.add(n55, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 300, 25, 20));

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel113.setText("Account Status");
        aspane3.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 65, 90, 25));
        aspane3.add(b11, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 65, 25, 20));

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel114.setText("Employee Id");
        aspane3.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));
        aspane3.add(b12, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 140, 25, 20));
        aspane3.add(b15, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 30, 25, 20));

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel115.setText("Gender");
        aspane3.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 50, 25));

        m15.setEditable(false);
        aspane3.add(m15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 380, 25));

        m1.setEditable(false);
        aspane3.add(m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 140, 25));

        m3.setEditable(false);
        aspane3.add(m3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, 25));

        m4.setEditable(false);
        m4.setText("18-02-2000 |dd/MM/yyyy");
        m4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m4MouseEntered(evt);
            }
        });
        aspane3.add(m4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 25));

        m10.setEditable(false);
        aspane3.add(m10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 130, 25));

        m11.setEditable(false);
        aspane3.add(m11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 130, 25));

        m9.setEditable(false);
        m9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m9MouseEntered(evt);
            }
        });
        aspane3.add(m9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 140, 25));
        aspane3.add(n56, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 300, 25, 20));

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel116.setText("Date Of Joining");
        aspane3.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 90, 25));

        male_profile_panel.add(aspane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 560, 415));

        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back5.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel19.add(back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117.setText("Back");
        jPanel19.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        male_profile_panel.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton17.setText("Save Profile");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        male_profile_panel.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 465, 110, -1));

        jPanel21.add(male_profile_panel, "card17");

        active_emp.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Active Employees Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        active_emp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        active_emp.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        active_emp.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 150, 22));

        jLabel190.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel190.setText("Search by Name");
        active_emp.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 30, 100, 22));

        active_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Employee I'd", "Name", "Login Time", "CNIC", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        active_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                active_tableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(active_table);

        active_emp.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 630, 400));

        jButton7.setText("Save PDF file");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        active_emp.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 467, 110, -1));

        jPanel21.add(active_emp, "card16");

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Balance Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel45MouseClicked(evt);
            }
        });
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bn47.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel45.add(bn47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel136.setText("Back");
        jPanel45.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        jPanel10.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jLabel159.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel159.setText("Search by Name");
        jPanel10.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 95, 22));

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
        jPanel10.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 45, 150, 22));

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        jPanel10.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 45, 125, 22));

        jLabel162.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel162.setText("From Date");
        jPanel10.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 45, 60, 22));

        jLabel163.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel163.setText("To Date");
        jPanel10.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 45, -1, 22));

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        jPanel10.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 45, 120, 22));

        bnc_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Account No", "Time & Date", "History Type", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bnc_history.setShowGrid(false);
        jScrollPane8.setViewportView(bnc_history);

        jPanel10.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 630, 380));

        jLabel156.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel156.setText("History type");
        jPanel10.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 462, 80, 30));

        hit1.setEditable(false);
        jPanel10.add(hit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 462, 160, 30));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton11.setText("Refresh");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 462, 90, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Save as PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 462, 110, 30));

        jPanel21.add(jPanel10, "card18");

        main_profile.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Account Profile", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        main_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel46MouseClicked(evt);
            }
        });
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bn45.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel46.add(bn45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel117j.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117j.setText("Back");
        jPanel46.add(jLabel117j, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        main_profile.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        aspane6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Profile Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel172.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel172.setText("Name");
        aspane6.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 90, 25));

        m2b.setEditable(false);
        aspane6.add(m2b, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 105, 165, 25));

        jLabel173.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel173.setText("Father Name");
        aspane6.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 245, 90, 25));

        jTextField16.setEditable(false);
        jTextField16.setText("+92");
        aspane6.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 245, 30, 25));

        jLabel174.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel174.setText("CNIC");
        aspane6.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 90, 25));
        aspane6.add(bn32, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 210, 25, 20));
        aspane6.add(bn39, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 175, 25, 20));
        aspane6.add(bn33, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 245, 25, 20));

        pics1k.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane6.add(pics1k, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 30, 100, 100));
        aspane6.add(bn40, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 210, 25, 20));

        jLabel175.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel175.setText("Contect");
        aspane6.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 245, 75, 25));
        aspane6.add(bn41, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 245, 25, 20));

        jLabel176.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel176.setText("DateOfBirth");
        aspane6.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 175, 75, 25));

        m5o.setEditable(false);
        aspane6.add(m5o, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 245, 165, 25));
        aspane6.add(bn34, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 280, 25, 20));

        m6i.setEditable(false);
        aspane6.add(m6i, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 280, 165, 25));

        jLabel177.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel177.setText("Account type");
        aspane6.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 90, 25));
        aspane6.add(bn37, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 385, 25, 20));

        jLabel178.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel178.setText("Email");
        aspane6.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 90, 25));

        m7t.setEditable(false);
        aspane6.add(m7t, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 350, 165, 25));

        m13o.setEditable(false);
        aspane6.add(m13o, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 140, 130, 25));

        jLabel179.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel179.setText("Postal Code");
        aspane6.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 315, 75, 25));
        aspane6.add(bn38, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 140, 25, 20));

        jLabel180.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel180.setText("Address");
        aspane6.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 385, 90, 25));
        aspane6.add(bn36, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 350, 25, 20));

        m12y.setEditable(false);
        aspane6.add(m12y, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 245, 98, 25));

        m14n.setEditable(false);
        aspane6.add(m14n, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 280, 98, 25));

        m8y.setEditable(false);
        aspane6.add(m8y, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 315, 130, 25));

        jLabel181.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel181.setText("ATM Status");
        aspane6.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 75, 25));

        jLabel182.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel182.setText("Balance");
        aspane6.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 75, 25));
        aspane6.add(bn43, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 315, 25, 20));
        aspane6.add(bn42, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 280, 25, 20));

        jLabel183.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel183.setText("Account Status");
        aspane6.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 105, 90, 25));
        aspane6.add(bn29, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 105, 25, 20));
        aspane6.add(bn30, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, 25, 20));

        jLabel184.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel184.setText("Gender");
        aspane6.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 75, 25));

        m15t.setEditable(false);
        aspane6.add(m15t, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 385, 420, 25));

        m3j.setEditable(false);
        aspane6.add(m3j, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 210, 165, 25));

        m4p.setEditable(false);
        m4p.setText("18-02-2000 |dd/MM/yyyy");
        m4p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m4pMouseEntered(evt);
            }
        });
        aspane6.add(m4p, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 175, 130, 25));

        m10v.setEditable(false);
        aspane6.add(m10v, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 140, 165, 25));

        m11i.setEditable(false);
        aspane6.add(m11i, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 210, 130, 25));

        m9o.setEditable(false);
        m9o.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m9oMouseEntered(evt);
            }
        });
        aspane6.add(m9o, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 315, 165, 25));
        aspane6.add(bn35, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 315, 25, 20));

        jLabel187.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel187.setText("Register Date");
        aspane6.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 315, 90, 25));
        aspane6.add(bn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 175, 25, 20));

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel134.setText("ATM Account");
        aspane6.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 175, 90, 25));

        m16o.setEditable(false);
        aspane6.add(m16o, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 175, 165, 25));
        aspane6.add(bn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, 25, 20));

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel135.setText("Account Title");
        aspane6.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 90, 25));

        m17n.setEditable(false);
        aspane6.add(m17n, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 70, 165, 25));

        m1j.setEditable(false);
        aspane6.add(m1j, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 30, 165, 25));

        jLabel188.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel188.setText("Account No");
        aspane6.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));
        aspane6.add(bn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 25, 20));

        jTextField17.setEditable(false);
        jTextField17.setText("PKR");
        aspane6.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 280, 30, 25));
        aspane6.add(bn44, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 350, 25, 20));

        jLabel189.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel189.setText("ATM Register");
        aspane6.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 75, 25));

        atm_date.setEditable(false);
        atm_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atm_dateMouseEntered(evt);
            }
        });
        aspane6.add(atm_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 350, 130, 25));

        main_profile.add(aspane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 600, 420));

        jButton8.setText("Save Profile ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        main_profile.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 120, 30));

        jPanel21.add(main_profile, "card17");

        accounts_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Accounts Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        accounts_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel47MouseClicked(evt);
            }
        });
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bn26.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel47.add(bn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel137.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel137.setText("Back");
        jPanel47.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        accounts_pnl.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

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
        accounts_table.setShowGrid(false);
        accounts_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accounts_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accounts_table);

        accounts_pnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 75, 635, 380));

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

        jButton3.setText("Save as PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        accounts_pnl.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 462, 110, 30));

        jLabel165.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel165.setText("Search by Name");
        accounts_pnl.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 95, 22));

        jLabel166.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel166.setText("From Date");
        accounts_pnl.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 45, 60, 22));

        jDateChooser3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser3PropertyChange(evt);
            }
        });
        accounts_pnl.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 45, 125, 22));

        jLabel167.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel167.setText("To Date");
        accounts_pnl.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 45, -1, 22));

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

        atm_table_pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ATM Accounts Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        atm_table_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel48MouseClicked(evt);
            }
        });
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bn25.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel48.add(bn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel138.setText("Back");
        jPanel48.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        atm_table_pnl.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

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
        atm_table.setShowGrid(false);
        atm_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atm_tableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(atm_table);

        atm_table_pnl.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 75, 635, 380));

        jButton5.setText("Save as PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        atm_table_pnl.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 462, 110, 30));

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField2MouseEntered(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        atm_table_pnl.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 45, 140, 20));

        jLabel168.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel168.setText("Search by Name");
        atm_table_pnl.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 100, 20));

        jDateChooser5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser5PropertyChange(evt);
            }
        });
        atm_table_pnl.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 45, 125, 20));

        jLabel169.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel169.setText("From Date");
        atm_table_pnl.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 45, 60, 20));

        jDateChooser6.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser6PropertyChange(evt);
            }
        });
        atm_table_pnl.add(jDateChooser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 45, 120, 20));

        jLabel171.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel171.setText("To Date");
        atm_table_pnl.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 45, -1, 20));

        jButton13.setText("Refresh");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        atm_table_pnl.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 462, 90, 30));

        jPanel21.add(atm_table_pnl, "card14");

        search_acc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Searching", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        search_acc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N
        spane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        spane2.add(search1j, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 290, 30));

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
        jPanel27jj.add(bn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 4, 30, 25));

        jLabel139.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel139.setText("Search");
        jPanel27jj.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, 53, 35));

        spane2.add(jPanel27jj, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 155, 100, 35));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Account Data");
        spane2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 30));

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel140.setText("Search by");
        spane2.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 30));

        rd32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd32.setText("Account number");
        rd32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rd32MouseEntered(evt);
            }
        });
        rd32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd32redio_action(evt);
            }
        });
        spane2.add(rd32, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        rd11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd11.setSelected(true);
        rd11.setText("CNIC");
        rd11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rd11MouseEntered(evt);
            }
        });
        rd11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd11redio_action(evt);
            }
        });
        spane2.add(rd11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 80, -1));

        searcherr1.setForeground(new java.awt.Color(204, 0, 0));
        spane2.add(searcherr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 290, 20));

        search_acc.add(spane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 530, 200));

        jPanel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel49MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel49MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel49MouseExited(evt);
            }
        });
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bn24.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel49.add(bn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel141.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel141.setText("Back");
        jPanel49.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        search_acc.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        jPanel21.add(search_acc, "card10");

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

        bn22.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel23w.add(bn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 27, 18));

        jLabel185.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel185.setText("Back");
        jPanel23w.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 18));

        action_acc.add(jPanel23w, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 70, 20));

        aspane5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Profile Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        aspane5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel142.setText("Name");
        aspane5.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 168, 90, 25));

        s2f.setEditable(false);
        aspane5.add(s2f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 100, 165, 25));

        jLabel143.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel143.setText("Father Name");
        aspane5.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 204, 90, 25));

        jTextField14.setEditable(false);
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("+92");
        aspane5.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 205, 32, 25));

        jLabel144.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel144.setText("CNIC");
        aspane5.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 90, 25));
        aspane5.add(bn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 168, 25, 20));
        aspane5.add(bn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 240, 25, 20));
        aspane5.add(bn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 204, 25, 20));

        picsff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aspane5.add(picsff, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 30, 100, 95));
        aspane5.add(bn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 170, 25, 20));

        jLabel145.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel145.setText("Contect");
        aspane5.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 205, 75, 25));
        aspane5.add(bn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 205, 25, 20));

        jLabel146.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel146.setText("DateOfBirth");
        aspane5.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 75, 25));

        s5f.setEditable(false);
        aspane5.add(s5f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 204, 165, 25));
        aspane5.add(bn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 240, 25, 20));

        s6f.setEditable(false);
        aspane5.add(s6f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 240, 165, 25));
        aspane5.add(bn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 380, 25, 20));

        jLabel147.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel147.setText("Email");
        aspane5.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 345, 90, 25));

        s7f.setEditable(false);
        aspane5.add(s7f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 345, 165, 25));

        jLabel148.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel148.setText("Account type");
        aspane5.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 275, 90, 25));

        jLabel149.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel149.setText("Address");
        aspane5.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 90, 25));
        aspane5.add(bn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 345, 25, 20));

        s12af.setEditable(false);
        aspane5.add(s12af, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 205, 96, 25));

        s14cf.setEditable(false);
        aspane5.add(s14cf, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 275, 98, 25));

        s8f.setEditable(false);
        aspane5.add(s8f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 275, 165, 25));

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel150.setText("Balance");
        aspane5.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 275, 75, 25));
        aspane5.add(bn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 310, 25, 20));
        aspane5.add(bn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 275, 25, 20));

        jLabel151.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel151.setText("Account Status");
        aspane5.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 25));
        aspane5.add(bn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 100, 25, 20));

        jLabel152.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel152.setText("Account No");
        aspane5.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 25));
        aspane5.add(bn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 275, 25, 20));
        aspane5.add(bn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 30, 25, 20));

        jLabel153.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel153.setText("Gender");
        aspane5.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 75, 25));

        s9cf.setEditable(false);
        aspane5.add(s9cf, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 380, 420, 25));

        s1f.setEditable(false);
        aspane5.add(s1f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 30, 165, 25));

        s3f.setEditable(false);
        aspane5.add(s3f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 168, 165, 25));

        s4zf.setEditable(false);
        s4zf.setText("18-02-2000 |dd/MM/y");
        s4zf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                s4zfMouseEntered(evt);
            }
        });
        aspane5.add(s4zf, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 240, 130, 25));

        s10sf.setEditable(false);
        aspane5.add(s10sf, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 310, 130, 25));

        joindatek.setEditable(false);
        joindatek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                joindatekMouseEntered(evt);
            }
        });
        aspane5.add(joindatek, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 310, 165, 25));
        aspane5.add(bn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 310, 25, 20));

        jLabel154.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel154.setText("Register Date");
        aspane5.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 90, 25));
        aspane5.add(bn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 65, 25, 20));

        jLabel155.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel155.setText("ATM Account");
        aspane5.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 65, 90, 25));

        s13f.setEditable(false);
        aspane5.add(s13f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 65, 165, 25));

        s15sf.setEditable(false);
        aspane5.add(s15sf, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 170, 130, 25));

        jLabel157.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel157.setText("Postal Code");
        aspane5.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 75, 25));

        s16f.setEditable(false);
        aspane5.add(s16f, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 134, 165, 25));

        jLabel158.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel158.setText("Account Title");
        aspane5.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 134, 90, 25));
        aspane5.add(bn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 134, 25, 20));

        s17df.setEditable(false);
        aspane5.add(s17df, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 135, 130, 25));

        jLabel160.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel160.setText("ATM Status");
        aspane5.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 135, 75, 25));
        aspane5.add(bn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 135, 25, 20));

        jTextField15.setEditable(false);
        jTextField15.setText("PKR");
        aspane5.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 275, 30, 25));
        aspane5.add(bn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 345, 25, 20));

        jLabel170.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel170.setText("ATM Register");
        aspane5.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 345, 75, 25));

        atm_date1.setEditable(false);
        atm_date1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atm_date1MouseEntered(evt);
            }
        });
        aspane5.add(atm_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 345, 130, 25));

        action_acc.add(aspane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 600, 415));

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
        pac77.add(bn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 30, 25));

        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel161.setText("Delete");
        pac77.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

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
        pac99.add(bn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 30, 25));

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel164.setText("Unblock");
        pac99.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

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
        pac101.add(bn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 30, 25));

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel186.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel186.setText("Block");
        pac101.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 30));

        action_acc.add(pac101, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 460, 85, 30));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setText("Save Profile");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        action_acc.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 110, 30));

        jPanel21.add(action_acc, "card9");

        getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 42, 660, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private Color color,c;
    private void a1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseExited

        jLabel1.setForeground(c);
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        a1.setBackground(color);
    }//GEN-LAST:event_a1MouseExited

    private void a1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseEntered
        // TODO add your handling code here:
        color = a1.getBackground();
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        c = a1.getForeground();
        jLabel1.setForeground(Color.white);
        a1.setBackground(Color.blue);
        a1.setToolTipText("Goto employee section");
    }//GEN-LAST:event_a1MouseEntered

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        color = jPanel5.getBackground();
        c = jPanel5.getForeground();
        jLabel3.setForeground(Color.white);
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jPanel5.setBackground(Color.blue);
        jPanel5.setToolTipText("Logout account");
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        jLabel3.setForeground(c);
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jPanel5.setBackground(new Color(102,153,255));
        
    }//GEN-LAST:event_jPanel5MouseExited

    private void a2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseEntered
        // TODO add your handling code here:
        color = a2.getBackground();
        c = a2.getForeground();
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setForeground(Color.white);
        a2.setBackground(Color.blue);
        a2.setToolTipText("Goto accounts section");
    }//GEN-LAST:event_a2MouseEntered

    private void a2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseExited
        // TODO add your handling code here:
        jLabel4.setForeground(c);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        a2.setBackground(color);
    }//GEN-LAST:event_a2MouseExited

    private void a4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseEntered
        // TODO add your handling code here:
        color = a4.getBackground();
        c = a4.getForeground();
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setForeground(Color.white);
        a4.setBackground(Color.blue);
        a4.setToolTipText("Goto balance record section");
    }//GEN-LAST:event_a4MouseEntered

    private void a4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseExited
        // TODO add your handling code here:
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setForeground(c);
        a4.setBackground(color);
    }//GEN-LAST:event_a4MouseExited

    private void a6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseEntered
        // TODO add your handling code here:
        color = a6.getBackground();
        c = a6.getForeground();
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setForeground(Color.white);
        a6.setBackground(Color.blue);
        a6.setToolTipText("Goto account profile");
    }//GEN-LAST:event_a6MouseEntered

    private void a6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseExited
        // TODO add your handling code here:
        jLabel7.setForeground(c);
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        a6.setBackground(color);
    }//GEN-LAST:event_a6MouseExited

    private void a7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseEntered
        // TODO add your handling code here:
        color = a7.getBackground();
        c = a7.getForeground();
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel8.setForeground(Color.white);
        a7.setBackground(Color.blue);
        a7.setToolTipText("Change account password");
    }//GEN-LAST:event_a7MouseEntered

    private void a7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseExited
        // TODO add your handling code here:
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setForeground(c);
        a7.setBackground(color);
    }//GEN-LAST:event_a7MouseExited

    private void jPanel11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_jPanel11MouseDragged

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_jPanel11MousePressed

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

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:
        int u=JOptionPane.showConfirmDialog(null,"Confirm to Cancle?","Confirm",JOptionPane.YES_NO_OPTION);
        if(u==JOptionPane.YES_OPTION){
         System.exit(0);
        }
    }//GEN-LAST:event_jPanel13MouseClicked

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

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void mouseclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseclick
        // TODO add your handling code here:
        if(evt.getSource()==home_p){
            URL pathh=getClass().getResource("/bank.png");
            ImageIcon photo=new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo.getWidth(),top_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
            top_logo.setIcon(photo);
            top_title.setText("Home");
            empy();
            home_p.setBackground(new Color(0,153,102));
            a1.setBackground(new Color(102,153,255));
            a2.setBackground(new Color(102,153,255));
            a4.setBackground(new Color(102,153,255));
            a6.setBackground(new Color(102,153,255));
            a7.setBackground(new Color(102,153,255));
            color=home_p.getBackground();
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(true);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
            search1.setText(null);
            serupdate.setText(null);
            rd1.setSelected(true);
            rd2.setSelected(false);
            rd3.setSelected(false);
            rd5.setSelected(true);
            rd4.setSelected(false);
            rd6.setSelected(false);
            jPanel10.setVisible(false);
       main_profile.setVisible(false);
       accounts_pnl.setVisible(false);
       atm_table_pnl.setVisible(false);
       search_acc.setVisible(false);
       action_acc.setVisible(false);
       search1j.setText(null);
            f_reset();
        }
        if(evt.getSource()==a1){
            URL pathh=getClass().getResource("/social_network-512.png");
            ImageIcon photo=new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo.getWidth(),top_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
            top_logo.setIcon(photo);
            top_title.setText("Employee Quires");
            empy();
            home_p.setBackground(new Color(102,153,255));
            a1.setBackground(new Color(0,153,102));
            a2.setBackground(new Color(102,153,255));
            a4.setBackground(new Color(102,153,255));
            a6.setBackground(new Color(102,153,255));
            a7.setBackground(new Color(102,153,255));
            color=a1.getBackground();
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(true);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
            search1.setText(null);
            serupdate.setText(null);
            rd1.setSelected(true);
            rd2.setSelected(false);
            rd3.setSelected(false);
            rd5.setSelected(true);
            rd4.setSelected(false);
            rd6.setSelected(false);
            jPanel10.setVisible(false);
       main_profile.setVisible(false);
       accounts_pnl.setVisible(false);
       atm_table_pnl.setVisible(false);
       search_acc.setVisible(false);
       action_acc.setVisible(false);
       search1j.setText(null);
            f_reset();
        }
        if(evt.getSource()==a2){
            URL pathh=getClass().getResource("/acc.png");
            ImageIcon photo=new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo.getWidth(),top_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
            top_logo.setIcon(photo);
            top_title.setText("Accounts Quires");
            home_p.setBackground(new Color(102,153,255));
            a1.setBackground(new Color(102,153,255));
            empy();
            a2.setBackground(new Color(0,153,102));
            a4.setBackground(new Color(102,153,255));
            a6.setBackground(new Color(102,153,255));
            a7.setBackground(new Color(102,153,255));
            color=a2.getBackground();
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(true);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
            search1.setText(null);
            serupdate.setText(null);
            rd1.setSelected(true);
            rd2.setSelected(false);
            rd3.setSelected(false);
            rd5.setSelected(true);
            rd4.setSelected(false);
            rd6.setSelected(false);
            jPanel10.setVisible(false);
       main_profile.setVisible(false);
       accounts_pnl.setVisible(false);
       atm_table_pnl.setVisible(false);
       search_acc.setVisible(false);
       action_acc.setVisible(false);
       search1j.setText(null);
            f_reset();
        }
        if(evt.getSource()==a4){
            URL pathh=getClass().getResource("/blnc.png");
            ImageIcon photo=new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo.getWidth(),top_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
            top_logo.setIcon(photo);
            top_title.setText("Balance Record");
            home_p.setBackground(new Color(102,153,255));
            empy();
            a1.setBackground(new Color(102,153,255));
            a2.setBackground(new Color(102,153,255));
            a4.setBackground(new Color(0,153,102));
            a6.setBackground(new Color(102,153,255));
            a7.setBackground(new Color(102,153,255));
            color=a4.getBackground();
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(true);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
            search1.setText(null);
            serupdate.setText(null);
            rd1.setSelected(true);
            rd2.setSelected(false);
            rd3.setSelected(false);
            rd5.setSelected(true);
            rd4.setSelected(false);
            rd6.setSelected(false);
            jPanel10.setVisible(false);
       main_profile.setVisible(false);
       accounts_pnl.setVisible(false);
       atm_table_pnl.setVisible(false);
       search_acc.setVisible(false);
       action_acc.setVisible(false);
       search1j.setText(null);
            f_reset();
        }
        if(evt.getSource()==a6){
            URL pathh=getClass().getResource("/pro.png");
            ImageIcon photo=new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo.getWidth(),top_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
            top_logo.setIcon(photo);
            top_title.setText("Account Profile");
            home_p.setBackground(new Color(102,153,255));
            empy();
            a1.setBackground(new Color(102,153,255));
            a2.setBackground(new Color(102,153,255));
            a4.setBackground(new Color(102,153,255));
            a6.setBackground(new Color(0,153,102));
            a7.setBackground(new Color(102,153,255));
            color=a6.getBackground();
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(true);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
            search1.setText(null);
            serupdate.setText(null);
            rd1.setSelected(true);
            rd2.setSelected(false);
            rd3.setSelected(false);
            rd5.setSelected(true);
            rd4.setSelected(false);
            rd6.setSelected(false);
            jPanel10.setVisible(false);
       main_profile.setVisible(false);
       accounts_pnl.setVisible(false);
       atm_table_pnl.setVisible(false);
       search_acc.setVisible(false);
       action_acc.setVisible(false);
       search1j.setText(null);
            f_reset();
        }
        if(evt.getSource()==a7){
            URL pathh=getClass().getResource("/pass.jpg");
            ImageIcon photo=new ImageIcon(new ImageIcon(pathh).getImage().getScaledInstance(top_logo.getWidth(),top_logo.getHeight(),java.awt.Image.SCALE_SMOOTH));
            top_logo.setIcon(photo);
            top_title.setText("Change Password");
            home_p.setBackground(new Color(102,153,255));
            a1.setBackground(new Color(102,153,255));
            a2.setBackground(new Color(102,153,255));
            a4.setBackground(new Color(102,153,255));
            a6.setBackground(new Color(102,153,255));
            a7.setBackground(new Color(0,153,102));
            empy();
            color=a7.getBackground();
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(true);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
            search1.setText(null);
            serupdate.setText(null);
            rd1.setSelected(true);
            rd2.setSelected(false);
            rd3.setSelected(false);
            rd5.setSelected(true);
            rd4.setSelected(false);
            rd6.setSelected(false);
            jPanel10.setVisible(false);
       main_profile.setVisible(false);
       accounts_pnl.setVisible(false);
       atm_table_pnl.setVisible(false);
       search_acc.setVisible(false);
       action_acc.setVisible(false);
       search1j.setText(null);
            f_reset();
            oldpass.requestFocus();
        }
    }//GEN-LAST:event_mouseclick

    private void home_pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_pMouseEntered
        // TODO add your handling code here:
        color = home_p.getBackground();
        c = home_p.getForeground();
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel19.setForeground(Color.white);
        home_p.setBackground(Color.blue);
        home_p.setToolTipText("Goto home page");
    }//GEN-LAST:event_home_pMouseEntered

    private void home_pMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_pMouseExited
        // TODO add your handling code here:
        jLabel19.setForeground(c);
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14));
        home_p.setBackground(color);
    }//GEN-LAST:event_home_pMouseExited
    private Color bck,fort;
    private void dash_h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash_h
        // TODO add your handling code here:
        if(evt.getSource()==d1_2){
            d1_1.setBackground(new Color(240,240,240));
            d1_l1.setForeground(Color.black);
            d1_l2.setForeground(Color.black);
            d1_2.setBackground(new Color(102,102,255));
            d1_l3.setForeground(Color.white);
            d1_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d1_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d2_2){
            d2_1.setBackground(new Color(240,240,240));
            d2_l1.setForeground(Color.black);
            d2_l2.setForeground(Color.black);
            d2_2.setBackground(new Color(102,102,255));
            d2_l3.setForeground(Color.white);
            d2_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d2_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d3_2){
            d3_1.setBackground(new Color(240,240,240));
            d3_l1.setForeground(Color.black);
            d3_l2.setForeground(Color.black);
            d3_2.setBackground(new Color(102,102,255));
            d3_l3.setForeground(Color.white);
            d3_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d3_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d4_2){
            d4_1.setBackground(new Color(240,240,240));
            d4_l1.setForeground(Color.black);
            d4_l2.setForeground(Color.black);
            d4_2.setBackground(new Color(102,102,255));
            d4_l3.setForeground(Color.white);
            d4_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d4_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d5_2){
            d5_1.setBackground(new Color(240,240,240));
            d5_l1.setForeground(Color.black);
            d5_l2.setForeground(Color.black);
            d5_2.setBackground(new Color(102,102,255));
            d5_l3.setForeground(Color.white);
            d5_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d5_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d6_2){
            d6_1.setBackground(new Color(240,240,240));
            d6_l1.setForeground(Color.black);
            d6_l2.setForeground(Color.black);
            d6_2.setBackground(new Color(102,102,255));
            d6_l3.setForeground(Color.white);
            d6_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d6_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d7_2){
            d7_1.setBackground(new Color(240,240,240));
            d7_l1.setForeground(Color.black);
            d7_l2.setForeground(Color.black);
            d7_2.setBackground(new Color(102,102,255));
            d7_l3.setForeground(Color.white);
            d7_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d7_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d8_2){
            d8_1.setBackground(new Color(240,240,240));
            d8_l1.setForeground(Color.black);
            d8_l2.setForeground(Color.black);
            d8_2.setBackground(new Color(102,102,255));
            d8_l3.setForeground(Color.white);
            d8_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d8_2.setToolTipText("View record details");
        }
        if(evt.getSource()==d9_2){
            d9_1.setBackground(new Color(240,240,240));
            d9_l1.setForeground(Color.black);
            d9_l2.setForeground(Color.black);
            d9_2.setBackground(new Color(102,102,255));
            d9_l3.setForeground(Color.white);
            d9_l3.setFont(new java.awt.Font("Tahoma", 1, 14));
            d9_2.setToolTipText("View record details");
        }
    }//GEN-LAST:event_dash_h

    private void dash_e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash_e
        // TODO add your handling code here:
        if(evt.getSource()==d1_2){
            d1_1.setBackground(new Color(102,102,255));
            d1_l1.setForeground(Color.white);
            d1_l2.setForeground(Color.white);
            d1_2.setBackground(new Color(240,240,240));
            d1_l3.setForeground(Color.black);
            d1_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d2_2){
            d2_1.setBackground(new Color(102,102,255));
            d2_l1.setForeground(Color.white);
            d2_l2.setForeground(Color.white);
            d2_2.setBackground(new Color(240,240,240));
            d2_l3.setForeground(Color.black);
            d2_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d3_2){
            d3_1.setBackground(new Color(102,102,255));
            d3_l1.setForeground(Color.white);
            d3_l2.setForeground(Color.white);
            d3_2.setBackground(new Color(240,240,240));
            d3_l3.setForeground(Color.black);
            d3_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d4_2){
            d4_1.setBackground(new Color(102,102,255));
            d4_l1.setForeground(Color.white);
            d4_l2.setForeground(Color.white);
            d4_2.setBackground(new Color(240,240,240));
            d4_l3.setForeground(Color.black);
            d4_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d5_2){
            d5_1.setBackground(new Color(102,102,255));
            d5_l1.setForeground(Color.white);
            d5_l2.setForeground(Color.white);
            d5_2.setBackground(new Color(240,240,240));
            d5_l3.setForeground(Color.black);
            d5_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d6_2){
            d6_1.setBackground(new Color(102,102,255));
            d6_l1.setForeground(Color.white);
            d6_l2.setForeground(Color.white);
            d6_2.setBackground(new Color(240,240,240));
            d6_l3.setForeground(Color.black);
            d6_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d7_2){
            d7_1.setBackground(new Color(102,102,255));
            d7_l1.setForeground(Color.white);
            d7_l2.setForeground(Color.white);
            d7_2.setBackground(new Color(240,240,240));
            d7_l3.setForeground(Color.black);
            d7_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d8_2){
            d8_1.setBackground(new Color(102,102,255));
            d8_l1.setForeground(Color.white);
            d8_l2.setForeground(Color.white);
            d8_2.setBackground(new Color(240,240,240));
            d8_l3.setForeground(Color.black);
            d8_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d9_2){
            d9_1.setBackground(new Color(102,102,255));
            d9_l1.setForeground(Color.white);
            d9_l2.setForeground(Color.white);
            d9_2.setBackground(new Color(240,240,240));
            d9_l3.setForeground(Color.black);
            d9_l3.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
    }//GEN-LAST:event_dash_e

    private void emp_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_menter
        // TODO add your handling code here:
        if(evt.getSource()==d1_4){
            d1_3.setBackground(new Color(240,240,240));
            d1_l4.setForeground(Color.black);
            d1_l5.setForeground(Color.black);
            d1_4.setBackground(new Color(102,102,255));
            d1_l6.setForeground(Color.white);
            d1_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
            d1_4.setToolTipText("View record details");
        }
        if(evt.getSource()==d1_6){
            d1_5.setBackground(new Color(240,240,240));
            d1_l7.setForeground(Color.black);
            d1_l8.setForeground(Color.black);
            d1_6.setBackground(new Color(102,102,255));
            d1_l9.setForeground(Color.white);
            d1_l9.setFont(new java.awt.Font("Tahoma", 1, 14));
            d1_6.setToolTipText("View record details");
        }
        if(evt.getSource()==d1_8){
            d1_7.setBackground(new Color(240,240,240));
            d1_l10.setForeground(Color.black);
            d1_l11.setForeground(Color.black);
            d1_8.setBackground(new Color(102,102,255));
            d1_l12.setForeground(Color.white);
            d1_l12.setFont(new java.awt.Font("Tahoma", 1, 14));
            d1_8.setToolTipText("View record details");
        }
    }//GEN-LAST:event_emp_menter

    private void emp_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_mexit
        // TODO add your handling code here:
        if(evt.getSource()==d1_4){
            d1_3.setBackground(new Color(102,102,255));
            d1_l4.setForeground(Color.white);
            d1_l5.setForeground(Color.white);
            d1_4.setBackground(new Color(240,240,240));
            d1_l6.setForeground(Color.black);
            d1_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d1_6){
            d1_5.setBackground(new Color(102,102,255));
            d1_l7.setForeground(Color.white);
            d1_l8.setForeground(Color.white);
            d1_6.setBackground(new Color(240,240,240));
            d1_l9.setForeground(Color.black);
            d1_l9.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d1_8){
            d1_7.setBackground(new Color(102,102,255));
            d1_l10.setForeground(Color.white);
            d1_l11.setForeground(Color.white);
            d1_8.setBackground(new Color(240,240,240));
            d1_l12.setForeground(Color.black);
            d1_l12.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
    }//GEN-LAST:event_emp_mexit

    private void ac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac_menter
        // TODO add your handling code here:
        if(evt.getSource()==ac1){
        lac1.setFont(new java.awt.Font("Tahoma", 1, 13));
        lac1.setForeground(Color.white);
        ac1.setBackground(Color.blue);
        ac1.setToolTipText("Add new Employee account");
        }
        if(evt.getSource()==ac2){
        lac2.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac2.setBackground(Color.blue);
        lac2.setForeground(Color.white);
        ac2.setToolTipText("Search Employee data");
        }
        if(evt.getSource()==ac3){
        lac3.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac3.setBackground(Color.blue);
        lac3.setForeground(Color.white);
        ac3.setToolTipText("Update Employee data");
        }
        if(evt.getSource()==ac4){
        lac4.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac4.setBackground(Color.blue);
        lac4.setForeground(Color.white);
        ac4.setToolTipText("Delete Employee data");
        }
    }//GEN-LAST:event_ac_menter

    private void ac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac_mexit
        // TODO add your handling code here:
        if(evt.getSource()==ac1){
        lac1.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac1.setForeground(Color.black);
        ac1.setBackground(new Color(240,240,240));
        }
        if(evt.getSource()==ac2){
        lac2.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac2.setForeground(Color.black);
        ac2.setBackground(new Color(240,240,240));
        }
        if(evt.getSource()==ac3){
        lac3.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac3.setForeground(Color.black);
        lac3.setForeground(Color.black);
        ac3.setBackground(new Color(240,240,240));
        }
        if(evt.getSource()==ac4){
        lac4.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac4.setForeground(Color.black);
        ac4.setBackground(new Color(240,240,240));
        }
    }//GEN-LAST:event_ac_mexit

    private void ac7ac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac7ac_menter
        // TODO add your handling code here:
        lac7.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac7.setBackground(Color.blue);
        lac7.setForeground(Color.white);
        ac7.setToolTipText("Unblock Employee account");
    }//GEN-LAST:event_ac7ac_menter

    private void ac7ac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac7ac_mexit
        // TODO add your handling code here:
        lac7.setFont(new java.awt.Font("Tahoma", 1, 12));
        ac7.setBackground(new Color(102,102,255));
        lac7.setForeground(Color.black);
        ac7.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_ac7ac_mexit

    private void ac8ac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac8ac_menter

        lac8.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac8.setBackground(Color.blue);
        lac8.setForeground(Color.white);
        ac8.setToolTipText("Block Employee account");
        
    }//GEN-LAST:event_ac8ac_menter

    private void ac8ac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac8ac_mexit
        // TODO add your handling code here:
        lac8.setFont(new java.awt.Font("Tahoma", 1, 12));
        ac8.setBackground(new Color(102,102,255));
        lac8.setForeground(Color.black);
        ac8.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_ac8ac_mexit

    private void an_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_an_menter
        // TODO add your handling code here:
        if(evt.getSource()==ac5){
        lac5.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac5.setBackground(Color.blue);
        lac5.setForeground(Color.white);
        ac5.setToolTipText("Search account data");
        }
        if(evt.getSource()==ac6){
        lac6.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac6.setBackground(Color.blue);
        lac6.setForeground(Color.white);
        ac6.setToolTipText("Delete account data");
        }
        if(evt.getSource()==ac9){
        lac9.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac9.setBackground(Color.blue);
        lac9.setForeground(Color.white);
        ac9.setToolTipText("Block account");
        }
        if(evt.getSource()==ac10){
        lac10.setFont(new java.awt.Font("Tahoma", 1, 13));
        ac10.setBackground(Color.blue);
        lac10.setForeground(Color.white);
        ac10.setToolTipText("Unblock account");
        }
    }//GEN-LAST:event_an_menter

    private void an_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_an_mexit
        // TODO add your handling code here:
        if(evt.getSource()==ac5){
        lac5.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac5.setForeground(Color.black);
        ac5.setBackground(new Color(240,240,240));
        }
        if(evt.getSource()==ac6){
        lac6.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac6.setForeground(Color.black);
        ac6.setBackground(new Color(240,240,240));
        }
        if(evt.getSource()==ac9){
        lac9.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac9.setForeground(Color.black);
        ac9.setBackground(new Color(240,240,240));
        }
        if(evt.getSource()==ac10){
        lac10.setFont(new java.awt.Font("Tahoma", 1, 12));
        lac10.setForeground(Color.black);
        ac10.setBackground(new Color(240,240,240));
        }
    }//GEN-LAST:event_an_mexit

    private void and_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_and_menter
        // TODO add your handling code here:
        if(evt.getSource()==d1_10){
            d1_9.setBackground(new Color(240,240,240));
            d1_l13.setForeground(Color.black);
            d1_l14.setForeground(Color.black);
            d1_10.setBackground(new Color(102,102,255));
            d1_l15.setForeground(Color.white);
            d1_l15.setFont(new java.awt.Font("Tahoma", 1, 14));
            d1_10.setToolTipText("View record details");
        }
        if(evt.getSource()==d1_12){
            d1_11.setBackground(new Color(240,240,240));
            d1_l16.setForeground(Color.black);
            d1_l17.setForeground(Color.black);
            d1_12.setBackground(new Color(102,102,255));
            d1_l18.setForeground(Color.white);
            d1_l18.setFont(new java.awt.Font("Tahoma", 1, 14));
            d1_12.setToolTipText("View record details");
        }
        if(evt.getSource()==d1_14){
            d1_13.setBackground(new Color(240,240,240));
            d1_l19.setForeground(Color.black);
            d1_l20.setForeground(Color.black);
            d1_14.setBackground(new Color(102,102,255));
            d1_l21.setForeground(Color.white);
            d1_l21.setFont(new java.awt.Font("Tahoma", 1, 14));
            d1_14.setToolTipText("View record details");
        }
    }//GEN-LAST:event_and_menter

    private void and_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_and_mexit
        // TODO add your handling code here:
        if(evt.getSource()==d1_10){
            d1_9.setBackground(new Color(102,102,255));
            d1_l13.setForeground(Color.white);
            d1_l14.setForeground(Color.white);
            d1_10.setBackground(new Color(240,240,240));
            d1_l15.setForeground(Color.black);
            d1_l15.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d1_12){
            d1_11.setBackground(new Color(102,102,255));
            d1_l16.setForeground(Color.white);
            d1_l17.setForeground(Color.white);
            d1_12.setBackground(new Color(240,240,240));
            d1_l18.setForeground(Color.black);
            d1_l18.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d1_14){
            d1_13.setBackground(new Color(102,102,255));
            d1_l19.setForeground(Color.white);
            d1_l20.setForeground(Color.white);
            d1_14.setBackground(new Color(240,240,240));
            d1_l21.setForeground(Color.black);
            d1_l21.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
    }//GEN-LAST:event_and_mexit

    private void bn_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_menter
        // TODO add your handling code here:
        if(evt.getSource()==d7_4){
            d7_3.setBackground(new Color(240,240,240));
            d7_l4.setForeground(Color.black);
            d7_l5.setForeground(Color.black);
            d7_4.setBackground(new Color(102,102,255));
            d7_l6.setForeground(Color.white);
            d7_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
            d7_4.setToolTipText("View record details");
        }
        if(evt.getSource()==d9_4){
            d9_3.setBackground(new Color(240,240,240));
            d9_l4.setForeground(Color.black);
            d9_l5.setForeground(Color.black);
            d9_4.setBackground(new Color(102,102,255));
            d9_l6.setForeground(Color.white);
            d9_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
            d9_4.setToolTipText("View record details");
        }
        if(evt.getSource()==d8_4){
            d8_3.setBackground(new Color(240,240,240));
            d8_l4.setForeground(Color.black);
            d8_l5.setForeground(Color.black);
            d8_4.setBackground(new Color(102,102,255));
            d8_l6.setForeground(Color.white);
            d8_l6.setFont(new java.awt.Font("Tahoma", 1, 14));
            d8_4.setToolTipText("View record details");
        }
    }//GEN-LAST:event_bn_menter

    private void bn_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_mexit
        // TODO add your handling code here:
        if(evt.getSource()==d7_4){
            d7_3.setBackground(new Color(102,102,255));
            d7_l4.setForeground(Color.white);
            d7_l5.setForeground(Color.white);
            d7_4.setBackground(new Color(240,240,240));
            d7_l6.setForeground(Color.black);
            d7_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d9_4){
            d9_3.setBackground(new Color(102,102,255));
            d9_l4.setForeground(Color.white);
            d9_l5.setForeground(Color.white);
            d9_4.setBackground(new Color(240,240,240));
            d9_l6.setForeground(Color.black);
            d9_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
        if(evt.getSource()==d8_4){
            d8_3.setBackground(new Color(102,102,255));
            d8_l4.setForeground(Color.white);
            d8_l5.setForeground(Color.white);
            d8_4.setBackground(new Color(240,240,240));
            d8_l6.setForeground(Color.black);
            d8_l6.setFont(new java.awt.Font("Tahoma", 1, 12));
        }
    }//GEN-LAST:event_bn_mexit

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
        jLabel17.setForeground(Color.white);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        // TODO add your handling code here:
        jLabel17.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel17MouseExited
private int see=0,seee=0;
    private void se1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se1MouseClicked

        if(see==0){
            oldpass.setEchoChar((char)0);
            URL path30=getClass().getResource("/unsee.jpg");
            ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se1.getWidth(),se1.getHeight(),java.awt.Image.SCALE_SMOOTH));
            se1.setIcon(photo30);
            see=1;
        }
        else if(see==1){
            oldpass.setEchoChar('•');
            oldpass.setForeground(Color.black);
            URL path30=getClass().getResource("/see.png");
            ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se1.getWidth(),se1.getHeight(),java.awt.Image.SCALE_SMOOTH));
            se1.setIcon(photo30);
            see=0;
        }
        
    }//GEN-LAST:event_se1MouseClicked

    private void se2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se2MouseClicked
        // TODO add your handling code here:
        if(seee==0){
            newpass1.setEchoChar((char)0);
            newpass2.setEchoChar((char)0);
            URL path30=getClass().getResource("/unsee.jpg");
            ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se2.getWidth(),se2.getHeight(),java.awt.Image.SCALE_SMOOTH));
            se2.setIcon(photo30);
            seee=1;
        }
        else if(seee==1){
            newpass1.setEchoChar('•');
            newpass2.setEchoChar('•');
            oldpass.setForeground(Color.black);
            URL path30=getClass().getResource("/see.png");
            ImageIcon photo30=new ImageIcon(new ImageIcon(path30).getImage().getScaledInstance(se2.getWidth(),se2.getHeight(),java.awt.Image.SCALE_SMOOTH));
            se2.setIcon(photo30);
            seee=0;
        }
    }//GEN-LAST:event_se2MouseClicked

    private void pac_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac_menter
        // TODO add your handling code here:
        if(evt.getSource()==pac1){
            pac1.setBackground(new Color(255,51,51));
            jLabel26.setForeground(Color.white);
            pac1.setToolTipText("Reset all fields");
        }
        if(evt.getSource()==pac2){
            pac2.setBackground(Color.blue);
            jLabel25.setForeground(Color.white);
            pac1.setToolTipText("Change you password");
        }
    }//GEN-LAST:event_pac_menter

    private void pac_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac_mexit
        // TODO add your handling code here:
        if(evt.getSource()==pac1){
            pac1.setBackground(new Color(240,240,240));
            jLabel26.setForeground(Color.black);
        }
        if(evt.getSource()==pac2){
            pac2.setBackground(new Color(240,240,240));
            jLabel25.setForeground(Color.black);
        }
    }//GEN-LAST:event_pac_mexit

    private void pac1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac1MouseClicked
        // TODO add your handling code here:
        oldpass.setText(null);
        newpass1.setText(null);
        newpass2.setText(null);
    }//GEN-LAST:event_pac1MouseClicked

    private void ac1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac1MouseClicked

        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(true);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
            update_value();
            int idshow=employeeid+1;
            f1.setText("EMP"+String.valueOf(idshow));
            f2.requestFocusInWindow();
    }//GEN-LAST:event_ac1MouseClicked

    private void en_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_en_mexit
        // TODO add your handling code here:
        if(evt.getSource()==pac6){
            pac6.setBackground(new Color(240,240,240));
            jLabel44.setForeground(Color.black);
        }
        if(evt.getSource()==pac5){
            pac5.setBackground(new Color(240,240,240));
            jLabel43.setForeground(Color.black);
        }
    }//GEN-LAST:event_en_mexit

    private void en_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_en_menter
        // TODO add your handling code here:
        if(evt.getSource()==pac6){
            pac6.setBackground(new Color(255,51,51));
            jLabel44.setForeground(Color.white);
            pac6.setToolTipText("Reset all fields");
        }
        if(evt.getSource()==pac5){
            pac5.setBackground(Color.blue);
            jLabel43.setForeground(Color.white);
            pac5.setToolTipText("Register account");
        }
    }//GEN-LAST:event_en_menter

    private void pac6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac6MouseClicked
        // TODO add your handling code here:
            f_reset();
    }//GEN-LAST:event_pac6MouseClicked

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
        jLabel41.setForeground(Color.blue);
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        // TODO add your handling code here:
        jLabel41.setForeground(Color.black);
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
            f_reset();
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(true);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
        
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseClicked
        // TODO add your handling code here:
         male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(true);
            updatepane.setVisible(false);
            search1.setText(null);
            rd1.setSelected(true);
            rd2.setSelected(false);
            rd3.setSelected(false);
            search1.requestFocus();
    }//GEN-LAST:event_jPanel23MouseClicked

    private void jPanel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseEntered
        // TODO add your handling code here:
         jLabel60.setForeground(Color.blue);
    }//GEN-LAST:event_jPanel23MouseEntered

    private void jPanel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseExited
        // TODO add your handling code here:
         jLabel60.setForeground(Color.black);
    }//GEN-LAST:event_jPanel23MouseExited

    private void red_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red_menter
        // TODO add your handling code here:
        if(evt.getSource()==pac10){
            pac10.setBackground(new Color(255,102,102));
            jLabel59.setForeground(Color.white);
            pac10.setToolTipText("Block account");
        }
        if(evt.getSource()==pac7){
            pac7.setBackground(new Color(255,102,102));
            jLabel56.setForeground(Color.white);
            pac7.setToolTipText("Delete account");
        }
    }//GEN-LAST:event_red_menter

    private void red_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red_mexit
        // TODO add your handling code here:
        if(evt.getSource()==pac10){
            pac10.setBackground(new Color(240,240,240));
            jLabel59.setForeground(Color.black);
        }
        if(evt.getSource()==pac7){
            pac7.setBackground(new Color(240,240,240));
            jLabel56.setForeground(Color.black);
        }
    }//GEN-LAST:event_red_mexit

    private void redio_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redio_action
        // TODO add your handling code here:
        if(evt.getSource()==rd1){
            rd1.isSelected();
            rd2.setSelected(false);
            rd3.setSelected(false);
            search1.setText("");
            search1.requestFocus();
        }
        if(evt.getSource()==rd2){
            rd2.isSelected();
            rd1.setSelected(false);
            rd3.setSelected(false);
            search1.setText("");
            searcherr.setText(null);
            search1.requestFocus();
        }
        if(evt.getSource()==rd3){
            rd3.isSelected();
            rd2.setSelected(false);
            rd1.setSelected(false);
            search1.setText("EMP");
            searcherr.setText(null);
            search1.requestFocus();
        }
    }//GEN-LAST:event_redio_action
   void search_button_task(){
            if(search1.getText().isEmpty()){
                search.setVisible(true);
                searcherr.setText("Please enter data for searching");
            }else{
            if(rd1.isSelected()){
                if(database.check_employee(search1.getText(),"cnic")==true){
                    search_emp_data(search1.getText(),"cnic");
                    search.setVisible(false);
                    entry2.setVisible(true);
                }else{
                    search.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Employee record not found", "Info",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(rd2.isSelected()){
                if(isValidEmailAddress(search1.getText())==true){
                    if(database.check_employee(search1.getText(),"mail")==true){
                    search_emp_data(search1.getText(),"mail");
                        search.setVisible(false);
                         entry2.setVisible(true);
                    }else{
                        search.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Employee record not found", "Info",JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                    search.setVisible(true);
                    searcherr.setText("Enter valid Email address");       
                }
            }
            else if(rd3.isSelected()){
                if(database.check_employee(search1.getText(),"id")==true){
                    search_emp_data(search1.getText(),"id");
                    search.setVisible(false);
                    entry2.setVisible(true);
                }else{
                    search.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Employee record not found", "Info",JOptionPane.ERROR_MESSAGE);
                }
            }
            }
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            updatepane.setVisible(false);
   }
    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        // TODO add your handling code her
        search_button_task();
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jPanel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseClicked
        // TODO add your handling code here:
        p1.setVisible(true);
        search1.setText(null);
        rd1.setSelected(true);
        rd2.setSelected(false);
        rd3.setSelected(false);
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_jPanel24MouseClicked

    private void jPanel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseEntered
        // TODO add your handling code here:
        jLabel68.setForeground(Color.blue);
    }//GEN-LAST:event_jPanel24MouseEntered

    private void jPanel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseExited
        // TODO add your handling code here:
        jLabel68.setForeground(Color.black);
    }//GEN-LAST:event_jPanel24MouseExited

    private void jPanel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseEntered
        // TODO add your handling code here:
        jPanel27.setBackground(new Color(0,204,0));
        jLabel66.setForeground(Color.white);
    }//GEN-LAST:event_jPanel27MouseEntered

    private void jPanel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseExited
        // TODO add your handling code here:
        jPanel27.setBackground(new Color(240,240,240));
        jLabel66.setForeground(Color.black);
    }//GEN-LAST:event_jPanel27MouseExited

    private void blu_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blu_menter
        // TODO add your handling code here:
        if(evt.getSource()==pac9){
        pac9.setBackground(new Color(102,102,255));
        jLabel58.setForeground(Color.white);
        pac9.setToolTipText("Unblock account");
        }
        if(pac8==evt.getSource()){
            pac8.setBackground(new Color(102,102,255));
            jLabel57.setForeground(Color.white);
        }
        
    }//GEN-LAST:event_blu_menter

    private void blu_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blu_mexit
        // TODO add your handling code here:
        if(evt.getSource()==pac9){
        pac9.setBackground(new Color(240,240,240));
        jLabel58.setForeground(Color.black);
        }
        if(pac8==evt.getSource()){
            pac8.setBackground(new Color(240,240,240));
            jLabel57.setForeground(Color.black);
        }
        
    }//GEN-LAST:event_blu_mexit

    private void pac8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac8MouseClicked
        // TODO add your handling code here:
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(true);
        if(upic.getIcon()==null || u3.getDate()==null || u1.getText().isEmpty() || u2.getText().isEmpty()|| u4.getSelectedItem()=="Marital Status" || u5.getText().isEmpty()|| u6.getText().isEmpty()|| u7.getText().isEmpty() || u8.getSelectedItem()=="Select Gender" || u9.getText().isEmpty()|| u10.getText().isEmpty()|| u11.getText().isEmpty()|| u12.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Please fill all required fields", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(u5.getText().length()!=15){
            JOptionPane.showMessageDialog(this,"Please enter valid CNIC number","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(u9.getText().length()!=10){
             JOptionPane.showMessageDialog(this,"Please enter valid contect","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            SimpleDateFormat thedate = new SimpleDateFormat("dd-MM-yyyy");
             String dab = thedate.format(u3.getDate()).toString();
             String df = "Hello dear " +u1.getText() + " !\nYour Sky Bank employee account profile update successfully. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                if(database.update_employee_data(employee_id,u1.getText(),u2.getText(),dab,u4.getSelectedItem().toString(),u5.getText(),u6.getText(),u7.getText(),u8.getSelectedItem().toString(),u9.getText(),u10.getText(),u11.getText(),u12.getText(),mg)==true){
                    Thread t = new Thread(new Runnable(){
                    public void run(){
                    if (net() == true) {
                        em.send(u6.getText(),df,"Message");
                    }
                }
            });
            t.start();
            JOptionPane.showMessageDialog(this,"Employee record update");
                }else{
                    JOptionPane.showMessageDialog(this,"Employee not record update");
                }
        }
            
    }//GEN-LAST:event_pac8MouseClicked

    private void action_emp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_emp
        // TODO add your handling code here:
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(true);
            updatepane.setVisible(false);
            search1.requestFocus();
    }//GEN-LAST:event_action_emp

    private void jPanel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseEntered
        // TODO add your handling code here:
        jPanel29.setBackground(new Color(0,204,0));
        jLabel100.setForeground(Color.white);
    }//GEN-LAST:event_jPanel29MouseEntered

    private void jPanel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseExited
        // TODO add your handling code here:
        jPanel29.setBackground(new Color(240,240,240));
        jLabel100.setForeground(Color.black);
    }//GEN-LAST:event_jPanel29MouseExited

    private void rd_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_action
        // TODO add your handling code here:
         if(evt.getSource()==rd4){
            rd4.isSelected();
            rd5.setSelected(false);
            rd6.setSelected(false);
            serupdate.setText("EMP");
            serupdate.requestFocus();
        }
        if(evt.getSource()==rd5){
            rd5.isSelected();
            rd4.setSelected(false);
            rd6.setSelected(false);
            serupdate.setText("");
            serupdate.requestFocus();
        }
        if(evt.getSource()==rd6){
            rd6.isSelected();
            rd5.setSelected(false);
            rd4.setSelected(false);
            serupdate.setText("");
            serupdate.requestFocus();
        }
    }//GEN-LAST:event_rd_action

    private void ac3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ac3MouseClicked
        // TODO add your handling code here:
        up_search.setVisible(true);
        serupdate.requestFocus();
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_ac3MouseClicked
void update_search_button_task(){
            if(serupdate.getText().isEmpty()){
                up_search.setVisible(true);
                uperror.setText("Please enter data for searching");
            }else{
            if(rd5.isSelected()){
                if(database.check_employee(serupdate.getText(),"cnic")==true){
                    search_update_emp_data(serupdate.getText(),"cnic");
                    updatepane.setVisible(true);
                    up_search.setVisible(false);
                }else{
                    up_search.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Employee record not found", "Info",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(rd6.isSelected()){
                if(isValidEmailAddress(serupdate.getText())==true){
                    if(database.check_employee(serupdate.getText(),"mail")==true){
                    search_update_emp_data(serupdate.getText(),"mail");
                        updatepane.setVisible(true);
                       up_search.setVisible(false);
                    }else{
                        up_search.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Employee record not found", "Info",JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                    up_search.setVisible(true);
                    uperror.setText("Enter valid Email address");       
                }
            }
            else if(rd4.isSelected()){
                if(database.check_employee(serupdate.getText(),"id")==true){
                    search_update_emp_data(serupdate.getText(),"id");
                    updatepane.setVisible(true);
                    up_search.setVisible(false);
                }else{
                    up_search.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Employee record not found", "Info",JOptionPane.ERROR_MESSAGE);
                }
            }
            }
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
   }
    private void jPanel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseClicked
        update_search_button_task();
    }//GEN-LAST:event_jPanel29MouseClicked

    private void jPanel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseClicked
        // TODO add your handling code here:
        up_search.setVisible(false);
        p1.setVisible(true);
        serupdate.setText(null);
        rd5.setSelected(true);
        rd4.setSelected(false);
        rd6.setSelected(false);
    male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_jPanel30MouseClicked

    private void jPanel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel26MouseClicked
        // TODO add your handling code here:
        up_search.setVisible(true);
        serupdate.requestFocus();
        serupdate.setText("");
        rd5.setSelected(true);
        rd4.setSelected(false);
        rd6.setSelected(false);
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_jPanel26MouseClicked

    private void jLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseClicked
        // TODO add your handling code here:
        er13.setText(null);
        JFileChooser ch=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("jpg,png","jpg","png");
        ch.setFileFilter(filter);
        int choice=ch.showOpenDialog(this);
        if(choice==JFileChooser.APPROVE_OPTION){
            path=ch.getSelectedFile();
            String p=path.getAbsolutePath();
            ImageIcon pc=new ImageIcon(new ImageIcon(p).getImage().getScaledInstance(pic.getWidth(),pic.getHeight(),java.awt.Image.SCALE_SMOOTH));
            pic.setIcon(pc);
        }
        
    }//GEN-LAST:event_jLabel73MouseClicked
    void data_insertion_action(){
        if(f1.getText().isEmpty() || pic.getIcon()==null || dob.getDate()==null || f2.getText().isEmpty() || f2.getText().isEmpty()|| f3.getText().isEmpty()|| f4.getSelectedItem()=="Marital Status" || f5.getText().isEmpty()|| f6.getText().isEmpty()|| f7.getText().isEmpty() || f8.getSelectedItem()=="Select Gender" || f9.getText().isEmpty()|| f10.getText().isEmpty()|| f11.getText().isEmpty()|| f12.getText().isEmpty()){
        if(pic.getIcon()==null){
            er13.setText("Upload image");
        }
        if(dob.getDate()==null){
            er3.setText("Enter Date of birth");
        }
        if(f1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Refresh page again","Error",JOptionPane.ERROR_MESSAGE);
        }
        if(f2.getText().isEmpty()){
            er1.setText("Enter employee name");
        }
        if(f3.getText().isEmpty()){
            er2.setText("Enter father name");
        }
        if(f4.getSelectedItem()=="Marital Status"){
            er4.setText("Select marital status");
        }
        if(f5.getText().isEmpty()){
            er5.setText("Enter CNIC number");
        }
        if(f6.getText().isEmpty()){
            er6.setText("Enter email");
        }
        if(f7.getText().isEmpty()){
            er7.setText("Enter postal code");
        }
        if(f8.getSelectedItem()=="Select Gender"){
            er9.setText("Select gender");
        }
        if(f9.getText().isEmpty()){
            er10.setText("Enter contect number");
        }
        if(f10.getText().isEmpty()){
            er11.setText("Enter education level");
        }
        if(f11.getText().isEmpty()){
            er12.setText("Enter employee income");
        }
        if(f12.getText().isEmpty()){
            er8.setText("Enter address");
        }
        }
        else if(isValidEmailAddress(f6.getText())==false || f5.getText().length()!=15 || f9.getText().length()!=10){
            if(isValidEmailAddress(f6.getText())==false){
            er6.setText("Enter valid email address");
            }
            if(f5.getText().length()!=15){
            er5.setText("Enter valid CNIC number");
             }
            if(f9.getText().length()!=10){
            er10.setText("Enter valid contect");
            }
        }
        else{
        SplittableRandom s1=new SplittableRandom();
        StringBuilder s2=new StringBuilder();
        for(int i=0;i<5;i++){
          s2.append(s1.nextInt(0,10));
         }
        String pass="emp"+s2.toString();
        SimpleDateFormat thedate = new SimpleDateFormat("dd-MM-yyyy");
        String dat = thedate.format(dob.getDate());
        update_value();
        employeeid=employeeid+1;
        String emid="EMP"+String.valueOf(employeeid);
        if(database.check_employee(f5.getText(),"cnic")==false){
        if(database.insertion(emid,f2.getText(), f3.getText(),dat,f4.getSelectedItem().toString(),f5.getText(), f6.getText(),f7.getText(),f8.getSelectedItem().toString(), f9.getText(), f10.getText(), f11.getText(), f12.getText(), path, pass)==true){
            database.dashboard_update(employeeid);
           // JOptionPane.showMessageDialog(this,"Please Wait few Seconds","Info",JOptionPane.INFORMATION_MESSAGE);
            String df="Hello dear "+f2.getText()+"\nWelcome to Sky Bank limited in Pakitan. Your Employee account is registerd\nYour username and password is given below\nUsername : "+emid+"\nPassword : "+pass;
           Thread t = new Thread(new Runnable(){
                public void run(){
                if (net() == true) {
                    em.send(f6.getText(),df,"Welcome to SKY Bank Pakistan");
                   }
                }
            });
            t.start();
            JOptionPane.showMessageDialog(this,"New Employee record add successfully","Info",JOptionPane.INFORMATION_MESSAGE);
            f_reset();
            f2.requestFocus();
            dashboraddat();
            f1.setText(null);
            entry.setVisible(false);
            p1.setVisible(true);
        }
        }else{
            JOptionPane.showMessageDialog(this,"Duplicate entry","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    private void pac5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac5MouseClicked
        // TODO add your handling code here:
        data_insertion_action();
    }//GEN-LAST:event_pac5MouseClicked

    private void entry_error(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_entry_error
        // TODO add your handling code here:
        if(evt.getSource()==db){
            er3.setText(null);
        }
        if(evt.getSource()==f2){
            er1.setText(null);
        }
        if(evt.getSource()==f3){
            er2.setText(null);
        }
        if(evt.getSource()==f4){
            er4.setText(null);
        }
        if(evt.getSource()==f5){
            er5.setText(null);
        }
        if(evt.getSource()==f6){
            er6.setText(null);
        }
        if(evt.getSource()==f7){
            er7.setText(null);
        }
        if(evt.getSource()==f8){
            er9.setText(null);
        }
        if(evt.getSource()==f9){
            er10.setText(null);
        }
        if(evt.getSource()==f10){
            er11.setText(null);
        }
        if(evt.getSource()==f11){
            er12.setText(null);
        }
        if(evt.getSource()==f12){
            er8.setText(null);
        }
    }//GEN-LAST:event_entry_error

    private void f4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f4ActionPerformed
        // TODO add your handling code here:
        if(f4.getSelectedItem()!="Marital Status"){
            er4.setText(null);
        }
    }//GEN-LAST:event_f4ActionPerformed

    private void f8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f8ActionPerformed
        // TODO add your handling code here:
        if(f8.getSelectedItem()!="Select Gender"){
            er9.setText(null);
        }
    }//GEN-LAST:event_f8ActionPerformed

    private void f7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f7KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
            er7.setText("Enter only digits");
        }else{
             er7.setText(null);
        }
    }//GEN-LAST:event_f7KeyTyped

    private void f11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f11KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
            er12.setText("Enter only digits");
        }else{
             er12.setText(null);
        }
    }//GEN-LAST:event_f11KeyTyped

    private void f9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f9KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
            er10.setText("Enter only digits");
        }else{
            if(f9.getText().length()>9){
                evt.consume();
            }
             er10.setText(null);
        }
    }//GEN-LAST:event_f9KeyTyped

    private void f10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f10KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
       if(!(Character.isAlphabetic(word)||Character.isWhitespace(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            evt.consume();
            getToolkit().beep();
            er11.setText("Enter only alphabet");
        }else{
             er11.setText(null);
        }
    }//GEN-LAST:event_f10KeyTyped

    private void f3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f3KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isAlphabetic(word)||Character.isWhitespace(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            evt.consume();
            getToolkit().beep();
            er2.setText("Enter only alphabet");
        }else{
             er2.setText(null);
        }
    }//GEN-LAST:event_f3KeyTyped

    private void f2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f2KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isAlphabetic(word)||Character.isWhitespace(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
            evt.consume();
            getToolkit().beep();
            er1.setText("Enter only alphabet");
        }else{
             er1.setText(null);
        }
    }//GEN-LAST:event_f2KeyTyped

    private void f5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f5KeyTyped

        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
            er5.setText("Enter only numbers");
        }else{
            if(f5.getText().length()>14){
                 evt.consume();
             }
             er5.setText(null);
        }
    }//GEN-LAST:event_f5KeyTyped
String mal=null;
int len=200;
int o=0;
    private void f6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f6KeyReleased
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(word=='@'){
            f6.setText(f6.getText()+"gmail.com");
            len=f6.getText().length();
            o=0;
        }
        
    }//GEN-LAST:event_f6KeyReleased

    private void f6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f6KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(word=='@'){
            mal=f6.getText();
        }
        if((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE){
            if(o==0){
            f6.setText(mal);
            o++;
            }
        }
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            if(f6.getText().length()>=len){
                evt.consume();
            }
        }
    }//GEN-LAST:event_f6KeyTyped

    private void f5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f5KeyReleased
        // TODO add your handling code here:
       char word=evt.getKeyChar();
            if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
             if(f5.getText().length()==5){
                 f5.setText(f5.getText()+"-");
             }
             if(f5.getText().length()==13){
                 f5.setText(f5.getText()+"-");
             }
            }
    }//GEN-LAST:event_f5KeyReleased

    private void search1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyTyped
        // TODO add your handling code here:
         char word=evt.getKeyChar();
         if(rd1.isSelected()){
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
            searcherr.setText("Enter only numbers");
        }else{
            if(search1.getText().length()>14){
                 evt.consume();
             }
             searcherr.setText(null);
        }
         }
    }//GEN-LAST:event_search1KeyTyped

    private void search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyReleased
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(rd1.isSelected()){
            if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
             if(search1.getText().length()==5){
                 search1.setText(search1.getText()+"-");
             }
             if(search1.getText().length()==13){
                 search1.setText(search1.getText()+"-");
             }
            }
        }
    }//GEN-LAST:event_search1KeyReleased

    private void search1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search1FocusGained
        // TODO add your handling code here:
        searcherr.setText(null);
    }//GEN-LAST:event_search1FocusGained

    private void search1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            search_button_task();
        }
    }//GEN-LAST:event_search1KeyPressed

    private void f2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f3.requestFocus();
        }
    }//GEN-LAST:event_f2KeyPressed

    private void f3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f3KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            SwingUtilities.invokeLater(() -> {
                f4.showPopup();
                f4.requestFocus();
            });
        }
    }//GEN-LAST:event_f3KeyPressed

    private void f4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f5.requestFocus();
        }
    }//GEN-LAST:event_f4KeyPressed

    private void f5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f6.requestFocus();
        }
    }//GEN-LAST:event_f5KeyPressed

    private void f6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f7.requestFocus();
        }
    }//GEN-LAST:event_f6KeyPressed

    private void f7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f7KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            SwingUtilities.invokeLater(() -> {
                f8.showPopup();
                f8.requestFocus();
            });
        }
    }//GEN-LAST:event_f7KeyPressed

    private void f8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f8KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f9.requestFocus();
        }
    }//GEN-LAST:event_f8KeyPressed

    private void f9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f9KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f10.requestFocus();
        }
    }//GEN-LAST:event_f9KeyPressed

    private void f10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f10KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f11.requestFocus();
        }
    }//GEN-LAST:event_f10KeyPressed

    private void f11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f11KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            f12.requestFocus();
        }
    }//GEN-LAST:event_f11KeyPressed

    private void f12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f12KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            data_insertion_action();
        }
    }//GEN-LAST:event_f12KeyPressed

    private void serupdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serupdateKeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
         if(rd5.isSelected()){
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
            uperror.setText("Enter only numbers");
        }else{
            if(serupdate.getText().length()>14){
                 evt.consume();
             }
             uperror.setText(null);
        }
         }
    }//GEN-LAST:event_serupdateKeyTyped

    private void serupdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serupdateKeyReleased
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(rd5.isSelected()){
            if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
             if(serupdate.getText().length()==5){
                 serupdate.setText(serupdate.getText()+"-");
             }
             if(serupdate.getText().length()==13){
                 serupdate.setText(serupdate.getText()+"-");
             }
            }
        }
    }//GEN-LAST:event_serupdateKeyReleased

    private void jLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseClicked
        // TODO add your handling code here:
        JFileChooser ch=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("jpg,png","jpg","png");
        ch.setFileFilter(filter);
        int choice=ch.showOpenDialog(this);
        if(choice==JFileChooser.APPROVE_OPTION){
            try{
            path=ch.getSelectedFile();
            mg = Files.readAllBytes(path.toPath());
            String p=path.getAbsolutePath();
            ImageIcon pc=new ImageIcon(new ImageIcon(p).getImage().getScaledInstance(upic.getWidth(),upic.getHeight(),java.awt.Image.SCALE_SMOOTH));
            upic.setIcon(pc);
            }catch(IOException e){
                System.out.print(e);
            }
        }
    }//GEN-LAST:event_jLabel86MouseClicked

    private void u5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u5KeyReleased
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
             if(u5.getText().length()==5){
                 u5.setText(u5.getText()+"-");
             }
             if(u5.getText().length()==13){
                 u5.setText(u5.getText()+"-");
             }
        }
    }//GEN-LAST:event_u5KeyReleased

    private void u5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u5KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
        }else{
            if(u5.getText().length()>14){
                 evt.consume();
             }
        }
    }//GEN-LAST:event_u5KeyTyped

    private void u6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u6KeyReleased
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(word=='@'){
            u6.setText(u6.getText()+"gmail.com");
            len=u6.getText().length();
            o=0;
        }
    }//GEN-LAST:event_u6KeyReleased

    private void u6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u6KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(word=='@'){
            mal=u6.getText();
        }
        if((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE){
            if(o==0){
            u6.setText(mal);
            o++;
            }
        }
        if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            if(u6.getText().length()>=len){
                evt.consume();
            }
        }
    }//GEN-LAST:event_u6KeyTyped

    private void u9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u9KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
        }else{
            if(u9.getText().length()>9){
                evt.consume();
            }
        }
    }//GEN-LAST:event_u9KeyTyped

    private void u11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u11KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_u11KeyTyped

    private void u7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u7KeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_u7KeyTyped

    private void pac7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac7MouseClicked
        // TODO add your handling code here:
        int sts=JOptionPane.showConfirmDialog(this,"Confirm to delete data","Confirm",JOptionPane.YES_NO_OPTION);
        if(sts==JOptionPane.YES_OPTION){
        if(database.delete_emp_account(s1.getText())==true){
           // JOptionPane.showMessageDialog(this,"Please Wait few Seconds","Info",JOptionPane.INFORMATION_MESSAGE);
            String df="Hello dear "+s3.getText()+"\nYour Sky Bank Employee account is deleted. Thanks to servive your imporatant time with SKY Bank. If you have any quiry then please contect with admin or send email on account given below\namirghafoorcss@gmail.com";
            dashboraddat();
            Thread t = new Thread(new Runnable(){
                public void run(){
                    if (net() == true) {
                        em.send(s7.getText(),df,"Message");
                    }
                }
            });
            t.start();
            JOptionPane.showMessageDialog(this,"Employee account deleted successfully","Info",JOptionPane.INFORMATION_MESSAGE);
            search.setVisible(true);
            entry2.setVisible(false);
        }else{
            search.setVisible(false);
            entry2.setVisible(true);
        }
            male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            updatepane.setVisible(false);
        }
    }//GEN-LAST:event_pac7MouseClicked

    private void pac9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac9MouseClicked
        // TODO add your handling code here:
        if(s2.getText().length()==6){
            JOptionPane.showMessageDialog(null,"Account is already Activated","Warnning",JOptionPane.WARNING_MESSAGE);
        }else{
        int sts=JOptionPane.showConfirmDialog(null,"Confirm to Activate this account","Confirm",JOptionPane.YES_NO_OPTION);
        if(sts==JOptionPane.YES_OPTION){
        if(database.account_status_update(s1.getText(),"Active")==true){
           // JOptionPane.showMessageDialog(this,"Please Wait few Seconds","Info",JOptionPane.INFORMATION_MESSAGE);
            String df="Hello dear "+s3.getText()+"\nYour Sky Bank Employee account is unblocked by admin\nWelcome again for join our service";
            Thread t = new Thread(new Runnable(){
                public void run(){
                    if (net() == true) {
                        em.send(s7.getText(),df,"Welcome");
                    }
                }
            });
            t.start();
            JOptionPane.showMessageDialog(this,"Employee account Unblock successfully","Info",JOptionPane.INFORMATION_MESSAGE);
            search_emp_data(s1.getText(),"id");
        }
        }
        }
    }//GEN-LAST:event_pac9MouseClicked

    private void pac10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac10MouseClicked
        // TODO add your handling code here:
        if(s2.getText().length()==5){
            JOptionPane.showMessageDialog(null,"Account is already Blocked","Warnning",JOptionPane.WARNING_MESSAGE);
        }else{
        int sts=JOptionPane.showConfirmDialog(null,"Confirm to Block this account","Confirm",JOptionPane.YES_NO_OPTION);
        if(sts==JOptionPane.YES_OPTION){
        if(database.account_status_update(s1.getText(),"Block")==true){
         //   JOptionPane.showMessageDialog(this,"Please Wait few Seconds","Info",JOptionPane.INFORMATION_MESSAGE);
           String df="Hello dear "+s3.getText()+"\nYour Sky Bank Employee account is blocked by admin\n"+"If you have any quiry then please contect with admin or send email on this account\namirghafoorcss@gmail.com";
           Thread t = new Thread(new Runnable(){
                public void run(){
                if (net() == true) {
                    em.send(s7.getText(),df,"Message");
                   }
                }
            });
            t.start();
            search_emp_data(s1.getText(),"id");
            JOptionPane.showMessageDialog(this,"Employee account Blocked successfully","Info",JOptionPane.INFORMATION_MESSAGE);
      }
        }
        }
    }//GEN-LAST:event_pac10MouseClicked

    private void serupdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serupdateKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            update_search_button_task();
        }
    }//GEN-LAST:event_serupdateKeyPressed

    private void d1_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_2MouseClicked
        // TODO add your handling code here:
        back_rule2="home";
        male_employee_details("s","n","","");
        male_emp.setVisible(true);
        jTextField1.requestFocus();
        male_profile_panel.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_d1_2MouseClicked

    private void male_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_male_tableMouseClicked
        // TODO add your handling code here:
        int i=male_table.getSelectedRow();
        int column = 1;
        String value = male_table.getModel().getValueAt(i, column).toString();
        male_profile_show(value,"id");
        back_rule="male";
        male_profile_panel.setVisible(true);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
        
    }//GEN-LAST:event_male_tableMouseClicked

    private void d2_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2_2MouseClicked
        // TODO add your handling code here:
        back_rule2="home";
        female_employee_details("lsa","sd","","");
        female_emp.setVisible(true);
        jTextField7.requestFocus();
        home_pnl.setVisible(false);
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_d2_2MouseClicked

    private void d3_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d3_2MouseClicked
        // TODO add your handling code here:
        active_employee_details("null","null");
        active_emp.setVisible(true);
        jTextField5.requestFocus();
        home_pnl.setVisible(false);
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_d3_2MouseClicked

    private void d1_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_4MouseClicked
        // TODO add your handling code here:
        total_employee_details("sa","a","","");
        total_emplyee.setVisible(true);
        jTextField6.requestFocus();
        p1.setVisible(false);
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_d1_4MouseClicked

    private void d1_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_6MouseClicked
        // TODO add your handling code here:
        back_rule2="1234";
        male_employee_details("ds","sa","a","");
        male_emp.setVisible(true);
        jTextField1.requestFocus();
        p1.setVisible(false);
        male_profile_panel.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_d1_6MouseClicked

    private void d1_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_8MouseClicked
        // TODO add your handling code here:
        back_rule2="1234";
        female_employee_details("lsa","sd","","");
        female_emp.setVisible(true);
        jTextField7.requestFocus();
        p1.setVisible(false);
        male_profile_panel.setVisible(false);
        male_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_d1_8MouseClicked

    private void female_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_female_tableMouseClicked
        // TODO add your handling code here:
        int i=female_table.getSelectedRow();
        int column = 1;
        String value = female_table.getModel().getValueAt(i, column).toString();
        male_profile_show(value,"id");
        back_rule="female";
        male_profile_panel.setVisible(true);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_female_tableMouseClicked

    private void all_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_tableMouseClicked
        // TODO add your handling code here:
        int i=all_table.getSelectedRow();
        int column = 1;
        String value = all_table.getModel().getValueAt(i, column).toString();
        male_profile_show(value,"id");
        back_rule="all";
        male_profile_panel.setVisible(true);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_all_tableMouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
        if("all".equals(back_rule)){
            male_emp.setVisible(false);
            female_emp.setVisible(false);
            total_emplyee.setVisible(true);
            active_emp.setVisible(false);
        }
        if("active".equals(back_rule)){
            male_emp.setVisible(false);
            female_emp.setVisible(false);
            total_emplyee.setVisible(false);
            active_emp.setVisible(true);
        }
        if("female".equals(back_rule)){
            male_emp.setVisible(false);
            female_emp.setVisible(true);
            total_emplyee.setVisible(false);
            active_emp.setVisible(false);
        }
        if("male".equals(back_rule)){
            male_emp.setVisible(true);
            female_emp.setVisible(false);
            total_emplyee.setVisible(false);
            active_emp.setVisible(false);
        }
            male_profile_panel.setVisible(false);
            up_search.setVisible(false);
            p1.setVisible(false);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
        
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MouseClicked
        // TODO add your handling code here:
        if(back_rule2=="home"){
            p1.setVisible(false);
            home_pnl.setVisible(true);
        }else{
            p1.setVisible(true);
            home_pnl.setVisible(false);
        }
        male_emp.setVisible(false);
        empy();
        male_profile_panel.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_jPanel42MouseClicked

    private void jPanel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel44MouseClicked
        // TODO add your handling code here:
        male_emp.setVisible(false);
        male_profile_panel.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        empy();
        up_search.setVisible(false);
        p1.setVisible(true);
            home_pnl.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_jPanel44MouseClicked

    private void jPanel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseClicked
        // TODO add your handling code here:
        male_emp.setVisible(false);
        jTextField5.setText(null);
        male_profile_panel.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(true);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_jPanel33MouseClicked

    private void jPanel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseClicked
        // TODO add your handling code here:
        if(back_rule2=="home"){
            p1.setVisible(false);
            home_pnl.setVisible(true);
        }else{
            p1.setVisible(true);
            home_pnl.setVisible(false);
        }
        male_emp.setVisible(false);
        empy();
        male_profile_panel.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            entry.setVisible(false);
            entry2.setVisible(false);
            search.setVisible(false);
            updatepane.setVisible(false);
    }//GEN-LAST:event_jPanel43MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        JFileChooser ch=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("jpg,png","jpg","png");
        ch.setFileFilter(filter);
        int choice=ch.showOpenDialog(this);
        if(choice==JFileChooser.APPROVE_OPTION){
            File pah=ch.getSelectedFile();
            String p=pah.getAbsolutePath();
            if(database.admin_account_profile_update(pah)==true){
                JOptionPane.showMessageDialog(this,"Profile image change successfully","Info",JOptionPane.INFORMATION_MESSAGE);
                ImageIcon pc=new ImageIcon(new ImageIcon(p).getImage().getScaledInstance(apro.getWidth(),apro.getHeight(),java.awt.Image.SCALE_SMOOTH));
               apro.setIcon(pc);
               admin_profile();
            }
        }
        
    }//GEN-LAST:event_jLabel17MouseClicked
void admin_pass_change(){
        String pas1=oldpass.getText();
        String pas2=newpass1.getText();
        String pas3=newpass2.getText();
        if(oldpass.getText().isEmpty() || newpass1.getText().isEmpty() || newpass2.getText().isEmpty()){
            if(oldpass.getText().isEmpty()){
                olderr.setText("Enter old password");
            }
            if(newpass1.getText().isEmpty()){
                newerr1.setText("Enter new password");
            }
            if(newpass2.getText().isEmpty()){
                newerr2.setText("Enter Confirm password");
            }
        }else{
         if(fth.getPassword_admin(pas1,"amirghafoorcss@gmail.com")==true){
            if(pas2.length()>=8){
                if(pas3.length()>=8){
                    if(pas2.equals(pas3)){
                        java.util.Date nowdate = new java.util.Date(); 
                       String drt="Hello dear Amir!\nYour Sky Bank account password is changed at "+String.valueOf(nowdate);
                        if(database.admin_account_password_update(pas2,"amirghafoorcss@gmail.com")==true){
                         Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                            em.send(jLabel21.getText(),drt,"Security Alert");
                            }
                        }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this,"Passowrd changed successfully","Info",JOptionPane.INFORMATION_MESSAGE);
                         oldpass.setText(null);
                         newpass1.setText(null);
                         newpass2.setText(null);
                        }else{
                            JOptionPane.showMessageDialog(this,"Passowrd not change","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        newerr2.setText("Confirm Password not matched");
                    }
                }else{
                    newerr2.setText("Password lenght must be 8");
                }
            }else{
                newerr1.setText("Password lenght must be 8");
            }
        }else{
            olderr.setText("Old password did't match");
        }
        }
}
    private void pac2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac2MouseClicked
        // TODO add your handling code here:
        admin_pass_change();
    }//GEN-LAST:event_pac2MouseClicked

    private void oldpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldpassFocusGained
        // TODO add your handling code here:
        olderr.setText(null);
    }//GEN-LAST:event_oldpassFocusGained

    private void newpass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newpass1FocusGained
        // TODO add your handling code here:
        newerr1.setText(null);
    }//GEN-LAST:event_newpass1FocusGained

    private void newpass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newpass2FocusGained
        // TODO add your handling code here:
        newerr2.setText(null);
    }//GEN-LAST:event_newpass2FocusGained

    private void oldpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldpassKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                newpass1.requestFocus();
        }
    }//GEN-LAST:event_oldpassKeyPressed

    private void newpass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                newpass2.requestFocus();
        }
    }//GEN-LAST:event_newpass1KeyPressed

    private void newpass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpass2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        admin_pass_change();
        }
    }//GEN-LAST:event_newpass2KeyPressed

    private void jPanel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel45MouseClicked

        if("home".equals(back_rule2)){
            home_pnl.setVisible(true);
            
        }else{
            p4.setVisible(true);
        }
        empy();
        jPanel10.setVisible(false);
    }//GEN-LAST:event_jPanel45MouseClicked

    private void d7_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_4MouseClicked
        // TODO add your handling code here:
        back_rule2="panel";
        like_s = "all";
        account_history_datils("all", "", "", "", "");
        jPanel10.setVisible(true);
        jTextField4.requestFocus();
        p4.setVisible(false);
    }//GEN-LAST:event_d7_4MouseClicked

    private void d8_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_4MouseClicked
        // TODO add your handling code here:
        back_rule2="panel";
        like_s = "d";
        account_history_datils("deposit", "", "", "", "");
        jPanel10.setVisible(true);
        jTextField4.requestFocus();
        p4.setVisible(false);
    }//GEN-LAST:event_d8_4MouseClicked

    private void d9_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_4MouseClicked
        // TODO add your handling code here:
        back_rule2="panel";
        like_s = "w";
        account_history_datils("withdraw", "", "", "", "");
        jPanel10.setVisible(true);
        jTextField4.requestFocus();
        p4.setVisible(false);
    }//GEN-LAST:event_d9_4MouseClicked

    private void jPanel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel46MouseClicked
          main_profile.setVisible(false);
          if("accnt".equals(back_rule)){
            accounts_pnl.setVisible(true);
            jTextField3.requestFocus();
        }
        if("atmacc".equals(back_rule)){
            atm_table_pnl.setVisible(true);
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jPanel46MouseClicked

    private void jPanel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel47MouseClicked

        if(back_rule2.equals("home")){
            home_pnl.setVisible(true);
        }else{
            p2.setVisible(true);
        }
        empy();
        accounts_pnl.setVisible(false);
    }//GEN-LAST:event_jPanel47MouseClicked

    private void jPanel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseClicked
        // TODO add your handling code here:
        if(back_rule2.equals("home")){
            home_pnl.setVisible(true);
        }
        else{
            p2.setVisible(true);
        }
        empy();
        atm_table_pnl.setVisible(false);
      
    }//GEN-LAST:event_jPanel48MouseClicked

    private void search1jFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search1jFocusGained
        // TODO add your handling code here:
        searcherr.setText(null);
    }//GEN-LAST:event_search1jFocusGained

    private void search1jKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1jKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(search1j.getText().isEmpty()){
                searcherr1.setText("Please enter data for searching");
            }else{
             search_button_task2();
            }
        }
    }//GEN-LAST:event_search1jKeyPressed

    private void search1jKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1jKeyReleased
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(rd11.isSelected()){
            if(!((word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE)){
                if(search1j.getText().length()==5){
                    search1j.setText(search1j.getText()+"-");
                }
                if(search1j.getText().length()==13){
                    search1j.setText(search1j.getText()+"-");
                }
            }
        }
    }//GEN-LAST:event_search1jKeyReleased

    private void search1jKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1jKeyTyped
        // TODO add your handling code here:
        char word=evt.getKeyChar();
        if(rd11.isSelected()){
            if(!(Character.isDigit(word)||(word==KeyEvent.VK_BACK_SPACE)||word==KeyEvent.VK_DELETE ||word==KeyEvent.VK_ENTER)){
                evt.consume();
                getToolkit().beep();
                searcherr1.setText("Enter only numbers");
            }else{
                if(search1j.getText().length()>14){
                    evt.consume();
                }
                searcherr1.setText(null);
            }
        }
    }//GEN-LAST:event_search1jKeyTyped
void search_button_task2(){
            if(search1j.getText().isEmpty()){
                search_acc.setVisible(true);
                searcherr1.setText("Please enter data for searching");
            }else{
            if(rd11.isSelected()){
                if(act.check_account(search1j.getText(),"cnic")==true){
                    search_account_data(search1j.getText(),"cnic");
                    search_acc.setVisible(false);
                    action_acc.setVisible(true);
                }else{
                    search_acc.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Account record not found", "Info",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(rd32.isSelected()){
                String typ=null;
                    typ="account";
                    if(act.check_account(search1j.getText(),"account")==true){
                    search_account_data(search1j.getText(),typ);
                    search_acc.setVisible(false);
                    action_acc.setVisible(true);
                }else{
                    search_acc.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Bank Account record not found", "Info",JOptionPane.ERROR_MESSAGE);
                }
            }
            }
   }
    private void jPanel27jjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27jjMouseClicked
        // TODO add your handling code her
        search_button_task2();
    }//GEN-LAST:event_jPanel27jjMouseClicked

    private void jPanel27jjMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27jjMouseEntered
        // TODO add your handling code here:
        jPanel27jj.setBackground(new Color(0,204,0));
        jLabel66.setForeground(Color.white);
        jPanel27jj.setToolTipText("Search account data");
    }//GEN-LAST:event_jPanel27jjMouseEntered

    private void jPanel27jjMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27jjMouseExited
        // TODO add your handling code here:
        jPanel27jj.setBackground(new Color(240,240,240));
        jLabel66.setForeground(Color.black);
    }//GEN-LAST:event_jPanel27jjMouseExited

    private void rd32redio_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd32redio_action
        // TODO add your handling code here:
       rd11.setSelected(false);
          rd32.setSelected(true);
        search1j.setText("");
        searcherr1.setText(null);
        search1j.requestFocus();
    }//GEN-LAST:event_rd32redio_action

    private void rd11redio_action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd11redio_action
        // TODO add your handling code here:
        rd11.setSelected(true);
        rd32.setSelected(false);
        search1j.setText("");
        searcherr1.setText(null);
        search1j.requestFocus();
    }//GEN-LAST:event_rd11redio_action

    private void jPanel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel49MouseClicked
        // TODO add your handling code here:
        search_acc.setVisible(false);
        search1j.setText(null);
        rd11.setSelected(true);
        rd32.setSelected(false);
        searcherr1.setText(null);
        p2.setVisible(true);
    }//GEN-LAST:event_jPanel49MouseClicked

    private void jPanel49MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel49MouseEntered
        // TODO add your handling code here:
        jLabel68.setForeground(Color.blue);
    }//GEN-LAST:event_jPanel49MouseEntered

    private void jPanel49MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel49MouseExited
        // TODO add your handling code here:
        jLabel68.setForeground(Color.black);
    }//GEN-LAST:event_jPanel49MouseExited

    private void jPanel23wMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23wMouseClicked
        // TODO add your handling code here:
        search_acc.setVisible(true);
        action_acc.setVisible(false);
        search1j.setText(null);
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
        if(evt.getSource()==pac101){
            pac101.setBackground(new Color(255,102,102));
            jLabel59.setForeground(Color.white);
        }
        if(evt.getSource()==pac77){
            pac77.setBackground(new Color(255,102,102));
            jLabel56.setForeground(Color.white);
        }
    }//GEN-LAST:event_action_accred_menter

    private void action_accred_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_accred_mexit
        // TODO add your handling code here:
        if(evt.getSource()==pac101){
            pac101.setBackground(new Color(240,240,240));
            jLabel59.setForeground(Color.black);
        }
        if(evt.getSource()==pac77){
            pac77.setBackground(new Color(240,240,240));
            jLabel56.setForeground(Color.black);
        }
    }//GEN-LAST:event_action_accred_mexit

    private void action_accounts(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_accounts
        // TODO add your handling code here:
        p2.setVisible(false);
        search_acc.setVisible(true);
        search1j.requestFocus();
    }//GEN-LAST:event_action_accounts

    private void d1_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_10MouseClicked
        // TODO add your handling code here:
        back_rule2="panel";
        like_s = "c";
        bank_account_datils("current", "", "",null,null);
        save_type = "Current Bank accounts list";
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        p2.setVisible(false);
    }//GEN-LAST:event_d1_10MouseClicked

    private void d1_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_12MouseClicked
        // TODO add your handling code here:
        back_rule2="panel";
        like_s = "s";
        bank_account_datils("saving", "", "",null,null);
        save_type = "Saving Bank accounts list";
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        p2.setVisible(false);
    }//GEN-LAST:event_d1_12MouseClicked

    private void d1_14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1_14MouseClicked
        // TODO add your handling code here:
        like_s = "all";
        atm_account_datils("all", "", "","","");
        save_type = "ATM accounts list";
        back_rule2="panel";
        atm_table_pnl.setVisible(true);
        jTextField2.requestFocus();
        p2.setVisible(false);
    }//GEN-LAST:event_d1_14MouseClicked

    private void d7_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7_2MouseClicked
        // TODO add your handling code here:
        back_rule2="home";
        like_s = "all";
        account_history_datils("all", "", "", "", "");
        jPanel10.setVisible(true);
        jTextField4.requestFocus();
        home_pnl.setVisible(false);
    }//GEN-LAST:event_d7_2MouseClicked

    private void d8_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8_2MouseClicked
        // TODO add your handling code here:
        back_rule2="home";
        like_s = "d";
        account_history_datils("deposit", "", "", "", "");
        jPanel10.setVisible(true);
        jTextField4.requestFocus();
        home_pnl.setVisible(false);
    }//GEN-LAST:event_d8_2MouseClicked

    private void d9_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9_2MouseClicked
        // TODO add your handling code here:
        back_rule2="home";
        like_s = "w";
        account_history_datils("withdraw", "", "", "", "");
        jPanel10.setVisible(true);
        jTextField4.requestFocus();
        home_pnl.setVisible(false);
    }//GEN-LAST:event_d9_2MouseClicked

    private void d4_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d4_2MouseClicked
        // TODO add your handling code here:
        back_rule2="home";
        like_s = "c";
        bank_account_datils("current", "", "",null,null);
        save_type = "Current Bank accounts list";
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        home_pnl.setVisible(false);
    }//GEN-LAST:event_d4_2MouseClicked

    private void d6_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d6_2MouseClicked
        // TODO add your handling code here:
        back_rule2="home";
        like_s = "s";
        bank_account_datils("saving", "", "",null,null);
        save_type = "Saving Bank accounts list";
        accounts_pnl.setVisible(true);
        jTextField3.requestFocus();
        home_pnl.setVisible(false);
    }//GEN-LAST:event_d6_2MouseClicked

    private void d5_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d5_2MouseClicked
        // TODO add your handling code here:
        like_s = "all";
        atm_account_datils("all", "", "","","");
        save_type = "ATM accounts list";
        back_rule2="home";
        atm_table_pnl.setVisible(true);
        jTextField2.requestFocus();
        home_pnl.setVisible(false);
    }//GEN-LAST:event_d5_2MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        int u=JOptionPane.showConfirmDialog(null,"Confirm to logout","Confirm",JOptionPane.YES_NO_OPTION);
        if(u==JOptionPane.YES_OPTION){
             JLabel messageLabel = new JLabel("<html><body><p style='width: 180px;'>"+"Please wait...."+"</p></body></html>");
        Timer timr = new Timer(3000, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messageLabel).dispose();
        });
        timr.setRepeats(false);
        timr.start();
        JOptionPane.showOptionDialog(null, messageLabel,"Message", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
        login gh=new login();
        gh.setVisible(true);
        gh.lgn();
        this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
                    headers[3]="Time";
                    headers[4]="Date";
                    headers[5]="History Type";
                    headers[6]="Amount";
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

    private void pac77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac77MouseClicked
        // TODO add your handling code here
            int sts = JOptionPane.showConfirmDialog(this, "Confirm to delete Account", "Confirm", JOptionPane.YES_NO_OPTION);
            if (sts == JOptionPane.YES_OPTION) {
                if (act.delete_account(s1f.getText()) == true) {
                   // JOptionPane.showMessageDialog(this, "Please Wait few Seconds", "Info", JOptionPane.INFORMATION_MESSAGE);
                    String df = "Hello dear " + s3f.getText() + "\nYour Sky Bank account is deleted. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                    dashboraddat();
                    Thread t = new Thread(new Runnable(){
                        public void run(){
                            if (net() == true) {
                                em.send(s7f.getText(), df, "Message");
                                }
                        }
                    });
                    t.start();
                    JOptionPane.showMessageDialog(this, "Account deleted successfully","Info",JOptionPane.INFORMATION_MESSAGE);
                    search_acc.setVisible(true);
                    action_acc.setVisible(false);
                } else {
                    search_acc.setVisible(false);
                    action_acc.setVisible(true);
                }
                main_profile.setVisible(false);
                accounts_pnl.setVisible(false);
                atm_table_pnl.setVisible(false);
            }
    }//GEN-LAST:event_pac77MouseClicked

    private void pac77red_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac77red_menter
        pac77.setBackground(new Color(255, 102, 102));
        jLabel56.setForeground(Color.white);
        pac77.setToolTipText("Delete account");
    }//GEN-LAST:event_pac77red_menter

    private void pac77red_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac77red_mexit
        // TODO add your handling code here:
        pac77.setBackground(new Color(240, 240, 240));
        jLabel56.setForeground(Color.black);
    }//GEN-LAST:event_pac77red_mexit

    private void pac99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac99MouseClicked
        // TODO add your handling code here:
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
                        String df = "Hello dear " + s3f.getText() + " !\nYour Sky Bank account is unblocked\nWelcome again for join our service";
                        dashboraddat();
                        search_account_data(s1f.getText(), "account");
                        Thread t = new Thread(new Runnable(){
                            public void run(){
                                if (net() == true) {
                                    em.send(s7f.getText(), df, "Welcome");
                                    }
                           }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "Account Unblock successfully","Info",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
    }//GEN-LAST:event_pac99MouseClicked

    private void pac99blu_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac99blu_menter
        // TODO add your handling code here:
        if (evt.getSource() == pac99) {
            pac99.setBackground(new Color(102, 102, 255));
            jLabel58.setForeground(Color.white);
            pac99.setToolTipText("Unlock account");
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
                    //    JOptionPane.showMessageDialog(this, "Please Wait few Seconds", "Info", JOptionPane.INFORMATION_MESSAGE);
                        String df = "Hello dear " + s3f.getText() + " !\nYour Sky Bank account is blocked. If you have any quiry then please contect with admin or send email on email account given below\namirghafoorcss@gmail.com";
                        search_account_data(s1f.getText(), "account");
                        dashboraddat();
                        Thread t = new Thread(new Runnable(){
                            public void run(){
                                if (net() == true) {
                                    em.send(s7f.getText(), df, "Message");
                                    }
                           }
                        });
                        t.start();
                        JOptionPane.showMessageDialog(this, "Account Blocked successfully","Info",JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
            }
    }//GEN-LAST:event_pac101MouseClicked

    private void pac101red_menter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac101red_menter
        // TODO add your handling code here:
        pac101.setBackground(new Color(255, 102, 102));
        jLabel59.setForeground(Color.white);
        pac101.setToolTipText("Block account");
    }//GEN-LAST:event_pac101red_menter

    private void pac101red_mexit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pac101red_mexit

        pac101.setBackground(new Color(240, 240, 240));
        jLabel59.setForeground(Color.black);
    }//GEN-LAST:event_pac101red_mexit
void empy() {
        jDateChooser5.setDate(null);
        jTextField5.setText(null);
        jDateChooser6.setDate(null);
        jDateChooser9.setDate(null);
        jDateChooser11.setDate(null);
        jDateChooser12.setDate(null);
        jDateChooser10.setDate(null);
        jTextField7.setText(null);
        jTextField6.setText(null);
        jDateChooser7.setDate(null);
        jDateChooser8.setDate(null);
        jTextField2.setText(null);
        jDateChooser4.setDate(null);
        jDateChooser3.setDate(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jTextField4.setText(null);
        jTextField3.setText(null);
        jTextField1.setText("");
    }
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
                    BufferedImage img = new BufferedImage(aspane5.getWidth(), aspane5.getHeight(), BufferedImage.TYPE_INT_RGB);
                    aspane5.paint(img.getGraphics());
                    ImageIO.write(img, "png", new File(theFileToSave + ".png"));
                    JOptionPane.showMessageDialog(this, "Profile data saved successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | IOException ex) {
                    System.out.print(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
        action_acc.setVisible(false);
        search_acc.setVisible(false);
    }//GEN-LAST:event_accounts_tableMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
void pdf_emp_acc(JTable tb, String name,String from,String to) {
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
                            if (cols == 5) {
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

    private void atm_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm_tableMouseClicked
        // TODO add your handling code here:
        int i = atm_table.getSelectedRow();
        int column = 2;
        String value = atm_table.getModel().getValueAt(i, column).toString();
        account_data_all(value, "account");
        back_rule = "atmacc";
        main_profile.setVisible(true);
        accounts_pnl.setVisible(false);
        atm_table_pnl.setVisible(false);
        action_acc.setVisible(false);
        search_acc.setVisible(false);
    }//GEN-LAST:event_atm_tableMouseClicked

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

    private void jDateChooser5PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser5PropertyChange
        // TODO add your handling code here:
        if(jDateChooser5.getDate()!=null){
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
                    BufferedImage img = new BufferedImage(aspane6.getWidth(), aspane6.getHeight(), BufferedImage.TYPE_INT_RGB);
                    aspane6.paint(img.getGraphics());
                    ImageIO.write(img, "png", new File(theFileToSave + ".png"));
                    JOptionPane.showMessageDialog(this, "Profile data saved successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | IOException ex) {
                    System.out.print(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        if(jTextField5.getText().isEmpty()){
            active_employee_details(null,null);
        }else{
            active_employee_details("like",jTextField5.getText());
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            String dit=null;
        if (jTextField6.getText().isEmpty()) {
            if(jDateChooser9.getDate()!=null){
            if(jDateChooser10.getDate()!=null){
                drt = date1.format(jDateChooser10.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser9.getDate());
            total_employee_details("date","a",dit,drt);
        }else{
                total_employee_details("sa","a","","");
            }
        }else{
             if(jDateChooser9.getDate()!=null){
            if(jDateChooser10.getDate()!=null){
                drt = date1.format(jDateChooser10.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser9.getDate());
            total_employee_details("date_s",jTextField6.getText(),dit,drt);
        }else{
            total_employee_details("like",jTextField6.getText(),"","");
             }
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            String dit=null;
        if(jTextField1.getText().isEmpty()){
            if(jDateChooser7.getDate()!=null){
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser7.getDate());
            male_employee_details("date","a",dit,drt);
            }else{
                male_employee_details("s","a","","");
            }
        }else{
            if(jDateChooser7.getDate()!=null){
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser7.getDate());
            male_employee_details("date_s",jTextField1.getText(),dit,drt);
            }else{
             male_employee_details("like",jTextField1.getText(),"","");
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            String drt=null;
            String dit=null;
        if(jTextField7.getText().isEmpty()){
            if(jDateChooser11.getDate()!=null){
            if(jDateChooser12.getDate()!=null){
                drt = date1.format(jDateChooser12.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser11.getDate());
            female_employee_details("date","",dit,drt);
        }else{
             female_employee_details("sa","s","","");
         }
        }else{
            if(jDateChooser11.getDate()!=null){
            if(jDateChooser12.getDate()!=null){
                drt = date1.format(jDateChooser12.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser11.getDate());
            female_employee_details("date_s",jTextField7.getText(),dit,drt);
        }else{
           female_employee_details("like",jTextField7.getText(),"",""); 
            }
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String dit=null;
        String drt=null;
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
        pdf_emp_acc(male_table,"Male employees record",dit,drt);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jDateChooser7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser7PropertyChange
        // TODO add your handling code here:
        String dit=null;
        String drt=null;
        jTextField1.setText(null);
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date();
        if(jDateChooser7.getDate()!=null){
            if(jDateChooser8.getDate()!=null){
                drt = date1.format(jDateChooser8.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser7.getDate());
            male_employee_details("date",jTextField1.getText(),dit,drt);
        }else{
            if(dit!=null){
              male_employee_details("","","","");
            }
        }
    }//GEN-LAST:event_jDateChooser7PropertyChange

    private void jDateChooser8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser8PropertyChange
        // TODO add your handling code here:
        String dit=null;
        String drt=null;
        jTextField1.setText(null);
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        if(jDateChooser7.getDate()!=null && jDateChooser8.getDate()!=null){
            drt = date1.format(jDateChooser8.getDate());
            dit = date1.format(jDateChooser7.getDate());
            male_employee_details("date",jTextField1.getText(),dit,drt);
        }else{
            if(dit!=null){
              male_employee_details("","","","");
            }
        }
    }//GEN-LAST:event_jDateChooser8PropertyChange

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jDateChooser7.setDate(null);
        jDateChooser8.setDate(null);
        jTextField1.setText(null);
        male_employee_details("","","","");
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String dit=null;
        String drt=null;
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date();
        if (jDateChooser9.getDate()!=null) {
            if(jDateChooser10.getDate()!=null){
                drt = date1.format(jDateChooser10.getDate());
            }else{
                drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser9.getDate());
        }else{
            drt=String.valueOf(date1.format(nowdate));
        }
        pdf_emp_acc(all_table,"Employees record",dit,drt);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jDateChooser9PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser9PropertyChange
        // TODO add your handling code here:
        jTextField6.setText(null);
        String drt=null;
        if(jDateChooser9.getDate()!=null){
            //SimpleDateFormat date1=new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            if(jDateChooser10.getDate()!=null){
                drt = date1.format(jDateChooser10.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser9.getDate());
          total_employee_details("date","a",dit,drt);
        }else{
            if(drt!=null){
                total_employee_details("","a","","");
            }
        }
    }//GEN-LAST:event_jDateChooser9PropertyChange

    private void jDateChooser10PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser10PropertyChange
        // TODO add your handling code here:
        jTextField6.setText(null);
        String drt=null;
        if(jDateChooser9.getDate()!=null && jDateChooser10.getDate()!=null){
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            drt = date1.format(jDateChooser10.getDate());
            String dit = date1.format(jDateChooser9.getDate());
          total_employee_details("date","a",dit,drt);
        }else{
            if(drt!=null){
                total_employee_details("","a","","");
            }
        }
    }//GEN-LAST:event_jDateChooser10PropertyChange

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        jDateChooser9.setDate(null);
        jDateChooser10.setDate(null);
        jTextField6.setText(null);
        total_employee_details("","a","","");
        jTextField6.requestFocus();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jDateChooser11PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser11PropertyChange
        // TODO add your handling code here:
        jTextField7.setText(null);
        String drt=null;
        if(jDateChooser11.getDate()!=null){
            //SimpleDateFormat date1=new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date nowdate = new java.util.Date(); 
            
            if(jDateChooser12.getDate()!=null){
                drt = date1.format(jDateChooser12.getDate());
            }else{
              drt=String.valueOf(date1.format(nowdate));
            }
            String dit = date1.format(jDateChooser11.getDate());
            female_employee_details("date","",dit,drt);
        }else{
            if(drt!=null){
                female_employee_details("","","","");
            }
        }
    }//GEN-LAST:event_jDateChooser11PropertyChange

    private void jDateChooser12PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser12PropertyChange
        // TODO add your handling code here:
        jTextField7.setText(null);
        String drt=null;
        if(jDateChooser11.getDate()!=null && jDateChooser12.getDate()!=null){
            SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
            drt = date1.format(jDateChooser12.getDate());
            String dit = date1.format(jDateChooser11.getDate());
            female_employee_details("date","",dit,drt);
        }else{
            if(drt!=null){
                female_employee_details("","","","");
            }
        }
    }//GEN-LAST:event_jDateChooser12PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String dit=null;
        String drt=null;
        SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date();
        if (jDateChooser11.getDate()!=null) {
            if(jDateChooser12.getDate()!=null){
                drt = date1.format(jDateChooser12.getDate());
            }else{
                drt=String.valueOf(date1.format(nowdate));
            }
            dit = date1.format(jDateChooser11.getDate());
        }else{
            drt=String.valueOf(date1.format(nowdate));
        }
        pdf_emp_acc(female_table,"Female employees record",dit,drt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        jDateChooser11.setDate(null);
        jDateChooser12.setDate(null);
        jTextField7.setText(null);
        female_employee_details("sa","s","","");
        jTextField7.requestFocus();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        pdf_emp_acc(active_table,"Active employees record","","");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s7ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(s3.getText()));
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
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(m3.getText()));
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
    }//GEN-LAST:event_jButton17ActionPerformed

    private void m12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m12ActionPerformed

    private void active_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_active_tableMouseClicked
        // TODO add your handling code here:
        int i=active_table.getSelectedRow();
        int column = 1;
        String value = active_table.getModel().getValueAt(i, column).toString();
        male_profile_show(value,"id");
        back_rule="active";
        male_profile_panel.setVisible(true);
        male_emp.setVisible(false);
        female_emp.setVisible(false);
        total_emplyee.setVisible(false);
        active_emp.setVisible(false);
        up_search.setVisible(false);
        p1.setVisible(false);
            home_pnl.setVisible(false);
    }//GEN-LAST:event_active_tableMouseClicked

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        jButton9.setToolTipText("Save profile data as PNG");
    }//GEN-LAST:event_jButton9MouseEntered

    private void rd11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd11MouseEntered
        // TODO add your handling code here:
        rd11.setToolTipText("Search account data by CNIC");
    }//GEN-LAST:event_rd11MouseEntered

    private void rd32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd32MouseEntered
        // TODO add your handling code here:
        rd32.setToolTipText("Search account data by Account number");
    }//GEN-LAST:event_rd32MouseEntered

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        // TODO add your handling code here:
        jTextField2.setToolTipText("Search data by typing name words");
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        jPanel6.setToolTipText("Perform action using features on board");
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jPanel3.setToolTipText("Perform action using features on board");
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        // TODO add your handling code here:
        jButton16.setToolTipText("Save profile data as PNG");
    }//GEN-LAST:event_jButton16MouseEntered

    private void s4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s4MouseEntered
        // TODO add your handling code here:
        s4.setToolTipText("Date format (dd/MM/YYYY)");
    }//GEN-LAST:event_s4MouseEntered

    private void joindateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joindateMouseEntered
        // TODO add your handling code here:
        joindate.setToolTipText("Date format (MM/dd/YYYY)");
    }//GEN-LAST:event_joindateMouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setToolTipText("Save data as PDF file");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        // TODO add your handling code here:
        jButton1.setToolTipText("Refresh table");
    }//GEN-LAST:event_jButton14MouseEntered

    private void jTextField6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseEntered
        // TODO add your handling code here:
        jTextField6.setToolTipText("Search data by name words");
    }//GEN-LAST:event_jTextField6MouseEntered

    private void jDateChooser9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser9MouseEntered
        // TODO add your handling code here:
        jDateChooser9.setToolTipText("Enter start date where you want to search data");
    }//GEN-LAST:event_jDateChooser9MouseEntered

    private void jDateChooser10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser10MouseEntered
        // TODO add your handling code here:
        jDateChooser10.setToolTipText("Enter end date (Data will search from given start date and given end date)");
    }//GEN-LAST:event_jDateChooser10MouseEntered

    private void atm_date1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atm_date1MouseEntered
        // TODO add your handling code here:
        if(!(atm_date1.getText().equals("Not Registered"))){
        atm_date1.setToolTipText("Date Formate (MM/dd/yyyy)");
    }
    }//GEN-LAST:event_atm_date1MouseEntered

    private void s4zfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s4zfMouseEntered
        // TODO add your handling code here:
        s4zf.setToolTipText("Date Formate (dd/MM/yyyy)");
    }//GEN-LAST:event_s4zfMouseEntered

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

    private void m9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m9MouseEntered
        // TODO add your handling code here:
        m9.setToolTipText("Date format (MM/dd/yyyy)");
    }//GEN-LAST:event_m9MouseEntered

    private void m4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m4MouseEntered
        // TODO add your handling code here:
         m4.setToolTipText("Date format (dd/MM/yyyy)");
    }//GEN-LAST:event_m4MouseEntered

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
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
    private javax.swing.JPanel ac10;
    private javax.swing.JPanel ac2;
    private javax.swing.JPanel ac3;
    private javax.swing.JPanel ac4;
    private javax.swing.JPanel ac5;
    private javax.swing.JPanel ac6;
    private javax.swing.JPanel ac7;
    private javax.swing.JPanel ac8;
    private javax.swing.JPanel ac9;
    private javax.swing.JPanel accounts_pnl;
    private javax.swing.JTable accounts_table;
    private javax.swing.JPanel action_acc;
    private javax.swing.JPanel active_emp;
    private javax.swing.JTable active_table;
    private javax.swing.JTable all_table;
    private javax.swing.JLabel apro;
    private javax.swing.JPanel aspane;
    private javax.swing.JPanel aspane1;
    private javax.swing.JPanel aspane2;
    private javax.swing.JPanel aspane3;
    private javax.swing.JPanel aspane5;
    private javax.swing.JPanel aspane6;
    private javax.swing.JTextField atm_date;
    private javax.swing.JTextField atm_date1;
    private javax.swing.JTable atm_table;
    private javax.swing.JPanel atm_table_pnl;
    private javax.swing.JLabel b1;
    private javax.swing.JLabel b11;
    private javax.swing.JLabel b12;
    private javax.swing.JLabel b13;
    private javax.swing.JLabel b14;
    private javax.swing.JLabel b15;
    private javax.swing.JLabel b2;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel b4;
    private javax.swing.JLabel b5;
    private javax.swing.JLabel b6;
    private javax.swing.JLabel b7;
    private javax.swing.JLabel back;
    private javax.swing.JLabel back1;
    private javax.swing.JLabel back2;
    private javax.swing.JLabel back3;
    private javax.swing.JLabel back4;
    private javax.swing.JLabel back5;
    private javax.swing.JLabel back6;
    private javax.swing.JLabel back7;
    private javax.swing.JLabel back8;
    private javax.swing.JLabel back9;
    private javax.swing.JLabel bn1;
    private javax.swing.JLabel bn10;
    private javax.swing.JLabel bn11;
    private javax.swing.JLabel bn12;
    private javax.swing.JLabel bn13;
    private javax.swing.JLabel bn14;
    private javax.swing.JLabel bn15;
    private javax.swing.JLabel bn16;
    private javax.swing.JLabel bn17;
    private javax.swing.JLabel bn18;
    private javax.swing.JLabel bn19;
    private javax.swing.JLabel bn2;
    private javax.swing.JLabel bn20;
    private javax.swing.JLabel bn21;
    private javax.swing.JLabel bn22;
    private javax.swing.JLabel bn23;
    private javax.swing.JLabel bn24;
    private javax.swing.JLabel bn25;
    private javax.swing.JLabel bn26;
    private javax.swing.JLabel bn27;
    private javax.swing.JLabel bn28;
    private javax.swing.JLabel bn29;
    private javax.swing.JLabel bn3;
    private javax.swing.JLabel bn30;
    private javax.swing.JLabel bn31;
    private javax.swing.JLabel bn32;
    private javax.swing.JLabel bn33;
    private javax.swing.JLabel bn34;
    private javax.swing.JLabel bn35;
    private javax.swing.JLabel bn36;
    private javax.swing.JLabel bn37;
    private javax.swing.JLabel bn38;
    private javax.swing.JLabel bn39;
    private javax.swing.JLabel bn4;
    private javax.swing.JLabel bn40;
    private javax.swing.JLabel bn41;
    private javax.swing.JLabel bn42;
    private javax.swing.JLabel bn43;
    private javax.swing.JLabel bn44;
    private javax.swing.JLabel bn45;
    private javax.swing.JLabel bn47;
    private javax.swing.JLabel bn5;
    private javax.swing.JLabel bn6;
    private javax.swing.JLabel bn7;
    private javax.swing.JLabel bn8;
    private javax.swing.JLabel bn9;
    private javax.swing.JTable bnc_history;
    private javax.swing.JLabel cus_logo;
    private javax.swing.JLabel cus_logo1;
    private javax.swing.JLabel cus_logo2;
    private javax.swing.JLabel cus_logo4;
    private javax.swing.JLabel cus_logo5;
    private javax.swing.JLabel cus_logo6;
    private javax.swing.JLabel cus_logo7;
    private javax.swing.JLabel cus_logo8;
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
    public javax.swing.JLabel d1_l1;
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
    public javax.swing.JLabel d2_l1;
    private javax.swing.JLabel d2_l2;
    private javax.swing.JLabel d2_l3;
    private javax.swing.JPanel d3_1;
    private javax.swing.JPanel d3_2;
    public javax.swing.JLabel d3_l1;
    private javax.swing.JLabel d3_l2;
    private javax.swing.JLabel d3_l3;
    private javax.swing.JPanel d4_1;
    private javax.swing.JPanel d4_2;
    public javax.swing.JLabel d4_l1;
    private javax.swing.JLabel d4_l2;
    private javax.swing.JLabel d4_l3;
    private javax.swing.JPanel d5_1;
    private javax.swing.JPanel d5_2;
    public javax.swing.JLabel d5_l1;
    private javax.swing.JLabel d5_l2;
    private javax.swing.JLabel d5_l3;
    private javax.swing.JPanel d6_1;
    private javax.swing.JPanel d6_2;
    public javax.swing.JLabel d6_l1;
    private javax.swing.JLabel d6_l2;
    private javax.swing.JLabel d6_l3;
    private javax.swing.JPanel d7_1;
    private javax.swing.JPanel d7_2;
    private javax.swing.JPanel d7_3;
    private javax.swing.JPanel d7_4;
    public javax.swing.JLabel d7_l1;
    private javax.swing.JLabel d7_l2;
    private javax.swing.JLabel d7_l3;
    private javax.swing.JLabel d7_l4;
    private javax.swing.JLabel d7_l5;
    private javax.swing.JLabel d7_l6;
    private javax.swing.JPanel d8_1;
    private javax.swing.JPanel d8_2;
    private javax.swing.JPanel d8_3;
    private javax.swing.JPanel d8_4;
    public javax.swing.JLabel d8_l1;
    private javax.swing.JLabel d8_l2;
    private javax.swing.JLabel d8_l3;
    private javax.swing.JLabel d8_l4;
    private javax.swing.JLabel d8_l5;
    private javax.swing.JLabel d8_l6;
    private javax.swing.JPanel d9_1;
    private javax.swing.JPanel d9_2;
    private javax.swing.JPanel d9_3;
    private javax.swing.JPanel d9_4;
    public javax.swing.JLabel d9_l1;
    private javax.swing.JLabel d9_l2;
    private javax.swing.JLabel d9_l3;
    private javax.swing.JLabel d9_l4;
    private javax.swing.JLabel d9_l5;
    private javax.swing.JLabel d9_l6;
    private javax.swing.JLabel db;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JLabel e1;
    private javax.swing.JLabel e10;
    private javax.swing.JLabel e2;
    private javax.swing.JLabel e3;
    private javax.swing.JLabel e4;
    private javax.swing.JLabel e5;
    private javax.swing.JLabel e6;
    private javax.swing.JLabel e7;
    private javax.swing.JLabel e8;
    private javax.swing.JLabel e9;
    private javax.swing.JLabel emp;
    private javax.swing.JLabel emp1;
    private javax.swing.JLabel emp10;
    private javax.swing.JLabel emp11;
    private javax.swing.JLabel emp12;
    private javax.swing.JLabel emp13;
    private javax.swing.JLabel emp14;
    private javax.swing.JLabel emp15;
    private javax.swing.JLabel emp16;
    private javax.swing.JLabel emp17;
    private javax.swing.JLabel emp18;
    private javax.swing.JLabel emp2;
    private javax.swing.JLabel emp3;
    private javax.swing.JLabel emp4;
    private javax.swing.JLabel emp5;
    private javax.swing.JLabel emp6;
    private javax.swing.JLabel emp7;
    private javax.swing.JLabel emp8;
    private javax.swing.JLabel emp9;
    private javax.swing.JPanel entry;
    private javax.swing.JPanel entry2;
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
    private javax.swing.JTextField f10;
    private javax.swing.JTextField f11;
    private javax.swing.JTextArea f12;
    private javax.swing.JTextField f2;
    private javax.swing.JTextField f3;
    private javax.swing.JComboBox<String> f4;
    private javax.swing.JTextField f5;
    private javax.swing.JTextField f6;
    private javax.swing.JTextField f7;
    private javax.swing.JComboBox<String> f8;
    private javax.swing.JTextField f9;
    private javax.swing.JPanel female_emp;
    private javax.swing.JTable female_table;
    private javax.swing.JTextField hit1;
    private javax.swing.JLabel home_logo;
    private javax.swing.JPanel home_p;
    private javax.swing.JPanel home_pnl;
    private javax.swing.JLabel idcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser12;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
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
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
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
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel62;
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
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel23w;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField joindate;
    private javax.swing.JTextField joindatek;
    private javax.swing.JLabel lac1;
    private javax.swing.JLabel lac10;
    private javax.swing.JLabel lac2;
    private javax.swing.JLabel lac3;
    private javax.swing.JLabel lac4;
    private javax.swing.JLabel lac5;
    private javax.swing.JLabel lac6;
    private javax.swing.JLabel lac7;
    private javax.swing.JLabel lac8;
    private javax.swing.JLabel lac9;
    private javax.swing.JLabel loc;
    private javax.swing.JTextField m1;
    private javax.swing.JTextField m10;
    private javax.swing.JTextField m10v;
    private javax.swing.JTextField m11;
    private javax.swing.JTextField m11i;
    private javax.swing.JTextField m12;
    private javax.swing.JTextField m12y;
    private javax.swing.JTextField m13;
    private javax.swing.JTextField m13o;
    private javax.swing.JTextField m14;
    private javax.swing.JTextField m14n;
    private javax.swing.JTextField m15;
    private javax.swing.JTextField m15t;
    private javax.swing.JTextField m16o;
    private javax.swing.JTextField m17n;
    private javax.swing.JTextField m1j;
    private javax.swing.JTextField m2;
    private javax.swing.JTextField m2b;
    private javax.swing.JTextField m3;
    private javax.swing.JTextField m3j;
    private javax.swing.JTextField m4;
    private javax.swing.JTextField m4p;
    private javax.swing.JTextField m5;
    private javax.swing.JTextField m5o;
    private javax.swing.JTextField m6;
    private javax.swing.JTextField m6i;
    private javax.swing.JTextField m7;
    private javax.swing.JTextField m7t;
    private javax.swing.JTextField m8;
    private javax.swing.JTextField m8y;
    private javax.swing.JTextField m9;
    private javax.swing.JTextField m9o;
    private javax.swing.JLabel mailicon;
    private javax.swing.JPanel main_profile;
    private javax.swing.JPanel male_emp;
    private javax.swing.JPanel male_profile_panel;
    private javax.swing.JTable male_table;
    private javax.swing.JLabel n11;
    private javax.swing.JLabel n12;
    private javax.swing.JLabel n13;
    private javax.swing.JLabel n14;
    private javax.swing.JLabel n15;
    private javax.swing.JLabel n16;
    private javax.swing.JLabel n17;
    private javax.swing.JLabel n18;
    private javax.swing.JLabel n19;
    private javax.swing.JLabel n20;
    private javax.swing.JLabel n21;
    private javax.swing.JLabel n22;
    private javax.swing.JLabel n23;
    private javax.swing.JLabel n24;
    private javax.swing.JLabel n25;
    private javax.swing.JLabel n26;
    private javax.swing.JLabel n27;
    private javax.swing.JLabel n28;
    private javax.swing.JLabel n29;
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
    private javax.swing.JLabel n45;
    private javax.swing.JLabel n46;
    private javax.swing.JLabel n47;
    private javax.swing.JLabel n48;
    private javax.swing.JLabel n49;
    private javax.swing.JLabel n50;
    private javax.swing.JLabel n51;
    private javax.swing.JLabel n52;
    private javax.swing.JLabel n53;
    private javax.swing.JLabel n54;
    private javax.swing.JLabel n55;
    private javax.swing.JLabel n56;
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
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel p6;
    private javax.swing.JPanel pac1;
    private javax.swing.JPanel pac10;
    private javax.swing.JPanel pac101;
    private javax.swing.JPanel pac2;
    private javax.swing.JPanel pac5;
    private javax.swing.JPanel pac6;
    private javax.swing.JPanel pac7;
    private javax.swing.JPanel pac77;
    private javax.swing.JPanel pac8;
    private javax.swing.JPanel pac9;
    private javax.swing.JPanel pac99;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pics;
    private javax.swing.JLabel pics1;
    private javax.swing.JLabel pics1k;
    private javax.swing.JLabel picsff;
    private javax.swing.JLabel ppro;
    private javax.swing.JLabel pr;
    private javax.swing.JLabel profile;
    private javax.swing.JRadioButton rd1;
    private javax.swing.JRadioButton rd11;
    private javax.swing.JRadioButton rd2;
    private javax.swing.JRadioButton rd3;
    private javax.swing.JRadioButton rd32;
    private javax.swing.JRadioButton rd4;
    private javax.swing.JRadioButton rd5;
    private javax.swing.JRadioButton rd6;
    private javax.swing.JTextField s1;
    private javax.swing.JTextField s10;
    private javax.swing.JTextField s10sf;
    private javax.swing.JTextField s11;
    private javax.swing.JTextField s12;
    private javax.swing.JTextField s12af;
    private javax.swing.JTextField s13;
    private javax.swing.JTextField s13f;
    private javax.swing.JTextField s14;
    private javax.swing.JTextField s14cf;
    private javax.swing.JTextField s15sf;
    private javax.swing.JTextField s16f;
    private javax.swing.JTextField s17df;
    private javax.swing.JTextField s1f;
    private javax.swing.JTextField s2;
    private javax.swing.JTextField s2f;
    private javax.swing.JTextField s3;
    private javax.swing.JTextField s3f;
    private javax.swing.JTextField s4;
    private javax.swing.JTextField s4zf;
    private javax.swing.JTextField s5;
    private javax.swing.JTextField s5f;
    private javax.swing.JTextField s6;
    private javax.swing.JTextField s6f;
    private javax.swing.JTextField s7;
    private javax.swing.JTextField s7f;
    private javax.swing.JTextField s8;
    private javax.swing.JTextField s8f;
    private javax.swing.JTextField s9;
    private javax.swing.JTextField s9cf;
    private javax.swing.JLabel se1;
    private javax.swing.JLabel se2;
    private javax.swing.JPanel search;
    private javax.swing.JTextField search1;
    private javax.swing.JTextField search1j;
    private javax.swing.JPanel search_acc;
    private javax.swing.JLabel searcherr;
    private javax.swing.JLabel searcherr1;
    private javax.swing.JTextField serupdate;
    private javax.swing.JLabel slo;
    private javax.swing.JPanel spane;
    private javax.swing.JPanel spane1;
    private javax.swing.JPanel spane2;
    private javax.swing.JLabel srch;
    private javax.swing.JLabel srch1;
    private javax.swing.JLabel st1;
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
    private javax.swing.JLabel st6;
    private javax.swing.JLabel st7;
    private javax.swing.JLabel st8;
    private javax.swing.JLabel st9;
    private javax.swing.JLabel top_logo;
    private javax.swing.JLabel top_title;
    private javax.swing.JPanel total_emplyee;
    private javax.swing.JTextField u1;
    private javax.swing.JTextField u10;
    private javax.swing.JTextField u11;
    private javax.swing.JTextArea u12;
    private javax.swing.JTextField u2;
    private com.toedter.calendar.JDateChooser u3;
    private javax.swing.JComboBox<String> u4;
    private javax.swing.JTextField u5;
    private javax.swing.JTextField u6;
    private javax.swing.JTextField u7;
    private javax.swing.JComboBox<String> u8;
    private javax.swing.JTextField u9;
    private javax.swing.JPanel up_search;
    private javax.swing.JPanel updatepane;
    private javax.swing.JLabel uperror;
    private javax.swing.JLabel upic;
    // End of variables declaration//GEN-END:variables

    private void titleicone() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("t.png")));
    }
}
class round extends JPanel {
    protected int strokeSize = 0;
    protected Color shadowColor = Color.black;
    protected boolean shady = false;
    protected boolean highQuality =true;
    protected Dimension arcs;
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 0;
    public round(int d) {
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
