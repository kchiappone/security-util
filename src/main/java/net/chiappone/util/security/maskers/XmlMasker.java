package net.chiappone.util.security.maskers;

import net.chiappone.util.xml.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Masks XML node values based upon either the start/end indices, or by passing
 * in a tag (or multiple tags) and masker(s) which "knows" how to mask the tag
 * type.
 *
 * @author Kurtis Chiappone
 */
public class XmlMasker extends StringMasker {

    public XmlMasker() {

        super();

    }

    public XmlMasker( char mask, int startIndex, int endIndex ) {

        super( mask, startIndex, endIndex );

    }

    public XmlMasker( int startIndex ) {

        super( startIndex );

    }

    public XmlMasker( int startIndex, int endIndex ) {

        super( startIndex, endIndex );

    }

    public String mask( Map<String, Masker<String>> map, String xml ) {

        if ( xml == null || map == null || xml.length() <= 0 || map.size() <= 0 ) {
            return null;
        }

        Document doc = XmlUtil.stringToXml( xml );

        if ( doc != null ) {

            for ( Entry<String, Masker<String>> entry : map.entrySet() ) {

                Masker<String> masker = entry.getValue();
                String tag = entry.getKey();

                NodeList matchingTags = doc.getElementsByTagName( tag );

                for ( int i = 0; i < matchingTags.getLength(); i++ ) {

                    Node node = matchingTags.item( i );
                    NodeList nodes = node.getChildNodes();
                    Text text = (Text) nodes.item( 0 );

                    String unmasked = text.getData();
                    String masked = masker.mask( unmasked );
                    text.setData( masked );

                }

            }

        }

        return XmlUtil.xmlToString( doc );

    }

    public String mask( Masker<String> masker, String xml, String tag ) {

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

                String unmasked = text.getData();
                String masked = masker.mask( unmasked );
                text.setData( masked );

            }

        }

        return XmlUtil.xmlToString( doc );

    }

    public String mask( String xml, String tag ) {

        return mask( this, xml, tag );

    }

}
