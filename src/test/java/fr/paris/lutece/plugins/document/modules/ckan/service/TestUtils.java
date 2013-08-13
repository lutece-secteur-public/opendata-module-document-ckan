/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.document.modules.ckan.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;


/**
 *
 * @author levy
 */
public final class TestUtils
{
    public static String getFile( String strFilename )
        throws IOException
    {
        URL url = Thread.currentThread(  ).getContextClassLoader(  ).getResource( strFilename );
        File file = new File( url.getPath(  ) );

        return readFile( file );
    }

    private static String readFile( File file ) throws IOException
    {
        BufferedReader reader = new BufferedReader( new FileReader( file ) );
        String strLine;
        StringBuilder sbString = new StringBuilder(  );

        while ( ( strLine = reader.readLine(  ) ) != null )
        {
            sbString.append( strLine );
        }

        return sbString.toString(  );
    }
}
