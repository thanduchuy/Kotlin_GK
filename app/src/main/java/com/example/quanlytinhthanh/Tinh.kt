package com.example.quanlytinhthanh

import android.net.Uri

data class Tinh(
    var id: Int,
    var name: String,
    var image: Uri,
    var population: Int,
    var description: String
)

object Supplier {
    var data = arrayListOf<Tinh>(
        Tinh(
            1,
            "Da Nang",
            Uri.parse("android.resource://com.example.quanlytinhthanh/" + R.drawable.danang),
            5,
            "Thanh pho dang song"
        ),
        Tinh(
            2,
            "Quang Nam",
            Uri.parse("android.resource://com.example.quanlytinhthanh/" + R.drawable.danang),
            5,
            "Thanh pho dang song"
        ),
        Tinh(
            3,
            "Quang Ngai",
            Uri.parse("android.resource://com.example.quanlytinhthanh/" + R.drawable.danang),
            5,
            "Thanh pho dang song"
        ),
        Tinh(
            4,
            "Gia Lai",
            Uri.parse("android.resource://com.example.quanlytinhthanh/" + R.drawable.danang),
            5,
            "Thanh pho dang song"
        )
    )
}
