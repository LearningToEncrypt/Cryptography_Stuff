import java.util.Scanner;
import java.lang.Math;
public class CBC_encrypt {
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
                System.out.print(Math.round(asciiBit[i][k]));
            }
        }
        System.out.println("  ");
        System.out.println("  ");
        double[] initVec = {0,0,0,0,0,0,0};
        for(int i = 0; i < 7 ; i++) {
            System.out.println("input "+i+"th initial vector value");
            initVec[i] = Integer.parseInt(input.nextLine());
        }
        for(int i = 0; i < msg.length() ; i++) {
            double[] p = {0,0,0,0,0,0,0,0,0,0};
            for (int j = 0; j < 7; j++) {
                initVec[j] = (initVec[j]+asciiBit[i][j])%2;
            }
            p[0]=initVec[4];
            p[1]=initVec[6];
            p[2]=initVec[0];
            p[3]=initVec[1];
            p[4]=initVec[5];
            p[5]=initVec[2];
            p[6]=initVec[3];
            for(int k = 0; k < 7 ; k++) {
                asciiBit[i][k]=p[k];
                System.out.print(Math.round(asciiBit[i][k]));
                initVec[k]=asciiBit[i][k];
            }

        }
        for(int i=0; i<msg.length(); i++){
            asciiVal[i]=64*asciiBit[i][0]+32*asciiBit[i][1]+16*asciiBit[i][2]+8*asciiBit[i][3]+4*asciiBit[i][4]+2*asciiBit[i][5]+asciiBit[i][6];
            /* char ch = (char) Math.round(asciiVal[i]);
            System.out.print(ch); */
        }
    input.close();
    }
}