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
import fr.paris.lutece.plugins.document.modules.ckan.business.PackageTag;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * DocumentParser
 */
public final class DocumentParser
{
    private static final String TIMESTAMP_DEFAULT = "2000-01-01T00:00:00.000000";
    private static CkanService _service = SpringContextService.getBean( "document-ckan.ckanService" );
    private static SimpleDateFormat _dateFormaterInput = new SimpleDateFormat( "dd/MM/yyyy" );
    private static SimpleDateFormat _dateFormaterOutput = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS" );

    /** Private constructor */
    private DocumentParser(  )
    {
    }

    /**
     * Parse the XML content of a document
     * @param strXml The XML
     * @param psr The PackageShowResult
     * @param nPortletId The portlet ID
     * @return the fulfilled PackageShowResult
     * @throws SAXException if an error occurs
     */
    public static PackageShowResult parse( PackageShowResult psr, String strXml, int nPortletId )
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
            psr.setAuthor_email( getValue( doc, "author-email" ) );
            psr.setState( getValue( doc, "state" ) );
            psr.setVersion( getValue( doc, "version" ) );
            psr.setMaintainer( getValue( doc, "maintainer" ) );
            psr.setNotes( getValue( doc, "notes" ) );
            psr.setType( getValue( doc, "type" ) );
            psr.setUrl( MessageFormat.format( _service.getDatasetUrlFormat(  ), strId, nPortletId ) );
            psr.setLicense_id( getValue( doc, "license-id" ) );
            psr.setLicense_title( getValue( doc, "license-title" ) );

            String strMetadataCreated = convertDateToTimestamp( getValue( doc, "metadata-created" ), TIMESTAMP_DEFAULT );
            psr.setMetadata_created( strMetadataCreated );

            String strMetadataModified = convertDateToTimestamp( getValue( doc, "metadata-modified" ),
                    strMetadataCreated );
            psr.setMetadata_modified( strMetadataModified );
            psr.setRevision_id( getValue( doc, "revision-id" ) );
            psr.setRevision_timestamp( convertDateToTimestamp( getValue( doc, "revision-timestamp" ),
                    strMetadataModified ) );
            
            psr.setGroups( getValue( doc , "groups" ));
            psr.setFrequency( getValue( doc , "frequency" ));
            psr.setTemporal_coverage_from( getValue( doc , "temporal-coverage-from" ));
            psr.setTemporal_coverage_to( getValue( doc , "temporal-coverage-to" ));
            psr.setTerritorial_coverage( getValue( doc , "territorial-coverage"));
            psr.setTerritorial_coverage_granularity( getValue( doc , "territorial-coverage-granularity"));
            
            // Organization parsing
            PackageOrganization po = new PackageOrganization(  );
            po.setId( getValue( doc, "organization-id" ) );
            po.setTitle( getValue( doc, "organization-title" ) );
            po.setName( getValue( doc, "organization-name" ) );
            po.setDescription( getValue( doc, "organization-description" ) );
            po.setType( getValue( doc, "organization-type" ) );
            po.setIs_organization( true );
            po.setApproval_status( getValue( doc, "organization-approval-status" ) );
            po.setState( getValue( doc, "organization-state" ) );
            po.setId( getValue( doc, "organization-id" ) );
            po.setRevision_id( getValue( doc, "organization-revision-id" ) );
            po.setRevision_timestamp( getValue( doc, "organization-revision-timestamp" ) );
            po.setCreated( getValue( doc, "organization-revision-timestamp" ) );
            psr.setOrganization( po );

            // Resources parsing
            List<PackageResource> listResources = new ArrayList<PackageResource>(  );

            for ( int i = 1; i < 4; i++ )
            {
                String strFormat = getValue( doc, "resource-format-" + i );

                if ( !"".equals( strFormat.trim(  ) ) )
                {
                    PackageResource pr = new PackageResource(  );
                    pr.setFormat( strFormat );
                    pr.setDescription( strTitle );
                    pr.setLast_modified( strMetadataModified );
                    pr.setRevision_id( getValue( doc, "resource-revision-id" ) );
                    fillResourceInfos( pr, doc, "resource-file-" + i, strMetadataCreated );
                    listResources.add( pr );
                }
            }

            psr.setResources( listResources );
            psr.setNum_resources( listResources.size(  ) );

            // Tags parsing
            List<PackageTag> listTags = new ArrayList<PackageTag>(  );
            String strTags = getValue( doc, "tags" );
            StringTokenizer st = new StringTokenizer( strTags );

            while ( st.hasMoreTokens(  ) )
            {
                PackageTag tag = new PackageTag(  );
                String strName = st.nextToken(  );
                tag.setName( strName );
                tag.setDisplay_name( strName );
                tag.setRevision_timestamp( strMetadataModified );
                tag.setState( getValue( doc, "tag-state" ) );
                listTags.add( tag );
            }

            psr.setTags( listTags );
            psr.setNum_tags( listTags.size(  ) );
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
     * @param strCreated Creation Timestamp
     */
    private static void fillResourceInfos( PackageResource pr, Document doc, String strKey, String strCreated )
    {
        String strDocumentTag = _service.getMapping( strKey );

        if ( !strDocumentTag.equals( CkanService.NOT_FOUND ) )
        {
            NodeList nList = doc.getElementsByTagName( strDocumentTag );

            fillResource( pr, nList, strCreated );
        }
    }

    /**
     * Recursive method to find useful tags
     * @param pr The PackageResource
     * @param nList The node list
     * @param strCreated Creation Timestamp
     */
    private static void fillResource( PackageResource pr, NodeList nList, String strCreated )
    {
        String strId = "";
        String strAttributeId = "";

        for ( int i = 0; i < nList.getLength(  ); i++ )
        {
            Node node = nList.item( i );

            NodeList childs = node.getChildNodes(  );

            if ( childs.getLength(  ) > 0 )
            {
                fillResource( pr, childs, strCreated );
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
            pr.setId( formatResourceId( strId, strAttributeId ) );
            pr.setCreated( strCreated );
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
        return ( strId + "-" + StringUtil.replaceAccent( strTitle ).replace( " ", "_" ).toLowerCase(  ) );
    }

    /**
     * Convert a date to a timestamp
     * @param strDate The input date
     * @param strDefault The default value if the conversion failed
     * @return The timestamp
     */
    private static String convertDateToTimestamp( String strDate, String strDefault )
    {
        String strTimestamp = strDefault;

        try
        {
            Date date = _dateFormaterInput.parse( strDate );
            strTimestamp = _dateFormaterOutput.format( date );
        }
        catch ( ParseException e )
        {
            AppLogService.error( "Error parsing document : " + e.getMessage(  ), e );
        }

        return strTimestamp;
    }

    /**
     * Format a resource ID
     * @param strId The dataset id
     * @param strAttributeId the resource id
     * @return The ID
     */
    private static String formatResourceId( String strId, String strAttributeId )
    {
        return strId + ":" + strAttributeId;
    }
}
