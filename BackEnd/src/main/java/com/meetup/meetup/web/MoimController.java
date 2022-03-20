package com.meetup.meetup.web;

import com.meetup.meetup.domain.moim.Moim;
import com.meetup.meetup.repository.MoimRepository;
import com.meetup.meetup.repository.impl.MoimRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/moims")
public class MoimController {

    MoimRepository moimRepository;

    @GetMapping
    public List<Moim> findAll() {
        return moimRepository.findAll();
    }
}
