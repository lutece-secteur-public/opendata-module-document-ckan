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
package fr.paris.lutece.plugins.document.modules.ckan.rs;

import fr.paris.lutece.plugins.document.business.Document;
import fr.paris.lutece.plugins.document.business.DocumentHome;
import fr.paris.lutece.plugins.document.modules.ckan.business.PackageList;
import fr.paris.lutece.plugins.document.modules.ckan.business.PackageShow;
import fr.paris.lutece.plugins.document.modules.ckan.business.PackageShowResult;
import fr.paris.lutece.plugins.document.modules.ckan.service.CkanService;
import fr.paris.lutece.plugins.document.modules.ckan.service.DocumentParser;
import fr.paris.lutece.plugins.document.modules.ckan.service.MapperService;
import fr.paris.lutece.plugins.rest.service.RestConstants;
import fr.paris.lutece.portal.service.util.AppPropertiesService;

import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * Ckan Web services API implementation 
 */
@Path( RestConstants.BASE_PATH + Constants.PATH_CKAN_API )
public class CkanRest
{
    private static final String PROPERTY_HELP_PACKAGE_LIST = "document.ckan.help.package_list";
    private static final String PROPERTY_HELP_PACKAGE_SHOW = "document.ckan.help.package_show";
    
    
    /**
     * Get document spaces by id user
     *
     * @param strIdUser the id user
     * @return the xml of spaces
     */
    @GET
    @Path( Constants.PATH_GET_PACKAGE_LIST )
    @Produces( MediaType.APPLICATION_JSON )
    public String getPackageList(  )
    {
        PackageList pl = new PackageList(  );
        pl.setHelp( AppPropertiesService.getProperty( PROPERTY_HELP_PACKAGE_LIST ) );
        pl.setSuccess( true );

        List<String> listResults = new ArrayList<String>(  );

        for ( Document doc : DocumentHome.findBySpaceKey( 22 ) )
        {
            listResults.add( CkanService.getNameId(doc) );
        }

        pl.setResult( listResults );

        return MapperService.getJson( pl );
    }

    @GET
    @Path( Constants.PATH_GET_PACKAGE_SHOW )
    @Produces( MediaType.APPLICATION_JSON )
    public String getPackageShow( @QueryParam( Constants.PARAMETER_ID )
    String strIdPackage ) throws SAXException
    {
        String strId = strIdPackage;
        int nPos = strIdPackage.indexOf( "-" );

        if ( nPos > 0 )
        {
            strId = strIdPackage.substring( 0, nPos );
        }

        Document doc = DocumentHome.findByPrimaryKey( Integer.parseInt( strId ) );

        PackageShowResult psr = new PackageShowResult(  );
        psr = DocumentParser.parse( doc.getXmlValidatedContent(  ), psr );

        PackageShow ps = new PackageShow(  );
        ps.setHelp( AppPropertiesService.getProperty( PROPERTY_HELP_PACKAGE_SHOW ));
        ps.setSuccess( true );
        ps.setResult( psr );

        return MapperService.getJson( ps );
    }

}
