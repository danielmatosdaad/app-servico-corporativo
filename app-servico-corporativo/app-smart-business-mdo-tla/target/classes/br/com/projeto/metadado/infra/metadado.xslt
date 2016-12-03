<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://www.projeto.com.br/metadado/bean"
	xmlns:projeto="http://url.projeto/componentes">

	<xsl:template match="tns:metadado">


	<xsl:apply-templates select="componente" />


	</xsl:template>

	<xsl:template match="componente">
		<!-- create child element -->
		<xsl:element namespace="{@nameSpace}" name="{@nomeComponente}">
			<xsl:for-each select="propriedade">
				<!-- create attribute -->
				<xsl:attribute name="{@nome}">
		            <xsl:value-of select="valor" />
		         </xsl:attribute>
			</xsl:for-each>
		</xsl:element>
	</xsl:template>

</xsl:stylesheet>