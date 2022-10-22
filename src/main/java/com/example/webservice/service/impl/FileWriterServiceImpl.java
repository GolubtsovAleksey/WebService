package com.example.webservice.service.impl;

import com.example.webservice.service.FileWriterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
     *
     * @return
     */
    private List<String> getAllNames() {

        List<String> listNames = new ArrayList<>();

        File readWritingName = new File("writingName");
        Scanner scanner = null;

        try {
            scanner = new Scanner(readWritingName);
        } catch (FileNotFoundException e) {
            System.out.println("invalid file name or file path");
        }
        while (scanner.hasNext()) {
            listNames.add(scanner.nextLine());
        }
        scanner.close();
        return listNames;
    }

    @Override
    public void writeUniqueName(String name) {

        for (String nameFromFile: getAllNames()){
            if (nameFromFile.equals(name) == false ) {
                writeName(name);
                System.out.println("write a unique name");
            } else {
                System.out.println("this name is already in the file");
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj );
    }
}
