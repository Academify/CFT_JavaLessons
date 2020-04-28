/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Ui;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.Dao;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Hq;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Obra;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aluno
 */
public class ObraRelatorio extends Dao {

    public void emitirRelatorio(List<Obra> oList){
         String reportSrcFile = "./obras.jasper";
             
        //Parameters for report 
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nomeEmpresa", "CEFET");
        
        try {
            JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(oList);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportSrcFile, parameters, jrBean);
            
            JasperViewer.viewReport(jasperPrint, false);   
        } catch (JRException ex) {
            ex.printStackTrace();
        }
        
        //Make sure the output directory exists.
        //File outDir = new File("jasperoutput");
        //outDir.mkdirs();
        
        //Export to PDF.
        // JasperExportManager.exportReportToPdfFile(print, "AlunoRelatorio.pdf");
        
         
    }
    
    public void processar() throws JRException, ClassNotFoundException, SQLException, Exception {
        
        String reportSrcFile = "./obras.jrxml";
        
        // First, compile jrxml file. 
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        
        Connection conn = getConnection();
        
        //Parameters for report 
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
        
        //Make sure the output directory exists.
        //File outDir = new File("jasperoutput");
        //outDir.mkdirs();
        
        //Export to PDF.
        // JasperExportManager.exportReportToPdfFile(print, "AlunoRelatorio.pdf");
        
        JasperViewer.viewReport(print, false);    
    }
}