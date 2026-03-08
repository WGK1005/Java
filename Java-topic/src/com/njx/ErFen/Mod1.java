package com.njx.ErFen;

import java.util.*;

public class Mod1 {
    public static int binarySearch(int[] a, int target) {
        int i=0;int j=a.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(target<a[mid])
            {
                j = mid-1;
            }else if(target>a[mid])
            {
                i = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
//二分查找基础版
//Params:a-待查找的升序数组
//target-待查找的目标值
//Returns:
//找到则返回索引
//找不到返回-1