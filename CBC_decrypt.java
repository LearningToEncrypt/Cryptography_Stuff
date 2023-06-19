import java.util.Scanner;
public class CBC_decrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Message");
        String msg = input.nextLine();
        System.out.println(msg.length());
        double asciiVal[]= new double[msg.length()/7];
        double[][] asciiBit;
        asciiBit = new double[msg.length()/7][7];
        for(int i = 0; i < msg.length()/7 ; i++) {
            for(int k = 0; k < 7 ; k++) {
                char c = msg.charAt(i*7+k);
                int ValC = c;
                ValC= ValC-48;
                asciiBit[i][k] = ValC;
            }
        }
        System.out.println("  ");
        System.out.println("  ");
        double[] initVec = {0,0,0,0,0,0,0};
        for(int i = 0; i < 7 ; i++) {
            System.out.println("input "+i+"th initial vector value");
            initVec[i] = Integer.parseInt(input.nextLine());
        }
        for(int i = 0; i < msg.length()/7 ; i++) {
            double[] p = {0,0,0,0,0,0,0};
            p[0]=asciiBit[i][2];
            p[1]=asciiBit[i][3];
            p[2]=asciiBit[i][5];
            p[3]=asciiBit[i][6];
            p[4]=asciiBit[i][0];
            p[5]=asciiBit[i][4];
            p[6]=asciiBit[i][1];
            for(int k = 0; k < 7 ; k++) {
                p[k]=(p[k]+initVec[k])%2;
                initVec[k]=asciiBit[i][k];
            }
            for (int j = 0; j < 7; j++) {
                asciiBit[i][j]=p[j];
            } 
        }
        for(int i=0; i<msg.length()/7; i++){
            asciiVal[i]=64*asciiBit[i][0]+32*asciiBit[i][1]+16*asciiBit[i][2]+8*asciiBit[i][3]+4*asciiBit[i][4]+2*asciiBit[i][5]+asciiBit[i][6];
            char ch = (char) asciiVal[i];
            System.out.print(ch);
        }
        input.close();
    }
}