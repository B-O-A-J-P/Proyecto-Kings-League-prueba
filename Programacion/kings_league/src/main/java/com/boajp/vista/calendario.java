package com.boajp.vista;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


import java.io.File;
import java.io.IOException;


public class calendario {
    private JPanel pCalendario;

    public calendario(){
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("src/main/java/com/boajp/xml/Calendario_kings_league.xml"));

            NodeList partidoList = document.getElementsByTagName("partido");

            for (int i = 0; i < partidoList.getLength(); i++) {
                Element partidoElement = (Element) partidoList.item(i);

                NodeList equipoList = partidoElement.getElementsByTagName("equipo");

                for (int j = 0; j < equipoList.getLength(); j++) {
                    Element equipoElement = (Element) equipoList.item(j);

                    String id = equipoElement.getAttribute("id");
                    String nombre = equipoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String logo = equipoElement.getElementsByTagName("logo").item(0).getTextContent();

                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Logo: " + logo);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        new calendario();
    }
}