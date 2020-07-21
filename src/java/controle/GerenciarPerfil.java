/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Perfil;

/**
 *
 * @author Antônio Carlos
 */
public class GerenciarPerfil extends HttpServlet {

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
            out.println("<title>Servlet GerenciarPerfil</title>");
            out.println("</head>");
            out.println("<body>");

            String op = request.getParameter("op");
            int id = 0;
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            try {
                if (op.equals("excluir") || op.equals("alterar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                }

                if (op.equals("inserir")) {
                    if (nome.isEmpty()) {
                        out.print("Preencha o campo nome");
                    } else if (descricao.isEmpty()) {
                        out.print("Preencha o campo descrição");
                    }
                }
                Perfil p = new Perfil();
                p.setId(id);
                p.setNome(nome);
                p.setDescricao(descricao);

                switch (op) {
                    case "inserir":
                        p.inserir();
                        break;

                    case "alterar":
                        p.alterar();
                        break;

                    case "excluir":
                        p.excluir();
                        break;
                }

                response.sendRedirect("telaAdmin_listaPerfis.jsp");
            } catch (Exception e) {
                response.sendRedirect("pageError.jsp?erro="+e);
            }
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
        processRequest(request, response);
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
