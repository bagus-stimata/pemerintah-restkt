package com.erp.distribution.desgreenrestkt.presentation.rest_controller

import com.erp.distribution.desgreenrestkt.data.source.entity_security.Role
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.usecase.GetFAsosiasiUseCase
import com.erp.distribution.desgreenrestkt.presentation.model.FAsosiasiRes
import com.erp.distribution.desgreenrestkt.presentation.model.toDomain
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
class FAsosiasiRestController  @Autowired constructor(
    val fAsosiasiUseCase: GetFAsosiasiUseCase
) {

    @CrossOrigin
    @RequestMapping(value = ["/rest/getFAsosiasiById/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFAsosiasiById(@PathVariable("id") id: Int): FAsosiasiRes {
        return fAsosiasiUseCase.findByIdRes(id)
    }


    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFAsosiasi"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFAsosiasi(): List<FAsosiasiRes?> {
        return fAsosiasiUseCase.findAllRes()
    }


    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFAsosiasiByDivision/{fdivisionBean}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFAsosiasiByDivision(@PathVariable("fdivisionBean") fdivisionBean: Int): List<FAsosiasiRes?>? {
        return fAsosiasiUseCase.findByDivisionRes(fdivisionBean)
    }

/*
    @RequestMapping(value = ["/rest/getAllFAsosiasiByDivisionAndShareToCompany/{fdivisionBean}/{fcompanyBean}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFAsosiasiByDivisionAndShareToCompany(@PathVariable("fdivisionBean") fdivisionBean: Int, @PathVariable("fcompanyBean") fcompanyBean: Int): List<FAsosiasiRes?>? {
        return fAsosiasiUseCase.findByDivisionAndShareToCompanyRes(fdivisionBean, fcompanyBean)
    }
*/

//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @CrossOrigin
    @RequestMapping(value = ["/rest/createFAsosiasi"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createFAsosiasi(@RequestBody fAsosiasiResNew: FAsosiasiRes): FAsosiasiRes {
//        System.out.println("hello aku dipanggil saat create FAsosiasi");
        fAsosiasiResNew.id = 0 //Memastikan ID adalah Nol
        return fAsosiasiUseCase.save(fAsosiasiResNew.toDomain()).toResponse()
        //        FAsosiasi updatedDomain = new FAsosiasi();
//        if (fAsosiasiNew !=null) {
//            try {
//                fAsosiasiNew.setId(0);
//                updatedDomain = fAsosiasiUseCase.save(fAsosiasiNew);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return updatedDomain;
    }

    @CrossOrigin
    @RequestMapping(value = ["/rest/updateFAsosiasi/{id}"], method = [RequestMethod.PUT])
    fun updateFAsosiasiInfo(@PathVariable("id") id: Int, @RequestBody fAsosiasiResUpdated: FAsosiasiRes): FAsosiasiRes {
        val fAsosiasi = fAsosiasiUseCase.findById(id)
        //Tidak Meng Update Parent: Hanya Info Saja
//        var updatedDomain = FAsosiasi()
            fAsosiasiResUpdated.id = fAsosiasi.id
            if (fAsosiasi.fdivisionBean >0) fAsosiasiResUpdated.fdivisionBean = fAsosiasi.fdivisionBean
            try {
                fAsosiasiUseCase.save(fAsosiasiResUpdated.toDomain())
            } catch (e: Exception) {
            }

        return fAsosiasiResUpdated
    }

    @CrossOrigin
//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = ["/rest/deleteFAsosiasi/{id}"], method = [RequestMethod.DELETE])
    fun deleteFAsosiasi(@PathVariable("id") id: Int) {
        val fAsosiasi = fAsosiasiUseCase.findById(id)
        if (fAsosiasi != null) {
            fAsosiasiUseCase.delete(fAsosiasi)
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FAsosiasiRestController::class.java)
    }
}