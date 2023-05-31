import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_21s21093 implements Runnable 
{
    @Override
    public void run()
    {
        try
        { 
            Socket st_21s21093 = new Socket ("locahost",8000);
            Scanner sc_21s21093=new Scanner(System.in);
            
            System.out.println("Enter BeverageCode");
            int BC_21s21093=sc_21s21093.nextInt();
            System.out.println("Enter Number of cups");
            int C_21s21093=sc_21s21093.nextInt();
            
            //send
            DataOutputStream ds_21s21093=new DataOutputStream (st_21s21093.getOutputStream());
            ds_21s21093.writeInt(BC_21s21093);
            ds_21s21093.writeInt(C_21s21093);
            ds_21s21093.flush();
            
            //recive
            DataInputStream is_21s21093 = new DataInputStream(st_21s21093.getInputStream());
            String BN_21s21093 =is_21s21093.readUTF();
            double P_21s21093 =is_21s21093.readDouble();
            double s_21s21093=is_21s21093.readDouble();
            
            
            System.out.println("The BeverageName"+BN_21s21093);
            System.out.println("The price"+P_21s21093);
            System.out.println("The Sales"+s_21s21093);
        }
        catch(IOException e) {
            
        } 
    }    
             
}

