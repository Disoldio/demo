package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SupportedType {

    PDF("pdf"),
    DOCX("docx"),
    DOC("doc"),
    RTF("rtf");

    private final String extension;

    public static SupportedType getByString(String extension) throws IllegalArgumentException {
        SupportedType[] values = SupportedType.values();
        for (SupportedType value : values) {
            if (value.extension.equals(extension)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Extension " + extension + " is not supported");
    }
}
