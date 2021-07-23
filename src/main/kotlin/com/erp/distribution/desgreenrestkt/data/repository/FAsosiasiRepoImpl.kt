package com.erp.distribution.desgreenrestkt.data.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FAsosiasiEntity
import com.erp.distribution.desgreenrestkt.data.source.local.dao.FAsosiasiJPARepository
import com.erp.distribution.desgreenrestkt.domain.repository.FAsosiasiRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FAsosiasiRepoImpl @Autowired constructor(
    val fAsosiasiJPARepository: FAsosiasiJPARepository
) :FAsosiasiRepo {
    override fun findById(id: Int): FAsosiasiEntity {
        return fAsosiasiJPARepository.findById(id).get()
    }

    override fun findAll(): List<FAsosiasiEntity> {
        return fAsosiasiJPARepository.findAll()
    }

    override fun findAll(kode1: String, description: String): List<FAsosiasiEntity> {
        return fAsosiasiJPARepository.findAll(kode1, description)
    }

    override fun findByKode1(kode1: String): List<FAsosiasiEntity> {
        return fAsosiasiJPARepository.findByKode1(kode1)
    }

    override fun findByDivision(fdivisionBean: Int): List<FAsosiasiEntity> {
        return fAsosiasiJPARepository.findAllByDivision(fdivisionBean).orEmpty()
    }

//    override fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FAsosiasiEntity> {
//        return fAsosiasiJPARepository.findAllByDivisionAndShareToCompany(fdivisionBean, fcompanyBean)
//    }

    override fun save(fAsosiasiEntity: FAsosiasiEntity): FAsosiasiEntity {
        return fAsosiasiJPARepository.save(fAsosiasiEntity)
    }
    override fun saveAll(listFAsosiasi: List<FAsosiasiEntity>): List<FAsosiasiEntity> {
        return fAsosiasiJPARepository.saveAll(listFAsosiasi)
    }


    override fun delete(fAsosiasiEntity: FAsosiasiEntity) {
        return fAsosiasiJPARepository.delete(fAsosiasiEntity)
    }
    override fun deleteInBatch(listFAsosiasi: List<FAsosiasiEntity>) {
        return fAsosiasiJPARepository.deleteInBatch(listFAsosiasi)
    }

}