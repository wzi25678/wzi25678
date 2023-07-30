//package sanke赛克;
///*
//
// */
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main02 {
//    private int n,k;
//    private static int arr_t [];
//    private static int arr_gold[];
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int time = n;
//        int k = scanner.nextInt();
//        int arr_flower[] = new int[n];      //0代表当前地方的花没有被拿走了，1代表被拿走了
//        int gold[] = new int [n];
//        arr_t = new int[n];
//        arr_gold = new int[n];
//        for (int i=1;i<n;i++){
//            arr_t[i] = scanner.nextInt();
//        }
//        for (int i=1;i<n;i++){
//            arr_gold[i] = scanner.nextInt();
//        }
//        int cur_k = 0;//当前拿了多少花
//        for (int i=0;i<time;i++){
//            //此时拿花
//            if (cur_k <k){
//                takeFlower(arr_flower,arr_t,arr_gold);
//            }
//            //获得此时所得的金币数
//            gold[i] = thisTimeGold;
//
//            //花开始消逝
//            for (int iiii=0;iiii<n;iiii++){
//                if (arr_t[iiii]!=0){
//                    arr_t[iiii]--;
//                    if (arr_flower[iiii] == 1){
//                        k--;
//                        arr_flower[iiii] = 0;
//                    }
//                }
//            }
//        }
//        Arrays.sort(gold);
//        System.out.println(gold[gold.length-1]);
//    }
//
//    /**
//     *
//     * @param arr_flower
//     * @param arr_t
//     */
//    private static void takeFlower(int[] arr_flower, int[] arr_t,int [] arr_gold) {
//        int index ;
//        for (int i=0;i< arr_t.length;i++){
//            if (arr_flower[i] == 0){
//                if (arr_t[i] != 0){
//
//                }
//            }
//        }
//    }
//}
