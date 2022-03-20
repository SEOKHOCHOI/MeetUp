package com.meetup.meetup.repository;

import com.meetup.meetup.domain.moim.Moim;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MoimRepository {

    void create();
    void join();
    void setLocation();
    void calc();
    ArrayList<Moim> findAll();

}
