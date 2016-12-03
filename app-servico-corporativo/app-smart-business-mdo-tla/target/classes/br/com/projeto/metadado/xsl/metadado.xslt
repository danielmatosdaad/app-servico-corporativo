<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://www.projeto.com.br/metadado/bean"
	xmlns:projeto="http://url.projeto/componentes">

	<xsl:template match="tns:metadado">
		<xsl:apply-templates select="conteudo" />
	</xsl:template>
		<xsl:template match="conteudo">
			<!-- create child element -->
			<xsl:element name="{@nomeConteudo}">
				<xsl:apply-templates select="componente" />
			</xsl:element>
		</xsl:template>
		<xsl:template match="componente">

			<xsl:element namespace="{@nameSpace}" name="{@nomeComponente}">
				<xsl:for-each select="@*">
					<xsl:attribute name="{name()}">
		            <xsl:value-of select="." />
		         </xsl:attribute>
				</xsl:for-each>
			</xsl:element>
		</xsl:template>
	
</xsl:stylesheet>
