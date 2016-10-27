/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NTHINGs
 */
public class DES {
    //MATRICES
    //PERMUTACION INICIAL
    private int IP[][]=new int[8][8];
    //PERMUTACION INICIAL INVERSA
    private int IPR[][]={{40,8,48,16,56,24,64,32},
                         {39,7,47,15,55,23,63,31},
                         {38,6,46,14,54,22,62,30},
                         {37,5,45,13,53,21,61,29},
                         {36,4,44,12,52,20,60,28},
                         {35,3,43,11,51,19,59,27},
                         {34,2,42,10,50,18,58,26},
                         {33,1,41,9,49,17,57,25}};
    //PERMUTACION DE EXPANSION E
    private int E[][]=new int[8][6];
    //FUNCION DE PERMUTACION P
    private int P[][]=new int[4][8];
    
    //PERMUTACION OPCION UNO
    private int APC1[][]=new int[4][7];
    private int BPC1[][]=new int[4][7];
    
    //PERMUTACION OPCION DOS
    private int PC2[][]=new int[6][8];
    
    //PROGRAMACION DE ROTACIONES A LA IZQUIERDA 
    private int SCH[]=new int[16];
    
    //MATRIZ DE 16 LLAVES
    boolean llaves[][]=new boolean[16][48];
    boolean llavesdes[][]=new boolean[16][48];
    
    //S-BOXES
    private int Sboxes[][][]=
                       {{{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
                         {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
                         {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
                         {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}},


                       {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
                        {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
                        {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
                        {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}},


                       {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
                        {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
                        {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
                        {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}},


                       {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
                        {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
                        {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
                        {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}},


                       {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
                        {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
                        {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
                        {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}},


                       {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
                        {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
                        {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
                        {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}},


                       {{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
                        {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
                        {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
                        {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}},

                        
                       {{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
                        {1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
                        {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
                        {2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}}};
    
    DES(boolean[] llave){
        //PERMUTACION INICIAL
        IP[0][0]=58; IP[0][1]=50; IP[0][2]=42; IP[0][3]=34; IP[0][4]=26; IP[0][5]=18; IP[0][6]=10; IP[0][7]=2;
        IP[1][0]=60; IP[1][1]=52; IP[1][2]=44; IP[1][3]=36; IP[1][4]=28; IP[1][5]=20; IP[1][6]=12; IP[1][7]=4;
        IP[2][0]=62; IP[2][1]=54; IP[2][2]=46; IP[2][3]=38; IP[2][4]=30; IP[2][5]=22; IP[2][6]=14; IP[2][7]=6;
        IP[3][0]=64; IP[3][1]=56; IP[3][2]=48; IP[3][3]=40; IP[3][4]=32; IP[3][5]=24; IP[3][6]=16; IP[3][7]=8;
        IP[4][0]=57; IP[4][1]=49; IP[4][2]=41; IP[4][3]=33; IP[4][4]=25; IP[4][5]=17; IP[4][6]=9;  IP[4][7]=1;
        IP[5][0]=59; IP[5][1]=51; IP[5][2]=43; IP[5][3]=35; IP[5][4]=27; IP[5][5]=19; IP[5][6]=11; IP[5][7]=3;
        IP[6][0]=61; IP[6][1]=53; IP[6][2]=45; IP[6][3]=37; IP[6][4]=29; IP[6][5]=21; IP[6][6]=13; IP[6][7]=5;
        IP[7][0]=63; IP[7][1]=55; IP[7][2]=47; IP[7][3]=39; IP[7][4]=31; IP[7][5]=23; IP[7][6]=15; IP[7][7]=7;
        
      
        
        //PERMUTACION DE EXPANSION E
        E[0][0]=32; E[0][1]=1;  E[0][2]=2;  E[0][3]=3;  E[0][4]=4;  E[0][5]=5;
        E[1][0]=4;  E[1][1]=5;  E[1][2]=6;  E[1][3]=7;  E[1][4]=8;  E[1][5]=9;
        E[2][0]=8;  E[2][1]=9;  E[2][2]=10; E[2][3]=11; E[2][4]=12; E[2][5]=13;
        E[3][0]=12; E[3][1]=13; E[3][2]=14; E[3][3]=15; E[3][4]=16; E[3][5]=17;
        E[4][0]=16; E[4][1]=17; E[4][2]=18; E[4][3]=19; E[4][4]=20; E[4][5]=21;
        E[5][0]=20; E[5][1]=21; E[5][2]=22; E[5][3]=23; E[5][4]=24; E[5][5]=25;
        E[6][0]=24; E[6][1]=25; E[6][2]=26; E[6][3]=27; E[6][4]=28; E[6][5]=29;
        E[7][0]=28; E[7][1]=29; E[7][2]=30; E[7][3]=31; E[7][4]=32; E[7][5]=1;
        System.out.println("MATRIZ E: ");
        for(int a=0;a<8;a++){
            for(int b=0;b<6;b++){
                System.out.print((E[a][b]-1)+", ");
            }
        }
        
        //FUNCION DE PERMUTACION P
        P[0][0]=16; P[0][1]=7;  P[0][2]=20;  P[0][3]=21;  P[0][4]=29; P[0][5]=12;  P[0][6]=28;  P[0][7]=17;
        P[1][0]=1;  P[1][1]=15; P[1][2]=23;  P[1][3]=26;  P[1][4]=5;  P[1][5]=18;  P[1][6]=31;  P[1][7]=10;
        P[2][0]=2;  P[2][1]=8;  P[2][2]=24;  P[2][3]=14;  P[2][4]=32; P[2][5]=27;  P[2][6]=3;   P[2][7]=9;
        P[3][0]=19; P[3][1]=13; P[3][2]=30;  P[3][3]=6;   P[3][4]=22; P[3][5]=11;  P[3][6]=4;   P[3][7]=25;
        
        //PERMUTACION OPCION UNO
        APC1[0][0]=57; APC1[0][1]=49; APC1[0][2]=41;  APC1[0][3]=33;  APC1[0][4]=25; APC1[0][5]=17;  APC1[0][6]=9; 
        APC1[1][0]=1;  APC1[1][1]=58; APC1[1][2]=50;  APC1[1][3]=42;  APC1[1][4]=34; APC1[1][5]=26;  APC1[1][6]=18; 
        APC1[2][0]=10; APC1[2][1]=2;  APC1[2][2]=59;  APC1[2][3]=51;  APC1[2][4]=43; APC1[2][5]=35;  APC1[2][6]=27;   
        APC1[3][0]=19; APC1[3][1]=11; APC1[3][2]=3;   APC1[3][3]=60;  APC1[3][4]=52; APC1[3][5]=44;  APC1[3][6]=36;
        
        BPC1[0][0]=63; BPC1[0][1]=55; BPC1[0][2]=47;  BPC1[0][3]=39;  BPC1[0][4]=31; BPC1[0][5]=23;  BPC1[0][6]=15; 
        BPC1[1][0]=7;  BPC1[1][1]=62; BPC1[1][2]=54;  BPC1[1][3]=46;  BPC1[1][4]=38; BPC1[1][5]=30;  BPC1[1][6]=22; 
        BPC1[2][0]=14; BPC1[2][1]=6;  BPC1[2][2]=61;  BPC1[2][3]=53;  BPC1[2][4]=45; BPC1[2][5]=37;  BPC1[2][6]=29;   
        BPC1[3][0]=21; BPC1[3][1]=13; BPC1[3][2]=5;   BPC1[3][3]=28;  BPC1[3][4]=20; BPC1[3][5]=12;  BPC1[3][6]=4; 
        
        //PERMUTACION OPCION DOS
        PC2[0][0]=14;  PC2[0][1]=17; PC2[0][2]=11;  PC2[0][3]=24;  PC2[0][4]=1;  PC2[0][5]=5;   PC2[0][6]=3;   PC2[0][7]=28;
        PC2[1][0]=15;  PC2[1][1]=6;  PC2[1][2]=21;  PC2[1][3]=10;  PC2[1][4]=23; PC2[1][5]=19;  PC2[1][6]=12;  PC2[1][7]=4;
        PC2[2][0]=26;  PC2[2][1]=8;  PC2[2][2]=16;  PC2[2][3]=7;   PC2[2][4]=27; PC2[2][5]=20;  PC2[2][6]=13;  PC2[2][7]=2;
        PC2[3][0]=41;  PC2[3][1]=52; PC2[3][2]=31;  PC2[3][3]=37;  PC2[3][4]=47; PC2[3][5]=55;  PC2[3][6]=30;  PC2[3][7]=40;
        PC2[4][0]=51;  PC2[4][1]=45; PC2[4][2]=33;  PC2[4][3]=48;  PC2[4][4]=44; PC2[4][5]=49;  PC2[4][6]=39;  PC2[4][7]=56;
        PC2[5][0]=34;  PC2[5][1]=53; PC2[5][2]=46;  PC2[5][3]=42;  PC2[5][4]=50; PC2[5][5]=36;  PC2[5][6]=29;  PC2[5][7]=32;

        //PROGRAMACION DE ROTACIONES A LA IZQUIERDA
        SCH[0]=1;
        SCH[1]=1;
        SCH[2]=2;
        SCH[3]=2;
        SCH[4]=2;
        SCH[5]=2;
        SCH[6]=2;
        SCH[7]=2;
        SCH[8]=1;
        SCH[9]=2;
        SCH[10]=2;
        SCH[11]=2;
        SCH[12]=2;
        SCH[13]=2;
        SCH[14]=2;
        SCH[15]=1;
        
        
        //LLAVES
        llaves=obtencionllaves(llave);
        
            for(int b=0;b<48;b++){
                llavesdes[0][b]=llaves[15][b];
                llavesdes[1][b]=llaves[14][b];
                llavesdes[2][b]=llaves[13][b];
                llavesdes[3][b]=llaves[12][b];
                llavesdes[4][b]=llaves[11][b];
                llavesdes[5][b]=llaves[10][b];
                llavesdes[6][b]=llaves[9][b];
                llavesdes[7][b]=llaves[8][b];
                llavesdes[8][b]=llaves[7][b];
                llavesdes[9][b]=llaves[6][b];
                llavesdes[10][b]=llaves[5][b];
                llavesdes[11][b]=llaves[4][b];
                llavesdes[12][b]=llaves[3][b];
                llavesdes[13][b]=llaves[2][b];
                llavesdes[14][b]=llaves[1][b];
                llavesdes[15][b]=llaves[0][b];
            }
            
        for(int a=0;a<16;a++){
            System.out.print("\nLlave "+(a+1)+": ");

           for(int b=0;b<48;b++){
               System.out.print(llaves[a][b]+", ");
           } 
        }
        
        for(int a=0;a<16;a++){
            System.out.print("\nLlave inversa"+(a+1)+": ");

           for(int b=0;b<48;b++){
               System.out.print(llavesdes[a][b]+", ");
           } 
        }
    }
    
    //Este metodo rota el arreglo segun el schedule de rotaciones
    private boolean[] rotarIzq(boolean [] arreglo, int posiciones){
        for (int i = 0; i < posiciones; i++) {

            boolean aux = arreglo[0];

            for (int j = 0; j < arreglo.length-1; j++) {
                arreglo[j] = arreglo[j + 1];
            }
            
            arreglo[arreglo.length-1] = aux;
        }
       
        return arreglo;
    }
    
    private boolean[][] obtencionllaves(boolean[]llave){
        boolean llavesgen[][]=new boolean[16][48];
        boolean llaveizq[]=new boolean[28];
        boolean llaveder[]=new boolean[28];
        int cont=0;
        //PERMUTACION OPCION 1
        System.out.print("\nLlave: ");
        for(int x=0;x<64;x++){
            System.out.print(llave[x]+", ");
        }
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 7; b++) {
                llaveizq[cont]=llave[APC1[a][b]-1];
                llaveder[cont]=llave[BPC1[a][b]-1];
                cont++;
            }
        }
        System.out.print("\nLlave izq: ");
        for(int x=0;x<28;x++){
            System.out.print(llaveizq[x]+", ");
        }
        System.out.print("\nLlave der: ");
        for(int x=0;x<28;x++){
            System.out.print(llaveder[x]+", ");
        }
        
        //GENERACION DE 16 SUBLLAVES
        boolean temp[]=new boolean[56];
        boolean []llaveizqantes=new boolean[28];
        boolean []llavederantes=new boolean[28];
        llaveizqantes=llaveizq;
        llavederantes=llaveder;
        for(int x=0;x<16;x++){
            
            //CORRIMIENTO A LA IZQ SEGUN EL SCHEDULE
            llaveizq=rotarIzq(llaveizqantes, SCH[x]);
            
            System.out.println("SCHEDULE: "+SCH[x]);

            llaveder=rotarIzq(llavederantes, SCH[x]);
            llaveizqantes=llaveizq;
            llavederantes=llaveder;
            
            //JUNTAR LOS DOS ARREGLOS PARA HACER LA PERMUTACION OPCION 2
            for(int b=0;b<28;b++){
                temp[b]=llaveizq[b];
            }
            cont=0;
            for(int b=28;b<56;b++){
                temp[b]=llaveder[cont];
                cont++;
            }
            
            cont=0;
            //PERMUTACION OPCION 2
            boolean permutado2[]=new boolean[48];
            for (int a = 0; a < 6; a++) {
                for (int b = 0; b < 8; b++) {
                    permutado2[cont] = temp[PC2[a][b]-1];
                    if(cont<48){
                        cont++;
                    }
                }
            }
            
            //GUARDAR LAS SUBLLAVES EN EL ARREGLO DE 16
            for(int y=0;y<48;y++){
                llavesgen[x][y]=permutado2[y];
            }
        }
        
        return llavesgen;
    }
    
    private int binarioADecimal(boolean []bits){
        int decimal=0;
        String bitstring="";
        int longitud=bits.length;
        int potencia = longitud - 1;
        
        //Convertimos el arreglo booleano a un String
        for(int x=0;x<longitud;x++){
            if(bits[x]==true){
                bitstring=bitstring+"1";
            }else{
                bitstring=bitstring+"0";
            }
            
        }       
        //Conversion del string binario a numero entero
        for(int x=0;x<longitud;x++){
           if(bitstring.charAt(x)=='1'){
            decimal+= Math.pow(2, potencia);
           }
           potencia --;
        }
        return decimal;
    }
    
    private boolean[] Binario(int Decimal) {
        String resultado="";
        int temp=Decimal;
        //Se aplica el algoritmo para convertir a binario
        while(temp != 0){
            if(temp %2 == 0){
               resultado="0"+resultado;
            }else{
                resultado="1"+resultado;
            }
            temp = temp/2;
        }
        
        //Se le agregan ceros a la izquierda, para completar 8 bits por caracter
        int cerosalaizquierda=4-resultado.length();
        for(int x=0;x<cerosalaizquierda;x++){
            resultado="0"+resultado;
        }
        
        boolean[] cuatrobits=new boolean[4];
        
        for(int x=0;x<resultado.length();x++){
            cuatrobits[x]=resultado.charAt(x)=='1';
        }
        return cuatrobits;
    }
    
    public String encriptar(boolean[] paquete){
        String encriptado = "";
        
        //Se realiza la permutacion inicial
        boolean permutado[]=new boolean[64];
        int cont=0;
        System.out.print("Permutacion inicial : ");
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                permutado[cont]=paquete[IP[a][b]-1];
                System.out.print(permutado[cont]+", ");
                cont++;
            }
        }
        System.out.print("\nMitad izq : ");
        
        boolean[] izq=new boolean[32];
        boolean[] der=new boolean[32];
        boolean[] derantes=new boolean[32];
        //Separacion del paquete para mitad izq y der
        for(int x=0;x<32;x++){
            izq[x]=permutado[x];
            System.out.print(izq[x]+", ");
            der[x]=permutado[x+32];
        }
        System.out.print("\nMitad der : ");
        for(int x=0;x<32;x++){
            System.out.print(der[x]+", ");
        }
        
        
        boolean expansion[]=new boolean[48];
        boolean xor[]=new boolean[48];
        boolean sboxeado[]=new boolean[32];
        boolean entradasbox[][]=new boolean[8][6];
        
        cont=0;
        //COMIENZAN LAS RONDAS  
        for(int i=0;i<16;i++){
            //Backup del lado derecho para pasar a ser el izquierdo al final de la ronda
            System.out.println("Der. al entrar a ronda: ");
            for(int x=0;x<32;x++){
                derantes[x]=der[x];
                if(der[x]==true){
                    System.out.println('1');
                }else{
                    System.out.println('0');
                }
            }
            //PERMUTACION DE EXPANSION
            System.out.print("\nPermutacion de expansion : ");
            cont=0;
            char bit='1';
            for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 6; b++) {
                    if(der[E[a][b]-1]==false){
                        bit='0';
                    }else{
                        bit='1';
                    }
                    System.out.println("Bit: "+bit+" Es el de la pos: "+(E[a][b]-1));
                    expansion[cont] = der[E[a][b]-1];
                    //System.out.print(expansion[cont]+", ");
                    cont++;
                }
            }
            //XOR CON LA LLAVE DE 
            System.out.print("\nXOR con llave");
            for (int a = 0; a < 48; a++) {
                xor[a] = expansion[a] != llaves[i][a];
                System.out.print(xor[a]+", ");
            }
            
            //Preparamos la entrada a 8 paquetes de 6 bits
            cont=0;
            System.out.print("\nEntradas a sbox: \n");
            for (int a = 0; a < 8; a++) {
                System.out.print((a+1) +". ");
                for (int b = 0; b < 6; b++) {
                    entradasbox[a][b] = xor[cont];
                    System.out.print(entradasbox[a][b]+", ");
                    cont++;
                }
                System.out.print("\n");
            }
            
            //Comienza el proceso de s-box 
            cont=0;
            boolean cuatrobits[]=new boolean[4];
            boolean dosbits[]=new boolean[2];
            for (int a = 0; a < 8; a++) {
                //System.out.println("ENTRE: "+a);
                //Separación de los 4 bits de enmedio para la columna de la sbox
                //System.out.print("\nSBOX: "+a);
                dosbits[0]=entradasbox[a][0];
                cuatrobits[0]=entradasbox[a][1];
                cuatrobits[1]=entradasbox[a][2];
                cuatrobits[2]=entradasbox[a][3];
                cuatrobits[3]=entradasbox[a][4];
                dosbits[1]=entradasbox[a][5];
                System.out.println("Renglon: "+binarioADecimal(dosbits));
                System.out.println("Columna: "+binarioADecimal(cuatrobits));
                System.out.println("SBOX: "+a);
                System.out.println("SBOX: ");
                for(int x=0;x<4;x++){
                    for(int y=0;y<16;y++){
                        System.out.print(Sboxes[a][x][y]+", ");
                    }
                }
                boolean temp[]=Binario(Sboxes[a][binarioADecimal(dosbits)][binarioADecimal(cuatrobits)]);
                for(int b=0;b<4;b++){
                    sboxeado[cont]=temp[b];
                    //System.out.println("VALOR SBOX: "+Sboxes[a][0][binarioADecimal(cuatrobits)]);
                    //System.out.print(sboxeado[cont]+", ");
                    cont++;
                }
                
                //System.out.print("\n");
            }
            
            System.out.println("SBOXEADO: ");
            for(int x=0;x<sboxeado.length;x++){
                System.out.print(sboxeado[x]);
            }
            //Permutacion P
            
            boolean []permutacionp=new boolean[32];
            cont=0;
            System.out.print("\nPermutacion P: ");
            for(int a=0;a<4;a++){
                for(int b=0;b<8;b++){
                    permutacionp[cont]=sboxeado[P[a][b]-1];
                    System.out.print(permutacionp[cont]+", ");
                    cont++;
                }
            }
            System.out.print("\nIZQ: ");
            for(int x=0;x<32;x++){
                System.out.print(izq[x]+", ");
            }
            //XOR CON LA MITAD IZQUIERDA
            System.out.print("\nXOR CON LA MITAD IZQ: ");
            for(int x=0;x<32;x++){
                der[x]=permutacionp[x] != izq[x];
                System.out.print(der[x]+", ");
            }
            
            for(int x=0;x<32;x++){
                izq[x]=derantes[x];
            }
            System.out.print("\n Mitad izq despues de ronda: ");
            for(int x=0;x<32;x++){
                System.out.print(izq[x]+", ");
            }
            System.out.print("\n Mitad der despues de ronda: ");
            for(int x=0;x<32;x++){
                System.out.print(der[x]+", ");
            }
            
        }
        
        //TODO: AQUI FALTA COMPROBAR
        
        //PEGAR MITADES
        
        for(int x=0;x<32;x++){
            paquete[x]=der[x];
            paquete[x+32]=izq[x];
        }
        
        //PERMUTACION INVERSA
        System.out.print("\nPERMUTACION INVERSA: ");
        boolean [] permutadofinal=new boolean[64];
        cont=0;
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                permutadofinal[cont]=paquete[IPR[a][b]-1];
                System.out.print(permutadofinal[cont]+", ");
                cont++;
            }
        }
        
        //Concatenado del arreglo a un string
        for(int x=0;x<64;x++){
            if(permutadofinal[x]==true){
                encriptado=encriptado+"1";
            }else{
                encriptado=encriptado+"0";
            }
        }
        System.out.print("\n Encriptado: "+encriptado);
        
        return encriptado;
    }
    
}
