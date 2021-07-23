package com.erp.distribution.desgreenrestkt.domain.usecase

import com.erp.distribution.desgreenrestkt.data.source.entity.toDomain
import com.erp.distribution.desgreenrestkt.domain.model.FAsosiasi
import com.erp.distribution.desgreenrestkt.domain.model.toEntity
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.repository.FAsosiasiRepo
import com.erp.distribution.desgreenrestkt.presentation.model.FAsosiasiRes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetFAsosiasiUseCase @Autowired constructor(
    val fAsosiasiRepo: FAsosiasiRepo
) {

    fun findById(id: Int): FAsosiasi {
        return fAsosiasiRepo.findById(id).toDomain()
    }
    fun findByIdRes(id: Int): FAsosiasiRes {
        return fAsosiasiRepo.findById(id).toDomain().toResponse()
    }
    fun findByKode1(kode1: String): List<FAsosiasi> {
        return  fAsosiasiRepo.findByKode1(kode1).map {
            it.toDomain()
        }
    }
    fun findByKode1Res(kode1: String): List<FAsosiasiRes> {
        return  fAsosiasiRepo.findByKode1(kode1).map {
            it.toDomain().toResponse()
        }
    }

    fun findAll(): List<FAsosiasi> {
        return fAsosiasiRepo.findAll().map {
            it.toDomain()
        }
    }
    fun findAllRes(): List<FAsosiasiRes> {
        return fAsosiasiRepo.findAll().map {
            it.toDomain().toResponse()
        }
    }
    fun findAll(kode1: String, description: String): List<FAsosiasi> {
        return  fAsosiasiRepo.findAll(kode1, description).map {
            it.toDomain()
        }
    }
    fun findAllRes(kode1: String, description: String): List<FAsosiasiRes> {
        return  fAsosiasiRepo.findAll(kode1, description).map {
            it.toDomain().toResponse()
        }
    }

    fun findByDivision(fdivisionBean: Int): List<FAsosiasi> {
        return  fAsosiasiRepo.findByDivision(fdivisionBean).map {
            it.toDomain()
        }
    }
    fun findByDivisionRes(fdivisionBean: Int): List<FAsosiasiRes> {
        return  fAsosiasiRepo.findByDivision(fdivisionBean).map {
            it.toDomain().toResponse()
        }
    }
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FAsosiasi> {
//        return  fAsosiasiRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain()
//        }
//    }
//    fun findByDivisionAndShareToCompanyRes(fdivisionBean: Int, fcompanyBean: Int): List<FAsosiasiRes> {
//        return  fAsosiasiRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain().toResponse()
//        }
//    }

    fun save(fAsosiasi: FAsosiasi): FAsosiasi {
        return fAsosiasiRepo.save(fAsosiasi.toEntity()).toDomain()
    }
    fun saveAll(listFAsosiasi: List<FAsosiasi>): List<FAsosiasi> {
        return fAsosiasiRepo.saveAll(listFAsosiasi.map { it.toEntity() })!!.map {
            it.toDomain()
        }
    }

    fun delete(fAsosiasi: FAsosiasi) {
        return fAsosiasiRepo.delete(fAsosiasi.toEntity())
    }
    fun deleteInBatch(listFAsosiasi: List<FAsosiasi>) {
        return fAsosiasiRepo.deleteInBatch(listFAsosiasi.map { it.toEntity() })
    }


}