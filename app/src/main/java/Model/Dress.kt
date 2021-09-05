package Model

import com.google.firebase.database.Exclude

class Dress() {

    lateinit var dressName: String
    lateinit var dressImage: String
    lateinit var dressPrice: String


    constructor(_dressName: String, _dressPrise: String, _dressImage: String?) : this() {
        dressName = _dressName
        dressPrice = _dressPrise
        dressImage = _dressImage.toString()
    }




}