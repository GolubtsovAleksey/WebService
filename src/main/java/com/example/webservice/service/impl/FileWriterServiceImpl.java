package com.example.webservice.service.impl;

import com.example.webservice.service.FileWriterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class FileWriterServiceImpl implements FileWriterService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public void writeName(String name) {

        logger.info("write to a file of the given name ");
        File myFile = new File("writingName");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
            writer.println(name);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    /**
     * метод для получения всех имен из файла
     * @return
     */
    private List<String> getAllNames() {
        return null;
    }

    @Override
    public void writeUniqueName(String name) {

    }
}
