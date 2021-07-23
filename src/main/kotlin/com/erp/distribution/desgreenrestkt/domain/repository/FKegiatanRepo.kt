package com.erp.distribution.desgreenrestkt.domain.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FKegiatanEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FKegiatanRepo {
    fun findById(id: Int): FKegiatanEntity
    fun findAll(): List<FKegiatanEntity>
    fun findByKode1(kode1: String): List<FKegiatanEntity>
    fun findAll(kode1: String, description: String): List<FKegiatanEntity>
    fun findByDivision(fdivisionBean: Int): List<FKegiatanEntity>
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FKegiatanEntity>

    fun save(fKegiatanEntity: FKegiatanEntity): FKegiatanEntity
    fun saveAll(listFKegiatan: List<FKegiatanEntity>): List<FKegiatanEntity>
    fun delete(fKegiatanEntity: FKegiatanEntity)
    fun deleteInBatch(listFKegiatan: List<FKegiatanEntity>)

}