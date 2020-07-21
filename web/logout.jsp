<%
session.removeAttribute("usuario");
session.removeAttribute("cliente");

response.sendRedirect("index.jsp");
%>
