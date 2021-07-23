package com.erp.distribution.desgreenrestkt.data.source.entity

import com.erp.distribution.desgreenrestkt.domain.model.FCvpt
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.type.IntegerType
import java.io.Serializable
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "fcvpt")
class FCvptEntity (
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


    @Column(length = 200)
    var address : String ="",
    @Column(length = 50)
    var city : String ="",
    @Column(length = 50)
    var phone : String ="",
    @Column(length = 100)
    var email : String ="",
    @Column(length = 50)
    var contact : String ="",
    @Column(length = 50)
    var nktt : String ="",
    @Column(length = 50)
    var nomor_akta : String ="",

    @Column
    @Temporal(TemporalType.DATE)
    var tangal_akta : Date =Date(),


    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var created : Date =Date(),

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var modified : Date =Date(),

    @Column(length = 20)
    var modifiedBy : String ="" //User ID

): Serializable

internal fun FCvptEntity.toDomain(): FCvpt {
    return FCvpt(
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