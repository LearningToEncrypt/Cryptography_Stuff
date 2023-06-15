import java.util.Scanner;
public class decrypt {
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
        double[] initVec = {0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < 10 ; i++) {
            System.out.println("input "+i+"th initial vector value");
            initVec[i] = Integer.parseInt(input.nextLine());
        }
        for(int i = 0; i < msg.length()/7 ; i++) {
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
                initVec[k+3]=asciiBit[i][k];
                asciiBit[i][k]=(asciiBit[i][k]+p[k])%2;
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