package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.dto.WorkerDTO;
import com.yuan.foodtrace.auth.mapper.WorkerMapper;
import com.yuan.foodtrace.auth.utils.MapperUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerMapper mapper;

    public List<WorkerRecord> list() {
        return mapper.list();
    }

    public boolean insert(WorkerDTO dto) {
        WorkerRecord workerById = mapper.selectByPrimaryKey(dto.getId()).orElse(new WorkerRecord());

        if (workerById.getId() == null) {
            WorkerRecord workerRecord = MapperUtils.WorkerDTOToEntity(dto);
            return mapper.insertSelective(workerRecord) == 0 ? false : true;
        }
        return false;
    }

    public boolean delete(WorkerDTO dto) {
        mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("该id工人不存在"));
        return mapper.deleteByPrimaryKey(dto.getId()) == 0 ? false : true;
    }

    public boolean update(WorkerDTO dto) {
        mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("该id工人不存在"));
        WorkerRecord workerRecord = MapperUtils.WorkerDTOToEntity(dto);
        return mapper.updateByPrimaryKeySelective(workerRecord) == 0 ? false : true;
    }

    public WorkerRecord queryOne(WorkerDTO dto) {
        if (StringUtils.isEmpty(dto.getId())) {
            throw new RuntimeException("PrimaryKey is Empty");
        }
        return mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("该id工人不存在"));
    }
}
