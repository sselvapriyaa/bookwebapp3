/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.saa.bookwebapp3.model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Gladwin
 */
public class AuthorService {
    private AuthorDaoStrategy dao;
    
    public List<Author> getAuthorList() throws ClassNotFoundException, SQLException {
        return dao.getAuthorList();
    }

    public int deleteAuthorById(Object id) throws ClassNotFoundException, SQLException {
        return dao.deleteAuthorById(id);
    }

    public int createOneAuthor(Object name, Object date) throws ClassNotFoundException, SQLException {
        return dao.createOneAuthor(name, date);
    }

    public int updateAuthor(Object id, Object name, Object date) throws ClassNotFoundException, SQLException {
        return dao.updateAuthor(id, name, date);
    }
    
    public Author getAuthorById(String authorId) throws ClassNotFoundException, SQLException{
        return dao.getAuthorById(Integer.parseInt(authorId));
    }

    public AuthorDaoStrategy getDao() {
        return dao;
    }

    public void setDao(AuthorDaoStrategy dao) {
        this.dao = dao;
    }
}

