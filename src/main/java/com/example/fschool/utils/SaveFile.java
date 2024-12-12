package com.example.fschool.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SaveFile {
    public static void saveFile(MultipartFile photo, String realPath) throws IOException {
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(realPath + File.separator + photo.getOriginalFilename());
        photo.transferTo(file);

    }

}
