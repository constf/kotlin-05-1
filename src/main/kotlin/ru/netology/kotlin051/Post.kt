package ru.netology.kotlin051

import java.util.*

data class Post(
    val id:Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = System.currentTimeMillis().toInt(),
    var text: String = "Enter your post here...",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    var comments: Comments = Comments(),
    var copyright: Copyright = Copyright(),
    var likes: Likes = Likes(),
    var reposts: Reposts = Reposts(),
    var views: Views = Views(),
    var postType: PostType = PostType.post,
    val signerId: Int = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    var isPinned: Boolean = true,
    var markedAsAds: Boolean = false,
    var isFavorite: Boolean = false,
    var donut: Donut = Donut(),
    var postponedId: Int = 0
)

data class Comments(
    var count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Copyright(
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = ""
)


data class Likes(
    var count: Int = 0,
    var userLikes: Boolean = true,
    var canLike: Boolean = true,
    var canPublish: Boolean = true
)


data class Reposts(
    var count: Int = 0,
    var userReposted: Boolean = true
)

data class Views(
    var count: Int = 0
)

enum class PostType {post, copy, reply, postpone, suggest}

data class Donut(
    var isDonut: Boolean = false,
    var paidDuration: Int = 0,
    var placeholder: String = "",
    var canPublishFreeCopy: Boolean = true,
    var editMode: DonutEditMode = DonutEditMode.all
)

enum class DonutEditMode {all, duration}