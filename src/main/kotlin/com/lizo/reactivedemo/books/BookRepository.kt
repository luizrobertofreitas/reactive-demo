package com.lizo.reactivedemo.books

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface BookRepository: ReactiveCrudRepository<Book, Long> {}