package com.cnicg.lemon.demo.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
    public static void main(String[] args) throws Exception {
        JObj j = new JObj();
        j.setAa(null);
        j.setBb(1);


        ObjectMapper mapper = new ObjectMapper();
        String ret = mapper.writeValueAsString(j);
        System.out.println(ret);

        JObj jj = mapper.readValue("{}", JObj.class);


        System.out.println(jj);
        System.out.println(Integer.MAX_VALUE);


    }


}
