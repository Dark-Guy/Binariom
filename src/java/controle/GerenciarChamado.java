package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Chamado;
import modelo.Cliente;
import modelo.Equipamento;
import modelo.Usuario;

public class GerenciarChamado extends HttpServlet {

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
            out.println("<title>Servlet GerenciarChamado</title>");
            out.println("</head>");
            out.println("<body>");

            String op = request.getParameter("op");
            int bin = 0;
            String descricao = request.getParameter("descricao");
            String atendimento = request.getParameter("atendimento");
            String status = request.getParameter("status");
            String equipamento_etiqueta = request.getParameter("equipamento_etiqueta");
            String usuario_matricula = request.getParameter("usuario_matricula");
            String cliente_matricula = request.getParameter("cliente_matricula");

            try {
                if (op.equals("realizarTecnico") || op.equals("realizarAdmin") || op.equals("realizarTecnico")
                        || op.equals("cancelarTecnico") || op.equals("cancelarChefe") || op.equals("cancelarAdmin")
                        || op.equals("finalizarAdmin") || op.equals("finalizarTecnico") || op.equals("finalizarChefe")
                        || op.equals("aprovarAdmin") || op.equals("aprovarChefe") || op.equals("aprovarTecnico")) {
                    bin = Integer.parseInt(request.getParameter("bin"));
                }

                Chamado c = new Chamado();
                Usuario u = new Usuario();
                Cliente cl = new Cliente();
                Equipamento eq = new Equipamento();

                c.setBin(bin);
                c.setDescricao(descricao);
                c.setAtendimento(atendimento);
                eq.setEtiqueta(equipamento_etiqueta);
                c.setEquipamento(eq);
                c.setStatus(status);
                u.setMatricula(usuario_matricula);
                c.setUsuario(u);
                cl.setMatricula(cliente_matricula);
                c.setCliente(cl);

                switch (op) {
                    case "abrirCliente":
                        c.abrir();
                        response.sendRedirect("telaCliente.jsp");
                        break;

                    case "abrirAdmin":
                        c.abrir();
                        response.sendRedirect("telaAdmin_listaChamadosAbertos.jsp");
                        break;

                    case "abirTecnico":
                        c.abrir();
                        response.sendRedirect("telaTecnico_listaChamadosAbertos.jsp");
                        break;

                    case "abrirChefe":
                        c.abrir();
                        response.sendRedirect("telaChefe_listaChamadosAbertos.jsp");
                        break;

                    case "requisitarAdmin":
                        c.abrir();
                        response.sendRedirect("telaAdmin_listaRequisicoes.jsp");
                        break;

                    case "requisitarChefe":
                        c.abrir();
                        response.sendRedirect("telaChefe_listaRequisicoes.jsp");
                        break;

                    case "requisitarTecnico":
                        c.abrir();
                        response.sendRedirect("telaTecnico_listaRequisicoes.jsp");
                        break;

                    case "cancelarAdmin":
                        c.cancelar();
                        response.sendRedirect("telaAdmin_listaChamadosCancelados.jsp");
                        break;

                    case "cancelarChefe":
                        c.cancelar();
                        response.sendRedirect("telaChefe_listaChamadosCancelados.jsp");
                        break;

                    case "cancelarTecnico":
                        c.cancelar();
                        response.sendRedirect("telaTecnico_listaChamadosCancelados.jsp");
                        break;

                    case "realizarAdmin":
                        c.realizar();
                        response.sendRedirect("telaAdmin_listaChamadosEmAndamento.jsp");
                        break;

                    case "realizarChefe":
                        c.realizar();
                        response.sendRedirect("telaChefe_listaChamadosEmAndamento.jsp");
                        break;

                    case "realizarTecnico":
                        c.realizar();
                        response.sendRedirect("telaTecnico_listaChamadosEmAndamento.jsp");
                        break;

                    case "aprovarAdmin":
                        c.aprovar();
                        response.sendRedirect("telaAdmin_listaRequisicoes.jsp");
                        break;

                    case "aprovarChefe":
                        c.aprovar();
                        response.sendRedirect("telaChefe_listaRequisicoes.jsp");
                        break;

                    case "finalizarAdmin":
                        c.finalizar();
                        response.sendRedirect("telaAdmin_listaChamadosResolvidos.jsp");
                        break;

                    case "finalizarChefe":
                        c.finalizar();
                        response.sendRedirect("telaChefe_listaChamadosResolvidos.jsp");
                        break;

                    case "finalizarTecnico":
                        c.finalizar();
                        response.sendRedirect("telaTecnico_listaChamadosResolvidos.jsp");
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
