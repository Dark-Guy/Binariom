package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Perfil;
import modelo.Usuario;

public class GerenciarUsuario extends HttpServlet {

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
            out.println("<title>Servlet GerenciarUsuario</title>");
            out.println("</head>");
            out.println("<body>");

            String matricula = request.getParameter("matricula");
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            String cpf = request.getParameter("cpf");
            String setor = request.getParameter("setor");
            String telefone = request.getParameter("telefone");
            String status = request.getParameter("status");
            String id_perfil = request.getParameter("id_perfil");
            String op = request.getParameter("op");

            try {
                if (op.equals("inserir")) {
                    if (matricula.isEmpty()) {
                        out.print("Informe a matricula do equipamento");
                    } else if (nome.isEmpty()) {
                        out.print("Informe o nome do usuario!");
                    } else if (senha.isEmpty()) {
                        out.print("Informe a senha!");
                    } else if (cpf.isEmpty()) {
                        out.print("Informe o cpf!");
                    } else if (setor.isEmpty()) {
                        out.print("Informe o setor!");
                    } else if (status.isEmpty()) {
                        out.print("Informe o status!");
                    } else if (id_perfil.isEmpty()) {
                        out.print("Informe o perfil!");
                    }
                }
                Usuario u = new Usuario();
                Perfil p = new Perfil();

                u.setMatricula(matricula);
                u.setNome(nome);
                u.setSenha(senha);
                u.setStatus(status);
                u.setSetor(setor);
                u.setCpf(cpf);
                u.setTelefone(telefone);
                if (op.equals("inserirAdmin") || op.equals("inserirChefe") 
                        || op.equals("alterarChefe") || op.equals("alterarAdmin")) {
                    p.setId(Integer.parseInt(id_perfil));
                    u.setPerfil(p);
                }

                switch (op) {
                    case "inserirAdmin":
                        u.inserir();
                        response.sendRedirect("telaAdmin_listaUsuarios.jsp");
                        break;

                    case "inserirChefe":
                        u.inserir();
                        response.sendRedirect("telaChefe_listaUsuarios.jsp");
                        break;

                    case "alterarAdmin":
                        u.alterar();
                        response.sendRedirect("telaAdmin_listaUsuarios.jsp");
                        break;

                    case "alterarChefe":
                        u.alterar();
                        response.sendRedirect("telaChefe_listaUsuarios.jsp");
                        break;

                    //Fazer os dois cases    
                    /*case "excluir":*/
                    case "excluirAdmin":
                        u.excluir();
                        response.sendRedirect("telaAdmin_listaUsuarios.jsp");
                        break;

                    case "excluirChefe":
                        u.excluir();
                        response.sendRedirect("telaChefe_listaUsuarios.jsp");
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
