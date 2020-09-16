<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                xmlns:java="java">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="app">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A6-landscape"
                                       page-height="105mm" page-width="148mm" margin="1cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A6-landscape">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="16pt" font-weight="bold" space-after="5mm">
                        <xsl:value-of select="name"/>
                    </fo:block>
                    <fo:block font-size="12pt" space-after="2cm">
                        <xsl:value-of select="description"/>
                    </fo:block>
                    <fo:block font-size="12pt" space-after="5mm">
                        <xsl:value-of select="java:util.Date.new()"/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>