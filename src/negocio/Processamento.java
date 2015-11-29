/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;
import persistencia.ParquimetroDAOException;
import persistencia.ParquimetroDAOXML;
import persistencia.TicketDAODerby;
import persistencia.TicketDAOXML;
import persistencia.ticketDAOException;


/**
 *
 * @author Christoph
 */
public class Processamento {
    
    
    private ArrayList<Ticket> tickets;
    private TicketDAODerby daoTD;
    private TicketDAOXML daoTX;
    private ParquimetroDAOXML daoPX;
    private int numeracaoParquimetro = 1;
    
    public Processamento() throws ParquimetroDAOException, SQLException{
        try {
            
            daoTD = new TicketDAODerby();
            daoTX = new TicketDAOXML();
            daoPX = new ParquimetroDAOXML();
            
            
        } catch (JDOMException ex) {
            Logger.getLogger(Processamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Processamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void importaTickets() throws ticketDAOException{
        tickets = daoTX.getTickets();
        for(Ticket t : tickets){
            daoTD.adicionar(t);
        }        
    }
    
    //Endereco e, int cod, LocalTime hIni, LocalTime hFim, Duration tMin, Duration tMax, Duration incr, double vIncr, ArrayList<Moeda> moedas
    public void criaParquimetro(Endereco ende, LocalTime hIni,LocalTime hFim, Duration tMin, Duration tMax, Duration incr, BigDecimal vIncr, ArrayList<Moeda> moedas ){
        
        Parquimetro parq = new Parquimetro(ende, numeracaoParquimetro, hIni, hFim, tMin, tMax, incr, vIncr, moedas);
        
        daoPX.addParquimetro(parq);
        
    }
    
    
    
    
}
