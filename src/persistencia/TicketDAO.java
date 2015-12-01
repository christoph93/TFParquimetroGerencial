package persistencia;

import java.util.List;
import negocio.Ticket;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public interface TicketDAO {
 
    
        void adicionar(Ticket p) throws ticketDAOException;

    Ticket getTicketPorCodigo(int n) throws ticketDAOException;
    
    List<Ticket> getTickets();
    
}
