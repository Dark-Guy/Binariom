package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Componente;
import modelo.Equipamento;
import modelo.Estoque;

public class GerenciarComponente extends HttpServlet {

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
            out.println("<title>Servlet GerenciarComponente</title>");
            out.println("</head>");
            out.println("<body>");

            String id = request.getParameter("id");
            String modelo = request.getParameter("modelo");
            String tipo = request.getParameter("tipo");
            String marca = request.getParameter("marca");
            String descricao = request.getParameter("descricao");
            String status = request.getParameter("status");
            String id_estoque = request.getParameter("id_estoque");
            String equipamento_etiqueta = request.getParameter("equipamento_etiqueta");
            //Nome do Estoque
            String nome = request.getParameter("nome");
            String op = request.getParameter("op");

            try {
                Componente c = new Componente();
                Estoque es = new Estoque();
                Equipamento eq = new Equipamento();

                c.setId(id);
                c.setModelo(modelo);
                c.setTipo(tipo);
                c.setMarca(marca);
                c.setDescricao(descricao);
                c.setStatus(status);
                eq.setEtiqueta(equipamento_etiqueta);
                c.setEquipamento(eq);
                if (op.equals("inserirAdmin") || op.equals("inserirChefe")
                        || op.equals("inserirTecnico") || op.equals("alterarChefe")
                        || op.equals("alterarAdmin") || op.equals("alterarTecnico")) {
                    es.setId(Integer.parseInt(id_estoque));
                    c.setEstoque(es);
                }

                switch (op) {
                    case "inserirAdmin":
                        c.inserir();
                        response.sendRedirect("telaAdmin_listaEstoques.jsp");
                        break;

                    case "inserirChefe":
                        c.inserir();
                        response.sendRedirect("telaChefe_listaEstoques.jsp");
                        break;

                    case "inserirTecnico":
                        c.inserir();
                        response.sendRedirect("telaTecnico_listaEstoques.jsp");
                        break;

                    case "alterarAdmin":
                        c.alterar();
                        response.sendRedirect("telaAdmin_detalharComponente.jsp?id=" + id);
                        break;

                    case "alterarChefe":
                        c.alterar();
                        response.sendRedirect("telaChefe_detalharComponente.jsp?id=" + id);
                        break;

                    case "alterarTecnico":
                        c.alterar();
                        response.sendRedirect("telaTecnico_detalharComponente.jsp?id=" + id);
                        break;

                    case "removerAdmin":
                        c.remover();
                        response.sendRedirect("telaAdmin_checarEstoque.jsp?id=" + id_estoque + "&nome=" + nome);
                        break;

                    case "removerChefe":
                        c.remover();
                        response.sendRedirect("telaChefe_checarEstoque.jsp?id=" + id_estoque + "&nome=" + nome);
                        break;

                    case "removerTecnico":
                        c.remover();
                        response.sendRedirect("telaTecnico_checarEstoque.jsp?id=" + id_estoque + "&nome=" + nome);
                        break;
                }

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
