package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

data class ChapterData(
    val title: String,
    val days: String,
    val chapterNumber: Int
)

val artChapters: List<ChapterData> = listOf(
    ChapterData(title = "Primary Colours", days = "14", chapterNumber = 1),
    ChapterData(title = "Exploring Colours", days = "10", chapterNumber = 2),
    ChapterData(title = "Paint o fun", days = "11", chapterNumber = 3),
    ChapterData(title = "Printing", days = "10", chapterNumber = 4),
    ChapterData(title = "Collage", days = "04", chapterNumber = 5),
    ChapterData(title = "Magic Painting", days = "04", chapterNumber = 6),
    ChapterData(title = "Festivals", days = "04", chapterNumber = 7),
    ChapterData(title = "National Festivals", days = "04", chapterNumber = 8),
)

val generalAwarenessChapters: List<ChapterData> = listOf(
    ChapterData(title = "All About Me", days = "14", chapterNumber = 1),
    ChapterData(title = "My Face", days = "10", chapterNumber = 2),
    ChapterData(title = "Caring for yor Hair, Teeth....", days = "11", chapterNumber = 3),
    ChapterData(title = "Discovering My Body: Parts...", days = "10", chapterNumber = 4),
    ChapterData(title = "Handy Hands and Fantastic...", days = "04", chapterNumber = 5),
    ChapterData(title = "Dress up to shine", days = "04", chapterNumber = 6),
    ChapterData(title = "Colours and day Night...", days = "04", chapterNumber = 7),
    ChapterData(title = "Shapes", days = "04", chapterNumber = 8),
    ChapterData(title = "Animal world", days = "04", chapterNumber = 9),
    ChapterData(title = "Healthy Fruits and veggies", days = "04", chapterNumber = 10),
    ChapterData(title = "School", days = "04", chapterNumber = 11),
    ChapterData(title = "India, My Country", days = "04", chapterNumber = 12),
    )
