package servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PurchaseServlet extends HttpServlet {
    private boolean requestValid = true;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (requestValid){
            response.setStatus(200);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            JSONObject jsonString = new JSONObject();
            String responseMessage = jsonString.put("message", "Valid request!").toString();
            out.println(responseMessage);
        }
    }
}
