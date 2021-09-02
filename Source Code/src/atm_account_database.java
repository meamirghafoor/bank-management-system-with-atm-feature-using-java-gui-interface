
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class atm_account_database{
database_conection con=new database_conection();
    String atm_pass;
    String atm_status;
    String email;
    String acc_type;

    public String getAtm_acc() {
        return atm_acc;
    }
    String atm_acc;
    public String getBnk() {
        return bnk;
    }
    String bnk;

    public int getBlnc() {
        return blnc;
    }
    int blnc;

    public String getName() {
        return name;
    }
    String name,title;

    public String getTitle() {
        return title;
    }
     boolean check_atm_account(String cnc){
        try{
        Statement pst=con.conn().createStatement();
        String quiry="SELECT * FROM accounts WHERE atm_acc='"+cnc+"'";
        ResultSet rs=pst.executeQuery(quiry);
        if(rs.next()){
            name=rs.getString("name");
            atm_pass=rs.getString("pass");
            atm_status=rs.getString("atm_status");
            email=rs.getString("email");
            title=rs.getString("title");
            blnc=rs.getInt("blnc");
            bnk=rs.getString("bank_acc");
            atm_acc=rs.getString("atm_acc");
            acc_type=rs.getString("acc_type");
            return true;
        }else{
            return false;
        } 
        }catch(SQLException e){
            System.out.print(e);
        }
        return false;
    }
     public String getAcc_type() {
        return acc_type;
    }
     public String getAtm_pass() {
        return atm_pass;
    }

    public String getAtm_status() {
        return atm_status;
    }

    public String getEmail() {
        return email;
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
        pst.setString(2,se_acc);
        pst.setString(3,se_name);
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
   boolean atm_account_password_update(String pass,String id){
        try{
        String quiry="UPDATE accounts SET pass=? WHERE atm_acc='"+id+"'";
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
      boolean getPassword_emp(String pass,String id) {
        String pass_admin="sj";
        try{
            Statement pst=con.conn().createStatement();
           String qury="SELECT pass FROM accounts WHERE atm_acc='"+id+"'";
            ResultSet rs=pst.executeQuery(qury);
            if(rs.next()){
                pass_admin=rs.getString("pass");
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
}