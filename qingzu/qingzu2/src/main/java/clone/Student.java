package clone;


import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
public class Student implements Cloneable{
    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int i = Integer.parseInt(new DecimalFormat("0").format(50000));
        System.out.println(i);
        BigDecimal d = new BigDecimal(1.0);
        BigDecimal negate = d.negate();
        System.out.println(negate);
    }
}
