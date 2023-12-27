package com.demo.dbreadwrite.services;

import com.demo.dbreadwrite.dao.RegionRepository;
import com.demo.dbreadwrite.model.RegionEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegionServiceImpl {
    private final  RegionRepository regionRepository;

    public void getAndUpdateNameBnById(Integer id) {
        RegionEntity regionById = regionRepository.getRegionById(id);
        log.info(regionById.toString());
        regionRepository.updateNameBnById(id);
    }

    public void getAndUpdateNameBnNativeById(Integer id) {
        RegionEntity regionById = regionRepository.getRegionNativeById(id);
        log.info(regionById.toString());
        regionRepository.updateNameBnNativeById(id);
    }
}
