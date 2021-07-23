package com.erp.distribution.desgreenrestkt.domain.model

import com.erp.distribution.desgreenrestkt.data.source.entity.FKegiatanEntity
import com.erp.distribution.desgreenrestkt.presentation.model.FKegiatanRes
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.type.IntegerType
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.xml.bind.annotation.XmlTransient

class FKegiatan (
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


    @Column(name = "STATUS_ACTIVE")
    var statusActive : Boolean =true,

//    @OneToMany(mappedBy="fareaBean", fetch=FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    var fsubareaSet :Set<FSubAreaEntity> = HashSet<FSubAreaEntity>(),

    var tahun : Int =2021,

    var namaPekerjaan : String ="",
    var gantiNamaPaket : String ="",
    var paketAbt : String ="",

    var nilaiPagu : Double =0.0,
    var nilaiKontrak : Double =0.0,



    @Temporal(TemporalType.TIMESTAMP)
    var created : Date =Date(),

    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

    var modifiedBy : String ="" //User ID

): Serializable

internal fun FKegiatan.toEntity(): FKegiatanEntity {
    return FKegiatanEntity(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

//        fsubareaSet = fsubareaSet,

        tahun = tahun?.let { 0 },
        namaPekerjaan = namaPekerjaan,
        gantiNamaPaket = gantiNamaPaket,
        paketAbt = paketAbt,
        nilaiPagu = nilaiPagu?.let { 0.0 },
        nilaiKontrak = nilaiKontrak?.let { 0.0 },


        created = created,
        modified = modified,
        modifiedBy = modifiedBy
    )
}

internal fun FKegiatan.toResponse(): FKegiatanRes {
    return FKegiatanRes(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

        tahun = tahun?.let { 0 },
        nama_pekerjaan = namaPekerjaan,
        ganti_nama_paket = gantiNamaPaket,
        paket_abt = paketAbt,
        nilai_pagu = nilaiPagu?.let { 0.0 },
        nilai_kontrak = nilaiKontrak?.let { 0.0 },


//        created = created,
        modified = modified,
//        modifiedBy = modifiedBy
    )
}