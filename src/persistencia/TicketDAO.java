/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Ticket;

/**
 *
 * @author Christoph
 */
public interface TicketDAO {
 
    
        void adicionar(Ticket p) throws ticketDAOException;

    Ticket getTicketPorCodigo(int n) throws ticketDAOException;
    
    List<Ticket> getTickets();
    
}
