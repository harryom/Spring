<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

<div id="indexLeftColumn">
    <div id="welcomeText">
        <p style="font-size: larger">greeting</p>

        <p>intro</p>
        <span>${category.name}</span>
    </div>
</div>

<div id="indexRightColumn">
    <c:forEach var="category" items="${categories}">
        <div class="categoryBox">
            <a href="<c:url value='/category/${category.id}'/>">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText">${category.name}</span>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>