package com.cnicg.lemon.demo.mtthrift;

import com.google.common.collect.Lists;
import com.meituan.mtrace.Tracer;
import com.meituan.service.mobile.mtthrift.proxy.ThriftClientProxy;
import com.sankuai.meituan.kuailv.api.CouponQueryService;
import com.sankuai.meituan.kuailv.api.dto.req.CouponQueryReq;
import com.sankuai.meituan.kuailv.api.dto.req.CustomerReceiveCouponReq;
import com.sankuai.meituan.kuailv.api.dto.req.OperatorDto;
import com.sankuai.meituan.kuailv.api.dto.resp.CouponBuyerDto;
import com.sankuai.meituan.kuailv.api.dto.resp.CustomerReceiveCouponResult;
import com.sankuai.meituan.kuailv.api.dto.resp.PageCouponBuyerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MtReqRpc {


    public static void main(String[] args) throws Exception {
        Tracer.putContext("B2B_PORTAL_ID", "201");
        Tracer.putContext("B2B_DEALER_ID", "100001");
        Tracer.putContext("B2B_CHANNEL_ID", "1001");

        ThriftClientProxy proxy = new ThriftClientProxy() {{

            setServiceInterface(CouponQueryService.class);
            setTimeout(3000);
            setServerDynamicWeight(true);
            setAppKey("com.sankuai.mbc.coupon.thalia");
//            setRemoteAppkey("com.sankuai.mbc.coupon.thalia");
//            setRemoteServerPort(8326);

        }};


//        proxy.setServerIpPorts("127.0.0.1:8326");
        proxy.setServerIpPorts("10.48.236.17:8326");

        proxy.afterPropertiesSet();


        CouponQueryService couponQueryService = (CouponQueryService) proxy.getObject();

        /**
         * --------------------
         */
//        CouponQueryReq couponQueryReq = new CouponQueryReq();
//        couponQueryReq.setPageNo(1);
//        couponQueryReq.setPageSize(20);
//        couponQueryReq.setExpiredTime(1554192980535L);
//        couponQueryReq.setCouponTypeList(Lists.newArrayList(1,2,3));
//
//        OperatorDto operatorDto = new OperatorDto();
//        operatorDto.setCustomerId(10478L);
//        operatorDto.setCustomerName("胡大啊");
//        operatorDto.setCurCityId(110100);
//
//        PageCouponBuyerDto pageCouponBuyerDto = couponQueryService.pageGetCouponBuyerByQuery(couponQueryReq, operatorDto);
//
//        System.out.println(pageCouponBuyerDto);
        /**
         * --------------------listUnusedCouponBuyerByUser
         */
//        OperatorDto operatorDto2 = new OperatorDto();
//        operatorDto2.setCustomerId(10478L);
//        operatorDto2.setCustomerName("胡大啊");
//        operatorDto2.setCurCityId(110100);
//        List<CouponBuyerDto> dtos = couponQueryService.listUnusedCouponBuyerByUser(operatorDto2);
//        System.out.println(dtos);
        CustomerReceiveCouponReq req = new CustomerReceiveCouponReq();
        req.setCustomerId(1L);
        req.setSalesGridId(2L);
        CustomerReceiveCouponResult result = couponQueryService.listCustomerReceiveCoupons(req);
        System.out.println("*****" + result);
    }




}
