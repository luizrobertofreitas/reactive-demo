package com.lizo.reactivedemo.books

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("books")
data class Book(@Id val id: Long?, val title: String, val author: String, @CreatedBy val createdAt: LocalDateTime = LocalDateTime.now())