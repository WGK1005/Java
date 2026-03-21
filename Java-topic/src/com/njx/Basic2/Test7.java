package com.njx.Basic2;
import java.util.*;
import java.io.*;
public class Test7 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stones = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 1; i < n - 1; i++) {
            if (stones[i - 1] > stones[i]) {
                cnt++;
            }
            if (cnt == 2) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
