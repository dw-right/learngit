package com.isso.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonExample {
    public static void main(String[] args) {
        String  jsonStr="{\n" +
                "    \"status\": \"2000\",\n" +
                "    \"msg\": \"Successful!\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"details\": [\n" +
                "                {\n" +
                "                    \"distance\": 2847,\n" +
                "                    \"nextLat\": 39.994076,\n" +
                "                    \"nextLong\": 116.47764,\n" +
                "                    \"nexti\": \"MeloDev\",\n" +
                "                    \"status\": 4\n" +
                "                }\n" +
                "            ],\n" +
                "            \"distance\": 2847,\n" +
                "            \"imageUrl\": \"\",\n" +
                "            \"overview\": \"长期原创Android博客\",\n" +
                "            \"source\": \"http://www.jianshu.com/users/f5909165c1e8/latest_articles\",\n" +
                "            \"status\": \"SUCCESSFUL\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"details\": [\n" +
                "                {\n" +
                "                    \"distance\": 2769,\n" +
                "                    \"nextLat\": 39.97691,\n" +
                "                    \"nextLong\": 116.46019,\n" +
                "                    \"nexti\": \"MeloDev\",\n" +
                "                    \"status\": 4\n" +
                "                }\n" +
                "            ],\n" +
                "            \"distance\": 2769,\n" +
                "            \"imageUrl\": \"\",\n" +
                "            \"overview\": \"喜欢请加关注\",\n" +
                "            \"source\": \"http://www.jianshu.com/users/f5909165c1e8/latest_articles\",\n" +
                "            \"status\": \"SUCCESSFUL\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        QueryResultInfo queryResultInfo= JSON.parseObject(jsonStr,QueryResultInfo.class);
       /* JSONObject result=JSON.parseObject(jsonStr);
        System.out.println(result.getString("status"));
        JSONArray dataArray=result.getJSONArray("data");*/

        System.out.println(queryResultInfo);
        System.out.println(JSON.toJSONString(queryResultInfo));
    }
}
