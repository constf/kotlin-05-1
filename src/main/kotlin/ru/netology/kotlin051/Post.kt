package ru.netology.kotlin051

import java.util.*

data class Post(
    val id:Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    var text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    var comments: Comments,
    var copyright: Copyright,
    var likes: Likes,
    var reposts: Reposts,
    var views: Views,
    var postType: PostType,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    var isPinned: Boolean,
    var markedAsAds: Boolean,
    var isFavorite: Boolean,
    var donut: Donut,
    var postponedId: Int
)

data class Comments(
    var count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)


data class Likes(
    var count: Int,
    var userLikes: Boolean,
    var canLike: Boolean,
    var canPublish: Boolean
)


data class Reposts(
    var count: Int,
    var userReposted: Boolean
)

data class Views(
    var count: Int
)

enum class PostType {post, copy, reply, postpone, suggest}

data class Donut(
    var isDonut: Boolean,
    var paidDuration: Int,
    var placeholder: String,
    var canPublishFreeCopy: Boolean,
    var editMode: DonutEditMode
)

enum class DonutEditMode {all, duration}