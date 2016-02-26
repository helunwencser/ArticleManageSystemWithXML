<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
<xsl:template match="/">
  <html>
      <body>
          <h2>The title of articles later than 2010</h2>
          <ul>
              <xsl:for-each select="root/node">
                  <li>
                      <xsl:value-of select="title"/>
                  </li>
              </xsl:for-each>
          </ul>
      </body>
  </html>
</xsl:template>
</xsl:stylesheet>
