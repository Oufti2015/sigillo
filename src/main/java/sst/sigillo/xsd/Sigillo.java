//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.09.03 à 11:37:28 AM CEST 
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
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété preferences.
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
     * Définit la valeur de la propriété preferences.
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
     * Obtient la valeur de la propriété bookmarks.
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
     * Définit la valeur de la propriété bookmarks.
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
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
             * Obtient la valeur de la propriété url.
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
             * Définit la valeur de la propriété url.
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
             * Obtient la valeur de la propriété name.
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
             * Définit la valeur de la propriété name.
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
             * Obtient la valeur de la propriété category.
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
             * Définit la valeur de la propriété category.
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
             * Obtient la valeur de la propriété important.
             * 
             */
            public boolean isImportant() {
                return important;
            }

            /**
             * Définit la valeur de la propriété important.
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
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
         * Obtient la valeur de la propriété headerColor.
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
         * Définit la valeur de la propriété headerColor.
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
         * Obtient la valeur de la propriété bookmarkColor.
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
         * Définit la valeur de la propriété bookmarkColor.
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
