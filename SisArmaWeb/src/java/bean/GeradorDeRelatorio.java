/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author ander
 */
public class GeradorDeRelatorio {
    private Connection conexao;

    public GeradorDeRelatorio(Connection conexao) {
        this.conexao = conexao;
    }

    public void geraPdf(String jrxml, 
        Map<String, Object> parametros, OutputStream saida) {

        try {
            // compila jrxml em memoria
            JasperReport jasper = JasperCompileManager.compileReport(jrxml);
            
            

            // preenche relatorio
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conexao);

            // exporta para pdf
            JRExporter exporter = new JRPdfExporter();
            
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

            exporter.exportReport();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório", e);
        }
    }   
}
