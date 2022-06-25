package Com.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Base64Test {
    public static void main(String[] args) throws IOException {
        String content = "这是需要Base64编码的内容";
        //创建一个Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行Base64编码操作
        String encodedString = base64Encoder.encode(content.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedString);

        //创建Base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //执行Base64解码操作

        byte[] bytes = base64Decoder.decodeBuffer(encodedString);
        content = new String(bytes, "UTF-8");
        System.out.println(content);
    }
}
