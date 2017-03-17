package pl.pjwstk.creditcalculator.web;

import pl.pjwstk.creditcalculator.core.Formularz;
import pl.pjwstk.creditcalculator.core.Kalkulator;
import pl.pjwstk.creditcalculator.core.RataKredytu;
import pl.pjwstk.creditcalculator.core.TypRaty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/harmonogram")
public class HarmonogramServlet extends HttpServlet {

    private final Kalkulator kalkulator = new Kalkulator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Formularz formularz = new Formularz(
                Double.parseDouble(req.getParameter("kwotaKredytu")),
                Integer.parseInt(req.getParameter("iloscRat")),
                Double.parseDouble(req.getParameter("oprocentowanie")),
                Double.parseDouble(req.getParameter("oplataStala")),
                TypRaty.valueOf(req.getParameter("typRaty"))
        );

        List<Rata> raty = kalkulator.calculate(formularz).stream()
                .map(Rata::new)
                .collect(Collectors.toList());

        req.setAttribute("raty", raty);
        req.getRequestDispatcher("/WEB-INF/harmonogram.jsp").forward(req, resp);
    }

    public static class Rata {
        private static final NumberFormat formatter = new DecimalFormat("#0.00");

        private final String numerRaty;
        private final String kwotaKapitalu;
        private final String kwotaOdsetek;
        private final String oplatyStale;
        private final String calkowitaKwotaRaty;

        public Rata(RataKredytu rataKredytu) {
            numerRaty = String.valueOf(rataKredytu.getNumerRaty());
            kwotaKapitalu = formatter.format(rataKredytu.getKwotaKapitalu());
            kwotaOdsetek = formatter.format(rataKredytu.getKwotaOdsetek());
            oplatyStale = formatter.format(rataKredytu.getOplatyStale());
            calkowitaKwotaRaty = formatter.format(rataKredytu.getCalkowitaKwotaRaty());
        }

        public String getNumerRaty() {
            return numerRaty;
        }

        public String getKwotaKapitalu() {
            return kwotaKapitalu;
        }

        public String getKwotaOdsetek() {
            return kwotaOdsetek;
        }

        public String getOplatyStale() {
            return oplatyStale;
        }

        public String getCalkowitaKwotaRaty() {
            return calkowitaKwotaRaty;
        }
    }
}
