/*
 * Created on 3 avr. 2014 ( Time 19:39:36 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package cn.ilongfei.jpa.modeltest.model.test.bookstore;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "AUTHOR"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="AUTHOR", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AuthorEntity.countAll", query="SELECT COUNT(x) FROM AuthorEntity x" )
} )
public class AuthorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="ID", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="FIRST_NAME", length=40)
    private String     firstName    ;

    @Column(name="LAST_NAME", length=40)
    private String     lastName     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="author", targetEntity=BookEntity.class)
    private List<BookEntity> listOfBook  ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AuthorEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FIRST_NAME ( VARCHAR ) 
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    //--- DATABASE MAPPING : LAST_NAME ( VARCHAR ) 
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfBook( List<BookEntity> listOfBook ) {
        this.listOfBook = listOfBook;
    }
    public List<BookEntity> getListOfBook() {
        return this.listOfBook;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(firstName);
        sb.append("|");
        sb.append(lastName);
        return sb.toString(); 
    } 

}
