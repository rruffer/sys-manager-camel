<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output omit-xml-declaration="no" indent="yes" />

	<xsl:template match="/pedido">
		<soapenv:Envelope
			xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
			xmlns:cli="http://cliente.bean.master.sigep.bsb.correios.com.br/">
			<soapenv:Header />
			<soapenv:Body>
				<cli:consultaCEP>
					<cep>25020-150</cep>
				</cli:consultaCEP>
			</soapenv:Body>
		</soapenv:Envelope>
	</xsl:template>

</xsl:stylesheet>