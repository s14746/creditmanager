import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/harmonogram")
public class HarmonogramServlet extends HttpServlet {

    Kalkulator kalkulator = new Kalkulator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Formularz formularz = new Formularz();
        formularz.kwotaKredytu = Double.parseDouble(req.getParameter("kwotaKredytu"));
        formularz.iloscRat = Integer.parseInt(req.getParameter("iloscRat"));
        formularz.oprocentowanie = Double.parseDouble(req.getParameter("oprocentowanie"));
        formularz.oplataStala = Double.parseDouble(req.getParameter("oplataStala"));
        formularz.typRaty = TypRaty.valueOf(req.getParameter("typRaty"));

        List<RataKredytu> ratyKredytu = kalkulator.calculate(formularz);
        req.setAttribute("ratyKredytu", ratyKredytu);
        req.getRequestDispatcher("/WEB-INF/harmonogram.jsp").forward(req, resp);
    }
}
