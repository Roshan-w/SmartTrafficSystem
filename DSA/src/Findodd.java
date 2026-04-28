import java.util.Scanner;

public class Findodd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter "+ n + " integers");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int num:arr){
            System.out.print(num + " ");

        }
        for (int num : arr){
            if (num % 2 !=0){
                if (num % 3==0 & num % 5 ==0 ){
                    System.out.println("\nHello , num divisible by 3 and 5  :" + num);
                }
                else if (num % 7==0){
                    System.out.println("\nhii for number div by 7 : " + num);
                }
                else{
                    System.out.println("\nodd num " + num);
                }
            }
        }
    }
}
