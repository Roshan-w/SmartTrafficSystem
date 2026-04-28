import java.util.Scanner;

public class Array {
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

        System.out.println("\nEven numbers in the array are: ");
        int count =0;
        for(int num : arr){
            if(num%2==0){
                System.out.print(num + " ");
                count++;

            }
        }
        System.out.println("\nCount of even number: " + count);


    }
}


