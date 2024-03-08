/*
@author Cai Carter


 */

import java.util.*;
import javax.swing.*;

public class Main {
    public static String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void main(String[] args) {
        int rota = 0;
        String[] bet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] buttons = { "en", "de", "esc"};
        String out = "";
        int rc = JOptionPane.showOptionDialog(null, "Press 'en' to encode, 'de' to decode, and 'esc' to exit...", "Confirmation",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);
        if(rc == -1){
            System.out.println("Exiting");
        } else if (rc == 0) {
            System.out.println("Encoding...");
            rota = Integer.parseInt(JOptionPane.showInputDialog("Input Rotation Amount"));
            sorty(rota);
            String message = JOptionPane.showInputDialog("Enter Message");

            Boolean ch = false;
            for(int i = 0; i < message.length(); i++){
                ch = false;
                for(int j = 0; j < bet.length; j++){
                    if(message.substring(i,i+1).equalsIgnoreCase(bet[j])){
                        out += alpha[j];
                        ch = true;
                    }
                }
                if(!ch){
                    out += message.substring(i,i+1);
                }
            }
            System.out.println(out);
        } else if (rc == 1) {
            out = "";
            System.out.println("Decoding...");
            rota = Integer.parseInt(JOptionPane.showInputDialog("Input Rotation Amount"));
            rota = rota - rota*2;
            sorty(rota);
            String message = JOptionPane.showInputDialog("Enter Message");
            Boolean ch = false;
            for(int i = 0; i < message.length(); i++){
                ch = false;
                for(int j = 0; j < bet.length; j++){
                    if(message.substring(i,i+1).equalsIgnoreCase(bet[j])){
                        out += alpha[j];
                        ch = true;
                    }
                }
                if(!ch){
                    out += message.substring(i,i+1);
                }
            }
        } else if (rc == 2) {

        }
    }


    public static void sorty(int rot){
        int po = 0;
        for (int i = 0; i < alpha.length; i++){

            if(po+rot < alpha.length)
                alpha[i] = alpha[po + rot];
            else {
                po = 0;
                rot = 0;
            }
            po++;
        }
    }
}
