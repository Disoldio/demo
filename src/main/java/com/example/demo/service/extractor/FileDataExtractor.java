package com.example.demo.service.extractor;

import javax.swing.text.BadLocationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface FileDataExtractor {
    String extract(InputStream inputStream) throws IOException, BadLocationException;
}
