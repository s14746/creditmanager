<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Harmonogram spłat</title>
    </head>
    <body>
         <a href="/">Wróc</a>

         <table align="center">
         <tr>
         <th>Numer raty</th>
         <th>Kwota kapitału</th>
         <th>Kwota odsetek</th>
         <th>Opłata stała</th>
         <th>Całkowita kwota raty</th>
         </tr>
         <c:forEach items="${raty}" var="rata">
             <tr>
                 <td  align="center"><c:out value="${rata.numerRaty}"/></td>
                 <td  align="center"><c:out value="${rata.kwotaKapitalu}"/></td>
                 <td  align="center"><c:out value="${rata.kwotaOdsetek}"/></td>
                 <td  align="center"><c:out value="${rata.oplatyStale}"/></td>
                 <td  align="center"><c:out value="${rata.calkowitaKwotaRaty}"/></td>
             </tr>
         </c:forEach>
         </table>
    </body>
</html>