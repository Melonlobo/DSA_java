import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        /*int N = 100001;
        int rev = 0;
        while (N > 0) {
            rev = rev * 10 + N % 10;
            N /= 10;
        }
        if (N == rev) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }*/
        //int x = isPalindrome("A man, a plan, a canal: Panama");
        //int[] numbers = {1, 3, 4, 6, 8, 23, 45, 56, 67, 78, 89, 99};
        //int targetFound = binarySearch(numbers, 99);
        //int count = solve("abc");
//        int[] nums = {1, 2, 3, 5, 6};
//        int[] pos = TwoSum(nums, 9);
//        System.out.println("Positions: "+ pos[0] + " " + pos[1]);
//        System.out.println("Numbers: "+ nums[pos[0]] + " " + nums[pos[1]]);
        int sum = FindSum(-41,41);
        System.out.println("Sum: " + sum);
    }
    public static int FindSum(int a, int b) {
        int sum = 0;
        int mask = Integer.MAX_VALUE;
        while ((mask&b) > 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        if(b < 0) return mask & sum;
        return sum;
    }
    public static int[] TwoSum(int[] nums, int target) {
        Map<Integer, Integer> existingNums = new HashMap<Integer, Integer>();
        int arrLen = nums.length;
        for (int i = 0; i < arrLen; i++) {
            int num = target - nums[i];
            if (existingNums.containsKey(num)) {
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = existingNums.get(num);
                return pos;
            } else {
                existingNums.put(nums[i], i);
            }
        }
        return new int[2];
    }
    public static int solve(String A) {
        int count = 0;
        int n = A.length();
        for(int i = 0 ; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                char[] str = A.substring(i, j).toCharArray();
                int x = str.length - 1;
                if((str[0] == 'a' || str[0] == 'e' || str[0] == 'i' || str[0] == 'o' || str[0] == 'u') && !(str[x] == 'a' || str[x] == 'e' || str[x] == 'i' || str[x] == 'o' || str[x] == 'u')){
                    count++;
                }
            }
        }
        return count;
    }
    public static int binarySearch(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (numbers[m] > target) {
                r = m - 1;
            } else if (numbers[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    public static int isPalindrome(String A) {
        String a = A.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] b = a.toCharArray();
        int n = b.length;
        char[] c = new char[n];
        int y = 0;
        for(int x = n - 1; x >= 0;  x--){
            c[y] = b[x];
            y++;
        }
        String rev = new String(c);
        if(a.equals(rev)) return 1;
        else return 0;
    }
}