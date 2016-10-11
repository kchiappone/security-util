package net.chiappone.util.security.truncaters;

import net.chiappone.util.xml.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Truncates XML node values based upon either the start/end indices, or by
 * passing in a tag (or multiple tags) and truncater(s) which "knows" how to
 * truncate the tag type.
 */
public class XmlTruncater extends StringTruncater {

    public XmlTruncater() {

        super();

    }

    /**
     * @param startIndex
     */
    public XmlTruncater( int startIndex ) {

        super( startIndex );

    }

    /**
     * @param startIndex
     * @param endIndex
     */
    public XmlTruncater( int startIndex, int endIndex ) {

        super( startIndex, endIndex );

    }

    /**
     * @param xml
     * @param tag
     * @return
     */
    public String truncate( String xml, String tag ) {

        return truncate( this, xml, tag );

    }

    /**
     * @param truncater
     * @param xml
     * @param tag
     * @return
     */
    public String truncate( Truncater<String> truncater, String xml, String tag ) {

        if ( xml == null || tag == null || xml.length() <= 0 || tag.length() <= 0 ) {
            return null;
        }

        Document doc = XmlUtil.stringToXml( xml );

        if ( doc != null ) {

            NodeList matchingTags = doc.getElementsByTagName( tag );

            for ( int i = 0; i < matchingTags.getLength(); i++ ) {

                Node node = matchingTags.item( i );
                NodeList nodes = node.getChildNodes();
                Text text = (Text) nodes.item( 0 );

                String data = text.getData();
                String truncated = truncater.truncate( data );
                text.setData( truncated );

            }

        }

        return XmlUtil.xmlToString( doc );

    }

    /**
     * @param map
     * @param xml
     * @return
     */
    public String truncate( Map<String, Truncater<String>> map, String xml ) {

        if ( xml == null || map == null || xml.length() <= 0 || map.size() <= 0 ) {
            return null;
        }

        Document doc = XmlUtil.stringToXml( xml );

        if ( doc != null ) {

            for ( Entry<String, Truncater<String>> entry : map.entrySet() ) {

                Truncater<String> truncater = entry.getValue();
                String tag = entry.getKey();

                NodeList matchingTags = doc.getElementsByTagName( tag );

                for ( int i = 0; i < matchingTags.getLength(); i++ ) {

                    Node node = matchingTags.item( i );
                    NodeList nodes = node.getChildNodes();
                    Text text = (Text) nodes.item( 0 );

                    String data = text.getData();
                    String truncated = truncater.truncate( data );
                    text.setData( truncated );

                }

            }

        }

        return XmlUtil.xmlToString( doc );

    }

}
