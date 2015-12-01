package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Endereco;
import negocio.Moeda;
import negocio.Parquimetro;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class ParquimetroDAOXML implements ParquimetroDAO {

    private File inputFile;
    private SAXBuilder saxBuilder;
    private Document document;
    private Element parq;

    public ParquimetroDAOXML() throws ParquimetroDAOException, SQLException, IOException {
        try {
            inputFile = new File("parquimetro.xml");
            saxBuilder = new SAXBuilder();
            document = saxBuilder.build(inputFile);
            parq = document.getRootElement();
        } catch (JDOMException ex) {
            Logger.getLogger(ParquimetroDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Parquimetro getParquimetro() {

        String rua, cidade, estado, pais;
        LocalTime hInicio, hFinal;
        Duration tMin, tMax, tIncr;
        int numero, codigo;
        BigDecimal vIncr;
        ArrayList<Moeda> moedas;

        Element parquimetro = parq.getChild("parquimetro");

        Attribute attCodigo = parquimetro.getAttribute("codigo");
        codigo = Integer.parseInt(attCodigo.getValue());
        rua = parquimetro.getChild("rua").getText();
        cidade = parquimetro.getChild("cidade").getText();
        estado = parquimetro.getChild("estado").getText();
        pais = parquimetro.getChild("pais").getText();
        numero = Integer.parseInt(parquimetro.getChild("numero").getText());

        hInicio = LocalTime.parse(parquimetro.getChild("horaInicio").getText());
        hFinal = LocalTime.parse(parquimetro.getChild("horaFinal").getText());
        tMin = Duration.parse(parquimetro.getChild("tempoMin").getText());
        tMax = Duration.parse(parquimetro.getChild("tempoMax").getText());
        tIncr = Duration.parse(parquimetro.getChild("incremento").getText());
        vIncr = new BigDecimal(parquimetro.getChild("valorIncremento").getText());

        moedas = new ArrayList<>();

        if (parquimetro.getChild("CINCO").getText().equals("Y")) {
            moedas.add(Moeda.CINCO);
        }

        if (parquimetro.getChild("DEZ").getText().equals("Y")) {
            moedas.add(Moeda.DEZ);
        }

        if (parquimetro.getChild("VINTEECINCO").getText().equals("Y")) {
            moedas.add(Moeda.VINTEECINCO);
        }

        if (parquimetro.getChild("CINQUENTA").getText().equals("Y")) {
            moedas.add(Moeda.CINQUENTA);
        }

        if (parquimetro.getChild("CEM").getText().equals("Y")) {
            moedas.add(Moeda.UMREAL);
        }

        Endereco e = new Endereco(rua, numero, cidade, estado, pais);
        Parquimetro p = new Parquimetro(e, codigo, hInicio, hFinal, tMin, tMax, tIncr, vIncr, moedas);

        return p;
    }

    @Override
    public Parquimetro getParquimetro(String codigoParquimetro) {
        return getParquimetro();
    }

    @Override
    public void addParquimetro(Parquimetro parquimetro) {

        Endereco end = parquimetro.getEnder();

        Element elemParq = parq.getChild("parquimetro");

        parq.setAttribute("codigo", String.valueOf(parquimetro.getCodigo()));

        Element elemRua = elemParq.getChild("rua");
        elemRua.setText(end.getNomeRua());

        Element elemNumero = elemParq.getChild("numero");
        elemRua.setText(String.valueOf(end.getNumero()));

        Element elemCidade = elemParq.getChild("cidade");
        elemRua.setText(end.getCidade());

        Element elemEstado = elemParq.getChild("estado");
        elemRua.setText(end.getEstado());

        Element elemPais = elemParq.getChild("pais");
        elemRua.setText(end.getPais());

        Element elemHInicio = elemParq.getChild("horaInicio");
        elemHInicio.setText(parquimetro.getHoraInicio().toString());

        Element elemHFinal = elemParq.getChild("horaFinal");
        elemHFinal.setText(parquimetro.getHoraFim().toString());

        //converte tempo min de Duration p/ String
        long aux = parquimetro.getTempoMin().getSeconds();
        String t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);

        Element elemTMin = elemParq.getChild("tempoMin");
        elemTMin.setText(t);

        //converte tempo max de Duration p/ String
        aux = parquimetro.getTempoMax().getSeconds();
        t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);

        Element elemTMax = elemParq.getChild("tempoMax");
        elemTMax.setText(t);

        //converte incremento de Duration p/ String
        aux = parquimetro.getIncremento().getSeconds();
        t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);

        Element elemIncremento = elemParq.getChild("incremento");
        elemIncremento.setText(t);

        Element elemValorIncremento = elemParq.getChild("valorIncremento");
        elemValorIncremento.setText(String.valueOf(parquimetro.getValorIncremento()));

        Element elemCINCO = elemParq.getChild("CINCO");
        Element elemDEZ = elemParq.getChild("DEZ");
        Element elemVINTEECINCO = elemParq.getChild("VINTEECINCO");
        Element elemCINQUENTA = elemParq.getChild("CINQUENTA");
        Element elemCEM = elemParq.getChild("CEM");

        if (parquimetro.getMoedas().contains(Moeda.CINCO)) {
            elemCINCO.setText("Y");
        } else {
            elemCINCO.setText("N");
        }
        
        if (parquimetro.getMoedas().contains(Moeda.DEZ)) {
            elemDEZ.setText("Y");
        } else {
            elemDEZ.setText("N");
        }
        
        if (parquimetro.getMoedas().contains(Moeda.VINTEECINCO)) {
            elemVINTEECINCO.setText("Y");
        } else {
            elemVINTEECINCO.setText("N");
        }
        
        if (parquimetro.getMoedas().contains(Moeda.CINQUENTA)) {
            elemCINQUENTA.setText("Y");
        } else {
            elemCINQUENTA.setText("N");
        }
        
        if (parquimetro.getMoedas().contains(Moeda.UMREAL)) {
            elemCEM.setText("Y");
        } else {
            elemCEM.setText("N");
        }

        elemParq.addContent(elemRua);
        elemParq.addContent(elemCidade);
        elemParq.addContent(elemNumero);
        elemParq.addContent(elemEstado);
        elemParq.addContent(elemPais);
        elemParq.addContent(elemCEM);
        elemParq.addContent(elemCINCO);
        elemParq.addContent(elemDEZ);
        elemParq.addContent(elemCINQUENTA);
        elemParq.addContent(elemVINTEECINCO);
        elemParq.addContent(elemValorIncremento);
        elemParq.addContent(elemIncremento);
        elemParq.addContent(elemHFinal);
        elemParq.addContent(elemHInicio);
        elemParq.addContent(elemTMax);
        elemParq.addContent(elemTMin);

        parq.addContent(elemParq);

        XMLOutputter xmlOutput = new XMLOutputter();

        xmlOutput.setFormat(Format.getPrettyFormat());

        try {
            xmlOutput.output(document, new FileWriter("tickets.xml"));
        } catch (IOException ex) {
            Logger.getLogger(ParquimetroDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Parquimetro> getParquimetros() throws ParquimetroDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
