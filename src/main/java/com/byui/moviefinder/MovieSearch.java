/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.byui.moviefinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grant
 */
@WebServlet(name = "MovieSearch", urlPatterns = {"/MovieSearch"})
public class MovieSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MovieSearch</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MovieSearch at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Movie> moviesList = new ArrayList<>();
        String movie = request.getParameter("movie");
        movie = URLEncoder.encode(movie, "UTF-8");
        String query = "http://www.omdbapi.com/?s=" + movie;

        URL queryURL = new URL(query);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = mapper.readValue(queryURL, Map.class);

        List list = (List) map.get("Search");

        for (Object item : list) {
            Map<String, Object> innerMap = (Map<String, Object>) item;

            String title = "";
            String imdbID = "";

            for (String key : innerMap.keySet()) {
                if (key.equals("Title")) {
                    title = (String)innerMap.get(key);
                    if (!title.equals("") && !imdbID.equals("")) {
                        moviesList.add(new Movie(title, imdbID));
                        break;
                    }
                } else if (key.equals("imdbID")) {
                    imdbID = (String)innerMap.get(key);
                    if (!title.equals("") && !imdbID.equals("")) {
                        moviesList.add(new Movie(title, imdbID));
                        break;
                    }
                }
//                if (key.equals("Title")) {
//                    movieTitles.add(new Movie((String) innerMap.get(key));
//                    break;
//                }
                //out.println(key + ": " + innerMap.get(key));
                //System.out.println(key + ": " + innerMap.get(key));
            }
        }

        request.setAttribute("moviesList", moviesList);
        request.getRequestDispatcher("movieList.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
