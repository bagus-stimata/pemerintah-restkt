package com.erp.distribution.desgreenrestkt.data.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FKegiatanEntity
import com.erp.distribution.desgreenrestkt.data.source.local.dao.FKegiatanJPARepository
import com.erp.distribution.desgreenrestkt.domain.repository.FKegiatanRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FKegiatanRepoImpl @Autowired constructor(
    val fKegiatanJPARepository: FKegiatanJPARepository
) :FKegiatanRepo {
    override fun findById(id: Int): FKegiatanEntity {
        return fKegiatanJPARepository.findById(id).get()
    }

    override fun findAll(): List<FKegiatanEntity> {
        return fKegiatanJPARepository.findAll()
    }

    override fun findAll(kode1: String, description: String): List<FKegiatanEntity> {
        return fKegiatanJPARepository.findAll(kode1, description)
    }

    override fun findByKode1(kode1: String): List<FKegiatanEntity> {
        return fKegiatanJPARepository.findByKode1(kode1)
    }

    override fun findByDivision(fdivisionBean: Int): List<FKegiatanEntity> {
        return fKegiatanJPARepository.findAllByDivision(fdivisionBean).orEmpty()
    }

//    override fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FKegiatanEntity> {
//        return fKegiatanJPARepository.findAllByDivisionAndShareToCompany(fdivisionBean, fcompanyBean)
//    }

    override fun save(fKegiatanEntity: FKegiatanEntity): FKegiatanEntity {
        return fKegiatanJPARepository.save(fKegiatanEntity)
    }
    override fun saveAll(listFKegiatan: List<FKegiatanEntity>): List<FKegiatanEntity> {
        return fKegiatanJPARepository.saveAll(listFKegiatan)
    }


    override fun delete(fKegiatanEntity: FKegiatanEntity) {
        return fKegiatanJPARepository.delete(fKegiatanEntity)
    }
    override fun deleteInBatch(listFKegiatan: List<FKegiatanEntity>) {
        return fKegiatanJPARepository.deleteInBatch(listFKegiatan)
    }

}