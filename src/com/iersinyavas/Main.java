package com.iersinyavas;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {

		Document dosyayolu = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			dosyayolu = builder.parse("C:\\BitimeProjesi\\JavaXML\\personel.xml");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		Element personeller = dosyayolu.getDocumentElement();
		System.out.println("Kök Element : " + personeller.getNodeName());
		System.out.println("Element Adý : " + personeller.getElementsByTagName("title").item(0).getTextContent());
		NodeList personellistesi = personeller.getElementsByTagName("personel");

		for (int i = 0; i < personellistesi.getLength(); i++) {
			Element personel = (Element) personellistesi.item(i);
			String personelid = personel.getAttribute("id");
			System.out.print(personelid + "-" + personel.getElementsByTagName("adsoyad").item(0).getTextContent() + "\n");
			NodeList dersNodeList = personel.getElementsByTagName("dersadi");

			for (int j = 0; j < dersNodeList.getLength(); j++) {
				Element option = (Element) dersNodeList.item(j);
				System.out.println("Ders No: " + option.getAttribute("no") + " -" + option.getTextContent());

			}
			System.out.println("-------------------------------------------");
		}

	}

}
