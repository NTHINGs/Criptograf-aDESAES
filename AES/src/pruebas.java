/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nthings
 */
public class pruebas {
    public static byte rotateRight(byte bits, int shift) {
        return (byte) (((bits & 0xff) >>> shift) | ((bits & 0xff) << (8 - shift)));
    }

    public static byte rotateLeft(byte bits, int shift) {
        return (byte) (((bits & 0xff) << shift) );
    }
    
    public static byte xor(byte byte1, byte byte2){
        // convertir a enteros y hacer el xor
        int one = (int) byte1;
        int two = (int) byte2;
        int xor = one ^ two;

        // convertir de nuevo a byte
        return (byte) (0xff & xor);
    }
    
    public static byte[] rotar(byte[] vect, int distancia, boolean derecha) {
        if(distancia==0){
            return vect;
        }
        byte[] array=new byte[vect.length];
        if (derecha) {
            for (int i = 0; i < distancia; i++) {
                byte aux = vect[vect.length - 1];

                for (int j = vect.length - 2; j >= 0; j--) {
                    array[j + 1] = vect[j];
                }

                array[0] = aux;
            }
        } else {
            for (int i = 0; i < distancia; i++) {
                byte aux = vect[0];

                for (int j = 0; j < vect.length - 1; j++) {
                    array[j] = vect[j + 1];
                }

                array[vect.length - 1] = aux;
            }
        }
        return array;
    }
    
    public static byte xorarray(byte[] array){
        for(int x=0;x<array.length;x++){
            if(x==array.length-1){
                break;
            }
            int one = (int) array[x];
            int two = (int) array[x+1];
            
            array[x+1]=(byte) (0xff & (one ^ two));
        }
        
        return array[array.length-1];
    }
    public static byte multiplicarpor2(byte bait){
        String baitbinario=Integer.toBinaryString(bait & 0xff);
        
        int ceros = 8 - baitbinario.length();
                for (int a = 0; a < ceros; a++) {
                    baitbinario = "0" + baitbinario;
                }
        
        if(baitbinario.charAt(0)=='1'){
            byte constante=(byte)Short.parseShort("00011011", 2);
            byte temp=(byte)((bait & 0xff) << 1);
            System.out.println("rotado :"+Integer.toBinaryString(temp &0xFF));
            temp=xor(temp,constante);
            return temp;
        }else{
            byte temp=(byte)((bait & 0xff) << 1);
            return temp;
        }
    }
    
    
    public static void main(String args[]){
        String bb = "11000111";
        byte bait = (byte) Short.parseShort(bb, 2);
        String s = Integer.toBinaryString(bait & 0xFF);
        System.out.println("Bits: "+s);
        System.out.println("Hex: "+ Integer.toHexString(bait & 0xFF));
        
        byte baitrotadoizq=rotateLeft(bait,1);
        byte baitrotadoder=rotateRight(bait,1);
        
        String baitizq= Integer.toBinaryString(baitrotadoizq & 0xFF);
        String baitder= Integer.toBinaryString(baitrotadoder & 0xFF);
        System.out.println("Rotado izq: "+baitizq);
        System.out.println("Rotado izq hex: "+Integer.toHexString(baitrotadoizq & 0xFF));
        System.out.println("Rotado der: "+baitder);
        System.out.println("Rotado der hex: "+Integer.toHexString(baitrotadoder & 0xFF));
        
        //XOR
        byte bait2 = (byte) Short.parseShort("00111000", 2);
        byte xor=xor(bait,bait2);
        System.out.println("XOR: "+ Integer.toBinaryString(xor & 0xFF));
        System.out.println("XOR Hex: "+ Integer.toHexString(xor & 0xFF));
        
        
        byte[] baits=new byte[3];
        baits[0]=bait;
        baits[1]=bait2;
        baits[2]=xor;
        byte[] rotar=rotar(baits,0,false);
        
        System.out.println("BYTE 1: " + Integer.toBinaryString(rotar[0] & 0xFF));

        System.out.println("BYTE 2: " + Integer.toBinaryString(rotar[1] & 0xFF));
        System.out.println("BYTE 3: " + Integer.toBinaryString(rotar[2] & 0xFF));
        
        String bb2 = "10000001";
        byte bai = (byte) Short.parseShort(bb2, 2);
        bai=rotateLeft(bai,1);
        String sa = Integer.toBinaryString(bai & 0xFF);
        
        System.out.println("Byte rotado: "+sa);
        
        String b="fb";
        byte bt=(byte) Short.parseShort(b,16);
        System.out.println(bt);
        System.out.println("primeros 4 bits: "+Integer.toBinaryString(bt & 0xFF).substring(4, 8));
        
        String b1="a";
        byte bait1=(byte) Short.parseShort(b1,16);
        byte bait22=(byte) Short.parseShort(b1,16);
        byte bait3=(byte) Short.parseShort(b1,16);
        byte[] array=new byte[]{bait1,bait22,bait3};
        System.out.println("XOR ARRAY " + Integer.toBinaryString(xorarray(array) & 0xFF));
        
        System.out.println("fb :"+Integer.toBinaryString(bt & 0xFF));
        byte btrotad=(byte)((bt & 0xff) << 1);
        System.out.println("fb rotado :"+Integer.toBinaryString(btrotad & 0xFF));
        
        byte constante=(byte)Short.parseShort("ab", 16);
        System.out.println("x2:"+Integer.toBinaryString(constante & 0xFF));
        System.out.println("x2:"+Integer.toBinaryString(multiplicarpor2(constante) & 0xFF));
        
    }
}
