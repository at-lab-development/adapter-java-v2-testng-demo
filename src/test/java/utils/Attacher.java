package utils;

import com.epam.testng.utils.JIRAAttachment;

import java.io.File;

public class Attacher {

    public void add(File file, String JIRATestKey, Class clazz) {
        JIRAAttachment.addAttachment(file, JIRATestKey);
    }
}
