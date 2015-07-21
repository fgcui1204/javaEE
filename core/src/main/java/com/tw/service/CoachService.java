package com.tw.service;

import com.tw.dao.CoachDao;
import com.tw.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    @Autowired
    private CoachDao coachDao;

    public List<Coach> getCoachList(){
        return coachDao.getCoachList();
    }
}
