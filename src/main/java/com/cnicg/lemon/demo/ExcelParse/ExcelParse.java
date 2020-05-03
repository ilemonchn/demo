package com.cnicg.lemon.demo.ExcelParse;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelParse {

//    @Test
//    public void parseSql() throws Exception{
//        File file = new File("/Users/chenmeng/Documents/guoxing03_kl_pas_2019-05-22-11-25-16_sql1.xls");
//        InputStream inputStream = new FileInputStream(file);
//        Workbook workbook = new HSSFWorkbook(inputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//        int lastRowIndex = sheet.getLastRowNum();
//        int total = 0;
//        for (int i=1; i <= lastRowIndex; i++){
//            Row row = sheet.getRow(i);
//            Integer coupon_id = Integer.parseInt(row.getCell(0).toString().substring(0, row.getCell(0).toString().indexOf(".")));
//            Integer quantity = Integer.parseInt(row.getCell(2).toString().substring(0, row.getCell(2).toString().indexOf(".")));
//            Integer count = Integer.parseInt(row.getCell(3).toString().substring(0, row.getCell(3).toString().indexOf(".")));
//            // update cx_coupon set dispatch_quantity = dispatch_quantity + num where id = coupon_id;
//            StringBuilder sql = new StringBuilder(20);
//            sql.append("update cx_coupon set dispatch_quantity = dispatch_quantity + ")
//                    .append(count -  quantity).append(" ")
//                    .append("where id = ").append(coupon_id).append(";");
//            System.out.println(sql.toString());
//            total++;
//        }
//        System.out.println(total);
//
//    }
}
