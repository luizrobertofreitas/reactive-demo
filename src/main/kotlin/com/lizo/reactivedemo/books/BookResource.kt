package com.lizo.reactivedemo.books

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookResource(val bookRepository: BookRepository) {
    @GetMapping
    fun all() = bookRepository.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: Book) = bookRepository.save(book)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long) = bookRepository.findById(id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) = bookRepository.deleteById(id)

    @PutMapping
    fun update(@RequestBody book: Book) = bookRepository.save(book)
}