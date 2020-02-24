package com.efox.tutorial.notification;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SSEServlet
 */
@WebServlet("/notification")
public class SSEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSEServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = null;
		while(true) {
			try {
				long sleepSec =2;
				printWriter = response.getWriter();
				printWriter.print("data: "+"[next server time check event in "+sleepSec+" seconds]\n");
				printWriter.print("data: "+"Time: "+ Calendar.getInstance().getTime()+"\n\n");
				response.flushBuffer();
				Thread.sleep(sleepSec*1000);
			} catch (IOException | InterruptedException e) {
				printWriter.close();
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
