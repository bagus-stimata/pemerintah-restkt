package com.erp.distribution.desgreenrestkt.data.source.entity

import com.erp.distribution.desgreenrestkt.domain.model.FPegawai
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.type.IntegerType
import java.io.Serializable
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "fpegawai")
class FPegawaiEntity (
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
    @Temporal(TemporalType.TIMESTAMP)
    var created : Date =Date(),

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

    @Column(length = 20)
    var modifiedBy : String ="" //User ID

): Serializable

internal fun FPegawaiEntity.toDomain(): FPegawai {
    return FPegawai(
        id = id,
        sourceId = sourceId,

        kode1 = kode1,
        kode2 = kode2,
        description = description,
        fdivisionBean = fdivisionBean,
        statusActive = statusActive,

        created = created,
        modified = modified,
        modifiedBy = modifiedBy

    )
}