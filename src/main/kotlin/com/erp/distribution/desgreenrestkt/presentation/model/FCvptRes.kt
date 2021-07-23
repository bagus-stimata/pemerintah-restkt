package com.erp.distribution.desgreenrestkt.presentation.model

import com.erp.distribution.desgreenrestkt.domain.model.FCvpt
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@JacksonXmlRootElement
data class FCvptRes (
    var id : Int =0,
    var sourceId : Int =0,

    var kode1 : String ="",

    var kode2 : String ="",
    var description : String ="",
    var fdivisionBean : Int =0,
    var statusActive : Boolean =true,

    var address : String ="",
    var city : String ="",
    var phone : String ="",
    var email : String ="",
    var contact : String ="",
    var nktt : String ="",
    var nomor_akta : String ="",
    @Temporal(TemporalType.DATE)
    var tangal_akta : Date =Date(),


    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

//    @Column(name = "MODIFIED_BY", length = 20)
//    var modifiedBy : String ="" //User ID

): Serializable

internal fun FCvptRes.toDomain(): FCvpt {
    return FCvpt(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

        address = address,
        city = city,
        phone = phone,
        email = email,
        contact = contact,
        nktt = nktt,
        nomor_akta = nomor_akta,
        tangal_akta = tangal_akta,

//        created = created,
        modified = modified,
//        modifiedBy = modifiedBy
    )
}