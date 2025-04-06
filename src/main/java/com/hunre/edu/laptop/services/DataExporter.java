package com.hunre.edu.laptop.services;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface DataExporter {
    void export(HttpServletResponse response) throws IOException;
}
