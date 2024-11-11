package com.teacherapplication.teacherapplication.ui.SubjectChapterList

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
