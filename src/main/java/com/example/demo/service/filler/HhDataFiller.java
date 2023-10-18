package com.example.demo.service.filler;

import com.example.demo.domain.Resume;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HhDataFiller implements DataFiller {

    @Override
    public Resume fillData(String text) {
        Resume res = new Resume();

        String[] boba = {"Желаемая должность и зарплата", "Опыт работы", "Образование", "Ключевые навыки", "Дополнительная информация", "История общения с кандидатом", "Портфолио"};
        List<String> chel = new ArrayList<String>();
        //5
        List<String> obChel = new ArrayList<String>();

        for(int i = 0; i < boba.length; i++){
            if(text.indexOf(boba[i]) != -1){
                chel.add(boba[i]);
            }
        }

        for(int i = 0; i < chel.size(); i++){

            if(i != chel.size()-1){
                obChel.add(text.substring(text.indexOf(chel.get(i)), text.indexOf(chel.get(i+1))));
            }else{
                obChel.add(text.substring(text.indexOf(chel.get(i)), text.length()));
            }
        }

        res.setGeneralInfo(text.substring(0, text.indexOf("Желаемая должность и зарплата")));

        for(int i = 0; i < obChel.size(); i++){
            if(obChel.get(i).indexOf("Желаемая должность и зарплата") != -1){
                res.setSpec(obChel.get(i));
            }
            if(obChel.get(i).indexOf("Опыт работы") != -1){
                res.setExperience(obChel.get(i));
            }
            if(obChel.get(i).indexOf("Образование") != -1){
                res.setEducation(obChel.get(i));
            }
            if(obChel.get(i).indexOf("Ключевые навыки") != -1){
                res.setSkills(obChel.get(i));
            }
            if(obChel.get(i).indexOf("Дополнительная информация") != -1){
                res.setAbout(obChel.get(i));
            }
            if(obChel.get(i).indexOf("Портфолио") != -1){
                String portfolio = obChel.get(i);
            }
        }

        return res;
    }
}
