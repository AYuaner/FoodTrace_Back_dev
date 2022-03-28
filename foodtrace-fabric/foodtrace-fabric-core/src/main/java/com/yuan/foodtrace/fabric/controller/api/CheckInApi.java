package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.CheckIn;
import org.springframework.web.bind.annotation.*;

/**
 * 入库信息API
 *
 * @author A_Yuan
 */
@RequestMapping(value = "/checkin")
@CrossOrigin
public interface CheckInApi {

    /**
     * 新增一条入库信息
     *
     * @param info 入库信息
     * @return 新增结果
     */
    @PostMapping()
    Object newCheckIn(@RequestBody CheckIn info);

    @GetMapping
    Object findCheckInByCropsId(String cropsId);

    @GetMapping(value = "/all")
    Object findAll();
}
