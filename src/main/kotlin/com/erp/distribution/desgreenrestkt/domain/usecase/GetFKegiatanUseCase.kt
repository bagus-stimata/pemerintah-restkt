package com.erp.distribution.desgreenrestkt.domain.usecase

import com.erp.distribution.desgreenrestkt.data.source.entity.toDomain
import com.erp.distribution.desgreenrestkt.domain.model.FKegiatan
import com.erp.distribution.desgreenrestkt.domain.model.toEntity
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.repository.FKegiatanRepo
import com.erp.distribution.desgreenrestkt.presentation.model.FKegiatanRes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetFKegiatanUseCase @Autowired constructor(
    val fKegiatanRepo: FKegiatanRepo
) {

    fun findById(id: Int): FKegiatan {
        return fKegiatanRepo.findById(id).toDomain()
    }
    fun findByIdRes(id: Int): FKegiatanRes {
        return fKegiatanRepo.findById(id).toDomain().toResponse()
    }
    fun findByKode1(kode1: String): List<FKegiatan> {
        return  fKegiatanRepo.findByKode1(kode1).map {
            it.toDomain()
        }
    }
    fun findByKode1Res(kode1: String): List<FKegiatanRes> {
        return  fKegiatanRepo.findByKode1(kode1).map {
            it.toDomain().toResponse()
        }
    }

    fun findAll(): List<FKegiatan> {
        return fKegiatanRepo.findAll().map {
            it.toDomain()
        }
    }
    fun findAllRes(): List<FKegiatanRes> {
        return fKegiatanRepo.findAll().map {
            it.toDomain().toResponse()
        }
    }
    fun findAll(kode1: String, description: String): List<FKegiatan> {
        return  fKegiatanRepo.findAll(kode1, description).map {
            it.toDomain()
        }
    }
    fun findAllRes(kode1: String, description: String): List<FKegiatanRes> {
        return  fKegiatanRepo.findAll(kode1, description).map {
            it.toDomain().toResponse()
        }
    }

    fun findByDivision(fdivisionBean: Int): List<FKegiatan> {
        return  fKegiatanRepo.findByDivision(fdivisionBean).map {
            it.toDomain()
        }
    }
    fun findByDivisionRes(fdivisionBean: Int): List<FKegiatanRes> {
        return  fKegiatanRepo.findByDivision(fdivisionBean).map {
            it.toDomain().toResponse()
        }
    }
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FKegiatan> {
//        return  fKegiatanRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain()
//        }
//    }
//    fun findByDivisionAndShareToCompanyRes(fdivisionBean: Int, fcompanyBean: Int): List<FKegiatanRes> {
//        return  fKegiatanRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain().toResponse()
//        }
//    }

    fun save(fKegiatan: FKegiatan): FKegiatan {
        return fKegiatanRepo.save(fKegiatan.toEntity()).toDomain()
    }
    fun saveAll(listFKegiatan: List<FKegiatan>): List<FKegiatan> {
        return fKegiatanRepo.saveAll(listFKegiatan.map { it.toEntity() })!!.map {
            it.toDomain()
        }
    }

    fun delete(fKegiatan: FKegiatan) {
        return fKegiatanRepo.delete(fKegiatan.toEntity())
    }
    fun deleteInBatch(listFKegiatan: List<FKegiatan>) {
        return fKegiatanRepo.deleteInBatch(listFKegiatan.map { it.toEntity() })
    }


}