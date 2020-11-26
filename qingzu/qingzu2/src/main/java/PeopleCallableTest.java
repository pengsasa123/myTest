import java.util.concurrent.Callable;

public class PeopleCallableTest implements Callable<String> {

    private int age;
    private int sex;

    public PeopleCallableTest(int a, int s) {
        this.age = a;
        this.sex = s;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "小明同学年龄为:" + age + ",性别为:" + sex;
    }
}
