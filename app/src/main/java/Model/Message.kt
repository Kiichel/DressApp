package Model

import com.google.firebase.database.Exclude

class Message() {

    lateinit var textMessage: String
    lateinit var username: String
    lateinit var imageUrl: String


    constructor(_textMessage: String, _username: String, _imageUrl: String?) : this() {
        textMessage = _textMessage
        username = _username
        imageUrl = _imageUrl.toString()
    }

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "textMessage" to textMessage,
            "username" to username,
            "imageUrl" to imageUrl
        )
    }

//    fun getImageUrl(): String = imageUrl
//    fun getUsername(): String = username
//    fun getTextMessage(): String = textMessage


}