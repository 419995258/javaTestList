package com.pb.sentinel.controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pb.sentinel.feign.SentinelFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sentinelC")
public class testController {

    @Autowired
    private SentinelFeign sentinelFeign;


    @GetMapping(value = "/test")
    @SentinelResource(value = "test",fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public String test(@RequestParam("id") String id) {
        if("1".equals(id)){
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return "123";
    }

    //本例是fallback
    public String handlerFallback(@RequestParam("id") String id,Throwable e) {
        return "handlerFallback:" + e.toString();
    }

    //本例是blockHandler
    public String blockHandler(@RequestParam("id") String id,BlockException blockException) {
        return "blockHandler：" + blockException.toString();
    }



    @GetMapping(value = "/testFeign")
    public String testFeign() {
        return sentinelFeign.test();
    }


    /**
     * 根据不同的类型走不同的qps
     * @return
     */
    @GetMapping(value = "/test2")
    @SentinelResource(value = "test2",blockHandler = "blockHandler2")
    public String test2(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2) {
        System.out.println(p1);
        return "123";
    }

    //本例是blockHandler
    public String blockHandler2(@RequestParam(value = "p1", required = false) String p1,
                                @RequestParam(value = "p2", required = false) String p2,
                                BlockException blockException) {
        return "blockHandler：" + blockException.toString();
    }

}
