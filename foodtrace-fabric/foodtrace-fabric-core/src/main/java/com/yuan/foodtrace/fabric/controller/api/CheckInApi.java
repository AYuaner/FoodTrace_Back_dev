package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.CheckIn;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
