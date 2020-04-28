package br.cefet.renatathiago.trabalhoBim2.Relatorios;

import br.cefet.renatathiago.trabalhoBim2.Dao.Dao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.VendaCliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class VendaClienteRelatorio extends Dao {
    
    public void processar() throws JRException, ClassNotFoundException, SQLException, DaoException{
        String reportSrcFile = "clienteVenda.jrxml";
        
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        
        Connection conn = getConnection();
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
        
        JasperViewer.viewReport(print, false);
        
    }

    public void emitirRelatorio(List<VendaCliente> pList){
        
        String reportSource = "clienteVenda.jasper";
        
        Map<String, Object> params = new HashMap<String, Object>();
        try{
            JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(pList);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportSource, params, jrBean);
            
            JasperViewer.viewReport(jasperPrint, false);
            
            
        }catch(JRException ex){
            ex.printStackTrace();
        }
        
    }
}

