package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    private WhiskyRepository whiskyRepository;

    @GetMapping(value = "/year/{year}")
    public List<Whisky> findWhiskysByYear(@PathVariable int year) {
        return whiskyRepository.findAllByYear(year);
    }

    @GetMapping(value = "/distillery/{distilleryId}/age/{age}")
    public List<Whisky> findWhiskysByYear(@PathVariable long distilleryId, @PathVariable int age) {
        return whiskyRepository.findAllByDistilleryIdAndAge(distilleryId, age);
    }

    @GetMapping(value = "/distillery/region/{region}")
    public List<Whisky> findWhiskiesByRegion(@PathVariable String region) {
        return whiskyRepository.findAllByDistilleryRegion(region);
    }
}
