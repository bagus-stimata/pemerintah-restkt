package com.erp.distribution.desgreenrestkt.data.repository

import com.erp.distribution.desgreenrestkt.data.source.entity.FPegawaiEntity
import com.erp.distribution.desgreenrestkt.data.source.local.dao.FPegawaiJPARepository
import com.erp.distribution.desgreenrestkt.domain.repository.FPegawaiRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FPegawaiRepoImpl @Autowired constructor(
    val fPegawaiJPARepository: FPegawaiJPARepository
) :FPegawaiRepo {
    override fun findById(id: Int): FPegawaiEntity {
        return fPegawaiJPARepository.findById(id).get()
    }

    override fun findAll(): List<FPegawaiEntity> {
        return fPegawaiJPARepository.findAll()
    }

    override fun findAll(kode1: String, description: String): List<FPegawaiEntity> {
        return fPegawaiJPARepository.findAll(kode1, description)
    }

    override fun findByKode1(kode1: String): List<FPegawaiEntity> {
        return fPegawaiJPARepository.findByKode1(kode1)
    }

    override fun findByDivision(fdivisionBean: Int): List<FPegawaiEntity> {
        return fPegawaiJPARepository.findAllByDivision(fdivisionBean).orEmpty()
    }

//    override fun findByDivisionAndShareToCompany(fdivisionBean: Int, fcompanyBean: Int): List<FPegawaiEntity> {
//        return fPegawaiJPARepository.findAllByDivisionAndShareToCompany(fdivisionBean, fcompanyBean)
//    }

    override fun save(fPegawaiEntity: FPegawaiEntity): FPegawaiEntity {
        return fPegawaiJPARepository.save(fPegawaiEntity)
    }
    override fun saveAll(listFPegawai: List<FPegawaiEntity>): List<FPegawaiEntity> {
        return fPegawaiJPARepository.saveAll(listFPegawai)
    }


    override fun delete(fPegawaiEntity: FPegawaiEntity) {
        return fPegawaiJPARepository.delete(fPegawaiEntity)
    }
    override fun deleteInBatch(listFPegawai: List<FPegawaiEntity>) {
        return fPegawaiJPARepository.deleteInBatch(listFPegawai)
    }

}