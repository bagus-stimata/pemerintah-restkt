package com.erp.distribution.desgreenrestkt.presentation.rest_controller

import com.erp.distribution.desgreenrestkt.data.source.entity_security.Role
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.usecase.GetFKegiatanUseCase
import com.erp.distribution.desgreenrestkt.presentation.model.FKegiatanRes
import com.erp.distribution.desgreenrestkt.presentation.model.toDomain
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
class FKegiatanRestController  @Autowired constructor(
    val fKegiatanUseCase: GetFKegiatanUseCase
) {

    @CrossOrigin
    @RequestMapping(value = ["/rest/getFKegiatanById/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFKegiatanById(@PathVariable("id") id: Int): FKegiatanRes {
        return fKegiatanUseCase.findByIdRes(id)
    }

    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFKegiatan"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFKegiatan(): List<FKegiatanRes?> {
        return fKegiatanUseCase.findAllRes()
    }


    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFKegiatanByDivision/{fdivisionBean}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFKegiatanByDivision(@PathVariable("fdivisionBean") fdivisionBean: Int): List<FKegiatanRes?>? {
        return fKegiatanUseCase.findByDivisionRes(fdivisionBean)
    }

/*
    @RequestMapping(value = ["/rest/getAllFKegiatanByDivisionAndShareToCompany/{fdivisionBean}/{fcompanyBean}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFKegiatanByDivisionAndShareToCompany(@PathVariable("fdivisionBean") fdivisionBean: Int, @PathVariable("fcompanyBean") fcompanyBean: Int): List<FKegiatanRes?>? {
        return fKegiatanUseCase.findByDivisionAndShareToCompanyRes(fdivisionBean, fcompanyBean)
    }
*/

//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @CrossOrigin
    @RequestMapping(value = ["/rest/createFKegiatan"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createFKegiatan(@RequestBody fKegiatanResNew: FKegiatanRes): FKegiatanRes {
        System.out.println("hello aku dipanggil saat create FKegiatan " + fKegiatanResNew);
        fKegiatanResNew.id = 0 //Memastikan ID adalah Nol
        return fKegiatanUseCase.save(fKegiatanResNew.toDomain()).toResponse()
        //        FKegiatan updatedDomain = new FKegiatan();
//        if (fKegiatanNew !=null) {
//            try {
//                fKegiatanNew.setId(0);
//                updatedDomain = fKegiatanUseCase.save(fKegiatanNew);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return updatedDomain;
    }

    @CrossOrigin
    @RequestMapping(value = ["/rest/updateFKegiatan/{id}"], method = [RequestMethod.PUT])
    fun updateFKegiatanInfo(@PathVariable("id") id: Int, @RequestBody fKegiatanResUpdated: FKegiatanRes): FKegiatanRes {
        System.out.println("hello aku dipanggil saat Update FKegiatan " + fKegiatanResUpdated);

        val fKegiatan = fKegiatanUseCase.findById(id)
        //Tidak Meng Update Parent: Hanya Info Saja
//        var updatedDomain = FKegiatan()
            fKegiatanResUpdated.id = fKegiatan.id
            if (fKegiatan.fdivisionBean >0) fKegiatanResUpdated.fdivisionBean = fKegiatan.fdivisionBean

            try {
                fKegiatanUseCase.save(fKegiatanResUpdated.toDomain())
            } catch (e: Exception) {
                e.printStackTrace()
            }

        return fKegiatanResUpdated
    }

    @CrossOrigin
//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = ["/rest/deleteFKegiatan/{id}"], method = [RequestMethod.DELETE])
    fun deleteFKegiatan(@PathVariable("id") id: Int) {
        val fKegiatan = fKegiatanUseCase.findById(id)
        if (fKegiatan != null) {
            fKegiatanUseCase.delete(fKegiatan)
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FKegiatanRestController::class.java)
    }
}