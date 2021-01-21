package choujiang;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class LotteryTest {
    public static void main(String[] args) {

        List<Prize> prizes = new ArrayList<>();
        // 奖品序号==奖品id==奖品名称==库存==概率
        prizes.add(new Prize(2580, 11L, "再来一次", 100, 0.52d));
        prizes.add(new Prize(1234, 22L, "本站VIP一年", 100, 0.3d));
        prizes.add(new Prize(5678, 33L, "谢谢参与", -100, 0.1d));
        prizes.add(new Prize(1230, 55L, "50金币", 100, 0.05d));
        prizes.add(new Prize(3726, 66L, "iphone12", 100, 0.02d));
        prizes.add(new Prize(3737, 77L, "ipad Air8", 100, 0.01d));

        if (CollectionUtils.isEmpty(prizes)) {
            System.out.println("无奖品数据");
            return;
        }

        List<Double> originRates = new ArrayList<>();
        for (Prize prize : prizes) {
            double probability = prize.getProbability();
            int stock = prize.getStock();
            // 概率为负数或者库存为0的数据，概率设置为0
            if (probability < 0 || stock == 0) {
                probability = 0;
            }
            originRates.add(probability);
        }

        // 测试1000次的抽奖调用
        int i = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        int b = 0;
        for (int j = 0; j < 1001; j++) {
            int originIndex = LotteryUtil.lottery(originRates);
            System.out.println("originIndex" + originIndex);
            Prize prize = prizes.get(originIndex);
            if (prize.getProbability() <= 0 || prize.getStock() == 0) {
                // 多一步判断
                System.out.println("库存不足或概率小于等于0======谢谢参与======");
            } else {
                if (prize.getPrizeId() == 77) {
                    i++;
                }
                if (prize.getPrizeId() == 66L) {
                    k++;
                }
                if (prize.getPrizeId() == 55L) {
                    l++;
                }
                if (prize.getPrizeId() == 33L) {
                    m++;
                }
                if (prize.getPrizeId() == 22L) {
                    n++;
                }
                if (prize.getPrizeId() == 11L) {
                    b++;
                }
                System.out.println("一等奖一共中的次数为:" + i);
                System.out.println("二等奖一共中的次数为:" + k);
                System.out.println("三等奖一共中的次数为:" + l);
                System.out.println("四等奖一共中的次数为:" + m);
                System.out.println("五等奖一共中的次数为:" + n);
                System.out.println("六等奖一共中的次数为:" + b);
            }
        }


    }
}
