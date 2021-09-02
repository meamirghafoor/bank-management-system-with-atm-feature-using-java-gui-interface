import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class database_action {
    database_conection m=new database_conection();
    boolean insertion(String otp, String text, String text0, String dat, String toString, String text1, String text2, String text3, String toString0, String text4, String text5, String text6, String text7, File path, String pass) {
        try{
        FileInputStream bit=new FileInputStream(path);
        int length=(int)path.length();
        SimpleDateFormat currentdate=new SimpleDateFormat("MM/dd/yyyy");
        Date nowdate = new Date(); 
        String drt=String.valueOf(currentdate.format(nowdate));
        PreparedStatement pst=m.conn().prepareStatement("insert into employee(id,name,father,dob,marital,cnic,mail,postal,gender,contect,edu,incom,address,status,pass,joiningdate,image,login_status,log_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1, otp);
        pst.setString(2, text);
        pst.setString(3, text0);
        pst.setString(4, dat);
        pst.setString(5, toString);
        pst.setString(6, text1);
        pst.setString(7, text2);
        pst.setString(8, text3);
        pst.setString(9, toString0);
        pst.setString(10, text4);
        pst.setString(11, text5);
        pst.setString(12, text6);
        pst.setString(13, text7);
        pst.setString(14, "Active");
        pst.setString(15, pass);
        pst.setString(16, drt);
        pst.setBinaryStream(17, bit, length);
        pst.setString(18, "offline");
        pst.setString(19, "offline");
        int check=pst.executeUpdate();
        if(check>0){
            return true;
        }else{
            return false;
        }
        
        }catch(FileNotFoundException | SQLException e){
            System.out.println(e);
        }
        return false;
    }
    String pas_con;
    public String getPas_con() {
        return pas_con;
    }
    boolean check_employee(String cnc,String type){
        try{
        Statement pst=m.conn().createStatement();
        String quiry=null;
        if("cnic".equals(type)){
                quiry="SELECT id,cnic FROM employee WHERE cnic='"+cnc+"'";
            }
            if("mail".equals(type)){
                quiry="SELECT id,mail FROM employee WHERE mail='"+cnc+"'";
            }
            if("id".equals(type)){
                quiry="SELECT id FROM employee WHERE id='"+cnc+"'";
            }
          ResultSet rs=pst.executeQuery(quiry);
        if(rs.next()){
             pas_con=rs.getString("id");
            return true;
        }
        else{
            return false;
        }
        }catch(SQLException e){
            return false;
        }
    }
    boolean dashboard_update(int employeeid){
        try{
        String quiry="UPDATE strength SET empid='"+employeeid+"' WHERE id='1'";
        PreparedStatement pst=m.conn().prepareStatement(quiry);
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
    boolean account_status_update(String id,String st){
        try{
        String quiry="UPDATE employee SET status='"+st+"' WHERE id='"+id+"'";
        PreparedStatement pst=m.conn().prepareStatement(quiry);
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
    boolean admin_account_profile_update(File mg){
        try{
            FileInputStream bit=new FileInputStream(mg);
        int length=(int)mg.length();
        String quiry="UPDATE admin SET image=? WHERE id='1'";
        PreparedStatement st=m.conn().prepareStatement(quiry);
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
    boolean admin_account_password_update(String pass,String id){
        try{
        String quiry="UPDATE admin SET pass=? WHERE user='"+id+"'";
        PreparedStatement st=m.conn().prepareStatement(quiry);
        st.setString(1, pass);
        int status=st.executeUpdate();
        if(status>0){
            return true;
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.print(e);
            return false;
        }
    }
    boolean delete_emp_account(String id){
        try{
        String quiry="DELETE FROM employee WHERE id='"+id+"'";
        PreparedStatement pst=m.conn().prepareStatement(quiry);
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
    boolean update_employee_data(String id,String name,String father,String dob,String marital,String cnic, String mail, String postal, String gender,String contect,String edu, String incom, String address,byte[]img){
        try{
         PreparedStatement st=m.conn().prepareStatement("update employee set name=?,father=?,dob=?,marital=?,cnic=?,mail=?,postal=?,gender=?,contect=?,edu=?,incom=?,address=?,image=? WHERE id='"+id+"'");
         st.setString(1, name);
         st.setString(2, father);
         st.setString(3, dob);
         st.setString(4, marital);
         st.setString(5, cnic);
         st.setString(6, mail);
         st.setString(7, postal);
         st.setString(8, gender);
         st.setString(9, contect);
         st.setString(10, edu);
         st.setString(11, incom);
         st.setString(12, address);
         st.setBytes(13, img);
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
    
};
class fetch_data{
    private String id;
    private String name;
    private String faher;
    private Date dob;
    private String marital;
    private String dat;
    private String cnic;
    private String mail;
    private String postal;
    private String gender;
    private String contect;
    private String edu;
    private String incom;
    private String address;
    private String status;
    private String pass;
    private String joiningdate;
    private byte[] image;
    String password_admin;
    byte[] pic;
    database_conection m=new database_conection();
    public void papulate_data(String data,String type){
        try{
            String quiry=null;
            Statement pst=m.conn().createStatement();
            if("cnic".equals(type)){
                quiry="SELECT * FROM employee WHERE cnic='"+data+"'";
            }
            if("mail".equals(type)){
                quiry="SELECT * FROM employee WHERE mail='"+data+"'";
            }
            if("id".equals(type)){
                quiry="SELECT * FROM employee WHERE id='"+data+"'";
            }
            ResultSet rs=pst.executeQuery(quiry);
            if(rs.next()){
               this.id=rs.getString("id");
               this.status=rs.getString("status");
               this.name=rs.getString("name");
               this.faher=rs.getString("father");
               dat=rs.getString("dob");
               this.dob=new SimpleDateFormat("dd-MM-yyyy").parse(dat);
               this.marital=rs.getString("marital");
               this.gender=rs.getString("gender");
               this.cnic=rs.getString("cnic");
               this.mail=rs.getString("mail");
               this.postal=rs.getString("postal");
               this.address=rs.getString("address");
               this.contect=rs.getString("contect");
               this.edu=rs.getString("edu");
               this.incom=rs.getString("incom");
               this.image=rs.getBytes("image");
               this.joiningdate=rs.getString("joiningdate");
            }
            }catch(SQLException |ParseException e){
            System.out.print(e);
        }
    }
    public String getDat() {
        return dat;
    }
    public String getId() {
        return id;
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

    public String getMarital() {
        return marital;
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

    public String getEdu() {
        return edu;
    }

    public String getIncom() {
        return incom;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getPass() {
        return pass;
    }

    public String getJoiningdate() {
        return joiningdate;
    }

    public byte[] getImage() {
        return image;
    }

    public byte[] getPic() {
        try{
            Statement pst=m.conn().createStatement();
            String quiry="SELECT image FROM admin WHERE id='1'";
            ResultSet rs=pst.executeQuery(quiry);
            if(rs.next()){
                pic=rs.getBytes("image");
            }
        }catch(SQLException e){
            System.out.print(e);
        }
        return pic;
    }

    boolean getPassword_admin(String pass,String id) {
        String pass_admin=null;
        try{
            Statement pst=m.conn().createStatement();
           String qury="SELECT pass FROM admin WHERE user='"+id+"'";
            ResultSet rs=pst.executeQuery(qury);
            if(rs.next()){
                pass_admin=rs.getString("pass");
            }
            else{
                pass_admin="wrong";
            }
        }catch(SQLException e){
            System.out.print(e);
        }
        if(pass_admin.equals(pass)){
          return true;
        }else{
            return false;
        }
    }
};
