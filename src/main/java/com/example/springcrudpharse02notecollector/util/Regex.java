package com.example.springcrudpharse02notecollector.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static Matcher userIdValidate(String userId){
        return Pattern.compile("^USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$").matcher(userId);
    }

    public static Matcher noteIdValidate(String noteId){
        return Pattern.compile("^NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$").matcher(noteId);
    }
}
