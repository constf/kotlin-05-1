package ru.netology.kotlin051

object WallService {
    var posts: Array<Post> = emptyArray<Post>()

    fun add(post: Post): Post {
        val newPost: Post = post.copy(id = getNextId())
        posts += newPost

        return posts.last()
    }

    fun update(post: Post): Boolean {
        val id = post.id

        for( (index, currPost) in posts.withIndex() ){
            if(currPost.id == id){
                val currDate = currPost.date
                val currOwnerId = currPost.ownerId
                posts[index] = post.copy(date = currDate, ownerId = currOwnerId)

                return true
            }
        }

        return false
    }

    private var idCounter: Int = 0

    private fun getNextId(): Int {
        return ++idCounter
    }
}

