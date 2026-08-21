package com.example.data.mapper

import com.example.data.entity.TagEntity
import com.example.domain.model.Tag

fun Tag.toEntity(): TagEntity {
    return TagEntity(
        tagId = tagId,
        title = title,
        color = color
    )
}
fun TagEntity.toTagDomain(): Tag {
    return Tag(
        tagId = tagId?:0,
        title = title,
        color = color
    )
}