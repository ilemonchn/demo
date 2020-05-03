package com.cnicg.lemon.demo.print;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Print {
    private static final Logger LOGGER = LoggerFactory.getLogger(Print.class);

    public static void main(String[] args) {
        Map<String, Object> params = Maps.newHashMapWithExpectedSize(3);
        params.put("id", 1);
        params.put("addDispatch", 2);

        try {
            System.out.println(params);
            throw new RuntimeException("error");
        }catch (Exception e){
            LOGGER.info("ok:{}","good",e);
            LOGGER.info("e:{}","bad",e);
        }

    }
}
