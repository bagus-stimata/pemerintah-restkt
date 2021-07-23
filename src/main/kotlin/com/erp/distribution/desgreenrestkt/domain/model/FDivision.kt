package com.erp.distribution.desgreenrestkt.domain.model

import com.erp.distribution.desgreenrestkt.data.source.entity.FDivisionEntity
import com.erp.distribution.desgreenrestkt.presentation.model.FDivisionRes
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@JacksonXmlRootElement
data class FDivision (
    var id  :Int =0,
    var sourceId  :Int =0,

    var kode1  :String ="",
    var kode2  :String ="",
    var description  :String ="",

     //	@ManyToOne
    //	@JoinColumn(name="fcompanyBean", referencedColumnName="ID")
//    	private FCompany fcompanyBean;
    var fcompanyBean :FCompany = FCompany(),
//    @Column(name = "fcompanyBean", nullable = false)
//    var fcompanyBean  :Int =0,

    /*
	 * ****************************
	 */
    var statusActive  :Boolean =true,

    /*
	 * SETTING YANG BERLAKU UNTUK SEMUA DIVISI
	 * JIKA KOSONG MAKA MENGGUNAKAN PRIORITAS ATASNYA
	 * 1. Parameter System
	 * 2. Corporation
	 * 3. Division 
	 */
    /*
	 * Urutan nomor dalam satu divisi biasanya mengikuti perusahaan, karena mempunyai nomor urut faktur pajak yang sama
	 * Tidak digunakan. Karena urutan Dokumen Transaksi  mengikuti Company
	 */
    //	@Column(name="NOMOR_URUT_DOC_FOLLOW_CORP") //Tidak boleh diubah-ubah
    //	private boolean nomorUrutDocTransFollowCorp  :Boolean =true,;
    /*
	 * Urutan master product, material, salesman, mengikuti parameter level 2. Level Perusahaan
	 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var created :Date =Date(),

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var modified :Date =Date(),

    @Column(length = 20)
    var modifiedBy  :String ="" //User ID

): Serializable

internal fun FDivision.toEntity(): FDivisionEntity {
    return FDivisionEntity(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,

        fcompanyBean = fcompanyBean.id,

        statusActive = statusActive,

        created = created,
        modified = modified,
        modifiedBy = modifiedBy
    )
}


internal fun FDivision.toResponse(): FDivisionRes {
    return FDivisionRes(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,


//        fcompanyBean = fcompanyBean,

        statusActive = statusActive,

        created = created,
        modified = modified,
        modifiedBy = modifiedBy
    )
}