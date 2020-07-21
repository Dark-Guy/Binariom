package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estoque;

public class GerenciarEstoque extends HttpServlet {

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
            out.println("<title>Servlet GerenciarEstoque</title>");
            out.println("</head>");
            out.println("<body>");

            int id = 0;
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String op = request.getParameter("op");

            try {
                if (op.equals("alterar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                }
                if (op.equals("inserir")) {
                    if (nome.isEmpty()) {
                        out.print("Informe o nome do estoque!");
                    } else if (descricao.isEmpty()) {
                        out.print("Informe a descrição do estoque!");
                    }
                }
                Estoque es = new Estoque();
                es.setId(id);
                es.setNome(nome);
                es.setDescricao(descricao);

                switch (op) {
                    case "inserirAdmin":
                        es.inserir();
                        response.sendRedirect("telaAdmin_listaEstoques.jsp");
                        break;

                    case "inserirChefe":
                        es.inserir();
                        response.sendRedirect("telaChefe_listaEstoques.jsp");
                        break;

                    case "inserirTecnico":
                        es.inserir();
                        response.sendRedirect("telaTecnico_listaEstoques.jsp");
                        break;

                    case "alterarAdmin":
                        es.alterar();
                        response.sendRedirect("telaAdmin_listaEstoques.jsp");
                        break;

                    case "alterarChefe":
                        es.alterar();
                        response.sendRedirect("telaChefe_listaEstoques.jsp");
                        break;

                    case "alterarTecnico":
                        es.alterar();
                        response.sendRedirect("telaTecnico_listaEstoques.jsp");
                        break;
                }

            } catch (Exception e) {
                response.sendRedirect("pageError.jsp?erro=" + e);
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
