package com.erp.distribution.desgreenrestkt.domain.usecase

import com.erp.distribution.desgreenrestkt.data.source.entity.toDomain
import com.erp.distribution.desgreenrestkt.domain.model.FCvpt
import com.erp.distribution.desgreenrestkt.domain.model.toEntity
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.repository.FCvptRepo
import com.erp.distribution.desgreenrestkt.presentation.model.FCvptRes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetFCvptUseCase @Autowired constructor(
    val fCvptRepo: FCvptRepo
) {

    fun findById(id: Int): FCvpt {
        return fCvptRepo.findById(id).toDomain()
    }
    fun findByIdRes(id: Int): FCvptRes {
        return fCvptRepo.findById(id).toDomain().toResponse()
    }
    fun findByKode1(kode1: String): List<FCvpt> {
        return  fCvptRepo.findByKode1(kode1).map {
            it.toDomain()
        }
    }
    fun findByKode1Res(kode1: String): List<FCvptRes> {
        return  fCvptRepo.findByKode1(kode1).map {
            it.toDomain().toResponse()
        }
    }

    fun findAll(): List<FCvpt> {
        return fCvptRepo.findAll().map {
            it.toDomain()
        }
    }
    fun findAllRes(): List<FCvptRes> {
        return fCvptRepo.findAll().map {
            it.toDomain().toResponse()
        }
    }
    fun findAll(kode1: String, description: String): List<FCvpt> {
        return  fCvptRepo.findAll(kode1, description).map {
            it.toDomain()
        }
    }
    fun findAllRes(kode1: String, description: String): List<FCvptRes> {
        return  fCvptRepo.findAll(kode1, description).map {
            it.toDomain().toResponse()
        }
    }

    fun findByDivision(fdivisionBean: Int): List<FCvpt> {
        return  fCvptRepo.findByDivision(fdivisionBean).map {
            it.toDomain()
        }
    }
    fun findByDivisionRes(fdivisionBean: Int): List<FCvptRes> {
        return  fCvptRepo.findByDivision(fdivisionBean).map {
            it.toDomain().toResponse()
        }
    }
//    fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FCvpt> {
//        return  fCvptRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain()
//        }
//    }
//    fun findByDivisionAndShareToCompanyRes(fdivisionBean: Int, fcompanyBean: Int): List<FCvptRes> {
//        return  fCvptRepo.findByDivisionAndShareToCompany(fdivisionBean, fcompanyBean).map {
//            it.toDomain().toResponse()
//        }
//    }

    fun save(fCvpt: FCvpt): FCvpt {
        return fCvptRepo.save(fCvpt.toEntity()).toDomain()
    }
    fun saveAll(listFCvpt: List<FCvpt>): List<FCvpt> {
        return fCvptRepo.saveAll(listFCvpt.map { it.toEntity() })!!.map {
            it.toDomain()
        }
    }

    fun delete(fCvpt: FCvpt) {
        return fCvptRepo.delete(fCvpt.toEntity())
    }
    fun deleteInBatch(listFCvpt: List<FCvpt>) {
        return fCvptRepo.deleteInBatch(listFCvpt.map { it.toEntity() })
    }


}