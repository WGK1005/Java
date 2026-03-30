package com.njx.Basic5;

import java.util.*;
import java.math.*;

public class Test9 {
    public static void main(String[] args) {
        long s = (7385137888721L * 4) + 10470245;
        long a = 1000000;
        while (a * a < s) {
            a += 1;
        }
        System.out.println(a - 1);
    }
}
