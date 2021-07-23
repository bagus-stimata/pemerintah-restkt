package com.erp.distribution.desgreenrestkt.domain.model.enum

enum class EnumStatusPengiriman(var intCode: Int, var strCode: String, var stringCodeLong: String, var description: String) {
    NOTA_OPEN(0, "O", "OPEN", "Open atau blum ada status"), NOTA_TERKIRIM(1, "T", "KIRIM", "Terkirim"), NOTA_PENDING(2, "P", "PENDING", "Pending Pengiriman/Belum Dikirim"), NOTA_BATAL(3, "B", "BATAL", "Nota Batal Seluruhnya ");

}