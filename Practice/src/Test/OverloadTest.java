package Test;

import java.util.ArrayList;

public class OverloadTest {

    public static void main(String[] argv) {

        for(int i=0; i<4; i++){
            if(i==0)
                continue;

            System.out.println(i);
        }
    }
}

