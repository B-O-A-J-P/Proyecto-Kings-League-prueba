

package com.boajp.vista;

import javax.swing.*;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import com.boajp.utilidades.EstilosDeVistas;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Calendario {
    private JPanel pCalendario;

    public Calendario(){
        try {
            pCalendario.setLayout(new GridBagLayout());
            GridBagConstraints constraintLabel = new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 0), 0, 0);
            GridBagConstraints constraintTabla = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 50, 100, 50), 0, 0);

            //Leer archivo XML
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File("src/main/java/com/boajp/xml/Calendario_kings_league.xml"));

            // Obtener la lista de temporadas, splits y jornadas del documento
            NodeList temporadaList = document.getElementsByTagName("temporada");
            Element temporadaElement = (Element) temporadaList.item(0);

            NodeList splitList = temporadaElement.getElementsByTagName("split");
            Element splitElement = (Element) splitList.item(0);

            NodeList jornadaList = splitElement.getElementsByTagName("jornada");

            int gridy = 0;
            // Recorrer la lista de jornadas y crear un JTable para cada una
            for (int i = 0; i < jornadaList.getLength(); i++) {
                //obtener el elemento correspondiente a la jornada actual
                Element jornadaElement = (Element) jornadaList.item(i);

                // Obtener la fecha de la jornada
                String fechaJornada = jornadaElement.getElementsByTagName("fecha").item(0).getTextContent();

                // Crear el JLabel con el texto "Jornada" y el número y fecha de la jornada
                JLabel label = new JLabel("Jornada " + (i+1) + " - " + fechaJornada);
                label.setForeground(EstilosDeVistas.COLOR_FUENTE_VISTA_CALENDARIO_TITULO);;
                label.setFont(EstilosDeVistas.FUENTE_VISTA_CALENDARIO_TITULO);
                constraintLabel.gridy = gridy;
                pCalendario.add(label, constraintLabel);

                // Crear un JTable para mostrar los partidos de la jornada
                String[] columnas = { "Equipo local", "Logo", "Hora" , "logo","Equipo visitante"};
                DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
                JTable tabla = new JTable(modelo);
                //ocultar cabecera de la tabla
                tabla.setTableHeader(null);
                tabla.setBackground(EstilosDeVistas.COLOR_DE_FONDO);
                tabla.setShowVerticalLines(false);
                tabla.setFont(EstilosDeVistas.FUENTE_VISTA_CALENDARIO_TITULO);
                tabla.setForeground(EstilosDeVistas.COLOR_FUENTE_VISTA_CALENDARIO_CELDA);
                tabla.setGridColor(EstilosDeVistas.COLOR_DEL_BORDE_CELDA);


                // Agregar los partidos a la tabla
                NodeList partidoList = jornadaElement.getElementsByTagName("partido");


                //recorrer lista de partidos y agregarlos a la tabla
                for (int j = 0; j < partidoList.getLength(); j++) {
                    Element partidoElement = (Element) partidoList.item(j);
                    String horaPartido = partidoElement.getElementsByTagName("hora").item(0).getTextContent();

                    Element equipoLocalElement = (Element) partidoElement.getElementsByTagName("equipo").item(0);
                    String nombreEquipoLocal = equipoLocalElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String logoEquipoLocal = equipoLocalElement.getElementsByTagName("logo").item(0).getTextContent();

                    Element equipoVisitanteElement = (Element) partidoElement.getElementsByTagName("equipo").item(1);
                    String nombreEquipoVisitante = equipoVisitanteElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String logoEquipoVisitante = equipoVisitanteElement.getElementsByTagName("logo").item(0).getTextContent();

                    Object[] fila = { nombreEquipoLocal,logoEquipoLocal,horaPartido,logoEquipoVisitante,nombreEquipoVisitante};
                    modelo.addRow(fila);
                    tabla.setModel(modelo);
                    //cambiar altura fila de la tabla
                    tabla.setRowHeight(EstilosDeVistas.ALTURA_DE_CELDA);

                    // Hacer que la tabla sea no editable
                    tabla.setEnabled(false);
                }

                TableColumnModel columnModel = tabla.getColumnModel();
                // Centrar los datos en las celdas
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                for (int x = 0; x < columnModel.getColumnCount(); x++) {
                    tabla.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
                }

                gridy += 1;
                constraintTabla.gridy = gridy;
                pCalendario.add(tabla, constraintTabla);
                gridy += 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JPanel getpCalendario() {
        return pCalendario;
    }
}

