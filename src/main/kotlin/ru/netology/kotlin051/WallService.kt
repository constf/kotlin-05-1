package ru.netology.kotlin051

class WallService {
    private var postIdCounter: Int = 0
    var posts: Array<Post> = emptyArray<Post>()
    var comments: Array<Comment> = emptyArray<Comment>()


    fun add(post: Post): Post {
        val newPost: Post = post.copy(id = getNextPostId())
        posts += newPost

        return posts.last()
    }

    fun update(post: Post): Boolean {
        val id = post.id

        for ((index, currPost) in posts.withIndex()) {
            if (currPost.id == id) {
                val currDate = currPost.date
                val currOwnerId = currPost.ownerId
                posts[index] = post.copy(date = currDate, ownerId = currOwnerId)

                return true
            }
        }

        return false
    }


    fun createComment(comment: Comment) {
        val postId = comment.postId
        var foundPost: Boolean = false

        for ((index, currPost) in posts.withIndex()) {
            if (postId == currPost.id) {
                if (posts[index].comments == null)
                    posts[index].comments = Comments()

                comments += comment
                posts[index].comments?.count?.plus(1)
                foundPost = true
                break
            }
        }

        if ( !foundPost ) {
            throw PostNotFoundException("Пост с идентификатором $postId не найден.")
        }

    }


    private fun getNextPostId(): Int {
        return ++postIdCounter
    }

    internal fun clearData() {
        posts = emptyArray()
        comments = emptyArray()
        postIdCounter = 0
    }

}

