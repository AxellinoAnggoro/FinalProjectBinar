package com.example.finalproject.model.passenger

data class Penumpang(
    var penumpang : String
)

data class PenumpangPost(
    var name: String,
    var born_date: String,
    var citizen: String,
    var identity_number: String,
    var publisher_country: String,
)

data class PenumpangRequest(
    var ticketsId:String,
    var passengers:List<PenumpangPost>,
    var total_passenger:Int
)
