package es.albarregas.controllers;

import es.albarregas.beans.Codigo;
import es.albarregas.dao.IProfesorDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.beans.Profesor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Paco
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/conclusion"})
public class Conclusion extends HttpServlet {

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
        DAOFactory daof = DAOFactory.getDAOFactory();
        IProfesorDAO pdao = daof.getProfesorDAO();

        Codigo codigo = new Codigo();
        Profesor profesor = new Profesor();
        String url = null;
        switch (request.getParameter("op")) {

            case "update":
                try {
                    //BeanUtils.populate(profesor, request.getParameterMap());
                    String codigoObtenido = request.getParameter("actualizarCodigo");
                    String[] parts = codigoObtenido.split("-");
                    String id = parts[0];
                    String tipo = parts[1];
                    codigo.setId(Integer.parseInt(id));
                    codigo.setTipo(Integer.parseInt(tipo));

                    profesor.setCodigo(codigo);
                    profesor.setNombre(request.getParameter("nombre"));
                    profesor.setApe1(request.getParameter("ape1"));
                    profesor.setApe2(request.getParameter("ape2"));
                    profesor.setEscala(request.getParameter("escala"));

                    //Se pasa a Date la fecha recibida y después se pasa a Calendar con el método setTime()
                    String s = request.getParameter("fecha");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    Date date = sdf.parse(s);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    profesor.setFecha(cal);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                pdao.update(profesor);
                url = "index.html";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
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
