package ru.netology.kotlin051

import org.junit.After
import org.junit.Test

import org.junit.Assert.*

class NotesTest {

    @Test
    fun add() {
        //Arrange
        val nt = Notes()
        nt.clearData()

        // Act
        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")

        // Asserting
        assertEquals(3, nt.getNumberOfNotes())
    }

    @Test
    fun createComment() {
        //Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")

        // Act
        val comment1 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment2 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment3 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")
        val comment4 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")

        // Assert
        assertEquals(4, nt.getNumberOfComments())
    }

    @Test
    fun delete() {
        //Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")

        val comment1 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment2 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment3 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")
        val comment4 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")

        // Act
        nt.delete(note1.toUInt())
        nt.delete(note3.toUInt())

        // Asserting
        assertEquals(1, nt.getNumberOfNotes())
        assertEquals(2, nt.getNumberOfComments())
    }

    @Test
    fun edit() {
        //Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")


        //Act
        val res = nt.edit(note2.toUInt(), "Edited second note", "With the note's text updated after editing...")

        //Assert
        assertEquals(1, res)
    }

    @Test
    fun deleteComment() {
        // Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")

        val comment1 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment2 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment3 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")
        val comment4 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")

        // Act
        val res = nt.deleteComment(comment3.toUInt())

        // Assert
        assertEquals(1, res)
        assertEquals(3, nt.getNumberOfComments())
    }

    @Test
    fun editComment() {
        // Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")

        val comment1 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment2 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "***")
        val comment3 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")
        val comment4 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "***")

        // Act
        val res = nt.editComment(comment3.toUInt(), "New contents of the 3rd comment.")

        // Assert
        assertEquals(1, res)
    }

    @Test
    fun get() {
        // Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")
        val note4 = nt.add("Fourth note", "The fourth note is created. Testing it now. Working?")

        val nIds = "$note2,$note3"

        // Act
        val notes = nt.get(nIds, 0U, 0U, 0U)

        // Assert
        assertEquals(2, notes?.size)
    }

    @Test
    fun getById() {
        // Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")
        val note4 = nt.add("Fourth note", "The fourth note is created. Testing it now. Working?")

        // Act
        val note = nt.getById(note4.toUInt())

        // Assert
        assertEquals(note4, note?.id)
    }

    @Test
    fun getComments() {
        // Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")

        val comment1 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "**1")
        val comment2 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "**2")
        val comment3 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "**3")
        val comment4 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "**4")
        val comment5 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "**5")

        // Act
        val res1 = nt.getComments(noteId = note3.toUInt())
        val res2 = nt.getComments(noteId = note3.toUInt(), offset = 1U, count = 2U)

        // Assert
        assertEquals(3, res1.size)
        assertEquals(2, res2.size)
    }

    @Test
    fun restoreComment() {
        // Arrange
        val nt = Notes()
        nt.clearData()

        val note1 = nt.add("First note", "The first note is created. Testing it now. Working?")
        val note2 = nt.add("Second note", "The second note is created. Testing it now. Working?")
        val note3 = nt.add("Third note", "The third note is created. Testing it now. Working?")

        val comment1 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "**1")
        val comment2 = nt.createComment(note2.toUInt(), 0U, "Wow, great note $note2", "**2")
        val comment3 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "**3")
        val comment4 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "**4")
        val comment5 = nt.createComment(note3.toUInt(), 0U, "Wow, great note $note3", "**5")

        // Act
        val res1 = nt.deleteComment(comment3.toUInt())
        val res2 = nt.restoreComment(comment3.toUInt())

        // Assert
        assertEquals(1, res2)
        assertEquals(5, nt.getNumberOfComments())
    }
}