/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nthings
 */
public class palabra {
    public byte bait1;
    public byte bait2;
    public byte bait3;
    public byte bait4;
    
    public palabra(){
        
    }
    
    public palabra(byte bait1, byte bait2, byte bait3, byte bait4){
        this.bait1=bait1;
        this.bait2=bait2;
        this.bait3=bait3;
        this.bait4=bait4;
    }
    
    public byte[] getBytes(){
        byte[] baits=new byte[4];
        baits[0]=bait1;
        baits[1]=bait2;
        baits[2]=bait3;
        baits[3]=bait4;
        
        return baits;
    }
   
}
