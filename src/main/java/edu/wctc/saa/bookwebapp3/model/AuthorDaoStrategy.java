/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.saa.bookwebapp3.model;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Gladwin
 */
public interface AuthorDaoStrategy {
    List<Author> getAuthorList() throws ClassNotFoundException, SQLException;

    abstract int deleteAuthorById(Object id) throws ClassNotFoundException, SQLException;

    public abstract int createOneAuthor(Object name, Object date) throws ClassNotFoundException, SQLException;

    public abstract int updateAuthor(Object id, Object name, Object date) throws ClassNotFoundException, SQLException;
    
    public abstract Author getAuthorById(Integer authorId) throws ClassNotFoundException, SQLException;

}
