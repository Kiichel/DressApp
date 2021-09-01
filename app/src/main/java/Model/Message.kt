package Model

class Message(_textMessage: String, _username: String, _imageUrl: String?) {

    private var textMessage: String
    private var username: String
    private var imageUrl: String

    init {
        textMessage = _textMessage
        username = _username
        imageUrl = _imageUrl.toString()
    }


    fun getImageUrl(): String = imageUrl
    fun getUsername(): String = username
    fun getTextMessage(): String = textMessage


}