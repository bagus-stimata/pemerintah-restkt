package com.erp.distribution.desgreenrestkt.domain.model

import com.erp.distribution.desgreenrestkt.data.source.entity.FPegawaiEntity
import com.erp.distribution.desgreenrestkt.presentation.model.FPegawaiRes
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.type.IntegerType
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.xml.bind.annotation.XmlTransient

class FPegawai (
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

//    @OneToMany(mappedBy="fareaBean", fetch=FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    var fsubareaSet :Set<FSubAreaEntity> = HashSet<FSubAreaEntity>(),



    @Temporal(TemporalType.TIMESTAMP)
    var created : Date =Date(),

    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

    var modifiedBy : String ="" //User ID

): Serializable

internal fun FPegawai.toEntity(): FPegawaiEntity {
    return FPegawaiEntity(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

//        fsubareaSet = fsubareaSet,

        created = created,
        modified = modified,
        modifiedBy = modifiedBy
    )
}

internal fun FPegawai.toResponse(): FPegawaiRes {
    return FPegawaiRes(
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