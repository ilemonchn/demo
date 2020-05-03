package com.cnicg.lemon.demo.toutiao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class PersonTest {

    private Person person;


    @Before
    public void setUp(){
        person = new Person();
    }

    @After
    public void tearDown(){
//        System.out.println("TearDown invoke");
    }

    @Test
    public void tsetSay(){

        Assert.assertEquals("Hello, Ivan", person.say("Ivan"));
    }

    public static void main(String[] args) {


        JUnitCore.main("com.cnicg.lemon.demo.toutiao.PersonTest");




    }

}
