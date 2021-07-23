package com.erp.distribution.desgreenrestkt.data.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FCvptEntity
import com.erp.distribution.desgreenrestkt.data.source.local.dao.FCvptJPARepository
import com.erp.distribution.desgreenrestkt.domain.repository.FCvptRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FCvptRepoImpl @Autowired constructor(
    val fCvptJPARepository: FCvptJPARepository
) :FCvptRepo {
    override fun findById(id: Int): FCvptEntity {
        return fCvptJPARepository.findById(id).get()
    }

    override fun findAll(): List<FCvptEntity> {
        return fCvptJPARepository.findAll()
    }

    override fun findAll(kode1: String, description: String): List<FCvptEntity> {
        return fCvptJPARepository.findAll(kode1, description)
    }

    override fun findByKode1(kode1: String): List<FCvptEntity> {
        return fCvptJPARepository.findByKode1(kode1)
    }

    override fun findByDivision(fdivisionBean: Int): List<FCvptEntity> {
        return fCvptJPARepository.findAllByDivision(fdivisionBean).orEmpty()
    }

//    override fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FCvptEntity> {
//        return fCvptJPARepository.findAllByDivisionAndShareToCompany(fdivisionBean, fcompanyBean)
//    }

    override fun save(fCvptEntity: FCvptEntity): FCvptEntity {
        return fCvptJPARepository.save(fCvptEntity)
    }
    override fun saveAll(listFCvpt: List<FCvptEntity>): List<FCvptEntity> {
        return fCvptJPARepository.saveAll(listFCvpt)
    }


    override fun delete(fCvptEntity: FCvptEntity) {
        return fCvptJPARepository.delete(fCvptEntity)
    }
    override fun deleteInBatch(listFCvpt: List<FCvptEntity>) {
        return fCvptJPARepository.deleteInBatch(listFCvpt)
    }

}