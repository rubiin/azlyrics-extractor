/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azlyrics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rubin
 */
public class lyrics {
    
    
  
    
    
    
    
    public static void main(String[] args) {
        
        Scanner rubin= new Scanner(System.in);
        System.out.println("Enter Artist Name: ");
        String artist=rubin.nextLine();
        System.out.println("Enter Song Name: ");
        String songName=rubin.nextLine();
        
        
        
    artist=artist.toLowerCase().replace(" ", "").trim();
    songName=songName.toLowerCase().replace(" ", "").trim();
        
   String urlText = "http://www.azlyrics.com/lyrics/"+artist+"/"+songName+".html";
    BufferedReader in = null;
             String data="";
    try {
      URL url = new URL(urlText);
      in = new BufferedReader(new InputStreamReader(url.openStream()));

      String inputLine;
      
      while ((inputLine = in.readLine()) != null) {
      //  System.out.println(inputLine);
        data+=inputLine;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
 
    // lyrics is stored between these two strings
    String up_boundary="<!-- Usage of azlyrics.com content by any third-party lyrics provider is prohibited by our licensing agreement. Sorry about that. -->";
    String lower_boundary="<!-- MxM banner -->";

    data=data.split(up_boundary)[1];
    data=data.split(lower_boundary)[0];
    data=data.replace("<br>", "\n").replace("</div>", "").replace("</br>", " ").replace("<i>", " ").replace("</i>", "\n").trim();
   
    
        try {
            //clear console before printing lyrics
            Runtime.getRuntime().exec("cmd /c cls");
        } catch (IOException ex) {
            Logger.getLogger(lyrics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // actual lyrics is printed after some sanitization of tags
        // varaiable data stores the lyrics so use it anyway you like (print it, pass it)
        
    System.out.print(data);
    }
}
