package com.erp.distribution.desgreenrestkt.data.source.local.dao

import com.erp.distribution.desgreenrestkt.data.source.entity.FPegawaiEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FPegawaiJPARepository : JpaRepository<FPegawaiEntity, Int> {
//    fun findById(id: Int): FPegawaiEntity?
    fun findByKode1(kode1: String): List<FPegawaiEntity>

    @Query("SELECT u FROM FPegawaiEntity u WHERE u.kode1 LIKE :kode1 and u.description LIKE :description")
    fun findAll(kode1: String, description: String): List<FPegawaiEntity>

    @Query("SELECT u FROM FPegawaiEntity u WHERE u.kode1 LIKE :kode1 and u.description LIKE :description and u.fdivisionBean = :fdivisionBean")
    fun findAll(kode1: String?, description: String, fdivisionBean: Int): List<FPegawaiEntity>

    @Query("SELECT u FROM FPegawaiEntity u WHERE u.fdivisionBean = :fdivisionBean")
    fun findAllByDivision(fdivisionBean: Int): List<FPegawaiEntity>

//    @Query("SELECT u FROM FPegawaiEntity u " +
//            " left outer join FDivisionEntity f on u.fdivisionBean = f.id " +
//            " where f.id = :fdivisionBean OR " +
//            "      (f.shareMaterialToCompany = true and f.fcompanyBean = :fcompanyBean ) ")
//    fun findAllByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FPegawaiEntity>

}