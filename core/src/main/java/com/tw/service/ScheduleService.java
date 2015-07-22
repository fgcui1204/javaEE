package com.tw.service;

import com.tw.dao.ScheduleDao;
import com.tw.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fgcui on 7/22/15.
 */
@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    public List<Schedule> getScheduleList() {
        return scheduleDao.getScheduleList();
    }
}
