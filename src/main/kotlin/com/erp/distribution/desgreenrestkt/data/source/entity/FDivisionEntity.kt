package com.erp.distribution.desgreenrestkt.data.source.entity

import com.erp.distribution.desgreenrestkt.domain.model.FCompany
import com.erp.distribution.desgreenrestkt.domain.model.FDivision
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "fdivision")
data class FDivisionEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_sequence")
    @SequenceGenerator(
        name = "hibernate_sequence",
        sequenceName = "hibernate_sequence_master",
        allocationSize = 20,
        initialValue = 912345668
    )
    @Column(name = "id", length = 9)
    var id  :Int =0,

    /*
	 * JIKA COPY DARI TEMPAT LAIN: MAKA SEBAGAI LOG TRACK MENINGGALKAN SOURCE_ID = ID sumber asal dia dicopy
	 * keperluan diantaranya:
	 * 1. Clone Database. karena tidak mungkin menggunakan Kode External yang bisa jadi kemungkinan kembar, tapi harus pakai kode internal
	 * 2. 
	 */
    @Column(length = 9)
    var sourceId  :Int =0,

    @Column(length = 10)
    var kode1  :String ="",

    @Column(length = 20)
    var kode2  :String ="",

    @Column(length = 100)
    var description  :String ="",

    //	@ManyToOne
    //	@JoinColumn(name="fcompanyBean", referencedColumnName="ID")
    //	private FCompany fcompanyBean;
    @Column(name = "fcompanyBean", nullable = false)
    var fcompanyBean  :Int =0,

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
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var created :Date =Date(),

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var modified :Date =Date(),

    @Column(length = 20)
    var modifiedBy  :String =""

): Serializable

internal fun FDivisionEntity.toDomain(): FDivision {
    return FDivision(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,

//        fcompanyBean = fcompanyBean?.let { FCompany(fcompanyBean.i) },

        statusActive = statusActive,

        created = created,
        modified = modified,
        modifiedBy = modifiedBy
    )
}