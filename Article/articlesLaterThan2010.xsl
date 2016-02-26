<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
<xsl:template match="/">
  <html>
      <body>
          <h2>Articles later than 2010</h2>
          <ul>
              <xsl:for-each select="root/node/article">
                  <li>
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
                  </li>
              </xsl:for-each>
          </ul>
      </body>
  </html>
</xsl:template>
</xsl:stylesheet>
