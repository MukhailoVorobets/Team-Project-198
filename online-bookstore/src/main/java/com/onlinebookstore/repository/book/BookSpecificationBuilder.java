package com.onlinebookstore.repository.book;

import com.onlinebookstore.dto.book.BookSearchParameters;
import com.onlinebookstore.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String ISBN = "isbn";
    private static final String CATEGORY = "category";
    private static final String GENRES = "genres";

    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.where((Specification<Book>) null);
        if (searchParameters.title() != null && searchParameters.title().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(TITLE)
                    .getSpecification(searchParameters.title()));
        }
        if (searchParameters.author() != null && searchParameters.author().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(AUTHOR)
                    .getSpecification(searchParameters.author()));
        }
        if (searchParameters.isbn() != null && searchParameters.isbn().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(ISBN)
                    .getSpecification(searchParameters.isbn()));
        }
        if (searchParameters.category() != null && searchParameters.category().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(CATEGORY)
                    .getSpecification(searchParameters.category()));
        }
        if (searchParameters.genre() != null && searchParameters.genre().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(GENRES)
                    .getSpecification(searchParameters.genre()));
        }
        return spec;
    }
}
