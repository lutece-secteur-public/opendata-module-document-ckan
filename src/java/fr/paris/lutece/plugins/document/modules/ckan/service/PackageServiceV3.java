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

import fr.paris.lutece.plugins.document.business.Document;
import fr.paris.lutece.plugins.document.business.DocumentHome;
import fr.paris.lutece.plugins.document.business.portlet.DocumentPortletHome;
import fr.paris.lutece.plugins.document.modules.ckan.business.PackageShowResult;
import fr.paris.lutece.plugins.document.modules.ckan.business.WSBase;
import fr.paris.lutece.plugins.document.modules.ckan.business.WSError;
import fr.paris.lutece.plugins.document.modules.ckan.business.WSPackageList;
import fr.paris.lutece.plugins.document.modules.ckan.business.WSPackageShow;
import fr.paris.lutece.plugins.document.modules.ckan.business.WSResult;
import fr.paris.lutece.portal.service.util.AppPropertiesService;

import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;


/**
 * PackageServiceV3
 */
public final class PackageServiceV3
{
    private static final String PROPERTY_HELP_PACKAGE_LIST = "document-ckan.help.package_list";
    private static final String PROPERTY_HELP_PACKAGE_SHOW = "document-ckan.help.package_show";
    private static final String PROPERTY_DATASET_SPACE_ID = "document-ckan.datasetSpaceId";

    /** Private constructor */
    private PackageServiceV3(  )
    {
        
    }
    
    /**
     * Get the package list
     * @return The package list
     */
    public static WSBase getPackageList(  )
    {
        WSPackageList pl = new WSPackageList(  );
        pl.setHelp( AppPropertiesService.getProperty( PROPERTY_HELP_PACKAGE_LIST ) );
        pl.setSuccess( true );

        List<String> listResults = new ArrayList<String>(  );
        int nSpaceId = Integer.parseInt( AppPropertiesService.getProperty( PROPERTY_DATASET_SPACE_ID ) );

        for ( Document doc : DocumentHome.findBySpaceKey( nSpaceId ) )
        {
            listResults.add( CkanService.getNameId( doc ) );
        }

        pl.setResult( listResults );

        return pl;
    }

    /**
     * Returns the Package Show response
     * @param strId The dataset ID
     * @return The Package Show response
     * @throws SAXException If a parsing error occurs
     */
    public static WSBase getPackageShow( String strId )
        throws SAXException
    {
        String strHelp = AppPropertiesService.getProperty( PROPERTY_HELP_PACKAGE_SHOW );
        Document doc;

        try
        {
            doc = DocumentHome.findByPrimaryKey( Integer.parseInt( strId ) );
        }
        catch ( NumberFormatException e )
        {
            return new WSError( WSError.MESSAGE_INVALID, WSError.TYPE_INVALID, strHelp );
        }

        if ( doc == null )
        {
            return new WSError( WSError.MESSAGE_NOT_FOUND, WSError.TYPE_NOT_FOUND, strHelp );
        }

        PackageShowResult psr = new PackageShowResult(  );
        List<Integer> listPublications = DocumentPortletHome.findPortletForDocument( doc.getId(  ) );

        if ( listPublications.isEmpty(  ) )
        {
            // dataset is not published
            return new WSError( WSError.MESSAGE_NOT_FOUND, WSError.TYPE_NOT_FOUND, strHelp );
        }

        int nPortletId = listPublications.get( 0 );
        WSResult ps = new WSPackageShow(  );
        ps.setHelp( strHelp );
        psr = DocumentParser.parse( psr, doc.getXmlValidatedContent(  ), nPortletId );
        ps.setResult( psr );

        return ps;
    }
}
