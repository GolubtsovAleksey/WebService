package com.example.webservice.service;

import java.util.List;

public interface FileWriterService {

    /**
     * метод для записи имён
     * @param name
     */
    void writeName(String name);

    /**
     * метод для записи уникальных имен
     * @param name
     */
    void writeUniqueName(String name);
}
