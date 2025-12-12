package com.onlinebookstore.repository.book;

import org.springframework.stereotype.Component;

@Component
public interface SpecificationProviderManager<T> {
    SpecificationProvider<T> getSpecificationProvider(String key);
}
