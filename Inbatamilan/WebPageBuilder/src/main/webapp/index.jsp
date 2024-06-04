<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Drag and Drop Web Page Builder</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/script.js" defer></script>
</head>
<body>
    <div class="toolbar">
        <button id="addButton">Add Element</button>
        <button id="saveButton">Save Layout</button> 
        <!-- <form action="saveLayout" method="post">
        <input type="submit"  value="Add Element" name="add" id="addButton">
        <input type="submit" value="Save Layout" name="save" id="saveButton"> 
        </form> -->
    </div>
    <div class="workspace" id="workspace">
        <!-- Elements will be added here -->
    </div>
</body>
</html>