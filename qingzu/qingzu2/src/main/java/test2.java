import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        ArrayList<Object> a = new ArrayList<>();
        ArrayList<Object> b = new ArrayList<>();
        System.out.println(a.size());
        System.out.println(isListEqual(a,b));
        String format = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now());
        System.out.println(format);
    }

    public static <E> boolean isListEqual (List<E> list1, List <E> list2){
        if (list1 == list2) {
            return true;
        }
        if (list1 == null) {
            return list2.size() == 0;
        }
        if (list2 == null) {
            return list1.size() == 0;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        if (!list1.containsAll(list2)) {
            return false;
        }
        return true;
    }

        public static <T > int check (T t){
            if (t instanceof String) {
                return 1;
            }
            if (t instanceof Integer) {
                return 2;
            }
            return 0;
        }

        public static boolean checkObjAllIsNull (Object object){
            if (null == object) {
                return true;
            }
            boolean flag = false;
            int count = 0;
            try {
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field f : fields) {
                    f.setAccessible(true);


                    if (f.get(object) instanceof String) {
                        String s = f.get(object).toString();
                        s.trim();
                        System.out.println(s);

                    }

                }
            } catch (Exception e) {

            }

            return flag;
        }

    }
