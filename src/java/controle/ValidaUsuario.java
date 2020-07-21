package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class ValidaUsuario extends HttpServlet {

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
            out.println("<title>Servlet ValidaLogin</title>");
            out.println("</head>");
            out.println("<body>");

            HttpSession session = request.getSession();
            try {
                String matricula = request.getParameter("matricula");
                String senha = request.getParameter("senha");

                if (matricula.isEmpty()) {
                    out.print("O campo Matricula deve ser preenchido!");
                } else if (senha.isEmpty()) {
                    out.print("O campo Senha deve ser preenchido!");
                } else {
                    UsuarioDAO uDAO = new UsuarioDAO();
                    //Chama o metodo logar
                    Usuario u = uDAO.logar(matricula, senha);
                    //Verifica se o ID que foi pego é maior que zero, caso seja
                    //significa que o usuario está logado
                    if (u.getPerfil().getId() == 1) {
                        //Seta o atributo usuario, assim se torna possivel recuperar tudo que há 
                        //no usuario pois o tipo dele é u
                        //Caso o id_perfil seja = 1 o perfil é de ADM
                        session.setAttribute("usuario", u);
                        response.sendRedirect("telaAdmin.jsp");
                        session.setMaxInactiveInterval(600);
                    } else if (u.getPerfil().getId() == 2) {
                        //Caso seja 2 = Chefe
                        session.setAttribute("usuario", u);
                        response.sendRedirect("telaChefe.jsp");
                        session.setMaxInactiveInterval(600);
                    } else {
                        //Caso seja 3 = Técnico
                        session.setAttribute("usuario", u);
                        response.sendRedirect("telaTecnico.jsp");
                        session.setMaxInactiveInterval(600);
                    }
                }
            } catch (Exception e) {
                response.sendRedirect("pageError.jsp?erro=Usuario e/ou senha invalidos!");
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
