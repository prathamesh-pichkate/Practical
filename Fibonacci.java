// 1. Non-recursive Fibonacci:

// public class Fibonacci {
//     public static int fibonacciCode(int n){
//         int start = 0, end = 1, sum = 0;

//         for(int i=2;i<=n;i++){
//             sum = start +end;
//             start = end;
//             end = sum;
//         }
//         return end;
//     }
//     public static void main(String args[]){
//         int n = 5;
//         System.out.println(fibonacciCode(n));
//     }
// }

// The TC and SC for non-recursion Fibonacci is O(n) and O(1) respectively.



// 2. Recursive Fibonacci:
// public class Fibonacci {
//     public static int fibonacciCode(int n){
//         if(n == 0 || n == 1){
//             return n;
//         }

//         return fibonacciCode(n-1) + fibonacciCode(n-2);
//     }
//     public static void main(String args[]){
//         int n = 5;
//         System.out.println(fibonacciCode(n));
//     }
// }

// The TC and SC for recursion Fibonacci is O(2^n) and O(n) respectively.