import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.regex.Pattern;

public class test3 {
    private final static Pattern MONEY = Pattern.compile("^(\\d+(?:\\.\\d+)?)$");
    public static void main(String[] args) {
        String s = "sysid=1902271423530473681&rps=%7B%22returnValue%22%3A%7B%22bizUserId%22%3A%22pojuiobhuigyurftydghgb%22%7D%2C%22method%22%3A%22signContract%22%2C%22ContractNo%22%3A%221273146540239618048%22%2C%22service%22%3A%22MemberService%22%2C%22contractNo%22%3A%221273146540239618048%22%2C%22status%22%3A%22OK%22%7D&timestamp=2020-06-17+14%3A52%3A43&v=2.0&sign=LX%2F9AJyAMxA3wFRvTNMNS1WSkok%2FeX0bxSFnANSyH0EMr0%2Bh5MMDFdFLGQCqjeF6dVumEjltHTbR9MM%2BGnqIfYjj28l2ohyn0UKvUBY%2BAYW2TeNUvV%2FTktJqcBJ1U%2FfNGZUh29R06%2FbiVhx%2B0BOF%2F9PAdlXl%2BeJFews4ggNoi%2FM%3D";
        //创建Map对象
        Map<String,Object> map = new HashMap<>();

        String[] split = s.split("&");
        for (String s1 : split) {
            String[] split1 = s1.split("=");
            try {
                map.put(split1[0], URLDecoder.decode(split1[1],"utf-8"));
            } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
}
        System.out.println(map);

            String str ="{\"body\":\"123456\"}";
            System.out.println(JSONObject.isValid(str));
            System.out.println(JSONObject.isValidObject(str));
            System.out.println(JSONObject.isValidArray(str));

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        int count = 0;
        final int id = count++;
        System.out.println(id);
    }


    public static boolean isMatch(Pattern pattern, String content) {
        if (content == null || pattern == null) {
            return false; // 提供null的字符串为不匹配
        }
        return pattern.matcher(content).matches();
    }
}
