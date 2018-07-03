package com.codegym.basic.formatted;


import com.codegym.basic.service.GroupEmployeeService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class GroupEmployeeFormatted implements Formatter {

    private GroupEmployeeService groupEmployeeService;
    public GroupEmployeeFormatted(GroupEmployeeService groupEmployeeService){
        this.groupEmployeeService = groupEmployeeService;
    }

    @Override
    public Object parse(String text, Locale locale) throws ParseException {
        return groupEmployeeService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Object object, Locale locale) {
        return null;
    }
}
