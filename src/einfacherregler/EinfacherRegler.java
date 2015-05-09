/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einfacherregler;
import java.io.*;

/**
 *
 * @author t.gronowski
 */
public class EinfacherRegler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final double Kp=0.1;
        final double Ki=0.1;
        final double Kd=0.1;
        
        
        double soll[];       
        double[] ist;        
        double[] differenz;
        soll = new double[200];
        ist = new double[200];
        differenz=new double[200]; 
        
        try{       
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\t.gronowski\\Documents\\NetBeansProjects\\EinfacherRegler\\src\\einfacherregler\\test.txt"));
        int zaehler=0;       
        
        String zeile1 = br.readLine();  
       
        soll[zaehler]=Double.parseDouble(zeile1.trim());
        
         while((zeile1 = br.readLine()) != null ){    
             zaehler++;
             soll[zaehler]=Double.parseDouble(zeile1.trim()); 
             //System.out.println(zaehler+" :"+soll[zaehler]);
         }       
        
        }catch (IOException e){
            System.out.println("test.txt ist nicht vorhanden");            
        }    
        
        // ist[3]=ist[2]+Kp*differenz[2]+Kd*(differenz[2]-differenz[1])+Ki*(differenz[2]+differenz[1]+differenz[0]);
        
        System.out.println("Ist: "+ist[3]);
        
        for (int i=3;i<82;i++){
             differenz[i-1]=soll[i-1]-ist[i-1];
             ist[i]=ist[i-1]+Kp*differenz[i-1]+Kd*(differenz[i-1]-differenz[i-2])+Ki*(differenz[i-1]+differenz[i-2]+differenz[i-3]);
        }
        
        System.out.println();
        
        for (int i=0;i<82;i++){
            //System.out.println("Ist: "+ist[i]+" Soll: "+soll[i]);
            System.out.printf("Zeit: %d Ist: %.2f  Soll: %.2f\n",i,ist[i],soll[i]);
        }
        
    }
    
}
