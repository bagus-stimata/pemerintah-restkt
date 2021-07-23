package com.erp.distribution.desgreenrestkt.domain.usecase

import com.erp.distribution.desgreenrestkt.data.source.entity.toDomain
import com.erp.distribution.desgreenrestkt.domain.model.FPegawai
import com.erp.distribution.desgreenrestkt.domain.model.toEntity
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.repository.FPegawaiRepo
import com.erp.distribution.desgreenrestkt.presentation.model.FPegawaiRes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetFPegawaiUseCase @Autowired constructor(
    val fPegawaiRepo: FPegawaiRepo
) {

    fun findById(id: Int): FPegawai {
        return fPegawaiRepo.findById(id).toDomain()
    }
    fun findByIdRes(id: Int): FPegawaiRes {
        return fPegawaiRepo.findById(id).toDomain().toResponse()
    }
    fun findByKode1(kode1: String): List<FPegawai> {
        return  fPegawaiRepo.findByKode1(kode1).map {
            it.toDomain()
        }
    }
    fun findByKode1Res(kode1: String): List<FPegawaiRes> {
        return  fPegawaiRepo.findByKode1(kode1).map {
            it.toDomain().toResponse()
        }
    }

    fun findAll(): List<FPegawai> {
        return fPegawaiRepo.findAll().map {
            it.toDomain()
        }
    }
    fun findAllRes(): List<FPegawaiRes> {
        return fPegawaiRepo.findAll().map {
            it.toDomain().toResponse()
        }
    }
    fun findAll(kode1: String, description: String): List<FPegawai> {
        return  fPegawaiRepo.findAll(kode1, description).map {
            it.toDomain()
        }
    }
    fun findAllRes(kode1: String, description: String): List<FPegawaiRes> {
        return  fPegawaiRepo.findAll(kode1, description).map {
            it.toDomain().toResponse()
        }
    }

    fun findByDivision(fdivisionBean: Int): List<FPegawai> {
        return  fPegawaiRepo.findByDivision(fdivisionBean).map {
            it.toDomain()
        }
    }
    fun findByDivisionRes(fdivisionBean: Int): List<FPegawaiRes> {
        return  fPegawaiRepo.findByDivision(fdivisionBean).map {
            it.toDomain().toResponse()
        }
    }
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FPegawai> {
//        return  fPegawaiRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain()
//        }
//    }
//    fun findByDivisionAndShareToCompanyRes(fdivisionBean: Int, fcompanyBean: Int): List<FPegawaiRes> {
//        return  fPegawaiRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain().toResponse()
//        }
//    }

    fun save(fPegawai: FPegawai): FPegawai {
        return fPegawaiRepo.save(fPegawai.toEntity()).toDomain()
    }
    fun saveAll(listFPegawai: List<FPegawai>): List<FPegawai> {
        return fPegawaiRepo.saveAll(listFPegawai.map { it.toEntity() })!!.map {
            it.toDomain()
        }
    }

    fun delete(fPegawai: FPegawai) {
        return fPegawaiRepo.delete(fPegawai.toEntity())
    }
    fun deleteInBatch(listFPegawai: List<FPegawai>) {
        return fPegawaiRepo.deleteInBatch(listFPegawai.map { it.toEntity() })
    }


}