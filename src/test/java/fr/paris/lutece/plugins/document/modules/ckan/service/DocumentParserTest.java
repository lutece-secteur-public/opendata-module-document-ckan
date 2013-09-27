/*
 * Copyright (c) 2002-2013, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.document.modules.ckan.service;

import fr.paris.lutece.plugins.document.modules.ckan.business.PackageShowResult;
import fr.paris.lutece.test.LuteceTestCase;

import org.junit.Test;

import org.xml.sax.SAXException;

import java.io.IOException;


/**
 * DocumentParserTest
 */
public class DocumentParserTest extends LuteceTestCase
{
    /**
     * Test of parse method, of class DocumentParser.
     */
    @Test
    public void testParse(  ) throws IOException, SAXException
    {
        System.out.println( "parse" );

        PackageShowResult psr = new PackageShowResult(  );
        PackageShowResult result = DocumentParser.parse( psr, TestUtils.getFile( "document.xml" ), 1 );
        System.out.println( result.getId(  ) );
        System.out.println( result.getTitle(  ) );
        System.out.println( result.getAuthor(  ) );
        System.out.println( result.getState(  ) );
        System.out.println( result.getType(  ) );
        System.out.println( result.getVersion(  ) );
    }
}
