package com.cnicg.lemon.demo.ali;

import java.util.ArrayList;
import java.util.List;

public class InventoryStatusManager {

    private static final int ZERO = 0;

    private List<String> zeroLeftProduct = new ArrayList<>();

    private List<ProductInventory> topNList;

    public InventoryStatusManager(Integer topN){
        topNList = new ArrayList<>(topN);
    }

    public void processProductInventory(ProductInventory productInventory) {
        if (ZERO == productInventory.getLeftNum()) {
            //限制最大统计的零库存商品数量
            zeroLeftProduct.add(productInventory.getProductId());
        }
        processTopN(productInventory);
    }

    private void processTopN(ProductInventory productInventory) {
        //可根据具体情况topN值的大小采用具体算法
        //如果topN值较小可直接维护一个从大到小 数组，进行插入和移动操作
        //如果topN值较大可采用大顶堆维护


    }

    public List<String> getZeroLeftProducts(){
        return zeroLeftProduct;
    }

    public List<ProductInventory> getTopNList(){
        //如果为堆，将堆按堆排序算法，一个个从堆定取出返回即可。
        return topNList;
    }
}
