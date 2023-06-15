import java.util.Scanner;
import java.lang.Math;
public class encrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Message");
        String msg = input.nextLine();
        System.out.println(msg.length());
        double asciiVal[]= new double[msg.length()];
        for(int i = 0; i < msg.length() ; i++) {
            char c = msg.charAt(i);
            int ValC = c;
            asciiVal[i] = ValC;
        }
        double[][] asciiBit;
        asciiBit = new double[msg.length()][7];
        for(int i = 0; i < msg.length() ; i++) {
            double y = asciiVal[i];
            for(int k = 0; k < 7 ; k++) {
                double x = Math.floor(y/(Math.pow(2, 6-k)));
                y = y%(Math.pow(2, 6-k));
                asciiBit[i][k] = x;
            }
        }
        double[] initVec = {0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < 10 ; i++) {
            System.out.println("input "+i+"th initial vector value");
            initVec[i] = Integer.parseInt(input.nextLine());
        }
        for(int i = 0; i < msg.length() ; i++) {
            double[] p = {0,0,0,0,0,0,0,0,0,0};
            p[0]=initVec[2];
            p[1]=initVec[7];
            p[2]=initVec[4];
            p[3]=initVec[5];
            p[4]=initVec[6];
            p[5]=initVec[8];
            p[6]=initVec[0];
            p[7]=initVec[3];
            p[8]=initVec[9];
            p[9]=initVec[1];
            initVec[0]=initVec[7];
            initVec[1]=initVec[8];
            initVec[2]=initVec[9];
            for(int k = 0; k < 7 ; k++) {
                asciiBit[i][k]=(asciiBit[i][k]+p[k])%2;
                System.out.print(Math.round(asciiBit[i][k]));
                initVec[k+3]=asciiBit[i][k];
            }

        }
        for(int i=0; i<msg.length(); i++){
            asciiVal[i]=64*asciiBit[i][0]+32*asciiBit[i][1]+16*asciiBit[i][2]+8*asciiBit[i][3]+4*asciiBit[i][4]+2*asciiBit[i][5]+asciiBit[i][6];
        }
    input.close();
    }
}