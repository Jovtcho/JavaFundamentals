import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        // String str = "ABCD" + '\0' + '\0' + '\0' + '\0' + '\0' + "EFGH";
        //  str = str.replaceAll("\0", "");

        // System.out.println(str);
        // //System.out.println(newStr);


        String str1 = "ABC,DEF:GHI,JKL:MNO";
        String str2 = "ABC,,,,DEF,,GHI,,JKL,MNO";
        String[] strArr1 = str1.split("[,:]");
        String[] strArr2 = str2.split(",", -1);

        System.out.println(str1);
        System.out.println(Arrays.toString(strArr1));

        System.out.println();

        System.out.println(str2);
        System.out.println(Arrays.toString(strArr2));


        System.out.println(90 % 360);
        System.out.println(180 % 360);
        System.out.println(270 % 360);
        System.out.println(360 % 360);
        System.out.println(450 % 360);
        System.out.println(540 % 360);
        System.out.println(630 % 360);
        System.out.println(720 % 360);
    }
}