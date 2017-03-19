package pl.pjwstk.creditcalculator.web;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pl.pjwstk.creditcalculator.core.Formularz;
import pl.pjwstk.creditcalculator.core.Kalkulator;
import pl.pjwstk.creditcalculator.core.TypRaty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/harmonogram")
public class HarmonogramServlet extends HttpServlet {

    private final Kalkulator kalkulator = new Kalkulator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RodzajRaportu rodzajRaportu = RodzajRaportu.valueOf(req.getParameter("rodzajRaportu"));

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


        if (rodzajRaportu == RodzajRaportu.PDF) {
            wygenerujPdf(resp, raty);
        }

        wygenerujHtml(req, resp, raty);
    }

    private void wygenerujHtml(HttpServletRequest req, HttpServletResponse resp, List<Rata> raty) throws ServletException, IOException {
        req.setAttribute("raty", raty);
        req.getRequestDispatcher("/WEB-INF/harmonogram.jsp").forward(req, resp);
    }

    private void wygenerujPdf(HttpServletResponse resp, List<Rata> raty) {
        resp.setContentType("application/pdf");
        resp.addHeader("Content-Disposition", "attachment; filename=Harmonogram-Rat.pdf");

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, resp.getOutputStream());
            document.open();

            PdfPTable table = new PdfPTable(5);
            table.addCell("Numer raty");
            table.addCell("Kwota kapitału");
            table.addCell("Kwota odsetek");
            table.addCell("Opłaty stałe");
            table.addCell("Całkowita kwota raty");

            raty.forEach(rata -> {
                table.addCell(rata.getNumerRaty());
                table.addCell(rata.getKwotaKapitalu());
                table.addCell(rata.getKwotaOdsetek());
                table.addCell(rata.getOplatyStale());
                table.addCell(rata.getCalkowitaKwotaRaty());
            });

            document.add(table);
            document.close();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
