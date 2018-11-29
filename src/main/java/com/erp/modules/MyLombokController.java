package com.erp.modules;

import com.erp.common.utils.ApiResult;
import com.erp.dto.reponse.MyLombokRep;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/MyLombok", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
public class MyLombokController {

    @ApiOperation(value = "新增")
    @GetMapping(value = "/info")
    public ApiResult info() {
        val entity = new MyLombokRep();
        entity.setId(1);
        entity.setName("测试");
        entity.setNickName("匿名");
        return ApiResult.Success("操作成功!", entity);
    }

    @ApiOperation(value = "Map测试")
    @GetMapping(value = "/MapTest")
    public ApiResult MapTest()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

        return  ApiResult.Success("操作成功",map);
    }

    @ApiOperation(value = "List测试")
    @GetMapping(value = "/ListTest")
    public  ApiResult GetList()
    {

        List<MyLombokRep> list=new ArrayList<MyLombokRep>();

        list.add(new MyLombokRep(1,"aa","bb"));
        list.add(new MyLombokRep(2,"cc","dd"));
        list.add(new MyLombokRep(3,"ee","ff"));

        for (int i=0; i<list.size();i++) {
            System.out.println(list.get(i));
        }

        /*三种方法都是用来遍历ArrayList集合，第三种方法是采用迭代器的方法，该方法可以不用担心在遍历的过程中会超出集合的长度。*/
        //第一种遍历方法使用foreach遍历List
        for (MyLombokRep str : list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
            System.out.println(str);
        }

        //第二种遍历，把链表变为数组相关的内容进行遍历
        MyLombokRep[] strArray=new MyLombokRep[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) //这里也可以改写为  foreach(String str:strArray)这种形式
        {
            System.out.println(strArray[i]);
        }

        //第三种遍历 使用迭代器进行相关遍历

        Iterator<MyLombokRep> ite=list.iterator();
        while(ite.hasNext())//判断下一个元素之后有值
        {
            System.out.println(ite.next());
        }

        return ApiResult.Success("操作成功!",list);
    }

}
