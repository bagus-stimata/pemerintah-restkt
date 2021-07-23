package com.erp.distribution.desgreenrestkt.presentation.model

import com.erp.distribution.desgreenrestkt.domain.model.FAsosiasi
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@JacksonXmlRootElement
data class FAsosiasiRes (
    var id : Int =0,
    var sourceId : Int =0,

    var kode1 : String ="",

    var kode2 : String ="",

    var description : String ="",

    var fdivisionBean : Int =0,


    var statusActive : Boolean =true,


    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

//    @Column(name = "MODIFIED_BY", length = 20)
//    var modifiedBy : String ="" //User ID

): Serializable

internal fun FAsosiasiRes.toDomain(): FAsosiasi {
    return FAsosiasi(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

//        created = created,
        modified = modified,
//        modifiedBy = modifiedBy
    )
}