package com.erp.distribution.desgreenrestkt.domain.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FCvptEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FCvptRepo {
    fun findById(id: Int): FCvptEntity
    fun findAll(): List<FCvptEntity>
    fun findByKode1(kode1: String): List<FCvptEntity>
    fun findAll(kode1: String, description: String): List<FCvptEntity>
    fun findByDivision(fdivisionBean: Int): List<FCvptEntity>
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FCvptEntity>

    fun save(fCvptEntity: FCvptEntity): FCvptEntity
    fun saveAll(listFCvpt: List<FCvptEntity>): List<FCvptEntity>
    fun delete(fCvptEntity: FCvptEntity)
    fun deleteInBatch(listFCvpt: List<FCvptEntity>)

}