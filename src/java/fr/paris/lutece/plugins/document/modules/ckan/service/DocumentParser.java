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

import fr.paris.lutece.plugins.document.modules.ckan.business.PackageOrganization;
import fr.paris.lutece.plugins.document.modules.ckan.business.PackageResource;
import fr.paris.lutece.plugins.document.modules.ckan.business.PackageShowResult;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.util.string.StringUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import java.text.MessageFormat;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * DocumentParser
 */
public class DocumentParser
{
    private static CkanService _service = SpringContextService.getBean( "document-ckan.ckanService" );

    /**
     * Parse the XML content of a document
     * @param strXml The XML
     * @param psr The PackageShowResult
     * @return the fulfilled PackageShowResult
     * @throws SAXException if an error occurs
     */
    public static PackageShowResult parse( String strXml, PackageShowResult psr )
        throws SAXException
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(  );
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(  );
            Document doc = dBuilder.parse( new InputSource( new StringReader( strXml ) ) );

            String strId = getValue( doc, "id" );
            psr.setId( strId );

            String strTitle = getValue( doc, "title" );
            psr.setTitle( strTitle );
            psr.setName( formatName( strId, strTitle ) );
            psr.setAuthor( getValue( doc, "author" ) );
            psr.setAuthor_email( getValue( doc, "author_email" ) );
            psr.setState( getValue( doc, "state" ) );
            psr.setVersion( getValue( doc, "version" ) );
            psr.setMaintainer( getValue( doc, "maintainer" ) );
            psr.setNotes( getValue( doc, "notes" ) );
            psr.setType( getValue( doc, "type" ) );
            psr.setUrl( getValue( doc, "url" ) );

            PackageOrganization po = new PackageOrganization(  );
            po.setId( getValue( doc, "organization-id" ) );
            po.setTitle( getValue( doc, "organization-title" ) );
            po.setName( getValue( doc, "organization-name" ) );
            po.setDescription( getValue( doc, "organization-description" ) );
            po.setType( getValue( doc, "organization-type" ) );
            po.setIs_organization( true );
            po.setApproval_status( getValue( doc, "organization-approval-status" ) );
            po.setState( getValue( doc, "organization-state" ) );
            psr.setOrganization( po );

            List<PackageResource> listResources = new ArrayList<PackageResource>(  );

            for ( int i = 1; i < 4; i++ )
            {
                String strFormat = getValue( doc, "resource-format-" + i );

                if ( !"".equals( strFormat.trim(  ) ) )
                {
                    PackageResource pr = new PackageResource(  );
                    pr.setFormat( strFormat );
                    fillResourceInfos( pr, doc, "resource-file-" + i );
                    listResources.add( pr );
                }
            }

            psr.setResources( listResources );
        }
        catch ( IOException e )
        {
            AppLogService.error( "Error parsing document : " + e.getMessage(  ), e );
        }
        catch ( ParserConfigurationException e )
        {
            AppLogService.error( "Error parsing document : " + e.getMessage(  ), e );
        }

        return psr;
    }

    /**
     * Get a value for a given key
     * @param doc The document
     * @param strKey The key
     * @return The value
     */
    private static String getValue( Document doc, String strKey )
    {
        String strDocumentTag = _service.getMapping( strKey );

        if ( !strDocumentTag.equals( CkanService.NOT_FOUND ) )
        {
            NodeList nList = doc.getElementsByTagName( strDocumentTag );
            Node node = nList.item( 0 );

            if ( node != null )
            {
                return node.getTextContent(  );
            }
        }

        return _service.getDefault( strKey );
    }

    /**
     * Fill a resource by parsing tags
     * @param pr The PackageResource
     * @param doc The document
     * @param strKey The Key
     */
    private static void fillResourceInfos( PackageResource pr, Document doc, String strKey )
    {
        String strDocumentTag = _service.getMapping( strKey );

        if ( !strDocumentTag.equals( CkanService.NOT_FOUND ) )
        {
            NodeList nList = doc.getElementsByTagName( strDocumentTag );

            fillResource( pr, nList );
        }
    }

    /**
     * Recursive method to find useful tags  
     * @param pr The PackageResource
     * @param nList The node list
     */
    private static void fillResource( PackageResource pr, NodeList nList )
    {
        String strId = "";
        String strAttributeId = "";

        for ( int i = 0; i < nList.getLength(  ); i++ )
        {
            Node node = nList.item( i );

            NodeList childs = node.getChildNodes(  );

            if ( childs.getLength(  ) > 0 )
            {
                fillResource( pr, childs );
            }

            if ( node.getNodeName(  ).equals( "resource-document-id" ) )
            {
                strId = node.getTextContent(  );
            }
            else if ( node.getNodeName(  ).equals( "resource-attribute-id" ) )
            {
                strAttributeId = node.getTextContent(  );
            }
            else if ( node.getNodeName(  ).equals( "resource-content-type" ) )
            {
                pr.setMimetype( node.getTextContent(  ) );
            }
            else if ( node.getNodeName(  ).equals( "file-size" ) )
            {
                pr.setSize( node.getTextContent(  ) );
            }
        }

        if ( ( !"".equals( strId ) ) && ( !"".equals( strAttributeId ) ) )
        {
            pr.setUrl( MessageFormat.format( _service.getResourceUrlFormat(  ), strId, strAttributeId ) );
            pr.setResource_type( "file" );
        }
    }

    /**
     * Format the field name
     * @param strId The doc ID
     * @param strTitle The doc title
     * @return The Name
     */
    private static String formatName( String strId, String strTitle )
    {
        return ( strId + "-" + StringUtil.replaceAccent( strTitle ).replace( " ", "_" ).toLowerCase(  ));
    }
}
