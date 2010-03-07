<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Customers</title>
</head>
<body>
    <s:actionmessage />
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
        </tr>
        <s:iterator value="model">
        <tr>
            <td>${id}</td>
            <td>${name}</td>
            <td>${phone}</td>
            <td><a href="customers/${id}/show">View</a> |
                <a href="customers/${id}/edit">Edit</a> |
                <a href="customers/${id}/deleteConfirm">Delete</a></td>
        </tr>
        </s:iterator>
    </table>
    <a href="customers/new">Create a new customer</a>
</body>
</html>
