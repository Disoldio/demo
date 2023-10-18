package com.example.demo.service.extractor;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
public class PdfExtractor implements FileDataExtractor{

    @Override
    public String extract(InputStream inputStream) throws IOException {
        PDFTextStripper stripper = new PDFTextStripper();
        PDDocument document = Loader.loadPDF(inputStream.readAllBytes());

        String text = stripper.getText(document);
        return text;
    }
}
