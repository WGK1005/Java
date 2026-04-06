package com.njx.Basic7;

import java.util.*;
//首先思考怎么凑成一组，发现只有当L的2倍小于等于R时才会有，因为ι+（L+1）〉2*L和L+L==2*L接下来就是思考z的个数，如∟= 6，R = 18
//6 7 8 9 10 11 12 13 14 15 16 17 18发现Z的取值范围是12~18，则可以得到
//22
//13
//14
//25
//6+ 9，7+ 8，
//8+7,9+6
//可以发现，就是等差数列，n 就等于Ζ的个数，差为1
//等差数列求和公式为：sum = n*(a1+an)
//2
//an = a1 + (n − 1) = 1 + n − 1 = n n = an = (R − 2I + 1)
//然后直接带入，就可以算出结果了
public class Test6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while(T -- != 0) {
            long l = scan.nextLong(), r = scan.nextLong();
            System.out.println(l * 2 > r ? 0 : (r - 2 * l + 1) * (r - 2 * l + 2) / 2);
        }
        scan.close();
    }
}
/*
给定一个区间[L，R]，请求出有多少组X，Y，Z 满足X + Y = Z 且 L ≤ X, Y , Z ≤ R.
输入格式
本题包含多组询问。
输入的第一行包含一个整数T表示询问组数。
接下来T行，每行包含两个整数Li，Ri，用一个空格分隔，表示一组询问。
输出格式
输出T行，每行包含一个整数，表示满足条件的X，Y，Z的组数。
 */