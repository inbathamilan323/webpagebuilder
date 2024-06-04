package com.example.webbuilder.controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.webbuilder.model.PageElement;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@WebServlet("/saveLayout")
public class PageBuilderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            if (reader != null) {
                reader.close(); // Ensure the reader is closed
            }
        }

        String json = sb.toString();
        Gson gson = new Gson();
        PageElement[] elements;

        try {
            elements = gson.fromJson(json, PageElement[].class);
        } catch (JsonSyntaxException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\": \"error\", \"message\": \"Invalid JSON\"}");
            return;
        }

        try (FileWriter writer = new FileWriter("layout.json")) {
            gson.toJson(elements, writer);
        } catch (IOException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\": \"error\", \"message\": \"Failed to save layout\"}");
            return;
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"status\": \"success\"}");
    }
}
	