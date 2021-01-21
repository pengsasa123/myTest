package choujiang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prize {
    /**
     * 奖品序号
     */
    private Integer prizeIndex;
    /**
     * 奖品id
     */
    private Long prizeId;
    /**
     * 奖品名称
     */
    private String prizeName;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 概率
     */
    private double probability;
}
