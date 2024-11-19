package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Clientes;
import services.ClientesService;
import services.ClientesServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/clientes.json", "/clienteshtml"})
public class ClientesJson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientesService service = new ClientesServiceImplement();
        List<Clientes> clientes = service.listar();

        String servletPath = req.getServletPath();
        boolean esJson = servletPath.endsWith(".json");

        if (esJson) {
            // Configurar la respuesta para descargar el archivo JSON
            resp.setContentType("application/json;charset=UTF-8");
            resp.setHeader("Content-Disposition", "attachment; filename=clientes.json");

            try (PrintWriter out = resp.getWriter()) {
                // Generar JSON formateado
                out.println("[");
                for (int i = 0; i < clientes.size(); i++) {
                    Clientes cliente = clientes.get(i);
                    out.println("  {");
                    out.println("    \"idCliente\": \"" + cliente.getIdClientes() + "\",");
                    out.println("    \"nombre\": \"" + cliente.getNombre() + "\",");
                    out.println("    \"apellido\": \"" + cliente.getApellido() + "\",");
                    out.println("    \"genero\": \"" + cliente.getGenero() + "\",");
                    out.println("    \"telefono\": \"" + cliente.getTelefono() + "\"");
                    out.print("  }");
                    if (i < clientes.size() - 1) {
                        out.println(",");
                    } else {
                        out.println();
                    }
                }
                out.println("]");
            }
        } else {
            // Generar HTML con tabla y enlace para descargar JSON
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"utf-8\">");
                out.println("<title>Listado Clientes</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Listado Clientes</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/clientes.json\">Descargar JSON</a></p>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>ID Cliente</th>");
                out.println("<th>Nombre</th>");
                out.println("<th>Apellido</th>");
                out.println("<th>Género</th>");
                out.println("<th>Teléfono</th>");
                out.println("</tr>");
                clientes.forEach(p -> {
                    out.println("<tr>");
                    out.println("<td>" + p.getIdClientes() + "</td>");
                    out.println("<td>" + p.getNombre() + "</td>");
                    out.println("<td>" + p.getApellido() + "</td>");
                    out.println("<td>" + p.getGenero() + "</td>");
                    out.println("<td>" + p.getTelefono() + "</td>");
                    out.println("</tr>");
                });
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}

