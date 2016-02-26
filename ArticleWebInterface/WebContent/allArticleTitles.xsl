<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
<xsl:template match="/">
  <html>
	  <head>
		<title>Web Query</title>
		<meta charset="utf-8"></meta>
		<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
		<body class="bg-primary">
      	<div class="container">
			<div class = "col-lg-offset-5 col-lg-4">
	  			<h2>All article titles</h2>
	  		</div>
		</div>
		
        <xsl:for-each select="root/node">
        	<div class = "col-lg-offset-2 col-lg-8">
            	<a href = "#" class = "list-group-item">
                	<xsl:value-of select="title"/>
            	</a>
            </div>
        </xsl:for-each>
      </body>
  </html>
</xsl:template>
</xsl:stylesheet>
