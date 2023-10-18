package com.example.demo.service.extractor;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;

@Component
public class RtfExtractor implements FileDataExtractor {

    @Override
    public String extract(InputStream inputStream) throws IOException, BadLocationException {
        JEditorPane pane = new JEditorPane();
        pane.setContentType("text/rtf");
        RTFEditorKit rtfKit = new RTFEditorKit();

        InputStreamReader i = new InputStreamReader(inputStream,"UTF-8");
        rtfKit.read(i, pane.getDocument(), 0);
        String st = pane.getDocument().getText(0, pane.getDocument().getLength());
        return st;
    }
}
