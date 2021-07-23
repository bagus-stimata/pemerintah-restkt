package com.erp.distribution.desgreenrestkt.data.source.entity

import com.erp.distribution.desgreenrestkt.domain.model.FCompany
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "fcompany")
data class FCompanyEntity (
    @Id
    @Column(name = "id", length = 9)
    @SequenceGenerator(
        name = "hibernate_sequence",
        sequenceName = "hibernate_sequence_master",
        allocationSize = 20,
        initialValue = 912345668
    )
    @GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_sequence")
    var id :Int =0,

    @Column(length = 10)
    var kode1 :String ="",

    @Column(length = 20)
    var kode2 :String ="",

    @Column(length = 100)
    var description :String ="",

    @Column
    var statusActive :Boolean =true,

    /*
	 * SETTING YANG BERLAKU UNTUK SEMUA DIVISI
	 * JIKA KOSONG MAKA MENGGUNAKAN PRIORITAS ATASNYA
	 * 1. Parameter System
	 * 2. Corporation
	 * 3. Division 
	 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var created :Date =Date(),

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var modified :Date =Date(),

    @Column(length = 20)
    var modifiedBy :String ="" //User ID

): Serializable

internal fun FCompanyEntity.toDomain(): FCompany {
    return FCompany(
        id = id,

        kode1 = kode1,
        kode2 = kode2,
        description = description,

        statusActive = statusActive,

        created = created,
//        modified = modified,
        modifiedBy = modifiedBy
    )
}