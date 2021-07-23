package com.erp.distribution.desgreenrestkt.domain.model

import com.erp.distribution.desgreenrestkt.data.source.entity.FCvptEntity
import com.erp.distribution.desgreenrestkt.presentation.model.FCvptRes
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.type.IntegerType
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.xml.bind.annotation.XmlTransient

class FCvpt (
    var id : Int =0,
    var sourceId : Int =0,

    var kode1 : String ="",

    var kode2 : String ="",

    var description : String ="",

    //	@ManyToOne
    //	@JoinColumn(name="fdivisionBean", referencedColumnName="ID")
    //	private FDivision fdivisionBean;
    @Column(name = "fdivisionBean", nullable =false)
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
    var created : Date =Date(),

    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

    var modifiedBy : String ="" //User ID

): Serializable

internal fun FCvpt.toEntity(): FCvptEntity {
    return FCvptEntity(
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

        created = created,
        modified = modified,
        modifiedBy = modifiedBy
    )
}

internal fun FCvpt.toResponse(): FCvptRes {
    return FCvptRes(
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