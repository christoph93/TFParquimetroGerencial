package persistencia;

import java.time.LocalDateTime;
import java.util.List;
import negocio.Ticket;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class TicketDAODerby implements TicketDAO{

    public TicketDAODerby() {
        
    }

        @Override
    public void adicionar(Ticket p) throws ticketDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ticket getTicketPorCodigo(int n) throws ticketDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Ticket> getTicketPorData (LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal){
        return null;
    }

    @Override
    public List<Ticket> getTickets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
