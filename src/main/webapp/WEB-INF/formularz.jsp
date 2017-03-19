<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">
       <head>
        <title>Formularz kredytowy</title>
        <h2>Formularz kredytowy</h2>
    </head>
    <body>
         <form method="POST" action="/harmonogram" >
         <table>
         <tr>
            <td>Wnioskowana kwota kredytu</td>
            <td><input name="kwotaKredytu" type="text" required="required" pattern="[0-9]+"/></td>
            </tr>
            <tr>
            <td>Ilość rat</td>
            <td><input name="iloscRat" type="text" required="required" pattern="[0-9]+"/></td>
            </tr>
            <td>Oprocentowanie</td>
            <td><input name="oprocentowanie" type="text" required="required" pattern="[0-9.]+"/></td>
            <tr>
            <td>Opłata stała</td>
            <td><input name="oplataStala" type="text" required="required"pattern="[0-9]+"/></td>
            </tr>
            <tr>
            <td>Typ raty</td>
            <td><select name="typRaty">
                <option value="STALA">Stała</option>
                <option value="MALEJACA">Malejąca</option>
            </select></td>
            </tr>
            <tr>
            <td>&nbsp</td>
            </tr>
            <tr>
            <td></td>
            <td>
                <input type="submit" formaction="/harmonogram?rodzajRaportu=HTML" value="Wyślij" />
                <input type="submit" formaction="/harmonogram?rodzajRaportu=PDF" value="Wygeneruj PDF" />
            </td>
            </tr>
            </table>
         </form>
    </body>
</html>