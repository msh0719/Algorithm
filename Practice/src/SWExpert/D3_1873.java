package SWExpert;

import java.util.Scanner;

class BattleField {
    public String map[][];
    public int H;
    public int W;
    public int nowTanKX;
    public int nowTanKY;

    public static int TankPos(String pos){
        if(pos.equals("^")){
            return 0;
        }
        else if( pos.equals("v")){
            return 1;
        }
        else if(pos.equals(">")){
            return 2;
        }
        else if(pos.equals("<")){
            return 3;
        }
        else{
            return -1;
        }
    }
    public void play(String pos){
        switch(pos){
            case "U":
                map[nowTanKX][nowTanKY] = "^";
                if( nowTanKX - 1 >= 0){
                    if(map[nowTanKX-1][nowTanKY].equals(".")) {
                        map[nowTanKX][nowTanKY] = ".";
                        nowTanKX -= 1;
                        map[nowTanKX][nowTanKY] = "^";
                        break;
                    }
                }
                break;
            case "D":
                map[nowTanKX][nowTanKY] = "v";
                if( nowTanKX + 1 < H){
                    if( map[nowTanKX+1][nowTanKY].equals(".")) {
                        map[nowTanKX][nowTanKY] = ".";
                        nowTanKX += 1;
                        map[nowTanKX][nowTanKY] = "v";
                        break;
                    }
                }
                break;
            case "R":
                map[nowTanKX][nowTanKY] = ">";
                if( nowTanKY+ 1 < W) {
                    if (map[nowTanKX][nowTanKY + 1].equals(".")) {
                        map[nowTanKX][nowTanKY] = ".";
                        nowTanKY += 1;
                        map[nowTanKX][nowTanKY] = ">";
                        break;
                    }
                }
                break;
            case "L":
                map[nowTanKX][nowTanKY] = "<";
                if( nowTanKY - 1 >= 0 ){
                    if(map[nowTanKX][nowTanKY-1].equals(".")) {
                        map[nowTanKX][nowTanKY] = ".";
                        nowTanKY -= 1;
                        map[nowTanKX][nowTanKY] = "<";
                        break;
                    }
                }
                break;
            case "S":

                shoot(TankPos(map[nowTanKX][nowTanKY]));
                break;
        }
    }
    public void shoot(int pos){
        switch(pos){
            case 0:
                for(int i=0; i<H; i++) {
                    if (nowTanKX - i >= 0 && map[nowTanKX-i][nowTanKY].equals("*")) {
                        map[nowTanKX - i][nowTanKY] = ".";
                        break;
                    }
                    else if(nowTanKX - i >= 0 && map[nowTanKX-i][nowTanKY].equals("#")){
                        break;
                    }
                    else if(nowTanKX - i  < 0){
                        break;
                    }
                }
                break;
            case 1:
                for(int i=0; i<H; i++) {
                    if (nowTanKX + i < H && map[nowTanKX+i][nowTanKY].equals("*")) {
                        map[nowTanKX+i][nowTanKY] = ".";
                        break;
                    }
                    else if(nowTanKX + i < H && map[nowTanKX+i][nowTanKY].equals("#")){
                        break;
                    }
                    else if(nowTanKX + i >= H){
                        break;
                    }
                }
                break;
            case 2:
                for(int i=0; i<W; i++) {
                    if (nowTanKY + i < W && map[nowTanKX][nowTanKY+i].equals("*")) {
                        map[nowTanKX][nowTanKY+i] = ".";
                        break;
                    }
                    else if(nowTanKY + i <W && map[nowTanKX][nowTanKY+i].equals("#")){
                        break;
                    }
                    else if(nowTanKY + i >= W){
                        break;
                    }
                }
                break;
            case 3:
                for(int i=0; i<W; i++) {
                    if (nowTanKY - i >= 0 && map[nowTanKX][nowTanKY-i].equals("*")) {
                        map[nowTanKX][nowTanKY-i] = ".";
                        break;
                    }
                    else if(nowTanKY - i >= 0 && map[nowTanKX][nowTanKY-i].equals("#")){
                        break;
                    }
                    else if(nowTanKY - i < 0){
                        break;
                    }
                }
                break;
        }
    }
}
public class D3_1873 {

    public static void main(String[] args) {
        int testCase;
        int N;
        String field;
        String moveOrder;
        BattleField bf[];
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        bf = new BattleField[testCase];

        for (int i = 0; i < testCase; i++) {
            bf[i] = new BattleField();
            bf[i].H = sc.nextInt();
            bf[i].W = sc.nextInt();
            bf[i].map = new String[bf[i].H][bf[i].W];
            for (int j = 0; j < bf[i].H; j++) {
                field = sc.next();
                for (int k = 0; k < bf[i].W; k++) {
                    bf[i].map[j][k] = field.substring(k, k + 1);
                    if(bf[i].TankPos(bf[i].map[j][k]) != -1){
                            bf[i].nowTanKX = j;
                            bf[i].nowTanKY= k;
                    }
                }
            }
            N = sc.nextInt();
            moveOrder = sc.next();
            for(int j=0; j<moveOrder.length(); j++ ){
                bf[i].play(moveOrder.substring(j, j+1));
            }
        }
        for (int i = 0; i < testCase; i++) {
            System.out.print("#" + (i + 1) + " ");
            for (int j = 0; j < bf[i].H; j++) {
                for (int k = 0; k < bf[i].W; k++) {
                    System.out.print(bf[i].map[j][k]);
                }
                System.out.println();
            }
        }
    }

}
