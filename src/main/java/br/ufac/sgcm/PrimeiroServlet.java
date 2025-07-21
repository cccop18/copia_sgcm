package br.ufac.sgcm;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class PrimeiroServlet extends HttpServlet {
    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        PrintWriter saida = res.getWriter();
        saida.print("<html>");
        saida.print("<body>");
        saida.print("<h1>Web Academy</h1>");
        saida.print("<p>Teste</p>");
        saida.print("</body>");
        saida.print("</html>");
    }
}
