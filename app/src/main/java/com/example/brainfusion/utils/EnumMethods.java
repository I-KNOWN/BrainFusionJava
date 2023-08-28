package com.example.brainfusion.utils;

import static com.example.brainfusion.enums.AIStyle.*;
import static com.example.brainfusion.enums.Resolution.*;

import com.example.brainfusion.enums.AIStyle;
import com.example.brainfusion.enums.Resolution;

public class EnumMethods {

    public String getStyle(AIStyle aiStyle){
        switch (aiStyle) {
            case noStyle:
                return "DEFAULT";
            case anime:
                return "ANIME";
            case moreDetails:
                return "UHD";
            case cyberPunk:
                return "CYBERPUNK";
            case kandinskyPainter:
                return "KANDINSKY";
            case aivazovskyPainter:
                return "AIVAZOVSKY";
            case malevichPainter:
                return "MALEVICH";
            case picassoPainter:
                return "PICASSO";
            case goncharovaPainter:
                return "GONCHAROVA";
            case classicism:
                return "CLASSICISM";
            case renaissance:
                return "RENAISSANCE";
            case oilPainting:
                return "OILPAINTING";
            case pencilDrawing:
                return "PENCILDRAWING";
            case digitalPainting:
                return "DIGITALPAINTING";
            case medievalStyle:
                return "MEDIEVALPAINTING";
            case render3D:
                return "RENDER";
            case cartoon:
                return "CARTOON";
            case studioPhoto:
                return "STUDIOPHOTO";
            case portraitPhoto:
                return "PORTRAITPHOTO";
            case khokhlomaPainter:
                return "KHOKHLOMA";
            case christmas:
                return "CRISTMAS";
            case sovietCartoon:
                return "SOVIETCARTOON";
            default:
                return "DEFAULT";
        }
    }

    public String[] getResolution(Resolution resolution){
        switch (resolution) {
            case r1x1:
                return new String[]{"1024", "1024"};
            case r2x3:
                return new String[]{"680", "1024"};
            case r3x2:
                return new String[]{"1024", "680"};
            case r9x16:
                return new String[]{"576", "1024"};
            case r16x9:
                return new String[]{"1024", "576"};
            default:
                return new String[]{"1024", "1024"};
        }
    }

}
