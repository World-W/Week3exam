package com.example.wangshjie20200309.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DimenTool {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        //添加xml开始的标签
        String xmlStart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n <resources>\n";
        builder.append(xmlStart);
        for (int i = 0; i < 300; i++) {
            String dimenName = "    <dimen name=\"dp" + i + "\">";
            String end = "dp</dimen>";
            builder.append(dimenName).append(i).append(end).append("\n");
        }
        //添加sp
        builder.append("\n\n\n<!--sp-->\n");
        for (int i = 0; i < 50; i++) {
            String dimenName = "    <dimen name=\"sp" + i + "\">";
            String end = "sp</dimen>";
            builder.append(dimenName).append(i).append(end).append("\n");
        }
        //添加xml的尾标签
        builder.append("</resources>");
        String dimensFile = "./app/src/main/res/values/dimens.xml";
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(dimensFile)));
            out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
