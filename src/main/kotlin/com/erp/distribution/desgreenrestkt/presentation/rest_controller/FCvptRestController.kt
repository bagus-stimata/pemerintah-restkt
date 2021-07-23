package com.erp.distribution.desgreenrestkt.presentation.rest_controller

import com.erp.distribution.desgreenrestkt.data.source.entity_security.Role
import com.erp.distribution.desgreenrestkt.domain.model.toResponse
import com.erp.distribution.desgreenrestkt.domain.usecase.GetFCvptUseCase
import com.erp.distribution.desgreenrestkt.presentation.model.FCvptRes
import com.erp.distribution.desgreenrestkt.presentation.model.toDomain
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
class FCvptRestController  @Autowired constructor(
    val fCvptUseCase: GetFCvptUseCase
) {

    @CrossOrigin
    @RequestMapping(value = ["/rest/getFCvptById/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFCvptById(@PathVariable("id") id: Int): FCvptRes {
        return fCvptUseCase.findByIdRes(id)
    }

    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFCvpt"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFCvpt(): List<FCvptRes?> {
        return fCvptUseCase.findAllRes()
    }


    @CrossOrigin
    @RequestMapping(value = ["/rest/getAllFCvptByDivision/{fdivisionBean}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFCvptByDivision(@PathVariable("fdivisionBean") fdivisionBean: Int): List<FCvptRes?>? {
        return fCvptUseCase.findByDivisionRes(fdivisionBean)
    }


    @CrossOrigin
//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = ["/rest/createFCvpt"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createFCvpt(@RequestBody fCvptResNew: FCvptRes): FCvptRes {
//        System.out.println("hello aku dipanggil saat create FCvpt");
        fCvptResNew.id = 0 //Memastikan ID adalah Nol
        return fCvptUseCase.save(fCvptResNew.toDomain()).toResponse()
        //        FCvpt updatedDomain = new FCvpt();
//        if (fCvptNew !=null) {
//            try {
//                fCvptNew.setId(0);
//                updatedDomain = fCvptUseCase.save(fCvptNew);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return updatedDomain;
    }

    @CrossOrigin
    @RequestMapping(value = ["/rest/updateFCvpt/{id}"], method = [RequestMethod.PUT])
    fun updateFCvptInfo(@PathVariable("id") id: Int, @RequestBody fCvptResUpdated: FCvptRes): FCvptRes {
        System.out.println("The : " + id + " >> " + fCvptResUpdated)

        val fCvpt = fCvptUseCase.findById(id)
        //Tidak Meng Update Parent: Hanya Info Saja
//        var updatedDomain = FCvpt()
            fCvptResUpdated.id = fCvpt.id
//            if (fCvpt.fdivisionBean >0) fCvptResUpdated.fdivisionBean = fCvpt.fdivisionBean
            try {
                fCvptUseCase.save(fCvptResUpdated.toDomain())
            } catch (e: Exception) {
            }

        return fCvptResUpdated
    }

    @CrossOrigin
//    @PreAuthorize("hasAnyRole({'" + Role.ADMIN + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = ["/rest/deleteFCvpt/{id}"], method = [RequestMethod.DELETE])
    fun deleteFCvpt(@PathVariable("id") id: Int) {
        val fCvpt = fCvptUseCase.findById(id)
        if (fCvpt != null) {
            fCvptUseCase.delete(fCvpt)
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FCvptRestController::class.java)
    }
}