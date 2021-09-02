import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class account_database_action{
    database_conection con=new database_conection();
    boolean account_insertion(String bnk,String name,String father,String dob,String cnic,String email,String acc_type,String postal,String gen,String contect,int blnc,String address,File image,String title){
        try{
         FileInputStream bit=new FileInputStream(image);
        int length=(int)image.length();
        SimpleDateFormat currentdate=new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date(); 
        String drt=String.valueOf(currentdate.format(nowdate));
        PreparedStatement pst=con.conn().prepareStatement("INSERT INTO accounts(bank_acc,atm_acc,atm_status,bank_status,name,father,dob,cnic,email,acc_type,postal,gen,contect,blnc,address,join_date,image,title,atm_join,pass) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1,bnk);
        pst.setString(2,"Not Registered");
        pst.setString(3,"Not Registered");
        pst.setString(4,"Active");
        pst.setString(5,name);
        pst.setString(6,father);
        pst.setString(7,dob);
        pst.setString(8,cnic);
        pst.setString(9,email);
        pst.setString(10,acc_type);
        pst.setString(11,postal);
        pst.setString(12,gen);
        pst.setString(13,contect);
        pst.setInt(14, blnc);
        pst.setString(15,address);
        pst.setString(16,drt);
        pst.setBinaryStream(17, bit, length);
        pst.setString(18,title);
        pst.setString(19,"Not Registered");
        pst.setString(20,"Not Registered");
        int check=pst.executeUpdate();
        if(check>0){
            return true;
        }else{
            return false;
        }
        }catch(FileNotFoundException |SQLException e){
            System.out.print(e);
        }
        return false;
    }
     boolean check_duplycate_entry(String cnc){
        try{
        Statement pst=con.conn().createStatement();
        String quiry=null;
        quiry="SELECT cnic FROM accounts WHERE cnic='"+cnc+"'";
        ResultSet rs=pst.executeQuery(quiry);
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
    void dashboard_update(int atmvalue,int bnkvalue){
        try{
        String quiry="UPDATE strength SET acc_atm=?,acc_bank=? WHERE id='1'";
        PreparedStatement pst=con.conn().prepareStatement(quiry);
        pst.setInt(1, atmvalue);
        pst.setInt(2,bnkvalue);
        int status=pst.executeUpdate();
        if(status>0){
        }
        }catch(SQLException e){
            System.out.print(e);
        }
    }
String dashboad_value(String query){
    String count="0";
    try{
        Statement pst=con.conn().createStatement();
        ResultSet rs=pst.executeQuery(query);
       if(rs.next()){
          count = rs.getString("total");
       }else{
           count="0";
       }
    }catch(SQLException e){
        System.out.print(e);
    }
    if(count==null){
        return count="0";
    }else{
    return count;
    }
}
     boolean check_account(String cnc,String type){
        try{
        Statement pst=con.conn().createStatement();
        String quiry=null;
        if("cnic".equals(type)){
                quiry="SELECT cnic FROM accounts WHERE cnic='"+cnc+"'";
        }
        if("account".equals(type)){
                quiry="SELECT bank_acc FROM accounts WHERE bank_acc='"+cnc+"'";
         }
          ResultSet rs=pst.executeQuery(quiry);
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
     String mail=null;
     String nm=null;
    boolean check_account_status(String cnc){
         String bnk=null;
        try{
        Statement pst=con.conn().createStatement();
        String quiry="SELECT name,bank_status,email FROM accounts WHERE bank_acc='"+cnc+"'";
          ResultSet rs=pst.executeQuery(quiry);
        if(rs.next()){
            bnk=rs.getString("bank_status");
            mail=rs.getString("email");
            nm=rs.getString("name");
        }else{
            bnk="no";
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        if(bnk.equals("Active")){
            System.out.print(bnk);
            return true;
        }else{
            return false;
        }
    }
    public String getMail() {
        return mail;
    }

    public String getNm() {
        return nm;
    }
     boolean check_atm_account(String cnc,String typ){
         String rsult=null;
        try{
        Statement pst=con.conn().createStatement();
        String quiry=null;
        if("bnk".equals(typ)){
        quiry="SELECT atm_acc FROM accounts WHERE bank_acc='"+cnc+"'";
        }
        if("atm".equals(typ)){
            quiry="SELECT atm_acc FROM accounts WHERE atm_acc='"+cnc+"'";
        }
        if("cnic".equals(typ)){
            quiry="SELECT atm_acc FROM accounts WHERE cnic='"+cnc+"'";
        }
          ResultSet rs=pst.executeQuery(quiry);
        if(rs.next()){
            rsult=rs.getString("atm_acc");
        }else{
            rsult="no";
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        if(rsult.equals("Not Registered")){
            return false;
        }
        else if(rsult.equals("no")){
            return false;
        }
        else{
        return true;
        }
    }
     boolean update_account_data(String id,String name,String father,String dob,String acc_type,String cnic, String mail, String postal, String gender,String contect,String address,byte[]img,String title){
        try{
         PreparedStatement st=con.conn().prepareStatement("update accounts set name=?,father=?,dob=?,acc_type=?,cnic=?,email=?,postal=?,gen=?,contect=?,address=?,image=?,title=? WHERE bank_acc='"+id+"'");
         st.setString(1, name);
         st.setString(2, father);
         st.setString(3, dob);
         st.setString(4, acc_type);
         st.setString(5, cnic);
         st.setString(6, mail);
         st.setString(7, postal);
         st.setString(8, gender);
         st.setString(9, contect);
         st.setString(10, address);
         st.setBytes(11, img);
         st.setString(12, title);
         int out=st.executeUpdate();
         if(out>0){
             return true;
         }else{
             return false;
         }
        }catch(SQLException e){
            System.out.print(e);
        }
        return true;
    }
      boolean delete_account(String id){
        try{
        String quiry="DELETE FROM accounts WHERE bank_acc='"+id+"'";
        PreparedStatement pst=con.conn().prepareStatement(quiry);
        int status=pst.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
    boolean account_status_update(String id,String st,String atms){
        try{
        String quiry="UPDATE accounts SET atm_status='"+atms+"',bank_status='"+st+"' WHERE bank_acc='"+id+"'";
        PreparedStatement pst=con.conn().prepareStatement(quiry);
        int status=pst.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
    boolean account_histroy(String se_acc,String se_name,String re_name,String re_acc, String amount,String type,String bnk,String n){
        try{
        SimpleDateFormat date1=new SimpleDateFormat("MM/dd/yyyy");
        Date nowdate = new Date(); 
        String drt=String.valueOf(date1.format(nowdate));
        String drt1=String.valueOf((nowdate));
        String quiry="INSERT INTO history(bnk,se_acc,se_name,re_name,re_acc,date,time,amount,type,name) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst=con.conn().prepareStatement(quiry);
        pst.setString(1,bnk);
        pst.setString(2,se_name);
        pst.setString(3,se_acc);
        pst.setString(4,re_name);
        pst.setString(5,re_acc);
        pst.setString(6,drt);
        pst.setString(7,drt1);
        pst.setString(8,amount);
        pst.setString(9,type);
        pst.setString(10,n);
        int status=pst.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
    boolean money_transection(String id,int blnc){
        try{
        PreparedStatement stt=con.conn().prepareStatement("update accounts set blnc=? WHERE bank_acc='"+id+"'");
         stt.setInt(1, blnc);
        int status=stt.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
      boolean atm_account_new(String bnk,String st,String pass){
        try{
        String quiry=null;
        if(st.equals("del")){
        quiry="UPDATE accounts SET atm_acc='Not Registered',atm_status='Not Registered',atm_join='Not Registered',pass='null' WHERE bank_acc='"+bnk+"'";
        }else{
            SimpleDateFormat currentdate=new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date nowdate = new java.util.Date(); 
        String drit=String.valueOf(currentdate.format(nowdate));
          quiry="UPDATE accounts SET atm_acc='"+st+"',atm_status='Active',atm_join='"+drit+"' ,pass='"+pass+"' WHERE bank_acc='"+bnk+"'";
        }
        PreparedStatement pst=con.conn().prepareStatement(quiry);
        int status=pst.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
}
class account_profile_employee{
    database_conection con=new database_conection();
    byte[] image;
    String name,id,dob,cinc,email,gen,marital,address,incom,contect,father,postalcode,join,edu;
    public void employee_profile(String eid){
        try{
        Statement pst=con.conn().createStatement();
        ResultSet rs=pst.executeQuery("SELECT * FROM employee WHERE id='"+eid+"'");
        if(rs.next()){
            id=rs.getString("id");
            name=rs.getString("name");
            father=rs.getString("father");
            dob=rs.getString("dob");
            marital=rs.getString("marital");
            cinc=rs.getString("cnic");
            email=rs.getString("mail");
            postalcode=rs.getString("postal");
            gen=rs.getString("gender");
            contect=rs.getString("contect");
            edu=rs.getString("edu");
            incom=rs.getString("incom");
            address=rs.getString("address");
            join=rs.getString("joiningdate");
            image=rs.getBytes("image");
        }
        }catch(SQLException e){
            
        }
    }

    public byte[] getImage() {
        return image;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDob() {
        return dob;
    }

    public String getCinc() {
        return cinc;
    }

    public String getEmail() {
        return email;
    }

    public String getGen() {
        return gen;
    }

    public String getMarital() {
        return marital;
    }

    public String getAddress() {
        return address;
    }

    public String getIncom() {
        return incom;
    }

    public String getContect() {
        return contect;
    }

    public String getFather() {
        return father;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getJoin() {
        return join;
    }

    public String getEdu() {
        return edu;
    }
       boolean employee_account_profile_update(File mg,String id){
        try{
            FileInputStream bit=new FileInputStream(mg);
        int length=(int)mg.length();
        String quiry="UPDATE employee SET image=? WHERE id='"+id+"'";
        PreparedStatement st=con.conn().prepareStatement(quiry);
        st.setBinaryStream(1, bit, length);
        int status=st.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(FileNotFoundException |SQLException e){
            System.out.print(e);
        }
        return false;
    }
   boolean getPassword_emp(String pass,String id) {
        String pass_admin=null;
        try{
            Statement pst=con.conn().createStatement();
           String qury="SELECT pass FROM employee WHERE id='"+id+"'";
            ResultSet rs=pst.executeQuery(qury);
            if(rs.next()){
                pass_admin=rs.getString("pass");
            }else{
                pass_admin="edis";
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Database server not connected","Error",JOptionPane.ERROR_MESSAGE);
            System.out.print(e);
        }
        if(pass_admin.equals(pass)){
          return true;
        }else{
            return false;
        }
    }
   boolean emp_account_password_update(String pass,String id){
        try{
        String quiry="UPDATE employee SET pass=? WHERE id='"+id+"'";
        PreparedStatement st=con.conn().prepareStatement(quiry);
        st.setString(1, pass);
        int status=st.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
   boolean emp_account_login_status(String id,String set){
        try{
            SimpleDateFormat currentdate=new SimpleDateFormat("hh:mm:ss");
            java.util.Date nowdate = new java.util.Date(); 
            String drit=String.valueOf(currentdate.format(nowdate));
        String quiry="UPDATE employee SET login_status=?,log_time=? WHERE id='"+id+"'";
        PreparedStatement st=con.conn().prepareStatement(quiry);
        st.setString(1, set);
        st.setString(2, drit);
        int status=st.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
}
class fetch_account_data{
    private String bnk_acc;
    private String atm_acc;
    private String atm_status;
    private String bnk_status;
    private String acc_type;
    private String name;
    private String faher;
    private Date dob;
    private String cnic;
    private String mail;
    private String postal;
    private String gender;
    private String contect;
    private String balnce;
    private String address;
    private String title;
    private String joindate;
    private byte[] image;
    private String dat;
    String atm_date;
    database_conection m=new database_conection();
    public void papulate_data(String data,String type){
        try{
            String quiry=null;
            Statement pst=m.conn().createStatement();
            if("cnic".equals(type)){
                quiry="SELECT * FROM accounts WHERE cnic='"+data+"'";
            }
            if("account".equals(type)){
                quiry="SELECT * FROM accounts WHERE bank_acc='"+data+"'";
            }
            if("atm".equals(type)){
                quiry="SELECT * FROM accounts WHERE atm_acc='"+data+"'";
            }
            ResultSet rs=pst.executeQuery(quiry);
            if(rs.next()){
               this.bnk_acc=rs.getString("bank_acc");
               this.title=rs.getString("title");
               this.atm_acc=rs.getString("atm_acc");
               this.atm_status=rs.getString("atm_status");
               this.bnk_status=rs.getString("bank_status");
               this.acc_type=rs.getString("acc_type");
               this.name=rs.getString("name");
               this.faher=rs.getString("father");
               dat=rs.getString("dob");
               this.dob=new SimpleDateFormat("dd-MM-yyyy").parse(dat);
               this.gender=rs.getString("gen");
               this.cnic=rs.getString("cnic");
               this.mail=rs.getString("email");
               this.postal=rs.getString("postal");
               this.address=rs.getString("address");
               this.contect=rs.getString("contect");
               this.balnce=String.valueOf(rs.getInt("blnc"));
               this.image=rs.getBytes("image");
               this.joindate=rs.getString("join_date");
               this.atm_date=rs.getString("atm_join");
            }
            }catch(SQLException |ParseException e){
            System.out.print(e);
        }
    }
    public String getTitle() {
        return title;
    }
    public String getAtm_date() {
        return atm_date;
    }
    public String getBnk_acc() {
        return bnk_acc;
    }

    public String getAtm_acc() {
        return atm_acc;
    }

    public String getAtm_status() {
        return atm_status;
    }

    public String getBnk_status() {
        return bnk_status;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public String getName() {
        return name;
    }

    public String getFaher() {
        return faher;
    }

    public Date getDob() {
        return dob;
    }

    public String getCnic() {
        return cnic;
    }

    public String getMail() {
        return mail;
    }

    public String getPostal() {
        return postal;
    }

    public String getGender() {
        return gender;
    }

    public String getContect() {
        return contect;
    }

    public String getBalnce() {
        return balnce;
    }

    public String getAddress() {
        return address;
    }

    public String getJoindate() {
        return joindate;
    }

    public byte[] getImage() {
        return image;
    }

    public String getDat() {
        return dat;
    }
}
