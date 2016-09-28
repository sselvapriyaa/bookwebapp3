/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.saa.bookwebapp3.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Gladwin
 */
public class AuthorDao implements AuthorDaoStrategy {
private DBStrategy db;
    private String driver;
    private String url;
    private String user;
    private String pass;
    private String table;
    private String colone;
    private String coltwo;
    private String primarykey;
    private final List COLNAMES = new ArrayList();
    private final List VALUES = new ArrayList();
              public AuthorDao() {
    }
              @Override
    public List<Author> getAuthorList() throws ClassNotFoundException, SQLException {
        db.openConnection(driver, url, user, pass);

        List<Map<String, Object>> rawData
                = db.findAllRecords(table, 0);
        List<Author> authors = new ArrayList<>();

        for (Map rec : rawData) {
            Author author = new Author();
            Integer id = new Integer(rec.get(primarykey).toString());
            author.setAuthorId(id);
            String name = rec.get(colone) == null ? "" : rec.get(colone).toString();
            author.setAuthorName(name);
            Date date = rec.get(coltwo) == null ? null : (Date) rec.get(coltwo);
            author.setDateAdded(date);
            authors.add(author);
        }

        db.closeConnection();

        return authors;
    }
/**
     *
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public int deleteAuthorById(Object id) throws ClassNotFoundException, SQLException {
        db.openConnection(driver, url, user, pass);
        int result = db.deleteById(table, primarykey, id);
        db.closeConnection();
        return result;
    }
    /**
     *
     * @param name
     * @param date
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public int createOneAuthor(Object name, Object date) throws ClassNotFoundException, SQLException{
        db.openConnection(driver, url, user, pass);
        COLNAMES.add(colone);
        COLNAMES.add(coltwo);
        VALUES.add(name);
        VALUES.add(date);
        int result = db.insertOneRecord(table, COLNAMES, VALUES);
        COLNAMES.clear();
        VALUES.clear();
        db.closeConnection();
        return result;
    }
    /**
     *
     * @param id
     * @param name
     * @param date
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public int updateAuthor(Object id, Object name, Object date) throws ClassNotFoundException, SQLException{
        COLNAMES.add(colone);
        COLNAMES.add(coltwo);
        VALUES.add(name);
        VALUES.add(date);
        db.openConnection(driver, url, user, pass);
        int result = db.updateRecordById(table, COLNAMES, VALUES, primarykey, id);
        COLNAMES.clear();
        VALUES.clear();
        db.closeConnection();
        return result;
    }
    /**
     *
     * @param authorId
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public Author getAuthorById(Integer authorId) throws ClassNotFoundException, SQLException {
        db.openConnection(driver, url, user, pass);
        
        Map<String,Object> rawRec = db.findById(table, primarykey, authorId);
        Author author = new Author();
        author.setAuthorId((Integer)rawRec.get(primarykey));
        author.setAuthorName(rawRec.get(colone).toString());
        author.setDateAdded((Date)rawRec.get(coltwo));
        
        return author;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AuthorDaoStrategy dao = new AuthorDao();
        Date date = new Date();
        String name = "John Smith";
        dao.createOneAuthor(name, date);
        dao.updateAuthor(28, "Ann Taylor", 0);
        List <Author> authors = dao.getAuthorList();
        System.out.println(authors);
    }
}

