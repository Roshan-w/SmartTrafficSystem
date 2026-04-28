package logic;

import java.util.Arrays;

public class RatingAnalyzer {
    public static void main(String[] args) {
        int[] ratingsA= {4,5,3,2,1,4,5,3};
        int[] ratingsB= {4,4,1,3,3,3,2,1};
        int[] ratingsC= {3,3,1,2,3,2,2,1};

        int summ = 0;
        int maxA = Arrays.stream(ratingsA).max().getAsInt();
        int maxB = Arrays.stream(ratingsB).max().getAsInt();
        int maxC = Arrays.stream(ratingsC).max().getAsInt();

        for( int i : ratingsA){
            summ = summ+i;
        }
        double averageA=summ/ratingsA.length;
        summ = 0;
        for( int i : ratingsB){
            summ = summ+i;
        }
        double averageB=summ/ratingsA.length;
        summ = 0;
        for( int i : ratingsC){
            summ = summ+i;
        }
        double averageC=summ/ratingsA.length;

        System.out.println("Restraurant A: ");
        System.out.println("Maximum Rating of A : " + maxA);
        System.out.println("Average Rating of A : "+averageA);

        System.out.println("========");
        System.out.println("Restraurant B: ");
        System.out.println("Maximum Rating of B : " + maxB);
        System.out.println("Average Rating of B : "+averageB);

        System.out.println("========");
        System.out.println("Restraurant C: ");
        System.out.println("Maximum Rating of C : " + maxC);
        System.out.println("Average Rating of C : "+averageC);

        System.out.println("===============\n");
        if(maxA>maxB && averageA>averageB){
            System.out.println("Best Restraurant  is A with Highest rating "+ maxA + "Average Rating :" + averageA);
        }else if (maxA<maxB && averageA<averageB){
            System.out.println("Best Restraurant  is B with Highest rating "+ maxB + "Average Rating :" + averageB);
        }else {
            System.out.println("Best Restraurant  is C with Highest rating: "+ maxC + " Average Rating :" + averageC);
        }


    }
}
