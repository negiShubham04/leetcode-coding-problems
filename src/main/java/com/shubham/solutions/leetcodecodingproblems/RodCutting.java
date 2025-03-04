package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://www.geeksforgeeks.org/problems/rod-cutting0840/1">Rod cutting</a>
 */
public class RodCutting {

    public int cutRod(int[] prices) {
        int n = prices.length;
        int []ans = new int[n+1];
        ans[0]=0;
        ans[1] = prices[0];
        int i,j;
        int value = ans[1];
        //converted recursive to tabulation
        for(i=2;i<=n;i++){
            int max =Integer.MIN_VALUE;
            for(j=1;j<=i;j++){
                max = Math.max(max, prices[j-1] + (i-j>=0?ans[i-j]: 0));
            }
            ans[i]= max;
            value = Math.max(ans[i], value);
        }
        return value;
    }

    // recursive
    private int findRodCut(int []prices, int i){
        int n = prices.length;
        if(i<=0)return 0;
        int max =Integer.MIN_VALUE;
        for(int j=1;j<=i;j++){
            max = Math.max(max, prices[j-1] + findRodCut(prices, i -j));
        }
        return max;
    }
}
