package com.njx.ErFen;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        // 40位同学的力量值
        long[] powers = {
            345590635693812L, 411735179294186L, 190029355501347L, 973598561303630L,
            18202819016954L, 739089526396984L, 41064501651340L, 287075700776565L,
            458062562307032L, 723278851371706L, 997720296178889L, 470475557480472L,
            329586527903215L, 907379737442406L, 631284976214798L, 301204036247736L,
            747294692547790L, 914091289062262L, 144070679727924L, 988094642462741L,
            413975599277375L, 835461430976017L, 344371572186185L, 646160866308904L,
            880407857470630L, 794629069521762L, 462180977651587L, 342038139286302L,
            854772507978666L, 694223418935656L, 567502001946067L, 881035713848915L,
            840605474892139L, 324727089144326L, 226008847101330L, 65143946718125L,
            499249957077991L, 245803813100131L, 447887480320685L, 658036302578844L
        };

        // 计算总和
        long totalSum = 0;
        for (long power : powers) {
            totalSum += power;
        }

        // 使用动态规划求最接近总和一半的可达成的值
        long minDiff = findMinDifference(powers, totalSum);

        System.out.println("最小的力量值之差的绝对值：" + minDiff);
    }

    public static long findMinDifference(long[] powers, long totalSum) {
        // 用集合存储所有可达成的和
        Set<Long> reachable = new HashSet<>();
        reachable.add(0L);

        // 对每个力量值，更新可达成的和
        for (long power : powers) {
            Set<Long> newReachable = new HashSet<>(reachable);
            for (long sum : reachable) {
                newReachable.add(sum + power);
            }
            reachable = newReachable;
        }

        // 找最接近 totalSum/2 的可达成的值
        long minDiff = totalSum;
        long target = totalSum / 2;

        for (long sum : reachable) {
            long group1 = sum;
            long group2 = totalSum - sum;
            long diff = Math.abs(group1 - group2);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}

