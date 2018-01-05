package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;

@RequestMapping("/CheckCode")
@Controller
public class CheckCodeController {
    private static final int CODE_WIDTH = 40;
    private static final int CODE_HEIGHT = 15;
    private static final int CODE_LENGTH = 4;

    @RequestMapping("/create")
    public void getCheckCode(HttpServletRequest request,HttpServletResponse response){
        String[] charList = {
                "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "y",
                "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "Y",
                "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuilder builder = new StringBuilder();
        BufferedImage bufferedImage = new BufferedImage(CODE_WIDTH, CODE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();

        for (int i = 0; i < CODE_LENGTH; i++) {
            String code = charList[(int) (Math.random() * charList.length)];
            builder.append(code);
            graphics.drawString(code, (int) (CODE_WIDTH * 0.1 + CODE_WIDTH * 0.9 * ((float)i/CODE_LENGTH)), (int) (CODE_HEIGHT * 0.75));
        }

        request.getSession().setAttribute("CheckCode", Base64.getEncoder().encodeToString(builder.toString().getBytes()));
        graphics.dispose();
        try {
            ImageIO.write(bufferedImage,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
