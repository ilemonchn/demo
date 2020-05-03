package com.cnicg.lemon.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@RunWith(Parameterized.class)
public class MyTest extends MyTestSingle{
    private int i = 0;
    private int j;

    public MyTest(int i, int j){
//        super();
        this.i = i;
        this.j = j;
    }

    @Parameterized.Parameters
    public static Collection data(){
//        return Arrays.asList(new Object[][] {{1,2}, {3,4}});
        Object[] a = new Object[2];
        a[0] = 1;
        a[1] = 2;
        Object[] b = new Object[2];
        b[0] = 3;
        b[1] = 4;
        Collection<Object[]> ret = new LinkedList<>();
        ret.add(a);
        ret.add(b);
        return ret;
    }

    @Test
    public void myTest(){
        System.out.println(i);
        System.out.println(j);
        Assert.assertEquals(i+1, j);
    }


//    @Test
//    public void myTestSingle(){
//        System.out.println("single");
//    }





}
