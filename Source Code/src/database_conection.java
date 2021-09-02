import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
public class database_conection {
    public Connection conn(){
        try{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project","root","");
        return con;
        }catch(SQLException e){
            JLabel messageLabel = new JLabel("<html><body><p style='width: 200px;'>"+"Database server connection error"+"</p></body></html>");
        Timer timr = new Timer(4000, (ActionEvent event) -> {
            SwingUtilities.getWindowAncestor(messageLabel).dispose();
        });
        timr.setRepeats(false);
        timr.start();
        JOptionPane.showOptionDialog(null, messageLabel,"Server connection error", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[]{}, null);
        }
        return null;
    }
}  
