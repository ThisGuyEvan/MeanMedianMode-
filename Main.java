import java.util.*;
import java.io.*;


class Main {
  public static void main(String[] args) throws IOException{

    Scanner input = new Scanner(new File("Sat.txt"));

    int [] SAT = new int [71];
    int i = 0;

    while(input.hasNextInt()){
      SAT[i++] = input.nextInt();
    }
    System.out.println("Average: " + getAverage(SAT));
    System.out.println("Mode: " + getMode(SAT));
    System.out.println("Median: " + getMedian(SAT));
  }
  

   static int getAverage(int[] scores){
     int sum = 0;
     for(int i = 0; i<=scores.length-1; i++) {
       sum+=scores[i];
     }
     return sum/scores.length;
   }

   static int getMode(int[] scores){
     int max = 0;
     int maxValue = 0;
     int count = 0;
     for(int i = 0; i<scores.length-1; i++) {
       count = 0;
       for(int j = 0; j<scores.length-1; j++) {
         if(scores[j] == scores[i]) {
           count++;
         }
       }

       if(count>max) {
         max = count;
         maxValue = scores[i];
       }
     }
     return maxValue;
   }


   static int getMedian(int[] scores) {
     for (int i = 0; i<scores.length; i++) {
      for (int j = i + 1; j<scores.length; j++) {
        int switchNum = 0;
        if (scores[i] > scores[j]) {
          switchNum = scores[i];
          scores[i] = scores[j];
          scores[j] = switchNum;
        }
      }
     }
    if (scores.length % 2 != 0) {
      return scores[scores.length / 2]; 
    }
   return (scores[scores.length - 1 / 2] + scores[scores.length / 2]) / 2; 
  }
}