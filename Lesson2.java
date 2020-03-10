import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Character.*;

public class Lesson2 {

    //String first = new String "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static String string;
    private  static int[][] array;

//    private static String stringOne;
//    private  static String stringTwo;
//    private  static String stringThree;
//    private  static  String stringFour;
    private static String[][] twoDimensionalStringArray;

     public static void main(String[] args) {


         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         try {
             string  = reader.readLine();
         } catch (IOException e) {
             e.printStackTrace();
         }
         try {
             reader.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
//         try {
////             array = transformStringToArray4x4(string);
////         } catch (Array4x4Exeption | NotNumberExeption array4x4Exeption) {
////             array4x4Exeption.printStackTrace();
////         }
////         System.out.println(string);

         try {
             twoDimensionalStringArray = transfornStringToMatrix(string);
         } catch (NotNumberExeption notNumberExeption) {
             notNumberExeption.printStackTrace();
             notNumberExeption.e();
         } catch (Array4x4Exeption array4x4Exeption) {
             array4x4Exeption.printStackTrace();
             array4x4Exeption.e();
         }

         for (int i = 0; i <twoDimensionalStringArray.length ; i++) {
             for (int j = 0; j < twoDimensionalStringArray[0].length; j++) {
                 System.out.print("    " + twoDimensionalStringArray[i][j]);
             }
             System.out.println();
         }

         System.out.println("Summ = " + calculations(twoDimensionalStringArray));


     }//main

    private  static double calculations (String[][] s){
       double res = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j <s[0].length ; j++) {
               StringTokenizer tokenizer = new StringTokenizer(s[i][j]);
               while (tokenizer.hasMoreTokens()) {
                   res = res + Integer.parseInt(tokenizer.nextToken());
               }
            }
        }
        return res/2;
    }//calculations

    private static String[][] transfornStringToMatrix (String s) throws NotNumberExeption, Array4x4Exeption {
         String stringM[][] = new String[2][2];
        if (checkTransformable(s)) {
            StringTokenizer tokenizer = new StringTokenizer(s, "\\n");
            int i = 0, j = 0;
            while (tokenizer.hasMoreTokens()){
                stringM[i][j] = tokenizer.nextToken();
                i = (j == 1)?i+1:i;
                j = (j == 0)?j+1:0;
            }
        }
        return stringM;
    }//transfornStringToMatrix

    private static boolean checkTransformable (String s) throws Array4x4Exeption, NotNumberExeption {
         char[] c = s.toCharArray();
         int carr = 0;
         boolean flag = false;
         int k = 0, j = 0;
        for (int i = 0;  i <c.length ; i++) {
            if (isDigit(c[i])) {
                flag = true;
                carr = carr*10 + c[i] - 48;
            } else {
                if (c[i] == ' ' & flag == true) {
                    j = j + 1;
                    carr = 0;
                    flag = false;
                } else {
                    if (c[i] == '\\' & i+1 <c.length & c[i+1] == 'n' & flag == true) {
                        k = k + 1;
                        if (j !=3) {
                            throw new Array4x4Exeption();
                        }
                        j = 0;
                        i = i +1;
                        carr = 0;
                        flag = false;
                    } else {
                        throw new NotNumberExeption();
                    }
                }
            }
        }//for
        if (k != 3 | j !=3 ) {
            throw new Array4x4Exeption();
        }
        return true;
    }//checkTransformable

//    private static int[][]   transformStringToArray4x4  (String s) throws Array4x4Exeption, NotNumberExeption {
//         char[] c = s.toCharArray();
//         int[][] arr = new  int[4][4];
//         int carr = 0;
//         boolean flag = false;
//         int k = 0, j = 0;
//        for (int i = 0;  i <c.length ; i++) {
//            if (isDigit(c[i])) {
//                flag = true;
//                carr = carr*10 + c[i] - 48;
//            } else {
//                if (c[i] == ' ' & flag == true) {
//                    arr[k][j] = carr;
//                    j = j + 1;
//                    carr = 0;
//                    flag = false;
//                } else {
//                    if (c[i] == '\\' & i+1 <c.length & c[i+1] == 'n' & flag == true) {
//                        arr[k][j] = carr;
//                        k = k + 1;
//                        if (j !=3) {
//                            throw new Array4x4Exeption();
//                        }
//                        j = 0;
//                        i = i +1;
//                        carr = 0;
//                        flag = false;
//                    } else {
//                        throw new NotNumberExeption();
//                    }
//                }
//            }
//        }//for
//        if (k != 3 | j !=3 ) {
//            throw new Array4x4Exeption();
//        }
//        return arr;
//    }//transformStringToArray4x4




//    private static int stringToInt (String string) throws NotNumberExeption {
//         char[] c = string.toCharArray();
////         int prev = 0;
//           int carr = 0;
// //          carr = Integer.parseInt(string);
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] >= 48 && c[i] <= 57) {
//               carr = carr*10 + c[i]-48;
//            } else {
//                throw new NotNumberExeption();
//            }
//        }
//        return carr;
//    }
}//Lesson 2
