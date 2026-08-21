package com.example.domain.usecases.tag

import com.example.domain.model.Tag
import com.example.domain.repository.TagRepository
import javax.inject.Inject

class CreateTag @Inject constructor(
    private val tagRepository: TagRepository
){
    suspend operator fun invoke(tag: Tag){
        tagRepository.createTag(tag)
    }
}
