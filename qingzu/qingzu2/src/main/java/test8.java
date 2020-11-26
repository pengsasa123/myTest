import java.util.Date;

public class test8 {
    public static void main(String[] args) {
        String format = String.format("%tF %tT", new Date(), new Date());
        System.out.println(format);

        System.out.printf("%.2f", 1000.0 / 3.0);
        System.out.println();
        // 打印1个空格和7个字符
        System.out.printf("%8.2f", 10000.0 / 3.0);
        System.out.println();
        // 数字用,号
        System.out.printf("%,.2f", 10000.0 / 3.0);
        System.out.println();
        // 数字 + 带正负
        System.out.printf("%+.2f", -10000.0 / 3.0);
        System.out.println();
        // 将负数括在括号内
        System.out.printf("%(.2f", -10000.0 / 3.0);
        System.out.println();
        // 前面补0
        System.out.printf("%02d", 1);
        System.out.println();


    }
}
