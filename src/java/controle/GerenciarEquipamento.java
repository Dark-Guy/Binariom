package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Equipamento;

public class GerenciarEquipamento extends HttpServlet {

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
            out.println("<title>Servlet GerenciarEquipamento</title>");
            out.println("</head>");
            out.println("<body>");

            String etiqueta = request.getParameter("etiqueta");
            String tipo = request.getParameter("tipo");
            String op = request.getParameter("op");

            try {
                if (op.equals("inserir")) {
                    if (tipo.isEmpty()) {
                        out.print("Descreva o tipo do equipamento");
                    } else if (etiqueta.isEmpty()) {
                        out.print("Informe a etiqueta");
                    }
                }
                Equipamento e = new Equipamento();
                e.setEtiqueta(etiqueta);
                e.setTipo(tipo);

                switch (op) {
                    case "inserirAdmin":
                        e.inserir();
                        response.sendRedirect("telaAdmin_listaEquipamentos.jsp");
                        break;

                    case "inserirChefe":
                        e.inserir();
                        response.sendRedirect("telaChefe_listaEquipamentos.jsp");
                        break;

                    case "inserirTecnico":
                        e.inserir();
                        response.sendRedirect("telaTecnico_listaEquipamentos.jsp");
                        break;

                    case "alterarAdmin":
                        e.alterar();
                        response.sendRedirect("telaAdmin_listaEquipamentos.jsp");
                        break;

                    case "alterarChefe":
                        e.alterar();
                        response.sendRedirect("telaChefe_listaEquipamentos.jsp");
                        break;

                    case "alterarTecnico":
                        e.alterar();
                        response.sendRedirect("telaTecnico_listaEquipamentos.jsp");
                        break;

                    case "excluirAdmin":
                        e.excluir();
                        response.sendRedirect("telaAdmin_listaEquipamentos.jsp");
                        break;

                    case "excluirChefe":
                        e.excluir();
                        response.sendRedirect("telaChefe_listaEquipamentos.jsp");
                        break;

                    case "excluirTecnico":
                        e.excluir();
                        response.sendRedirect("telaTecnico_listaEquipamentos.jsp");
                        break;
                }
            } catch (Exception x) {
                response.sendRedirect("pageError.jsp?erro="+x);
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
