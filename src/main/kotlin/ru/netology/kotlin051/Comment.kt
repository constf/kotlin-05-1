package ru.netology.kotlin051

data class Comment(
    val id: Int,
    val fromId: Int,
    val postId: Int,
    val date: Int = System.currentTimeMillis().toInt(),
    var text: String? = null,
    val donut: VkDonut? = null,
    var replyToUser: Int? = null,
    var replyToComment: Int? = null,
    var attachments: Array<Attachment>? = null,
    var parentsStack: Array<Int>? = null,
    var thread: CommentThread? = null
)


data class VkDonut(
    val isDon: Boolean,
    val placeholder: String
)

data class CommentThread(
    var count: Int? = null,
    var items: Array<Comment>? = null,
    var canPost: Boolean? = null,
    var showReplyButton: Boolean? = null,
    var groupsCanPost: Boolean? = null
)