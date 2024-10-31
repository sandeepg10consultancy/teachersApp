package com.teacherapplication.teacherapplication

data class LessonsData(
    val title: String,
    val time: String
)

val lessonPlans = listOf(
    "Adheeti (Introduction)" to "15 mins",
    "Bodh (Conceptual Understanding)" to "10 mins",
    "Abhyas (Practice)" to "5 mins",
    "Prayog (Application)" to "20 mins",
    "Prasaar (Expansion)" to "10 mins",
).map { LessonsData(it.first, it.second) }
