package com.erp.distribution.desgreenrestkt.data.source.entity_security

import com.erp.distribution.desgreenrestkt.domain.model_security.FUser
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tb_user")
class FUserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id :Int =0,

    @Column(unique = true)
    var email :String ="",

    @Column(unique = true)
    var username :String ="",
    var password :String ="",

    @Transient
    var passwordConfirm :String ="",

    @Column(name = "full_name")
    var fullName :String ="",

    @Column(name = "phone")
    var phone :String ="",

    @Column(name = "notes")
    var notes :String ="",

    @JsonIgnore
    @OneToMany(mappedBy = "fuserBean")
    var fuserRoles: List<FUserRolesEntity> = listOf(),

    @JsonIgnore
    @OneToMany(mappedBy = "fuserBean")
    var fUserVendorEntities: List<FUserVendorsEntity> = listOf(),

    @JsonIgnore
    @Transient
    var tempRoles: MutableList<String> = mutableListOf(),


    @Transient
    var tempVendors: List<Int> = listOf(),

    var locked :Boolean = false,

    /**
     * Tambahan for DES Setting
     */
    var fsalesmanBean: Int? = 0,
    var fdivisionBean: Int?  = 0,
    var fwarehouseBean: Int?  = 0,

    @Transient
    var tempInt1 :Int =0,

    @Transient
    var tempBol1 :Boolean =false,

    @Transient
    var tempBol2 :Boolean =false,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    var created :Date =Date(),

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified")
    var lastModified :Date =Date(),

    @Column(name = "modified_by")
    var modifiedBy :String =""


): Serializable


internal fun FUserEntity.toDomain(): FUser {
    return FUser(
        id = id,
        email = email,
        username = username,
        password = password,
        passwordConfirm = passwordConfirm,
        fullName = fullName,
        phone = phone,
        notes = notes,

//        fuserRoles =  fuserRoles,
//        fUserVendorEntities =  fUserVendorEntities,
//        tempRoles =  tempRoles,
//        tempVendors =  tempVendors,

        locked =  locked,
        fsalesmanBean =  fsalesmanBean,
        fdivisionBean = fdivisionBean,
        fwarehouseBean = fwarehouseBean,

        tempInt1 = tempInt1,
        tempBol2 = tempBol2,

        created = created,
        lastModified = lastModified,
        modifiedBy = modifiedBy

    )
}


