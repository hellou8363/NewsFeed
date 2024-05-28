package com.noreabang.strawberryrabbit.domain.music.dto

import java.sql.Timestamp

data class MusicRequest (
    val singer: String,
    val title: String,
    val cover: String?
)