/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NTHINGs
 */
public class pruebas {
    
    pruebas(){
        boolean[]llave=new boolean[64];
        String llavestring="0000111100010101011100011100100101000111110110011110100001011001";
                            
        
        for(int x=0;x<llavestring.length();x++){
            llave[x]= llavestring.charAt(x)=='1';
        }
        
        DES des=new DES(llave);
        
        boolean[]paquete=new boolean[64];
        String paquetestring="0000001001000110100010101100111011101100101010000110010000100000";
        for(int x=0;x<paquetestring.length();x++){
            paquete[x]= paquetestring.charAt(x)=='1';
        }
        
        System.out.println("SALIDA"+des.encriptar(paquete));
        
        
        
    }
    public static void main(String args[]){
        pruebas main=new pruebas();
    }
}
