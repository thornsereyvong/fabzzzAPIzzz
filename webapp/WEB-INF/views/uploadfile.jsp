<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Crunchify - Spring MVC Upload Multiple Files Example</title>
<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
    $(document)
            .ready(
                    function() {
                        //add more file components if Add is clicked
                        $('#addFile')
                                .click(
                                        function() {
                                            var fileIndex = $('#fileTable tr')
                                                    .children().length - 1;
                                            $('#fileTable')
                                                    .append(
                                                            '<tr><td>'
                                                                    + '   <input type="file" name="files['+ fileIndex +']" />'
                                                                    + '</td></tr>');
                                        });
 
                    });
</script>
<style type="text/css">
body {
    background-image:
        url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
</head>
<body>
    <br>
    <br>
    <div align="center">
        <h1>Spring MVC Upload Multiple Files Example</h1>
        
         <form:form method="post" action="rest2" enctype="multipart/form-data"> --%>
 
            <p>Select files to upload. Press Add button to add more file
                inputs.</p>
 
            <table id="fileTable">
                <tr>
                    <td><input name="files[0]" type="file" /></td>
                </tr>
                <tr>
                    <td><input name="files[1]" type="file" /></td>
                </tr>
            </table>
            <br />
            <input type="submit" value="Upload" />
            <input id="addFile" type="button" value="Add File" />
    	</form:form>
    	
    	<br>
    	<hr>
    	<br>
    	
    	<form method="POST" action="rest3" enctype="multipart/form-data">
			File to upload: <input type="file" name="file">
 
			<input type="submit" value="Upload"> Press here to upload the file!
		</form>
		
		<br>
    	<hr>
    	<br>
    	
    	<form method="POST" action="rest4" enctype="multipart/form-data">
			File to upload: <input type="file" name="file"><br>
			File to upload: <input type="file" name="file"><br>
 
			<input type="submit" value="Upload"> Press here to upload the file!
		</form>
    		
 
    </div>
</body>
</html>