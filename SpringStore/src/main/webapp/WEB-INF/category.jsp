<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>


<%-- HTML markup starts below --%>
<p>${msg}</p>

<div id="categoryLeftColumn">

    <c:forEach var="category" items="${categories}">

        <c:choose>
            <c:when test="${category.name == selectedCategory.name}">
                <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">
                        ${category.name} [Selected]
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="<c:url value='/category/${category.id}'/>" class="categoryButton">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </a>
                <br/>
            </c:otherwise>
        </c:choose>

    </c:forEach>

</div>

<div id="categoryRightColumn">

    <p id="categoryTitle">${selectedCategory.name} (sel)</p>

    <table id="productTable">

        <c:forEach var="product" items="${categoryProducts}" varStatus="iter">

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                <td>
                    <img alt="${product.name}">
                </td>

                <td>
                    <br>
                    <span class="smallText">${product.name}</span>
                </td>

                <td>${product.price}</td>

                <td>
                    <form action="<c:url value='/addToCart'/>" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.id}">
                        <input type="submit"
                               name="submit"
                               value='addToCart'">
                    </form>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
</body>
</html>