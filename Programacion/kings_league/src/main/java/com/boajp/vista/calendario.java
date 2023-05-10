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



import java.io.IOException;


public class calendario {
    private JPanel pCalendario;

    public calendario(){


    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        JFrame frame = new JFrame("calendario");
        frame.setContentPane(new calendario().pCalendario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}