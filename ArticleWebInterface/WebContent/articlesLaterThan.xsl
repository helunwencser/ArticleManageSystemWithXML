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
			<div class = "col-lg-offset-4 col-lg-5">
	  			<h2>Articles later than some year</h2>
	  		</div>
		</div>
		
		<xsl:for-each select="root/node/article">
			<div class = "col-lg-offset-3 col-lg-6">
			<a href = "#" class = "list-group-item">
				<ul>
                    <li>
                        Title: <xsl:value-of select="title"/>
                    </li>
                    <li>
                        Author: <xsl:value-of select="author"/>
                    </li>
                    <li>
                        Mdate: <xsl:value-of select="@mdate"/>
                    </li>
                    <li>
                        Key: <xsl:value-of select="@key"/>
                    </li>
                    <li>
                        Pages: <xsl:value-of select="pages"/>
                    </li>
                    <li>
                        Year: <xsl:value-of select="year"/>
                    </li>
                    <li>
                        Volume: <xsl:value-of select="volume"/>
                    </li>
                    <li>
                        Journal: <xsl:value-of select="journal"/>
                    </li>
                    <li>
                        Number: <xsl:value-of select="number"/>
                    </li>
                    <li>
                        EE: <xsl:value-of select="ee"/>
                    </li>
                    <li>
                        URL: <xsl:value-of select="url"/>
                    </li>
                </ul>
			</a>
			</div>
        </xsl:for-each>
      </body>
  </html>
</xsl:template>
</xsl:stylesheet>

