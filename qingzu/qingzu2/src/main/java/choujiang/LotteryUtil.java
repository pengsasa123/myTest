package choujiang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 抽奖算法工具类
 *
 * @author xiegege
 * @date 2021/1/7 17:02
 */
@Slf4j
public class LotteryUtil {

    /**
     * 抽奖算法
     *
     * @param originRates 原始的概率列表，保证顺序和实际物品对应
     * @return 物品的索引
     */
    public static int lottery(List<Double> originRates) {
        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (double rate : originRates) {
            sumRate += rate;
        }
        System.out.println("总和" + sumRate);
        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOriginRates = new ArrayList<>();
        double tempSumRate = 0d;
        for (double rate : originRates) {
            tempSumRate += rate;
            System.out.println("tempSumRate的值" + tempSumRate);
            System.out.println("概率" + tempSumRate / sumRate);
            sortOriginRates.add(tempSumRate / sumRate);
        }
        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random();
        sortOriginRates.add(nextDouble);
        Collections.sort(sortOriginRates);
        System.out.println("-------------------");
        sortOriginRates.forEach(System.out::println);
        System.out.println("-------------------");
        return sortOriginRates.indexOf(nextDouble);
    }
}
