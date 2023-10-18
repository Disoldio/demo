package com.example.demo.service.extractor;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DocXExtractor implements FileDataExtractor{

    @Override
    public String extract(InputStream inputStream) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);

        String fileData = extractor.getText();

        return fileData;
    }
}
