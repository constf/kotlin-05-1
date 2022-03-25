package ru.netology.kotlin051

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        // Arrange
        val ws = WallService()
        ws.clearData()

        // Act
        val testPost = ws.add( Post(0, 123) )

        // Assert
        assertEquals(1, testPost.id)
    }

    @Test
    fun update_successful() {
        // Arrange
        val ws = WallService()
        ws.clearData()

        ws.add( Post(ownerId = 123) )
        ws.add( Post(ownerId = 124) )
        ws.add( Post(ownerId = 125) )

        var update = ws.add( Post(ownerId = 126) )
        update = update.copy(text = "Post text is edited and now is a new one.")

        // Act
        val result = ws.update(update)

        // Assert
        assertTrue(result)
    }

    @Test
    fun update_failed() {
        // Arrange
        val ws = WallService()
        ws.clearData()

        ws.add( Post(ownerId = 123) )
        ws.add( Post(ownerId = 124) )
        ws.add( Post(ownerId = 125) )

        var update = ws.add( Post(ownerId = 126) )
        update = update.copy(id = 5678, text = "Post text is edited and now is a new one.")

        // Act
        val result = ws.update(update)

        // Assert
        assertFalse(result)
    }

    @Test
    fun createComment_pass() {
        // Arrange
        val ws = WallService()
        ws.clearData()

        ws.add( Post(ownerId = 123) )
        ws.add( Post(ownerId = 124) )
        ws.add( Post(ownerId = 125) )

        val comment: Comment = Comment(1, 15, 2)

        // Act
        ws.createComment(comment)

        // Assert
        assertFalse(ws.comments.isEmpty())
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_fail() {
        // Arrange
        val ws = WallService()
        ws.clearData()

        ws.add( Post(ownerId = 123) )
        ws.add( Post(ownerId = 124) )
        ws.add( Post(ownerId = 125) )

        val comment: Comment = Comment(1, 15, 12)

        // Act
        ws.createComment(comment)

        // Assert
        // In @Test invocation
    }


}