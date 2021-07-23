package com.erp.distribution.desgreenrestkt.domain.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FAsosiasiEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FAsosiasiRepo {
    fun findById(id: Int): FAsosiasiEntity
    fun findAll(): List<FAsosiasiEntity>
    fun findByKode1(kode1: String): List<FAsosiasiEntity>
    fun findAll(kode1: String, description: String): List<FAsosiasiEntity>
    fun findByDivision(fdivisionBean: Int): List<FAsosiasiEntity>
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FAsosiasiEntity>

    fun save(fAsosiasiEntity: FAsosiasiEntity): FAsosiasiEntity
    fun saveAll(listFAsosiasi: List<FAsosiasiEntity>): List<FAsosiasiEntity>
    fun delete(fAsosiasiEntity: FAsosiasiEntity)
    fun deleteInBatch(listFAsosiasi: List<FAsosiasiEntity>)

}