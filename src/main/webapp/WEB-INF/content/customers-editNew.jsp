<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>New Customer</title>
</head>
<body>
    <s:form method="post" action="%{#request.contextPath}/customers">
    <table>
        <s:textfield name="name" label="Name"/>
        <s:textfield name="phone" label="Phone" />
        <tr>
            <td colspan="2">
                <s:submit />
            </td>
    </table>
    </s:form>
    <a href="<%=request.getContextPath() %>/customers">Back to Customers</a>
</body>
</html>
