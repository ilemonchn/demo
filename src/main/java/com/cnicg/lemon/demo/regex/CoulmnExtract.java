package com.cnicg.lemon.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoulmnExtract {
    public static void main(String[] args) throws Exception {
        String tableInfo = "REATE TABLE `coupon_approval_bill` (\n" +
                "  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',\n" +
                "  `process_id` varchar(70) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'gravity 生成的流程处理ID',\n" +
                "  `bill_no` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '审批单号，形如JQXXXXX',\n" +
                "  `biz_type` int(11) NOT NULL COMMENT '业务类型 1：优惠券 2：批次',\n" +
                "  `biz_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '依据biz_type而定 1 优惠券Id 2 coupon_dispatch_log_id',\n" +
                "  `bill_status` int(11) NOT NULL DEFAULT '0' COMMENT '审批单状态，1:审核中，2:已撤回，3:审核通过，4:审核驳回',\n" +
                "  `bu_id` int(11) NOT NULL COMMENT '事业部id',\n" +
                "  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                "  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
                "  `create_acc` varchar(100) NOT NULL DEFAULT '' COMMENT '发起人misId',\n" +
                "  `create_acc_name` varchar(100) NOT NULL DEFAULT '' COMMENT '发起人姓名',\n" +
                "  `update_acc` varchar(100) NOT NULL DEFAULT '',\n" +
                "  `channel_id` int(11) NOT NULL COMMENT '渠道id',";

        String pattern = "`\\w+`";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(tableInfo);
        while (matcher.find()){
            String s = matcher.group();
            System.out.println(s);

        }


    }
}
