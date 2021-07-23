package com.erp.distribution.desgreenrestkt.data.source.entity

import com.erp.distribution.desgreenrestkt.domain.model.FKegiatan
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.type.IntegerType
import java.io.Serializable
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "fkegiatan")
class FKegiatanEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_sequence")
    @SequenceGenerator(
        name = "hibernate_sequence",
        sequenceName = "hibernate_sequence_master",
        allocationSize = 20,
        initialValue = 912345668
    )
    @Column(name = "id")
    var id : Int =0,

    @Column(length = 9)
    var sourceId  :Int =0,

    @Column(length = 10)
    var kode1 : String ="",

    @Column(length = 20)
    var kode2 : String ="",

    @Column(length = 100)
    var description : String ="",

    //	@ManyToOne
    //	@JoinColumn(name="fdivisionBean", referencedColumnName="ID")
    //	private FDivision fdivisionBean;
    @Column(name = "fdivisionBean", nullable =false)
    var fdivisionBean : Int =0,


    @Column
    var statusActive : Boolean =true,

    @Column
    var tahun : Int? =2021,

    @Column(length = 200)
    var namaPekerjaan : String ="",
    @Column(length = 200)
    var gantiNamaPaket : String ="",
    @Column(length = 200)
    var paketAbt : String ="",

    @Column
    var nilaiPagu : Double? =0.0,
    @Column
    var nilaiKontrak : Double? =0.0,


    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var created : Date =Date(),

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

    @Column(length = 20)
    var modifiedBy : String ="" //User ID

): Serializable

internal fun FKegiatanEntity.toDomain(): FKegiatan {
    return FKegiatan(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

        tahun = tahun!!,
        namaPekerjaan = namaPekerjaan,
        gantiNamaPaket = gantiNamaPaket,
        paketAbt = paketAbt,
        nilaiPagu = nilaiPagu!!,
        nilaiKontrak = nilaiKontrak!!,


        created = created,
        modified = modified,
        modifiedBy = modifiedBy

    )
}