package Com.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {


    //javaBean和json的互转
    @Test
    public void test01() {
        Person person = new Person(1, "Morries_Wu");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以把Java对象转换为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        /*
         fromJson把json字符串转换回Java对象
         第一个参数是json字符串
         第二个参数是转换回去的Java对象类型
         */
        Person toperson = gson.fromJson(personJsonString, Person.class);
        System.out.println(toperson);
    }

    //List和json的互相转换
    @Test
    public void test02() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Morries_Wu"));
        personList.add(new Person(2, "simin"));

        Gson gson = new Gson();
        String personlistJsonString = gson.toJson(personList);
        System.out.println(personlistJsonString);

        List<Person> list = gson.fromJson(personlistJsonString, new PersonListType().getType());
        Person person = list.get(0);
        System.out.println(person);

    }

    //map和json的互转
    @Test
    public void test03() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "Morries_Wu"));
        personMap.put(2, new Person(2, "simin"));
        //把map集合转换成json字符串
        Gson gson = new Gson();
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

        Map<Integer, Person> map = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(map);
        Person person = map.get(1);
        System.out.println(person);
    }


}
