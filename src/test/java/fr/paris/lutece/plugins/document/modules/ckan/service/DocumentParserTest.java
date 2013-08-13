/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.document.modules.ckan.service;

import fr.paris.lutece.plugins.document.modules.ckan.business.PackageShowResult;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.xml.sax.SAXException;

import java.io.IOException;


/**
 *
 * @author levy
 */
public class DocumentParserTest
{
    public DocumentParserTest(  )
    {
    }

    @BeforeClass
    public static void setUpClass(  )
    {
    }

    @AfterClass
    public static void tearDownClass(  )
    {
    }

    @Before
    public void setUp(  )
    {
    }

    @After
    public void tearDown(  )
    {
    }

    /**
     * Test of parse method, of class DocumentParser.
     */
    @Test
    public void testParse(  ) throws IOException, SAXException
    {
        System.out.println( "parse" );

        PackageShowResult psr = new PackageShowResult(  );
        PackageShowResult result = DocumentParser.parse( TestUtils.getFile( "document.xml" ), psr );
        System.out.println( result.getId(  ) );
        System.out.println( result.getTitle(  ) );
        System.out.println( result.getAuthor(  ) );
        System.out.println( result.getState(  ) );
        System.out.println( result.getType(  ) );
        System.out.println( result.getVersion(  ) );
    }
}
