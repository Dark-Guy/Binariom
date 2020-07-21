package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

public class GerenciarCliente extends HttpServlet {

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
            out.println("<title>Servlet GerenciarCliente</title>");
            out.println("</head>");
            out.println("<body>");

            String matricula = request.getParameter("matricula");
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String setor = request.getParameter("setor");
            String telefone = request.getParameter("telefone");
            String senha = request.getParameter("senha");
            String status = request.getParameter("status");
            String sala = request.getParameter("sala");
            String op = request.getParameter("op");

            try {

                Cliente c = new Cliente();

                if (op.equals("inserir")) {
                    if (matricula.isEmpty()) {
                        out.print("Preencha o campo matricula!");
                    } else if (nome.isEmpty()) {
                        out.print("Preencha o campo nome!");
                    } else if (cpf.isEmpty()) {
                        out.print("Preencha o campo cpf!");
                    } else if (setor.isEmpty()) {
                        out.print("Preencha o campo setor!");
                    } else if (telefone.isEmpty()) {
                        out.print("Preencha o campo telefone!");
                    } else if (senha.isEmpty()) {
                        out.print("Preencha o campo senha!");
                    } else if (status.isEmpty()) {
                        out.print("Preencha o campo status!");
                    } else if (sala.isEmpty()) {
                        out.print("Preencha o campo sala!");
                    }
                }

                c.setMatricula(matricula);
                c.setNome(nome);
                c.setSetor(setor);
                c.setSenha(senha);
                c.setStatus(status);
                c.setCpf(cpf);
                c.setTelefone(telefone);
                if (op.equals("inserirAdmin") || op.equals("inserirChefe")
                        || op.equals("alterarChefe") || op.equals("alterarAdmin")) {
                    c.setSala(Integer.parseInt(sala));
                    c.setSala(Integer.parseInt(sala));
                }

                switch (op) {
                    case "inserirAdmin":
                        c.inserir();
                        response.sendRedirect("telaAdmin_listaClientes.jsp");
                        break;

                    case "inserirChefe":
                        c.inserir();
                        response.sendRedirect("telaChefe_listaClientes.jsp");
                        break;

                    case "alterarAdmin":
                        c.alterar();
                        response.sendRedirect("telaAdmin_listaClientes.jsp");
                        break;

                    case "alterarChefe":
                        c.alterar();
                        response.sendRedirect("telaChefe_listaClientes.jsp");
                        break;

                    case "excluirAdmin":
                        c.excluir();
                        response.sendRedirect("telaAdmin_listaClientes.jsp");
                        break;

                    case "excluirChefe":
                        c.excluir();
                        response.sendRedirect("telaChefe_listaClientes.jsp");
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
