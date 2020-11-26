import cn.hutool.core.convert.Convert;

import java.util.StringJoiner;

public class test5 {

    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        sj.add("wang");
        sj.add("wei");
        sj.add("liang");
        System.out.println(sj.toString());

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("peng");
        stringJoiner.add("sa");
        stringJoiner.add("sa");
        sj.merge(stringJoiner);
        System.out.println(sj.toString());

        String s = Convert.digitToChinese(1234.56);
        System.out.println(s);

    }
}
