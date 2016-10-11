package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.xml.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Hashes XML node values based on the tag(s) passed in.
 *
 * @author Kurtis Chiappone
 */
public class XmlHasher extends StringHasher {

    public String hash( Algorithm algorithm, String xml, List<String> tags ) {

        if ( xml == null || tags == null || xml.length() <= 0 || tags.size() <= 0 ) {
            return null;
        }

        Document doc = XmlUtil.stringToXml( xml );

        if ( doc != null ) {

            for ( String tag : tags ) {

                NodeList matchingTags = doc.getElementsByTagName( tag );

                for ( int i = 0; i < matchingTags.getLength(); i++ ) {

                    Node node = matchingTags.item( i );
                    NodeList nodes = node.getChildNodes();
                    Text text = (Text) nodes.item( 0 );

                    String data = text.getData();
                    String hashed = super.hash( algorithm, data );
                    text.setData( hashed );

                }

            }

        }

        return XmlUtil.xmlToString( doc );

    }

    public String hash( Algorithm algorithm, String xml, String tag ) {

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
                String hashed = super.hash( algorithm, data );
                text.setData( hashed );

            }

        }

        return XmlUtil.xmlToString( doc );

    }

}
