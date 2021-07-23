package com.erp.distribution.desgreenrestkt.presentation.model

import com.erp.distribution.desgreenrestkt.domain.model.FKegiatan
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@JacksonXmlRootElement
data class FKegiatanRes (
    var id : Int =0,
    var sourceId : Int =0,

    var kode1 : String ="",

    var kode2 : String ="",

    var description : String ="",

    var fdivisionBean : Int =0,


    var statusActive : Boolean =true,

    var tahun : Int =2021,

    var nama_pekerjaan : String ="",
    var ganti_nama_paket : String ="",
    var paket_abt : String ="",

    var nilai_pagu : Double =0.0,
    var nilai_kontrak : Double =0.0,


    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

//    @Column(name = "MODIFIED_BY", length = 20)
//    var modifiedBy : String ="" //User ID

): Serializable

internal fun FKegiatanRes.toDomain(): FKegiatan {
    return FKegiatan(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

        tahun = tahun,
        namaPekerjaan = nama_pekerjaan,
        gantiNamaPaket = ganti_nama_paket,
        paketAbt = paket_abt,
        nilaiPagu = nilai_pagu,
        nilaiKontrak = nilai_kontrak,


//        created = created,
        modified = modified,
//        modifiedBy = modifiedBy
    )
}