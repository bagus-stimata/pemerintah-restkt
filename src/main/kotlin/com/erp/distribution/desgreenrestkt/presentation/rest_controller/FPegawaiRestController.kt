package com.erp.distribution.desgreenrestkt.presentation.rest_controller

import com.erp.distribution.desgreenrestkt.data.source.entity_security.Role
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.usecase.GetFPegawaiUseCase
import com.erp.distribution.desgreenrestkt.presentation.model.FPegawaiRes
import com.erp.distribution.desgreenrestkt.presentation.model.toDomain
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
class FPegawaiRestController  @Autowired constructor(
    val fPegawaiUseCase: GetFPegawaiUseCase
) {

    @CrossOrigin
    @RequestMapping(value = ["/rest/getFPegawaiById/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFPegawaiById(@PathVariable("id") id: Int): FPegawaiRes {
        return fPegawaiUseCase.findByIdRes(id)
    }

    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFPegawai"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFPegawai(): List<FPegawaiRes?> {
        return fPegawaiUseCase.findAllRes()
    }


    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFPegawaiByDivision/{fdivisionBean}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFPegawaiByDivision(@PathVariable("fdivisionBean") fdivisionBean: Int): List<FPegawaiRes?>? {
        return fPegawaiUseCase.findByDivisionRes(fdivisionBean)
    }

/*
    @RequestMapping(value = ["/rest/getAllFPegawaiByDivisionAndShareToCompany/{fdivisionBean}/{fcompanyBean}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFPegawaiByDivisionAndShareToCompany(@PathVariable("fdivisionBean") fdivisionBean: Int, @PathVariable("fcompanyBean") fcompanyBean: Int): List<FPegawaiRes?>? {
        return fPegawaiUseCase.findByDivisionAndShareToCompanyRes(fdivisionBean, fcompanyBean)
    }
*/

    @CrossOrigin
//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = ["/rest/createFPegawai"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createFPegawai(@RequestBody fPegawaiResNew: FPegawaiRes): FPegawaiRes {
//        System.out.println("hello aku dipanggil saat create FPegawai");
        fPegawaiResNew.id = 0 //Memastikan ID adalah Nol
        return fPegawaiUseCase.save(fPegawaiResNew.toDomain()).toResponse()
        //        FPegawai updatedDomain = new FPegawai();
//        if (fPegawaiNew !=null) {
//            try {
//                fPegawaiNew.setId(0);
//                updatedDomain = fPegawaiUseCase.save(fPegawaiNew);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return updatedDomain;
    }

    @CrossOrigin
    @RequestMapping(value = ["/rest/updateFPegawai/{id}"], method = [RequestMethod.PUT])
    fun updateFPegawaiInfo(@PathVariable("id") id: Int, @RequestBody fPegawaiResUpdated: FPegawaiRes): FPegawaiRes {
        val fPegawai = fPegawaiUseCase.findById(id)
        //Tidak Meng Update Parent: Hanya Info Saja
//        var updatedDomain = FPegawai()
            fPegawaiResUpdated.id = fPegawai.id
            if (fPegawai.fdivisionBean >0) fPegawaiResUpdated.fdivisionBean = fPegawai.fdivisionBean
            try {
                fPegawaiUseCase.save(fPegawaiResUpdated.toDomain())
            } catch (e: Exception) {
            }

        return fPegawaiResUpdated
    }

    @CrossOrigin
//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = ["/rest/deleteFPegawai/{id}"], method = [RequestMethod.DELETE])
    fun deleteFPegawai(@PathVariable("id") id: Int) {
        val fPegawai = fPegawaiUseCase.findById(id)
        if (fPegawai != null) {
            fPegawaiUseCase.delete(fPegawai)
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FPegawaiRestController::class.java)
    }
}