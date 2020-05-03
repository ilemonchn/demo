package com.cnicg.lemon.demo.abknowledge.suanfa.dongtaiguihua;

public class DTGHMain {
    public static void main(String[] args) {
//        Bag bag = new Bag();
//        bag.calculate(1, 0);
//        System.out.println(bag.maxW);

        int[] weight = {10,10, 3, 5, 100, 90, 1};
        System.out.println(knapack2(weight, 7, 117));

    }

    private static int knapack(int[] weight, int n, int limit) {
        //记录每个物品放入或不放入后产生的结果集，二维数组的列即为当前物品决策后，产生的所有的在背包限制内的总重量
        //每个物品决策后，最大结果集为limit+1，不会产生无限膨胀，空间复杂度n*limit+1
        boolean[][] states = new boolean[n][limit+1];
        //处理第一个，第一个特殊处理
        states[0][0] = true;   //第一个不放进去
        states[0][weight[0]] = true;  //第一个放进去

        //后面的每个物品都基于上一个物品决策结果层计算
        for (int i = 1; i< n;i++) {
            //第i个不放进去，将上一层的所有true状态拷贝下去
            for (int j = 0;j<limit;j++) {
                if (states[i-1][j]) {
                    states[i][j] = true;
                }
            }
            //第i个放进去，将上一层的所有加上i放到i层
            for (int j = 0;j<limit;j++) {
                if (states[i-1][j]) {
                    if (j + weight[i] <= limit) {
                        states[i][j + weight[i]] = true;
                    }
                }
            }
        }

        //直接查看最后一层的所有状态，倒序第一个为true即为最大放入重量
        for (int i = limit-1;i>=0;i--){
            if(states[n-1][i]) {
                return i;
            }
        }
        return 0;
    }

    //优化这里二维数组，其中用一维数据就够了
    private static int knapack2(int[] weight, int n, int limit) {
        //记录每个物品放入或不放入后产生的结果集，数组的列即为当前物品决策后，产生的所有的在背包限制内的总重量
        boolean[] states = new boolean[limit+1];
        //处理第一个，第一个特殊处理
        states[0] = true;   //第一个不放进去
        states[weight[0]] = true;  //第一个放进去

        //后面的每个物品都基于上一个物品决策结果层计算
        for (int i = 1; i< n;i++) {
            //不放进去，则states无需改变
            //第i个放进去，将上一层的所有加上i放到i层
            for (int j = limit-1;j>=0;j--) {  //注意这里需要倒序，不然会错误的重复计算
                if (states[j]) {
                    if (j + weight[i] <= limit) {
                        states[j + weight[i]] = true;
                    }
                }
            }
        }

        //直接查看最后一层的所有状态，倒序第一个为true即为最大放入重量
        for (int i = limit-1;i>=0;i--){
            if(states[i]) {
                return i;
            }
        }
        return 0;
    }
}
