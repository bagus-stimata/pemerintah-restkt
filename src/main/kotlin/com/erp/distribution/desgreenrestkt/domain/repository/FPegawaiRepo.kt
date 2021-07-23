package com.erp.distribution.desgreenrestkt.domain.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FPegawaiEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FPegawaiRepo {
    fun findById(id: Int): FPegawaiEntity
    fun findAll(): List<FPegawaiEntity>
    fun findByKode1(kode1: String): List<FPegawaiEntity>
    fun findAll(kode1: String, description: String): List<FPegawaiEntity>
    fun findByDivision(fdivisionBean: Int): List<FPegawaiEntity>
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FPegawaiEntity>

    fun save(fPegawaiEntity: FPegawaiEntity): FPegawaiEntity
    fun saveAll(listFPegawai: List<FPegawaiEntity>): List<FPegawaiEntity>
    fun delete(fPegawaiEntity: FPegawaiEntity)
    fun deleteInBatch(listFPegawai: List<FPegawaiEntity>)

}