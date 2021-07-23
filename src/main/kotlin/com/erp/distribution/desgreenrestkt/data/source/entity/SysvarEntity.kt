/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.distribution.desgreenrestkt.data.source.entity

import com.erp.distribution.desgreenrestkt.domain.model.Sysvar
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.io.Serializable
import java.util.*
import javax.persistence.*

@JacksonXmlRootElement
@Entity
@Table(name = "sysvar")
data class SysvarEntity (
    @Id
    @Column(length = 35)
    var id: String ="",

    /*
	 * JIKA COPY DARI TEMPAT LAIN: MAKA SEBAGAI LOG TRACK MENINGGALKAN SOURCE_ID = ID sumber asal dia dicopy
	 * keperluan diantaranya:
	 * 1. Clone Database. karena tidak mungkin menggunakan Kode External yang bisa jadi kemungkinan kembar, tapi harus pakai kode internal
	 * 2. 
	 */
    @Column
    var sourceId :String ="",

    @JsonIgnore
    @Column
    var nomorUrut  :Int =0,

    @JsonIgnore
    @Column
    var visible  :Boolean =true,

    @Column(length = 30)
    var groupSysvar :String ="",

    //** End Tools
    @Column(length = 300)
    var deskripsi :String ="",

    @Column(length = 300)
    var notes :String ="",

    @Column(length = 10)
    var tipeData :String ="",

    @Column
    var lenghtData  :Int =0,

    @Column(length = 15)
    var prefix :String ="",

    @JsonIgnore
    @Column(length = 15)
    var suffix :String ="",

    @Column(length = 300)
    var nilaiString1 :String ="",

    @Column(length = 300)
    var nilaiString2 :String ="",

    @Column
    var nilaiBol1  :Boolean =false,

    @Column
    var nilaiBol2  :Boolean =false,

    @Column
    var nilaiInt1  :Int =0,

    @Column
    var nilaiInt2  :Int =0,

    @Column
    var nilaiDouble1  :Double =0.0,

    @Column
    var nilaiDouble2  :Double =0.0,

    @Temporal(TemporalType.DATE)
    @Column
    var nilaiDate1: Date? = Date(),

    @Temporal(TemporalType.DATE)
    @Column
    var nilaiDate2: Date? = Date(),

    @Temporal(TemporalType.DATE) //date bisa time juga kok
    @Column
    var nilaiTime1: Date? = Date(),

    @Temporal(TemporalType.DATE) //date bisa time juga kok
    @Column
    var nilaiTime2: Date? = Date(),

    /*
     * DIPAKAI UNTUK 
     * Level 1= Level Aplikasi
     * Level 2= Level Company
     * Level 3= Level Division
     */
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "fcompanyBean", referencedColumnName = "ID")
//    var fcompanyBean: FCompanyEntity? = FCompanyEntity(),
    var fcompanyBean: Int? = 0,

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "fdivisionBean", referencedColumnName = "ID")
//    var fdivisionBean: FDivisionEntity? = FDivisionEntity(),
    var fdivisionBean: Int? = 0,

    @JsonIgnore
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var created :Date =Date(),

    @JsonIgnore
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var modified :Date =Date(),

    @JsonIgnore
    @Column(length = 20)
    var modifiedBy :String ="" //User ID



): Serializable


internal fun SysvarEntity.toDomain(): Sysvar {
    return Sysvar(
        id = id,
        sourceId = sourceId,

        nomorUrut = nomorUrut,
        visible = visible,
        groupSysvar = groupSysvar,
        deskripsi = deskripsi,
        notes = notes,
        tipeData = tipeData,
        lenghtData = lenghtData,
        prefix = prefix,
        suffix = suffix,

        nilaiString1 = nilaiString1,
        nilaiString2 = nilaiString2,
        nilaiBol1 = nilaiBol1,
        nilaiBol2 = nilaiBol2,
        nilaiInt1 = nilaiInt1,
        nilaiInt2 = nilaiInt2,
        nilaiDouble1 = nilaiDouble1,
        nilaiDouble2 = nilaiDouble2,

        nilaiDate1 = nilaiDate1,
        nilaiDate2 = nilaiDate2,
        nilaiTime1 = nilaiTime1,
        nilaiTime2 = nilaiTime2,

        fcompanyBean = fcompanyBean,
        fdivisionBean = fdivisionBean,

        created = created,
        modified = modified,
        modifiedBy = modifiedBy
    )
}
