package com.surojit.doctordear.center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {
    @Autowired
    private CenterRepository centerRepository;

    public Center registerCenter(Center center) {

        return centerRepository.save(center);
    }
}