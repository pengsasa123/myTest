public class test12 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = s1;
        System.out.println(s1 == s2);

        String s3 = "abc";
        String s4 = new String("abc");
        System.out.println(s3 == s4);

        String s5 = new String("abc");
        String s6 = new String("abc");
        System.out.println(s5 == s6);

        String s7 = "a";
        String s8 = "b";
        String s9 = s7 + s8;
        String s10 = "ab";
        System.out.println(s9 == s10);

        String s11 = "a" + "b";
        String s12 = "ab";
        System.out.println(s11 == s12);

        String s13 = "abc";
        String s14 = new String("abc").intern();
        System.out.println(s13 == s14);
    }
}
