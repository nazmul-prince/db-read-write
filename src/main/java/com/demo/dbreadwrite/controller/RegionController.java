package com.demo.dbreadwrite.controller;

import com.demo.dbreadwrite.dao.RegionRepository;
import com.demo.dbreadwrite.model.RegionEntity;
import com.demo.dbreadwrite.services.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public @RestController
class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private RegionServiceImpl regionService;

    @RequestMapping(value = "/region/{id}", method = RequestMethod.GET)
    public ResponseEntity<RegionEntity> getOne(@PathVariable Integer id) {
        Optional<RegionEntity> region = regionRepository.findById(id);
        return new ResponseEntity<>(region.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/region", method = RequestMethod.POST)
    public ResponseEntity<RegionEntity> save(@RequestBody RegionEntity newregion) {
        RegionEntity region = regionRepository.save(newregion);
        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/region/namebn/{id}", method = RequestMethod.GET)
    public void updateNameBn(@PathVariable Integer id) {
        regionService.getAndUpdateNameBnById(id);
        return;
    }

    @RequestMapping(value = "/region/namebn/native/{id}", method = RequestMethod.GET)
    public void updateNameBnNative(@PathVariable Integer id) {
        regionService.getAndUpdateNameBnNativeById(id);
        return;
    }
}

