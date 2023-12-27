package com.demo.dbreadwrite.dao;

import com.demo.dbreadwrite.model.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface RegionRepository extends JpaRepository<RegionEntity, Integer> {

    @Query("select r from RegionEntity r where id = ?1")
    RegionEntity getRegionById(Integer id);

    @Query(value = "select * from region where id = ?1", nativeQuery = true)
    RegionEntity getRegionNativeById(Integer id);

    @Transactional(readOnly = false)
    @Modifying
    @Query("update RegionEntity set nameBn = 'test' where id=?1")
    void updateNameBnById(Integer id);

    @Query(value = "update region set name_bn = 'testttttt' where id=?1", nativeQuery = true)
    void updateNameBnNativeById(Integer id);

}
