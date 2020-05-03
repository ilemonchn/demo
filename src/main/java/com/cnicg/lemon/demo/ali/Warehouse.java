package com.cnicg.lemon.demo.ali;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    List<ProductInventory> inventories = new ArrayList<>();

    private InventoryStatusManager statusManager = new InventoryStatusManager(10);

    //入库
    public void provideProduct(ProvideProduct provideProduct){
        //进行入库操作，插入或累加商品库存；
        //监听商品库存变动情况，交给InventoryStatusManager做统计信息更新;
        ProductInventory inventory = inventories.get(0);
        statusManager.processProductInventory(inventory);
    }

    //下单扣减库存
    public boolean consumeProduct(ConsumerProduct consumerProduct){
        //判断商品现有库存是否足够，库存不足返回false
        //库存足够，进行库存占用，返回true
        //监听商品库存变动情况，交给InventoryStatusManager做统计信息更新;
        ProductInventory inventory = inventories.get(0);
        statusManager.processProductInventory(inventory);
        return true;
    }

    //其他查询库存信息操作

}
