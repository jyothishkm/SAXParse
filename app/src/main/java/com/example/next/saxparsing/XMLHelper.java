package com.example.next.saxparsing;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by next on 9/3/17.
 */
public class XMLHelper extends DefaultHandler {
    private String URL_MAIN = "http://www.androidbegin.com/tutorial/XMLParseTutorial.xml";
    boolean currTAG = false;
    String currTagValue="";
    private static String TAG = "XMLHelper";
    public DataModel dataModel = null;
    public ArrayList<DataModel> modelArrayList = new ArrayList<>();

    public void get(){
        try{
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(this);
            InputStream inputStream = new URL(URL_MAIN).openStream();
            xmlReader.parse(new InputSource(inputStream));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        Log.i(TAG, "characters: ");
if (currTAG) {
    currTagValue = currTagValue + new String(ch , start , length);
    currTAG = false;
}

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        Log.i(TAG, "startElement: ");
        currTAG = true;
        currTagValue = "";
        if (localName.equals("item")){
            dataModel = new DataModel();

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Log.i(TAG, "endElement: ");
        currTAG = false;
        if (localName.equalsIgnoreCase("title"))
            dataModel.setTitle(currTagValue);

        else if (localName.equalsIgnoreCase("description"))
            dataModel.setDesc(currTagValue);

        else if (localName.equalsIgnoreCase("link"))
            dataModel.setLink(currTagValue);

        else if (localName.equalsIgnoreCase("date"))
            dataModel.setDate(currTagValue);

        else if (localName. equalsIgnoreCase("item"))
            modelArrayList.add(dataModel);

    }
}
