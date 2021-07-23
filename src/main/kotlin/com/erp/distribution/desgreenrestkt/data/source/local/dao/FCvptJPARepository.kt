package com.erp.distribution.desgreenrestkt.data.source.local.dao

import com.erp.distribution.desgreenrestkt.data.source.entity.FCvptEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FCvptJPARepository : JpaRepository<FCvptEntity, Int> {
//    fun findById(id: Int): FCvptEntity?
    fun findByKode1(kode1: String): List<FCvptEntity>

    @Query("SELECT u FROM FCvptEntity u WHERE u.kode1 LIKE :kode1 and u.description LIKE :description")
    fun findAll(kode1: String, description: String): List<FCvptEntity>

    @Query("SELECT u FROM FCvptEntity u WHERE u.kode1 LIKE :kode1 and u.description LIKE :description and u.fdivisionBean = :fdivisionBean")
    fun findAll(kode1: String?, description: String, fdivisionBean: Int): List<FCvptEntity>

    @Query("SELECT u FROM FCvptEntity u WHERE u.fdivisionBean = :fdivisionBean")
    fun findAllByDivision(fdivisionBean: Int): List<FCvptEntity>

//    @Query("SELECT u FROM FCvptEntity u " +
//            " left outer join FDivisionEntity f on u.fdivisionBean = f.id " +
//            " where f.id = :fdivisionBean OR " +
//            "      (f.shareMaterialToCompany = true and f.fcompanyBean = :fcompanyBean ) ")
//    fun findAllByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FCvptEntity>

}