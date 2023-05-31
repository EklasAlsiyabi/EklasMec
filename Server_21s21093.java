import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Server_21s21093 implements Runnable{
    @Override
    public void run()
    {
        try{
            String URL="jdbc:derby://localhost:1527/EklasDB";
            String US="EklasDB";
            String PA="12345";
            
            Connection co_21S21093 =DriverManager.getConnection(URL,US,PA);
            
            ServerSocket Server_21s21093=new ServerSocket(8000);
            System.out.println("server is running");
           
            while(true){
            Socket client_21S21093=Server_21s21093.accept();
            
            DataInputStream dS_21S21093 = new DataInputStream(client_21S21093.getInputStream());
            int BC_21S21093=dS_21S21093 .readInt();
            int C_21S21093 =dS_21S21093 .readInt();
            System.out.println("Your BeverageCode"+BC_21S21093);
             System.out.println("Cups"+C_21S21093);
             
             Statement S_21S21093=co_21S21093.createStatement();
             String Q_21S21093="SELECT*FROM DRINKS WHERE BEVERACODE="+BC_21S21093;
            ResultSet R_21S21093=S_21S21093.executeQuery(Q_21S21093);
            
            DataOutputStream ds_21S21093 = new DataOutputStream(client_21S21093.getOutputStream());
            while(R_21S21093.next()){
                String BN_21s21093=R_21S21093.getString("BEVERANAME");
                double Pr_21s21093=R_21S21093.getDouble("PRICE");
                double s_21s21093=Pr_21s21093* C_21S21093;
                
                ds_21S21093.writeUTF(BN_21s21093);
                ds_21S21093.writeDouble(s_21s21093);
                System.out.println("Send to client");
                ds_21S21093.flush();
                
                
            }
       
        }
           
    }   catch (IOException | SQLException ex) {
            
        }
       
}
}
