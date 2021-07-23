package com.erp.distribution.desgreenrestkt.presentation.model

import com.erp.distribution.desgreenrestkt.domain.model.FCompany
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@JacksonXmlRootElement
data class FCompanyRes (
    var id :Int =0,

    var kode1 :String ="",

    var kode2 :String ="",

    var description :String ="",

    var shareDataToBeClone :Boolean =false,

    var shareDataToBeCloneSecurityCode :String ="",

    var statusActive :Boolean =true,


    /*
	 * SETTING YANG BERLAKU UNTUK SEMUA DIVISI
	 * JIKA KOSONG MAKA MENGGUNAKAN PRIORITAS ATASNYA
	 * 1. Parameter System
	 * 2. Corporation
	 * 3. Division 
	 */

    //	@Column(name="INVOICE_COMPANY_NPWP_1", length=45)
    //	private String invoiceCompanyNpwpPhone1 :String ="",;
    //LOG
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    var created :Date =Date(),

    @Column(name = "MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    var modified :Date =Date(),

    @Column(name = "MODIFIED_BY", length = 20)
    var modifiedBy :String ="" //User ID

): Serializable

internal fun FCompanyRes.toDomain(): FCompany {
    return FCompany(
        id = id,

        kode1 = kode1,
        kode2 = kode2,
        description = description,

        shareDataToBeClone = shareDataToBeClone,
        shareDataToBeCloneSecurityCode = shareDataToBeCloneSecurityCode,
        statusActive = statusActive,

        created = created,
//        modified = modified,
        modifiedBy = modifiedBy
    )
}