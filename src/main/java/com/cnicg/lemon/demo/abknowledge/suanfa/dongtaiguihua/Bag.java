package com.cnicg.lemon.demo.abknowledge.suanfa.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    //背包问题，采用递归穷举的思想解决 及其优化点   又名 回溯算法
    //思路：每个物品在不超过背包称重上限的情况可以选择装入也可以选择不装入，
    //采用递归依次搜索每个物品的两条路径

    public int maxW = 0;  //记录背包当前的最大重量
    private int[] weight = {10,10, 3, 5, 100, 90, 1}; //所有的物品
    private int n = 7;  //所有的物品个数
    private int limit = 117; //背包限重117
    public int count = 0;  //记录总递归次数

    public Map<String, Integer> record = new HashMap<>(); //优化记录已经搜索过的路径，避免重复搜索

    //i 表示决策的第i个物品，
    //cw 表示在第i个决策前的背包重量
    public void calculate(int i, int cw) {
        count++;
        //对穷举递归的优化
        //记录已经搜索的路径，即当前背包为某个值的情况，决策第i个是否放入，只计算一次就够了
        //经过此次重要的优化，此穷举算法效率已经跟动态几乎无差别
        if (record.get(i+"-"+cw) == null) {
            record.put(i+"-"+cw, 0);
        } else {
            return;
        }

        //如果i超过个数
        if (i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        //第i个物品不放入，即cw还是原来重量，再决策下一个
        calculate(i+1, cw);
        //第i个物品放入，即cw加上i的重量 (在不超限的情况下)
        if (cw + weight[i] <= limit) {
            calculate(i+1, cw + weight[i]);
        }
    }

}
