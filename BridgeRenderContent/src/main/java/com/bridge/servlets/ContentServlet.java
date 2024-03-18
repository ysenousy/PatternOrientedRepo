package com.bridge.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bridge.core.ArticleRenderer;
import com.bridge.core.ContentRenderer;
import com.bridge.core.HTMLRenderer;
import com.bridge.core.JSONRenderer;
import com.bridge.core.Renderer;
import com.bridge.core.TutorialRenderer;
import com.bridge.core.XMLRenderer;

/**
 * Servlet implementation class ContentServlet
 */
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String userContent = request.getParameter("content");
    	String contentType = request.getParameter("contentType");
        String format = request.getParameter("format");

        Renderer renderer;
        switch (format) {
	        case "json":
	            renderer = new JSONRenderer();
	            break;
	        case "xml":
	            renderer = new XMLRenderer();  
	            break;
	        default:
	            renderer = new HTMLRenderer();
    }

        ContentRenderer contentRenderer;
        if ("tutorial".equals(contentType)) {
            contentRenderer = new TutorialRenderer(renderer);
        } else {
            contentRenderer = new ArticleRenderer(renderer);
        }

        String renderedContent = contentRenderer.renderContent(userContent); // Use user content
        request.setAttribute("content", renderedContent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Display.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
