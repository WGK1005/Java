package com.njx.Basic8;

import java.util.*;
//暴力太香了
public class Test8 {
    public static void main(String[] args) {
        long count = 0L;
        for(int i = 0; i <= 255; i++) {
            for(int j = 0; j <= 255; j++) {
                for(int k = 0; k <= 255; k++) {
                    if(k > i && k > j) {
                        count++;
                    }
                }
            }
        }
        //System.out.println(count);
    }
}
/*
小蓝特别喜欢蓝色。最近，小蓝学习了颜色在计算机中的一种表示方法：
用三个0至255之间的整数（包含0和255）分别表示颜色的红、绿、蓝三个分量。
在这种颜色的表示方法下，小蓝定义了一种颜色是偏蓝的，是指蓝色分量大于红色分量，且蓝色分量大于绿色分量
例如，红、绿、蓝分别为10、10、11时是偏蓝的；红、绿、蓝分别为100、200、200时不是偏蓝的。
小蓝想知道，有多少种不同的颜色是偏蓝的。两种颜色如果在红、绿、蓝中至少有一个分量值不同，就认为是不同的。
 */