<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Formularz kredytowy</title>
    </head>
    <body>
         <form method="POST" action="/harmonogram">
            <label>Wnioskowana kwota kredytu</label>
            <input name="kwotaKredytu" type="text" />

            <label>Ilość rat</label>
            <input name="iloscRat" type="text" />

            <label>Oprocentowanie</label>
            <input name="oprocentowanie" type="text" />

            <label>Opłata stała</label>
            <input name="oplataStala" type="text" />

            <label>Typ raty</label>
            <select name="typRaty">
                <option value="STALA">Stała</option>
                <option value="MALEJACA">Malejąca</option>
            </select>

            <input type="submit" />
         </form>
    </body>
</html>