package com.example.demo.service;

import com.example.demo.domain.Resume;
import com.example.demo.service.extractor.FileDataExtractor;
import com.example.demo.service.filler.HhDataFiller;
import com.example.demo.storage.CVRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Service
public class CVService {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private FileDataExtractor docXExtractor;

    @Autowired
    private FileDataExtractor pdfExtractor;

    @Autowired
    private FileDataExtractor rtfExtractor;

    @Autowired
    private HhDataFiller hhDataFiller;

    public List<Resume> getAll(){

        return cvRepository.findAll();
    }

    public Resume getById(Integer id){
        Resume referenceById = cvRepository.getReferenceById(id);
        Object unproxy = Hibernate.unproxy(referenceById);

        return (Resume) unproxy;
    }

    public Resume create(MultipartFile multipartFile){
        String extract = null;

        try {
            InputStream inputStream = multipartFile.getInputStream();
            String originalFilename = multipartFile.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf(".")+1);;


            switch (extension){
                case "pdf":
                    extract = pdfExtractor.extract(inputStream);
                    break;
                case "docx":
                    extract = docXExtractor.extract(inputStream);
                    break;
                case "rtf":
                case "doc":
                    extract = rtfExtractor.extract(inputStream);
                    break;
            }
            log.info(extract);
        } catch (IOException | BadLocationException e) {
            throw new RuntimeException(e);
        }

        Resume resume = hhDataFiller.fillData(extract);

        return cvRepository.save(resume);
    }

}
