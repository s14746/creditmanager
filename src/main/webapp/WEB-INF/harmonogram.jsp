<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Harmonogram spłat</title>
    </head>
    <body>
         <table>
         <c:forEach items="${ratyKredytu}" var="rataKredytu">
             <tr>
                 <td>Numer raty: <c:out value="${rataKredytu.numerRaty}"/></td>
                 <td>Kwota kapitału: <c:out value="${rataKredytu.kwotaKapitalu}"/></td>
                 <td>Kwota odsetek: <c:out value="${rataKredytu.kwotaOdsetek}"/></td>
                 <td>Opłata stała: <c:out value="${rataKredytu.oplatyStale}"/></td>
                 <td>Całkowita kwota raty: <c:out value="${rataKredytu.calkowitaKwotaRaty}"/></td>
             </tr>
         </c:forEach>
         </table>
    </body>
</html>