package ru.netology.kotlin051

abstract class Attachment(val type: String)

class PhotoAttachment(val photo: Photo) : Attachment("photo")
class VideoAttachment(val video: Video) : Attachment("video")
class AudioAttachment(val audio: Audio) : Attachment("audio")
class GraffitiAttachment(val graffiti: Graffiti) : Attachment("graffiti")
class StickerAttachment(val sticker: Sticker) : Attachment("sticker")


class Photo(val id: Int, val albumId: Int, val ownerId: Int, val userId: Int){
    private var text: String? = null
    private var date: Int = System.currentTimeMillis().toInt()
    private var sizes: Array <PhotoSizes> = emptyArray()
    private var width: Int = 0
    private var height: Int = 0
}

data class PhotoSizes(
    val url: String,
    val wodth: Int,
    val height: Int,
    val type: String
)


class Video(val id: Int, val ownerId: Int, var title: String, val duration: Int){
    private var desription: String? = null
    private var image: Array<AlbumImage> = emptyArray()
    private var firstFrame: Array<FirstImage> = emptyArray()
    private var date: Int? = null
    private var addingDate: Int = System.currentTimeMillis().toInt()
    private var views: Int? = null
    private var localViews: Int? = null
    private var comments: Int? = null
    private var player: String? = null
    private var canAdd: Boolean? = null
    private var isPrivate: Int = 1
    private var accessKey: String? = null
    private var processing: Int = 1
    private var isFavourite: Boolean? = null
    private var canComment: Boolean? = null
    private var cnEdit: Boolean? = null
    private var canLike: Boolean? = null
    private var canRepost: Boolean? = null
    private var canSubscribe: Boolean? = null
    private var canAddToFavs: Boolean? = null
    private var canAttachLink: Boolean? = null
    private var width: Int = 0
    private var height: Int = 0
    private val userId: Int? = null
    private var converting: Boolean? = null
    private var added: Boolean? = null
    private var isSubscribed: Boolean? = null
    private var repeat: Int = 1
    private var type: String? = null
    private var balance: Int? = null
    private var liveStatus: String? = null
    private var live: Int = 1
    private var upcoming: Int? = null
    private var spectators: Int? = null
    private var likes: LikesVideo? = null
    private var reposts: RepostsVideo? = null
}

data class AlbumImage(
    val height: Int,
    val url: String,
    val width: Int,
    var widthPadding: Int = 1
)

data class FirstImage(
    val height: Int,
    val url: String,
    val width: Int,
)

data class LikesVideo(
    var count: Int,
    var userLikes: Int
)

data class RepostsVideo(
    var count: Int,
    var wallCount: Int,
    var mailCount: Int,
    var userReposted: Int
)

class Audio(val id: Int, val ownerId: Int, var artist: String, var title: String, val duration: Int){
    private var url: String? = null
    private var lyricsId: Int? = null
    private var albumId: Int? = null
    private var genreId: Int? = null
    private var date: Int = System.currentTimeMillis().toInt()
    private var noSearch: Int? = null
    private var isHq: Int? = null
}

class Graffiti(val id: Int, val ownerId: Int, val url: String){
    private var width: Int? = null
    private var height: Int? = null
}

class  Sticker(val productId: Int, val stickerId: Int){
    private var images: Array<ImagesSticker>? = null
    private var imagesWithBackground: Array<ImagesSticker>? = null
    private var animationUrl: String? = null
    private var isAllowed: Boolean? = null
}

data class ImagesSticker(
    var url: String,
    var width: Int,
    var height: Int
)


