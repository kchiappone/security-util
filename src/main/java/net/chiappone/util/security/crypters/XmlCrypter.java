package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.KeyHolder;
import net.chiappone.util.xml.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Encrypts/decrypts XML node values based upon the tag(s) passed in.
 * <p>
 * <strong>NOTE:</strong> If you wish to encrypt/decrypt the whole XML as
 * opposed to specific tags, use StringCrypter instead.
 */
public class XmlCrypter extends StringCrypter {

    /**
     * @param xml
     * @param key
     * @param tags
     * @return
     */
    public String decrypt( String xml, KeyHolder key, List<String> tags ) {

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

                    String txt = text.getData();
                    String decrypted = super.decrypt( txt, key );
                    text.setData( decrypted );

                }

            }

        }

        return XmlUtil.xmlToString( doc );

    }

    /**
     * @param xml
     * @param key
     * @param tag
     * @return
     */
    public String decrypt( String xml, KeyHolder key, String tag ) {

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

                String txt = text.getData();
                String decrypted = super.decrypt( txt, key );
                text.setData( decrypted );

            }

        }

        return XmlUtil.xmlToString( doc );

    }

    /**
     * @param xml
     * @param key
     * @param tags
     * @return
     */
    public String encrypt( String xml, KeyHolder key, List<String> tags ) {

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

                    String txt = text.getData();
                    String encrypted = super.encrypt( txt, key );
                    text.setData( encrypted );

                }

            }

        }

        return XmlUtil.xmlToString( doc );

    }

    /**
     * @param xml
     * @param key
     * @param tag
     * @return
     */
    public String encrypt( String xml, KeyHolder key, String tag ) {

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

                String txt = text.getData();
                String encrypted = super.encrypt( txt, key );
                text.setData( encrypted );

            }

        }

        return XmlUtil.xmlToString( doc );

    }

}
