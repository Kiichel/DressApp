package Model

import com.google.firebase.database.Exclude

class Dress() {

    lateinit var dressName: String
    lateinit var dressImage: String
    lateinit var dressPrice: String


    constructor(_dressName: String, _dressPrice: String, _dressImage: String?) : this() {
        dressName = _dressName
        dressPrice = _dressPrice
        dressImage = _dressImage.toString()
    }

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "dressName" to dressName,
            "dressImage" to dressImage,
            "dressPrice" to dressPrice
        )
    }
}