//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2014.09.03 � 11:37:28 AM CEST 
//


package sst.sigillo.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Preferences">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="HeaderColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="BookmarkColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Bookmarks">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Bookmark" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="important" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "preferences",
    "bookmarks"
})
@XmlRootElement(name = "Sigillo")
public class Sigillo {

    @XmlElement(name = "Preferences", required = true)
    protected Sigillo.Preferences preferences;
    @XmlElement(name = "Bookmarks", required = true)
    protected Sigillo.Bookmarks bookmarks;

    /**
     * Obtient la valeur de la propri�t� preferences.
     * 
     * @return
     *     possible object is
     *     {@link Sigillo.Preferences }
     *     
     */
    public Sigillo.Preferences getPreferences() {
        return preferences;
    }

    /**
     * D�finit la valeur de la propri�t� preferences.
     * 
     * @param value
     *     allowed object is
     *     {@link Sigillo.Preferences }
     *     
     */
    public void setPreferences(Sigillo.Preferences value) {
        this.preferences = value;
    }

    /**
     * Obtient la valeur de la propri�t� bookmarks.
     * 
     * @return
     *     possible object is
     *     {@link Sigillo.Bookmarks }
     *     
     */
    public Sigillo.Bookmarks getBookmarks() {
        return bookmarks;
    }

    /**
     * D�finit la valeur de la propri�t� bookmarks.
     * 
     * @param value
     *     allowed object is
     *     {@link Sigillo.Bookmarks }
     *     
     */
    public void setBookmarks(Sigillo.Bookmarks value) {
        this.bookmarks = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Bookmark" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="important" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bookmark"
    })
    public static class Bookmarks {

        @XmlElement(name = "Bookmark")
        protected List<Sigillo.Bookmarks.Bookmark> bookmark;

        /**
         * Gets the value of the bookmark property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bookmark property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBookmark().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Sigillo.Bookmarks.Bookmark }
         * 
         * 
         */
        public List<Sigillo.Bookmarks.Bookmark> getBookmark() {
            if (bookmark == null) {
                bookmark = new ArrayList<Sigillo.Bookmarks.Bookmark>();
            }
            return this.bookmark;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="important" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "url",
            "name",
            "category",
            "important"
        })
        public static class Bookmark {

            @XmlElement(required = true)
            protected String url;
            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String category;
            @XmlElement(defaultValue = "false")
            protected boolean important;

            /**
             * Obtient la valeur de la propri�t� url.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrl() {
                return url;
            }

            /**
             * D�finit la valeur de la propri�t� url.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrl(String value) {
                this.url = value;
            }

            /**
             * Obtient la valeur de la propri�t� name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * D�finit la valeur de la propri�t� name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Obtient la valeur de la propri�t� category.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategory() {
                return category;
            }

            /**
             * D�finit la valeur de la propri�t� category.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategory(String value) {
                this.category = value;
            }

            /**
             * Obtient la valeur de la propri�t� important.
             * 
             */
            public boolean isImportant() {
                return important;
            }

            /**
             * D�finit la valeur de la propri�t� important.
             * 
             */
            public void setImportant(boolean value) {
                this.important = value;
            }

        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="HeaderColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="BookmarkColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "headerColor",
        "bookmarkColor"
    })
    public static class Preferences {

        @XmlElement(name = "HeaderColor", required = true)
        protected String headerColor;
        @XmlElement(name = "BookmarkColor", required = true)
        protected String bookmarkColor;

        /**
         * Obtient la valeur de la propri�t� headerColor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeaderColor() {
            return headerColor;
        }

        /**
         * D�finit la valeur de la propri�t� headerColor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeaderColor(String value) {
            this.headerColor = value;
        }

        /**
         * Obtient la valeur de la propri�t� bookmarkColor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBookmarkColor() {
            return bookmarkColor;
        }

        /**
         * D�finit la valeur de la propri�t� bookmarkColor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBookmarkColor(String value) {
            this.bookmarkColor = value;
        }

    }

}
